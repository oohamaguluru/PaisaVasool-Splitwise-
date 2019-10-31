<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<!-- @dashok
Starting Page of the Project -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paisa Vasool</title>
<style>
#centerDiv {
	position: absolute;
	width: 300px;
	height: 200px;
	z-index: 15;
	top: 55%;
	left: 20%;
	margin: -100px 0 0 -150px;
	
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="scripts/validateuser.js"></script>
<script src="scripts/newuser.js"></script>


</head>

<body
	style="background-image: url('images/indexbg.jpg'); background-repeat: no-repeat; background-size: cover; position: center">


	<!-- Top nav bar -->


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">

				<img src="images/sapientlogo.png" height="50px" width="50px">
			</div>
			<div>


				<!-- Right aligned -->


				<ul class="nav navbar-nav navbar-right">
					<li><button type="button" class="btn btn-primary"
							data-toggle="modal" data-target="#popUpWindow"
							style="padding: 14px 2px;">Sign Up</button></li>

				</ul>
			</div>

		</div>

	</nav>

	<!-- MAIN LOGIN CONTENT -->
	
		<div id="centerDiv" style="text-align: center">
			<form action="dashboard.jsp" method="post" name="dashboardForm" id="dashBoardForm">
				<strong>Enter your OID: &nbsp;</strong> <input type="text" id="idtext" name="oidtext" placeholder="OID" /><br>
				<br> <strong>Enter Password:</strong> <input type="password" id="passtext" name="password"
					placeholder="Password" /><br>
				<br>
				<button type = "button" class = "btn btn-warning" id="toDashboardButton">Log In!</button>
			</form>
		</div>
		
		<div id="resultField"></div>


	<!-- 	MODAL for new user -->
	<div class="modal fade" id="popUpWindow" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content" style="padding: 10px 12px">

				<!-- Header -->
				<div class="modal-header"></div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">Sign Up!</h3>
				<!-- Body -->
				<div class="modal-body"></div>
				<form action="newUserServlet" method="post" name="newUserForm" role="form" id="newForm">
					<div class="form-group">
						<input type="text" class="form-control" placeHolder="Enter OID"
							id="oid" name="newoid" />
					</div>
					<div id="dangerOID" class="alert alert-danger"
						style="display: none;">Please enter a valid OID!</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeHolder="Enter the default password" id="defaultPassword" name="defpass"/>
					</div>
					<div id="dangerPassword" class="alert alert-danger"
						style="display: none;">Please enter a password!</div>
					<div id="wrongPassword" class="alert alert-danger"
						style="display: none;">Please contact the sysadmin for the
						correct default password.</div>
					<div class="form-group">
						<input type="text" class="form-control" placeHolder="Name"
							id="newUserName" name="userName" />
					</div>
					<div id="dangerName" class="alert alert-danger"
						style="display: none;">Name field cannot be blank!</div>
				</form>

				<!-- button -->
				<div class="modal-footer"></div>
				<button type="button" class="btn btn-primary btn-block"
					id="newUserButton">Get Started!</button>
			</div>
		</div>
	</div>

</body>
</html>