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
 * UpdateRecordsFilter filter the update page request.
 */
public class UpdateRecordsFilter implements Filter
{
	FilterConfig filterConfig;

	/**
	 * Filter interface method
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

		String empName = req.getParameter("empName");
		String empContact = req.getParameter("empContact");
		String empGender = req.getParameter("empGender");
		String empOrganization = req.getParameter("empOrganization");
		PrintWriter out = res.getWriter();

		if (vehicleName == null || vehicleNumber == null)
		{
			out.print("<script>alert('vehicle details fields are empty');</script>");
			out.print("<script>window.location='updateEmployeeDetails.jsp'</script>");
		}
		else if (empName == null || empContact == null || empGender == null || empOrganization == null)
		{
			out.print("<script>alert('employee detail fields are empty');</script>");
			out.print("<script>window.location='updateEmployeeDetails.jsp'</script>");

		}
		else
		{
			chain.doFilter(req, res);
		}
	}
}