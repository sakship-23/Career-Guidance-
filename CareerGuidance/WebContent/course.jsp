<%@page import="java.util.List"%>
<%@page import="com.careerguidance.user.bean.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function container() {

		location.replace("http://localhost:8080/CareerGuidance/login.jsp")
	}
	
</script>
<meta charset="ISO-8859-1">
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

body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 80%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

/* The Close Button */
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}
</style>
</style>
</head>

<body>


<script>
// Get the modal

// Get the button that opens the modal

// Get the <span> element that closes the modal



function close(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "none";

}
// When the user clicks the button, open the modal 
function validate1(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "block";

}


// When the user clicks on <span> (x), close the modal
var modal = document.getElementById("myModal");


var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];
span.onclick = function() {
	  modal.style.display = "none";
	}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	var modal = document.getElementById("myModal");
	if (event.target == modal) {
	  
    modal.style.display = "close";
  }
}
</script>
<div align="right">
     <%
	String name = (String)session.getAttribute("name");
%>
    			<button onclick="container()" class="button1" >Logout</button>
    				<h3 style="color: #8B0000"><%=name %> </h3> 
    				 
    </div>
	<div align="center">
	
		<h1 style="color: #000080">COURSE</h1>

		<table id="myTable">
			<tr align="center" class="new">
				<th style="color: #000080">Course</th>
				<th style="color: #000080">Parent Course</th>
				<th style="color: #000080">Institute</th>
			    <th style="color: #000080">Duration</th>
				<th style="color: #000080">Actions</th>
			</tr>
			
			<%
			List<Course> courses = (List<Course>)session.getAttribute("courses");
			for(Course course : courses) {
                %>
			<tr align="center">
			
			 <td> <%= course.getName()%></td>
			 <td> <%= course.getParentCourseName()%></td>
			 <td> <%= course.getInstitutename()%></td>
			 <td> <%= course.getDuration()%></td>
			 
				<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button">
				<input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('1')"
					style="color: #000080" class="area"></td>
			</tr>
			
			 <%}%>
					
		</table>
		<h2>
		
 <input type="button"
				style="color: red" value="ADD" onClick="validate1()">				
				 <input type="button"
				style="color: red" value="SAVE" onClick="validate()">
				
				
		</h2>
	</div>
	
	
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span onclick="close">&times;</span>
      <h2>Modal Header</h2>
    </div>
    <div class="modal-body">
      <p>Some text in the Modal Body</p>
      <p>Some other text...</p>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>
</body>
</html>
