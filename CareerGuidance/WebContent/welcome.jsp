<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<script>
	function course() {

		location.replace("http://localhost:8080/CareerGuidance/course")
	}
	function institute() {

		location.replace("http://localhost:8080/CareerGuidance/institute")
	}
	function area() {

		location.replace("http://localhost:8080/CareerGuidance/location")
	}
	function container() {

		location.replace("http://localhost:8080/CareerGuidance/login.jsp")
	}
	
</script>
<style>
#rcorners2 {
	border-radius: 25px;
	border: 2px solid #5F9EA0;
	padding: 100px;
	width: 400px;
	height: 250px;
	position: relative;
	right: -350px;
}

.button {
	background-color: white;
	border: none;
	color: white;
	font-size: 16px;
	margin: 7px 5px;
}

.button {
	background-color: white;
	color: #4B0082;
	border: black;
}

.button:hover {
	background-color: #DDA0DD;
	color: white;
}

.button1 {
	background-color: white;
	border: none;
	color: white;
	font-size: 12px;
	margin: 2px 1px;
	padding: 8px 30px;
}

.button1 {
	background-color: red ; 
	color: white;
}

.button1:hover {
	background-color: #FF726F;
	color: white;
}

</style>
</head>


<body>
 
    <div align="right">
     <%
	String name = (String)session.getAttribute("name");
%>
    			<button onclick="container()" class="button1" >Logout</button>
    				<h3 style="color: #8B0000"><%=name %> </h3> 
    				 <h1 align="center"  style="color: #5F9EA0;">Career Guidance</h1>
    </div>
   
	<div style="color: #8A2BE2" id="rcorners2">
		<h1 align="center">
					Course<br>
			<button onclick="course()" class="button">Click</button>
			<br> Institute<br>
			<button onclick="institute()" class="button">Click</button>
			<br> Location<br>
			<button onclick="area()" class="button">Click</button>
			<br> <br>
		</h1>
	</div>
</body>
</html>