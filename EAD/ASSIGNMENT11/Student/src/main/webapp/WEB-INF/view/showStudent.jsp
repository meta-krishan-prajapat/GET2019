<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Students</title>
</head>
<body>
	<h3>List Of Student</h3>
	<table>
		<tr>
			<td>Student Id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Father Name</td>
			<td>Email</td>
			<td>Class</td>
			<td>Age</td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.fatherName}</td>
				<td>${student.email}</td>
				<td>${student.studentClass}</td>
				<td>${student.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>