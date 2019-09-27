<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
<div>
	<form id="commentForm" name="commentForm" method="post">
	<br><br>
		<div>
			<div>
               <span><strong>Comments</strong></span> <span id="cCnt"></span>
           	</div>
           	<div>
           		 <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 800px" rows="2" cols="30" id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <a href='#' onclick="reg_comment('${result.code }')" class="btn pull-right btn-success">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
           	</div>		
		</div>
		<input type="hidden" id="b_code" name="b_code" value="${result.code }" />		
	</form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
</body>
</html>