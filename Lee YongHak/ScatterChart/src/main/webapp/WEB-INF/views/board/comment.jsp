<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function commentWrite(){
		var comments = document.getElementById("comments");
		if(comments.value.length==0){
			alert("댓글을 입력하세요");
			comments.focus();
			return;
		}
		var form = document.getElementById("commentForm");
		form.submit();
	}

	

</script>
</head>
<body>
<!-- 댓글 입력 -->
<form action="/three/board/commentWrite" id="commentForm" method="post">
	<input type="hidden" name="b_num" value="${vo.b_num }" />
	<table id="commentinput" style="margin-left: auto; margin-right: auto;">
		<tr>
			<td>
				<input id="comments" type="text" name="comments" required="required"/>
				<input id="commentWrite" type="button" value="댓글 입력" onclick="commentWrite()"/>
			</td>
		</tr>
	</table>
</form>

<!-- 댓글 출력 -->
<div id="commentdisplay">
<table class="comment" style="margin-left: auto; margin-right: auto;">
	<c:forEach items="${commentList}" var="comment">
		<tr>
			<td class="comments">
				${comment.comments}
			</td>
			<td class="commentid">
				<span>${comment.fitc_id} </span>
			</td>
			<td class="commentdate">
				<span>${comment.c_date}</span>
			</td>
			<c:if test="${sessionScope.fitc_id == comment.fitc_id }">
				<td class="commentbtn">
					<input type="button" value="삭제" onclick="commentDelete('${comment.c_date}')" >
					<input type="button" value="수정" onclick="commentModify('${comment.c_date}', '${comment.comments}')">
				</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>