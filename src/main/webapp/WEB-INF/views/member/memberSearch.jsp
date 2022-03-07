<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}

</style>
</head>
<body>

<%@ include file="/WEB-INF/views/member/memberIdSearchModal.jsp"%>
	<div class="wrap">
		<div class="search" style="border: 1px solid gray; margin-top: 70px; position: relative;">
			<div style="border-bottom: 2px solid gold;" class="mt-2">
			<h2 class="mb-2" style="color: black; text-align: center;">아이디/비밀번호 찾기</h2>
			<h5>인증된 이메일만 정보 찾기가 가능합니다.</h5>
			</div>
			<div class="mt-2" style="display: flex; justify-content:space-around; width: 80%;">
			<div 
					class="custom-control custom-radio custom-control-inline">
					<input type="radio" class="custom-control-input" id="search_1" name="search_total" onclick="search_check(1)" checked="checked">
					<label class="custom-control-label font-weight-bold text-black"	for="search_1">아이디 찾기</label>
				</div>
				<div class="custom-control custom-radio custom-control-inline">
					<input type="radio" class="custom-control-input" id="search_2" name="search_total" onclick="search_check(2)"> 
					<label class="custom-control-label font-weight-bold text-black" for="search_2">비밀번호 찾기</label>
				</div>
			</div>
			<div id="searchI" style="width:80%;" class="mt-2">
					<div class="form-group">
						<label class="font-weight-bold text-black mb-1" for="inputName_1">이름</label>
						<div>
							<input type="text" class="form-control" id="m_name" name="inputName_1" placeholder="Name">
						</div>
					</div>
					<div class="form-group mt-3">
						<label class="font-weight-bold text-black  mb-1" for="inputPhone_1">휴대폰번호</label>
						<span style="font-size: 12px; color: #50bcdf;">※ '-'없이 번호만 입력해주세요</span>
						<div>
							<input type="number" class="form-control" id="m_phone" name="inputPhone_1" placeholder="Phone">
						</div>
					</div>
					<div class="form-group mt-3">
						<button id="searchBtn" type="button" class="btn btn-primary btn-block sb" data-bs-toggle="modal" data-bs-target="#staticBackdrop">확인</button>
					<a class="btn btn-danger btn-block sb mt-2"	href="member.login.go">로그인</a>
					</div>
				</div>
				<div id="searchP" style="display: none; width: 80%;" class="mt-2">
					<div class="form-group">
						<label class="font-weight-bold text-black mb-1" for="inputId">아이디</label>
						<div>
							<input type="email" class="form-control" id="inputEmail_2"	name="m_email" placeholder="ex) E-mail@gmail.com" value="">
						</div>
					</div>
					<div class="form-group mt-3">
						<label class="font-weight-bold text-black mb-1" for="inputEmail_2">휴대폰번호</label>
						<span style="font-size: 12px; color: #50bcdf;">※ '-'없이 번호만 입력해주세요</span>
						<div >
							<input type="number" class="form-control" id="inputPhone_2" name="inputId_2" placeholder="Phone" name="m_phone">
						</div>
					</div>
					<div class="form-group mt-3">
						<button id="searchBtn2" type="button" class="btn btn-primary btn-block sb">확인</button>
					<a class="btn btn-danger btn-block sb mt-2"	href="member.login.go">로그인</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>