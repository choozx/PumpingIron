<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/index.css">
<script src="resources/js/del/like.js"></script>
<script>
 window.onpageshow = function(event) {
	let check = true;
	 
	 if ( event.persisted || (window.performance && window.performance.navigation.type == 2)) {
		 window.location.reload()
			
	 }
	}
</script>

</head>

${result }


<body style="z-index: 0;">


<div class="title-center text-center">

<a href="tips/tips.jsp">
<span class="prompt-h1">Q/A</span>
</a>
</div>



<table class="table container">
  <thead>
    <tr>
      <th scope="col" style="width: 10%">번호</th>
      <th scope="col" style="width: 54%">글 제목</th>
      <th scope="col" style="width: 10%">작성자</th>
      <th scope="col" style="width: 10%">날짜</th>
      <th scope="col" style="width: 8%">조회수</th>
      <th scope="col" style="width: 8%">추천수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="m" items="${reviews }">
    <tr>
      <th scope="row">${m.cr_no}</th>
      <td><a href="watchContents.go?cr_no=${m.cr_no }&token2=${token2}"><span>${m.cr_title}</span></a></td>
      <td>${m.cr_nickname }</td>
      <td><fmt:formatDate value="${m.cr_date}" type="date" dateStyle="short" />
      </td>
      <td>${m.cr_views }</td>
      
      <td class="viewer-like" style="color: black;">${likeCnt }</td>

      
    </tr>
  </c:forEach>
  </tbody>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  
  
    <li class="page-item">
    
    <c:choose>
    
    <c:when test="${curPage < 2 }">
    
      <a class="page-link" href="" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </c:when>


<c:otherwise>


      <a class="page-link" href="page.change?p=${curPage - 1 }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>


</c:otherwise>   
   
   
    </c:choose>
    </li>
    
    
    <c:forEach var="p" begin="1" end="${pageCount }">
    	<li class="page-item"><a class="page-link" href="page.change?p=${p }">${p }</a></li>
 	</c:forEach>
    
    
    
    
    
     <li class="page-item">
    <c:choose>
    <c:when test="${curPage == pageCount }">
         
      <a class="page-link" href="" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
 
    </c:when>
    <c:otherwise>
      <a class="page-link" href="page.change?p=${curPage + 1 }" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </c:otherwise>
    </c:choose>
 
    </li>
  </ul>
</nav>

<c:choose>
<c:when test="${sessionScope.loginMember != null }">
<div class="viewer-bottom d-flex align-items-center justify-content-between mt-4 mb-5 container">
<div class="viewer-bottom-left container"></div>
<button class="background-b-btn board-btn noto-h4"
 type="button" name="button" data-category-id="8"
  data-auth-write="1" 
  onclick= "location.href='write.go'" value="${sessionScope.loginMember.m_name}">글쓰기</button>
</div>
</c:when>
<c:otherwise>




</c:otherwise>


</c:choose>


</body>
</html>