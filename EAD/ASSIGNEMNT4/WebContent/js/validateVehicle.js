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
	} 
	else {

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
