<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

div h4{
	color: #333;
	
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

});


</script>
</head>
<body>

<form action="member.update" method="post" enctype="multipart/form-data" name="infoForm" onsubmit="return infoCheck();">
	<div class="wrap contain">
		<div class="join" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; text-align: center;">회원정보 수정</h1>
			<div class="join_id">
				<div style="display: flex; align-items: center;">
				<h4>Email</h4>
				</div>
				<div>
					<h5>${sessionScope.loginMember.m_email}</h5>
				</div>
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Password</h4>
				</div>
				<input type="password" name="m_pw" id="userpas" placeholder="Password" maxlength="16" autocomplete="off">
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>New Password</h4>
				</div>
				<input type="password" name="m_pw2" id="userpassch" placeholder="New Password" maxlength="16" autocomplete="off" >
				<input type="hidden" id="pwDoubleChk"/>
				   <span class="ps-1 successPw" style="color: green;"></span>
			</div>
			<div class="join_pw">
				<div style="display: flex; align-items: center;">
				<h4>Confirm New Password</h4>
				</div>
				<input type="password" id="userpassch2" name="m_pw2Chk" placeholder="Confirm New Password" maxlength="16" autocomplete="off" >
				<input type="hidden" id="pwDoubleChk"/>
				   <span class="ps-1 successPwChk" style="color: green;"></span>
			</div>
			<div class="join_pw">
				<h4>Name</h4>
				<div>
					<h5>${sessionScope.loginMember.m_name}</h5>
				</div>
			</div>
			<div class="join_pn">
				<div style="display: flex; align-items: center;">
				<h4>Phone Number</h4>
				</div>
				<div>
					<input type="tel" name='m_phone' maxlength="11" id="phone" placeholder="휴대폰 번호 11자리를 입력해주세요" required="required" value="${sessionScope.loginMember.m_phone}" style="width: 100%;"> 
				</div>
				<input type="hidden" id="phoneDoubleChk"/>
			</div>
			<div class="join_addr">
				<h4>Address</h4>
				<div
					style="display: flex; justify-content: center; align-items: center;">
					<input id="jm_addr3Input" readonly="readonly" name="m_addr3"
						maxlength="5" autocomplete="off" placeholder="Postal Code"
						style="width: 92%" value="${addr[2] }"> <span id="addrSearchBtn">[Search]</span>
				</div>
				<input id="jm_addr1Input" readonly="readonly" name="m_addr1"
					maxlength="30" autocomplete="off" placeholder="Address line1" value="${addr[0] }"><br>
				<input name="m_addr2" maxlength="30" autocomplete="off"
					placeholder="Address line2" value="${addr[1] }">
			</div>
			<div class="image-container">
				<h4>Profile Picture</h4>
				<img src="resources/files/${sessionScope.loginMember.m_photo }" style="width: 200px; height: 200px;">
				<input style="display: block;" type="file" id="input-image" name="m_photo"
					class="mt-3" accept="image/*" /> <img
					style="width: 100%; height: 250px; max-width:750px; display: visibility:; text-align: center;"
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