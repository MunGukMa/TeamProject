<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table
	{
		text-align:center;
	}
</style>

</head>
<body>
	<table border="1">
		<tr>
			<th colspan="3">
				<img src="${game. imagelink}"><h2>${game.gamename}의 직접견적</h2>
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
				<input type="text"><input type="button" value="검색">
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
				<input type="text"><input type="button" value="검색">
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
				<input type="text"><input type="button" value="검색">
			</td>
		</tr>
		<tr>
			<th>
				MAINBOARD
			</th>
			<td>
				
			</td>
			<td>
				<input type="text"><input type="button" value="검색">
			</td>
		</tr>
		<tr>
			<th>
				POWER
			</th>
			<td>
				
			</td>
			<td>
				<input type="text"><input type="button" value="검색">
			</td>
		</tr>
		<tr>
			<th>
				CASE
			</th>
			<td>
				
			</td>
			<td>
				<input type="text"><input type="button" value="검색">
			</td>
		</tr>
		
	</table>



</body>
</html>