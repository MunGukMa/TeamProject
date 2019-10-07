<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	function changeEmail(){
		if (selectEmail.value == '1') {
			fitc_email_02.readonly = false;
			fitc_email_02.value = '';
			fitc_email_02.focus();
	    }
	    else {
	    	fitc_email_02.readonly = true;
	    	fitc_email_02.value = selectEmail.value;
	    }
	}

	function updateInfo(){
		var fitc_pw = document.getElementById("fitc_pw");
		var check_pw = document.getElementById("check_pw");
		var fitc_nickname = document.getElementById("fitc_nickname");

		if(fitc_pw.value.length<4 || fitc_pw.value.length>10){
			alert('비밀번호는 4~10글자로 입력해주세요');
			fitc_id.focus();
			return;
		}

		if(fitc_nickname.value.length>10 || fitc_nickname.value.length == 0){
			alert('닉네임은 10글자 이하로 입력해주세요');
			fitc_nickname.focus();
			return;
		}
		

		if(fitc_pw.value != check_pw.value){
			alert("비밀번호가 일치하지 않습니다.");
			fitc_pw.focus();
			return;
		}

		if(fitc_email_01.value.length == 0){
			alert('이메일을 입력해주세요')
			fitc_email_01.focus();
			return;
		}

		if(fitc_email_02.value.length == 0){
			alert('이메일을 입력해주세요')
			fitc_email_02.focus();
			return;
		}

		var form = document.getElementById("update");
		form.submit();
	}	

	function cancel(){
		location.href="/three"
	}

</script>
<style>
	
	header {
		text-align: center;
	}
	
	caption {
		font-size: 24px;
	}
	
	td {
		text-align: center;
	}
	
	.registration form {
		width: 540px;
		height: 300px;
		background-color: black;
		padding: 10px 0px 0px 4px;
		border-radius: 15px;
		color: white;
		text-transform: uppercase;
		font-size: 14px;
		font-weight: bold;
		font-family: "Century Gothic";
		margin: 0 auto;
	}
	
	.registration input, .registration select {
		width: 250px;
		height: 25px;
		margin: 3px 0px 0px 10px;
		border: 0px;
		font-weight: bold;
	}
	
	.registration input:focus {
		background-color: crimson;
	}
	
	.registration form label {
		margin: 5px 0px 0px 15px;
	}
	
	a {
		outline: none;
	}

</style>
</head>
<body>
	<header>
		<div>
			<h1>
				<a href="/one/">Fit-c</a>
			</h1>
			<h5>Fit your game</h5>
		</div>
	</header>
	<div class="registration">
		<form id="update" action="updateInfo" method="post">
			<table>
				<caption>${sessionScope.fitc_id }님의 회원정보 수정</caption>
				<tr>
					<td><input type="hidden" name="fitc_id" id="fitc_id" value="${sessionScope.fitc_id }"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="fitc_pw" id="fitc_pw" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="check_pw" id="check_pw" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="fitc_name" id="fitc_name" value="${sessionScope.fitc_name}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="fitc_nickname" id="fitc_nickname" value="${sessionScope.fitc_nickname}" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="fitc_email_01" class="selectEmail" id="fitc_email_01" /><br/>
						&nbsp;&nbsp;&nbsp;@ <input type="text" name="fitc_email_02" class="selectEmail" id="fitc_email_02" style="width:100px" />
						<select style="width:110px" class="selectEmail" name="selectEmail" id="selectEmail" onChange="changeEmail()" >
							<option value="1" selected>직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="google.com">google.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="수정하기" onclick="updateInfo()" /></td>
					<td><input type="button" value="취소" onclick="cancel()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>