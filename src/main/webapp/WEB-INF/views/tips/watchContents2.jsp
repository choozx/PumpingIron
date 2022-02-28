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



<div class="board-detail-wrapper container" style="min-height:100%">
<input type="text" id="copy-url">
<div class="main-wrapper">
<div id="content-wrapper" class="content-detail-wrapper">
<div class="body-center mt-5">
<div class="body-top">
<div class="board-header mb-2">
<div class="title-center text-center">

<a href="tips/tips.jsp">
<span class="prompt-h1">Q/A</span>
</a>
</div>





</div>



</div>
<div class="viewer-wrapper mt-3">
<div class="content-header">
<div class="border border-dark board-header-wrapper">
<div class="viewer-header d-flex align-items-start justify-content-between">
<div class=" viewer-left d-flex align-items-start">
<a class="viewer-picture">

<img alt="" src="" class="rounded-circle">

</a>


<div class="viewer-left-text">
<div class="text-top mb-1">
<span class="noto-h3 text-over-flow-2">${tippp.cr_title }</span>



</div>
<div class="text-bottom d-flex align-items-center">
<span class="noto-pb">${tippp.cr_nickname }</span>
<p class="d-flex align-items-center ml-3 m-0 noto-pb">
<span class="viewer-like viewer-like-count noto-h4">0</span>&nbsp
<span class="material-icons viewer-like-icon ml-1 cursor" data-type="0"
 data-like-cnt="0" data-islike="0" onclick="" >
 <img alt="" src="resources/img/tips/love.png" style="width: 18px">
 </span>



</p>


</div>

</div>
</div>
<div class="viewer-right">
<div class="right-bottom d-flex justify-content-end">

<div class="viewer-view-count mr-3">
<span class="count-text mr-2 noto-pb">조회수</span>
<span class="count-number noto-pb">0</span>&nbsp

</div>
<div class="viewer-view-data">
<span class="count-text mr-2 noto-pb">작성시간</span>
<span class="count-data noto-pb">${tippp.cr_date }</span>



</div>

</div>


</div>


</div>



</div>		






</div>
<div class="content-body">
<div class="viewer-content border border-dark border-top-0 p-5">
<div class="viewer-content-item">
<div class="item-text mb-5 text-break">
<span>${tippp.cr_content }</span>
</div>


</div>



</div>
<div class="clothes-list border-dark border border-top-0"></div>
<!-- 댓글  -->
<div class="comment-wrapper">
<div class="comment-top border border-dark border-top-0 d-flex align-items-center justify-content-between">
<div class="d-flex align-items-center comment-left">
<img alt="" src="resources/img/tips/comment.png" class="comment-icon">
<div>
<span class="point-color noto-pb comment-cnt">0</span>
<span class="text-muted noto-pb">댓글</span>



</div>

</div>



</div>


</div>
<!-- 댓글 영역 -->
<div class="comment-content border border-dark border-top-0">

<!-- foreach 로 돌리기 -->
<div class="comment-box-elem">
<div class="comment-box">

<div class>

<div class="d-flex align-items-start justify-content-between">
<div class="comment-content-left d-flex align-items-start justify-content-center">
<div class="comment-left-text">
<div class="text-id noto-pb mb-1 d-flex align-items-center">
<span class="noto-pb">${tipp.cr_nickname }</span>
<div class="comment-item">
<span class="noto-pm text-break comment-text">####</span>



</div>


</div>


</div>


<div class="comment-content-right" style="margin-left: 1013px;">

<div class="d-flex align-items-center comment-right" style="float: right;">
<button class="update" onclick="" style="float: right;">수정</button>
<button class="delete" onclick="" style="float: right;">삭제</button>

</div>

</div>





</div>


</div>



</div>



</div>
<div class="recomment-elem recomment-box-0 hidden"></div>

</div>



</div>


<!-- 댓글등록 -->
<div class="comment-edit-wrapper">
<form id="comment-form">
<div class="reply-write-box comment-content border border-dark d-flex">
<div class="reply-write-textarea">
<textarea rows="8" cols="80" placeholder="댓글을 남겨보세요"
class="bg-whtie comment-textarea"></textarea>

</div>

<div class="reply-write-wrapper">
<div class="preview-wrapper p-3">

</div>
<div class="reply-write-btn">
<div class="write-btn-center">
<button class="noto-pb submit-btn" type="button" name="button"
 onclick="">댓글등록</button>



</div>


</div>

</div>


</div>



</form>



</div>



<div class="bottom-btn-wrapper">
<div class="viewer-bottom d-flex align-items-center justify-content-between mt-5 mb-5">

<a href="javascript:history.back();" class="viewer-bottom-left">
<button class="border-b-btn board-btn noto-h4" type="button" name="button" style="background-color: black; color: white">
목록</button>
</a>
<div class="viewer-bottom-right d-flex align-items-center">
<div class="d-inline-block is-mine">
<button class="ml-3 border-b-btn board-btn noto-h4" type="button" name="button"
onclick="">수정</button>
<button class="ml-3 border-b-btn board-btn noto-h4 item-delete" data-type="board" name="button"
onclick = "deleteContent(${tippp.cr_no},'${tippp.cr_content }');">삭제</button>



</div>

</div>


</div>



</div>
</div>


</div>


</div>



</div>



</div>


</div>










<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>