<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보 수정</h2>
<div>
	<form id="update" action="updateInfo" method="post">
		<table>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="fitc_pw" id="fitc_pw" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인 : </td>
				<td><input type="password" name="check_pw" id="check_pw" /></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="fitc_name" id="fitc_name" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="fitc_eamil" id="fitc_email "/></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정하기" /></td>
				<td><input type="button" value="취소" onclick="cancel()" /></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>