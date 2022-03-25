<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/review.css">
<link rel="stylesheet" href="resources/css/tips.css">

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
<body>
<div class="main-wrapper container">
<div class="title-center text-center ">

<a href="">
<span class="prompt-h1">review</span>
</a>
</div>
</div>

<div class="container">
  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
  
  
 <c:forEach var="n" items="${reviews}">
 	
 
   
    <div class="col" style="border: 1px solid;">
    
<a href="reviewWatch.go?c2_no=${n.c2_no }" class="card-item grid-item"  >
<div class="column-div cursor">
<span class="column-img" alt style="width: 100%"></span>
 <img class="column-img" src="${n.c2_picture }" alt style="width: 100%" ><!-- ajax에서 등록된 문자열 가져오기  -->
<div class="d-flex align-items-center justify-content-between mb-3" style="margin-top: 10px">
<span class="noto-sb text-gray"><fmt:formatDate value="${n.c2_date }" type="date" dateStyle="short"/></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<div class="d-flex align-items-center">
<img  src="resources/img/tips/heart-fill.svg" class="mr-1 column-like" style="max-width: 20px">
<span class="noto-sb mb-1">${n.c2_like }</span>


</div>
<div class="d-flex align-items-center ml-2">
<img alt="" src="resources/img/tips/cnt.png" class="mr-1 column-like">
<span class="noto-sb mb-1">${n.c2_bodyProfile }</span>
</div>

</div>
<div class="column-title noto-h4 column-mb-15 text-break text-overflow-3">${n.c2_title }</div>
<div class="column-content noto-pr mb-5 colum-lineheight w-100 text-break text-overflow-5">

</div>
<div class="column-user d-flex align-items-center justify-content-between" style="margin-bottom: 15px;">
<div class="d-flex align-items-center">
<img  src="resources/files/${n.m_photo }" class="user-img mr-2"><!-- 회원가입할때 이미지 가져오기 -->
<span class="noto-sb">${n.c2_nickname }</span>
</div>
<div class="d-flex align-items-center noto-sb"></div>
<span class="mr-1" style="font-size: 12px; font-weight: bold;">조회수</span>
<span style="font-size: 12px; font-weight: bold;" >${n.c2_views }</span>
</div>
</div> 
</a>
    </div>
  </c:forEach> 
    
    
    
  
    
    </div>
    
  </div>

  
  
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


      <a class="page-link" href="page2.change?p=${curPage - 1 }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>


</c:otherwise>   
   
   
    </c:choose>
    </li>
    
    
    <c:forEach var="p" begin="1" end="${pageCount }">
    	<li class="page-item"><a class="page-link" href="page2.change?p=${p }">${p }</a></li>
 	</c:forEach>
    
    
    
    
    
     <li class="page-item">
    <c:choose>
    <c:when test="${curPage == pageCount }">
         
      <a class="page-link" href="" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
 
    </c:when>
    <c:otherwise>
      <a class="page-link" href="page2.change?p=${curPage + 1 }" aria-label="Next">
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
<div class="viewer-bottom-left"></div>
<button class="background-b-btn board-btn noto-h4"
 type="button" name="button" data-category-id="8"
  data-auth-write="1" 
  onclick= "location.href='reviewWrite.go'" value="${sessionScope.loginMember.m_name}">글쓰기</button>
  
  
</div>
</c:when>
<c:otherwise>

</c:otherwise>


</c:choose>

</body>
</html>