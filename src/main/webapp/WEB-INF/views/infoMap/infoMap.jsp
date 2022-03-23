<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			if (e.keyCode == 13) {
				$('#searchBtn').trigger('click');
			}
		});
			
		
		$('#searchBtn').bind("click", function() {	
			
			let search = $("#search").val(),
			exp = /헬스/;
		
			if(exp.test(search)){
				if (confirm("지역, 업체명으로만 검색하시면 보다 정확한 결과를 얻을 수 있습니다.\n정말로 이대로 검색하시겠습니까??")) {
				$("#search").val('');
				} else {
					return false;
				}
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
					
					if (result.documents.length == 0) {
						alert('검색 결과가 없습니다.');
						return false;
					} else {
						
					let newY = 0;
					let newX = 0;
					newY = result.documents[0].y;
					newX = result.documents[0].x;
					
					$.each(result.documents, function(i, l) {
						let namePlace = l.place_name;
						let address = l.address_name
						let roadAdress = l.road_address_name;
						let detail = l.place_url;
						console.log(namePlace);
						console.log(roadAdress);
						
					var markerImage = new daum.maps.MarkerImage(
							    'resources/img/infoMap/marker2.png', new daum.maps.Size(40, 50));
						
					// 마커 세팅
					var marker = new kakao.maps.Marker({
						map : map,
						// 마커 표시 위치 
					    position: new kakao.maps.LatLng(l.y, l.x),
					    // 마커 이미지
					    image: markerImage,
					    // 마커 클릭 가능
					    clickable: true
					});
						// 마커 생성
						marker.setMap(map);  
						
						
						
						// 마커에 클릭이벤트를 등록합니다
						kakao.maps.event.addListener(marker, 'click', function() {
							
							
							// 클릭할 때마다 윈도우를 비우고 새롭게 append
							  $('#infoTitle').empty();
							  $('#infoAdress_road').empty();
							  $('#infoAdress').empty();
							  
							$('img[alt=close]').click();
							
							// infowindow 열기
						      infowindow.open(map, marker); 
						      
						      // infowindow에 추가할 내용 
						      $('#infoTitle').append(namePlace);
						      $('#infoAdress_road').append(roadAdress);
						      $('#infoAdress').append('(지번)' + address);
							
						});
						
						$('img[alt=close]').click(function() {
							  $('#infoTitle').empty();
							  $('#infoAdress_road').empty();
							  $('#infoAdress').empty();
						});
						
						
					// 커스텀 오버레이에 표시할 컨텐츠
					var content = '<div class="wrap" style="border-radius: 1px; width:250px; height:100px;">' +
					 	'    <div class="info row" style="width:100%; height:100%;">' + 
			            '        <div id="infoTitle" class="title" style="background-color: black; color:white; font-size:14pt;"></div>' + 
			            '        <div class="body row" style="width:100%; height:100%;">' + 
			            '            <div class="desc">' + 
			            '                <div id="infoAdress_road" class="ellipsis"></div>' + 
			            '                <div id="infoAdress" style="font-size:9pt; color:silver;" class="jibun ellipsis"></div>' + 
			            '                <div style="font-size:9pt; color:gary;"><a href="' + detail + '" target="_blank" class="link">길찾기</a> | <a href="/pi/priceInfo.go" target="_blank" class="link">가격 정보</a></div>' + 
			            '            </div>' + 
			            '        </div>' + 
			            '    </div>' +    
			            '</div>';
			            
						// 인포윈도우를 생성하고 지도에 표시합니다
						var infowindow = new kakao.maps.InfoWindow({
						    content : content,
						    removable : true
						});
			            
					}); // $each
					
					
					// 지도 이동
					 // 이동할 위도 경도 위치를 생성합니다 
				    var moveLatLon = new kakao.maps.LatLng(newY, newX);
					
					    // 지도 중심을 부드럽게 이동시킵니다
					    // 만약 이동할 거리가 지도 화면보다 크면 효과 없이 이동합니다
						map.panTo(moveLatLon);    
					    
					} // if / else
						
				} //success
				
			}); //ajax
			
		});	//$('#search')
		 
	}); // ready
	</script>

</head>
<body>

	<div class="input-group mb-3 container" style="height:50px; margin-top: 50px;">
		<input id="search" class="form-control" placeholder="지역, 업체명만 검색해주세요.."
			aria-label="search fitnessClub" aria-describedby="button-addon2">
		<button id="searchBtn" class="btn btn-outline-secondary" type="button">검색</button>
	</div>


	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" class="container" style="width: 100%; height: 750px; margin-top: 40px; border-style: double; border-radius: 8px; "></div>
	
</body>
</html>