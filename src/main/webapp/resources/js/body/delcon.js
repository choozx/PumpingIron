function deleteContent(n) {
	
	let aa = $("span p img").attr("src");
	console.log(aa);
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delete3.do?br_no=" + n + "&iii=" + aa ;
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

function deleteReply3(n,n2) {
	
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delReply3.do?brr_no=" + n + '&br_no=' + n2;
	}
}

function updateReply3(n, n2, t) {
	t = prompt("댓글", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "upReply3.do?brr_no=" + n + "&brr_text=" + t + "&br_no=" + n2;
	}
}


	
	
	
	
	
	
	
	

	
