package com.metacube.assignment9_10.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.assignment9_10.dao.EmployeeDb;
import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeAllDetails;
import com.metacube.assignment9_10.model.EmployeeVehicle;
import com.metacube.assignment9_10.model.Friends;

/**
 * @author krishan
 *EmployeeServiceImpl is an implementation class for EmployeeService
 */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDb empdb;

	/**
	 * @param emp
	 * @return true if employee successfully inserted to database else return false
	 */
	@Override
	public boolean setEmployeeToDb(Employee emp)
	{
		try
		{
			String result = empdb.InsertEmployeeToDb(emp);
			if (result.equals("success"))
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
	 * @param employeeVehicle
	 * @return true if vehicle details successfully inserted to database else return false
	 */
	@Override
	public boolean setEmployeeVehicleToDb(EmployeeVehicle employeeVehicle)
	{
		try
		{
			boolean result = empdb.InsertEmployeeVehicleToDb(employeeVehicle);
			if (result == true)
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
	 * @return list of the employee details fetched from database
	 */
	@Override
	public List<String> getEmployeeDetails(String email, String pass)
	{
		try
		{
			List<String> allDetails = new ArrayList<String>();

			Employee e = empdb.AuthenticateLogin(email, pass);

			EmployeeVehicle ev = empdb.getVehicleDetails(e.getEmpId());

			if (e != null && ev != null)
			{
				allDetails.add(e.getEmpName());
				allDetails.add(e.getEmpEmail());
				allDetails.add(e.getEmpContact());
				allDetails.add(e.getEmpGender());
				allDetails.add(e.getEmpOrganization());
				allDetails.add(ev.getVehicleName());
				allDetails.add(ev.getVehicleType());
				allDetails.add(ev.getVehicleNumber());
				allDetails.add(ev.getPassPriceDetail());
				allDetails.add("" + e.getEmpId());
				allDetails.add(e.getEmpPassword());

				return allDetails;
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
	 * @param email
	 * @param pass
	 * @return true if user exist else return false
	 */
	@Override
	public boolean checkLogin(String email, String pass)
	{
		try
		{
			List<String> allDetails = getEmployeeDetails(email, pass);
			if (allDetails != null)
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
	 * @param organization
	 * @param id
	 * @return the list of all the friends 
	 */
	@Override
	public List<Friends> getAllFriends(String organization, int id)
	{
		List<Friends> friends = null;
		try
		{
			friends = empdb.getFriends(organization, id);
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
	 * @return updates the employee details
	 */
	@Override
	public boolean updateEmployee(EmployeeAllDetails ead, int id)
	{
		try
		{
			if (ead != null)
			{
				if (empdb.updateEmployeeDb(ead, id))
				{

					return true;
				}
				else
				{
					return false;
				}
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
}
