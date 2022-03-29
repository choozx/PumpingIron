<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){
		total_cart();
	})
</script>
<body>
	<div id="myCart_all_div" class="container">
	<div id="cart_name">내가 담은 상품</div>
		<c:forEach var="c" items="${myCart }">
			<div id="product_cart_div">
				<div id="product_cart_img_div"><img id="product_cart_img_div" class="container" src="resources/file/${c.p_img }"></div>
				<a href="product.detail?p_no=${c.p_no }">
					<div id="product_cart_name_div">${c.p_name }</div>
				</a>
				<div id="product_cart_price_div"><input type="hidden" name="products_cart_price" id="products_cart_price" value="${c.p_price }"> ${c.p_price }</div>
				<div id="cart_quantity_div">수량:<input type="number" name="cart_quantity" onchange="total_cart();" id="cart_quantity" value="1" min="1"/></div>
				<div><img id="cartDel" onclick="delCart(${c.p_no});" src="resources/img/products/x-del.png"></div>
			</div>
		</c:forEach>
	<div style="clear: both;"></div>
	<div id="itemTotalVol_html">총 수량:</div>
	<div id="itemTotalVol"></div>
	<div id="itemTotalPrice_html">합계:</div>
	<div id="itemTotalPrice"></div>

	<input id="product_name" type="hidden" name="totalName" value="${myCart[0].p_name } + 외 (${myCart.size() - 1 } )">
	<input id="total_amount" type="hidden" name="totalPrice" >
    <input id="quantity" type="hidden" name="totalVol">
    
    <input id="member" type="hidden" value="${sessionScope.loginMember }"> 
    <input id="member_addr" type="hidden" value="${sessionScope.loginMember.m_addr }">
	<input id="member_email" type="hidden" value="${sessionScope.loginMember.m_email }">
	<input id="member_name" type="hidden" value="${sessionScope.loginMember.m_name }">			
	<input id="member_phone" type="hidden" value="${sessionScope.loginMember.m_phone }">						
    
	<div id="kakao_pay_div"><img id="kakao_pay" src="resources/img/products/payment_icon_yellow_small.png"></div>
	</div>
	
</body>
</html>