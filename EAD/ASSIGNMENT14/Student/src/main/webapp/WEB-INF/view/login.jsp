<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/login"  method="POST">
		<h4 class="text-danger">${errorMsg}</h4>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>