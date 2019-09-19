<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>employee vehicle details</title>
<script type="text/javascript">
	function validateVehicleForm() {

		vehicle_emp_name = document.getElementById("vehicle_name");
		vehicle_emp_id = document.getElementById("empId");
		vehicle_type1 = document.getElementById("vehicleType1");
		vehicle_type2 = document.getElementById("vehicleType2");
		vehicle_type3 = document.getElementById("vehicleType3");

		vehicle_emp_number = document.getElementById("vehicle_number");
		if (vehicle_emp_name.value == "") {
			document.getElementById('vehicle_emp_error_message').innerHTML = "Name must be filled out";
			document.getElementById('vehicle_emp_error_message').style.color = "red";
			return false;
		}
		employee_name_letters = /^([a-z]+[ ]?|[a-z]+)+$/;
		if (!vehicle_emp_name.value.match(employee_name_letters)) {
			document.getElementById('vehicle_emp_error_message').innerHTML = "Name should not contain any numbers or special character";
			document.getElementById('vehicle_emp_error_message').style.color = "red";
			return false;
		}
		if (vehicle_emp_id.value == "") {
			document.getElementById('vehicle_emp_id_error_message').innerHTML = "Id must be filled out";
			document.getElementById('vehicle_emp_id_error_message').style.color = "red";
			return false;
		}
		if (vehicle_emp_number.value == "") {
			document.getElementById('vehicle_number_error_message').innerHTML = "Number must be filled out";
			document.getElementById('vehicle_number_error_message').style.color = "red";
			return false;
		}
		if (!vehicle_type1.checked && !vehicle_type2.checked
				&& !vehicle_type3.checked) {
			document.getElementById('vehicle_type_error_message').innerHTML = "Type must be filled out";
			document.getElementById('vehicle_type_error_message').style.color = "red";
			return false;
		} else {

			var dailyPassPrice, monthlyPassPrice, yearlyPassPrice;
			if (document.getElementById("vehicleType1").checked) {
				dailyPassPrice = 5;
				monthlyPassPrice = 100;
				yearlyPassPrice = 500;
				document.getElementById("daily").value = dailyPassPrice;
				document.getElementById("monthly").value = monthlyPassPrice;
				document.getElementById("yearly").value = yearlyPassPrice;
				document.getElementById("dailylabel").innerHTML = "daily Pass Price is "
						+ dailyPassPrice;
				document.getElementById("monthlylabel").innerHTML = "monthly Pass Price is "
						+ monthlyPassPrice;
				document.getElementById("yearlylabel").innerHTML = "yearly Pass Price is "
						+ yearlyPassPrice;
				document.getElementById("passDetail").style.display = "block";

			} else if (document.getElementById("vehicleType2").checked) {
				dailyPassPrice = 10;
				monthlyPassPrice = 200;
				yearlyPassPrice = 1000;
				document.getElementById("daily").value = dailyPassPrice;
				document.getElementById("monthly").value = monthlyPassPrice;
				document.getElementById("yearly").value = yearlyPassPrice;
				document.getElementById("dailylabel").innerHTML = "daily Pass Price is "
						+ dailyPassPrice;
				document.getElementById("monthlylabel").innerHTML = "monthly Pass Price is "
						+ monthlyPassPrice;
				document.getElementById("yearlylabel").innerHTML = "yearly Pass Price is "
						+ yearlyPassPrice;
				document.getElementById("passDetail").style.display = "block";

			} else if (document.getElementById("vehicleType3").checked) {
				dailyPassPrice = 20;
				monthlyPassPrice = 500;
				yearlyPassPrice = 3500;
				document.getElementById("daily").value = dailyPassPrice;
				document.getElementById("monthly").value = monthlyPassPrice;
				document.getElementById("yearly").value = yearlyPassPrice;
				document.getElementById("dailylabel").innerHTML = "daily Pass Price is "
						+ dailyPassPrice;
				document.getElementById("monthlylabel").innerHTML = "monthly Pass Price is "
						+ monthlyPassPrice;
				document.getElementById("yearlylabel").innerHTML = "yearly Pass Price is "
						+ yearlyPassPrice;
				document.getElementById("passDetail").style.display = "block";

			}

		}
	}
</script>
</head>
<body>
	<div id="addVehicleForm">
		<form:form action="vehicleDetailsToDb" method="POST"
			modelAttribute="EmployeeVehicle">
			<table cellpadding=10 cellspacing=10 align="center"
				style="background-color: rgb(173, 235, 235)">
				<tr>
					<td colspan="3">
						<h3>
							Add Vehicle:
							<h3>
								<br>
					</td>
				</tr>
				<tr>
					<td align="left"><label><b>name:</b></label></td>
					<td><form:input type="text" path="vehicleName"
							id="vehicle_name" placeholder="vehicle name" /></td>

					<td><span id="vehicle_emp_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Vehicle Type:</b></label></td>
					<td><form:radiobutton path="vehicleType" value="Cycle"
							id="vehicleType1" /> <label><b>Cycle</b></label> <form:radiobutton
							path="vehicleType" value="MotorCycle" id="vehicleType2" /> <label><b>MotorCycle</b></label>
						<form:radiobutton path="vehicleType" value="FourWheeler"
							id="vehicleType3" /> <label><b>FourWheeler</b></label></td>

					<td><span id="vehicle_type_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Employee Id:</b></label></td>
					<td><form:input type="text" path="empId" id="empId"
							value="${empId}" /></td>

					<td><span id="vehicle_emp_id_error_message"></span></td>
				</tr>
				<tr>
					<td><label>Vehicle Number</label></td>
					<td><form:input type="text" path="vehicleNumber"
							onkeypress="return numbers(event)" maxlength="4"
							id="vehicle_number" placeholder="Number(Last four digit)" /></td>
					<td><span id="vehicle_number_error_message"></span></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" value="get Pass Details"
						onclick="return validateVehicleForm()" /></td>

				</tr>
			</table>
			<table id="passDetail" style="display: none" cellpadding=10
				cellspacing=10 align="center"
				style="background-color:rgb(173, 235, 235)">

				<tr>
					<td colspan="3">
						<h3>Pass prices</h3> <br>
					</td>
				</tr>
				<tr>
					<td align="left"><form:radiobutton path="PassPriceDetail"
							value="" id="daily" /></td>
					<td><label id="dailylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td align="left"><form:radiobutton path="PassPriceDetail"
							value="" id="monthly" /></td>
					<td><label id="monthlylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td align="left"><form:radiobutton path="PassPriceDetail"
							value="" id="yearly" /></td>
					<td><label id="yearlylabel"></label></td>

					<td><span></span></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Get Pass"></td>

				</tr>

			</table>


		</form:form>
	</div>

</body>
</html>