<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript">
$(function() {
	
// DB값 옵션을 select에 셋팅하기
$("#e_type").val("${edetail.e_type}").prop("selected",true);

});
</script>
</head>
<body class="main-bg mt-5">

<form id="common-edit-form" action="customerservice.event.updateDo" method="post" onsubmit="return eventCheck();">
<div class="write-wrapper container">
<div class="write-input-top d-flex mb-5" style="align-items: center;">
<span class="m-0 sub-title noto-pb">말머리</span>
<select id="e_type" name="e_type" style="margin-left: -8px;" value="${edetail.e_type}">
	<option value="공지사항">공지사항</option>
	<option value="이벤트">이벤트</option>
</select>
</div>
<div class="d-flex justify-content-center mb-4"  style="align-items: center;">
<span class="m-0 sub-title noto-pb">제목</span>
<input class="common-oneline-input" type="text" name="e_title" id="title"
 maxlength="100" placeholder="제목을 입력해주세요" value="${edetail.e_title}">

</div>
 <textarea id="summernote" name="e_content" >${edetail.e_content}</textarea>
 
 
 
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

<button class="ml-3 background-b-btn board-btn noto-h4" name="button1" data-type="board" data-category-id="8"
 data-id>수정</button>

<input name="e_no" value="${param.e_no }" type="hidden">
<input id="img" name="img" type="hidden" value="${param.img}">

</div>


</div>
</form>
</body>
</html>