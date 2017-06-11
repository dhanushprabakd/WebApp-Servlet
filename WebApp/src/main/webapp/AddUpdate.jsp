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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ADD/Update</title>
</head>
<script type="text/javascript">
	function submitForm() {

		var salary = document.getElementById('Salary').value;
		var firstName = document.getElementById('firstName').value;
		var lastName = document.getElementById('lastName').value;

		if (salary < 10000 || (firstName + lastName).length < 8) {

			alert('Salary should be greater than 1000 and the name should be of min 8 characters');
			return;
		}

		document.getElementById('addUpdateform').submit();
	}
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<h4>
						<span class="label label-danger">${requestScope.message}</span>
					</h4>
					<h4>Add/Update Employee Details</h4>
					<form id='addUpdateform'
						action="<%=request.getContextPath()%>/addUpdate.do" method="post">
						<input type="text" id="empNo" name="empNo"
							class="form-control input-sm chat-input" placeholder="empNo" /><br>
						<input type="text" id="firstName" name='firstName'
							class="form-control input-sm chat-input" placeholder="First Name" /><br>
						<input type="text" id="lastName" name='lastName'
							class="form-control input-sm chat-input" placeholder="Last Name" /><br>
						<input type="number" id="Salary" name='Salary'
							class="form-control input-sm chat-input" placeholder="Salary" /><br>
						<input type="date" id="birthDate" name='birthDate'
							class="form-control input-sm chat-input" placeholder="Birth Date" /><br>
						<input type="date" id="hireDate" name='hireDate'
							class="form-control input-sm chat-input" placeholder="Hire Date" /><br>

						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-default active"> <input
								type="radio" name="gender" id="M" value="M" autocomplete="off"
								checked> Male
							</label> <label class="btn btn-default"> <input type="radio"
								name="gender" id="F" value="F" autocomplete="off">
								Female
							</label>
						</div>
						<br> <br> <input type="text" id="deptName"
							name='deptName' class="form-control input-sm chat-input"
							placeholder="deptName" /><br> <br>
						<div class="wrapper">
							<button type="button" class="btn btn-default"
								onclick="submitForm()">Add/Update</button>
						</div>
					</form>
				</div>

			</div>
		</div>



	</div>
</body>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</html>