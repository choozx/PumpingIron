<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style type="text/css">
img {
max-width: 200px;}
</style>
</head>
<body class="main-bg">
<div class="title-center text-center ">

<a href="tips/tips.jsp">
<span class="prompt-h1">review</span>
</a>
</div>

<div class="write-wrapper container">
<div class="write-input-top d-flex mb-4">
<span class="m-0 sub-title noto-pb">작성자</span>
<span class="noto-pb mr-2">${sessionScope.loginMember.m_name }</span>

</div>

<form action="update.do" id="common-edit-form" onsubmit="return updateContennt();" method="get">


<script type="text/javascript">
var up = "<c:out value="${tippp.cr_no}"></c:out>";


</script> 
<div class="d-flex justify-content-center mb-4">
<span class="m-0 sub-title noto-pb pt-3">제목</span>
<input class="common-oneline-input" type="text" name="cr_title"
 maxlength="100" placeholder="제목을 입력해주세요" value="${tippp.cr_title }">

</div>
 <textarea id="summernote" name="cr_content">${tippp.cr_content }</textarea>
 
 
 
    <script>
    $(document).ready(function() {
      $('#summernote').summernote({
        height: 400,
        callbacks:{
        	onImageUpload: function (files, editor, welEditable) {
				console.log('aaaaa')
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
			url : "/pi/summorFileUpload",
			cache : false,
			contentType : false,
			processData : false,
			success : function (data) {
				$(editor).summernote('editor.insertImage',data.url);
				console.log(data.url)
			}
		});
		
		}
    </script>


<div class="write-bottom">
<a class="border-b-btn board-btn noto-h4 text-center"
href="javascript:history.back();" type="button">취소</a>

<button class="ml-3 background-b-btn board-btn noto-h4" data-type="board" data-category-id="8"
 data-id >수정</button>
<input name="cr_no" value="${param.cr_no }" type="hidden">
<input id="iii" name="iii" type="hidden">

</div>
</form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</body>
</html>