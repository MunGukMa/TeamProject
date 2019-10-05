<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맞춤 견적</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.bundle.min.js"></script>
<script>
	$(function(){
		var result = sessionStorage.getItem('resultGP');
		if(result != null){
			$('#graphicList').remove();
			$(result).each(function(index, item){
				$('#graphicList').append("<td>" + item.product_name + "</td><td><input type='radio' class='selectGP'>")
			})
		}
	})
</script>
<style>

</style>
</head>
<body>

	<table border="1">
		<tr><th colspan="2">검색하신 Graphic Card 정보</th></tr>
		<tr id="graphicList">
		</tr>
		<tr><td colspan="2"><input type="button" value="선택" id="confirm"></td></tr>
	</table>

</body>
</html>