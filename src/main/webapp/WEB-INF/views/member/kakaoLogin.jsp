<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="member.kakaoDo" method="post" >
<div class="wrap">
		<div class="search" style="border: 1px solid gray; margin-top: 70px; position: relative;">
			<div style="border-bottom: 2px solid gold;" class="mt-2">
			<h2 class="mb-2" style="color: black; text-align: center;">추가 정보 기입</h2>
			<span style="font-size: 12pt">사이트 내 모든 서비스를 이용하기 위해 필요한 정보입니다.</span>
			</div>
			<div id="searchI" style="width:80%;" class="mt-2">
			<c:set var="email" value="${param.email}"></c:set>
                                        <c:if test="${email eq '' or email eq null}">
                                        <div class="form-group mt-3">
						<label class="font-weight-bold text-black  mb-1" for="inputPhone_1">이메일</label>
						<div>
							<input type="text" class="form-control" id="email" name="email" placeholder="Email" required="required">
						</div>
					</div>
			                        	</c:if>
					<div class="form-group mt-3">
						<label class="font-weight-bold text-black  mb-1" for="inputPhone_1">휴대폰번호</label>
						<span style="font-size: 12px; color: #50bcdf;">※ '-'없이 번호만 입력해주세요</span>
						<div>
							<input type="text" class="form-control" id="m_phone" name="m_phone" placeholder="Phone" required="required">
						</div>
					</div>
					<div class="form-group mt-3">
						<label class="font-weight-bold text-black  mb-1" for="inputPhone_1">주소</label>
						<div>
							<div style="display: flex; align-items: center;">							
							<input id="jm_addr3Input" class="form-control" readonly="readonly" name="m_addr3"
						maxlength="5" autocomplete="off" placeholder="Postal Code"
						style="width: 92%"><span id="addrSearchBtn">[Search]</span>
							</div>
							<input id="jm_addr1Input"  class="form-control" readonly="readonly" name="m_addr1"
					maxlength="30" autocomplete="off" placeholder="Address line1">
							<input name="m_addr2" class="form-control" maxlength="30" autocomplete="off"
					placeholder="Address line2">
						</div>
					</div>
					<div class="form-group mt-3">
						<button id="searchBtn2" class="btn btn-primary btn-block sb" data-bs-toggle="modal" data-bs-target="#staticBackdrop">확인</button>
					<a class="btn btn-danger btn-block sb mt-2"	onclick="location.href='index.go'">취소</a>
					</div>
				</div>
		</div>
	</div>
	<input  type="hidden" id="id" name="id" value="${param.id}">
	<input  type="hidden" id="connected_at" name="connected_at" value="${param.connected_at}">
	<input  type="hidden" id="email" name="email" value="${param.email }">
	<input  type="hidden" id="name" name="name" value="${param.name }">
	<input  type="hidden" id="profile_image" name="profile_image" value="${param.profile_image}">
</form>



	
</body>
</html>