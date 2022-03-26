<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>
</head>
<body>

	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	
	<form action="schedule.reg.detail" method="post" enctype="multipart/form-data">
	
	<input name="cc_no" id="numFromJS1" type="hidden" value="${param.ccd_no}">
	<input name="ccd_no" id="numFromJS2" type="hidden" value="${param.ccd_no}">
	<input type="hidden" name="token" value="${token}">
    <div class="container" id="calendarReg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header"> 
                    <h5 class="modal-title" id="exampleModalLabel">상세정보를 입력하세요.</h5>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">대회명</label> <br>
                        <input name="ccd_title" type="text" class="form-control">
                        <label for="taskId" class="col-form-label">대회 사진</label> <br>
                        <input name="ccd_img" type="file" class="form-control">
                        <label for="taskId" class="col-form-label">대회 상세</label> <br>
                        <textarea name="ccd_text" style="resize: none; width: 100%; height: 300px;"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" id="addDetail">추가</button>
                </div>
    
            </div>
        </div>
    </div>
    
	</form>
    

</body>
</html>