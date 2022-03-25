<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
	<div class="title_box" style="margin: 0px 0 20px 0; padding: 30px 30px; border: 1px solid #000000;">
        <h1 style="font-size: 36px; padding-left: 15px; border-left: 3px solid #000000; margin-top: 0px; margin-bottom: 10px;">Pumping Iron에 바란다</h1>
        <p style="font-size: 14px; line-height: 24px; padding: 0px; margin: 0px; word-break: keep-all;">보다 나은 Pumping Iron을 만들기 위한 의견을 남겨주세요. <br>이곳은 운영진들과 고객들을 이어주는 소중한 소통 창구입니다.</p>
    </div>
    <input type="hidden" name="token" value="${token }">
	<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
        <c:if test="${m_email ne 'admin'}">
		<div style="width: 100%; border-bottom: 3px solid gray; display: flex; justify-content: space-between;">
			<h4>고객의 소리</h4>
			<button class="btn btn-dark" type="button" onclick="location.href='customerservice.request.writeGo'">'Pumping Iron에 바란다' 글쓰기</button>
		</div>
        <c:forEach items="${requests}" var="r">
        <c:if test="${r.r_answercheck eq 0}">
		<div class="mt-3 pb-3" style="border-bottom: 3px solid #f2f5f5;">
			<div class="mb-2" onclick="location.href='customerservice.request.detail?r_no=${r.r_no}'" style="cursor: pointer;"><span><fmt:formatDate value="${r.r_date}" type="date" pattern="yyyy.MM.dd"/></span> ${r.r_title}</div>
			<div class="mt-4">
			<span class="me-2" style="border: 1px solid #f7de5e; background: #f7de5e; border-radius: 30px; padding: 5px 10px">답변대기</span>
			</div>
		</div>
		</c:if>
		<c:if test="${r.r_answercheck eq 1}">
		<div class="mt-3 pb-3" style="border-bottom: 3px solid #f2f5f5;">
			<div class="mb-2" onclick="location.href='customerservice.request.detail?r_no=${r.r_no}'" style="cursor: pointer;"><span><fmt:formatDate value="${r.r_date}" type="date" pattern="yyyy.MM.dd"/></span> ${r.r_title}</div>
			<div class="mt-4">
			<span class="me-2" style="border: 1px solid #f7de5e; background: #f7de5e; border-radius: 30px; padding: 5px 10px">답변완료</span><a href="customerservice.inquiry.detail?r_no=${r.r_no}" style="color: #717171;">RE: ${r.r_title}</a>
			</div>
		</div>
		</c:if>
        </c:forEach>
        <c:if test="${requestCount ne 0}">
        <nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">


			<li class="page-item"><c:choose>

					<c:when test="${curPage == 1 }">
						<a class="page-link disabled" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
						</a>
					</c:when>


					<c:otherwise>


						<a class="page-link" href="customerservice.request.page?p=${curPage - 1 }"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a>


					</c:otherwise>


				</c:choose></li>

			<c:forEach var="p" begin="1" end="${pageCount }">
				<li class="page-item"><a id="page-link" class="page-link"
					href="customerservice.request.page?p=${p }">${p}</a></li>
			</c:forEach>





			<li class="page-item"><c:choose>
					<c:when test="${curPage == pageCount }">
						<a class="page-link disabled" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
						</a>
					</c:when>
					<c:otherwise>
						<a class="page-link" href="customerservice.request.page?p=${curPage + 1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a>
					</c:otherwise>
				</c:choose></li>
		</ul>
	</nav>
	</c:if>
		</c:if>
	<c:set var="m_email" value="${sessionScope.loginMember.m_email}"></c:set>
        <c:if test="${m_email eq 'admin'}">
		<div class="mt-5" style="display: flex; justify-content: space-between; border-bottom: 3px solid gray;">
		<div>
			<h4>고객의 소리</h4>
		</div>
		<form action="customerservice.request.search" name="eventSearchForm" onsubmit="return eventSearchCheck();">
			<div style="display: flex;">
		<input class="form-control" type="search" placeholder="찾고 싶은 내용을 검색해보세요!" aria-label="Search" name="search">
        <button class="btn btn-outline-primary" >Search</button>
			</div>
		</form>
		</div>
		<div>
		<c:forEach items="${requestAdmins}" var="r">
			<c:if test="${r.r_answercheck eq 0}">
				<div style="border-bottom: 3px solid #f2f5f5; cursor: pointer;" onclick="location.href='customerservice.request.detail?r_no=${r.r_no}'">[${r.r_from}]${r.r_title }<span class="ms-2" style="color: rgb(136, 136, 136);"><fmt:formatDate value="${r.r_date}" type="date" pattern="yyyy.MM.dd"/></span></div>
			</c:if>
			<c:if test="${r.r_answercheck eq 1}">
				<div style="border-bottom: 3px solid #f2f5f5; color: rgb(136, 136, 136); cursor: pointer;" onclick="location.href='customerservice.request.detail?r_no=${r.r_no}'" >[${r.r_from}] ${r.r_title } <span class="ms-2" style="color: rgb(136, 136, 136);"><fmt:formatDate value="${r.r_date}" type="date" pattern="yyyy.MM.dd"/></span></div>
			</c:if>
		</c:forEach>
		</div>
		<c:if test="${RequestAdminCount ne 0}">
		<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">


			<li class="page-item"><c:choose>

					<c:when test="${curPage == 1 }">
						<a class="page-link disabled" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
						</a>
					</c:when>


					<c:otherwise>


						<a class="page-link" href="customerservice.request.page?p=${curPage - 1 }"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a>


					</c:otherwise>


				</c:choose></li>
			
			<c:forEach var="p" begin="1" end="${pageCount }">
				<li class="page-item"><a id="page-link" class="page-link"
					href="customerservice.request.page?p=${p }">${p}</a></li>
			</c:forEach>
			





			<li class="page-item"><c:choose>
					<c:when test="${curPage == pageCount }">
						<a class="page-link disabled" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
						</a>
					</c:when>
					<c:otherwise>
						<a class="page-link" href="customerservice.request.page?p=${curPage + 1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a>
					</c:otherwise>
				</c:choose></li>
		</ul>
	</nav>
	</c:if>
		</c:if>	
	</div>
</body>
</html>