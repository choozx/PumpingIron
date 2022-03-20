<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/tips1.css">
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
${result }
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
<span class="count-data noto-pb" >${tippp.cr_date }</span>



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
<!-- foreach 로 돌리기 -->
<c:forEach var="p" items="${re }">
<div class="comment-content border border-dark border-top-0">

<div class="comment-box-elem">
<div class="comment-box">
<div class>
<div class="d-flex align-items-start justify-content-between">
<div class="comment-content-left d-flex align-items-start justify-content-center">
<div class="comment-picture mr-4">
<img alt="" src="" class="rounded-circle cursor">
</div>


<div class="comment-left-text">
<%-- <input type="hidden" name="crr_no" value="${re.crr_no}"> --%>
<div class="text-id noto-pb mb-1 d-flex align-items-center">&nbsp&nbsp
<span class="noto-pb">${p.crr_cr_nickname }</span>&nbsp

<c:if test="${p.crr_cr_nickname == sessionScope.loginMember.m_name }">
<div class="reply-writer ml-1 noto-sm hidden">작성자</div>
</c:if>

<p class="d-flex align-items-center ml-2 m-0 noto-sm color-gray">
<span class="comment-time"></span>
</p>
</div>
<div class="comment-item">&nbsp

<span class="noto-pm text-break comment-text">${p.crr_text }</span>
</div>
<div class="hidden comment-file-264785">
<img alt="" src="">
</div>

</div>

<div class="comment-content-right" style="margin-left: 1013px;">







</div>
</div>
</div>
</div>



</div>
<div class="recomment-elem recomment-box-0 hidden"></div>
</div>






</div>

</c:forEach>

<!-- 댓글등록 -->
<div class="comment-edit-wrapper">

<form id="comment-form" action="upReply.Do">
<div class="reply-write-box comment-content border border-dark d-flex" style="">
<div class="reply-write-textarea">
<textarea rows="8" cols="80" placeholder="댓글을 남겨보세요"
class="bg-whtie comment-textarea" name="crr_text">${re.crr_text }</textarea>
</div>

<div class="reply-write-wrapper">
<div class="preview-wrapper p-3">
<input type="hidden" class="input-delete" value="0">
</div>
<div class="reply-write-btn container" style="margin-right: 2px">

<div class="write-btn-right">
<input type="hidden" value="${tippp.cr_no }" name="cr_no">
<input type="hidden" name="token" value="${token }">
<button class="noto-pb submit-btn"  name="button"
 style="margin-right: 70px;">수정</button>

</div>
</div>
</div>
</div>
</form>
</div>



<div class="bottom-btn-wrapper">
<div class="viewer-bottom d-flex align-items-center justify-content-between mt-5 mb-5">

<a href="tips.go" class="viewer-bottom-left">
<button class="border-b-btn board-btn noto-h4" type="button" name="button" style="background-color: black; color: white">
목록</button>
</a>






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