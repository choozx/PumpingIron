<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

$(function() {


	$("#search").keyup(function(e) {
		if (e.keyCode == 13) {
			$('#searchBtn').trigger('click');
		}
	});
		
	
	$('#searchBtn').bind("click", function() {	
		
	}); // #searchBtn click
	
	$('#addInfo').click(function() {
		
		$('#infoReg').modal("show");
		
/* 			var name = document.getElementById('info_name').value;
			var loca = document.getElementById('info_location').value;
			var price = document.getElementById('info_price').value;
			var partner = document.getElementById('info_partner').value;
			var img = document.getElementById('info_image').value;
		
		$('#addBtn').click(function() {
			
			 if(name == null){
                 alert("업체명 공백");
                 return false;
			 }else if(loca == null){
                 alert("위치정보 공백");
                 return false;
			 }else if(partner == null){
                 alert("제휴 여부 공백");
                 return false;
			 }else if(img == null){
                 alert("제휴 여부 공백");
                 return false;
             }else{ // 정상적인 입력 시
            	 
     			console.log(name);
     			console.log(loca);
     			console.log(price);
     			console.log(partner);
     			console.log(img);
            	  
                   $.ajax({
         			url : "priceInfo.reg",
         			data : {"pi_name" : name,"pi_loc" : loca, "pi_price" : price, "pi_partner" : partner, "pi_img" : img},
         			type : "POST",
         			success : function(data) {
         				console.log(data);
         				$('#info_name').val('');
         				$('#info_location').val('');
         				$('#info_price').val('');
         				$('#info_partner').val('');
         				$('#info_img').val('');
         				$('#calendarModal').click();
         				alert('업체 정보를 추가했습니다.');
         				location.reload(); 
         				} //success
         		}); //ajax 
         		
             } */ // else 
			
			
		}); // #addBtn click
		
		
		$('#modalClose').click(function() {
			$('#infoReg').click();
		});
		
	var enter = document.querySelector('textarea');
	enter = enter.value.replace(/(\n|\r\n)/g ,'<br>');
	
}); // ready


</script>


<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>


	
	<div class="input-group mb-3 container" style="margin-top: 100px;">
	
		<input name="pi_name" type="text" class="form-control" placeholder="헬스장 검색..." style="width:75%"
			 aria-label="search fitnessClub" aria-describedby="button-addon2" id="search">
		<button class="btn btn-outline-secondary" type="button" style="width: 100px;"
			id="searchBtn">검색</button>
			
			<c:if test="${sessionScope.loginMember.m_email == 'admin'}">
		<button class="btn btn-outline-secondary" style="width: 100px;" id="addInfo">정보 등록</button>
			</c:if>
		
	</div>

		<c:forEach begin="1" end="3">
	
	<div class="centerInfo container bg-light bg-gradient" style="width: 100%; border: 1px solid;">
	
		<div class="row">

			<div class="centerInfo_fhoto ratio ratio-1x1"
				style=" width: 450px;">
					<div class="row row-cols-2">
						<div class="col ms-2 ratio ratio-1x1" style="width: 220px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (1).jpg">
						</div>
						<div class="col ratio ratio-1x1" style="width: 220px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (2).jpg">
						</div>
						<div class="col ms-2 ratio ratio-1x1" style="width: 220px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (3).jpg">
						</div>
						<div class="col ratio ratio-1x1" style="width: 220px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (4).jpg">
						</div>
					</div>
			</div>

			<div class="centerInfo_info mt-1 mb-1 p-3 col "
				style=" font-size: 14pt;">
				<!-- 가데이터 -->
				
				<b class="partnership_center">▷ with PUMPING IRON◁</b> <br><br>
				
				▷업체명<br>
				 홍키통키 휘트니스 <p><br>
				 
				▷위   치<br>
				 경기 동두천시 중앙로 125 영스포츠타운 4층. <br>
				(서울 지하철 1호선 지행역 1번 출구에서 379m) <p>
				
				▷가격 정보<br>
				 1일권 : 11,000원<br>
				<span style="text-decoration: overline;">1개월 : 88,000원</span>(정상가)<br>
				3개월 : 176,000원(1개월 무료)<br>
				5개월 : 264,000원(2개월 무료+라카S서비스(6월10일까지))<br>
				12개월 : 528,000원(6개월 무료+운동복 서비스(6월10일까지))
				</div>




		</div>
		
		</div>
		
		<p>
		
		</c:forEach>
		
		
		<form action="priceInfo.reg" method="post" enctype="multipart/form-data">
		<!--  Reg Modal -->>
		<input type="hidden" name="token" value="${token }">
		<div class="modal fade" id="infoReg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header"> 
                    <h5 class="modal-title" id="exampleModalLabel">헬스장 정보 등록</h5>
                    <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button> -->
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">업체명</label>
                        <input class="form-control" id="info_name" name="pi_name" required="required">
                        <label for="taskId" class="col-form-label">위치 정보</label>
                        <textarea class="form-control" id="info_location" name="pi_loc" placeholder="지도에서 복사해서 붙여넣기" required="required"></textarea>
                        <label for="taskId" class="col-form-label">가격 정보</label>

                        <textarea class="form-control" id="info_price" name="pi_price" style="height: 150px;">
1일권 : 
1개월 : 
3개월 : 
5개월 : 
12개월 : </textarea>
                        <label for="taskId" class="col-form-label">제휴 여부</label>
                         <input type="radio" id="info_partner" name="pi_partner" value="Y"/>  Yes
                         <input type="radio" id="info_partner" name="pi_partner" value="N">  No <br>
                        <label for="taskId" class="col-form-label">업체 제공 사진</label>
                        <input type="file" name="pi_img" id="info_image" required="required">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" id="addBtn">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        id="modalClose" onclick="">취소</button>
                </div>
    
            </div>
        </div>
    </div>
		</form>
		
		

</body>
</html>