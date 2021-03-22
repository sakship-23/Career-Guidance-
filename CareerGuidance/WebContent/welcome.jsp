<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<script>
	function course() {

		location.replace("http://localhost:8080/CareerGuidance/course.jsp")
	}
	function institute() {

		location.replace("http://localhost:8080/CareerGuidance/institute.jsp")
	}
	function area() {

		location.replace("http://localhost:8080/CareerGuidance/location.jsp")
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
</style>
</head>


<body>
	<div style="color: #8A2BE2" id="rcorners2">
		<h1 align="center">
			Course<br>
			<button onclick="course()" class="button">Click</button>
			<br> Institute<br>
			<button onclick="institute()" class="button">Click</button>
			<br> Location<br>
			<button onclick="area()" class="button">Click</button>
		</h1>
	</div>
</body>
</html>