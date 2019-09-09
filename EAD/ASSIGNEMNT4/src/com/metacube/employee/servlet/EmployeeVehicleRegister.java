package com.metacube.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.InsertVehicleDao;
import POJO.EmployeeVehicle;
/**
 * @author krishan
 * EmployeeVehicleRegister class registers the vehicle by adding data to the database.
 */
public class EmployeeVehicleRegister  extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		 HttpSession session = req.getSession(false);
		 int empId=Integer.parseInt(req.getParameter("empId"));
		String vehicleName=req.getParameter("vehicleName");
		String vehicleType=req.getParameter("vehicleType");
		String vehicleNumber=req.getParameter("vehicleNumber");
		String passPriceDetail=req.getParameter("PassPriceDetail");
		EmployeeVehicle vehicle=new EmployeeVehicle();
		vehicle.setEmpId(empId);
		vehicle.setPassPriceDetail(passPriceDetail);
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleType(vehicleType);
		PrintWriter out= res.getWriter();
		InsertVehicleDao ivd=new InsertVehicleDao();
		boolean result=ivd.Insertvehicle(vehicle);
		if(result==true)
		{
			session.invalidate();
			RequestDispatcher rd=req.getRequestDispatcher("/login.html");
			rd.forward(req, res);
		}
		else
		{
			out.print("<script>alert('error Inserting data');</script>");
			out.print("<script>window.location='vehicleRegister.jsp'</script>");
			
			
		}		
	}
}