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
		var temp;
		var gameary = new Array();
		var gameicon = new Array();
		
		window.onload = function(){
			var ctx = document.getElementById("example").getContext('2d');
			var myChart
			
			$.ajax
			({
				url:"/three/list",
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
		            	{x:gameary[3].pclevel, y:gameary[3].gamelevel}, {x:gameary[4].pclevel, y:gameary[4].gamelevel}, {x:gameary[5].pclevel, y:gameary[5].gamelevel} ] //컨트롤러에서 모델로 받아온다.
		            
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
		    			var tooltipEl = document.getElementById('chartjs-tooltip');   // Tooltip Element 

		    			if (tooltip.opacity === 0) {		 // Hide if no tooltip
		    		        tooltipEl.style.opacity = 0; 
		    		        return; 
		    		    }

		    			tooltipEl.classList.remove('above', 'below', 'no-transform');		// Set caret Position
		    	        if (tooltip.yAlign) {
		    	        	tooltipEl.classList.add(tooltip.yAlign);
		    	        } else {
		    	        	tooltipEl.classList.add('no-transform');
		    	        }

		    	        
		    	        if (tooltip.dataPoints.length) {
		    	        	var i = tooltip.dataPoints[0].index;
		    	            
		    	        	$("#spn-title").text(data.datasets[0].name[i].gamename);
		    	            $("#spn-gLv").text(data.datasets[0].data[i].y);
		    	            $("#spn-pLv").text(data.datasets[0].data[i].x);
		    	            $("#spn-cpu").text(data.datasets[0].name[i].cpu);
		    	            $("#spn-ram").text(data.datasets[0].name[i].ram);
		    	            $("#spn-vga").text(data.datasets[0].name[i].vga);
		    	        }

		    	        var positionY = this._chart.canvas.offsetTop;
		    	        var positionX = this._chart.canvas.offsetLeft;	

		    	     	// Display, position, and set styles for font
		    	     	
		    	        tooltipEl.style.opacity = 1;
		    	        tooltipEl.style.left = positionX + tooltip.caretX + 'px';
		    	        tooltipEl.style.top = positionY + tooltip.caretY + 'px';
		    	        tooltipEl.style.fontFamily = tooltip._fontFamily;
		    	        tooltipEl.style.fontSize = tooltip.fontSize;
		    	        tooltipEl.style.fontStyle = tooltip._fontStyle;
		    	        tooltipEl.style.padding = tooltip.yPadding + 'px ' + tooltip.xPadding + 'px';    
		    	        
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
						
	</script>
	<style>
		/*div{
	        border: 1px solid #ccc;
	    }*/
	
	    h1{
	        text-align: center;
	        font-family: 'NanumGothic';
	    }
	    
	    .box1{
	        margin-top: 30px;
	        margin-left: 20%;
	        width: 40%;
	        height: 400px;
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
		    min-width: 200px; 
	    }
	    
	    .chartjs-tooltip-key { 
		    display: inline-block;		
		    width: 10px; 		
		    height: 10px; 		
		    margin-right: 10px; 	
	    }
	</style>
</head>
<body>
	<header>
        <div>
            <h1>
                <a href="#" >Fit-c</a>
            </h1>
            
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
        <div class="box1" id="chart_div" style="width: 900px; height: 500px;">
	            본문<br>
	            그래프가 들어갈 자리 
	     <canvas id="example" width="600" height="400"></canvas>
	     
        </div>	
    </section>
	<footer>
        <div class="footer">
	            푸터<br>
	            출처가 들어갈 자리
        </div>
    </footer>
    
    <div id="chartjs-tooltip" class="center bottom">
    	<p><span><span id="spn-title"></span>의 견적</span></p>
    	<div>
    		<span>gamelevel : <span id ="spn-gLv"></span></span><br />
    		<span>pclevel : <span id="spn-pLv"></span></span><br />
    		<span>CPU : <span id="spn-cpu"></span></span><br />
    		<span>RAM : <span id="spn-ram"></span></span><br />
    		<span>VGA : <span id="spn-vga"></span></span><br />
    		<span><a href ="#">링크 test</a></span>
    	</div>
    </div>
	
</body>
</html>