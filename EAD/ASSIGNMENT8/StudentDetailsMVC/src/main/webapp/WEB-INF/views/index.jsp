<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- start page o the application the will have three links of add ,show and search student -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Student Portal</title>
<style>
.studentLinks {
	background-color: #d3bcf5;
	align: center;
	text-align: center;
	cellspacing: 30;
	cellpadding: 30;
}

a:link, a:visited {
	background-color: #bd99f2;
	color: white;
	padding: 20px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: #a56ef5;
}

body {
	background-color: #e4d7f7;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font color="#314c54">${message}</font>
	</h1>
	<br>
	<br>
	<div align="center">
		<table class="studentLinks">
			<tr>
				<td><h3>
						<a href="addStudentDetail">Add Student Detail</a>
					</h3></td> &nbsp;&nbsp;&nbsp;&nbsp;
				<td><h3>
						<a href="showStudents">Show All Student</a>

					</h3></td> &nbsp;&nbsp;&nbsp;&nbsp;

			</tr>
		</table>
	</div>
</body>
</html>