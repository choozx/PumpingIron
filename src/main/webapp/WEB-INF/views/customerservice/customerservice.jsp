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
	$(function() {
		$(".주문").show();
		$(".결제").css("display","none");
		$(".취소").css("display","none");
		$(".배송").css("display","none");
		$(".기타").css("display","none");
		$(".accordion-body").hide();  
		
		
		let type = $('input[name=type]').val();
		
		// 라디오 버튼
		$("#btnradio4").click(function() {
			
			$(".주문").show();
			$(".결제").css("display","none");
			$(".취소").css("display","none");
			$(".배송").css("display","none");
			$(".기타").css("display","none");
			$(".accordion-body").hide();  
		});

		$("#btnradio5").click(function() {
			$(".주문").css("display","none");
			$(".결제").show();
			$(".취소").css("display","none");
			$(".배송").css("display","none");
			$(".기타").css("display","none");
			$(".accordion-body").hide();  
		});

		$("#btnradio6").click(function() {
			$(".주문").css("display","none");
			$(".결제").css("display","none");
			$(".취소").show();
			$(".배송").css("display","none");
			$(".기타").css("display","none");
			$(".accordion-body").hide();  
		});

		$("#btnradio7").click(function() {
			$(".주문").css("display","none");
			$(".결제").css("display","none");
			$(".취소").css("display","none");
			$(".배송").show();
			$(".기타").css("display","none");
			$(".accordion-body").hide();  
		});
		
		$("#btnradio8").click(function() {
			$(".주문").css("display","none");
			$(".결제").css("display","none");
			$(".취소").css("display","none");
			$(".배송").css("display","none");
			$(".기타").show();
			$(".accordion-body").hide();  
		});
		// 아코디언
		$(".accordion-body").hide();
		$(".accordion-header").click(function() {
			$(this).next().slideToggle(300);
			$(".accordion-header").not(this).next().slideUp(300);
			return false;
		});
		
		/* if(${curPage} == 1){
		 $("#page-link").css("background", "gray");
		}  */
		 
			
		
	
	
	});
