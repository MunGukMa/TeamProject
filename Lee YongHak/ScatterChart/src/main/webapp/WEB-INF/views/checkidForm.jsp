<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function idchk(){
		var id = document.getElementById('fitc_id').value;
		if(id == null || id == ""){
			alert("아이디를 입력해주세요");
			return;
		}
		location.href="/three/checkID?fitc_id="+id;
		
		/*var fitc_id = document.getElementById("fitc_id");
		var form = document.getElementById("checkidForm");
		form.submit();
		*/
	}

	function idsubmit(){
		opener.document.getElementById("fitc_id").value = "${fitc_id}";
		close();
	}	
</script>
</head>

<body>

<div class="popwrap">

<h2>ID중복확인</h2>
<c:choose>
	<c:when test="${result == true }">
	<div style="display:;">
		${fitc_id } 아이디는 사용가능합니다.
		<p class="list_btn">
		<a href="#" onclick="idsubmit()">적용</a>
		</p>
	</div>
	</c:when>
	<c:when test="${result == false }">
	<form id="checkidForm" action="checkID" method="post">
	<div style="display:;">
		${fitc_id } 아이디는 이미 사용중입니다.
		<p class="list_btn">
		<input type="text" class="wr_idcheck" id="fitc_id"/> <a href="#" onclick="return idchk()">중복확인</a>
		</p>
	</div>
	</form>
	</c:when>
	<c:when test="${fitc_id == null}">
	<form id="checkidForm" action="checkID" method="post">
	<div style="display:;">
		<p class="list_btn">
		<input type="text" class="wr_idcheck" id="fitc_id"/> <a href="#" onclick="return idchk()">중복확인</a>
		</p>
	</div>
	</form>
	</c:when>
</c:choose>	
</div>


</body>
</html>