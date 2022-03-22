<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=938630b29a8b84390fba8518da467e06"></script>

	<script type="text/javascript">
	
	$(function() {

		var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
		var mapOption = {
			center : new kakao.maps.LatLng(37.566609, 126.978272), // 지도의 중심좌표
			level : 3 // 지도의 확대 레벨
		};

		// div에 지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
		var position = new kakao.maps.LatLng(35.93501119925401, 128.56210315279392);
		
		$("#search").keyup(function(e) {
			if(e.keyCode == 13){ 
			let search = $(this).val(),
			exp = /헬스/;
		
			if(exp.test(search)){
				confirm("지역, 업체명으로만 검색하시면 보다 정확한 결과를 얻을 수 있습니다.\n정말로 이대로 검색하시겠습니까??");
				$("#search").val('');
			}
//			37.570073934698264
			$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/keyword.json",
				data : {query : search + "헬스클럽", x:35.93501119925401, y:128.56210315279392, radius:5000},
				beforeSend : function(req) {
					req.setRequestHeader("Authorization", "KakaoAK 4f7470daace7b93bb66a9fcffbb5d9c9");
				},
				success : function(result) {
					$("#search").val('');
					console.log(result);
					console.log(JSON.stringify(result));
					let newY = 0;
					let newX = 0;
					newY = result.documents[0].y;
					newX = result.documents[0].x;
					
					$.each(result.documents, function(i, l) {
						console.log(l.place_name);
						console.log(l.category_name);
						
						var markerImage = new daum.maps.MarkerImage(
							    'resources/img/infoMap/pi.svg', new daum.maps.Size(40, 40));
						
					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						map : map,
						// 마커 표시 위치 
					    position: new kakao.maps.LatLng(l.y, l.x),
					    image: markerImage
					});
					
						marker.setMap(map);  
					
						// 마커에 클릭이벤트를 등록합니다
						kakao.maps.event.addListener(marker, 'click', function() {
					      // 마커 위에 인포윈도우를 표시합니다
					      infowindow.open(map, marker);  
					      $('#markerInfo').text(l.place_name);
					});
					
					}); // $each
					
					
					// 지도 이동
					 // 이동할 위도 경도 위치를 생성합니다 
				    var moveLatLon = new kakao.maps.LatLng(newY, newX);
					
					    // 지도 중심을 부드럽게 이동시킵니다
					    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
					map.panTo(moveLatLon);            
				    
					
					var iwContent = '<div id="markerInfo" style="padding:5px;">Hello World!</div>',
					// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
				    
					// 인포윈도우를 생성하고 지도에 표시합니다
					var infowindow = new kakao.maps.InfoWindow({
					    content : iwContent,
					    removable : iwRemoveable
					});
				    
				    
				} //success
				
			}); //ajax
			
			} //if
			
		});	//$('#search')
		 
	}); // ready
	</script>

</head>
<body>

<img hidden="" src="resources/img/infoMap/pi.svg">

	<div class="input-group mb-3 container" style="height:50px; margin-top: 100px;">
		<input id="search" class="form-control" placeholder="지역, 업체명만 검색해주세요.."
			aria-label="search fitnessClub" aria-describedby="button-addon2">
		<button id="searchBtn" class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
	</div>

	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width: 100%; height: 750px; border-style: double; border-radius: 8px; " class="container"></div>
	
</body>
</html>