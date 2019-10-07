<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.registration #findMember, .registration #findpw{
		width: 400px;
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
		text-align: center;
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
	.register_button {
		width: 150px;
		height: 45px;
		background-color: orange;
		border-radius: 10px;
		margin: 15px auto 0px auto;
		text-align: center;
		cursor: pointer;
		clear: both;
	}
	
	.find_button {
		width: 125px;
		height: 30px;
		background-color: orange;
		border-radius: 10px;
		margin: 15px auto 0px auto;
		text-align: center;
		curser: pointer;
		clear: both;
	}
	
	.register_button span {
		font-weight: normal;
		font-size: 28px;
		font-family: "Impact";
		line-height: 40px;
	}
	
	.find_button span {
		font-weight: normal;
		font-size: 22px;
		font-family: "Impact";
		line-height: 30px;
	}
	
	.register_button span a {
		text-decoration: none;
		color: white;
	}
	
	.find_button span a {
		text-decoration: none;
		color: white;
	}
	
	.register_button span a:hover {
		color: black;
	}
	
	.find_button span a:hover {
		color: black;
	}
	
	span.error {
		margin-right: 20px;
		font-size: 9px;
		color: orange;
		height: 10px;
	}
	
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>

	$(function(){
		$('#findId').on('click', searchId);
		$('#findPW').on('click', searchPW);
	})

	function searchId(){
		$.ajax({
			url:"/one/searchInfo",
			type:"post",
			data:{"fit_usernick":$("#fit_usernick_id").val(),"fit_usermail":$("#fit_usermail_id").val()},
			success:function(result){
				if(result != null){
					alert("찾으신 아이디는 " + result + " 입니다.");
				}else{
					alert("찾는 아이디가 없습니다.");
				}
			},
			error:function(){
				alert("error");
			}
		})
	}

	function searchPW(){
		$.ajax({
			url:"/one/searchPW",
			type:"post",
			data:{"fit_userid":$("#fit_userid_pw").val(), "fit_usernick":$("#fit_usernick_pw").val(), "fit_usermail":$("#fit_usermail_pw").val()},
			success:function(result){
				if(result != null){
					alert("찾으신 비밀번호는 " + result + " 입니다.");
				}else{
					alert("다시 입력해주세요.");
				}
			},
			error:function(){
				alert("error");
			}
		})
	}


	function goId(){
		var test1 = document.getElementById("test1");
		var test2 = document.getElementById("test2");
	
		test1.style.display = 'none';
		test2.style.display = 'block';
	}
	
	function goPassword(){
		var test1 = document.getElementById("test1");
		var test2 = document.getElementById("test2");
	
		test1.style.display = 'block';
		test2.style.display = 'none';
	}
	
</script>
</head>
<body>
	<div class="registration">
		<div id="test1" style="display:;">
			<form id="findMember" action="searchInfo" method="post">
				<div class="find_button">
					<span><a href="javascript:;" class="" onclick="goId()">Password</a></span>
				</div>
				<br/>
				<h4>아이디 찾기</h4>
				<input type="text" placeholder="닉네임" id="fit_usernick_id" name="fit_usernick" />
				<br/>
				<input type="email" placeholder="이메일주소" id="fit_usermail_id" name="fit_usermail" />
				<br/>
				<div class="register_button">
					<span><a href="javascript:;" id="findId">CHECK</a></span>
				</div>
			</form>
		</div>
		
		<div id="test2" style="display: none;">
			<form id="findpw" action="searchPW" method="post">
				<div class="find_button">
					<span><a href="javascript:;" class="" onclick="goPassword()">ID</a></span>
				</div>
				<br/>
				<h4>비밀번호 찾기</h4>
				<input type="text" placeholder="아이디" id="fit_userid_pw" name="fit_userid" />
				<br/>
				<input type="text" placeholder="닉네임" id="fit_usernick_pw" name="fit_usernick" />
				<br/>
				<input type="email" placeholder="이메일주소" id="fit_usermail_pw" name="fit_usermail" />
				<br/>
				<div class="register_button">
					<span><a href="javascript:;" id="findPW">CHECK</a></span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
