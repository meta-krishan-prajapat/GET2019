package com.metacube.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author krishan
 * FriendDataServlet class gets the id of the particular friend and forwards it to the friendDetail page.
 */
public class FriendDataServlet extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		HttpSession session = req.getSession(false);
		session.setAttribute("friendId",Integer.parseInt(id));
		
		try
		{
			RequestDispatcher rd= req.getRequestDispatcher("friendDetail.jsp");
			rd.forward(req, res);
		}		
		catch (Exception e)
		{
			
			e.printStackTrace();
		}	
	}
}