<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="">
	<div id="carouselExampleCaptions" class="container carousel slide" data-bs-ride="carousel" style="z-index: 0;">
	<div class="container">
	<div id="products_banner"><input id="p_type" type="hidden" value="${param.p_type }"></div>
	<div id="products_banner"><input id="p_type" type="hidden" value="${param.products }"></div>

	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" style="z-index: 0;">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" >
				<a href="#"><img style="height: 300px;"
				src="resources/img/products/banner.webp"
					class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
			<div class="carousel-item" >
				<a href="#"><img style="height: 300px;"
					src="resources/img/products/banner2.webp"
					class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
			<div class="carousel-item">
				<a href="#"><img style="height: 300px;"
				src="resources/img/index/slide_03.png" class="d-block w-100" alt="..."></a>
				<div class="carousel-caption d-none d-md-block">
				
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<div id="products_select_div">
		<select id="p_main_sort" name="p_sort" onchange="productsSort(1)">			
			<option value="p_name">이름순</option>
			<option value="p_cnt">구매순</option>
			<option value="p_priceTohigh">높은가격순</option>
			<option value="p_priceToLow">낮은가격순</option>
		</select>
	</div>
	<div style="clear: both;"></div>
	<input id="p_type" type="hidden" value="${param.p_type }">
	
	<div id="products_div">
	</div>
	
	<div id="products_div_first">
		<div class="row">
		 	<c:forEach var="p" items="${products }">
				<div class="col-sm-12 col-lg-2 col-md-2 product_div" id="product_div">
					<a href="product.detail?p_no=${p.p_no }">
						<div><img id="product_img_div" class="container" src="resources/file/${p.p_img }"></div>
						<div id="product_name_div" style="display: flex; justify-content: center;">${p.p_name }</div>
						<div id="product_price_div"  style="display: flex; justify-content: center;">${p.p_price }</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<nav aria-label="Page navigation example">
  		<ul class="pagination justify-content-center">
    
   			<c:forEach var="pageNo" begin="1" end="${pageCount }">
    			<li class="page-item"><div id="page${pageNo }" class="page-link" onclick="productsSort(${pageNo});">${pageNo }</div></li>
 			</c:forEach>
    
  		</ul>
	</nav>
</div>	
	</div>
</body>
</html>