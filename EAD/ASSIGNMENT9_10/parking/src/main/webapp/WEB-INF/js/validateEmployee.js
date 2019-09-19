			var id = 1;
		function registerEmployee() {
			employee_name = document.forms["employeeDetailsform"]["empName"].value;
			employee_name_letters = /^([A-Z a-z]+[ ]?|[a-z]+)+$/;
			if (employee_name == "") {
				document.getElementById('empName_error_message').innerHTML = "Name must be filled out";
				document.getElementById('empName_error_message').style.color = "red";
				return false;
			}
			if (employee_name.length < 2) {
				document.getElementById('empName_error_message').innerHTML = "Name must be contain minimum two character";
				document.getElementById('empName_error_message').style.color = "red";
				return false;
			}
			if (!employee_name.match(employee_name_letters)) {
				document.getElementById('empName_error_message').innerHTML = "Name should not contain any numbers or special character";
				document.getElementById('empName_error_message').style.color = "red";
				return false;
			}
			//for email validation//
			var email = document.forms["employeeDetailsform"]["empEmail"].value;
			
			if (email.length == 0) {
				document.getElementById('empEmail_error_message').innerHTML = "email field is empty";
				document.getElementById('empEmail_error_message').style.color = "red";
				return false;
			}
			//for contact validaton//
			var employee_contact = document.forms["employeeDetailsform"]["empContact"].value;
			if (employee_contact.length < 8) {
				if (employee_contact.length == 0) {
					document.getElementById('empContact_error_message').innerHTML = "Contact field is empty";
				}
				else {
					document.getElementById('empContact_error_message').innerHTML = "Contact length should be greater then 8";
				}
				document.getElementById('empContact_error_message').style.color = "red";
				return false;
			}
			//for gender validaton//
			var employee_gender = document.getElementsByName("empGender");
			if (employee_gender[0].checked == false && employee_gender[1].checked == false) {
				document.getElementById('empGender_error_message').innerHTML = "Please select your gender";
				document.getElementById('empGender_error_message').style.color = "red";
				return false;
			}
			//for password validation//
			var employee_password = document.forms["employeeDetailsform"]["empPassword"].value;
			var employee_confirm_password = document.forms["employeeDetailsform"]["confirm_empPassword_error_message"].value;
			alert("hello");
			if (employee_password == "") {
				document.getElementById('empPassword_error_message').innerHTML = "Password must be filled out";
				document.getElementById('empPassword_error_message').style.color = "red";
				return false;
			}
			if (!employee_password.match("(?=.*[a-z])")) {
				document.getElementById('empPassword_error_message').innerHTML = "Password contain at least one lower case";
				document.getElementById('empPassword_error_message').style.color = "red";
				return false;
			}
			if (!employee_password.match("(?=.*[0-9])")) {
				document.getElementById('empPassword_error_message').innerHTML = "Password should contain at one digit ";
				document.getElementById('empPassword_error_message').style.color = "red";
				return false;
			}
			if (!employee_password.match("(?=.*[A-Z])")) {
				document.getElementById('empPassword_error_message').innerHTML = "Password contain at least one upper case ";
				document.getElementById('empPassword_error_message').style.color = "red";
				return false;
			}
			if (!employee_password.match("(?=^.{8,}$)")) {
				document.getElementById('empPassword_error_message').innerHTML = "Password length minimum 8 ";
				document.getElementById('empPassword_error_message').style.color = "red";
				return false;
			}
			//check confirm password//
			if (!employee_password.match(employee_confirm_password)) {
				document.getElementById('confirm_empPassword_error_message').innerHTML = "Password mismatch";
				document.getElementById('confirm_empPassword_error_message').style.color = "red";
				return false;
			}
			
			
			
			
		}
		function numbers(e) {
			var x = (window.event) ? event.keyCode : e.which;
			if ((x >= 48 && x <= 57)) {
				return true;
			}
			else {
				return false;
			}
		}
				
	