<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList,java.util.List,POJO.Employee,POJO.EmployeeVehicle"
	session="false"%>
<%
	List<Object> listOfAllData = new ArrayList<Object>();
	listOfAllData = (List<Object>) request.getSession().getAttribute("listOfAllData");
	Employee e = (Employee) listOfAllData.get(0);
	EmployeeVehicle v = (EmployeeVehicle) listOfAllData.get(1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
<style>
body {
	background-color: lightblue;
}

a:link {
	color: maroon;
}

a:visited {
	color: green;
}

a:hover {
	color: red;
}

a:active {
	color: yellow;
}

table {
	background-color: #d1ede7;
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<form action="logout">
			<input type="submit" value="logout">
		</form>
	</div>
	<p>
		welcome:
		<%=request.getSession().getAttribute("empEmail")%>
		<br> <a href="friends">friends</a>
	</p>
	<form action="updateEmployeeDetails.jsp">
		<table>

			<tr>
				<th>empName:</th>
				<td><%=e.getEmpName()%></td>
			</tr>

			<th>empEmail:</th>
			<td><%=e.getEmpEmail()%></td>
			</tr>
			<tr>
				<th>empContact:</th>
				<td><%=e.getEmpContact()%></td>
			</tr>
			<tr>
				<th>empGender:</th>
				<td><%=e.getEmpGender()%></td>
			</tr>
			<tr>
				<th>empPassword:</th>
				<td><%=e.getEmpPassword()%></td>
			</tr>
			<tr>
				<th>empOrganization:</th>
				<td><%=e.getEmpOrganization()%></td>
			</tr>
			<tr>
				<th>vehicleName:</th>
				<td><%=v.getVehicleName()%></td>
			</tr>
			<tr>
				<th>vehicleType:</th>
				<td><%=v.getVehicleType()%></td>
			</tr>
			<tr>
				<th>vehicleNumber:</th>
				<td><%=v.getVehicleNumber()%></td>
			</tr>
			<tr>
				<th>PassPrice:</th>
				<td><%=v.getPassPriceDetail()%></td>

			</tr>
			<tr>
				<td><input type="submit" value="edit"></td>
			</tr>

		</table>
	</form>
</body>
</html>