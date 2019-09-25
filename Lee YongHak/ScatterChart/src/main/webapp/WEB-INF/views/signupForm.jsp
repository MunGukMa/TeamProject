<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	
	function signUP(){
		var fitc_id = document.getElementById("fitc_id");
		var fitc_pw = document.getElementById("fitc_pw");
		var check_pw = document.getElementById("check_pw");
		var fitc_name = document.getElementById("fitc_name");
		
		if(fitc_id.value.length<4 || fitc_id.value.length>10){
			alert('아이디는 4~10글자로 입력해주세요');
			fitc_id.focus();
			return;
		}

		if(fitc_pw.value.length<4 || fitc_pw.value.length>10){
			alert('비밀번호는 4~10글자로 입력해주세요');
			fitc_pw.focus();
			return;
		}

		if(fitc_nickname.value.length>10){
			alert('닉네임은 10글자 이하로 입력해주세요');
			fitc_nickname.focus();
			return;
		}
		
		if(fitc_pw.value != check_pw.value){
			alert('비밀번호가 일치하지 않습니다.');
			fitc_pw.focus();
			return;
		}
		    	
		var form = document.getElementById("signupForm");
		form.submit();
	}

	function cancel(){
		location.href="/three"
	}
</script>
</head>
<body>
<h1>회원가입</h1>
<div>
	<form name="signupForm" id="signupForm" action="signUP" method="post">
		<table>
			<tr>
				<td>아이디 : </td>
				<td>
					<input type="text" placeholder="아이디" name="fitc_id" id="fitc_id" readonly="readonly"/>
					<input type="button" id="checkID" value="중복확인" onclick="window.open('checkidForm','pop', 'resizable=no scrollbars=yes top=300 left=500 width=400 height=200');return false">
				</td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" placeholder="비밀번호" name="fitc_pw" id="fitc_pw" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인 : </td>
				<td><input type="password" placeholder="비밀번호 확인" name="check_pw" id="check_pw"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" placeholder="이름" name="fitc_name" id="fitc_name" /></td>
			</tr>
			<tr>
				<td>닉네임 : </td>
				<td><input type="text" placeholder="닉네임" name="fitc_nickname" id="fitc_nickname" /></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td>
					<input type="text" name="fitc_email_01" class="selectEmail" id="fitc_email_01" /> @ 
					<input type="text" name="fitc_email_02" class="selectEmail" id="fitc_email_02" style="width:100px" />
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
				<td><input type="button" value="회원가입" onclick="signUP()"/></td>
				<td><input type="button" value="취소" onclick="cancel()" /></td>
			</tr>
		</table>		
	</form>
	
</div>
</body>
</html>