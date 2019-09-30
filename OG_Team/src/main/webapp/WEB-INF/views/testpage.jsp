<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"
  integrity="sha256-0YPKAwZP7Mp3ALMRVB2i8GXeEndvCq3eSl/WsAl1Ryk="
  crossorigin="anonymous"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
	var malist;
	
	window.onload=function()
	{
		var languages = [
			"ActionScript", "AppleScript", "Asp","BASIC", "C",
			"C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
			"Fortran", "Groovy", "Haskell", "Java", "JavaScript",
			"Lisp", "Perl", "PHP", "Python", "Ruby",
			"Scala", "Scheme"
		];
		
		
		$('.userspec').autocomplete({
			source: function(request,response)
			{
				$.ajax({
					url:"getauto",
					type:"get",
					dataType: "json",
					data:{keyvalue : request.term},
					success: function(data)
					{
						response($.map(data, function(item) 
		                {
		                 	return {label: item,value: item}
		                }));
					}
				})
			},
			focus: function(event, ui){ return false;},
			minLength: 2
		});
	}
	

	
	
</script>
<style>
	table
	{s
		text-align:center;
	}
</style>

</head>
<body>
	<table border="1">
		<tr>
			<th colspan="3">
				<img src="${game. imagelink}">
				<h2><%-- ${sessionScope.userid} --%>마문국님의 견적서</h2>
			</th>
		</tr>
		<tr>
			<th>
				품명	
			</th>
			<th>
				추천
			</th>
			<th>
				직접
			</th>
		</tr>
		<tr>
			<th>
				CPU
			</th>
			<td>
				${game.gamecpu}
			</td>
			<td>
				<input class="userspec" name="usercpu" id="usercpu" type="text"><input type="button" value="검색">
			
			</td>
		</tr>
		<tr>
			<th>
				GPU
			</th>
			<td>
				${game.gamegpu}
			</td>
			<td>
				<input class="userspec" name="usergpu" id="usergpu" type="text"><input type="button" value="검색">
				<div id="autocom"></div>
			</td>
		</tr>
		<tr>
			<th>
				RAM
			</th>
			<td>
				${game.gameram}
			</td>
			<td>
				<input class="userspec" name="userram" id="userram" type="text"><input type="button" value="검색">
				<div id="autocom"></div>
			</td>
		</tr>
		<tr>
			<th>
				MAINBOARD
			</th>
			<td>
				
			</td>
			<td>
				<input class="userspec" name="usermainboard" id="usermainboard" type="text"><input type="button" value="검색">
				<div id="autocom"></div>
			</td>
		</tr>
		<tr>
			<th>
				POWER
			</th>
			<td>
				
			</td>
			<td>
				<input class="userspec" name="userpower" id="userpower" type="text"><input type="button" value="검색">
				<div id="autocom"></div>
			</td>
		</tr>
		<tr>
			<th>
				CASE
			</th>
			<td>
				
			</td>
			<td>
				<input class="userspec" name="usercase" id="usercase" type="text"><input type="button" value="검색">
				<div id="autocom"></div>
			</td>
		</tr>
		
	</table>
	
</body>
</html>
