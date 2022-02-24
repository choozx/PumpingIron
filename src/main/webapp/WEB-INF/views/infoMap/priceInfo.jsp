<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="input-group mb-3 container" style="margin-top: 100px;">
		<select class="form-select" >
 		 <option value="all"> 전체 포함 </option>
  		 <option value="name"> 업체명 </option>
 		 <option value="area"> 위치 </option>
		</select>
		
		<input type="text" class="form-control" placeholder="헬스장 검색..." style="width:75%"
			 aria-label="search fitnessClub" aria-describedby="button-addon2">
		<button class="btn btn-outline-secondary" type="button"
			id="button-addon2">검색</button>
	</div>

		<c:forEach begin="1" end="3">
	
	<div class="centerInfo container bg-light bg-gradient" style="width: 100%; border: 1px solid;">
	
		<div class="row">

			<div class="centerInfo_fhoto ratio ratio-1x1"
				style=" width: 450px;">
					<div class="row row-cols-2">
						<div class="col ms-2 ratio ratio-1x1" style="width: 200px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (1).jpg">
						</div>
						<div class="col ratio ratio-1x1" style="width: 200px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (2).jpg">
						</div>
						<div class="col ms-2 ratio ratio-1x1" style="width: 200px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (3).jpg">
						</div>
						<div class="col ratio ratio-1x1" style="width: 200px; border: 1px solid;">
						<img class="img-fluid" src="resources/img/infoMap/샘플 사진 홍키통키 (4).jpg">
						</div>
					</div>
			</div>

			<div class="centerInfo_info mt-1 mb-1 p-3 col "
				style=" font-size: 14pt;">
				<!-- 가데이터 -->
				
				<b class="partnership_center">▷ PUMPING IRON과 파트너십 업체 ◁</b> <br><br>
				
				▷업체명<br>
				 홍키통키 휘트니스 <p>
				 
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


</body>
</html>