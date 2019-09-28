<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>차트 연동하기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>	
	<script>
	
		/*function write(){
			var form = document.getElementById("boardWriteForm");
			form.submit();
		}*/

		alert("CPU : ${pcsetList.get(1).cpu},\n RAM : ${pcsetList.get(1).ram},\n VGA : ${pcsetList.get(1).vga},\n CASE : ${pcsetList.get(1).pc_case}");
		
		function pcsetting(){
			for(var i = 0; i<${pcsetList.size()}; i++){
				if(pcset.value == '-1'){
					pcsets.value='';
				}else if(pcset.value == 'i'){
					pcsets.value="CPU : ${pcsetList.get(i).cpu}, RAM : ${pcsetList.get(i).ram}, VGA : ${pcsetList.get(i).vga}, CASE : ${pcsetList.get(i).pc_case}";
					pcsets.readonly = true;
				}
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
	    
	    table, th, td{
	        border: 1px solid #ccc;
	    }
	
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
	    	height: 156px;
	    }
	    
	    .infoBanner{
	    	position: fixed;
	    	top: 20%;
	    	right: 20%;
	    }
	    
	</style>
</head>
<body>
	<header>
        <div>
            <h1>
                <a href="/three" >Fit-c</a>
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
	        			<li><a href="/three/board/boardList" class="submenuLink longLink">견적게시판</a></li>
	        			<li><a href="/three/logOUT" class="submenuLink longLink">LOGOUT</a></li>
	        			<li><a href="/three/updateInfoForm" class="submenuLink longLink">회원정보 수정</a></li>
	        		</ul>
	        	</li>
	        </ul>
	    </c:if>
	    <c:if test="${sessionScope.fitc_id == null }">
	    	<form id="login" action="logIN" method="post">
				<table style="border:1px solid #ccc; width:140%">
					<tr>
						<td width="250px"><input type="text" name="fitc_id" id="fitc_id" placeholder="ID" style="width:90%" /></td>
					</tr>
					<tr>
						<td width="250px"><input type="password" name="fitc_pw" id="fitc_pw" placeholder="PASSWORD" style="width:90%" /></td>
					</tr>
					<tr>
						<td width="250px"><input type="button" value="로그인" onclick="logIN()" style="width:100%" /></td>
					</tr>
				</table>		
			</form>
			<a href="signupForm" style="font-size:10px" >아직 회원이 아니신가요?</a><br>
			<a href="#" onclick="window.open('searchInfoForm','pop','resizeable=no scrollbars=yes width=600 height=400');return false" style="font-size:10px" > 아이디 / 비밀번호 찾기 </a>
	    </c:if>
	    </nav>
        </div>
    </aside>
	<section>
	<h2 style="text-align:center"> [글 작성] </h2>
        <div>
		    <form action="/three/board/boardWrite" id="boardWriteForm" name="boardWriteForm" method="post">
		        <div>
		            <div>
		                <table style="margin-left: auto; margin-right: auto;">
		                    <tr>
		                        <th>제목</th>
		                        <td><input style="width: 500px" type="text" id="title" name="title" /></td>
		                    </tr>		                    
		                    <tr>
		                        <th>견적</th>
		                        <td>
		                        	<input type="text" name="pcsets" id="pcsets" style="width:400px"><br>
		                        	<select style="width:300px" class="pcset" name="pcset" id="pcset" onchange="pcsetting()">
		                        		<option value="-1" selected>견적을 선택하세요</option>
		                        		<c:forEach var="i" begin="0" end="${pcsetList.size()-1 }" >
		                        		<option value="i">견적 ${pcsetList.get(i).getPcnum()}</option>
		                        		</c:forEach>
		                        	</select>
		                        </td>
		                    </tr>		                    
		                    <tr>
		                        <th>내용</th>
		                        <td><textarea style="width: 500px" rows="10" cols="10" id="b_content" name="b_content"></textarea></td>
		                    </tr>
		                    
		                </table>
		                <input type="hidden" name="fitc_id" value="${sessionScope.fitc_id }">
		                <div style="text-align:center">
		                    <input type="submit" value="등록" />
		                    <a href='/three/board/boardList'>취소</a>
		                </div>
		            </div>
		        </div>
		    </form>
		</div>
    </section>
    <br><br>
	<footer>
        <div class="footer">
	            푸터<br>
	            출처가 들어갈 자리
        </div>
    </footer>    
</body>
</html>