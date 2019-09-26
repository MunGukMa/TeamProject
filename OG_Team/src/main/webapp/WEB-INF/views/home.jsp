<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>차트 연동하기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.bundle.min.js"></script>
	<script>
		var gameary = new Array();
		var gameicon = new Array();
		var addwin ;
		var testva;
		window.onload = function(){
			var ctx = document.getElementById("mainchart").getContext('2d');
			var myChart
			
			if(${dbchk}==false)
			{
				makedb();
			};
			
			$.ajax
			({
				url:"/one/gamelist",
				type:"get",
				async:false,
				dataType : "JSON",
				success:function(result)
				{
					for(var i=0;i<result.length;i++)
						{
							gameary[i] = result[i];
							$('#gameary[i].gamename').html(result[i]);

							gameicon[i] = new Image();
							gameicon[i].src = result[i].imagelink;
							gameicon[i].width = 50;
							gameicon[i].height = 50;
							gameicon[i].id= result[i].gamename;
							gameicon[i].glevel=result[i].gamelevel;							
						}										
				},
				error:function(){alert("error");}
			})			
			
			var data ={
		        datasets: [{
			        name: ['0,0', '10,10', gameary[0], gameary[1], gameary[2], gameary[3], gameary[4], gameary[5]],
			        pointRadius: 10,
			        pointHoverRadius: 10,
			        pointClickRadius: 15,
			        pointStyle:['circle','circle', gameicon[0], gameicon[1], gameicon[2], gameicon[3], gameicon[4], gameicon[5]],			
		            data: [{x:0, y:0}, {x:10, y:10}, {x:gameary[0].pclevel, y:gameary[0].gamelevel}, {x:gameary[1].pclevel, y:gameary[1].gamelevel}, {x:gameary[2].pclevel, y:gameary[2].gamelevel}, 
		            	{x:gameary[3].pclevel, y:gameary[3].gamelevel}, {x:gameary[4].pclevel, y:gameary[4].gamelevel}] //컨트롤러에서 모델로 받아온다.
		            
		        }]
		    }
				
			//chart 옵션 파트
			var option = {
				events: ['click'],
				tooltips: {
					enabled:false,
					mode: 'index',
					position: 'nearest',
					custom:  function (tooltip){
						/* testva = tooltip;
						if(tooltip!=null)
						{
							addwin = window.open("/one/test","_blank","width=400px,height=300px");
						} */
						
						document.getElementById('nondiv').style.display="";


		    	        
		    	        if (tooltip.dataPoints.length) {
		    	        	var i = tooltip.dataPoints[0].index;
		    	        	var isrc = gameicon[1].src;
		    	        	document.getElementById('rvbtn').name=data.datasets[0].name[i].gamename;
		    	        	document.getElementById('gameimg').src = data.datasets[0].pointStyle[i].src;
		    	            document.getElementById('spectype').innerText="권장사양";
		    	            document.getElementById('windowtype').innerText="64bit";
		    	            document.getElementById('cpuname').innerText=data.datasets[0].name[i].gamecpu;
		    	            document.getElementById('memory').innerText=data.datasets[0].name[i].gameram;
		    	            document.getElementById('gpuname').innerText=data.datasets[0].name[i].gamegpu;
		    	            document.getElementById('addop').innerText=data.datasets[0].name[i].gameaddop;
		    	        }

		    	        var positionY = this._chart.canvas.offsetTop;
		    	        var positionX = this._chart.canvas.offsetLeft;	

		    	     	// Display, position, and set styles for font
		    	     	
		    	        
		    		}
				},
				animation:{
					animationScale:true
				},
				responsive: false,
				scales:{
					yAxes:[
						{
							ticks:{
								beginAtZero : true
							}
						}
					]
				},
				legend:{
					display: false
				}
			}

			//차트 구성 파트
			myChart = new Chart(ctx, {
			    type: 'scatter',
			    data: data,
			    options: option	
			});
						                     			
		}
		
		function closediv()
		{
			document.getElementById('nondiv').style.display="none";
		}
		
		function pagemove(obj)
		{
			var gamename = obj.name;
			location.href="/one/makelist?gamename="+gamename; 
		}
		
						
	</script>
	<style>
		a
		{
			text-decoration:none;
		}
		/*div{
	        border: 1px solid #ccc;
	    }*/
	
	    h1, h5{
	        text-align: center;
	        font-family: 'NanumGothic';
	    }
	    
	    .box1{
	        margin-top: 30px;
	        margin-left: 20%;
	        width: 60%;
	        height: 60%;
	        margin-bottom: 5%; 
	        align-content: center
	    }
	
	    .box2{
	        float: right;
	        width: 10%;
	        margin-top: 30px;
	        margin-left: 5%;
	        margin-right: 5%;        
	        height: 50px;
	    }
	    .box3{
	        float: left;
	        width: 10%;
	        margin-top: 30px;
	        margin-left: 5%;
	        margin-right: 5%;
	        height: 50px;
	        align-text:center;
	    }
	    .footer{
	        text-align: center;
	        clear: both;
	    }
	    
	    
	    #topMenu{
	    	height : 30px;
	    	width : 120px;	    
	    }
	    
	    #topMenu ul{     /*메인메뉴 ul 설정*/
	    	list-style-type: none;
	    	margin: 0px;
	    	padding: 0px;
	    }
	    
	    #topMenu ul li{
	    	float: left;
	    	line-height: 30px;
	    	vertical-align: middle;
	    	text-align: center;
	    	position: relative;
	    }
	    
	    .menuLink, .submenuLink{
	    	text-decoration: none;
	    	display: block;
	    	width: 150px;
	    	font-weight: bold;	    
	    }
	    
	    .topMenuLi:hover .menuLink{
	    	color: red;
	    	background-color: #4d4d4d;
	    }
	    
	    .longLink{
	    	width: 150px;
	    }
	    
	    .submenu{
	    	position: absolute;
	    	height: 0px;
	    	overflow: hidden;
	    	transaction: height .2s;
	    	-webkit-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 크롬/사파라ㅣ) */
	        -moz-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 파폭) */
	        -o-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 오페라) */
	    }
	    
	    .submenuLink{
	    	border: solid 1px black;
	    	margin-top: -1px;
	    }
	    
	    
	    .submenuLink:hover{
	    	color: red;
	    }
	    
	    .topMenuLi:hover .submenu{
	    	height: 125px;
	    }
	    
	    .infoBanner{
	    	position: fixed;
	    	top: 20%;
	    	right: 20%;
	    }
	    
	    canvas{
	    	-moz-user-select: none;
	    	-webkit-user-select: none;
	    	-ms-user-select: none; 
	    	width: 100%;
	    	height:50%;
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
	    #nondiv
	    {
	    	position:absolute;
	    	left:55%;
	    	width:25%;
	    	top:20%;
	    	text-align:center;
	    	background:rgba;
	    	border:10px solid lightblue;
	    	border-radius:25px;
	    }
	</style>
</head>
<body>
	<header>
        <div>
            <h1>
                <a href="#" >Fit-c</a>
            </h1>
			<h5>
				Fit your game
			</h5>            
        </div>
    </header>
    <aside>
        <div class="box2">
	            사이드1<br>
	            광고가 들어갈 자리
        </div>
    </aside>
    <aside>
	    <div class="box3">
	    <nav id="topMenu">
		    <ul>
	        	<li class="topMenuLi" value="banner">
	        		<a class="menuLink">welcome</a>
	        		<ul class="submenu">
	        			<li><a href="#" class="submenuLink longLink">견적 맞추기</a></li>
	        			<li><a href="#" class="submenuLink longLink">게임 상세 랭킹</a></li>
	        			<li><a href="#" class="submenuLink longLink">사용자 게시판</a></li>
	        			<c:if test="${sessionScope.userid == null }">
	        				<li><a href="loginForm" class="submenuLink longLink">LOGIN</a></li>
	        			</c:if>
	        			<c:if test="${sessionScope.userid != null }">
	        				<li><a href="#" class="submenuLink longLink">LOGOUT</a></li>	        			
	        			</c:if>
	        			</ul>
	        	</li>
	        </ul>
	     </nav>
        </div>
    </aside>
	<section>
        <div class="box1" id="chart_div" >
	     <canvas id="mainchart" ></canvas>
	     <div id="nondiv" style="display:none;">
	     	<table style="width:100%;">
			<tr>
				<th colspan="2">
					<input type="hidden" id="gamename">
					<img id="gameimg" />
				</th>
			</tr>
			<tr>
				<th id="spectype" colspan="2">
				
				</th>
			</tr>
			<tr>
				<th>
					운영체제
				</th>
				<td id="windowtype">
				
				</td>
			</tr>
			<tr>
				<th>
					CPU
				</th>
				<td id="cpuname">
				
				</td>
			</tr>
			<tr>
				<th>
					MEMORY
				</th>
				<td id="memory">
				
				</td>
			</tr>
			<tr>
				<th>
					GPU
				</th>
				<td id="gpuname">
				
				</td>
			</tr>
			<tr>
				<th>
					Additional Option
				</th>
				<td id="addop">
				
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="rebtn" type="button" value="추천견적" onclick="alert('추천견적');">
					<input id="fitbtn" type="button" value="맞춤견적" onclick="alert('맞춤견적');">
					<input type="button" value="창 닫기" onclick="closediv();">
				</td>
			</tr>
		</table>
	     
    		</div>
        </div>	
     <div id="detail">
    		
    </div>
    
    </section>
	<footer>
        <div class="footer">
	            푸터<br>
	            출처가 들어갈 자리
        </div>
    </footer>
    
 
	
</body>
</html>
