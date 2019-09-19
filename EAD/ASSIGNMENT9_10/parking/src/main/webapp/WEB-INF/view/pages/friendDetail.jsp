<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>friend Details</title>
</head>
<body>
	<form:form action="EmployeeHome" method="POST"
		modelAttribute="friendData">
		<table>
			<tr>
				<th>Name</th>
				<td>${friendData.getE().getEmpName()}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${friendData.getE().getEmpEmail() }</td>
			</tr>
			<tr>
				<th>Contact</th>
				<td>${friendData.getE().getEmpContact() }</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>${friendData.getE().getEmpGender() }</td>
			</tr>
			<tr>
				<th>Organization</th>
				<td>${friendData.getE().getEmpOrganization() }</td>
			</tr>
			<tr>
				<th>VehicleName</th>
				<td>${friendData.getV().getVehicleName() }</td>
			</tr>
			<tr>
				<th>VehicleType</th>
				<td>${friendData.getV().getVehicleType() }</td>
			</tr>
			<tr>
				<th>VehicleNumber</th>
				<td>${friendData.getV().getVehicleNumber() }</td>
			</tr>
			<tr>
				<th>PassPrice</th>
				<td>${friendData.getV().getPassPriceDetail() }</td>
			</tr>
			<tr>
				<td><input type="submit" value="Home Page"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>