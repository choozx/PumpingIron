function deleteContent(n) {
	
	let aa = $("span p img").attr("src");
	console.log(aa);
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delete2.do?c2_no=" + n + "&iii=" + aa ;
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

function deleteReply2(n,n2) {
	
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delReply2.do?c2r_no=" + n + '&c2_no=' + n2;
	}
}

function updateReply2(n, n2, t) {
	t = prompt("댓글", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "upReply2.Do?c2r_no=" + n + "&c2r_text=" + t + "&c2_no=" + n2;
	}
}


	
	
	
	
	
	
	
	

	
