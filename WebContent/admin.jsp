<!-- @author ooha -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Paisa Vasool</title>
<style>
body {
	background-image: url("images/windmill.jpg");
	background-attachment: "fixed";
	backgroud-size: "cover";
}

h1 {
	position: absolute;
	width: 70px;
	height: 60px;
	z-index: 2;
	top: 0.2%;
	left: 36%;
	font-size: 300%;
	color: #00BFFF;
	white-space: nowrap;
}

#getUserTable {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 200px;
	position: absolute;
	top: 15%;
	right: 41%;
	font: bold 15px arial, sans-serif;
	white-space: nowrap;
	z-index: 10;
}

.button1 {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 200px;
	position: absolute;
	top: 25%;
	right: 41%;
	font: bold 15px arial, sans-serif;
	white-space: nowrap;
	z-index: 10;
}

.button2 {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 200px;
	position: absolute;
	top: 35%;
	right: 41%;
	font: bold 15px arial, sans-serif;
	white-space: nowrap;
	z-index: 10;
}

.maindiv {
	border: 2px solid darkgrey;
	border-radius: 5px;
	position: absolute;
	top: 4%;
	right: 27%;
	height: 320px;
	width: 600px;
	background-color: grey;
	opacity: 0.3;
}
</style>

</head>
<body>

	<h1>WELCOME ADMIN</h1>
	<table>
		<tr>
			<td>
				<form action="viewEmployees" method="get">
					<input id="getUserTable" type="submit" value="ViewEmployees" />
				</form>
			</td>
		</tr>
		<tr>
			<td><button class="button1" type="button" value="RemoveEmployee"
					onclick="location.href='removeEmployee.jsp'">RemoveEmployee</button></td>
		</tr>
		<tr>
			<td><button class="button2" type="button" value="EditFine"
					onclick="location.href='editFine.jsp'">EditFine</button></td>
		</tr>
		<tr>
			<td><div id="divbody"></div></td>
		</tr>
		<div class="maindiv"></div>
	</table>

</body>
</html>