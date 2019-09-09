<!-- page to display the details searched student -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,java.util.ArrayList,POJO.Student,javax.servlet.ServletContext;"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Search Student Result</title>
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
</style>
</head>

<body>
	<br>
	<br>
	<h1 align="center">
		<font color="#314c54"> Students List</font>
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
				</tr>
			</thead>
			<form method='POST' action="">

				<%
					List<Student> li = new ArrayList<Student>();
					li = (List<Student>) request.getAttribute("resultDetails");
					for (Student s : li)
					{
				%>
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
				</tr>
				<%
					}
				%>
			</form>

		</table>
	</div>
</body>

</html>