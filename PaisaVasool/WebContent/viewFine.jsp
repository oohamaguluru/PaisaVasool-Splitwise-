<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
  <table class="table table-striped">
    <thead>
      <tr>
        <th style="color: white;">OID</th>
        <th style="color: white;">Name</th>
        <th style="color: white;">Fine Amount Due</th>
        <th style="color: white;">No: of Times Late</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${employee.getoID() }</td>
        <td>${employee.getName() }</td>
        <td>${employee.getFine() }</td>
        <td>${employee.getTimeslate() }</td>
      </tr>
    </tbody>
  </table>
	
</body>
</html>