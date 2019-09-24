<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>
<div class="login">
	<form action="logIN" method="post">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" id="fitc_id"/></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" id="fitc_pw" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"/></td>
				<td><input type="button" value="취소" /></td>
			</tr>
		</table>		
	</form>
	<a href="signupForm">아직 회원이 아니신가요?</a><br>
	<a href="#">아이디/비밀번호찾기</a>
</div>
</body>
</html>