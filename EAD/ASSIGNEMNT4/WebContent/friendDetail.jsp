<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList,java.util.List,POJO.Friends"
	session="false"%>
	<%
	List<Friends> listOfAllFriendsData=new ArrayList<Friends>();
	listOfAllFriendsData=(List<Friends>)request.getSession().getAttribute("listOfAllFriendsData");
	int friendId=(int)request.getSession().getAttribute("friendId");
	Friends ob=null;
	for(Friends f:listOfAllFriendsData)
	{
		if(f.getE().getEmpId()==friendId)
		{
			
			ob=f;
			
			break;
		}
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>friend Details</title>
</head>
<body>
<form action="employeeWelcome" method="POST">
<table>
<tr>
<th>Name</th>
<td><%=ob.getE().getEmpName() %></td>
</tr>
<tr>
<th>Email</th>
<td><%=ob.getE().getEmpEmail() %></td>
</tr>
<tr>
<th>Contact</th>
<td><%=ob.getE().getEmpContact() %></td>
</tr>
<tr>
<th>Gender</th>
<td><%=ob.getE().getEmpGender() %></td>
</tr>
<tr>
<th>Organization</th>
<td><%=ob.getE().getEmpOrganization() %></td>
</tr>
<tr>
<th>VehicleName</th>
<td><%=ob.getV().getVehicleName() %></td>
</tr>
<tr>
<th>VehicleType</th>
<td><%=ob.getV().getVehicleType() %></td>
</tr>
<tr>
<th>VehicleNumber</th>
<td><%=ob.getV().getVehicleNumber() %></td>
</tr>
<tr>
<th>PassPrice</th>
<td><%=ob.getV().getPassPriceDetail() %></td>
</tr>
<tr>
<td><input type="submit" value ="Home Page"></td>
</tr>
</table>
</form>
</body>
</html>