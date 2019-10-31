<!-- @author ooha -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#attributes4 {
	position: absolute;
	width: 150px;
	height: 20px;
	z-index: 2;
	top: 20%;
	left: 410%;
	font-size: 100%;
	color: threedlightshadow;
}

#attributes {
	position: absolute;
	width: 500px;
	height: 500px;
	z-index: 2;
	top: 40%;
	left: 43.5%;
	font-size: 200%;
	color: threedlightshadow;
}

#attributes1 {
	position: absolute;
	width: 50px;
	height: 20px;
	z-index: 2;
	top: 53%;
	left: 35%;
	font-size: 200%;
	white-space: nowrap;
	color: threedlightshadow;
}

#attributes2 {
	position: absolute;
	width: 150px;
	height: 20px;
	z-index: 2;
	top: 53.5%;
	left: 50%;
	font-size: 200%;
	color: threedlightshadow;
}

#attributes3 {
	position: absolute;
	width: 50px;
	height: 20px;
	z-index: 2;
	top: 60%;
	left: 35%;
	font-size: 200%;
	color: threedlightshadow;
	white-space:nowrap;
}

body {
	background-image: url("images/ooha.jpg");
	background-attachment: fixed;
	background-size: cover;
	z-index:3;
}

#abc {
	border-style: solid;
	border-color: transparent;
}

#abcd {
	position: absolute;
	top: 20%;
	right: 45%;
}

.some {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 100px;
	position: absolute;
	top: 70%;
	right: 45%;
	font: bold 15px arial, sans-serif;
	z-index: 10;
}
</style>

</head>


<body>

	<form action="admin" method="get">
		<br>
		<br>
		<div id="abcd">
			<img src="images/sapientlogo.png" height="200px" width="200px">
		</div>
		<div id="attributes">
			<h3>LOGIN</h3>
		</div>
		<table>
			<tr>
				<td id="attributes1">Enter Username</td>
				<td><input id="attributes2" type="text" name="admin" /></td>
			</tr>
			<tr>
				<td id="attributes3">Enter Password<input id="attributes4"
					type="password" name="password" /></td>
			</tr>

		</table>
		<input type="submit" value="SUBMIT" class="some">
	</form>
	<br>
	<br>


</body>
</html>












