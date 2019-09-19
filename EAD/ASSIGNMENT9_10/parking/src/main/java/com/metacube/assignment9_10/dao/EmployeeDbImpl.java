package com.metacube.assignment9_10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import com.metacube.assignment9_10.mapper.EmpDetailsMapper;
import com.metacube.assignment9_10.mapper.EmpVehicleMapper;
import com.metacube.assignment9_10.mapper.FriendsMapper;
import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeAllDetails;
import com.metacube.assignment9_10.model.EmployeeVehicle;
import com.metacube.assignment9_10.model.Friends;

/**
 * @author krishan
 * EmployeeDbImpl class is an implementation class for EmployeeDb and it is a repository class 
 */
@Repository
public class EmployeeDbImpl implements EmployeeDb
{
	JdbcTemplate template;

	@Autowired
	public void jdbcRef(DataSource dataSource)
	{
		template = new JdbcTemplate(dataSource);
	}

	/**
	 * @param emp
	 * @return success if successfully insets data to Employee table
	 */
	@Override
	public String InsertEmployeeToDb(Employee emp)
	{
		try
		{
			int result = template.update(new PreparedStatementCreator()
			{

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException
				{
					String sqlQuery = "INSERT INTO empDetails(empName, empEmail, empContact, empGender, empPassword, empOrganization) VALUES(?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(sqlQuery);
					ps.setString(1, emp.getEmpName());
					ps.setString(2, emp.getEmpEmail());
					ps.setString(3, emp.getEmpContact());
					ps.setString(4, emp.getEmpGender());
					ps.setString(5, emp.getEmpPassword());
					ps.setString(6, emp.getEmpOrganization());
					return ps;
				}
			});

			if (result > 0)
			{
				return "success";
			}
			else
			{
				return "couldn't insert to db ";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param vehicle
	 * @return true if successfully inserts data to  EmployeeVehicle table else return false
	 */
	public boolean InsertEmployeeVehicleToDb(EmployeeVehicle vehicle)
	{

		try
		{
			int result = template.update(new PreparedStatementCreator()
			{

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException
				{
					String sqlQuery = "INSERT INTO empVehicleDetails(empId,vehicleName,vehicleType,vehicleNumber,PassPriceDetail) VALUES(?,?,?,?,?)";

					PreparedStatement ps = con.prepareStatement(sqlQuery);
					ps.setInt(1, vehicle.getEmpId());
					ps.setString(2, vehicle.getVehicleName());
					ps.setString(3, vehicle.getVehicleType());
					ps.setString(4, vehicle.getVehicleNumber());
					ps.setString(5, vehicle.getPassPriceDetail());
					return ps;
				}

			});
			if (result > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * @param email
	 * @param pass
	 * @return employee object if user is authenticate else return null
	 */
	public Employee AuthenticateLogin(String email, String pass)
	{
		try
		{
			String sqlQueryEmployeeDetails = "SELECT empId,empName, empEmail, empContact, empGender, empPassword, empOrganization,empPassword FROM empDetails WHERE empEmail=? AND empPassword=?";

			Employee resultEmployeeDetails = template.queryForObject(sqlQueryEmployeeDetails, new Object[]
			{ email, pass }, new EmpDetailsMapper());

			if (resultEmployeeDetails != null)
			{

				return resultEmployeeDetails;

			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param empId
	 * @return EmployeeVehicle if vehicle details exist in the EmployeeVehicle table else return null
	 */
	@Override
	public EmployeeVehicle getVehicleDetails(int empId)
	{
		try
		{

			String sqlQueryVehicle = "SELECT vehicleName,vehicleType,vehicleNumber,PassPriceDetail FROM empVehicleDetails WHERE empId=?";
			EmployeeVehicle resultVehicleDetails = template.queryForObject(sqlQueryVehicle, new Object[]
			{ empId }, new EmpVehicleMapper());
			if (resultVehicleDetails != null)
			{

				return resultVehicleDetails;

			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param organization
	 * @param id
	 * @return list of friends if friends exist else return null
	 */
	@Override
	public List<Friends> getFriends(String organization, int id)
	{
		try
		{
			String sqlQuery = "SELECT e.empId,e.empName,e.empEmail, e.empContact, e.empGender,e.empOrganization,v.vehicleName,v.vehicleType,v.vehicleNumber,v.PassPriceDetail FROM empDetails e INNER JOIN empVehicleDetails v on e.empId=v.empId WHERE e.empOrganization=? AND e.empId<>?";
			List<Friends> friends = template.queryForObject(sqlQuery, new Object[]
			{ organization, id }, new FriendsMapper());
			if (friends != null)
			{

				return friends;

			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param ead
	 * @param id
	 * @return true if user details are successfully updated in the table else return false
	 */
	@Override
	public boolean updateEmployeeDb(EmployeeAllDetails ead, int id)
	{
		try
		{
			String sqlQuery = "UPDATE empDetails e,empVehicleDetails v SET e.empName=? , e.empContact=?, e.empGender=?,  e.empOrganization=?,v.vehicleName=?,v.vehicleNumber=? WHERE e.empid=? AND v.empId=?";
			return template.update(sqlQuery, ead.getEmpName(), ead.getEmpContact(), ead.getEmpGender(), ead.getEmpOrganization(),
					ead.getVehicleName(), ead.getVehicleNumber(), id, id) > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
