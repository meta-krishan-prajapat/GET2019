package com.metacube.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.RetrieveStudentData;
import POJO.Student;

/**
 * @author krishan
 * ShowAllStudentsServlet class is a servlet that will display all the students details from the database.
 *
 */
public class ShowAllStudentsServlet extends HttpServlet
{
	/**
	 *service method to process request and response 
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			RetrieveStudentData rsd = new RetrieveStudentData();
			List<Student> list = rsd.collectAllStudentsData();
			req.setAttribute("listOfAllStudents", list);
			RequestDispatcher rd = req.getRequestDispatcher("displayAllStudents.jsp");
			rd.forward(req, res);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
