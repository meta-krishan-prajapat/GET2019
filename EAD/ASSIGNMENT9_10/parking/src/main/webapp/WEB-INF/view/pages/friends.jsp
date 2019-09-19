<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>friend list</title>
</head>
<body>
	your friends are:
	<c:forEach var="f" items="${friends}">
		<a href="friendsData?id=${ f.getE().getEmpId()}"> ${ f.getE().getEmpName() }
		</a>
	</c:forEach>


	<form:form action="EmployeeHome" method="POST">
		<input type="submit" value="Home Page">
	</form:form>
</body>
</html>