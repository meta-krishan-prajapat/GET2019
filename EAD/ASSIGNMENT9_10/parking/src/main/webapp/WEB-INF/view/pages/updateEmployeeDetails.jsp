<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
<Script src="js/validateEmployee.js"></Script>
</head>
<body>
	<p>please update here!!</p>
	<table>
		<form:form method="POST" action="updateEmployeeResult"
			modelAttribute="empData">
			<tr>
				<th>empName:</th>
				<td><form:input type="text" path="empName"
						placeholder="${EmpUpdateDetails.get(0)}" /></td>
			</tr>
			<tr>
				<th>empEmail:</th>
				<td><form:input type="text" path="empEmail"
						value="${EmpUpdateDetails.get(1)}" disabled="true" /></td>
			</tr>
			<tr>
				<th>empContact:</th>
				<td><form:input type="number" path="empContact"
						placeholder="${EmpUpdateDetails.get(2)}" maxlength="10" /></td>
			</tr>
			<tr>
				<th>empGender:</th>
				<td><form:radiobutton path="empGender" value="Male" /> <label><b>Male</b></label>
					<form:radiobutton path="empGender" value="Female" /> <label><b>Female</b></label><br>
				</td>
			</tr>
			<tr>
				<th>empOrganization:</th>
				<td><form:select path="empOrganization">
						<form:option value="Metacube">Metacube</form:option>
						<form:option value="Google">Google</form:option>
						<form:option value="Microsoft">Microsoft</form:option>
						<form:option value="TCS">TCS</form:option>
					</form:select></td>
			</tr>

			<tr>
				<th>vehicleName:</th>
				<td><form:input type="text" path="vehicleName"
						placeholder="${EmpUpdateDetails.get(5)}" /></td>
			</tr>
			<tr>
				<th>vehicleType:</th>
				<td><form:input type="text" path="vehicleType"
						value="${EmpUpdateDetails.get(6)}" disabled="true" /></td>
			</tr>
			<tr>
				<th>vehicleNumber:</th>
				<td><form:input type="text" path="vehicleNumber"
						placeholder="${EmpUpdateDetails.get(7)}"
						value="${EmpUpdateDetails.get(7)}" /></td>
			</tr>
			<tr>
				<th>PassPrice:</th>
				<td><form:input type="text" path="passPriceDetail"
						value="${EmpUpdateDetails.get(8)}" disabled="true" /></td>

			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</form:form>
		<tr>
			<td>
				<form method="POST" action="EmployeeHome">
					<input type="submit" value="Cancel">
				</form>
			</td>
		</tr>
	</table>




</body>
</html>