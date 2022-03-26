<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/calendar">
<script type="text/javascript">
	$(function() {
		
		//	let number2 = $('#numFromJS2').val();
			
		$('#detail_delete1').click(function() {
			
			let number1 = $('#numFromJS1').val();
			
			if (confirm('해당 내용을 정말로 삭제하시겠습니까??')) {
				
				location.href="schedule.del?cc_no=" + number1;
				
			} else {
				return false;
			}
		}); // detail_delete1
		
		$('#detail_delete2').click(function() {
			
			let number2 = $('#numFromJS2').val();
			
			if (confirm('해당 내용을 정말로 삭제하시겠습니까??')) {
				
				location.href="schedule.del.detail?ccd_no=" + number2;
				
			} else {
				return false;
			}
		}); // callback
		
	}); //ready
</script>

<title>Insert title here</title>
</head>
<body>

	<!-- admin 확인 -->
	<input id="login_check" type="hidden" value="${sessionScope.loginMember.m_email}">
	

	 <!-- 상세페이지 -->
 
	<input name="cc_no" id="numFromJS1" type="hidden" value="${param.ccd_no}">
	<input name="ccd_no" id="numFromJS2" type="hidden" value="${param.ccd_no}">
	
	
	<c:forEach items="${detail}" var="d" >
 	<c:if test="${detail.size() != 0}">
    <div class="container" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="" role="document" >
            <div class="modal-content" >
                <div class="modal-header" > 
                    <h5 class="modal-title" id="exampleModalLabel"> ${d.ccd_title} </h5>
                </div>
              
                <div class="modal-body" style="text-align: center;">
                    <div class="form-group">
                    
                        <div id="detail_img">
                        	<img style="width: 85%; " src="resources/img/${d.ccd_img}">
                        </div>
                        
                        <div id="detail_text" style="color:#3D3D3D; white-space:pre-wrap;">${d.ccd_text}</div>
                        <br>
                        <button class="btn btn-light btn-outline-dark" onclick="location.href='schedule.go'">돌아가기</button>
                        <c:if test="${sessionScope.loginMember.m_email == 'admin'}">
                        &nbsp; <button id="detail_delete2" class="btn btn-light btn-outline-dark">삭제</button> 
                        </c:if>
                        
                    </div>
                </div>
    
            </div>
        </div>
    </div>
    </c:if>
    
    </c:forEach>
    
    
    <c:if test="${detail.size() == 0}">
    <div class="container bg-light bg-gradient" style="width: 100%; border: 1px solid; border-radius: 10px; margin-top: 30px;">
   		<div class="pb-5 pt-3"></div>
		<div class="pb-5 pt-5" style="text-align: center;">
                 <h3 style=" font:bold;">이런.. 아직 상세정보가 아직 준비 되지 않은 페이지입니다... :(</h3>
                 <h3>이용에 불편을 드려 죄송합니다.</h3>
                 <h3>빠른 시일 내로 추가하도록 하겠습니다.</h3>
   		<div class="pb-5 pt-3"></div>
                 <span style="font-family: facon; font-size: 50pt;">Pumping Iron</span>
   		<div class="pb-5 pt-3">
   		<button class="btn btn-light btn-outline-dark" onclick="location.href='schedule.go'">돌아가기</button>
   		 <c:if test="${sessionScope.loginMember.m_email == 'admin'}">
   			&nbsp; <button class="btn btn-light btn-outline-dark" onclick="location.href='schedule.reg.page?ccd_no=' + ${param.ccd_no}">일정 추가</button>
   			&nbsp; <button id="detail_delete1" class="btn btn-light btn-outline-dark">삭제</button> 
   		 </c:if>
   		</div>
		</div>
	</div>
    </c:if>

</body>
</html>