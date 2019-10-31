<!-- @author ooha -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1{
position: absolute;
	width: 500px;
	height: 500px;
	z-index: 2;
	top: 47%;
	left: 40.5%;
	font-size: 200%;
	color: threedlightshadow;;
}
#abcd {
	position: absolute;
	top: 20%;
	right: 45%;
}
#attributes1 {
	position: absolute;
	width: 50px;
	height: 20px;
	z-index: 2;
	top: 54%;
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
	top: 55%;
	left: 48%;
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
#attributes4 {
	position: absolute;
	width: 150px;
	height: 20px;
	z-index: 2;
	top: 61%;
	left: 48%;
	font-size: 100%;
	color: threedlightshadow;
}
.some {
	background: #0066A2;
	color: white;
	border-color: #0066A2;
	height: 50px;
	width: 100px;
	position: absolute;
	top: 67%;
	right: 50%;
	font: bold 15px arial, sans-serif;
	z-index: 10;
}
body {
	background-image: url("images/editfine.jpg");
	background-attachment: fixed;
	background-size: cover;
	z-index:3;
}
</style>
<body>

<form action="editFine" method="get">
<h1> EDIT FINE</h1>
<div id="abcd"><img src="images/sapientlogo.png" /></div>
<table>
<tr>
<td id="attributes1">
Enter OID</td> <td><input id="attributes2" type="text" name="oid" /></td></tr>
<tr><td id="attributes3">
Enter the fine</td><td><input id="attributes4" type="text" name="fine" /></td></tr>
<tr><td>
<input type="submit" value="submit" class="some"></td></tr> 
</table>
</form>
</body>
</html>