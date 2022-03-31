// 유효성 검사
// 카카오 로그인 추가 정보 입력
function kakaoJoinCheck() {
	var emailInput = document.getElementById('kakaoEmail');
	var phoneInput = document.kakaoJoinForm.m_phone;
	var addr1Input = document.kakaoJoinForm.m_addr1;
	var addr2Input = document.kakaoJoinForm.m_addr2;
	var addr3Input = document.kakaoJoinForm.m_addr3;	
	var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
	var phoneRule = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	
	
	
	if(!emailRule.test($("input[id='kakaoEmail']").val())){
		alert('이메일을 올바르게 입력하세요.');
		emailInput.focus();
		return false;		
	}else if(!phoneRule.test($("input[id='m_phone']").val())){
		alert('핸드폰 번호를 올바르게 입력하세요.');
		phoneInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)) {
		alert("주소를 올바르게 입력하세요.");
		addr2Input.focus();
		return false;
	} 

	

 return true;
}

function kakaoJoinCheck2() {
	var phoneInput = document.kakaoJoinForm.m_phone;
	var addr1Input = document.kakaoJoinForm.m_addr1;
	var addr2Input = document.kakaoJoinForm.m_addr2;
	var addr3Input = document.kakaoJoinForm.m_addr3;	
	var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
	var phoneRule = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	

	
	if(!phoneRule.test($("input[id='m_phone']").val())){
		alert('핸드폰 번호를 올바르게 입력하세요.');
		phoneInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)) {
		alert("주소를 올바르게 입력하세요.");
		addr2Input.focus();
		return false;
	} 
 return true;
}

// 일반 회원가입 
function joinCheck() {
	var addr1Input = document.joinForm.m_addr1;
	var addr2Input = document.joinForm.m_addr2;
	var addr3Input = document.joinForm.m_addr3;	
	var photoInput = document.joinForm.m_photo;
	var phone2Input = document.joinForm.phone2; // 인증번호
	
	
	if(isEmpty(phone2Input)){
		alert("휴대폰 인증을 해주세요.")
		
		return false;
	}else if(isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)){
		
		alert("주소를 올바르게 입력하세요.");
		addr2Input.focus();
		return false;
	} else if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("프로필 사진을 등록해주세요.");
		return false;
	}
	
	 return true;	
}

// 일반회원 정보수정 전 pw체크
function infoPwCheck() {
	var pwInput = document.infoPwForm.m_pw;
	
	if(isEmpty(pwInput)){
		alert("비밀번호를 입력해주세요.")
		
		return false;
  }
 return true;
}

// 일반회원 정보수정 
function infoCheck() {
	var pwInput = document.infoForm.m_pw;
	var newPw = document.infoForm.m_pw2;
	var newPwCheck = document.infoForm.m_pw2Chk;
	var addr1Input = document.infoForm.m_addr1;
	var addr2Input = document.infoForm.m_addr2;
	var addr3Input = document.infoForm.m_addr3;	
	var photoInput = document.infoForm.m_photo;
	
	if(isEmpty(pwInput)){
		alert('비밀번호를 입력해주세요.');
		pwInput.focus();
		return false;
	} else if(notEquals(newPw, newPwCheck)){
		alert('신규 비밀번호가 일치하지 않습니다.')
		newPwCheck.value == "";
		newPwCheck.focus();
		return false;
	} else if(isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)){
		
		alert("주소를 올바르게 입력하세요.");
		addr2Input.focus();
		return false;
	} else if(isEmpty(photoInput)){
		return true;
	}  else if ((isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
		return false;
	}
}



$(function() {
	$("#userpassch").keyup(function(){
		checkPassword($('#userpassch').val());
	});
// 신규 비밀번호 유효성 검사
function checkPassword(password){
    
    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/.test(password)){            
    	$(".successPw").text("비밀번호는 영문, 숫자, 특수문자의 조합으로 8~16자리를 사용해야 합니다."); 
		$("#userpassch").focus();
		$(".successPw").css("color", "red"); 
		$("#reg_submit").attr("disabled", true)
    } else{
    	$(".successPw").text("사용 가능한 비밀번호입니다."); 
    	$(".successPw").css("color", "green"); 
    	$("#reg_submit").attr("disabled", false);
    }
  }

// 신규 비밀번호 일치여부
$("#userpassch2").keyup(function(){ 
	if($("#userpassch2").val() == $("#userpassch").val()){
		$(".successPwChk").text("비밀번호가 일치합니다."); 
		$(".successPwChk").css("color", "green");
		$("#reg_submit").attr("disabled", false);; 
		}else{
			$(".successPwChk").text("비밀번호가 일치하지 않습니다.");
			$("#userpassch2").focus();
			$(".successPwChk").css("color", "red"); 
			$("#reg_submit").attr("disabled", true); } });


});

// 카카오회원 정보수정
function kakaoInfoCheck() {
	var nameInput = document.kakaoInfoForm.m_name;
	var phoneInput = document.kakaoInfoForm.m_phone;
	var addr1Input = document.kakaoInfoForm.m_addr1;
	var addr2Input = document.kakaoInfoForm.m_addr2;
	var addr3Input = document.kakaoInfoForm.m_addr3;	
	var photoInput = document.kakaoInfoForm.m_photo;
	var phoneRule = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	

	
	
	
	if(isEmpty(nameInput)){
		alert('이름을 입력해주세요.');
		pwInput.focus();
		return false;
	} else if(!phoneRule.test($("input[id='m_phone']").val())){
		alert('핸드폰 번호를 올바르게 입력하세요.');
		phoneInput.focus();
		return false;
	} else if(isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)){
		
		alert("주소를 올바르게 입력하세요.");
		addr2Input.focus();
		return false;
		
	} else if (isEmpty(photoInput)) {
		return true; 
	} else if ((isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
		return false;
	}
}