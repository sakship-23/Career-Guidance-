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
	function queue() {

		location.replace("http://localhost:8080/CareerGuidance/welcome.jsp")
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
body {
	font-family: Arial, Helvetica, sans-serif;
}

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
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

/* Add Animation */
@
-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: white;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}
.queues{
  position: absolute;
  left: 10px;
  top: 550px;
}
</style>
</head>

<body>
<script>
// Get the modal

// Get the button that opens the modal

// Get the <span> element that closes the modal




function closeWindow(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "none";

}

function deleteinstitute(instituteId){
	var form = document.createElement("form");
	form.method = 'POST';
	form.action = 'http://localhost:8080/CareerGuidance/deleteinstitute';
	var input = document.createElement('input');
	input.name = "id";
	input.value = instituteId;
	form.appendChild(input);
	document.body.append(form);
	form.submit();
}

function addInstitutes(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "block";}





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
    <div class="queues" >
    <button onclick="queue()" class="button1" class="queues">Back</button>
    </div>
	<div align="center">

		<h1 style="color: #000080">Institute</h1>
		<%
				String msg=(String)request.getAttribute("errorAddInstitute");  
				if(msg!=null)
				out.println("<font color=red size=4px>"+msg+"</font>");
				
				 
				String smsg=(String)request.getAttribute("successAddInstitute");  
				if(smsg!=null)
				out.println("<font color=red size=4px>"+smsg+"</font>");
				
				
				String sDeleteMsg=(String)request.getAttribute("successDeleteInstitute");  
				if(sDeleteMsg!=null)
				out.println("<font color=red size=4px>"+sDeleteMsg+"</font>");
				
				 
				String eDeleteMsg=(String)request.getAttribute("errorDeleteInstitute");  
				if(eDeleteMsg!=null)
				out.println("<font color=red size=4px>"+eDeleteMsg+"</font>");
				
				
				%>
				
				
		<table id="myTable">
			<tr align="center" class="new">
				<th style="color: #000080">Institute</th>
				<th style="color: #000080">Actions</th>
			</tr>

			<%
			List<Institute> institutes = (List<Institute>)session.getAttribute("institutes");
			for(Institute institute : institutes) {
                %>
			<tr align="center">

				<td><%= institute.getInstituteName()%></td>

				<td><input type="button" value="Delete Row"
					onclick="deleteinstitute(<%=institute.getInstituteId()%>);" style="color: #000080"
					class="area"></td>
			</tr>

			<%}%>

		</table>
		<h2>

			<input type="button" style="color: red" value="ADD"
				onClick="addInstitutes()">
				


		</h2>
	</div>


	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div align="center">
				<input type="button" style="color: red; float: right" value="X"
					onClick="closeWindow()">
				<h1 style="color: #000080">INSTITUTE</h1>
				<form name="addInstitute" action="addinstitute" method="post">

					<table id="myTable">

						<tr>
							<td style="color: #5F9EA0;">institute Name :</td>
							<td><input type="text" name="cname"></td>
						</tr>
					</table>

					<h3>
						<input style="float: center" type="submit" value="submit"
							class="button1">
					</h3>



				</form>
			</div>
		</div>

	</div>

</body>
</html>
