<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맞춤 견적</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.bundle.min.js"></script>
<script>
	$(function(){
		$('#cpuConfirm').on('click', searchCPU);
		$('#mainboardConfirm').on('click', searchMB);
		$('#graphicConfirm').on('click', searchGP);
		$('#ramConfirm').on('click', searchRAM);
	})

	$(function(){
		var result = JSON.parse(sessionStorage.getItem('result'));
		
		/*
		for(var i = 0 ; i < result.length ; i++){
			console.log(result[i])
		}
		*/
		if(result != null){
			$('#cpuResult').empty();
			$('#mbResult').empty();
			$('#gpResult').empty();
			$('#ramResult').empty();
			
			$('#cpuResult').append(result[0]);
			$('#mbResult').append(result[1]);
			$('#gpResult').append(result[2]);
			$('#ramResult').append(result[3]);

			setTimeout(function(){
				var check = confirm("입력하신 정보와 일치합니까?");
				if(check == true){
					$('#cpu').val(result[0])
					$('#mainboard').val(result[1])
					$('#graphic').val(result[2])
				} else {
					alert("죄송합니다, 직접 입력해주세요.")
					$('#cpu').val(result[0])
					$('#mainboard').val(result[1])
					$('#graphic').val(result[2])
				}
			}, 1000);
		} else {
			alert("컴퓨터 정보를 입력해주세요.")
		}
	})
	
	/*
	$(document).ready(function(){ }) // 데이터가 바인딩 되기 이전
	$(window).load(function(){ }) // 데이터 바인딩 된 이후
	setTimeout(function(){ }) // 시간 설정 후
	*/
	
	function searchCPU(){
		var cpuname = $('#cpu').val();
		if(cpuname == "" || cpuname == null){
			alert("정보를 입력해주세요.")
			$('#cpu').focus();
			return false;
		}
		
		$.ajax({
			url: 'searchCPU',
			type: 'POST',
			data: {'cpuname' : cpuname},
			success: function(result){
				sessionStorage.setItem('resultCPU', result);
				window.open("searchCPU", "searchCPU", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
			},
			error: function(){alert("Error")}
		})
	}
	
	function searchMB(){
		var name = $('#mainboard').val();
		if(name == "" || name == null){
			alert("정보를 입력해주세요.")
			$('#mainboard').focus();
			return false;
		}
		
		$.ajax({
			url: 'searchMB',
			type: 'POST',
			data: {'name' : name},
			dataType: 'JSON',
			success: function(result){
				
				for(var y in result){
					console.log(result[y].name);
				}
				
				sessionStorage.setItem("resultMB", result);
				window.open("searchMB_window", "searchMB",
				"width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
				/*
				var win = window.open("searchMB_window", "searchMB",
									"width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
				$(win.document).find('#nameList').clear();
				$(win.docuemnt).find('#mainboardList').clear();
				$(win.docuemnt).find('#mainboardList').append("<td>제품명</td><td>선택</td>");
				for(var i in result){
					$(win.docuemnt).find('#mainboardList').append("<td>"
							+ result[i].name + "</td><td><input type='radio' class='selectRadio'></td>");
				}
				*/
			},
			error: function(){alert("Error")}
		})
	}
	
	function searchGP(){
		var product_name = $('#graphic').val();
		if(product_name == "" || product_name == null){
			alert("정보를 입력해주세요.")
			$('#graphic').focus();
			return false;
		}
		
		$.ajax({
			url: 'searchGP',
			type: 'POST',
			data: {'product_name' : product_name},
			success: function(result){
				sessionStorage.setItem('resultGP', result);
				window.open("searchGP", "searchGP", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
			},
			error: function(){alert("Error")}
		})
	}
	
	function searchRAM(){
		var name = $('#ram').val();
		if(name == "" || name == null){
			alert("정보를 입력해주세요.")
			$('#ram').focus();
			return false;
		}
		
		$.ajax({
			url: 'searchRAM',
			type: 'POST',
			data: {'name' : name},
			success: function(result){
				sessionStorage.setItem('resultRAM', result);
				window.open("searchRAM", "searchRAM", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
			},
			error: function(){alert("Error")}
		})
	}
	
</script>
<style>

	a {
	
		text-decoration: none;
	}
	/*div{
	        border: 1px solid #ccc;
	    }*/
	h1, h5 {
		text-align: center;
		font-family: 'NanumGothic';
	}
	
	.box1 {
		margin-top: 30px;
		margin-left: 20%;
		width: 60%;
		height: 60%;
		margin-bottom: 5%;
		align-content: center
	}
	
	.box2 {
		float: right;
		width: 10%;
		margin-top: 30px;
		margin-left: 5%;
		margin-right: 5%;
		height: 50px;
	}
	
	.box3 {
		float: left;
		width: 10%;
		margin-top: 30px;
		margin-left: 5%;
		margin-right: 5%;
		height: 50px;
		align-text: center;
	}
	
	.footer {
		text-align: center;
		clear: both;
	}
	
	#topMenu {
		height: 30px;
		width: 120px;
	}
	
	#topMenu ul { /*메인메뉴 ul 설정*/
		list-style-type: none;
		margin: 0px;
		padding: 0px;
	}
	
	#topMenu ul li {
		float: left;
		line-height: 30px;
		vertical-align: middle;
		text-align: center;
		position: relative;
	}
	
	.menuLink, .submenuLink {
		text-decoration: none;
		display: block;
		width: 150px;
		font-weight: bold;
	}
	
	.topMenuLi:hover .menuLink {
		color: red;
		background-color: #4d4d4d;
	}
	
	.longLink {
		width: 150px;
	}
	
	.submenu {
		position: absolute;
		height: 0px;
		overflow: hidden;
		transaction: height .2s;
		-webkit-transition: height .2s;
		/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 크롬/사파라ㅣ) */
		-moz-transition: height .2s;
		/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 파폭) */
		-o-transition: height .2s;
		/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 오페라) */
	}
	
	.submenuLink {
		border: solid 1px black;
		margin-top: -1px;
	}
	
	.submenuLink:hover {
		color: red;
	}
	
	.topMenuLi:hover .submenu {
		height: 125px;
	}
	
	.infoBanner {
		position: fixed;
		top: 20%;
		right: 20%;
	}
	
	canvas {
		-moz-user-select: none;
		-webkit-user-select: none;
		-ms-user-select: none;
		width: 100%;
		height: 50%;
	}
	
	#chartjs-tooltip {
		opacity: 1;
		position: absolute;
		background: white;
		color: black;
		border: 1px solid black;
		-webkit-transition: all .1s ease;
		transition: all .1s ease;
		pointer-events: none;
		-webkit-transform: translate(-50%, 0);
		transform: translate(-50%, 0);
		min-width: 10%;
	}
	
	.chartjs-tooltip-key {
		display: inline-block;
		width: 10px;
		height: 10px;
		margin-right: 10px;
	}
	
	#nondiv {
		position: absolute;
		left: 55%;
		width: 25%;
		top: 20%;
		text-align: center;
		background: rgba;
		border: 10px solid lightblue;
		border-radius: 25px;
	}
	
	table {
	    border-collapse: separate;
	    border-spacing: 1px;
	    text-align: center;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
	  	margin : 20px 10px;
	  	margin-left: auto;
	  	margin-right: auto;
	}
	
	th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	}
	
	td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	}
	
	#td3 {
		width: 350px;
	    padding: 10px;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	    text-align: left;
	}
	
