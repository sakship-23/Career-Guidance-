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
	location.replace("http://localhost:8080/CareerGuidance/hschierarchy")
}
function login() {

	location.replace("http://localhost:8080/CareerGuidance/login.jsp")
}

</script>
<style type="text/css">

.button{
	color: black;
                padding: 35px 55px;
                border-radius: 10px;                
                background: linear-gradient(to right,#FFF8DC,#FFB6C1);
                box-shadow: 0 10px 10px -2px rgba(0,0,0,.25);
                cursor:pointer;
                border: 3px solid #000000;

}

.button {
	background-color: #48D1CC
	color: black;
}

.button:hover {
	background-color: #5F9EA0;
	color: black;
}
.button1{
background-color: grey ;
color: white;
 position: absolute;
  left: 10px;
  top: 560px;
   padding: 10px 30px;
   
}

.button1:hover {
background-color: #C0C0C0;
color: white;
}
.container{
 position: absolute;
 left: 10px;
 down: 550px;
}

body{
        background-color:#FFE7FE;
    }

</style>
</head>
<body>
	<h1 align="center" style="color:#464726">CAREER GUIDANCE</h1>
	<h2 align="center" style="color:#B62CB1">"Navigating path to your sucsess"</h2>
	<h3 align="center" style="color: #B6B94F">WELCOME</h3>
		<h4 align="center" style="color: #B6B94F">"We will guide you for your better future"</h4>
		<h2 align="center" style="color: #B62CB1">Select Your Standard:</h2>
	<div align= "center">
					<table>
					<tr>
					<td ><input type="submit" value="After 10th" onclick="aptitude()" class="button" style="color: black"></td>
					<td></td>
					<tr>
					<td><input type="submit" value="After 12th" onclick="selectcourse()" class="button" style="color: black"></td>
					</tr>
					<tr>
					<td><input type="button" value="Back" onclick="login()" class="button1" class="container"></td>
					</tr>
					</table>
					</div>
</body>
</html>
