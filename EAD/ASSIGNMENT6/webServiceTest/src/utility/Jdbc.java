
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author krishan
 * Jdbc class for database connectivity
 *
 */
public class Jdbc
{

	/**
	 * @return Connection reference for database connection
	 */
	public static Connection makeConnection()
	{
		final String URL = "jdbc:mysql://localhost:3306/books";
		final String user = "root";
		final String pass = "1234";
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, pass);
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return conn;
	}
}