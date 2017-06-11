<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Employee Display Info</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>Employee Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Salary</th>
				<th>Department Name</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>${requestScope.empInfo.getNumber()}</td>
				<td>${requestScope.empInfo.getFirstName()}</td>
				<td>${requestScope.empInfo.getLastName()}</td>
				<td>${requestScope.empInfo.getGender()}</td>
				<td>${requestScope.empInfo.getSalary()}</td>
				<td>${requestScope.empInfo.getDeptName()}</td>
			</tr>

		</tbody>
	</table>
	
	<a href = "/WebApp/home.jsp">Home Page</a>
</body>
</html>