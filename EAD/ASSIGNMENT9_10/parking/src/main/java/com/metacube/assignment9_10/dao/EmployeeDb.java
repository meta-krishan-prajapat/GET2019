package com.metacube.assignment9_10.dao;

import java.util.List;

import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeAllDetails;
import com.metacube.assignment9_10.model.EmployeeVehicle;
import com.metacube.assignment9_10.model.Friends;

public interface EmployeeDb
{
	/**
	 * @param emp
	 * @return success if successfully insets data to Employee table
	 */
	public String InsertEmployeeToDb(Employee emp);

	/**
	 * @param vehicle
	 * @return true if successfully inserts data to  EmployeeVehicle table else return false
	 */
	public boolean InsertEmployeeVehicleToDb(EmployeeVehicle vehicle);

	/**
	 * @param email
	 * @param pass
	 * @return employee object if user is authenticate else return null
	 */
	public Employee AuthenticateLogin(String email, String pass);

	/**
	 * @param empId
	 * @return EmployeeVehicle if vehicle details exist in the EmployeeVehicle table else return null
	 */
	public EmployeeVehicle getVehicleDetails(int empId);

	/**
	 * @param organization
	 * @param id
	 * @return list of friends if friends exist else return null
	 */
	public List<Friends> getFriends(String organization, int id);

	/**
	 * @param ead
	 * @param id
	 * @return true if user details are successfully updated in the table else return false
	 */
	public boolean updateEmployeeDb(EmployeeAllDetails ead, int id);
}
