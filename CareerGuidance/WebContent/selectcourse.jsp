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
	background-color: linear-gradient(to right,#FFEFD5 #F08080);
border:3px solid #18ab29;
	color: white;
	font-size: 20px;
	margin: 2px 2px;
	padding:15px 30px;
}
.button {
	background-color:#48D1CC;
	color: white;
}

.button:hover {
	background-color: #5F9EA0;
	color: white;
}
.button1{
background-color: grey ;
color: white;
}

.button1:hover {
background-color: #C0C0C0;
color: white;
}

body{
        background-color:#E0FFFF;
    }
</style>

<title>Select course</title>
</head>
<body>
<h1 align="center">"DISCOVER YOURSELF AND YOUR IDEAL CARRER"</h1>
<h2 align="center">Select Your Course From Below:</h2>
<div align="center">
<table>
 <tr> 
<td ><input type="submit" value="Science" class="button"></td>
<td></td> <td></td>
<tr>
<td ><input type="submit" value="commerce" class="button"></td>
</tr>
<td></td> <td></td>
<tr>
<td ><input type="submit" value="Arts" class="button"></td>
</tr>
<td></td> <td></td>
<tr>
<td><input type="button" value="Back" onclick="freeuser()" class="button1"></td>
</tr>
</table>
</div>
</body>
</html>