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

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script src="resources/summernote-0.8.18-dist/summernote-lite.js"></script>
<script src="resources/summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/summernote-0.8.18-dist/summernote-lite.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body class="main-bg">
<div class="title-center text-center ">

<a href="tips/tips.jsp">
<span class="prompt-h1">Q/A</span>
</a>
</div>

<div class="write-wrapper container">
<div class="write-input-top d-flex mb-4">
<span class="m-0 sub-title noto-pb">작성자</span>
<span class="noto-pb mr-2">#ID</span>

</div>

<form id="common-edit-form" onsubmit="return false;">
<div class="d-flex justify-content-center mb-4">
<span class="m-0 sub-title noto-pb pt-3">제목</span>
<input class="common-oneline-input" type="text" name="title"
 maxlength="100" value placeholder="제목을 입력해주세요">

</div>
 <div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 550
      });
    </script>


</form>
<div class="write-bottom">
<a class="border-b-btn board-btn noto-h4 text-center"
href="javascript:history.back();" type="button" name="button">취소</a>

<button class="ml-3 background-b-btn board-btn noto-h4"
 type="button" name="button" data-type="board" data-category-id="8"
 data-id onclick="">저장</button>



</div>


</div>
</body>
</body>
</html>