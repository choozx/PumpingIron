<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html lang='en'>
<head>
<meta charset="UTF-8">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
 <link href='resources/css/calendar/main.css' rel='stylesheet' />
<script type="text/javascript" src='resources/js/calendar/main.js'></script> 
<script type="text/javascript" src='resources/js/calendar/locales-all.js'></script>
	
	
<script type="text/javascript">

      $(function() {
    	var checkingL = document.getElementById('login_check').value;
//    	console.log(checkingL);

        var calendarEl = document.getElementById('calendar');
        
        var calendar = new FullCalendar.Calendar(calendarEl, {
          timeZone: 'local',
          initialView: 'dayGridMonth',
          selectable: true,
          customButtons: {
        		  addEvent: { // 추가한 버튼 설정
                      text : "대회 일정 추가",  // 버튼 내용
                      click : function(){ // 버튼 클릭 시 이벤트 추가
                    	  
                    	  if (checkingL != 'admin') {
							alert('관리자 전용 기능입니다.');
							return false;
						}
                    	  
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
                                  
                                  /* location.href = 'schedule.reg?cc_text=' + content + '&cc_startDate=' + start_date + '&cc_endDate=' + end_date; */
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
                          				getContestSchedule();
                          				},
                         				error : function(request,status,error){
                        			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                          				}
                          		});
                              }
                              
                          });
                          
                        $('#sprintSettingModalClose').on("click", function() {
						$('#calendarModal').click();
						});
                          
                      }
                  }
              },
              
              editable: false, // false로 변경 시 draggable 작동 x 
              displayEventTime: false // 시간 표시 x

        });
        calendar.render();

        calendar.on('dateClick', function(info) {
      	 console.log('clicked on ' + info.dateStr);
      	//alert('Clicked on: ' + info.dateStr);
      	});
        
      });
      
      
      
      function getContestSchedule() {
    	  
    	  var content = $("#calendar_content").val();
          var start_date = $("#calendar_start_date").val();
          var end_date = $("#calendar_end_date").val();
    	  
    	  $.ajax({
				url : "routine.getData",
				data : {"cc_text" : content,"cc_startDate" : start_date, "cc_endDate" : end_date},
				dataType : "json",
				type : "GET",
				success : function(data) {
					// $("#routineDIV").empty();
					console.log(data);
					$.each(data, function(i,c) {
						console.log(c.cc_text);
//						$("#routineDIV").append("<h6 style='color: white;' value='"+ c.cr_no + "'> - " + c.cr_text + '<span class="delRoutine" style="color: white;"> x </span></h6>');
						console.log('--------');
					});
	}
					});
	}
      
      
      
    </script>
    

<title>Insert title here</title>
</head>
<body>

	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	
	<c:forEach items="${contest}" var="con">
	<input id="toConsole_text" type="hidden" value="${con.cc_text}">
	<input id="toConsole_sDate" type="hidden" value="${con.cc_startDate}">
	<input id="toConsole_eDate" type="hidden" value="${con.cc_endDate}">
	</c:forEach>
	


	<!-- Calendar div -->
	  <div id="calendarBox">
        <div id="calendar" class="container"></div>
    </div>



 <!-- modal 추가 -->
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
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="calendar_content" name="cc_text">
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

</body>
</html>