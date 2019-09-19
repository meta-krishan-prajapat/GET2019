<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="checkLogin" method="post">
			<input type="email" name="empEmail"
				placeholder="enter registered email"> <input type="password"
				name="empPassword" placeholder="enter password"> <input
				type="submit" value="Login">
		</form>
	</div>
	<div>
		<a href="index">not registered? register here</a>
	</div>

</body>
</html>