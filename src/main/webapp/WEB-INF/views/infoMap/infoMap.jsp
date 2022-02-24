<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="input-group mb-3 container" style="margin-top: 100px;">
		<input type="text" class="form-control" placeholder="헬스장 검색..."
			aria-label="search fitnessClub" aria-describedby="button-addon2">
		<button class="btn btn-outline-secondary" type="button"
			id="button-addon2">검색</button>
	</div>

	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width: 100%; height: 750px; border-style: double; border-radius: 8px; " class="container"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=938630b29a8b84390fba8518da467e06"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566609, 126.978272), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
	</script>

</body>
</html>