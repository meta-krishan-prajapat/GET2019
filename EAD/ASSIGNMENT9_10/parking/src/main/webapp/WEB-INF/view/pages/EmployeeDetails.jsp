<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
</head>
<body>
	<div>
		<form action="logout">
			<input type="submit" value="logout">
		</form>
	</div>
	<p>
		welcome: <br> <a href="friends">friends</a>
	</p>

	<form:form action="UpdateEmployee" method="POST" modelAttribute="list">
		<table>
			<tr>
				<th>empName:</th>
				<td>${list.get(0)}</td>
			</tr>
			<tr>
				<th>empEmail:</th>
				<td>${list.get(1)}</td>
			</tr>
			<tr>
				<th>empContact:</th>
				<td>${list.get(2)}</td>
			</tr>
			<tr>
				<th>empGender:</th>
				<td>${list.get(3)}</td>
			</tr>

			<tr>
				<th>empOrganization:</th>
				<td>${list.get(4)}</td>
			</tr>
			<tr>
				<th>vehicleName:</th>
				<td>${list.get(5)}</td>
			</tr>
			<tr>
				<th>vehicleType:</th>
				<td>${list.get(6)}</td>
			</tr>
			<tr>
				<th>vehicleNumber:</th>
				<td>${list.get(7)}</td>
			</tr>
			<tr>
				<th>PassPrice:</th>
				<td>${list.get(8)}</td>

			</tr>
			<tr>
				<td><input type="submit" value="edit details"></td>
			</tr>

		</table>

	</form:form>

</body>
</html>