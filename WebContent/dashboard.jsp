<!-- @author dashok -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- @dashok
User dashboard page -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%-- <%{employee.name}%> --%></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="style/sidebar.css">
<link rel="stylesheet" href="style/userfunctions.css">
<link rel="stylesheet" href="style/resultdiv.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="scripts/optionclicked.js"></script>
<script src="scripts/fineview.js"></script>
<script src="scripts/imageupload.js"></script>
<script src="scripts/logoutscript.js"></script>
</head>
<body
	style="background-image: url('images/indexbg.jpg'); background-repeat: no-repeat; background-size: cover; position: center">


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button
					style="background: url('images/3lt.jpg'); height: 30px; width: 30px; padding: 8px 0px;"
					id="menu-toggle"></button>
				<img src="images/sapientlogo.png" height="50px" width="50px">
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li><form action="logOutServlet" name="logoutForm"><button type="button" class="btn btn-danger"
					id = "signOutButton" style="padding: 14px 2px;">Log Out</button></form></li>

				</ul>


			</div>

		</div>

	</nav>


	<!-- MAIN CONTENT -->

	<div id="wrapper" class="container">

		<!-- Sidebar -->


		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li
					style="height: 200px; text-align: center; padding-top: 70px; padding-bottom: 10px">
					<!-- ENTER THE employees.image HERE -->
					<%-- <a href="${sessionScope.image }" target="_blank" style="color: white"> --%><img class="img-circle" style="max-height: 100%; max-width: 100%;"
					src="${sessionScope.image }" alt="View Image" /></a>
				</li>
				<li style="color: #ddd; text-align: center;"><strong>
						 ${ sessionScope.username }
				</strong></li>
				<li><a href="http://www.sapientnitro.com/en-us.html#home">Go
						to SapientNitro</a></li>
				<li><a href="http://peopleportal2.sapient.com/">Go to
						People Portal</a></li>
			</ul>
		</div>


		<!-- Page content -->


		<div id="page-content-wrapper">

			<!-- USER OPTIONS -->
			<div id="userfns">
				<ul class="sidebar-nav">
					<li style="color: #ddd; text-align: center;"><strong>USER
							OPTIONS</strong></li>
					<li style="color: #ddd; text-align: center;" id="changepassword"><a
						href="#">Change Password</a></li>
					<li style="color: #ddd; text-align: center;" id="profilepic"><a
						href="#">Upload Profile Picture</a></li>
					<li style="color: #ddd; text-align: center;" id="viewfine"><a
						href="#">View Fine</a></li>
					<li style="color: #ddd; text-align: center;" id="reportMistake">
						<a href="mailto:admin@fine.collector.com?Subject=Fine Discrepancy">Report
							a mistake</a>
					</li>
				</ul>
			</div>

			<!-- RESULT DISPLAY -->
			<div id="resultdiv" style="display: none;"></div>

		</div>


	</div>


	<!-- Menu toggle script -->

	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("menuDisplayed")
		});
	</script>

</body>
</html>