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

		$('#cpuname').append(r[0]);
		$('#gpuname').append(r[2]);
		$('#memory').append(r[1]);
		document.getElementById('loading').style.display = '';
		document.getElementById('check1').style.display = 'none';
		document.getElementById('check2').style.display = 'none';
		
	  	$.ajax({
	  			url : '/one/compare/recommend',
	  			type : 'post',
	  			data : {'cpu': $('#cpuname').html() ,'ram': $('#memory').html(), 'gpu': $('#gpuname').html()},
	  			dataType : "JSON",
	  			success : function(result){
	  	  			$('#recommended_cpu').append(result.cpu);
	  	  			$('#recommended_cpu_amd').append(result.cpu_amd);
	  	  			$('#recommended_gpu').append(result.gpu);
	  	  			$('#recommended_ram').append(result.ram);
	  	  			$('#recommended_mainboard').append(result.mainboard);
	  	  			$('#recommended_mainboard_amd').append(result.mainboard_amd);
	  			  	$('#recommended_power').append(result.power);
	  				$('#recommended_case').append(result.pc_case);
	  				var cpu				= $('#recommended_cpu').html();	
	  		  		var ram 			= $('#recommended_ram').html();
	  		  		var gpu 			= $('#recommended_gpu').html();
	  		  		var mainboard		= $('#recommended_mainboard').html();
	  		  		var power 			= $('#recommended_power').html();
	  		  		var pc_case 		= $('#recommended_case').html();
	  		  		
	  		  		
	  		  		var cpu_amd			= $('#recommended_cpu_amd').html();
	  		  		var mainboard_amd 	= $('#recommended_mainboard_amd').html();

	  		  		$.ajax({
	  			  			url : '/one/compare/lowest',
	  			  			type : 'post',
	  			  			data : {'cpu': cpu ,'ram': ram, 'gpu': gpu, 'mainboard': mainboard, 'power': power, 'pc_case': pc_case,'cpu_amd': cpu_amd,'mainboard_amd': mainboard_amd},
	  			  			dataType : "JSON",
	  			  			success : function(r){
	  		  	  			$('#lowestCpu1').append(r.cpu);
	  		  	  			$('#lowestGpu1').append(r.gpu);
	  		  	  			$('#lowestRam1').append(r.ram);
	  		  	  			$('#lowestMainboard1').append(r.mainboard);
	  		  	  			$('#lowestPower1').append(r.power);
	  		  	  			$('#lowestCase1').append(r.pc_case);
	  		  	  			
	  		  	  			$('#lowestCpu1_amd').append(r.cpu_amd);
	  		  	 		 	$('#lowestMainboard1_amd').append(r.mainboard_amd);
	  		  	 			document.getElementById('loading').style.display = 'none';
	  		  	 			document.getElementById('check1').style.display = '';
	  			  			},
	  			  			error : function(){
	  			  				alert("ERROR!!!!!");
	  			  			}
	  			  	
	  			  		}) 
  			
	  			},
	  			error : function(){
	  				alert("빙시나");
	  			}
	  	
	  	})
	  	
	})
	
	function lowerprice(){
  	 	 	document.getElementById('check1').style.display = 'none';
	  		document.getElementById('check2').style.display = '';
	  		document.getElementById('check3').style.display = '';
	  		
  	  		if(document.getElementById('intel_check').style.display == 'none') {
  				document.getElementById('lowestCpu1').style.display = '';
  				document.getElementById('lowestCpu1_amd').style.display = 'none';
  				document.getElementById('lowestCpu2').style.display = 'none';
  	  		} else {
  	  			document.getElementById('lowestCpu1').style.display = 'none';
				document.getElementById('lowestCpu1_amd').style.display = '';
				document.getElementById('lowestCpu2').style.display = 'none';
  	  		}
  			
	  		document.getElementById('lowestGpu1').style.display = '';
	  		document.getElementById('lowestGpu2').style.display = 'none';
	  		document.getElementById('lowestRam1').style.display = '';
	  		document.getElementById('lowestRam2').style.display = 'none';
	  		
	  		if(document.getElementById('intel_check').style.display == 'none') {
  				document.getElementById('lowestMainboard1').style.display = '';
  				document.getElementById('lowestMainboard1_amd').style.display = 'none';
  				document.getElementById('lowestMainboard2').style.display = 'none';
  	  		} else {
  	  			document.getElementById('lowestMainboard1').style.display = 'none';
				document.getElementById('lowestMainboard1_amd').style.display = '';
				document.getElementById('lowestMainboard2').style.display = 'none';
  	  		}
	  		
	  		document.getElementById('lowestPower1').style.display = '';
	  		document.getElementById('lowestPower2').style.display = 'none';
	  		document.getElementById('lowestCase1').style.display = '';
	  		document.getElementById('lowestCase2').style.display = 'none';

	}
	function amd(){
  			
	  	  	document.getElementById('intel_check').style.display = '';
	  	  	document.getElementById('amd_check').style.display = 'none';
	  	  	document.getElementById('recommended_cpu').style.display = 'none';
	  		document.getElementById('recommended_mainboard').style.display = 'none';
	  		document.getElementById('recommended_cpu_amd').style.display = '';
	  		document.getElementById('recommended_mainboard_amd').style.display = '';
	  		
	  		if(document.getElementById('check1').style.display == 'none'&&document.getElementById('loading').style.display == 'none') {
	  			document.getElementById('lowestCpu1_amd').style.display = '';
	  			document.getElementById('lowestCpu1').style.display = 'none';
	  			document.getElementById('lowestMainboard1_amd').style.display = '';
	  			document.getElementById('lowestMainboard1').style.display = 'none';
	  		}

	}
	function intel(){
		
  		document.getElementById('intel_check').style.display = 'none';
  		document.getElementById('amd_check').style.display = '';
		document.getElementById('recommended_cpu').style.display = '';
		document.getElementById('recommended_mainboard').style.display = '';
		document.getElementById('recommended_cpu_amd').style.display = 'none';
		document.getElementById('recommended_mainboard_amd').style.display = 'none';
		
		
		if(document.getElementById('check1').style.display == 'none'&&document.getElementById('loading').style.display == 'none') {
  			document.getElementById('lowestCpu1_amd').style.display = 'none';
  			document.getElementById('lowestCpu1').style.display = '';
  			document.getElementById('lowestMainboard1_amd').style.display = 'none';
  			document.getElementById('lowestMainboard1').style.display = '';
  		}
 
	}
