// 주소 찾기
function connectAddrSearchEvent() {

	$("#addrSearchBtn").click(function() { // 주소입력 버튼 클릭시 이벤트 발생
		new daum.Postcode({
			oncomplete : function(data) {
				$("#jm_addr3Input").val(data.zonecode);
				$("#jm_addr1Input").val(data.roadAddress);
			}
		}).open();
	});
}

$(function() {

	connectAddrSearchEvent();

});


// 휴대폰 인증번호
$(function() {
	
	//모든 공백 체크 정규식
	var empJ = /\s/g;
	//아이디 정규식
	var idJ = /^[a-z0-9]{4,12}$/;
	// 비밀번호 정규식
	var pwJ = /^[A-Za-z0-9]{4,12}$/; 
	// 이름 정규식
	var nameJ = /^[가-힣]{2,6}$/;
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	
	

	let code2 = "";
	$("#phoneChk").click(function() {
		alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
		let phone = $("#phone").val();
		console.log(phone);

		$.ajax({
			type : "GET",
			url : "phoneCheck?m_phone=" + phone,
			cache : false,
			success : function(data) {
				if (data == "error") {
					alert("휴대폰 번호가 올바르지 않습니다.")
					$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
					$(".successPhoneChk").css("color", "red");
					$("#phone").attr("autofocus", true);
				} else {
					$("#phone2").attr("disabled", false);
					$("#phoneChk2").css("display", "inline-block");
					$(".successPhoneChk").text("인증번호를 입력한 뒤 확인을 눌러주십시오.");
					$(".successPhoneChk").css("color", "green");
					$("#phone").attr("readonly", true);
					code2 = data;
				}
			}
		});
	});

// 인증번호 일치 여부
	$("#phoneChk2").click(function() {
		if ($("#phone2").val() == code2) {
			$(".successPhoneChk").text("인증번호가 일치합니다.");
			$(".successPhoneChk").css("color", "green");
			$("#phoneDoubleChk").val("true");
			$("#phone2").attr("disabled", true);
		} else {
			$(".successPhoneChk").text("인증번호가 일치하지 않습니다.");
			$(".successPhoneChk").css("color", "red");
			$("#phoneDoubleChk").val("false");
			$(this).attr("autofocus", true);
		}
	});

// 휴대폰 유효성 검사
	$('#phone').keyup(function(){
		if(phoneJ.test($(this).val()) && this.value.length == 11 ){
			console.log(nameJ.test($(this).val()));
			$("#phone_check").text('');
			$("#phoneChk").attr("disabled",false);
		} else {
			$('#phone_check').text('휴대폰 번호를 올바르게 입력해주세요.');
			$('#phone_check').css('color', 'red');
			$("#phoneChk").attr("disabled",true);
		}
	});
	
// 이름 유효성 검사
	$("#m_name").keyup(function() {
		if (nameJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#name_check").text('');
				$("#reg_submit").attr("disabled", false)
		} else {
			$('#name_check').text('이름을 확인해주세요');
			$('#name_check').css('color', 'red');
			$("#reg_submit").attr("disabled", true)
		}
	});
	
	
// 비밀번호 유효성 검사


	$("#userpass").keyup(function(){
	    checkPassword($('#userpass').val());
	});
	
	function checkPassword(password){
	    
	    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/.test(password)){            
	    	$(".successPw").text("비밀번호는 영문, 숫자, 특수문자의 조합으로 8~16자리를 사용해야 합니다."); 
			$("#userpass").focus();
			$(".successPw").css("color", "red"); 
			$("#reg_submit").attr("disabled", true)
	    } else{
	    	$(".successPw").text("사용 가능한 비밀번호입니다."); 
	    	$(".successPw").css("color", "green"); 
	    	$("#reg_submit").attr("disabled", false);
	    	
	  
	    
	
	}
	}
// 비밀번호 확인	
	$("#userpasschk").keyup(function(){ 
		if($("#userpasschk").val() == $("#userpass").val()){
			$(".successPwChk").text("비밀번호가 일치합니다."); 
			$(".successPwChk").css("color", "green");
			$("#reg_submit").attr("disabled", false);; 
			}else{
				$(".successPwChk").text("비밀번호가 일치하지 않습니다.");
				$("#userpasschk").focus();
				$(".successPwChk").css("color", "red"); 
				$("#reg_submit").attr("disabled", true); } });

	
	
});
