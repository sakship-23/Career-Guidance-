<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Log In</title>
<meta charset="ISO-8859-1">
<script type="text/javascript">
	function validate() {
		var uname = document.myform.uname.value;
		if (uname == "") {
			alert("Please enter username");
			document.myform.username.focus();
			return false;
		}
	}
	function freeuser() {
		location.replace("http://localhost:8080/CareerGuidance/freeuser.jsp")
	}
</script>

<style type="text/css">
.button {
	background-color: white;
	border: none;
	color: white;
	font-size: 10px;
	margin: 1px 1px;
	padding: 8px 20px;
}

.button {
	background-color: #48D1CC;
	color: white;
}

.button:hover {
	background-color: #5F9EA0;
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

img {
	width: 450px;
	height: 400px;
}

.loginform {
	position: relative;
	right: -50px;
	down: -150px;
}
</style>
</head>

<body>
	<div class="hey" align="center" id="rcorners">
		<div class="container" align="left">
			<img src="career.jpg" alt="Cinque Terre" width="300" height="300"
				align="left">
		</div>

		<div class="loginform">
		
			<form name="myform" action="login">
				<h2 style="color: #2F4F4F;">Log In</h2>
				<table>
					<tr>
						<td style="color: #5F9EA0;"> Username :</td>
						<td><input type="text" name="uname"></td>
					</tr>
					<tr>
						<td style="color: #5F9EA0;">Password :</td>
						<td><input type="password" name="passwd"></td>
					</tr>
					<tr>
						<td></td>
						<td ><input type="submit" value="Login" class="button" ></td>
					</tr>
					<tr>
					<td></td>
						<td><input type="button" value="FreeUser" class="button" onclick="freeuser()"></td>
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

