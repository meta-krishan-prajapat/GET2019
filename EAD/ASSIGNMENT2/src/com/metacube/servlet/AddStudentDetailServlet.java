package com.metacube.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.InsertStudentDao;
import POJO.Student;

/**
 * @author krishan
 * AddStudentDetailServlet class is a Servlet that will add the student details entered in addStudentDetail.html
 * to the database.
 */
public class AddStudentDetailServlet extends HttpServlet
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
			String firstName = req.getParameter("first_Name");
			String lastName = req.getParameter("last_Name");
			String fatherName = req.getParameter("father_Name");
			String email = req.getParameter("email");
			String className = req.getParameter("class_Name");
			String age = req.getParameter("age");
			PrintWriter out = res.getWriter();
			if (firstName != null && lastName != null && fatherName != null && email != null && className != null && age != null)
			{
				Student student = new Student();
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setFatherName(fatherName);
				student.setEmail(email);
				student.setClassName(className);
				student.setAge(age);

				InsertStudentDao istdDao = new InsertStudentDao();
				boolean result = istdDao.InsertStudent(student);

				if (result == true)
				{
					out.print("<script>alert('data successfully Inserted');</script>");
					out.print("<script>window.location='index.html'</script>");

				}
				else
				{

					out.print("<script>alert('data couldn't Inserted,please Insert again!');</script>");
					out.print("<script>window.location='index.html'</script>");
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