</script>
<style>
a {
	text-decoration: none;
}

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

/* table {
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
}  */
html, body {
	height: 100%;
}

body {
	margin: 0;
	/* background: linear-gradient(45deg, #49a09d, #5f2c82); */
	/* background: linear-gradient(45deg, #49a09d, #5f2c82); */
	/* background: radial-gradient(circle, rgba(2,0,36,1) 0%, rgba(9,9,41,1) 35%, rgba(0,212,255,1) 100%); */
	
	font-family: sans-serif;
	font-weight: 100;
}

/* .recommended {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
} */

table {
background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);
	width: 800px;
	border-collapse: separate;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
	border-spacing: 1px; 
	text-align: center;
	line-height: 1.5;
	margin: 20px 10px;
	margin-left: auto;
	margin-right: auto; 
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
	background-color: #55608f;
}


tr:hover {
			background-color: rgba(255,255,255,0.2);
}
td:hover {
			background-color: rgba(255,255,255,0.4);
}
/* .row1:hover {
	background-color: rgba(255,255,255,0.2);
} */


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
		<div class = "recommended">
			<table>
				<thead>
					<tr>
						<th></th>
						<th>game_spec</th>
						<th>recommended_spec</th>
						<th>The lowest price</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>CPU</td>
						<td id='cpuname'></td>
						<td id='recommended_cpu'></td>
						<td id='recommended_cpu_amd' style = 'display:none;'></td>
						<td id='lowestCpu1' style = 'display:none;'></td>
						<td id='lowestCpu1_amd' style = 'display:none;'></td>
						<td id='lowestCpu2' style = 'display:;'></td>
					</tr>
					<tr>
						<td>GPU</td>
						<td id='gpuname'></td>
						<td id='recommended_gpu'></td>
						<td id='lowestGpu1' style = 'display:none;'></td>
						<td id='lowestGpu2' style = 'display:;'></td>
					</tr>
					<tr>
						<td>RAM</td>
						<td id='memory'></td>
						<td id='recommended_ram'></td>
						<td id='lowestRam1' style = 'display:none;'></td>
						<td id='lowestRam2' style = 'display:;'></td>
					</tr>
					<tr>
						<td>MAINBOARD</td>
						<td></td>
						<td id='recommended_mainboard'></td>
						<td id='recommended_mainboard_amd' style = 'display:none;'></td>
						<td id='lowestMainboard1' style = 'display:none;'></td>
						<td id='lowestMainboard1_amd' style = 'display:none;'></td>
						<td id='lowestMainboard2' style = 'display:;'></td>
					</tr>
					<tr>
						<td>POWER</td>
						<td></td>
						<td id='recommended_power'></td>
						<td id='lowestPower1' style = 'display:none;'></td>
						<td id='lowestPower2' style = 'display:;'></td>
					</tr>
					<tr>
						<td>CASE</td>
						<td></td>
						<td id='recommended_case'></td>
						<td id='lowestCase1' style = 'display:none;'></td>
						<td id='lowestCase2' style = 'display:;'></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<button id = 'intel_check' style = 'display:none;' onclick="intel()">Intel추천</button>
							<button id = 'amd_check' style = 'display: ;' onclick="amd()" >AMD추천</button>
						</td>
						<!-- <td id='loading'>최저가 가져오는 중</td> -->
						<td id='result'>
							<a href = "#" id='loading'>최저가 가져오는 중</a>
							<button id = 'check1' style = 'display: none;' onclick="lowerprice()">최저가 확인</button>
							<button id = 'check2' style = 'display: none;' >저장하기</button>
							<button id = 'check3' style = 'display: none;' >직접견적</button>
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
