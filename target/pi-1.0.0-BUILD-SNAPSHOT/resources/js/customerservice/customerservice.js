// 공지사항&이벤트 글 삭제
function eventDelete(no) {
	let img = $("div p img").attr("src");
	// alert(img);
	let e_no = no;
	var ok = confirm("정말 삭제하시겠습니까?");
	
	if(ok){
		location.href='customerservice.event.delete?e_no=' + e_no + '&img=' + img;
	} else{
		return false;
	}
	
}
/*// 공지사항&이벤트 글 상세정보
function eventUpdate(no) {
	let img2 = $("div p img").attr("src");
	let e_no = no;
	
	let img = document.getElementById('img');
	img.value = img2;
}*/


