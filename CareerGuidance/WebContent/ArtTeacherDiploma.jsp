<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
        background-color:#FFE7FE;
    }
.button {
	background-color: grey ; 
	color: white;
	padding: 5px 10px;
}

.button:hover {
	background-color: #C0C0C0;
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<script type="text/javascript">

	function back() {
		location.replace("http://localhost:8080/CareerGuidance/sschierarchy")
	}
</script>
<title>Insert title here</title>

</head>
<body>
<form name="myform" action="login">
				<table >
					<tr>
						<td style="color: #5F9EA0;"> SIR J J School of Art</td>
					</tr>
					<tr>
						<td style="color: #5F9EA0;">L S Raheja School Of Art</td>
					</tr>
						<tr>
						<td style="color: #5F9EA0;">Institute of Media, Fashion and Allied Arts</td>
					</tr>
						<tr>
						<td style="color: #5F9EA0;">Aat Media College</td>
					</tr>
						
					<tr>
						<td><input type="button" value="Back" class="button" onclick="back()"></td>
					</tr>
				</table>
				
			</form>

</body>
</html>