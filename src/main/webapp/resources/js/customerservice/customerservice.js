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

// 고객센터(자주찾는질문) 글 삭제
function questionDelete(no) {
	let q_no = no;
	var ok = confirm("정말 삭제하시겠습니까?");
	
	if(ok){
		location.href='customerservice.delete?q_no=' + q_no 
	} else{
		return false;
	}
}

//고객센터(1:1문의답변) 글 삭제
function answerDelete(no) {
	let ia_no = no;
	var ok = confirm("정말 삭제하시겠습니까?");
	
	if(ok){
		location.href='customerservice.inquiry.answerDelete?ia_no=' + ia_no 
	} else{
		return false;
	}
}

// Pumping Iron에 바란다 답변 삭제
function requestADelete(no) {
	let ra_no = no;
	var ok = confirm("정말 삭제하시겠습니까?");
	
	if(ok){
		location.href='customerservice.request.answerDelete?ra_no=' + ra_no 
	} else{
		return false;
	}
}

// 제휴문의 유효성 검사
function associateCheck() {
	var nameInput = document.associateForm.m_name;
	var emailInput = document.getElementById('associate_email');
	var phoneInput = document.associateForm.m_phone;
	var contentInput = document.getElementById('associate_content');
	var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
	
	
	
	if (isEmpty(nameInput)) {
		alert("이름을 입력해주세요.");
		nameInput.focus();
		return false;
    }else if(!emailRule.test($("input[id='associate_email']").val())){
		alert('이메일을 올바르게 입력하세요.');
		emailInput.focus();
		return false;		
	}else if(isEmpty(phoneInput)){
		alert('연락처를 입력해주세요.');
		phoneInput.focus();
		return false;
	} else if(isEmpty(contentInput)){
		alert('제휴내용을 입력해주세요.')
		contentInput.focus();
		return false;
	}
	
 return true;
}

// 검색 기능 공백 체크
function eventSearchCheck() {
	let searchInput = document.eventSearchForm.search
	if(isEmpty(searchInput)){
		
		return false;
	}
	
}

// 공지사항&이벤트 글 작성 유효성 검사
function eventCheck() {
	let titleInput = document.getElementById('title');
    let contentInput = document.getElementById('summernote');
    let content = document.getElementById('summernote').value;
    content = content.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
    content = content.replace(/(<([^>]+)>)/ig,"");
    
    if (isEmpty(titleInput)) {
		alert("제목을 입력해주세요.");
		titleInput.focus();
		return false;
    } else if(isEmpty(contentInput)){
    	alert("내용을 입력해주세요.");
    	contentInput.focus();
		return false;
    } else if(content.trim() == ''){
    	alert("내용을 입력해주세요.");
    	contentInput.focus();
		return false;
    }
    return true;
}

// 고객센터 자주찾는질문 유효성 검사
function customerserviceCheck() {
	let titleInput = document.customerserviceForm.q_title;
    let contentInput = document.customerserviceForm.q_content;
    
    if (isEmpty(titleInput)) {
		alert("제목을 입력해주세요.");
		titleInput.focus();
		return false;
    } else if(isEmpty(contentInput)){
    	alert("내용을 입력해주세요.");
    	contentInput.focus();
		return false;
    } 
    return true;
}

