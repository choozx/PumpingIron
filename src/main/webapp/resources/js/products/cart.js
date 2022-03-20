function addCart() {
	$("#addCart").click(function() {
		let member = $("#member").val();
		
		if (member == null || member == "") {
			alert("로그인이 필요한 서비스입니다");
			return false;
		}
		
		let p_no = $('#p_no').val();
		
		$.ajax({
			url: "/pi/add.cart",
			type: 'GET',
			data: {
				"p_no" : p_no
			},
			success : function(data) {
				console.log(data)
				if (data == 1) {
					alert("장바구니 추가 완료");
				} else if (data == 2) {
					alert("이미 존재하는 상품입니다");
				}
			},
			error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		    }
		})
	})
}

function delCart(p_no) {
	
	$.ajax({
		url: "/pi/cart.del",
		type: 'GET',
		data: {
			"p_no" : p_no
		},
		success : function(data) {
			console.log(data)
			location.href='cart.go';
		},
		error:function(request,status,error){
	        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
	    }
	})
}


function total_cart() {
	let quantity = $('input[name="cart_quantity"]');
	let price = $('input[name="products_cart_price"]');
	let sum = 0;
	var count = price.length;
	var itemvol = 0;
	
	for (var i = 0; i < count; i++) {
		sum += parseInt(price[i].value) * parseInt(quantity[i].value);
		itemvol += parseInt(quantity[i].value);
	}
	
	var summ = new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' }).format(sum);
	
	$("#itemTotalPrice").html(summ);
	$("#itemTotalVol").html(itemvol);
	$("#total_amount").val(sum);
	$("#quantity").val(itemvol);
	
}

$(function () {
	addCart();
	total_cart();
	delCart(p_no);
})