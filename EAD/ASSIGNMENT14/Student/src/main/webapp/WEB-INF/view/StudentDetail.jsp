<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<title>Student Detail Page</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="student">
			<h1>Student Detail Form</h1>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName"  /></td>
					<td><form:errors path = "firstName" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName"  /></td>
					<td><form:errors path = "lastName" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Father Name</td>
					<td><form:input path="fatherName"  /></td>
					<td><form:errors path = "fatherName" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
					<td><form:errors path = "email" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Class</td>
					<td><form:input path="studentClass"  /></td>
					<td><form:errors path = "studentClass" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
					<td><form:errors path = "age" cssClass="text-danger"></form:errors></td>
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>