</script>
</head>
<body>
	<input type="hidden" name="token" value="${token }">
	<div class="main container mt-5">
	<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
        <c:if test="${m_email ne 'admin'}">
		<div style="width: 100%; border-bottom: 3px solid gray;">
			<h4>문의내역</h4>
		</div>
        <c:forEach items="${inquirys}" var="i">
        <c:if test="${i.i_answercheck eq 0}">
		<div class="mt-3 pb-3" style="border-bottom: 3px solid #f2f5f5;">
			<div class="mb-2" onclick="location.href='customerservice.inquiry.detail?i_no=${i.i_no}'" style="cursor: pointer;"><span><fmt:formatDate value="${i.i_date}" type="date" pattern="yyyy.MM.dd"/></span> ${i.i_title}</div>
			<div class="mt-4">
			<span class="me-2" style="border: 1px solid #f7de5e; background: #f7de5e; border-radius: 30px; padding: 5px 10px">답변대기</span>
			</div>
		</div>
		</c:if>
		<c:if test="${i.i_answercheck eq 1}">
		<div class="mt-3 pb-3" style="border-bottom: 3px solid #f2f5f5;">
			<div class="mb-2" onclick="location.href='customerservice.inquiry.detail?i_no=${i.i_no}'" style="cursor: pointer;"><span><fmt:formatDate value="${i.i_date}" type="date" pattern="yyyy.MM.dd"/></span> ${i.i_title}</div>
			<div class="mt-4">
			<span class="me-2" style="border: 1px solid #f7de5e; background: #f7de5e; border-radius: 30px; padding: 5px 10px">답변완료</span><a href="#" style="color: #717171;">RE:</a>
			</div>
		</div>
		</c:if>
        </c:forEach>
		</c:if>
	<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
        <c:if test="${m_email eq 'admin'}">
		<div class="mt-5" style="display: flex; justify-content: space-between; border-bottom: 3px solid gray;">
		<div>
			<h4>문의내역</h4>
		</div>
		<form action="event.search">
			<div style="display: flex;">
		<input class="form-control" type="search" placeholder="Search" aria-label="Search" name="search">
        <button class="btn btn-outline-primary" >Search</button>
			</div>
		</form>
		</div>
		<div>
		<c:forEach items="${inquiryAdmins}" var="i">
			<c:if test="${i.i_answercheck eq 0}">
				<div style="border-bottom: 3px solid #f2f5f5; cursor: pointer;" onclick="location.href='customerservice.inquiry.detail?i_no=${i.i_no}'">[${i.i_from}]${i.i_title }<span class="ms-2" style="color: rgb(136, 136, 136);"><fmt:formatDate value="${i.i_date}" type="date" pattern="yyyy.MM.dd"/></span></div>
			</c:if>
			<c:if test="${i.i_answercheck eq 1}">
				<div style="border-bottom: 3px solid #f2f5f5; color: rgb(136, 136, 136); cursor: pointer;" onclick="location.href='customerservice.inquiry.detail?i_no=${i.i_no}'" >[${i.i_from}] ${i.i_title } <span class="ms-2" style="color: rgb(136, 136, 136);"><fmt:formatDate value="${i.i_date}" type="date" pattern="yyyy.MM.dd"/></span></div>
			</c:if>
		</c:forEach>
		</div>
		</c:if>	
		<div class="mt-5">
			<h4>1:1문의</h4>
			<p>아래에서 문의사항을 선택해주세요.</p>
		</div>
		<form action="customerservice.inquiry.go">
		<div class="btn-group mb-5"  role="group" aria-label="" style="width: 100%">
		    <button class="btn btn-outline-secondary" name="i_type" value="주문">주문</button>
		    <button class="btn btn-outline-secondary" name="i_type" value="결제">결제</button>
		    <button class="btn btn-outline-secondary" name="i_type" value="취소">취소/반품/교환</button>
		    <button class="btn btn-outline-secondary" name="i_type" value="배송">배송</button>
		    <button class="btn btn-outline-secondary" name="i_type" value="기타">기타</button>
		</div>
		</form>
		<div class="mt-3" style="display: flex; justify-content: space-between;">
		<h4>자주찾는질문</h4>
			<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
             <c:if test="${m_email eq 'admin'}">
			<div><button type="button" class="btn btn-primary" onclick="location.href='customerservice.write.go'">글쓰기</button></div>
			</c:if>
		</div>

		<div class="btn-group" role="group"
			aria-label="Basic radio toggle button group" style="width: 100%;">
			<input type="radio" class="btn-check" name="btnradio" id="btnradio4"
				autocomplete="off" checked> <label
				class="btn btn-outline-primary" for="btnradio4">주문</label> <input
				type="radio" class="btn-check" name="btnradio" id="btnradio5"
				autocomplete="off"> <label class="btn btn-outline-primary"
				for="btnradio5">결제</label> <input type="radio" class="btn-check"
				name="btnradio" id="btnradio6" autocomplete="off"> <label
				class="btn btn-outline-primary" for="btnradio6">취소/반품/교환</label>
				<input type="radio" class="btn-check"
				name="btnradio" id="btnradio7" autocomplete="off"> <label
				class="btn btn-outline-primary" for="btnradio7">배송</label>
				<input type="radio" class="btn-check"
				name="btnradio" id="btnradio8" autocomplete="off"> <label
				class="btn btn-outline-primary" for="btnradio8">기타</label>
		</div>
		<div class="accordion accordion-flush all mt-1"
			id="accordionFlushExample">
			<c:forEach items="${questions }" var="q">
			<div class="accordion-item ${q.q_type}">
				<input type="hidden" value="${q.q_type}" name="type">
				<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
                 <c:if test="${m_email eq 'admin'}">
				<h2 class="accordion-header ${q.q_type}">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" aria-expanded="false">
						<span style="width: 5%; height: auto;">Q</span> ${q.q_title}
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen ms-2" viewBox="0 0 16 16" onclick="location.href='customerservice.update.go?q_no=${q.q_no}'">
					  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
					</svg>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash ms-2" viewBox="0 0 16 16" onclick="questionDelete(${q.q_no});">
  							<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  							<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
							</svg>
						</button>
				</h2>
                 </c:if>
                 <c:if test="${m_email ne 'admin'}">
                 <h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" aria-expanded="false">
						<span style="width: 5%; height: auto;">Q</span> ${q.q_title}
					</button>
				</h2>
				</c:if>	
			<div class="accordion-body accordion-collapse collapse" style="background-color: #f2f2f2; display: flex;">
					<div style="width: 5%; height: auto; color: rgba(0,0,0,0.4);">A</div>
					<div  style="width: 95%; height: auto;"> ${q.q_content}</div>
			</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>