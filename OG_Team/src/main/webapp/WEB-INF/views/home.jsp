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
			
			//chart 데이터값 파트
			var data ={
		        datasets: [{
			        name: [gameary[0], gameary[1], gameary[2], gameary[3], gameary[4], gameary[5]],
			        pointRadius: 10,
			        pointHoverRadius: 10,
			        pointClickRadius: 15,
			        pointStyle:[gameicon[0], gameicon[1], gameicon[2], gameicon[3], gameicon[4], gameicon[5]],			
		           	data: [{x:gameary[0].pclevel, y:gameary[0].gamelevel}, {x:gameary[1].pclevel, y:gameary[1].gamelevel}, {x:gameary[2].pclevel, y:gameary[2].gamelevel}, 
		            	{x:gameary[3].pclevel, y:gameary[3].gamelevel}, {x:gameary[4].pclevel, y:gameary[4].gamelevel}]
		            
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
				scales: {
					xAxes: [{
					    gridLines: {
						display:false,    //x축 그래프 내부 눈금선 지우기
						color:"red",      //x축의 선 색상
						lineWidth:3       //x축의 선 굵기
					    },
					    ticks: {    //x축 최소값 최대값 기준치 설정
						min: 0,
						max: 10,
						stepSize:1,	//x축 눈금 간격 1로 설정
			            		fontSize:15,	//x축 눈금자 숫자 크기 설정
			            		fontColor:"red"	//x축 눈금자 숫자 색상 설정
					    },
					    scaleLabel: {	//x축 데이터 라벨 추가
						display: true,
						labelString: "GAME LEVEL",
						fontColor: "black",
						fontSize: "15",
						fontFamily:"'Lobster', cursive",	//x축 라벨 폰트 설정
					    }   
					}],
					yAxes: [{
					    gridLines: { 
						display:false,	//y축 그래프 내부 눈금선 지우기
						color:"red",	//y축의 선 색상
						lineWidth:3	//y축의 선 굵기
					    },
					    ticks: {
						min: 0,
						max: 10,
						fontSize:15,	//y축 눈금자 숫자 크기 설정
						fontColor:"red"	//y축 눈금자 숫자 색상 설정
					    },
					    scaleLabel: {	//y축 데이터 라벨 추가
						display: true,
						labelString: "PC LEVEL",
						fontColor: "black",
						fontSize: "15",
						fontFamily:"'Lobster', cursive",	//y축 라벨 폰트 설정
					    }   
					}]
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
			
			dbchk;
						                     			
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
		
		function fitEstimate() {
		var estimate = confirm("본인의 컴퓨터 부품에 대해 알고 계신가요?");
		if(estimate == true){
			location.href = "/one/comInfo"
		} else {
			location.href = "/one/infoCheck";			
		}
		
	}
	function dbchk()
		{
			$.ajax({
				url:"/one/dbchk",
				type:"get",
				success:function(result)
				{
					var a = result;
					alert(a)
					if(a=="false")
					{
						alert("makedb접속");
						$.ajax
						({
							url:"/one/db/makedb",
							type:"get",
							error:function()
							{
								alert("error");
							}
						})
					}
				},
				error:function()
				{
					dbchk;
				}
			})
			
		}	
		
		///////////////////////// Add 1002 update1005 //////////////////////////////////
		function logIN(){
			$.ajax({
				url:"/one/logIN",
				type:"post",
				data:$('#login').serialize(),
				dataType:"json",
				success:function(result)
				{
					if(result ==1){
						location.reload();
					} else if (result ==2)
					{
						alert("메일인증을 완료해주세요");
					} else 
					{
						alert("ID혹은 PASSWORD가 정확하지않습니다");
					}
				},
				error:function()
				{
					alert("Error!");
				}
				
			})
		}	
		//////////////////////// Add 1005 ////////////////////////////
		function fitRecommend() {
  		var estimate = confirm("해당 게임의 사양의 견적을 확인하시겠습니까?");
  		var cpuname = $('#cpuname').html();
  		var memory = $('#memory').html();
  		var gpuname = $('#gpuname').html();

  		if(estimate == true){
  			$.ajax({
  	  			url : '/fitc/gameSpec',
  	  			type : 'post',
  	  			data : {'cpuname':cpuname,'memory':memory,'gpuname':gpuname},
  	  			dataType : "JSON",
  	  			success : function(result){
  	  				sessionStorage.setItem("vo", JSON.stringify(result));
  	  				location.href = "/fitc/comRecommend"
  	  			},
  	  			error : function(){
  	  				alert("ERROR");
  	  			}
  	  	
  	  		})
  		
  		} else {
  			location.href = "/fitc/";			
  		}
  		
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
	    
	    /*타이틀 높이 설정*/
	    .title{
	    	height:10%;	    	
	    }
	    /*로그인 메뉴바 공간 설정*/
	    .loginMenuBar{
	    	width:80%;
	    	height: 5%;
	    	margin-left: 10%;
	    	margin-top: 1.25%;	    	
	    }
	    /*로그인 메뉴 테이블 설정*/
	    .loginMenu{
	    	margin-left: auto;
	    	margin-right: auto;
	    	align:center;
	    	border-spacing:10px;
	    }
	    /* box1~3  각 구역 크기 재설정  */
	    .box1{
	        margin-left: 10%;
	        width: 75%;
	        height: 60%;
	        align-content: center
	    }
	
	    .box2{
	        float: right;
	        width: 8%;
	        margin-top: 30px;
	        margin-left: 1%;
	        margin-right: 1%;        
	        
	    }
	    .box3{
	        float: left;
	        width: 8%;
	        margin-top: 30px;
	        margin-left: 1%;
	        margin-right: 1%;
	       
	    }
	    .footer{
	    	margin-top:1.25%;
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
    <!-- title 클래스 이름 선언 --!>
    <header>
        <div class = "title">
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
		   <c:if test="${sessionScope.fitc_id != null }">
		    <ul>
	        	<li class="topMenuLi" value="banner">
	        		<a class="menuLink">${sessionScope.fitc_nickname}님 Welcome</a>
	        		<ul class="submenu">
	        			<li><a href="#" class="submenuLink longLink">메뉴1</a></li>
	        			<li><a href="#" class="submenuLink longLink">메뉴2</a></li>
	        			<li><a href="/one/board/boardList" class="submenuLink longLink">견적게시판</a></li>
	        			<li><a href="/one/logOUT" class="submenuLink longLink">LOGOUT</a></li>
	        			<li><a href="/one/updateInfoForm" class="submenuLink longLink">회원정보 수정</a></li>
	        		</ul>
	        	</li>
	        </ul>
	    </c:if>
	    <!-- 로그인메뉴 왼쪽 메뉴바에서 삭제 --!>
	    </nav>
        </div>
    </aside>
    <!-- 로그인메뉴 차트위 상단으로 이동 --!>
    <nav>
    	<div class="loginMenuBar">
    		<c:if test="${sessionScope.fit_member== null }">
    		<form id="login" action="logIN" method="post">
	    		<table class="loginMenu">
	    			<tr>
	    				<td>로그인 : </td>
	    				<td><input type="text" name="fit_userid" id="fitc_id" placeholder="ID" placeholder="ID"></td>
	    				<td>비밀번호 : </td>
	    				<td><input type="password" name="fit_userpwd" id="fitc_pw" placeholder="PASSWORD"></td>
	    				<td><input type="button" value="로그인" onclick="logIN()" style="width:100%" /></td>
	    				<td><a href="signupForm" style="font-size:10px" >아직 회원이 아니신가요?</a></td>
	    				<td><a href="javascript:;" onclick="window.open('searchInfoForm','pop','resizeable=no scrollbars=yes width=600 height=400');return false" style="font-size:10px" > 아이디 / 비밀번호 찾기 </a></td>
	    			</tr>
	    		</table>
    		</form>
    		</c:if>
    	</div>
    </nav>
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
					<input id="rebtn" type="button" value="추천견적" onclick="fitRecommend();">
					<input id="fitbtn" type="button" value="맞춤견적" onclick="fitEstimate();">
					<input type="button" value="창 닫기" onclick="closediv();">
				</td>
			</tr>
		</table>
	     
    		</div>
        </div>	
    <!--<div id="detail">
    </div> -->    
		
    </section>
	<footer>
        <div class="footer">
	            푸터<br>
	            출처가 들어갈 자리
        </div>
    </footer>
    
 
	
</body>
</html>
