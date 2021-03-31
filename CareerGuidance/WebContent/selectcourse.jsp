<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function freeuser(){

	location.replace("http://localhost:8080/CareerGuidance/freeuser.jsp")
}
</script>
<style type="text/css">
.button{
	background-color: white;
	border: #000000;
	color: white;
	font-size: 20px;
	margin: 2px 2px;
	padding:10px 20px;
}

.button {
	background-color:#48D1CC;
	color: white;
}

.button:hover {
	background-color: #5F9EA0;
	color: white;
}
body{
        background-color:#FFFFE0;
    }
</style>
<title>Select course</title>
</head>
<body>
<h1 align="center">Select your course from below</h1>
<div align="center">
<table>
 <tr> 
<td class="button"><input type="submit" value="Science" class="button"></td>
<td></td> <td></td>
<td class="button"><input type="submit" value="commerce" class="button"></td>
<td></td> <td></td>
<td class="button"><input type="submit" value="Arts" class="button"></td>
<td><input type="button" value="Back" onclick="freeuser()"class="button"></td>
</tr>
</table>
</div>
</body>
</html>