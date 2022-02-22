<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="member.login.do" method="post">
	<div class="wrap">
		<div class="login" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; font-family: facon; text-align: center;">Pumping Iron</h1>
			<div class="login_id">
				<h4>Email</h4>
				<input type="email" name="m_email" id="" placeholder="Email">
			</div>
			<div class="login_pw">
				<h4>Password</h4>
				<input type="password" name="m_pw" id="" placeholder="Password">
			</div>
			<div class="login_etc">
				<div class="checkbox">
					<a href="member.join.go">회원가입</a>
				</div>
				<div class="forgot_pw">
					<a href="">아이디・비밀번호 찾기</a>
				</div>
			</div>
			<div class="submit">
				<input type="submit" value="Sign in">
			</div>
			<div class="login_sns mt-5">
				<a><img src="resources/img/member/kakaologin_btn.png" style="width: 60px; height: 60px;"></a>
			</div>
				<div>카카오톡 로그인/회원가입</div>
		</div>
	</div>
</form>



</body>
</html>