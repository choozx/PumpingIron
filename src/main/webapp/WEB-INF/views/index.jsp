<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pumping Iron</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="resources/css/index.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/f44a228655.js"
	crossorigin="anonymous"></script>
</head>
<body>

<div class="header">
	<div class="container header-nav">
		<div class="nav-logo">
			<a href="/pi"><img
				src="https://w.namu.la/s/8c5bc8129cf1dc5011dc8dad2e505c568e6be2c6c0bb9e9b6e9374df725639ffa359c16b9546536fe381f7982379d980b90fc1b2b3ff3bbe5d0c05377bdda69039472251a5b54f1a39d388a657f38149"
				style="width: 70px;"></a>
		</div>
		<div class="nav">
			<li class="nav-item dropdown flex"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="color: black;">SHOP</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">보충제</a></li>
					<li><a class="dropdown-item" href="#">그립/스트랩</a></li>
					<li><a class="dropdown-item" href="#">팔꿈치 보호대</a></li>
					<li><a class="dropdown-item" href="#">등/허리</a></li>
					<li><a class="dropdown-item" href="#">무릎 보호대</a></li>
					<li><a class="dropdown-item" href="#">신발</a></li>
				</ul>  <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
				href="infoMap.go" role="button" aria-expanded="false" style="color: black;">헬스장 정보</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="infoMap.go">헬스장 정보 검색</a></li>
					<li><a class="dropdown-item" href="#">가격 정보 모아보기</a></li>
				</ul>  <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
				href="#" role="button" aria-expanded="false" style="color: black;">커뮤니티</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="tips.go">운동팁/Q&A</a></li>
					<li><a class="dropdown-item" href="#">쇼핑후기</a></li>
					<li><a class="dropdown-item" href="#">바디프로필</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="#">Exercises(영상)</a></li>
				</ul> <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
				href="#" role="button" aria-expanded="false" style="color: black;">대회/운동 루틴</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Action</a></li>
					<li><a class="dropdown-item" href="#">Another action</a></li>
					<li><a class="dropdown-item" href="#">Something else here</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="#">Separated link</a></li>
				</ul></li>
				
		</div>
		<div class="nav-login">
			<div class="login-item01">
				<a href="#">로그인</a>
			</div>
			<div class="login-item02">
				<a href="#"><i class="fa-solid fa-cart-shopping"
					style="color: black;"><span>장바구니</span></i></a>
			</div>
		</div>
	</div>
</div>

	<div style="margin-top: 70px" >
		<jsp:include page="${contentPage }"></jsp:include>
	</div>
		
	 <footer>
        <div class="container">
            <div class="pb-5 pt-5 first-line" >
                <h1 style="color: white; font-family: facon">Pumping Iron</h1>
            </div>
            <div class="pb-5 pt-5 second-line">
                <div class="row">
                    <div class="col">주소 및 연락처 : 서울특별시 종로구 종로12길 15 8F 802호 / 1544-0714</div>
                </div>
                 <div class="row">
                    <div class="col">멤버 : 최재식, 김건우, 김두현, 유제현</div>
                 </div>   
            </div>
            <div class="third-line pt-5 pb-5 text-center">
                <a href="#"><img
				src="https://w.namu.la/s/8c5bc8129cf1dc5011dc8dad2e505c568e6be2c6c0bb9e9b6e9374df725639ffa359c16b9546536fe381f7982379d980b90fc1b2b3ff3bbe5d0c05377bdda69039472251a5b54f1a39d388a657f38149"
				style="width: 70px;"></a>
            </div>
        </div>
    </footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>