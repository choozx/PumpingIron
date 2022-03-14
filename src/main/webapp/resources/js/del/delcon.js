function deleteContent(n) {
	
	let aa = $("span p img").attr("src");
	console.log(aa);
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delete.do?cr_no=" + n + "&iii=" + aa ;
	}
}

function updateContennt() {
	
	
	let aa = $("p img").attr("src");
	console.log(aa);
	$("#iii").val(aa);
	
	var ok = confirm("정말 수정하시겠습니까?");
	if (ok) {
		return true;
	}else{
		return false;
	}
}

function deleteReply(n,n2) {
	
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delReply.do?crr_no=" + n + '&cr_no=' + n2;
	}
}

function updateReply(n, n2, t) {
	t = prompt("댓글", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "upReply.Do?crr_no=" + n + "&crr_text=" + t + "&cr_no=" + n2;
	}
}

$(function() {
	
	
	$('.material-icons').click(function() {
		
	let idd = $("#likeId").val();
	let emaill = $("#likeEmail").val();
		
	$.ajax({
		url : "/pi/tipsLikes",
		data : {'ajaxId' : idd, 'ajaxEmail' : emaill},
		success : function(data) {
			if(data == 1){
				// 하트 빨강색으로
				$(this).append('<img alt="" src="resources/img/tips/heart-fill.svg" style="width: 18px" value="1">');
				
			}else{
				// 빈 하트로
				$(this).append('<img alt="" src="resources/img/tips/heart.svg" style="width: 18px" value="0">');
			}
		}
	
	});
	
	
	
	
	
	});
	
	
	
	
	
});
