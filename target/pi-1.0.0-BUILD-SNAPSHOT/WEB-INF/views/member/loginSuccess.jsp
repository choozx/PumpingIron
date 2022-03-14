<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div style="margin: 100px;">
		<a><img src="https://w.namu.la/s/8c5bc8129cf1dc5011dc8dad2e505c568e6be2c6c0bb9e9b6e9374df725639ffa359c16b9546536fe381f7982379d980b90fc1b2b3ff3bbe5d0c05377bdda69039472251a5b54f1a39d388a657f38149"	style="height: 80px; margin-left: 10px;" /></a> <br>
		<br>
		<h3>안녕하세요, ${param.m_email} 님</h3>
		<br>
		<p>환영합니다!</p>
		<br>
		<p>회원가입이 정상적으로 이루어 졌습니다.</p>
		<br>
		<p>로그인 하시면 홈페이지 내의 모든 서비스를 이용하실 수 있습니다.</p>
		<br> <a href="${pageContext.request.contextPath}/">로그인 페이지로 이동하기</a>
	</div>
</body>
</html>