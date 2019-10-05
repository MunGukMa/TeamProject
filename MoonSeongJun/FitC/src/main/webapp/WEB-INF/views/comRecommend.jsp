<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맞춤 견적</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.bundle.min.js"></script>
<script>
	$(function(){
		var r = JSON.parse(sessionStorage.getItem("vo"));
		$('#cpuname').append(r.cpu);
		$('#gpuname').append(r.vga);
		$('#memory').append(r.ram);
		document.getElementById('check1').style.display = '';
		document.getElementById('check2').style.display = 'none';
		
		$.ajax({
	  			url : '/fitc/lowest',
	  			type : 'post',
	  			data : {'cpu': $('#cpuname').html() ,'ram': $('#memory').html(), 'gpu': $('#gpuname').html()},
	  			dataType : "JSON",
	  			success : function(result){
  	  			$('#lowestCpu2').append(result.cpu);
  	  			$('#lowestGpu2').append(result.gpu);
  	  			$('#lowestRam2').append(result.ram);
	  			},
	  			error : function(){
	  				alert("빙시나");
	  			}
	  	
	  		})
		
	})
	/* $(function(){
		var r = JSON.parse(sessionStorage.getItem("lowest"));
		$('#lowestCpu').append(r.cpu);
		$('#lowestGpu').append(r.gpu);
		$('#lowestRam').append(r.ram);
	}) */
	
	function lowerprice(){
		var cpu = $('#cpuname').html();
  		var ram = $('#memory').html();
  		var gpu = $('#gpuname').html();
  		
  		var estimate = confirm("최저가를 확인하시겠습니까?");
  		
  		if(estimate == true){
  			/* $.ajax({
  	  			url : '/fitc/lowest',
  	  			type : 'post',
  	  			data : {'cpu': cpu ,'ram': ram, 'gpu': gpu},
  	  			dataType : "JSON",
  	  			success : function(r){
	  	  			$('#lowestCpu').append(r.cpu);
	  	  			$('#lowestGpu').append(r.gpu);
	  	  			$('#lowestRam').append(r.ram);
	  	  			document.getElementById('check1').style.display = 'none';
	  	  			document.getElementById('check2').style.display = '';
  	  			},
  	  			error : function(){
  	  				alert("빙시나");
  	  			}
  	  	
  	  		}) */
  			document.getElementById('check1').style.display = 'none';
	  		document.getElementById('check2').style.display = '';
	  		document.getElementById('lowestCpu1').style.display = 'none';
	  		document.getElementById('lowestCpu2').style.display = '';
	  		document.getElementById('lowestGpu1').style.display = 'none';
	  		document.getElementById('lowestGpu2').style.display = '';
	  		document.getElementById('lowestRam1').style.display = 'none';
	  		document.getElementById('lowestRam2').style.display = '';
  		} else {
  			//location.href = "/fitc/comRecommend2";			
  		}
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
	margin: 20px 10px;
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
			<table>
				<thead>
					<tr>
						<th></th>
						<th>recommended</th>
						<th>The lowest price</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>CPU</td>
						<td id='cpuname'></td>
						<td id='lowestCpu1' style = 'display:;'></td>
						<td id='lowestCpu2' style = 'display:none;'></td>
					</tr>
					<tr>
						<td>GPU</td>
						<td id='gpuname'></td>
						<td id='lowestGpu1' style = 'display:;'></td>
						<td id='lowestGpu2' style = 'display:none;'></td>
					</tr>
					<tr>
						<td>RAM</td>
						<td id='memory'></td>
						<td id='lowestRam1' style = 'display:;'></td>
						<td id='lowestRam2' style = 'display:none;'></td>
					</tr>
					<tr>
						<td>MAINBOARD</td>
						<td id='mainboard'></td>
						<td></td>
					</tr>
					<tr>
						<td>POWER</td>
						<td id='power'></td>
						<td></td>
					</tr>
					<tr>
						<td>CASE</td>
						<td id='cas2'></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<button id = 'check1' style = 'display:;' onclick="lowerprice()">최저가 확인</button>
							<button id = 'check2' style = 'display: none;' >당신의 마음속에 저장</button>
						</td>
					
					</tr>
				</tbody>
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