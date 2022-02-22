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
	<div id="products_banner">보충제</div>
	<c:forEach var="p" items="${products }">
		<div id="product_div">
			<a href="product.detail?p_no=${p.p_no }">
				<div id="product_img_div"><img class="container" src="resources/img/products/${p.p_img }.jpg"></div>
				<div id="product_name_div">${p.p_name }</div>
				<div id="product_price_div">${p.p_price }</div>
			</a>
		</div>
	</c:forEach>
</body>
</html>