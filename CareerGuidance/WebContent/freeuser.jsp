<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>free user</title>
<script>
function aptitude() {
	location.replace("http://localhost:8080/CareerGuidance/aptitude.html")
}
function selectcourse() {
	location.replace("http://localhost:8080/CareerGuidance/selectcourse.jsp")
}
function login() {

	location.replace("http://localhost:8080/CareerGuidance/login.jsp")
}

</script>
<style type="text/css">
.button{
	background-color: white;
	border: none;
	color: white;
	font-size: 20px;
	margin: 2px 2px;
	padding: 20px 40px;
}

.button {
	background-color: #48D1CC;
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
</head>
<body>
	<h1 align="center">CAREER GUIDANCE</h1>
	<h2 align="center" style="color: red">"Navigation path to sucsess"</h2>
	<div align= "center">
					<table>
					<tr>
					<td><input type="submit" value="After 10th" onclick="aptitude()" class="button"></td>
					<td><input type="submit" value="After 12th" onclick="selectcourse()" class="button"></td>
					<td><input type="button" value="Back" onclick="login()" class="button"></td>
					</tr>
				</table>
					</div>
</body>
</html>
