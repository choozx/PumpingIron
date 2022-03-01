function deleteContent(n) {
	
	let aa = $("span p img").attr("src");
	console.log(aa);
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delete.do?cr_no=" + n + "&iii=" + aa ;
	}
}

function updateCon(n) {
	
	let aa = $("span p img").attr("src");
	console.log(aa);
	var ok = confirm("정말 수정하시겠습니까?");
	if (ok) {
		location.href = "update.Do?cr_no=" + n + "&iii=" + aa ;
	}
}



