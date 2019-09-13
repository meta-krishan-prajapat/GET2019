<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Student Details</title>
<style>
.studentTable {
	background-color: #d3bcf5;
	text-align: center;
	border-spacing: 10px;
}

body {
	background-color: #e4d7f7;
}
</style>
</head>
<body>
<br>
<center>
	<h2>Student Details</h2>
	<br><br><br>

	<c:if test="${not empty lists}">
		<table class="studentTable">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Email Address</th>
				<th>Class Name</th>
				<th>Age</th>
			</tr>
			<c:forEach var="listValue" items="${lists}">
				<tr>
					<td>${listValue.getFirstName()}</td>
					<td>${listValue.getLastName()}</td>
					<td>${listValue.getFatherName()}</td>
					<td>${listValue.getEmail()}</td>
					<td>${listValue.getClassName()}</td>
					<td>${listValue.getAge()}</td>

				</tr>
			</c:forEach>
		</table>

	</c:if>
</center>
</body>
</html>