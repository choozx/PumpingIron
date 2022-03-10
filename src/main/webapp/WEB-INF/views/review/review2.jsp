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

</head>
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
  
  
 <c:forEach var="n" items="">
  
    <div class="col" style="border: 1px solid;">
    
<a href="reviewWatch.go" class="card-item grid-item"  >
<div class="column-div cursor">
<img class="column-img" src="resources/img/tips/bh.jpg" alt style="width: 100%" >
<div class="d-flex align-items-center justify-content-between mb-3" style="margin-top: 10px">
<span class="noto-sb text-gray">####-##-##</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<div class="d-flex align-items-center">
<img  src="resources/img/tips/love.png" class="mr-1 column-like" style="max-width: 20px">
<span class="noto-sb mb-1">0</span>


</div>
<div class="d-flex align-items-center ml-2">
<img alt="" src="resources/img/tips/cnt.png" class="mr-1 column-like">
<span class="noto-sb mb-1">#</span>
</div>

</div>
<div class="column-title noto-h4 column-mb-15 text-break text-overflow-3">쵸코맛 프로틴 리뷰</div>
<div class="column-content noto-pr mb-5 colum-lineheight w-100 text-break text-overflow-5">
넘나 맛있는것 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</div>
<div class="column-user d-flex align-items-center justify-content-between" style="margin-bottom: 15px;">
<div class="d-flex align-items-center">
<img  src="resources/img/tips/d.jpg" class="user-img mr-2">
<span class="noto-sb">#유저아뒤</span>
</div>
<div class="d-flex align-items-center noto-sb"></div>
<span class="mr-1" style="font-size: 12px; font-weight: bold;">조회수</span>
<span style="font-size: 12px; font-weight: bold;" >#</span>
</div>
</div> 
</a>
    </div>
  </c:forEach> 
    
    
  
    
    
    
    
    
    
    
    
  
    
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
  </div>

  
  
  
<div class="viewer-bottom d-flex align-items-center justify-content-between mt-4 mb-5 container">
<div class="viewer-bottom-left"></div>
<button class="background-b-btn board-btn noto-h4"
 type="button" name="button" data-category-id="8"
  data-auth-write="1" 
  onclick= "location.href='reviewWrite.go'">글쓰기</button>
  
  
</div>



</body>
</html>