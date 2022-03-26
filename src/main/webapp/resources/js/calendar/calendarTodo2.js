
function login_check() {
	
	login = document.getElementById('loginCheck').value;
	console.log(login);
	
	if (login == '' || login == null) {
		alert('회원전용 기능입니다!');
		location.href = "/member.login.go";
	}
	
}


