<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body style="font-size: 13pxt;">
	<div class="container mt-5" style="width: 100%;">
		<div style="display: flex; width: 100%; align-items: center; border-bottom: 2px solid #aaa;">
			<h2>회원탈퇴</h2>
			<span class="ms-3" style="font-size: font-size: 13pt;">회원탈퇴전 다음 사항을 꼭 숙지하시길 바랍니다. </span>
		</div>
		<div class="mt-3">
			<p>- 회원님께서 사이트이용에 대한 불편으로 회원 탈퇴를 원하신다면, 고객센터 요청 또는 ‘Pumping Iron에 바란다’를 통해 불편사항을 해결 하실 수 있습니다.</p>
			<p>- 저희 Pumping Iron은 고객센터를 카카오톡(ID:Pumping Iron), 이메일(customer@pumpingiron.com) 또는 1:1게시판을 통해 운영하고 있습니다.</p>
			<p>- 서비스 이용 중 불편사항은 언제든지 연락 주시면, 최선을 다해 해결 되도록 노력하겠습니다.</p>
		</div>
		<div class="mt-5" style="border: 1px solid gray;" >
			<h2 class="ms-4 mt-3">회원탈퇴 안내</h2>
			<p class="ms-4">· 회원 탈퇴 시 회원님께서 보유하셨던 비현금성 포인트와 마일리지, 회원정보, 거래정보 등은 모두 삭제 됩니다.</p>
			<p class="ms-4">· 회원 탈퇴 후 해지 및 재가입 방지를 목적으로 1개월 동안 회원의 성명, CI, 아이디(ID), 비밀번호(Password), 이메일(E-mail), 연락처 정보를 보관하며, 로그기록, 접속아이피(IP) 정보는 12개월간 보관합니다.</p>
			<p class="ms-4">· 회원 탈퇴 후 재가입 시에는 신규 회원 가입으로 처리되며, 탈퇴 전의 회원정보와 거래정보 및 포인트 등은 복구되지 않습니다.</p>
			<p class="ms-4">· 진행중인 거래 내역이 있거나, 현금성 포인트와 캐시, 상품 및 배너가 전시 되어 있는 경우에는 즉시 탈퇴가 불가능 합니다.</p>
			<table class="ms-4 mb-3" style=" width: 95.8%;">
				<tr style="border-bottom: 1px solid gray; text-align: center; background-color: #eee;">
					<th>즉시 회원 탈퇴가 불가능한 경우</th>
					<th>탈퇴방법</th>
				</tr>
				<tr style="text-align: center;">
					<td>진행중인 거래 내역이 있는 경우</td>
					<td>배송완료 처리 후 회원 탈퇴 가능</td>
				</tr>
			</table>
		</div>
		<form action="member.withdrawal.go">
		<div class="mt-5" style="width:100%; display:flex; justify-content: center;">
			<button class="btn btn-warning" style="width: 160px;">회원탈퇴 신청</button>
			<button type="button" class="btn btn-secondary" style="margin-left: 10px; width: 160px;" onclick="location.href='index.go'">취소</button>
		</div>
		</form>
	
	</div>
</body>
</html>