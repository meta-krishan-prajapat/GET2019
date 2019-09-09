package ServletFilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author krishan
 * VehicleRegister filters the request of vehicle register page.
 */
public class VehicleRegisterFilter implements Filter
{
	FilterConfig filterConfig;

	/**
	 *Filter interface method
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.filterConfig = filterConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		String vehicleName = req.getParameter("vehicleName");

		String vehicleNumber = req.getParameter("vehicleNumber");

		PrintWriter out = res.getWriter();
		if (vehicleName == null || vehicleNumber == null)
		{
			out.print("<script>alert('some of the fields are empty');</script>");
			out.print("<script>window.location='vehicleRegister.jsp'</script>");
		}
		else
		{
			chain.doFilter(req, res);
		}
	}
}