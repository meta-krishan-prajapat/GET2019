package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.EmployeeVehicle;

/**
 * @author krishan 
 * InsertVehicleDao is a class that inserts vehicle details to
 * the database
 */
public class InsertVehicleDao
{
	Connection con;

	/**
	 * Constructor to initialise the connection
	 */
	public InsertVehicleDao()
	{
		con = DBConnectionDao.getDBConnection();
	}

	/**
	 * @param vehicle
	 * @return true if the vehicle details are successfully inserted into the database
	 *         else return false.
	 */
	public boolean Insertvehicle(EmployeeVehicle vehicle)
	{
		String sqlQuery = "INSERT INTO empVehicleDetails(empId,vehicleName,vehicleType,vehicleNumber,PassPriceDetail) VALUES(?,?,?,?,?)";
		try
		{

			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, vehicle.getEmpId());
			ps.setString(2, vehicle.getVehicleName());
			ps.setString(3, vehicle.getVehicleType());
			ps.setString(4, vehicle.getVehicleNumber());
			ps.setString(5, vehicle.getPassPriceDetail());

			int result = ps.executeUpdate();
			ps.close();
			if (result == 1)
			{

				con.close();

				return true;

			}
			else
			{
				con.close();
				return false;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
