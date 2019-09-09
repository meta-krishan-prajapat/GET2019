package com.metacube.employee.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RetrieveEmployeeData;
import POJO.Employee;
import POJO.Friends;
/**
 * @author krishan
 * FriendListServlet collects all the friends data in a list and forwards it to the friends page
 */
public class FriendListServlet extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
public void doGet(HttpServletRequest req,HttpServletResponse res)
{
	List<Friends> listOfAllFriendsData=new ArrayList<Friends>();
	try
	{
	HttpSession session = req.getSession(false);
	
	int id = (int) session.getAttribute("empId");
	List<Object> listOfAllData=new ArrayList<Object>();
	listOfAllData = (List<Object>)session.getAttribute("listOfAllData");
	Employee e=(Employee)listOfAllData.get(0);
	RetrieveEmployeeData red=new RetrieveEmployeeData();
	listOfAllFriendsData=red.collectAllEmployeeFriendsData(e.getEmpOrganization(),id);
	if(listOfAllFriendsData!=null)
	{
		session.setAttribute("listOfAllFriendsData", listOfAllFriendsData);
		RequestDispatcher rd=req.getRequestDispatcher("friends.jsp");
		rd.forward(req, res);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}