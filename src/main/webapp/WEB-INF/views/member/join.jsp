<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	

function readImage(input) {

    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {

        // 이미지 파일인지 검사 (생략)

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

// 핸드폰 번호 11자리 입력

$("#phone").on("input",function(){
	if(this.value.length < 11) { 
		$("#phoneChk").attr("disabled",true);
		
	} else{
		$("#phoneChk").attr("disabled",false);
	}
});


});

function maxLengthCheck(object){
    if (object.value.length > object.maxLength){
        object.value = object.value.slice(0, object.maxLength);
    }    
}
</script>
</head>
<body>
	<div class="wrap contain">
		<div class="join" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; text-align: center;">Sing
				up</h1>
			<div class="join_id">
				<div style="display: flex; align-items: center;">
				<h4>Email</h4><span class="ps-1" style="color: #50bcdf;">※ 아이디 비밀번호 분실시 필요한 정보이므로 정확하게 기입해주세요.</span>
				</div>
				<div style="display: flex;">
				<input type="email" name="" id="" placeholder="Email" style="width: 75%" required="required">
				<input type="button" name='' id="" value="이메일 인증" style="text-align: center; width: 25%">
				</div>
				<div style="display: flex; align-items: center;">
				<input type="number" id="" name=""  maxlength="4"  style="width: 38%" placeholder="인증번호를 입력해주세요." oninput="maxLengthCheck(this)" disabled="disabled">
				<input type="button" id="" style="width: 25%; display: none;" value="확인" style="text-align: center">
				<span class="mt-1 ps-1" style="color: red;">※ 이메일 입력 후 이메일 인증을 해주세요.</span>
				</div>
				<input type="hidden" id=""/>
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Password</h4><span class="ps-1" style="color: red;">※ 비밀번호는 총 8~16자까지 입력해주세요.</span>
				</div>
				<input type="password" name="" id="userpass" placeholder="Password" maxlength="16" autocomplete="off">
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Confirm Password</h4><span class="ps-1 successPwChk" style="color: green;"></span>
				</div>
				<input type="password" name="" id="userpasschk" placeholder="Confirm Password" maxlength="16" autocomplete="off" required="required">
				<input type="hidden" id="pwDoubleChk"/>
			</div>
			<div class="join_pw">
				<h4>Name</h4>
				<input type="text" name="" id="" placeholder="Name">
			</div>
			<div class="join_pn">
				<h4>Phone Number</h4>
				<div style="display: flex;">
				<input type="tel" name='phone' maxlength="11" id="phone" placeholder="휴대폰 번호 11자리를 입력해주세요" oninput="maxLengthCheck(this)" style="width: 75%" required="required" > 
				<input type="button" name='' id="phoneChk" value="휴대폰 인증" style="text-align: center; width: 25%" disabled="disabled">
				</div>
				<div style="display: flex; align-items: center;">
				<input type="number" id="phone2" name="phone2"  maxlength="4"  style="width: 38%" placeholder="인증번호를 입력해주세요." oninput="maxLengthCheck(this)" disabled="disabled">
				<input type="button" id="phoneChk2" style="width: 25%; display: none;" value="확인" style="text-align: center">
				<span class="successPhoneChk mt-1 ps-1" style="color: red;">※ 휴대폰 번호 입력 후 휴대폰 인증을 해주세요.</span>
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
				<input style="display: block;" type="file" id="input-image"
					class="mt-3"> <img
					style="width: 100%; height: 250px; max-width:750px; display: visibility:;"
					id="preview-image"
					src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
			</div>
			<div class="submit">
				<input type="submit" value="submit">
			</div>
		</div>
	</div>
</body>
</html>