<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var i1 = document.getElementById("i1").style.visibility="visible"; 
var i2 = document.getElementById("i2").style.visibility="visible"; 
var i3 = document.getElementById("i3").style.visibility="visible"; 
var i4 = document.getElementById("i4").style.visibility="visible"; 

</script>
</head>
<body>
			<div class="container mt-5">
			<div class="col-sm-12 col-lg-12">
				<div class="card flex-center" style="border: none;">
					<div class="card-body" style="width: 800px;">
						<div class="mb-3 mt-3">
						</div>
						<div>
							<div style="display: flex; align-items: center; background-color: #f1f5f9; height: 50px; border-top: 2px solid black ;border-bottom: 1px solid #dedede; font-size: 30px;">
								<span style="width: 5%; height: auto;" class="me-2">Q.</span> ${rdetail.r_title}
							</div>
						</div>
						<div class="mb-3">
							<div style="display: flex; align-items: center; height: 40px; border-bottom: 1px solid #dedede; color: #717171;">
								<fmt:formatDate value="${rdetail.r_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="mb-3">
							<div>
							${rdetail.r_content}
							</div>
						</div>
						<div class="mb-5">
							<div class="mb-1">
							<c:if test="${rdetail.r_photo ne null}">
							<div style="display: flex;">
							<img src="resources/files/${r_photo[0]}" onError="this.style.display='none'" id="i1" style="width: 350px;" height="350px;">
							<img src="resources/files/${r_photo[1]}" onError="this.style.display='none'" id="i2" style="width: 350px;" height="350px;">
							</div>
							<div style="display: flex;">
							<img src="resources/files/${r_photo[2]}" onError="this.style.display='none'" id="i3" style="width: 350px;" height="350px;">
							<img src="resources/files/${r_photo[3]}" onError="this.style.display='none'" id="i4" style="width: 350px;" height="350px;">
							</div>
							</c:if>
							</div>
						</div>
						<c:if test="${rdetail.r_answercheck eq 0}">
						<div style="border-top: 3px solid #f2f5f5; border-bottom: 3px solid #f2f5f5; padding-top: 20px; padding-bottom: 20px;" >
							<div style="color: #af2309; font-size: 20px;" class="mb-3">
							<span style="color: #af2309; font-size: 20px;" class="me-2">A.</span>답변입니다.
							</div>
							<div>
								<p> 
								 	문의사항이 접수되어 처리중입니다.
								 	<br>
								 	고객님께서 문의하신 사항에대해 빠른 답변 드리겠습니다.
								</p>								
							</div>	
						</div>
						</c:if>
						<c:if test="${rdetail.r_answercheck eq 1}">
						<div style="border-top: 3px solid #f2f5f5; border-bottom: 3px solid #f2f5f5; padding-top: 20px; padding-bottom: 20px;" >
							<div style="color: #af2309; font-size: 20px;" class="mb-3">
							<span style="color: #af2309; font-size: 20px;" class="me-2">A.</span>답변입니다.
							</div>
							<div>
								<p> 
								 	최선을 다하겠습니다. 안녕하세요. Pumping Iron입니다.
								 	<br>
								 	보내주신 문의메일은 잘 받아보았습니다.
								 	<br>
								</p>								
								 	<div>
								 	${ranswers.ra_content}
								 	</div>
								 	<div style="display: flex;">
								 		<img src="resources/files/${rr_photo[0]}" onError="this.style.display='none'" id="i1" style="width: 350px;" height="350px;">
										<img src="resources/files/${rr_photo[1]}" onError="this.style.display='none'" id="i2" style="width: 350px;" height="350px;">
								 	</div>
								 	<div style="display: flex;">
										<img src="resources/files/${rr_photo[2]}" onError="this.style.display='none'" id="i3" style="width: 350px;" height="350px;">
										<img src="resources/files/${rr_photo[3]}" onError="this.style.display='none'" id="i4" style="width: 350px;" height="350px;">
									</div>
							</div>	
						</div>
						</c:if>
						<input type="hidden" name="r_to" value="admin">
						<input type="hidden" name="token" value="${token }">
						<div class="mt-5" style="display: flex; align-items: center; justify-content:flex-end;">
						<c:if test="${rdetail.r_answercheck eq 0 and sessionScope.loginMember.m_email eq 'admin'}">
								<button type="button" class="btn btn-primary" onclick="location.href='customerservice.request.answerGo?r_no=${rdetail.r_no}'" style="width: 150px;">답변하기</button>
						</c:if>
						<c:if test="${rdetail.r_answercheck eq 1 and sessionScope.loginMember.m_email eq 'admin'}">
								<button type="button" class="btn btn-warning" onclick="requestADelete(${rdetail.r_no})" style="width: 150px;">삭제</button>
						</c:if>
								<button type="button" class="btn btn-secondary" onclick="history.back(-1)" style="width: 150px;">목록으로</button>
						</div>
						</div>
					</div>
				</div>
			 </div>
</body>
</html>