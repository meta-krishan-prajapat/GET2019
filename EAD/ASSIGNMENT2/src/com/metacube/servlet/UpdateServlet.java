package com.metacube.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.RetrieveStudentData;
import POJO.Student;

/**
 * @author krishan
 * UpdateServlet class is a servlet that forwards the update request of particular student to the update student.jsp page
 */
public class UpdateServlet extends HttpServlet
{
	/**
	 *service method to process request and response 
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		try
		{
			int id = Integer.parseInt(req.getParameter("id"));
			RetrieveStudentData rsd = new RetrieveStudentData();
			Student stu = rsd.collectStudentsData(id);
			req.setAttribute("firstName", stu.getFirstName());
			req.setAttribute("lastName", stu.getLastName());
			req.setAttribute("fatherName", stu.getFatherName());
			req.setAttribute("email", stu.getEmail());
			req.setAttribute("className", stu.getClassName());
			req.setAttribute("age", stu.getAge());
			req.setAttribute("id", id);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateStudent.jsp");
			rd.forward(req, res);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
