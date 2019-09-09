<!-- jsp page to display all the details of students -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,java.util.ArrayList,POJO.Student"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>List of Enrolled Students</title>
<style>
body {
	background-color: #e4d7f7;
}

table, thead th {
	background-color: #d3bcf5;
	text-align: center;
	border-spacing: 10px;
	border-collapse: collapse;
	padding: 15px;
}

table td {
	background-color: rgb(226, 202, 202);
	text-align: center;
	border-spacing: 10px;
}

table tr.even {
	background-color: #fde9d9;
}

input[type=submit] {
	background-color: #008CBA;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}
</style>
</head>

<body>
	<br>
	<br>
	<h1 align="center">
		<font color="#314c54">Enrolled Students List</font>
	</h1>
	<br>
	<br>
	<div class="studentDetails" align="center">
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Father's Name</th>
					<th>Email</th>
					<th>Class</th>
					<th>Age</th>
					<th></th>
					<th>Edit Here</th>
				</tr>
			</thead>
			<%
				List<Student> li = new ArrayList<Student>();
				li = (List<Student>) request.getAttribute("listOfAllStudents");
				for (Student s : li)
				{
			%>


			<form method='POST' action='updateServlet'>
				<tr>
					<td>
						<%
							out.print(s.getFirstName());
						%>
					</td>
					<td>
						<%
							out.print(s.getLastName());
						%>
					</td>
					<td>
						<%
							out.print(s.getFatherName());
						%>
					</td>
					<td>
						<%
							out.print(s.getEmail());
						%>
					</td>
					<td>
						<%
							out.print(s.getClassName());
						%>
					</td>
					<td>
						<%
							out.print(s.getAge());
						%>
					</td>
					<td><input type='hidden' name='id'
						value=<%out.print(s.getStudentId());%>></td>
					<td><input type='submit' value='Edit'></td>
				</tr>
			</form>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>