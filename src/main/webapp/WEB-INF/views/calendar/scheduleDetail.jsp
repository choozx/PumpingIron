<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/calendar">

<title>Insert title here</title>
</head>
<body>

	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	

 <!-- 상세페이지 -->
 
	<input name="ccd_no" id="numFromJS" type="hidden" value="">
	
	
	<c:forEach items="${detail}" var="d" >
<%-- 	<input name="ccd_no" id="toJs_no" type="hidden" value="${d.ccd_no}">
	<input name="ccd_title" id="toJs_title" type="hidden" value="${d.ccd_title}">
	<input name="ccd_img" id="toJs_img" type="hidden" value="${d.ccd_img}">
	<textarea name="ccd_text" id="toJs_text" style="display: none;">${d.ccd_text}</textarea> --%>
	
	 
 	
    <div class="container" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="" role="document" >
            <div class="modal-content" >
                <div class="modal-header" > 
                    <h5 class="modal-title" id="exampleModalLabel"> ${d.ccd_title} </h5>
                </div>
               
                <div class="modal-body" style="text-align: center;">
                    <div class="form-group">
                    
                        <div id="detail_img">
                        	<img style="width: 85%; " src="${d.ccd_img}">
                        </div>
                        
                        <div id="detail_text" style="color:#3D3D3D; ">
							${d.ccd_text} 
                        </div>
                        <br><button class="btn btn-light btn-outline-dark" onclick="location.href='schedule.go'">돌아가기</button>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
    </c:forEach>

</body>
</html>