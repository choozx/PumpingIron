function payment() {
	
	let member = $("#member").val();
	
	if (member == null || member == "") {
		alert("로그인이 필요한 서비스입니다");
		return false;
	}
	
	let p_name = $('#product_name').val();
	let total_amount = $('#total_amount').val();
	
	let p_no = $('#product_no').val();	
	let p_quantity = $('#detail_quantity').val();
	
	alert(p_name);
	alert(total_amount);
	
	let m_name = $('#member_name').val();
	let m_email = $('#member_email').val();
	let m_phone = $('#member_phone').val();
	let m_addr = $('#member_addr').val();
	
	let m_addr_split = m_addr.split('!');
			
	var IMP = window.IMP; // 생략가능
	IMP.init('imp60273439');
	IMP.request_pay({
		pg: 'kakaopay.TC0ONETIME', // version 1.1.0부터 지원.
		pay_method: 'card',
	
		merchant_uid: 'test' + new Date().getTime(),
	
		name: p_name,
		amount: total_amount,
		buyer_email: m_email,
		buyer_name: m_name,
		buyer_tel: m_phone,
		buyer_addr: m_addr_split[0] + m_addr_split[1],
		buyer_postcode: m_addr_split[2],
		m_redirect_url : 'redirect url'
	}, function (rsp) {
		console.log(rsp);
		if (rsp.success) {
			if (p_name.indexOf('외') == -1) {								
				location.href='product.buycount?p_no=' + p_no + '&p_cnt=' + p_quantity;
				alert("단일 구매");
			} else {		
				location.href='cart.del.all';
			}
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
		alert(msg);
	});
	
}

function calAmount() {
	let price = $("#product_price").val();
	let quantity = $("#detail_quantity").val();
	
	alert(price);
	alert(quantity);
	
	let total_amount = price * quantity;
	$("#total_amount").val(total_amount);
}


$(function() {
	$("#kakao_pay").click(function() {
		payment();
	})
	
	$("#detail_quantity").change(function() {
		calAmount();
	})
})