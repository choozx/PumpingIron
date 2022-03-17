<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="myCart_all_div" class="container">
	<div>내가 담은 상품</div>
		<c:forEach var="c" items="${myCart }">
			<div class="col-sm-12 col-lg-3 product_div" id="product_div">
				<a href="product.detail?p_no=${c.p_no }">
					<div><img id="product_img_div" class="container" src="resources/file/${c.p_img }"></div>
					<div id="product_name_div">${c.p_name }</div>
					<div id="product_price_div">${c.p_price }</div>
				</a>
			</div>
		</c:forEach>
	<div style="clear: both;"></div>
	<div id="kakao_pay_div"><img id="cart_kakao_pay" src="resources/img/products/payment_icon_yellow_small.png"></div>
	</div>
	
</body>
</html>