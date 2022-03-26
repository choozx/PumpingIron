<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/tips.css">
<link rel="stylesheet" href="resources/css/tips1.css">
<script src="resources/js/review2/like.js"></script>
<script type="text/javascript" src="resources/js/review2/delcon.js"></script>
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
${result }



<div class="board-detail-wrapper container" style="min-height:100%">
<input type="text" id="copy-url">
<div class="main-wrapper">
<div id="content-wrapper" class="content-detail-wrapper">
<div class="body-center mt-5">
<div class="body-top">
<div class="board-header mb-2">
<div class="title-center text-center">

<a href="">
<span class="prompt-h1">review</span>
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

<img alt="" src="resources/files/${tippp.m_photo}" class="rounded-circle">

</a>


<div class="viewer-left-text">
<div class="text-top mb-1">
<span class="noto-h3 text-over-flow-2">${tippp.c2_title }</span>

</div>
<div class="text-bottom d-flex align-items-center">
<span class="noto-pb">${tippp.c2_nickname }</span>

<!-- 좋아요 -->
<p class="d-flex align-items-center ml-3 m-0 noto-pb">
<span class="viewer-like viewer-like-count noto-h4"></span>&nbsp
<span class="material-icons viewer-like-icon ml-1 cursor" data-type="0"
 data-like-cnt="" data-islike="0">
  <img id="likeImg" src="resources/img/tips/heart.svg" style="width: 18px">
 </span>



</p>


</div>

</div>
</div>
<div class="viewer-right" style="margin-top: 20px">
<div class="right-bottom d-flex justify-content-end">

<div class="viewer-view-count mr-3">
<span class="count-text mr-2 noto-pb">조회수</span>
<span class="count-number noto-pb">${tippp.c2_views }</span>&nbsp&nbsp

</div>
<div class="viewer-view-data">
<span class="count-text mr-2 noto-pb">작성시간</span>

<span class="count-data noto-pb"><fmt:formatDate value="${tippp.c2_date }"/></span>



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
<span>${tippp.c2_content }</span>
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
<span class="point-color noto-pb comment-cnt">${recnt }</span>
<span class="text-muted noto-pb">댓글</span>



</div>

</div>



</div>


</div>
<!-- 댓글 영역 -->
<c:forEach var="t" items="${re }">
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
<span class="noto-pb">${t.c2r_c2_nickname }</span>&nbsp

<c:if test="${t.c2r_c2_nickname == sessionScope.loginMember.m_name }">
<div class="reply-writer ml-1 noto-sm hidden">작성자</div>
</c:if>

<p class="d-flex align-items-center ml-2 m-0 noto-sm color-gray">
<span class="comment-time"></span>
</p>
</div>
<div class="comment-item">&nbsp

<span class="noto-pm text-break comment-text">${t.c2r_text }</span>
</div>
<div class="hidden comment-file-264785">
<img alt="" src="">
</div>

</div>

<div class="comment-content-right" style="margin-left: 1131px;">



<c:if test="${t.c2r_c2_nickname == sessionScope.loginMember.m_name }">
<div class="d-flex align-items-center comment-right" style="float: right;">
<button class="update" onclick="updateReply2('${t.c2r_no}','${t.c2r_c2_no}','${t.c2r_text}');" style="float: right;">수정</button>
<button class="delete" onclick="deleteReply2('${t.c2r_no}','${t.c2r_c2_no}');" style="float: right;">삭제</button>
</div>
</c:if>



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

<form id="comment-form" action="reply2.write">
<div class="reply-write-box comment-content border border-dark d-flex" style="">
<div class="reply-write-textarea">
<textarea rows="8" cols="80" placeholder="댓글을 남겨보세요"
class="bg-whtie comment-textarea" name="c2r_text"></textarea>
</div>

<div class="reply-write-wrapper">
<div class="preview-wrapper p-3">
<input type="hidden" class="input-delete" value="0">
</div>
<div class="reply-write-btn container" style="margin-right: 2px">

<div class="write-btn-right">

<input type="hidden" value="${tippp.c2_no}" name="c2r_c2_no" id="likeId">
<input type="hidden" value="${sessionScope.loginMember.m_email }"id="likeEmail">
<input type="hidden" name="token" value="${token }">
<input type="hidden" name="c2_no" value="${tippp.c2_no }">

<%-- <input type="hidden" value="${re.crr_no }" name="crr_no"> --%>
<button class="noto-pb submit-btn"  name="button"
 style="margin-right: 70px;">댓글등록</button>

</div>
</div>
</div>
</div>
</form>
</div>



<div class="bottom-btn-wrapper">
<div class="viewer-bottom d-flex align-items-center justify-content-between mt-5 mb-5">

<a href="review.go" class="viewer-bottom-left">
<button class="border-b-btn board-btn noto-h4" type="button" name="button" style="background-color: black; color: white">
목록</button>
</a>

<c:if test="${tippp.c2_nickname == sessionScope.loginMember.m_name }">
<div class="viewer-bottom-right d-flex align-items-center">
<div class="d-inline-block is-mine">
<button class="ml-3 border-b-btn board-btn noto-h4" type="button" name="button"
onclick="location.href = 'update2.go?c2_no=${tippp.c2_no}'">수정</button>
<button class="ml-3 border-b-btn board-btn noto-h4 item-delete" data-type="board" name="button"
onclick = "deleteContent(${tippp.c2_no});">삭제</button>


</div>

</div>

</c:if>





</div>



</div>
</div>


</div>


</div>



</div>



</div>


</div>










</body>
</html>