package com.metacube.employee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RetrieveEmployeeData;
/**
 * @author krishan
 * EmployeeWelcomeServlet class collects all the data of employee and forward it to the EmployeeDetails page
 */
public class EmployeeWelcomeServlet extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("empId");
		RetrieveEmployeeData red = new RetrieveEmployeeData();
		List<Object> listOfAllData = new ArrayList<Object>();
		listOfAllData = red.collectEmployeeData(id);
		session.setAttribute("listOfAllData", listOfAllData);
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeDetails.jsp");
		rd.forward(req, res);
	}
}