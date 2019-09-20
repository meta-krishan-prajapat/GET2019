<!-- Update student details page  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String firstName = (String) request.getAttribute("firstName");
	String lastName = (String) request.getAttribute("lastName");
	String fatherName = (String) request.getAttribute("fatherName");
	String email = (String) request.getAttribute("email");
	String className = (String) request.getAttribute("className");
	String age = (String) request.getAttribute("age");
	int id = (Integer) request.getAttribute("id");
%>
<html>

<head>
<title>Update student details</title>
<style>
.studentTable {
	background-color: #d3bcf5;
	text-align: center;
	border-spacing: 10px;
}

input {
	width: 200px;
	padding: 10px 20px;
	box-sizing: border-box;
}

input[type=text] {
	border: 4px solid #e4d7f7;
	border-radius: 5px;
}

input[type=email] {
	border: 4px solid #e4d7f7;
	border-radius: 5px;
}

body {
	background-color: #e4d7f7;
}

input[type=submit] {
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
		<font color="#314c54">Update Student Details Here</font>
	</h1>
	<br>
	<br>
	<div class="studentDetails" align="center">
		<form onsubmit=" return registerStudent()"
			action="updateStudentServlet" method="POST" name="studentDetailsform">
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
					<td><input type="text" name="first_Name"
						placeholder=<%out.print(firstName);%>></td>

					<td><span id="first_Name_error_message"></span></td>
				</tr>

				<tr>
					<td align="left"><label><b>Last Name:</b></label></td>
					<td><input type="text" name="last_Name"
						placeholder=<%out.print(lastName);%>></td>

					<td><span id="last_Name_error_message"></span></td>
				</tr>

				<tr>
					<td align="left"><label><b>Father's Name:</b></label></td>
					<td><input type="text" name="father_Name"
						placeholder=<%out.print(fatherName);%>></td>

					<td><span id="father_Name_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Email:</b></label></td>
					<td><input type="email" name="email"
						placeholder=<%out.print(email);%>></td>

					<td><span id="email_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Class:</b></label></td>
					<td><input type="text" name="class_Name"
						onkeypress="return numbers(event)" maxlength=2
						placeholder=<%out.print(className);%>></td>

					<td><span id="class_Name_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Age:</b></label></td>
					<td><input type="text" name="age"
						onkeypress="return numbers(event)" maxlength=2
						placeholder=<%out.print(age);%>></td>

					<td><span id="age_error_message"></span></td>
				</tr>

				<tr>
					<td><input type='hidden' value=<%out.print(id);%> name='id'></td>
					<td colspan="3"><input type="submit" value="update"
						style="margin-top: 20px"></td>

				</tr>
			</table>
		</form>
	</div>
</body>

</html>