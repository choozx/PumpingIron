<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.event_td1{
	width: 10%;
	display:inline-block;
	 text-overflow: ellipsis; 
	 overflow: hidden;
	 white-space: nowrap;
}
.event_td2{
	width: 15%;
	display:inline-block;
	 text-overflow: ellipsis; 
	 overflow: hidden;
	 white-space: nowrap;
}
.event_td3{
	width: 25%;
	display:inline-block;
	 text-overflow: ellipsis; 
	 overflow: hidden;
	 white-space: nowrap;
}
.event_td4{
	width: 330px;
	display:inline-block;
	 text-overflow: ellipsis; 
	 overflow: hidden;
	 white-space: nowrap;
	

}
</style>
<script type="text/javascript">
 $(function() {
   $(".event_tr").hide();
   $(".event_tr").slice(0,3).show();
   
	  
})
</script>
</head>
<body>

<!-- 슬라이드  -->
	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel" style="z-index: 0;">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" >
				<a href="#"><img style="height: 1000px;"
				src="https://t1.daumcdn.net/cfile/tistory/99C941375C870FD50E"
					class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
			<div class="carousel-item" >
				<a href="schedule.go"><img style="height: 1000px;"
					src="resources/img/index/slide_02.png"
					class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
			<div class="carousel-item">
				<a href="products.go?products=supplements"><img style="height: 1000px;"
				src="resources/img/index/slide_03.png" class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	
	

<!-- SHOP -->
	<div class="main container">
		<div class="row mt-5 mb-5">
				<div class="col-sm-6 col-lg-3">
					<div class="card flex-center">
						<div class="card-body">
							<h5 class="card-text text-center"><a href="customerservice.request.go">Pumping Iron에 바란다</a></h5>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-3">
					<div class="card flex-center">
						<div class="card-body">
							<h5 class="card-text text-center"><a href="customerservice.go">고객센터</a></h5>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-3">
					<div class="card flex-center">
						<div class="card-body">
							<h5 class="card-text text-center"><a href="customerservice.event.go">공지사항&이벤트</a></h5>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-3">
					<div class="card flex-center">
						<div class="card-body">
							<h5 class="card-text text-center"><a href="customerservice.associate.go">제휴문의</a></h5>
						</div>
					</div>
				</div>
			</div>
		<header class="header-card pb-3 mt-5">
			<h1>SHOP</h1>
		</header>
		<div class="mb-5">
			<div class="row">
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center">
						<a href="products.go?p_type=supplements">
						<img src="resources/img/index/card_protein.jpg"
							class="card-img-top" alt="보충제">
						<div class="card-body">
							<h5 class="card-text text-center">보충제</h5>
						</div>
						</a>
					</div>
				</div>
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center">
						<a href="products.go?p_type=gripStrap">
						<img src="resources/img/index/card_strap.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-text text-center">그립/스트랩</h5>
						</div>
						</a>
					</div>
				</div>
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center">
						<a href="products.go?p_type=elbowProtecter">
						<img src="resources/img/index/card_elbowguard.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-text text-center">팔꿈치 보호대</h5>
						</div>
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="mb-5">
			<div class="row">
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center">
						<a href="products.go?p_type=backWaist">
						<img src="resources/img/index/card_belt.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-text text-center">등/허리</h5>
						</div>
						</a>
					</div>
				</div>
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center">
						<a href="products.go?p_type=kneeProtecter">
						<img src="resources/img/index/card_kneeguard.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-text text-center">무릎 보호대</h5>
						</div>
						</a>
					</div>
				</div>
				<div class="col-sm-12 col-lg-4">
					<div class="card flex-center" onclick="location.href='products.go?products=shoes'" style="cursor: pointer;">
						<a href="products.go?p_type=shoes">
						<img src="resources/img/index/card_shoues.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-text text-center">신발</h5>
						</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		
<!-- 게시판(커뮤니티)  -->		
		<div class="mb-5 mt-5">
			<div class="row">
				<div class="col-sm-12 col-lg-6 ">
					<header class="header-board pb-3 mt-5">
						<h3  style="font-weight: 900;">커뮤니티
						<span class="ms-3" style="color:rgba(7, 29, 61, 0.7); font-size: 20px;">정보 공유, 파트너 모집</span></h3>
						<div>
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
  						<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
						</svg>
						</div>
					</header>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td colspan="2">Larry the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-sm-12 col-lg-6">
					<header class="header-board pb-3 mt-5">
						<h3  style="font-weight: 900;">커뮤니티
						<span class="ms-3" style="color:rgba(7, 29, 61, 0.7); font-size: 20px;">상품 후기</span></h3>
						<div>
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
  						<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
						</svg>
						</div>
					</header>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td colspan="2">Larry the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="mb-5 mt-5">
			<div class="row">
				<div class="col-sm-12 col-lg-6">
					<header class="header-board pb-3 mt-5">
						<h3  style="font-weight: 900;">공지사항&이벤트
						<span class="ms-3" style="color:rgba(7, 29, 61, 0.7); font-size: 20px;"></span></h3>
						<div>
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16" onclick="location.href='customerservice.event.go'" style="cursor: pointer;">
  						<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
						</svg>
						</div>
					</header>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col" width="10%;" class="event_td1">번호</th>
								<th scope="col" width="15%;" class="event_td2">구분</th>
								<th scope="col" width="25%" class="event_td3">날짜</th>
								<th scope="col" width="50%;" class="event_td4" style="max-width: 50%;">제목</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${events}" var="e">
							<tr class="event_tr" id="event_tr" onclick="location.href='customerservice.event.go'" style="cursor: pointer; width: 100%;" >
								<th scope="row"  class="event_td1" style="max-width: 10%;">${e.e_no}</th>
								<td  class="event_td2" style="max-width: 15%;">${e.e_type }</td>
								<td  class="event_td3" style="max-width: 25%;"><fmt:formatDate value="${e.e_date}" type="date" pattern="yyyy.MM.dd"/></td>
								<td  class="event_td4" style="max-width: 50%;">${e.e_title}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table> 
				</div>
				<div class="col-sm-12 col-lg-6">
					<header class="header-board pb-3 mt-5">
						<h3  style="font-weight: 900;">캘린더
						<span class="ms-3" style="color:rgba(7, 29, 61, 0.7); font-size: 20px;">대회 일정, 운동 루틴</span></h3>
						<div>
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
  						<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
						</svg>
						</div>
					</header>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td colspan="2">Larry the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		
		
		
		<!--메인 컨테이너  -->
	</div>
	</div>
</body>
</html>