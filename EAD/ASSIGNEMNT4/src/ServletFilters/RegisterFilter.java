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
 * RegisterFilter class filter the request of register page
 */
public class RegisterFilter implements Filter
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
		String empName = req.getParameter("empName");
		String empEmail = req.getParameter("empEmail");
		String empContact = req.getParameter("empContact");
		String empGender = req.getParameter("empGender");
		String empPassword = req.getParameter("empPassword");
		String empOrganization = req.getParameter("empOrganization");
		PrintWriter out = res.getWriter();
		if (empName != null && empEmail != null && empContact != null && empGender != null && empPassword != null
				&& empOrganization != null)
		{
			chain.doFilter(req, res);
		}
		else
		{

			out.print("<script>alert('email or password can't be empty');</script>");
			out.print("<script>window.location='index.html'</script>");
		}
	}
}