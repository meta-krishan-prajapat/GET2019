package com.metacube.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.RetrieveStudentData;
import POJO.Student;

/**
 * @author krishan
 * SearchStudentServlet class is a Servlet that will search the student in the database according to the user's requirement.
 *
 */
public class SearchStudentServlet extends HttpServlet
{
	/**
	 * service method to process request and response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		try
		{
			PrintWriter out = res.getWriter();
			String id = req.getParameter("id");
			List<Student> resultDetails = new ArrayList<Student>();
			RetrieveStudentData rsd = new RetrieveStudentData();
			if ("firstName".equals(id))
			{
				String firstName = req.getParameter("firstName");
				resultDetails = rsd.collectStudentsDataByName(id, firstName);

			}
			else if ("lastName".equals(id))
			{
				String lastName = req.getParameter("lastName");
				resultDetails = rsd.collectStudentsDataByName(id, lastName);
			}
			req.setAttribute("resultDetails", resultDetails);
			RequestDispatcher rd = req.getRequestDispatcher("SearchStudentResult.jsp");
			rd.forward(req, res);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
