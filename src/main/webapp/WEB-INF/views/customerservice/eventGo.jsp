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
		// 더보기 클릭
		
		
		
		let type = $('input[name=type]').val();
		
		// 라디오 버튼
		$("#btnradio1").click(function() {
			$(".이벤트").show();
			$(".공지사항").show();
			$(".accordion-body").hide(); ;
		});

		$("#btnradio2").click(function() {
			$(".공지사항").show();
			$(".이벤트").hide();
			$(".accordion-body").hide(); 
		});

		$("#btnradio3").click(function() {
			$(".이벤트").show();
			$(".공지사항").hide();
			$(".accordion-body").hide(); ;
		});

		// 아코디언
		$(".accordion-body").hide();
		$(".accordion-header").click(function() {
			$(this).next().slideToggle(300);
			$(".accordion-header").not(this).next().slideUp(300);
			return false;
		});
		
		
		
	});
</script>
</head>
<body>

	<div class="main container mt-5">
		<div class="btn-group" role="group"
			aria-label="Basic radio toggle button group" style="width: 100%;">
			<input type="radio" class="btn-check" name="btnradio" id="btnradio1"
				autocomplete="off" checked> <label
				class="btn btn-outline-primary" for="btnradio1">전체</label> <input
				type="radio" class="btn-check" name="btnradio" id="btnradio2"
				autocomplete="off"> <label class="btn btn-outline-primary"
				for="btnradio2">공지사항</label> <input type="radio" class="btn-check"
				name="btnradio" id="btnradio3" autocomplete="off"> <label
				class="btn btn-outline-primary" for="btnradio3">이벤트</label>
		</div>
		<div class="mt-5" style="display: flex; justify-content: space-between;">
			<div style="display: flex;">
			<input class="form-control" type="search" placeholder="Search" aria-label="Search">
        <button type="button" class="btn btn-outline-primary">Search</button>
			</div>
			<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
             <c:if test="${m_email eq 'admin'}">
			<div><button type="button" class="btn btn-primary" onclick="location.href='customerservice.event.do'">글쓰기</button></div>
			</c:if>
		</div>
		<div class="accordion accordion-flush all mt-1"
			id="accordionFlushExample">
			<c:forEach items="${events }" var="e">
			<div class="accordion-item ${e.e_type}">
				<input type="hidden" value="${e.e_type}" name="type">
				<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
                 <c:if test="${m_email eq 'admin'}">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" aria-expanded="false">
						[${e.e_type}] ${e.e_title}<span class="ms-1" style="color: rgb(136, 136, 136); font-size: 12px;"><fmt:formatDate value="${e.e_date}" type="date" pattern="yyyy.MM.dd"/></span>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen ms-2" viewBox="0 0 16 16" onclick="location.href='customerservice.event.updateGo?e_no=${e.e_no}'">
					  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
					</svg>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash ms-2" viewBox="0 0 16 16" onclick="eventDelete(${e.e_no});">
  							<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  							<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
							</svg>
						</button>
				</h2>
                 </c:if>
                 <c:if test="${m_email ne 'admin'}">
                 <h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" aria-expanded="false">
						[${e.e_type}] ${e.e_title}<span class="ms-1" style="color: rgb(136, 136, 136); font-size: 12px;"><fmt:formatDate value="${e.e_date}" type="date" pattern="yyyy.MM.dd"/></span>
					</button>
				</h2>
				</c:if>	
			<div class="accordion-body accordion-collapse collapse">
					<div>${e.e_content}</div>
			</div>
			</div>
			</c:forEach>
			<div style="display: flex; justify-content: center; align-items: center;">
				<a style="color: rgb(0, 81, 245);" href="#" id="more">더보기</a>
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-down ms-1" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" style="color: rgb(0, 81, 245);"/>
</svg>
			</div>
		</div>
	</div>
</body>
</html>