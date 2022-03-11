// 유효성검사할때 사용할 라이브러리

// <input>을 넣었을때
// 비어있으면 true, 글자가 들어있으면 false
function isEmpty(input) {
	return (!input.value);
}

// <input>, 글자수를 넣었을때
// 글자수가 모자라면 true, 괜찮으면 false
function lessThan(input, len) {
	return (input.value.length < len);
}

// <input>을 넣었을때
// 영어, 숫자이외의 것이 있으면 true, 아니면 false
function containsHS(input) {
	var txt = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@_.";
	for (var i = 0; i < input.value.length; i++) {
		if (txt.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

// <input> 두 개 넣었을때
// 두 개 내용이 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return (input1.value != input2.value);
}

// <input>, 문자열세트를 넣었을때
// 문자열세트에 포함된게 없으면 true, 있으면 false
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input>을 넣으면
// 거기에 숫자 아닌거 있으면 true, 숫자만 있으면 false
function isNotNumber(input) {
	return isNaN(input.value);
}

// <input>, 확장자를 넣으면
// 그 파일이 아니면 true, 맞으면 false
function isNotType(input, type){
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}









