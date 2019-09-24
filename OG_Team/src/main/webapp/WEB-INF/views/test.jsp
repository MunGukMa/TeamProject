<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	var tempid
	$(function()
	{
		$('#rebtn').on('click',recommend);
		$('#fitbtn').on('click',fitcommend);
		$('#rvbtn').on('click',rowvalue);
		tempid = opener.document.getElementById("chartjs-tooltip");
		var temp = tempid.innerText;
		var templist = temp.split('\n');
		document.getElementById("gamename").innerText = templist[0];
		
	});
	
	
	function recommend()
	{
		
	}
	function fitcommend()
	{
		
	}
	function rowvalue()
	{
		
	}
</script>
</head>
<body>
	<div class="wrapper">
		<table>
			<tr>
				<td id="gameimg">
					
				</td>
				<th id="gamename" colspan="2">
					
				</th>
			</tr>
			<tr>
				<th id="spectype" colspan="3">
				
				</th>
			</tr>
			<tr>
				<th>
					운영체제
				</th>
				<td colspan="2" id="windowtype">
				
				</td>
			</tr>
			<tr>
				<th>
					CPU
				</th>
				<td colspan="2" id="cpuname">
				
				</td>
			</tr>
			<tr>
				<th>
					MEMORY
				</th>
				<td colspan="2" id="memory">
				
				</td>
			</tr>
			<tr>
				<th>
					GPU
				</th>
				<td colspan="2" id="gpuname">
				
				</td>
			</tr>
			<tr>
				<th>
					Additional Option
				</th>
				<td colspan="2" id="addop">
				
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input id="rebtn" type="button" value="추천견적">
					<input id="fitbtn" type="button" value="맞춤견적">
					<input id="rvbtn" type="button" value="최저가견적">
				</td>
			</tr>
		</table>
	
	</div>
</body>
</html>