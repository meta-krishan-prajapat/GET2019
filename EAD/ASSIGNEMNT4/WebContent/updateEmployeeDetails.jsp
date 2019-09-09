
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
<title>Update Employee</title>
<Script src="js/validateEmployee.js"></Script>
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
	<center>
	<p>
		
		<%=request.getSession().getAttribute("empEmail")%>, Please Update
		Here!!
	</p>
	</center>

	<form method="POST" action="updateEmployeeResult"
		onsubmit="return registerEmployee">
		<table cellpadding=10 cellspacing=10 align="center">
			<tr>
				<th align="left">Employee Name:</th>
				<td align="left"><input type="text" name="empName"
					value="<%=e.getEmpName()%>"></td>
			</tr>

			<tr>
				<th align="left">Employee Email:</th>
				<td align="left"><input type="text" name="empEmail"
					value="<%=e.getEmpEmail() %>" disabled></td>
			</tr>
			<tr>
				<th align="left">Employee Contact:</th>
				<td><input type="number" name="empContact"
					value="<%=e.getEmpContact() %>" maxlength=10></td>
			</tr>
			<tr>
				<th align="left">Employee Gender:</th>
				<td><input type="radio" name="empGender" value="Male">
					<label><b>Male</b></label> <input type="radio" name="empGender"
					value="Female"> <label><b>Female</b></label><br></td>
			</tr>
			<tr>
				<th align="left">Employee Organization:</th>
				<td><select name="empOrganization">
						<option value="--Select Value--">--Select Value--</option>
						<option value="Metacube">Metacube</option>
						<option value="Google">Google</option>
						<option value="Microsoft">Microsoft</option>
						<option value="TCS">TCS</option>
				</select></td>
			</tr>
			<tr>
				<th align="left">Vehicle Name:</th>
				<td><input type="text" name="vehicleName"
					value="<%=v.getVehicleName()%>"></td>
			</tr>
			<tr>
				<th align="left">Vehicle Type:</th>
				<td><input type="text" name="vehicleType"
					value="<%=v.getVehicleType() %>" disabled></td>
			</tr>
			<tr>
				<th align="left">Vehicle Number:</th>
				<td><input type="text" name="vehicleNumber"
					value="<%=v.getVehicleNumber() %>"></td>
			</tr>
			<tr>
				<th align="left">Pass Price:</th>
				<td><input type="text" name="passPriceDetail"
					value="<%=v.getPassPriceDetail() %>" disabled></td>

			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
				<td>
					<form method="POST" action="employeeWelcome">
						<input type="submit" value="Cancel">
					</form>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>