</style>
</head>
<body>
	<header>
		<div>
			<h1>
				<a href="#">Fit-c</a>
			</h1>
			<h5>Fit your game</h5>
		</div>
	</header>

	<aside>
		<div class="box2">
			사이드1<br> 광고가 들어갈 자리
		</div>
	</aside>

	<aside>
		<div class="box3">
			<nav id="topMenu">
				<ul>
					<li class="topMenuLi" value="banner"><a class="menuLink">welcome</a>
						<ul class="submenu">
							<li><a href="#" class="submenuLink longLink">메뉴1</a></li>
							<li><a href="#" class="submenuLink longLink">메뉴2</a></li>
							<li><a href="#" class="submenuLink longLink">메뉴3</a></li>
							<c:if test="${sessionScope.userid == null }">
								<li><a href="loginForm" class="submenuLink longLink">LOGIN</a></li>
							</c:if>
							<c:if test="${sessionScope.userid != null }">
								<li><a href="#" class="submenuLink longLink">LOGOUT</a></li>
							</c:if>
						</ul></li>
				</ul>
			</nav>
		</div>
	</aside>
	
	<section>
		<div>
			<table border="1">
				<tr>
					<td colspan="2">${sessionScope.userid} 님의 컴퓨터 정보</td>
				</tr>
				<tr>
					<td>
						<h3>CPU 정보</h3><br/>
						<span id="cpuResult"></span>
					</td>
					<td>
						<h3>CPU</h3><br/>
						<input type="text" id="cpu" value=""><input type="button" value="검색" id="cpuConfirm">
					</td>
				</tr>
				<tr>
					<td>
						<h3>메인보드 정보</h3><br/>
						<span id="mbResult"></span>
					</td>
					<td>
						<h3>Mainboard</h3><br/>
						<input type="text" id="mainboard" value=""><input type="button" value="검색" id="mainboardConfirm">
					</td>
				</tr>
				<tr>
					<td>
						<h3>그래픽카드 정보</h3><br/>
						<span id="gpResult"></span>
					</td>
					<td>
						<h3>Graphics</h3><br/>
						<input type="text" id="graphic" value=""><input type="button" value="검색" id="graphicConfirm">
					</td>
				</tr>
				<tr>
					<td>
						<h3>RAM 정보</h3><br/>
						<span id="ramResult"></span>
					</td>
					<td>
						<h3>RAM</h3><br/>
						<input type="text" id="ram" value=""><input type="button" value="검색" id="ramConfirm">
					</td>
				</tr>
			</table>
		</div>
	</section>

	<footer>
		<div class="footer">
			푸터<br> 출처가 들어갈 자리
		</div>
	</footer>

</body>
</html>