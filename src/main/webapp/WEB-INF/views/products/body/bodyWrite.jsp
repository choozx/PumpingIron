<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body class="main-bg">
<div class="title-center text-center ">

<a href="">
<span class="prompt-h1">bodyprofile</span>
</a>
</div>

<div class="write-wrapper container">
<div class="write-input-top d-flex mb-4">
<span class="m-0 sub-title noto-pb">작성자</span>
<span class="noto-pb mr-2">${sessionScope.loginMember.m_name }</span>

</div>

<form id="common-edit-form" onsubmit="true" action="bodyWrite.do" method="post" >
<div class="d-flex justify-content-center mb-4">
<span class="m-0 sub-title noto-pb pt-3">제목</span>
<input class="common-oneline-input" type="text" name="br_title"
 maxlength="100" placeholder="제목을 입력해주세요" >

</div>
 <textarea id="summernote" name="br_content"></textarea>
 
 
 
    <script>
    $(document).ready(function() {
      $('#summernote').summernote({
        height: 400,
        callbacks:{
        	onImageUpload: function (files, editor, welEditable) {
				console.log('aaaaa');
                sendFile(files[0], this);
        	}
        }
      });
      
	});
    
    function sendFile(file, editor) {
		data = new FormData();
		data.append("uploadFile", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/pi/summorFileUpload3",
			cache : false,
			contentType : false,
			processData : false,
			success : function (data) {
				$(editor).summernote('editor.insertImage',data.url);
				console.log(data.url) // 파일이름
				$("#br_pic").val(data.url);
			}
		});
		
		} // 베이스24코드로 안바꾸고 ajax로 처리 '등록' 누르면 문자열로
    </script>


<div class="write-bottom">
<a class="border-b-btn board-btn noto-h4 text-center"
href="javascript:history.back();" type="button">취소</a>
<input name="token" value="${token }" type="hidden">
<input id="br_pic" name="br_picture" value="" type="hidden">
<button class="ml-3 background-b-btn board-btn noto-h4" name="button1" data-type="board" data-category-id="8"
 data-id>저장</button>



</div>

</form>

</div>
</body>
</body>
</html>