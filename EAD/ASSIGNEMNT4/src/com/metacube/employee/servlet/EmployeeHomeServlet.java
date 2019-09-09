package com.metacube.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RetrieveEmployeeData;
import POJO.Employee;

/**
 * @author krishan
 * EmployeeHomeServlet class checks if the login credentials are correct or not.
 */
public class EmployeeHomeServlet  extends HttpServlet
{
	/**
	 *service method to process request and generate response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession session;
		String empEmail=req.getParameter("empEmail");
		String empPassword=req.getParameter("empPassword");
		RetrieveEmployeeData red=new RetrieveEmployeeData();
		PrintWriter out = res.getWriter();
		Employee emp=new Employee();
		
		emp.setEmpEmail(empEmail);
		emp.setEmpPassword(empPassword);
		int id=red.collectEmployeeId(emp);
		if(id!=-1)
		{
			session=req.getSession();
			session.setAttribute("empEmail", empEmail);
			session.setAttribute("empId", id);
			RequestDispatcher rd=req.getRequestDispatcher("employeeWelcome");
			rd.forward(req, res);
			
		}
		else
		{
			out.print("<script>alert('User not found,Please Enter valid email!');</script>");
			out.print("<script>window.location='login.html'</script>");
		}
	}
}
