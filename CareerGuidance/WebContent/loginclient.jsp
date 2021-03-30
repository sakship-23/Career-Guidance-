<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function loginclient() {

	location.replace("http://localhost:8080/CareerGuidance/loginclient.html")
}
function member() {

	location.replace("http://localhost:8080/CareerGuidance/member.jsp")
}
	function selectcource() {

		location.replace("http://localhost:8080/CareerGuidance/selectcourse.jsp")
	}
	</script>
<title>log in client</title>
<style type="text/css">
.button {
	background-color: white;
	border: none;
	color: white;
	font-size: 16px;
	margin: 2px 1px;
	padding: 8px 30px;
	align: center;
}

.button {
	background-color: #48D1CC;
	color: white;
}

.button:hover {
	background-color: #5F9EA0;
	color: white;
}

.loginclient {
	position: relative;
	right: -400px;
	down: -400px;
}
img {
	width:500px;
	height:600px;
}
.container {
	position: relative;
	right: 50px;
}

</style>
</head>

<body>
<div class="hey" align="center" id="rcorners">
		<div class="container" align="center">
			<img src="career.jpg" alt="Cinque Terre" width="350" height="200"
				align="left">
				</div>
				</div>
	<h1 align="center">CAREER GUIDANCE</h1>
	<h2 align="center" style="color: red">"A Navigation path to sucsess"</h2>
	<div class="loginclient">
		<form method="post" action="logincheck">

			<table>
				<tr>
					<td style="color: #5F9EA0;">Enter Username :</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td style="color: #5F9EA0;">Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr></tr>
				<tr>
				<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
				<tr>
				<td></td>
					<td><input type="submit" value="freeuser"></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>