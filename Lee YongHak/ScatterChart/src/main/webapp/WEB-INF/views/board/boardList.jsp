<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>차트 연동하기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script>

	function logIN(){
		var form = document.getElementById("login");
		form.submit();

		if(result==false){
			alert("아이디와 비밀번호를 확인해주세요");
			return;
		}
		
	}

	function pageProc(currentPage, searchItem, searchKeyword) {
		location.href="/three/board/boardList?currentPage=" + currentPage + "&searchItem=" + searchItem + "&searchKeyword=" + searchKeyword;
	}
							
	</script>
	<style>
		a
		{
			text-decoration:none;
		}
		
		a:hover{
			text-decoration:none;
		}
		
		/*div{
	        border: 1px solid #ccc;
	    }*/
	    
	    .th_num{
	    	width:10%;
	    }
	    
	    .th_title{
	    	width:50%;
	    }
	    
	    .th_fitc_id{
	    
	    }
	    
	    .th_hit{
	    	width:10%;
	    }
	    
	    .th_date{
	    	width:15%;
	    }
	    
	    
	    th{
	    	text-align:center;
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
	    	width: 148px;
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
<c:choose>
	<c:when test="${d_result == true}">
		<script>alert("삭제 완료");</script>
	</c:when>
	<c:when test="${d_result == false}">
		<script>alert("삭제 실패");</script>
	</c:when>
	<c:when test="${w_result == true}">
		<script>alert("등록 완료");</script>
	</c:when>
	<c:when test="${w_result == false}">
		<script>alert("등록 실패");</script>
	</c:when>
</c:choose>
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
	    	<form id="/three/login" action="logIN" method="post">
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
	<h2 style="text-align:center"> [견적게시판] </h2>
	<hr/>
        <div class="box1" id="board_div" >
	    	<table style="margin-left: auto; margin-right: auto;" class="table table-bordered table-striped table-hover">
	    		<thead>
				<tr>
					<th class="th_num">번호</th>
					<th class="th_title">제목</th>
					<th class="th_fitc_id">작성자</th>
					<th class="th_hit">조회</th>
					<th class="th_date">날짜</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="boardVO">
					<tr>
						<td class="center" style="text-align:center">${boardVO.b_num}</td>
						<td id="title" style="padding-left:2%"><a href="/three/board/boardRead?b_num=${boardVO.b_num}">${boardVO.title}</a></td>
						<td class="center" style="text-align:center">${boardVO.fitc_id}</td>
						<td class="center" style="text-align:center">${boardVO.hit}</td>
						<td id="inputdate" style="text-align:center">
							<fmt:parseDate value="${boardVO.b_date}" var="parseRegdate" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${parseRegdate}" pattern="MM.dd HH:mm"/>	
						</td>
					</tr>
				</c:forEach>
				</tbody>
				<tr style="text-align:center">
					<td id="navigator" colspan="5">
						<a href="javascript:pageProc(${navi.currentPage - navi.pagePerGroup}, '${searchCondition}', '${searchKeyword}')">◁◁ </a> &nbsp;&nbsp;
						<a href="javascript:pageProc(${navi.currentPage - 1}, '${searchCondition}', '${searchKeyword}')">◀</a> &nbsp;&nbsp;
					
						<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}"> 
							<c:if test="${counter == navi.currentPage}"><b></c:if>
								<a href="javascript:pageProc(${counter}, '${searchCondition}', '${searchKeyword}')">${counter}</a>&nbsp;
							<c:if test="${counter == navi.currentPage}"></b></c:if>
						</c:forEach>
						&nbsp;&nbsp;
						<a href="javascript:pageProc(${navi.currentPage + 1}, '${searchCondition}', '${searchKeyword}')">▶</a> &nbsp;&nbsp;
						<a href="javascript:pageProc(${navi.currentPage + navi.pagePerGroup}, '${searchCondition}', '${searchKeyword}')">▷▷</a>
					</td>
				</tr>						
				<tr>
					<td id="boardSearch" colspan="5" style="text-align:center">
					<form action="/three/board/boardList" method="get">
						<select name="searchItem">
							<option value="title" selected="selected">제목</option>
							<option value="fitc_id">작성자</option>
						</select>
						<input type="text" name="searchKeyword">
						<input type="submit" value="검색" >
						<button type="button" class="btn" >버튼</button>
					</form>
					</td>
				</tr>				
			</table>
			<hr/>
			<a class="btn btn-default pull-right" href="/three/board/boardWriteForm">글쓰기</a>
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