<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">


<!-- fullcalendar -->
<link href='resources/css/calendar/main.css' rel='stylesheet' />
<script type="text/javascript" src='resources/js/calendar/main.js'></script> 
<script type="text/javascript" src='resources/js/calendar/locales/ko.js'></script>
	
	
<script type="text/javascript">

$(function() {
    	var checkingL = document.getElementById('login_check').value;
//    	console.log(checkingL);

        var calendarEl = document.getElementById('calendar');
        var calendar;
        
        if (checkingL == 'admin') {
        // 로그인 id가 admin일 때 /////////////////
        
        calendar = new FullCalendar.Calendar(calendarEl, {
          timeZone: 'local',
          initialView: 'dayGridMonth',
          selectable: true,
          headerToolbar: {
              start: 'dayGridMonth listMonth addEventButton',
              center: 'title',
              end: 'today prevYear,prev,next,nextYear',
          },
          customButtons: {
        	  addEventButton: { // 추가한 버튼 설정
                      text : "대회 일정 추가",  // 버튼 내용
                      click : function(){ // 버튼 클릭 시 이벤트 추가
                    	  
                          $("#calendarModal").modal("show"); // modal 나타내기
                          
                          $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
                              var content = $("#calendar_content").val();
                              var start_date = $("#calendar_start_date").val();
                              var end_date = $("#calendar_end_date").val();
                              
                              // emptyCheck
                              if(content == null || content == ""){
                                  alert("내용을 입력하세요.");
                                  return false;
                              }else if(start_date == "" || end_date ==""){
                                  alert("날짜를 입력하세요.");
                                  return false;
                              }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
                                  alert("종료일이 시작일보다 먼저입니다.");
                                  return false;
                              }else{ // 정상적인 입력 시
                                  var obj = {
                                      "title" : content,
                                      "start" : start_date,
                                      "end" : end_date
                                  }//전송할 객체 생성
                                  
                                  console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                                  
                                  $.ajax({
                          			url : "schedule.reg",
                          			data : {"cc_text" : content,"cc_startDate" : start_date, "cc_endDate" : end_date},
                          			type : "GET",
                          			success : function(data) {
                          				console.log(data);
                          				$('#calendar_content').val('');
                          				$('#calendar_start_date').val('');
                          				$('#calendar_end_date').val('');
                          				$('#calendarModal').click();
                          				alert('일정을 추가했습니다.');
                          				location.reload();
                          				} //success
                          		}); //ajax
                              } // else
                              
                          }); // on.click
                          
                        $('#sprintSettingModalClose').on("click", function() {
						$('#calendarModal').click();
						});
                          
                      } // click
                  } //addEventButton
              }, //customButtons
              
          
               events: [ //DB에서 event 불러오기
				$.ajax({
					type: "GET",
					url: "schedule.getData",
					data: {},
					success: function(response) {
//						console.log(response);
						for (var i = 0; i < response.length; i++) {
							calendar.addEvent({
								id: response[i] ['cc_no'],
								title: response[i] ['cc_text'],
								start: response[i] ['cc_startDate'],
								end: response[i] ['cc_endDate']
							}) // .addEvent
						} // for
					} //success
				})  // ajax          	  
              ], // events
              
               eventClick: function(info) { // 관리자일 경우 => 클릭시 삭제
            	let numSchedule = info.event.id;
               
				if (confirm(info.event.title + ' - 해당 일정을 삭제하시겠습니까?')) {
					$.ajax({
						type: "GET",
						url: "schedule.del",
						data: {	'cc_no' : numSchedule },
						success : function () {
							location.reload();
						} // success
					}); // ajax
				} else {
					return false;
				}
			}, // eventClick
              
              editable: false, // false로 변경 시 draggable 작동 x 
              displayEventTime: false // 시간 표시 x

        }); // calendar 선언
        
        }  else {
        // 로그인 id가 admin이 아닐 때 /////////////////
        	
        calendar = new FullCalendar.Calendar(calendarEl, {
          timeZone: 'local',
          initialView: 'dayGridMonth',
          selectable: true,
          headerToolbar: {
              start: 'dayGridMonth listMonth',
              center: 'title',
              end: 'today prevYear,prev,next,nextYear',
          },
               events: [ //DB에서 event 불러오기
				$.ajax({
					type: "GET",
					url: "schedule.getData",
					data: {},
					success: function(response) {
//						console.log(response);
						for (var i = 0; i < response.length; i++) {
							calendar.addEvent({
								id: response[i] ['cc_no'],
								title: response[i] ['cc_text'],
								start: response[i] ['cc_startDate'],
								end: response[i] ['cc_endDate']
							})
						}
					}
				})            	  
              ],
              
              eventClick: function(info) { // 관리자가 아닐 경우 => 클릭시 상세 페이지
              	 let numSchedule = info.event.id;
             	 console.log(numSchedule);
             	 
             	$('#numFromJS').val(numSchedule);
             	
             	location.href = "schedule.getDetail?ccd_no=" + numSchedule;
                 
              /* 	$.ajax({
					type: "GET",
					url: "schedule.getDetail",
					data: {'ccd_no' : numSchedule},
					success: function(data) {
						console.log(data)
						$("#detailModal").modal("show"); // modal 나타내기
					}
				})       */ 
				
              	$('#doModalClose').on("click", function() {
						$('#detailModal').click();
				});
              	
  			},
              
              editable: false, // false로 변경 시 draggable 작동 x 
              displayEventTime: false // 시간 표시 x

        });
        }
        calendar.render();

        calendar.on('dateClick', function(info) {
      	 console.log('clicked on ' + info.dateStr);
      	//alert('Clicked on: ' + info.dateStr);
      	});
        
        
        
});    


    </script>
    

<title>Insert title here</title>
</head>
<body>

	<div class="container" style="font-size: 9pt;">* 일정을 클릭하시면 상세 정보를 볼 수 있습니다. </div>
	
	<br>

	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	

	<!-- Calendar div -->
        <div id="calendar" class="container"></div>



 <!-- 일정 등록 modal -->
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header"> 
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                    <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button> -->
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">일정  내용</label>
                        <input class="form-control" id="calendar_content" name="cc_text" >
                        <label for="taskId" class="col-form-label">시작 날짜</label>
                        <input type="date" class="form-control" id="calendar_start_date" name="cc_startDate">
                        <label for="taskId" class="col-form-label">종료 날짜</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="cc_endDate">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" id="addCalendar">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        id="sprintSettingModalClose" onclick="">취소</button>
                </div>
    
            </div>
        </div>
    </div>



	<input name="ccd_no" id="numFromJS" type="hidden" value="">

</body>
</html>