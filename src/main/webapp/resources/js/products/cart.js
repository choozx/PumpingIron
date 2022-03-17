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

$(function () {
	addCart();
})