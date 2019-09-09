<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList,java.util.List,POJO.Friends"
	session="false"%>
	<%
	List<Friends> listOfAllFriendsData=new ArrayList<Friends>();
	listOfAllFriendsData=(List<Friends>)request.getSession().getAttribute("listOfAllFriendsData");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>friend list</title><style>body {
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
}</style>

</head>
<body>
your friends are:
<%
for(Friends f:listOfAllFriendsData)
{
%>

<a href="friendsData?id=<%=f.getE().getEmpId()%>"><%=f.getE().getEmpName() %> </a><br>
<%
}
%>
<form action="employeeWelcome" method="POST">
<input type="submit" value="Home Page">
</form>
</body>
</html>