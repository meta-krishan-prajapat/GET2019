package com.metacube.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UpdateEmployeeDao;
import POJO.Employee;
import POJO.EmployeeVehicle;
/**
 * @author krishan
 * UpdateEmployeeResultServlet class takes the data to be updated in database,updates it and redirect to 
 * the welcome servlet that will reflect back the data on welcome page.
 */
public class UpdateEmployeeResultServlet extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("empId");
		String vehicleName=req.getParameter("vehicleName");
				String vehicleNumber=req.getParameter("vehicleNumber");
		
		EmployeeVehicle vehicle=new EmployeeVehicle();
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleNumber(vehicleNumber);
		
		String empName = req.getParameter("empName");
		String empEmail = req.getParameter("empEmail");
		String empContact = req.getParameter("empContact");
		String empGender = req.getParameter("empGender");
		
		String empOrganization = req.getParameter("empOrganization");
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setEmpEmail(empEmail);
		emp.setEmpContact(empContact);
		emp.setEmpGender(empGender);
		
		emp.setEmpOrganization(empOrganization);
		UpdateEmployeeDao update=new UpdateEmployeeDao();
		int rows=update.updateEmployee(id, emp, vehicle);
		if(rows!=-1)
		{
			out.print("<script>alert('sussceesufully updated')</script>");
			RequestDispatcher rd=req.getRequestDispatcher("employeeWelcome");
			rd.forward(req, res);
		}		
	}
}