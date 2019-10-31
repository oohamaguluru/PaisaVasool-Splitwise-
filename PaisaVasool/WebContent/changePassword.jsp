<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- @dashok
Changes password of the user -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="scripts/newpassscript.js"></script>
</head>

<body>
	<div style="text-align: center">
		<h3>Change Password</h3>
		<br>
		<hr>
		<form action="changePasswordServlet" method="post" name="myForm">
			<input type="password" name="newpassword"
				placeholder="Enter New Password" id="newpass"><br>
			<br> <input type="password" name="dummypassword"
				placeholder="Enter Password Again" id="dummypass"
				onkeyup="checkBoth()"><br>
			<br>
			<div id="mismatch" class="alert alert-danger" style="display: none;">Please
				enter the same password</div>
			<button type="button" class="btn btn-primary btn-block"
				id="confirmButton">Change Password!</button>
		</form>
	</div>


</body>
</html>