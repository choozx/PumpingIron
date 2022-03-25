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
</head>
<body>

<form action="customerservice.associate.do" method="post" onsubmit="return associateCheck();" name="associateForm">
	<div class="main container">
		<div class="row mt-5 mb-5">
			<div class="col-sm-12 col-lg-6" style="display: flex; align-items: center;">
				<div class="card flex-start" style="border: none;">
					<div class="card-body">
						<h3 class="card-text text-left">제휴 및 기타 문의 : gr9501@gmail.com</h3>
						<h3 class="mt-3"style="text-align: center;">OR</h3>
						<h3 style="text-align: center;" class="mt-3">QR코드 검색 후 Pumping Iron 1:1 채팅</h3>
						<div style="display: flex; justify-content: center;">
						<img src="resources/img/member/qrcode_350.png" width="200px;" style="text-align: center;">
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-lg-6">
				<div class="card flex-center">
					<div class="card-body">
						<div class="mb-3 mt-3">
							<div style="display: flex; align-items: center;">
							이름
							<svg xmlns="http://www.w3.org/2000/svg" width="8" height="8"
								fill="currentColor" class="bi bi-circle-fill ms-1"
								viewBox="0 0 16 16">
  							<circle cx="8" cy="8" r="8" style="color: red;"/>
							</svg>
							</div>
							<input style="width: 400px;" class="mt-1" name="m_name">
						</div>
						<div class="mb-3">
						<div style="display: flex; align-items: center;">
							이메일
							<svg xmlns="http://www.w3.org/2000/svg" width="8" height="8"
								fill="currentColor" class="bi bi-circle-fill ms-1"
								viewBox="0 0 16 16">
  							<circle cx="8" cy="8" r="8" style="color: red;"/>
							</svg>
						</div>
						<input style="width: 400px;"  class="mt-1" name="m_email" id="associate_email">
						<input type="hidden" name="m_pw" value="gr9501@gmail.com">
						<input type="hidden" name="token" value="${token }">
						</div>
						<div class="mb-3">
						<div style="display: flex; align-items: center;">
							연락처
							<span class="ps-1" style="color: #50bcdf;">※ '-'없이 번호만 입력해주세요.</span>
						</div>
						<input style="width: 400px;"  class="mt-1" type="number" name="m_phone">
						</div>
						<div class="mb-3">
						<div style="display: flex; align-items: center;">
							제휴내용
							<svg xmlns="http://www.w3.org/2000/svg" width="8" height="8"
								fill="currentColor" class="bi bi-circle-fill ms-1"
								viewBox="0 0 16 16">
  							<circle cx="8" cy="8" r="8" style="color: red;"/>
							</svg>
						</div>
						<textarea style="width: 400px; height: 65px;" class="mt-1" name="m_photo" id="associate_content"></textarea>
						</div>
						<div style="display: flex; align-items: center; justify-content: center;">
							<div class="submit">
								<button id="reg_submit">작성</button>
							</div>
						</div>
					</div>
				</div>
			 </div>
		</div>
	</div>
</form>



</body>
</html>