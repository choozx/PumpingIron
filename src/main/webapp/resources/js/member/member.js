// 회원 탈퇴
function withdraw() {
	var ok = confirm("정말 탈퇴하시겠습니까?");
	let withdrawPw = document.getElementById('m_pw');

	if (isEmpty(withdrawPw)) {

		alert('비밀번호를 입력해주세요')

		withdrawPw.focus();
		withdrawPw.value == "";

		return false;

	}

	
	if (ok) {
		return true;
	} else{
		return false;
	}
}


// 아이디/비밀번호 찾기 체크 버튼에 따라
function search_check(num) {
	if (num == '1') {
		document.getElementById("searchP").style.display = "none";
		document.getElementById("searchI").style.display = "";	
	} else {
		document.getElementById("searchI").style.display = "none";
		document.getElementById("searchP").style.display = "";
	}
}



$(function() {
	
	
// 아이디 값 받고 출력하는 ajax
$('#searchBtn').click(function(){
	var idV = "";
	var m_name = $('#m_name').val();
	var m_phone = $('#m_phone').val();
	
	function masking(email) {

		   const len = email.split('@')[0].length - 3;

		   return email.replace(new RegExp('.(?=.{0,' + len + '}@)', 'g'), '*');

		}
	//	console.log(masking('test0808@naver.com'));

	//  console.log(masking('hello@google.com'));
	
	
	$.ajax({
		type:"POST",
		url:"/pi/member.searchId.do",
		data : {
					m_name : m_name,
					m_phone : m_phone
					},	
		success:function(data){
			if(data == 0){
				$('#id_value').text("존재하지 않는 회원입니다.");	
			} else {
		//		console.log(masking(data));
		// 아이디 찾기(마스킹)		
				$('#id_value').text(masking(data));
				
			}
		}
	});
});


// 아이디 찾기 후에 비밀번호 찾기 눌렀을 때
$('#pwSearch_btn').click(function(){		
	
	
	// 1. 패스워드 찾기 창으로 이어지고
	$('#search_2').prop("checked", true);
	
	// 2. 메서드 호출
	search_check(2);
	
	// 3. 모달창 닫기
	$('#staticBackdrop').modal('hide');
	
	
});


//비밀번호 찾기 이메일로 보내기
$('#searchBtn2').click(function(){
	console.log("패스워드 찾기 : ajax 들어가기 전");
	console.log($('#inputEmail_2').val());
	console.log($('#inputPhone_2').val());
	var m_email = $('#inputEmail_2').val();
	var m_phone = $('#inputPhone_2').val();
	$.ajax({
		type : "get",
		url : "member.searchPw.do",
		data : {
			m_email : m_email,
			m_phone : m_phone
		},
		success : function(data){
					
			if(data == 0){
			   alert("존재하지 않는 회원입니다.")
			} else if (data == -4) { // 비밀번호 오류라면?
				alert("회원정보를 올바르게 입력해주세요.")
			}else {
				alert("해당 이메일로 임시 비밀번호를 발송하였습니다.");
			}
		}
	});
	
});





});
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
					$(".successPhoneChk").css("color", "red");
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

	
	
	
// 로그인 할 때 유효성 검사
	$('#loginBtn').click(function() {
		var m_email = $('#m_email').val();
		var m_pw = $('#m_pw').val();
		var remember_us = $('#remember_us').is(':checked');
		

		if (m_email == "" || m_pw == "") {
			alert('정보를 올바르게 입력해주세요.')
			return false;
		}
		
		$.ajax({
			type : 'post',
			url : "/pi/member.login.do",
			data : {
				m_email : m_email,
				m_pw : m_pw,
				remember_userId : remember_us
				},
				success : function(data) {
		
					console.log(data);
					if (data == 0) { // 없는 회원일 경우
						$('#spanLoginCheck').text('존재하지 않는 회원입니다.');
						$("#spanLoginCheck").css("color", "red"); 
					} else if (data == -2) { //인증하지 않았다면?
						console.log(data);
						$('#spanLoginCheck').text('이메일을 통하여 이메일인증을 해주시길 바랍니다.');
						$("#spanLoginCheck").css("color", "red"); 
						
					} else if (data == -3) { // 아이디가 사용중이라면?
						console.log(data);
						location.href = '/pi/member.login.go?m_email=' + m_email + '&m_pw=' + m_pw + '&remember_userId=' + remember_us;
						
					} else if (data == -4) { // 비밀번호 오류라면?
						console.log(data);
						$('#spanLoginCheck').text('로그인 정보를 정확히 입력해주세요.');	
						$("#spanLoginCheck").css("color", "red"); 
					} else { //로그인 성공시
						console.log(data);
						location.href = '/pi/index.go';
					}
				}
			});
		});
	

	
});