//고객센터 1:1문의 유효성 검사
function inquiryCheck() {
	let titleInput = document.getElementById('title');
    let contentInput = document.getElementById('content');
    let fileInput1 = document.getElementById('photo1');
    let fileInput2 = document.getElementById('photo2');
    let fileInput3 = document.getElementById('photo3');
    let fileInput4 = document.getElementById('photo4');

    if (isEmpty(titleInput)) {
		alert("제목을 입력해주세요.");
		titleInput.focus();
		return false;
    } else if(isEmpty(contentInput)){
    	alert("내용을 입력해주세요.");
    	contentInput.focus();
		return false;
    } else if(isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	return true;
    } else if(fileInput1.value != "" && isEmpty(fileInput2) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    } 
    }else if(fileInput2.value != "" && isEmpty(fileInput1) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    }else if(fileInput3.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput4)){
    	if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    }else if(fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput3)){
    	if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput2.value != "" && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput3.value != "" && isEmpty(fileInput2) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput4.value != "" && isEmpty(fileInput2) && isEmpty(fileInput3)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput2.value != "" && fileInput3.value != "" && isEmpty(fileInput1) && isEmpty(fileInput4)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput2.value != "" && fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2)){
    	if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput2.value != "" && fileInput3.value != "" && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput2.value != "" && fileInput4.value != "" && isEmpty(fileInput3)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput2)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput2.value != "" && fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput1)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput2.value != "" && fileInput3.value != "" && fileInput4.value != ""){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    }  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    }
    	
	}
    return true;
}

//Pumping Iron에 바란다 유효성 검사
function requestCheck() {
	let titleInput = document.getElementById('title');
	let contentInput = document.getElementById('content');
	let fileInput1 = document.getElementById('photo1');
	let fileInput2 = document.getElementById('photo2');
	let fileInput3 = document.getElementById('photo3');
	let fileInput4 = document.getElementById('photo4');
	
    if (isEmpty(titleInput)) {
		alert("제목을 입력해주세요.");
		titleInput.focus();
		return false;
    } else if(isEmpty(contentInput)){
    	alert("내용을 입력해주세요.");
    	contentInput.focus();
		return false;
    } else if(isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	return true;
    } else if(fileInput1.value != "" && isEmpty(fileInput2) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    } 
    }else if(fileInput2.value != "" && isEmpty(fileInput1) && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    }else if(fileInput3.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput4)){
    	if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    }else if(fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2) && isEmpty(fileInput3)){
    	if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput2.value != "" && isEmpty(fileInput3) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput3.value != "" && isEmpty(fileInput2) && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput4.value != "" && isEmpty(fileInput2) && isEmpty(fileInput3)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput2.value != "" && fileInput3.value != "" && isEmpty(fileInput1) && isEmpty(fileInput4)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput2.value != "" && fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput1) && isEmpty(fileInput2)){
    	if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    } else if(fileInput1.value != "" && fileInput2.value != "" && fileInput3.value != "" && isEmpty(fileInput4)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput2.value != "" && fileInput4.value != "" && isEmpty(fileInput3)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput2)){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput2.value != "" && fileInput3.value != "" && fileInput4.value != "" && isEmpty(fileInput1)){
    	if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    }
    	
	} else if(fileInput1.value != "" && fileInput2.value != "" && fileInput3.value != "" && fileInput4.value != ""){
    	if(isNotType(fileInput1, "png") && isNotType(fileInput1, "gif")
    			&& isNotType(fileInput1, "jpg") && isNotType(fileInput1,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
    	}  else if(isNotType(fileInput2, "png") && isNotType(fileInput2, "gif")
    			&& isNotType(fileInput2, "jpg") && isNotType(fileInput2,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    } else if(isNotType(fileInput3, "png") && isNotType(fileInput3, "gif")
    			&& isNotType(fileInput3, "jpg") && isNotType(fileInput3,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    }  else if(isNotType(fileInput4, "png") && isNotType(fileInput4, "gif")
    			&& isNotType(fileInput4, "jpg") && isNotType(fileInput4,
    			"bmp")) {
    		alert("파일형식 : 이미지 형식이 아닙니다. \n (png,gif,jpg,bmp형식만 가능합니다)");
    		return false;
	    }
    	
	}
	
	return true;
}

/*// 공지사항&이벤트 글 상세정보
function eventUpdate(no) {
	let img2 = $("div p img").attr("src");
	let e_no = no;
	
	let img = document.getElementById('img');
	img.value = img2;
}*/


