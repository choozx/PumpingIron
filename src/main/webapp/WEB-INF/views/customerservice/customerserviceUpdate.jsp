<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	
	// 내용의 br태그 개행으로 치환하기
	var content = $("#textarea").val();
	content = content.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
	document.getElementById("textarea").value = content
	
		
	// DB값 옵션을 select에 셋팅하기
	$("#q_type").val("${qdetail.q_type}").prop("selected",true);


	// textarea 개행처리
	$(".btn-primary").click(function() {
		var str = $('textarea').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('textarea').val(str);
	 });
});
</script>
</head>
<body>
		<form action="customerservice.update.do" method="post" onsubmit="return customerserviceCheck();" name="customerserviceForm">
			<div class="container mt-5">
			<div class="col-sm-12 col-lg-12">
				<div class="card flex-center" style="border: none;">
					<div class="card-body" style="border: 1px solid gray; width: 800px;">
						<div class="mb-3 mt-3">
							<div class="mt-4">
								<div style="display: flex; justify-content: center;">
									<h4>자주찾는질문 수정</h4>
								</div>
								<span class="m-0 sub-title noto-pb me-2">말머리</span>
								<div class="mt-1">
								<select name="q_type" value="${qdetail.q_type}" id="q_type">
									<option selected="selected" value="주문">주문</option>
									<option value="결제">결제</option>
									<option value="취소">취소/반품/교환</option>
									<option value="배송">배송</option>
									<option value="기타">기타</option>
								</select>
								</div>
							</div>
						</div>
						<input type="hidden" value="${qdetail.q_no}" name="q_no">
						<input type="hidden" name="token" value="${token }">
						<div class="mb-3">
						<div style="display: flex; align-items: center;">
							제목
						</div>
						<input style="width: 770px;"class="mt-1"  name="q_title" type="text" placeholder="제목을 입력해주세요." value="${qdetail.q_title}">
						</div>
						<div class="mb-3">
						<div style="display: flex; align-items: center;">
							내용
						</div>
						<textarea style="width: 770px; height: 200px;" id="textarea" class="mt-1" name="q_content" placeholder="내용을 입력해주세요.">${qdetail.q_content}</textarea>
						</div>
						<div style="display: flex; align-items: center; justify-content: center;">
								<button type="button" class="btn btn-secondary" onclick="history.back(-1)" style="width: 150px;">취소</button>
								<button class="btn btn-primary" style="width: 150px;">수정</button>
						</div>
					</div>
				</div>
			 </div>
			</div>
		</form>
</body>
</html>