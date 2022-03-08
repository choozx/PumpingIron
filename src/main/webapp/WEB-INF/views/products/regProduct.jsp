<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="resources/css/tips.css">
</head>
<body class="main-bg">
<div class="title-center text-center ">
	<span class="prompt-h1">상품등록</span>
</div>

<div class="write-wrapper container">

	<form id="common-edit-form" onsubmit="true" action="product.reg.do" method="post" enctype="multipart/form-data">
		<div class="d-flex justify-content-center mb-4">
			<div>
			<span class="m-0 sub-title noto-pb pt-3">상품명</span>
			<input class="common-oneline-input" type="text" name="p_name" maxlength="100" placeholder="제목을 입력해주세요" >
			</div>
			<div>
			<span class="m-0 sub-title noto-pb pt-3">상품가격</span>
			<input class="common-oneline-input" type="text" name="p_price" maxlength="100" placeholder="입력" >
			</div>
			<div>
			<span class="m-0 sub-title noto-pb pt-3">상품 타입</span>
			<select name="p_type" >
				<option value="supplements">보충제</option>
				<option value="gripStrap">그립/스트랩</option>
				<option value="elbowProtecter">팔꿈치보호대</option>
				<option value="backWaist">등/허리ㅣ</option>
				<option value="kneeProtecter">무릅보호대</option>
				<option value="shoes">신발</option>
			</select>
			</div>
			<div>
			<span class="m-0 sub-title noto-pb pt-3">상품이미지</span>
			<input class="common-oneline-input" type="file" name="p_img" maxlength="100">
			</div>
		</div>
		<textarea id="summernote" name="p_info"></textarea>
 
 
 
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
			<a class="border-b-btn board-btn noto-h4 text-center" href="javascript:history.back();" type="button">취소</a>
			<button class="ml-3 background-b-btn board-btn noto-h4" name="button1" data-type="board" data-category-id="8" data-id>저장</button>
		</div>

	</form>

</div>
</body>
</html>