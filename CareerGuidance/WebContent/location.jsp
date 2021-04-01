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
	
	function queue() {

		location.replace("http://localhost:8080/CareerGuidance/welcome.jsp")
	}
</script>
<title>Insert title here</title>
<style>
table, th, td {
  border-collapse: collapse;
 }
th {
  padding: 5px;
  color: #008B8B;
 background-color: #ADD8E6;
}
td {
  padding: 5px;
  color: #5F9EA0;
}
tr:nth-child(odd) {background-color: #E0FFFF}

.button {
	background-color: #AFEEEE;
	border: black;
	color: #008B8B;
	font-size: 16px;
	margin: 7px 5px;
}
.button:hover {
	background-color: #87CEEB;
	color: white;
}
.button {border-radius: 8px;}


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

.button2 {
	background-color: grey ; 
	color: white;
}

.button2:hover {
	background-color: #C0C0C0;
	color: white;
}
.button3 {
	background-color: white;
	border: none;
	color: white;
	font-size: 13px;
	margin: 2px 1px;
	padding: 8px 30px;
	transition-duration: 0.4s;
	}
.button3 {
  background-color: #FF6347; 
  color: black; 
}

.button3:hover {
  background-color: #FFA07A;
  color: white;
}
.button3 {border-radius: 12px;} 

.button4 {
    			color: white;
                padding: 10px 20px;
                border-radius: 5px;
                background: linear-gradient(to right,#B22222,#F08080);
                cursor:pointer;
                border: 2px solid #A9A9A9;
                }
.button4 {border-radius: 12px;}

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




// When the user clicks the button, open the modal 
function addLocation(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "block";

}
function closeWindow(){
	var modal = document.getElementById("myModal");
	  modal.style.display = "none";

}

function deleteLocation(locationId){
	
	//location.replace("http://localhost:8080/CareerGuidance/deletelocation?id="+locationId)

	var form = document.createElement("form");
	form.method = 'POST';
	form.action = 'http://localhost:8080/CareerGuidance/deletelocation';
	var input = document.createElement('input');
	input.name = "id";
	input.value = locationId;
	form.appendChild(input);
	document.body.append(form);
	form.submit();
	
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
    <div class="queues" >
    <button onclick="queue()" class="button2" class="queues">Back</button>
    </div>
	
	<div align="center">

		<h1 style="color: #000080">LOCATION</h1>
		<%
				String msg=(String)request.getAttribute("errorAddLocation");  
				if(msg!=null)
				out.println("<font color=red size=4px>"+msg+"</font>");
				
				 
				String smsg=(String)request.getAttribute("successAddLocation");  
				if(smsg!=null)
				out.println("<font color=red size=4px>"+smsg+"</font>");
				
				
				String sDeleteMsg=(String)request.getAttribute("successDeleteLocation");  
				if(sDeleteMsg!=null)
				out.println("<font color=red size=4px>"+sDeleteMsg+"</font>");
				
				 
				String eDeleteMsg=(String)request.getAttribute("errorDeleteLocation");  
				if(eDeleteMsg!=null)
				out.println("<font color=red size=4px>"+eDeleteMsg+"</font>");
				
				
				%>
				
				
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

				<td><%= location.getName()%></td>

				<td><input type="button" value="Delete Row"
					onclick="deleteLocation(<%=location.getId()%>);" style="color: #000080"
					class="button"></td>
			</tr>

			<%}%>

		</table>
		<h2>

			<input type="button"  value="ADD" onClick="addLocation()" class="button4">
				


		</h2>
	</div>


	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div align="center">
				<input type="button" style="color: red; float: right" value="X"
					onClick="closeWindow()">
				<h1 style="color: #4682B4">Add Location</h1>
				<form name="addlocation" action="addlocation" method="post">

					<table id="myTable">

						<tr>
							<td style="color: #5F9EA0;">Location Name :</td>
							<td><input type="text" name="cname"></td>
						</tr>
					</table>

					<h3>
						<input style="float: center" type="submit" value="submit"
							class="button3">
					</h3>



				</form>
			</div>
		</div>

	</div>

</body>
</html>
