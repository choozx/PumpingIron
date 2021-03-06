<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">
	<div id="products_banner"><input id="p_type" type="hidden" value="${param.products }">보충제</div>
	<div id="products_select_div">
		<select id="p_main_sort" name="p_sort">			
			<option value="p_cnt">구매순</option>
			<option value="evaluation_sort">평점순</option>
			<option value="p_priceTohigh">높은가격순</option>
			<option value="p_priceToLow">낮은가격순</option>
		</select>
	</div>
	<div style="clear: both;"></div>
	
	<div id="products_div">
	</div>
	
	<div id="products_div_first">
		<div class="row">
		 	<c:forEach var="p" items="${products }">
				<div class="col-sm-12 col-lg-3 product_div" id="product_div">
					<a href="product.detail?p_no=${p.p_no }">
						<div><img id="product_img_div" class="container" src="resources/file/${p.p_img }"></div>
						<div id="product_name_div">${p.p_name }</div>
						<div id="product_price_div">${p.p_price }</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>