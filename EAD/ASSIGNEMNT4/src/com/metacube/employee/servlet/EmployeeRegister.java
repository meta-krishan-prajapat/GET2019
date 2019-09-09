package com.metacube.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.InsertEmployeeDao;
import POJO.Employee;
/**
 * @author krishan
 * EmployeeRegister class registers the employee in the database with a unique id. 
 */
public class EmployeeRegister extends HttpServlet
{
	/**
	 *service method to process request and generate response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out;
		HttpSession session;
		try
		{
			out = res.getWriter();
			session=req.getSession();
			String empName = req.getParameter("empName");
			String empEmail = req.getParameter("empEmail");
			String empContact = req.getParameter("empContact");
			String empGender = req.getParameter("empGender");
			String empPassword = req.getParameter("empPassword");
			String empOrganization = req.getParameter("empOrganization");
			if (empName != null && empEmail != null && empContact != null && empGender != null && empPassword != null
					&& empOrganization != null)
			{
				Employee emp = new Employee();
				emp.setEmpName(empName);
				emp.setEmpEmail(empEmail);
				emp.setEmpContact(empContact);
				emp.setEmpGender(empGender);
				emp.setEmpPassword(empPassword);
				emp.setEmpOrganization(empOrganization);
				InsertEmployeeDao ied = new InsertEmployeeDao();
				int result = ied.InsertEmployee(emp);
				if (result != -1)
				{
					session.setAttribute("empId",result);
					RequestDispatcher rd=req.getRequestDispatcher("/vehicleRegister.jsp");
					rd.include(req, res);
					rd.forward(req, res);
				} else
				{

					out.print("<script>alert('Duplicate data can't be inserted!');</script>");
					out.print("<script>window.location='index.html'</script>");
				}
			} else
			{
				out.println("<script>alert(Sorry! Null values are not accepted!)</script>");
				
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
