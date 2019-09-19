<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>EmployeeDetails</title>
<!--<Script src="/js/validateEmployee.js"></Script>-->
</head>

<body style="text-align: center">
	<div>
		<a href="login">already registered? login here</a>
	</div>
	<div id="employeeDetails">
		<form:form onsubmit=" return registerEmployee()"
			action="vehicleRegister" method="POST" modelAttribute="Employee">
			<table cellpadding=10 cellspacing=10 align="center"
				style="background-color: rgb(173, 235, 235)">
				<tr>
					<td colspan="3">
						<h3>
							Employee details:
							<h3>
								<br>
					</td>
				</tr>

				<tr>
					<td align="left"><label><b>name:</b></label></td>
					<td><form:input type="text" path="empName" placeholder="name" />
					</td>

					<td><span id="emppath_error_message"></span></td>
				</tr>

				<tr>
					<td align="left"><label><b>Emailid:</b></label></td>
					<td><form:input type="text" path="empEmail"
							placeholder="email" /></td>

					<td><span id="empEmail_error_message"></span></td>
				</tr>


				<tr>
					<td align="left"><label><b>contact no:</b></label></td>
					<td><form:input type="text" path="empContact" maxlength="10"
							onkeypress="return numbers(this.event)" placeholder="contact no." />
					</td>

					<td><span id="empContact_error_message"></span></td>
				</tr>


				<tr>
					<td align="left"><label><b>Gender:</b></label></td>
					<td><form:radiobutton path="empGender" value="Male" /> <label><b>Male</b></label>
						<form:radiobutton path="empGender" value="Female" /> <label><b>Female</b></label><br>
					</td>

					<td><span id="empGender_error_message"></span></td>
				</tr>

				<tr>
					<td align="left"><label><b>Password:</b></label></td>
					<td><form:input type="password" path="empPassword"
							placeholder="password" /></td>

					<td><span id="empPassword_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Confirm Password:</b></label></td>
					<td><input type="password" name="empConfirmPassword"
						placeholder="confirm password" /></td>

					<td><span id="confirm_empPassword_error_message"></span></td>
				</tr>
				<tr>
					<td align="left"><label><b>Organization</b></label></td>
					<td><form:select path="empOrganization">
							<form:option value="Metacube">Metacube</form:option>
							<form:option value="Google">Google</form:option>
							<form:option value="Microsoft">Microsoft</form:option>
							<form:option value="TCS">TCS</form:option>
						</form:select></td>

					<td><span id="empOrganization_error_message"></span></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="submit"
						style="margin-top: 20px"></td>

				</tr>
			</table>
		</form:form>
	</div>

</body>

</html>