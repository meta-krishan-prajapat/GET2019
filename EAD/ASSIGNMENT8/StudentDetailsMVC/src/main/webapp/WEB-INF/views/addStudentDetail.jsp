<!-- addStudentDetail html page takes the details of the student that are to be inserted in the database
 and on submit the form goes under validation process and then the details goes to AddStudentDetailSertvlet.java servlet  -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Student Form</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="js/addStudent.js"></script>
<style>
.studentTable {
	background-color: #d3bcf5;
	text-align: center;
	border-spacing: 10px;
}

form:input {
	width: 200px;
	padding: 10px 20px;
	box-sizing: border-box;
}

form:input[type=text] {
	border: 4px solid #e4d7f7;
	border-radius: 5px;
}

form:input[type=email] {
	border: 4px solid #e4d7f7;
	border-radius: 5px;
}

body {
	background-color: #e4d7f7;
}

form:input[type=submit] {
	background-color: #008CBA;;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
</style>
</head>

<body>
	<br>
	<br>
	<h1 align="center">
		<font color="#314c54">Add Student Details Here</font>
	</h1>
	<br>
	<br>
	<div class="studentDetails" align="center">
		<form:form onsubmit=" return validateStudentDetails()"
			action="addStudent" method="POST" modelAttribute="student">
			<form:errors style="color:red"></form:errors>

			<table class="studentTable">
				<tr>
					<td colspan="2">
						<h2 align="center">
							Student details:
							<h2>
								<br>
					</td>
				</tr>

				<tr>
					<td align="left"><label><b>First Name:</b></label></td>
					<td><form:input type="text" path="firstName"
							placeholder="First Name" /></td>

					<td><form:errors path="firstName" style="color:red" /></td>
				</tr>

				<tr>
					<td align="left"><label><b>Last Name:</b></label></td>
					<td><form:input type="text" path="lastName"
							placeholder="Last Name" /></td>

					<td><form:errors path="lastName" style="color:red" /></td>
				</tr>

				<tr>
					<td align="left"><label><b>Father's Name:</b></label></td>
					<td><form:input type="text" path="fatherName"
							placeholder="Father's Name" /></td>

					<td><form:errors path="fatherName" style="color:red" /></td>
				</tr>
				<tr>
					<td align="left"><label><b>Email:</b></label></td>
					<td><form:input type="email" path="email" placeholder="Email" />
					</td>

					<td><form:errors path="email" style="color:red" /></td>
				</tr>
				<tr>
					<td align="left"><label><b>Class:</b></label></td>
					<td><form:input type="text" path="className"
							onkeypress="return numbers(event)" maxlength="2"
							placeholder="Class" /></td>

					<td><form:errors path="className" style="color:red" /></td>
				</tr>
				<tr>
					<td align="left"><label><b>Age:</b></label></td>
					<td><form:input type="text" path="age"
							onkeypress="return numbers(event)" maxlength="2"
							placeholder="Age" /></td>

					<td><form:errors path="age" style="color:red" /></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="Submit"
						style="margin-top: 20px" /></td>

				</tr>
			</table>
		</form:form>
	</div>
</body>

</html>