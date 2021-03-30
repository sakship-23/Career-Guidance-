<%@page import="java.util.List"%>
<%@page import="com.careerguidance.user.bean.Location"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
	function container() {

		location.replace("http://localhost:8080/CareerGuidance/login.jsp")
	}
	
	function openForm() {
		  document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
		  document.getElementById("myForm").style.display = "none";
		}
</script>
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	background-color: #E0FFFF;
	color: #008080;
	padding: 7px
}

.button {
	background-color: white;
	border: none;
	color: black;
	font-size: 16px;
	margin: 7px 5px;
}

.button {
	background-color: white;
	color: black;
	border: black;
}

.button:hover {
	background-color: green;
	color: white;
}

.area {
	background-color: white;
	border: none;
	color: white;
	font-size: 16px;
	margin: 7px 5px;
}

.area {
	background-color: white;
	color: black;
	border: black;
}

.area:hover {
	background-color: red;
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



.form-popup {
  display: none;
  position: relative;
  bottom: 0;
  center: 0;
  border: 3px solid #f1f1f1;
  z-index: 9;
}



.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}


.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}


.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}


.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: %;
  margin-bottom:10px;
  opacity: 0.8;
}


.form-container .cancel {
  background-color: red;
}


.form-container .btn:hover, .open-button:hover {
  opacity: 1



</style>
</head>

<body>
<div align="right">
     <%
	String name = (String)session.getAttribute("name");
%>
    			<button onclick="container()" class="button1" >Logout</button>
    				<h3 style="color: #8B0000"><%=name %> </h3> 
    				 
    </div>
	<div align="center">
		<h1 style="color: #000080">LOCATION</h1>

		<table id="myTable">
			<tr align="center" class="new">
			    <th style="color: #000080">Location</th>
				<th style="color: #000080">Actions</th>
			</tr>
			
			<%
			List<Location> locations = (List<Location>)session.getAttribute("locations");
			for(Location location : locations) {
                %>
			<tr align="center">
			
			<td> <%= location.getName()%></td>
			<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button">
				<input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('1')"
					style="color: #000080" class="area"></td>
			</tr>
			<%}%>
			</table>
			<br>
<button class="open-button" onclick="openForm()">ADD</button>
<div class="form-popup" id="myForm"  align="center">
  <form action="/action_page.php" class="form-container">
  <h2>Add new course</h2>

    <label><b>Course name:</b></label>
    <input type="text" placeholder="Course name" name="Course name">
    
    <label for="Parent course name">Choose a parent course:</label>
  <select id="course" name="Parent course" >
    <option value="science">science</option>
    <option value="saab">arts</option>
  </select><br>
    
    <label for="Institute name">Institute name:</label>
  <select id="Institute name" name="Institute name" >
    <option value="Mumbai">Mumbai</option>
    <option value="Thane">Thane</option>
  </select><br>
<br>
     <label><b>Duration:</b></label>
    <input type="text" placeholder="Duration" name="Duration"> <br>

    <button type="button" class="btn">Add</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>	
						
		
	
	</body>
</html>

