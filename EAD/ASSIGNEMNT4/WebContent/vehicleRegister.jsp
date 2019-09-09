
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Vehicle Details</title>
<script src="js/validateVehicle.js">
	
</script>
<style>
body {
	background-color: lightblue;
}

table {
	background-color: #d1ede7;
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
	<br>
	<br>
	<center>
		<h1>Vehicle Registration Form</h1>
	</center>
	<br>
	<br>
	<div id="addVehicleForm">
		<form action="vehicleRegister" method="POST">
			<table cellpadding=10 cellspacing=10 align="center"
				style="background-color: rgb(173, 235, 235)">
				<tr>
					<td colspan="3">
						<center>
							<h3>
								Add Vehicle:
								<h3>
						</center> <br>
					</td>
				</tr>
				<tr>
					<td align="left"><label><b>Name:</b></label></td>
					<td><input type="text" name="vehicleName" id="vehicle_name"
						placeholder="vehicle name"></td>

					<td><span id="vehicle_emp_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Vehicle Type:</b></label></td>
					<td><input type="radio" name="vehicleType" value="Cycle"
						id="vehicleType1"> <label><b>Cycle</b></label> <input
						type="radio" name="vehicleType" value="MotorCycle"
						id="vehicleType2"> <label><b>MotorCycle</b></label> <input
						type="radio" name="vehicleType" value="FourWheeler"
						id="vehicleType3"> <label><b>FourWheeler</b></label></td>

					<td><span id="vehicle_type_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Employee Id:</b></label></td>
					<td><input type="text" name="empId" id="empId"
						value="<%=request.getSession().getAttribute("empId")%>" readonly>
					</td>

					<td><span id="vehicle_emp_id_error_message"></span></td>
				</tr>
				<tr>
					<td><label>Vehicle Number</label></td>
					<td><input type="text" name="vehicleNumber"
						onkeypress="return numbers(event)" maxlength=4
						name="vehicle_number" id="vehicle_number"
						placeholder="Number(Last four digit)"></td>
					<td><span id="vehicle_number_error_message"></span></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="3"><input
						type="button" value="get Pass Details"
						onclick="return validateVehicleForm()"></td>

				</tr>
			</table>
			<table id="passDetail" style="display: none" cellpadding=10
				cellspacing=10 align="center"
				style="background-color:rgb(173, 235, 235)">

				<tr>
					<td colspan="3" style="text-align: center;">
						<h3>Pass prices</h3> <br>
					</td>
				</tr>
				<tr>
					<td align="left"><input type="radio" name="PassPriceDetail"
						value="" id="daily"></td>
					<td><label id="dailylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td align="left"><input type="radio" name="PassPriceDetail"
						value="" id="monthly"></td>
					<td><label id="monthlylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td align="left"><input type="radio" name="PassPriceDetail"
						value="" id="yearly"></td>
					<td><label id="yearlylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Get Pass"
						style="text-align: center;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>