package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.Employee;

/**
 * @author krishan 
 * InsertemloyeepDao is a class that inserts employee details to the database
 */
public class InsertEmployeeDao
{
	Connection con;

	/**
	 * Constructor to initialize the connection
	 */
	public InsertEmployeeDao()
	{
		con = DBConnectionDao.getDBConnection();
	}

	/**
	 * @param emp
	 * @return true if the employee details are successfully inserted into the database
	 *         else return false.
	 */
	public int InsertEmployee(Employee emp)
	{
		String sqlQuery = "INSERT INTO empDetails(empName, empEmail, empContact, empGender, empPassword, empOrganization) VALUES(?,?,?,?,?,?)";
		try
		{

			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpEmail());
			ps.setString(3, emp.getEmpContact());
			ps.setString(4, emp.getEmpGender());
			ps.setString(5, emp.getEmpPassword());
			ps.setString(6, emp.getEmpOrganization());
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1)
			{

				con.close();
				RetrieveEmployeeData red = new RetrieveEmployeeData();

				return red.collectEmployeeId(emp);

			}
			else
			{
				con.close();
				return -1;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
}