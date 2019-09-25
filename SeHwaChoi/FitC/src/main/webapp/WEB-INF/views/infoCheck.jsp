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

	$(function() {
		$('#3dpchip').on('click', chip);
		$('#fileConfirm').on('click', confirm);
	})

	function chip() {
		window
				.open("https://www.3dpchip.com/3dp/chip_down_kor.php",
						"3DP Chip",
						"width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	}

	function confirm() {
		var formData = new FormData(document.getElementById("uploadFile"));

		$.ajax({
			url : '/fitc/tesseract',
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			success : function(result) {
				if(result != "error"){
					
				} else {
					alert("정보를 읽어오는데에 실패하였습니다.");
				}
			}
		});
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
					<th colspan="3">${sessionScope.userid} 님의 컴퓨터 정보 가져오기</th>
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="uploadFile"></td>
					<td><input type="button" value="정보 가져오기" id="fileConfirm"></td>
				</tr>
				<tr>
					<td colspan="3"><a href="#" id="3dpchip">3DP Chip 사이트로 가기</a></td>
				</tr>
				<tr>
					<td>
						<h3>CPU</h3>
						<input type="text" id="cpu">
						<input type="button" class="searchButton" value="검색">
					</td>
					<td colspan="2" rowspan="4" id="td3">
						* 사용 방법 *<br/>
						1. 위 링크를 통해, 3DP Chips를 다운로드.<br/>
						2. 설치 후, 프로그램 실행.<br/>
						3. 프로그램 실행 시, 아래의 버튼을 클릭하여 캡쳐 출력하기.<br/>
						<img src="resources/icon/3DP Chip.jpg"><br/>
						4. 캡쳐 파일을 위 '파일 선택'에 첨부, '정보 가져오기' 클릭!
					</td>
				</tr>
				<tr>
					<td>
						<h3>VGA</h3>
						<input type="text" id="vga">
						<input type="button" class="searchButton" value="검색">
					</td>
				</tr>
				<tr>
					<td>
						<h3>MainBoard</h3>
						<input type="text" id="mainboard">
						<input type="button" class="searchButton" value="검색">
					</td>
				</tr>
				<tr>
					<td>
						<h3>RAM</h3>
						<input type="text" id="ram">
						<input type="button" class="searchButton" value="검색">
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