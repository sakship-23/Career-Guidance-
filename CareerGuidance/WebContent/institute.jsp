<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
	color: white;
	font-size: 16px;
	margin: 7px 5px;
}

.button {
	background-color: white;
	color: white;
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
</style>
</head>

<body>
	<div align="center">
		<h1 style="color: #000080">INSTITUTE</h1>

		<table id="myTable">
			<tr align="center" class="new">
				<th style="color: #000080">Firstname</th>
				<th style="color: #000080">Lastname</th>
				<th style="color: #000080">Age</th>
			</tr>
			<tr align="center">
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
				<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button"></td>
				<td><input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('1')"
					style="color: #000080" class="area"></td>
			</tr>
			<tr align="center">
				<td>Eve</td>
				<td>Jackson</td>
				<td>94</td>
				<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button"></td>
				<td><input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('2')"
					style="color: #000080" class="area"></td>
			</tr>
			<tr align="center">
				<td>John</td>
				<td>Doe</td>
				<td>80</td>
				<td><input type="submit" style="color: #000080" value="MODIFY"
					onClick="validate()" class="button"></td>
				<td><input type="button" value="Delete Row"
					onclick="document.getElementById('myTable').deleteRow('3')"
					style="color: #000080" class="area"></td>
			</tr>

		</table>
		<h2>
			<input type="submit" style="color: red" value="ADD"
				onClick="validate()"> <input type="submit"
				style="color: red" value="SAVE" onClick="validate()">
		</h2>
	</div>

</body>
</html>
