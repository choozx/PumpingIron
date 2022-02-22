function payment() {
	
	var p_name = $('#product_name').text();
	var p_price = $('#product_price').text();
	var p_quantity = $('#product_quantity').text();
	
	var total_amount = p_price * p_quantity;
	
	var IMP = window.IMP; // 생략가능
	IMP.init('imp60273439');
	IMP.request_pay({
		pg: 'kakaopay.TC0ONETIME', // version 1.1.0부터 지원.
		pay_method: 'card',
	
		merchant_uid: 'test' + new Date().getTime(),
	
		name: p_name,
		amount: total_amount,
		buyer_email: 'choozx@naver.com',
		buyer_name: '유제현',
		buyer_tel: '010-7192-2785',
		buyer_addr: '서울특별시 강남구 삼성동',
		buyer_postcode: '123-456',
		m_redirect_url : 'redirect url'
	}, function (rsp) {
		console.log(rsp);
		if (rsp.success) {
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

$(function() {
	$("#kakao_pay").click(function() {
		payment();
	})
})