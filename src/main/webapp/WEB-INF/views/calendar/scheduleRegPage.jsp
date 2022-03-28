<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">

$(function() {
	
	$('#addDetail').click(function() {
		
		let title = $('#title_input').val();
 		let image = $('#img_input').val();
		let textArea = $('#text_input').val();
		
		if (title == '' || title == null) {
			alert('대회명을 입력해주세요.');
			$('#title_input').focus();
			return false;
		} else if (textArea == '' || textArea == null) {
			alert('상세 내용을 입력해주세요.');
			return false;
		} else if (textArea.length > 3000) {
			alert('3000자까지만 작성할 수 있습니다.');
			return false;
		} 
		
		
	});
	
}); // ready

</script>


<title>Insert title here</title>
</head>
<body>

    <div class="container" id="calendarReg">
    
	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	
	<form action="schedule.reg.detail" method="post" enctype="multipart/form-data">
	
	<input name="cc_no" id="numFromJS1" type="hidden" value="${param.ccd_no}">
	<input name="ccd_no" id="numFromJS2" type="hidden" value="${param.ccd_no}">
	<input type="hidden" name="token" value="${token}">
	
       
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header"> 
                    <h5 class="modal-title" id="exampleModalLabel">상세정보를 입력하세요.</h5>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">대회명</label> <br>
                        <input id="title_input" name="ccd_title" type="text" class="form-control">
                        <label for="taskId" class="col-form-label">대회 사진</label> <br>
                        <input id="img_input" name="ccd_img" type="file" class="form-control" required="required">
                        <label for="taskId" class="col-form-label">대회 상세</label> <br>
                        <textarea id="text_input" name="ccd_text" style="resize: none; width: 100%; height: 300px;"></textarea>
                        <div style="font-size: 8pt; color: gray; text-align: right;">* 최대 3,000자</div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" id="addDetail">추가</button>
                </div>
    
            </div>
        </div>
    
	</form>
    </div>
    

</body>
</html>