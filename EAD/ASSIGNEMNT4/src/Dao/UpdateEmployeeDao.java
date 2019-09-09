package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.Employee;
import POJO.EmployeeVehicle;

/**
 * @author krishan
 * UpdateEmployeeDao class to update employee details
 */
public class UpdateEmployeeDao
{
	Connection con;

	/**
	 * constructor to initialize connection
	 */
	public UpdateEmployeeDao()
	{
		con = DBConnectionDao.getDBConnection();
	}

	/**
	 * @param id
	 * @param e
	 * @param v
	 * @return no. of updated rows
	 */
	public int updateEmployee(int id, Employee e, EmployeeVehicle v)
	{
		String sqlQuery = "Update empDetails e,empVehicleDetails v set e.empName=? , e.empContact=?, e.empGender=?,  e.empOrganization=?,v.vehicleName=?,v.vehicleNumber=? where e.empid=? AND v.empid=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getEmpContact());
			ps.setString(3, e.getEmpGender());
			ps.setString(4, e.getEmpOrganization());
			ps.setString(5, v.getVehicleName());
			ps.setString(6, v.getVehicleNumber());
			ps.setInt(7, id);
			ps.setInt(8, id);
			int rows = ps.executeUpdate();
			return rows;
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}

		return -1;
	}
}
