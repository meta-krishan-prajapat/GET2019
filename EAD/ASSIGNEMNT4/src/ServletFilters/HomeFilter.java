package ServletFilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author krishan
 * HomeFilter class filter the request of login page.
 */
public class HomeFilter implements Filter
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

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		String email = req.getParameter("empEmail");
		String pass = req.getParameter("empPassword");
		if (pass == null || email == null || pass == "" || email == "")
		{
			out.print("<script>alert('email or password can't be empty');</script>");
			out.print("<script>window.location='login.html'</script>");
		}
		else
		{
			fc.doFilter(req, res);
		}
	}
}