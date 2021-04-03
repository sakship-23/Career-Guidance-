<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Log In</title>
<meta charset="ISO-8859-1">
<script type="text/javascript">
	
	function freeuser() {
		location.replace("http://localhost:8080/CareerGuidance/freeuser.jsp")
	}
</script>

<style type="text/css">


table, th, td {
  border-collapse: collapse;
 }
th {
  padding: 20px;
  color: #008B8B;
 background-color: white;
}
td {
  padding: 5px;
  color: #5F9EA0;
  height: 40px;
  font-size: 20px;
}


tr:nth-child(odd) {background-color: #E0FFFF}
tr:nth-child(even) {background-color: white}


.button {
	background-color: white;
	color: white;
	padding: 5px 10px;
    cursor:pointer;
    border: 2px solid #B0E0E6;
     font-size: 15px;
}

.button:hover {
	background-color: #40E0D0;
	color: white;
}

#rcorners {
	border-radius: 25px;
	border: 2px solid #5F9EA0;
	padding: 100px;
	width: 800px;
	height: 300px;
	position: relative;
	right: -150px;
}
.container {
	position: relative;
	right: 50px;
}

body {
background-image:url(login.jpeg);
  background-size:1300px 650px;
  padding: 50px;
}

.loginform {
	position: relative;
	right: -107px;
	top:200px;
}
p {
  font-size: 30px;
}
</style>
</head>

<body>
		<div class="container" align="center">
		<div class="body">
		</div>

		<div class="loginform">
		
			<form name="myform" action="login" method="post">
				<p style="color:white;">Log In</p>
				<table>
					<tr>
						<td style="color: #008080;"> Username :</td>
						<td><input type="text" name="uname" placeholder="EnterUsername"></td>
					</tr>
					<tr>
						<td style="color:#008080;" >Password :</td>
						<td><input type="password" name="passwd" placeholder="Enter Password"></td>
					</tr>
					<tr>
						<td></td>
						<td ><input type="submit" value="Login" class="button" style="color: #008080"></td>
					</tr>
					<tr>
					<td></td>
						<td><input type="button" value="FreeUser" class="button" onclick="freeuser()" style="color: #008080"></td>
					</tr>
				</table>
				<%
				String login_msg=(String)request.getAttribute("error");  
				if(login_msg!=null)
				out.println("<font color=red size=4px>"+login_msg+"</font>");
				%>
			</form>
		</div>
	</div>
</body>
</html>

