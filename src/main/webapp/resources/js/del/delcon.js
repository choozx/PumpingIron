function deleteContent(n) {
	var ok = confirm("정말 삭제하겠습니까?");
	if (ok) {
		location.href = "delete.do?cr_no=" + n;
	}
}