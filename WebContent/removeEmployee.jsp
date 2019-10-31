<!-- @author ooha -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paisa Vasool</title>
</head>
<script>
</script>
<style>
body {
	background-image: url("images/editfine.jpg");
	background-attachment: fixed;
	background-size: cover;
	z-index:3;
}
h3{
position: absolute;
	width: 500px;
	height: 500px;
	z-index: 2;
	top: 45%;
	left: 35%;
	font-size: 200%;
	color: threedlightshadow;;
}
#attributes1 {
	position: absolute;
	width: 50px;
	height: 20px;
	z-index: 2;
	top: 57%;
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
	top: 57.5%;
	left: 48%;
	font-size: 200%;
	color: threedlightshadow;
}
.some {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 100px;
	position: absolute;
	top: 65%;
	right: 50%;
	font: bold 15px arial, sans-serif;
	z-index: 10;
}
#abcd {
	position: absolute;
	top: 17%;
	right: 45%;
}</style>
<body>
<h3>REMOVE EMPLOYEE</h3>
<div id="abcd"><img src="images/sapientlogo.png" /></div>
<form action="removeEmployee" method="get">
<table>
<tr>
<td id="attributes1">Enter OID</td><td><input id="attributes2"  type="text" name="oid"></td></tr>
<tr><td><input class="some"type="submit" value="submit"></td></tr>
</table>
</form>
</body>
</html>