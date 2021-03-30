<%@page import="com.careerguidance.user.bean.Institute"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<script>
	function container() {

		location.replace("http://localhost:8080/CareerGuidance/login.jsp")
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
		<h1 style="color: #000080">INSTITUTE</h1>

		<table id="myTable">
			<tr align="center" class="new">
				<th style="color: #000080">Institute</th>
			    <th style="color: #000080">Location</th>
				<th style="color: #000080">Actions</th>
			</tr>
			
			<%
			List<Institute> institutes = (List<Institute>)session.getAttribute("institutes");
			for(Institute institute : institutes) {
                %>
			<tr align="center">
			
			 <td> <%= institute.getInstituteName()%></td>
			 <td> <%= institute.getLocationName()%></td>
			
			
			 
				<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button">
				<input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('1')"
					style="color: #000080" class="area"></td>
			</tr>
			
			 <%}%>
					
		</table>
		<h2>
			<input type="submit" style="color: red" value="ADD"
				onClick="validate()"> <input type="submit"
				style="color: red" value="SAVE" onClick="validate()">
		</h2>
	</div>

</body>
</html>
