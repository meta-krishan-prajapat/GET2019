package com.metacube.employee.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author krishan
 * LogoutServlet class destroy the session and redirect to login page
 */
public class LogoutServlet extends HttpServlet
{
	/**
	 * Service method to process request and generate response
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			HttpSession session = req.getSession(false);
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}