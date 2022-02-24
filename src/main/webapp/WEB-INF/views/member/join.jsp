<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}

</style>
<script type="text/javascript">
$(function() {
	

// 이미지 미리보기
function readImage(input) {

    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {

        // 이미지 파일인지 검사 
		
        
        // FileReader 인스턴스 생성
        const reader = new FileReader();

        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image");
            previewImage.src = e.target.result;
        }

        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    };
}

// input file에 change 이벤트 부여
const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {
    readImage(e.target)
});



// 이메일 중복 검사(1 = 중복 / 0 != 중복)
$("#m_email").keyup(function() {
	// id = "m_email"
	var regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	var user_id = $('#m_email').val();
	// alert(user_id)
	$.ajax({
		url : '${pageContext.request.contextPath}/member.emailCheck?m_email='+ user_id,
		type : 'get',
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#id_check").text("이미 사용중인 이메일입니다.");
					$("#id_check").css("color", "red");
					$("#m_email").focus();
					$("#reg_submit").attr("disabled", true); // reg_submit 버튼
				} else {
					if(regEmail.test(user_id)){
						// 0 : 아이디 길이 / 문자열 검사
						$("#id_check").text("사용 가능한 이메일입니다.");
						$("#id_check").css("color", "green");
						$("#reg_submit").attr("disabled", false);
			
					} 
					
					else if(user_id == ""){
						$('#id_check').text('이메일을 입력해주세요.');
						$('#id_check').css('color', 'red');
						$("#m_email").focus();
						$("#reg_submit").attr("disabled", true);				
						
					} else {
						$('#id_check').text("이메일을 올바르게 입력해주세요.");
						$('#id_check').css('color', 'red');
						$("#m_email").focus();
						$("#reg_submit").attr("disabled", true);
					}
				}
			}, error : function() {
					console.log("실패");
			}
		});
	});


});


</script>
</head>
<body>

<form action="member.join.do" method="post" enctype="multipart/form-data">
	<div class="wrap contain">
		<div class="join" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; text-align: center;">Sing
				up</h1>
			<div class="join_id">
				<div style="display: flex; align-items: center;">
				<h4>Email</h4><span class="ps-1" style="color: #50bcdf;">※ 아이디 비밀번호 분실시 필요한 정보이므로 정확하게 기입해주세요.</span>
				</div>
				<input type="email" name="m_email" id="m_email" placeholder="Email" style="width: 100%" required="required">
				<span class="ps-1" id="id_check" style="color: green;"></span>
				<input type="hidden" id=""/>
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Password</h4>
				</div>
				<input type="password" name="m_pw" id="userpass" placeholder="Password" maxlength="16" autocomplete="off">
					<span class="ps-1 successPw" style="color: green;"></span>
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Confirm Password</h4>
				</div>
				<input type="password" name="m_pw2" id="userpasschk" placeholder="Confirm Password" maxlength="16" autocomplete="off" required="required">
				<input type="hidden" id="pwDoubleChk"/>
				   <span class="ps-1 successPwChk" style="color: green;"></span>
			</div>
			<div class="join_pw">
				<h4>Name</h4>
				<input type="text" name="m_name" id="m_name" placeholder="Name">
				   <span class="ps-1" id="name_check" style="color: #50bcdf;"></span>
			</div>
			<div class="join_pn">
				<div style="display: flex; align-items: center;">
				<h4>Phone Number</h4><span class="ps-1" style="color: #50bcdf;">※ '-'없이 번호만 입력해주세요</span>
				</div>
				<div style="display: flex;">
				<input type="tel" name='m_phone' maxlength="11" id="phone" placeholder="휴대폰 번호 11자리를 입력해주세요" style="width: 75%" required="required" > 
				<input type="button" name='' id="phoneChk" value="휴대폰 인증" style="text-align: center; width: 25%" disabled="disabled">
				</div>
				<span class="ps-1" id="phone_check"></span>
				<div style="display: flex; align-items: center;">
				<input type="number" id="phone2" name="phone2"  maxlength="4"  style="width: 38%" placeholder="인증번호를 입력해주세요."  disabled="disabled">
				<input type="button" id="phoneChk2" style="width: 25%; display: none;" value="확인" style="text-align: center">
				<span class="successPhoneChk mt-1 ps-1" style="color: #50bcdf;">※ 휴대폰 번호 입력 후 휴대폰 인증을 해주세요.</span>
				</div>
				<input type="hidden" id="phoneDoubleChk"/>
			</div>
			<div class="join_addr">
				<h4>Address</h4>
				<div
					style="display: flex; justify-content: center; align-items: center;">
					<input id="jm_addr3Input" readonly="readonly" name="m_addr3"
						maxlength="5" autocomplete="off" placeholder="Postal Code"
						style="width: 92%"> <span id="addrSearchBtn">[Search]</span>
				</div>
				<input id="jm_addr1Input" readonly="readonly" name="m_addr1"
					maxlength="30" autocomplete="off" placeholder="Address line1"><br>
				<input name="m_addr2" maxlength="30" autocomplete="off"
					placeholder="Address line2">
			</div>
			<div class="image-container">
				<h4>Profile Picture</h4>
				<input style="display: block;" type="file" id="input-image" name="m_photo"
					class="mt-3" accept="image/*" /> <img
					style="width: 100%; height: 250px; max-width:750px; display: visibility:;"
					id="preview-image"
					src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
			</div>
			<div class="submit">
				<button id="reg_submit">submit</button>
			</div>
		</div>
	</div>
</form>

</body>
</html>