package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.UpdateExistingStudentDao;
import POJO.Student;

/**
 * @author krishan
 * UpdateStudentServlet class is a servlet that updates the student details to the database
 *
 */
public class UpdateStudentServlet extends HttpServlet
{
	/**
	 *service method to process request and response 
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			int id = Integer.parseInt(req.getParameter("id"));
			String firstName = req.getParameter("first_Name");
			String lastName = req.getParameter("last_Name");
			String fatherName = req.getParameter("father_Name");
			String email = req.getParameter("email");
			String className = req.getParameter("class_Name");
			String age = req.getParameter("age");
			if (firstName != null && lastName != null && fatherName != null && email != null && className != null && age != null)
			{
				Student student = new Student();
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setFatherName(fatherName);
				student.setEmail(email);
				student.setClassName(className);
				student.setAge(age);
				student.setStudentId(id);

				UpdateExistingStudentDao uesd = new UpdateExistingStudentDao();
				int result = uesd.UpdateById(student);
				if (result > 0)
				{

					out.print("<script>alert('data successfully updated');</script>");
					out.print("<script>window.location='index.html'</script>");
				}
				else
				{
					out.println("<script>alert(Sorry! unable to update record)</script>");
					out.print("<script>window.location='addStudentDetail.html'</script>");
				}
			}
			else
			{
				out.println("<script>alert(Sorry! null values are not accepted!)</script>");
				out.print("<script>window.location='addStudentDetail.html'</script>");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
