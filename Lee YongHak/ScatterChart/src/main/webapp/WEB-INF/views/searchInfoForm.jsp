<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}

div {
	text-align: center;
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
			url:"/three/searchInfo",
			type:"post",
			data:{"fitc_name":$("#fitc_name_id").val(),"fitc_email":$("#fitc_email_id").val()},
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
			url:"/three/searchPW",
			type:"post",
			data:{"fitc_id":$("#fitc_id_pw").val(), "fitc_name":$("#fitc_name_pw").val(), "fitc_email":$("#fitc_email_pw").val()},
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
	<div>
		<h2>아이디 / 비밀번호 찾기</h2>
		<div>
			<form id="findMember" action="searchInfo" method="post">
				<ul id="test1" style="display:;">
					<!-- 아이디 찾기 -->
					<li class="">Fit-C</li>
					<li><a href="#" class="" onclick="goPassword()">아이디 찾기</a>&nbsp;<a	href="#" class="" onclick="goId()">패스워드 찾기</a></li>
					<li><input type="text" placeholder="이름" id="fitc_name_id" name="fitc_name" /></li>
					<li><input type="email" placeholder="이메일주소" id="fitc_email_id" name="fitc_email"  /></li>
					<li><a href="#" id="findId">아이디 확인</a></li>
				</ul>
			</form>
			<form id="findpw" action="searchPW" method="post">
				<ul id="test2" style="display: none;">
					<!-- 비밀번호 찾기 -->
					<li class="">Fit-C</li>
					<li><a href="#" class="" onclick="goPassword()">아이디 찾기</a>&nbsp;<a	href="#" class="" onclick="goId()">패스워드 찾기</a></li>
					<li><input type="text" placeholder="아이디" id="fitc_id_pw" name="fitc_id"  /></li>
					<li><input type="text" placeholder="이름" id="fitc_name_pw" name="fitc_name"  /></li>
					<li><input type="email" placeholder="이메일주소" id="fitc_email_pw" name="fitc_email" /></li>
					<li><a href="#" id="findPW">비밀번호 확인</a></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>