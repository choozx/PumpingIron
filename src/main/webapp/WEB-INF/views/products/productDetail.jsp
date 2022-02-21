<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="product_selector" class="container">
		<input type="button" value="보충제">
		<input type="button" value="그립/스트랩">
		<input type="button" value="팔꿈치 보호대">
		<input type="button" value="등/허리">
		<input type="button" value="무릅 보호대">
		<input type="button" value="신발">
	</div>
	<div id="product_detail_div" class="container">
		<div id="product_detail_img_div"><img src="resources/img/products/${product.p_img }.jpg"></div>
		<div id="product_info">
			<div id="product_name">보충제1</div>
			<div id="product_star">별점</div>
			<div id="product_price">1000</div>
			<div id="product_option">옵션</div>
			<div id="product_quantity">수량</div>
			<div><img id="kakao_pay" src="resources/img/products/payment_icon_yellow_small.png"></div>
		</div>
	</div>
</body>
</html>