<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/index.css">
<style>
.reply-write-btn {
position: absolute;
width: 100px;
left:90%;
}

.reply-write-textarea{
position: relative;
width: 100%;

}
</style>
</head>
<body>
<div class="title-center text-center">

<a href="tips/tips.jsp">
<span class="prompt-h1">abs</span>
</a>
</div>

<div class="write-wrapper container" style="height: 150px">
<div class="write-input-top d-flex mb-4">
<span class="m-0 sub-title noto-pb pt-3">제목</span>
<span class="m-0 sub-title noto-pb pt-3" style="font-size: 15px">복근</span>

</div>


<div class="d-flex  mb-4">
<span class="m-0 sub-title noto-pb ">작성자</span>
<span class="noto-pb mr-2">#ID</span>
<span class=""></span>&nbsp
<span class="" style="margin-right: 850px"></span>

<span class="viewer">조회수</span>
<span class="">#</span>&nbsp&nbsp&nbsp&nbsp
<span class="">작성시간</span>
<span class="">####-##-##</span>

</div>
</div>

<div class="write-wrapper container" style="height: 700px">
<div class=" justify-content-center mb-4">
<span class="">

<iframe width="1000" height="500" src="https://www.youtube.com/embed/ICvHkVGI57Q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


</span>


</div>
</div>
<div class="write-wrapper container">
<div class="d-flex align-items-center comment-left">

<img src="resources/img/tips/comment.png" class="comment-icon">
<div>
<span class="point-color ">#</span>
</div>

<div>
<span class="text-muted noto-pb" style="font-size: 14px">댓글</span>
</div>
</div>

</div>

<!-- <div class="write-wrapper container" >
<span class="">lmc 제품입니다</span>
</div>
 -->


<div class="write-wrapper container" style="height: 250px">
<div class="reply-write-textarea" >
	<textarea rows="8" cols="80" placeholder="댓글을 남겨보세요." class="bg-white comment-textarea" >
	</textarea>
	<div class="reply-write-btn">
	<button class="noto-pb submit-btn text-muted noto-pb" type="button" name="button" onclick="">댓글등록</button>
	</div>
</div>


</div>
<div class="bottom-btn-wrapper container">
<div class="viewer-bottom d-flex align-items-center justify-content-between
mt-5 mb-5">
<a href="javascript:history.back();" class="viewer-bottom-left">
<button class="border-b-btn board-btn noto-h4" type="button" name="button" style="background-color: black; color: white">
목록</button>
</a>


</div>

</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>