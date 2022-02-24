<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Cookie가 비어있지 않을 때 checked 속성을 줌 -->
	<c:if test="${not empty cookie.user_check}">
		<c:set value="checked" var="checked"/>
	</c:if>

	<div class="wrap">
		<div class="login" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; font-family: facon; text-align: center;">Pumping Iron</h1>
			<div class="login_id">
				<h4>Email</h4>
				<input type="email" name="m_email" id="m_email" placeholder="Email" value="${cookie.user_check.value}">
			</div>
			<div class="mt-1" style="display: flex; justify-content: flex-start; align-items: center; width: 80%">
				<input type="checkbox" id="remember_us" name="remember_userId" ${checked}> &nbsp;아이디 기억하기
			</div>
			<div class="login_pw">
				<h4>Password</h4>
				<input type="password" name="m_pw" id="m_pw" placeholder="Password">
			</div>
			<div style="display:flex; justify-content: flex-start; width: 80%;">
				<span id="spanLoginCheck"></span>
			</div>
			<div class="login_etc">
				<div class="checkbox">
					<a href="member.join.go">회원가입</a>
				</div>
				<div class="forgot_pw">
					<a href="member.search.go">아이디・비밀번호 찾기</a>
				</div>
			</div>
			<div class="submit">
				<button type="button" id="loginBtn">Sign in</button>
			</div>
			<div class="login_sns mt-5">
				<a><img src="resources/img/member/kakaologin_btn.png" style="width: 60px; height: 60px;"></a>
			</div>
				<div>카카오톡 로그인/회원가입</div>
		</div>
	</div>



</body>
</html>