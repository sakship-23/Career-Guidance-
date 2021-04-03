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

		location.replace("http://localhost:8080/CareerGuidance/login")
	}
	
</script>
<style>

.button {
    			color: white;
                padding: 10px 30px;
                border-radius: 5px;
                background: linear-gradient(to right,#B22222,#F08080);
                box-shadow: 0 10px 10px -2px rgba(0,0,0,.25);
                cursor:pointer;
                border: 2px solid #A9A9A9;
                }
.button {border-radius: 12px;}

.button1 {
    			color: white;
                padding: 10px 30px;
                border-radius: 5px;                
                background: linear-gradient(to right,#87CEFA,#191970);
                box-shadow: 0 10px 10px -2px rgba(0,0,0,.25);
                cursor:pointer;
                border: 2px solid #A9A9A9;
                }
            .button1 {border-radius: 50%;}

</style>
</head>


<body style="background-color:#008B8B;">

    <div align="right">
     <%
	String name = (String)session.getAttribute("name");
%>
    			<button onclick="container()" class="button1" >Logout</button>
    				<h3 style="color: #8B0000"><%=name %> </h3> 
    				 <h1 align="center"  style="color: black;">Career Guidance</h1>
    </div>
   
	<div style="color: #8A2BE2">
		<h1 align="center">
					
			<button onclick="course()" class="button">Add Course</button>
			<br> <br>
			<button onclick="institute()" class="button">Add Institute</button>
			<br> <br>
			<button onclick="area()" class="button">Add Location</button>
			<br> <br>
		</h1>
	</div>
	
</body>
</html>