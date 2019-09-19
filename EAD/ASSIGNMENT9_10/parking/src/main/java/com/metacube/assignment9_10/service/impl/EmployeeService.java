package com.metacube.assignment9_10.service.impl;

import java.util.List;
import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeAllDetails;
import com.metacube.assignment9_10.model.EmployeeVehicle;
import com.metacube.assignment9_10.model.Friends;

/**
 * @author krishan
 * EmployeeService keeps the service methods for this web application
 *
 */
public interface EmployeeService
{
	/**
	 * @param emp
	 * @return true if employee successfully inserted to database else return false
	 */
	public boolean setEmployeeToDb(Employee emp);

	/**
	 * @param employeeVehicle
	 * @return true if vehicle details successfully inserted to database else return false
	 */
	public boolean setEmployeeVehicleToDb(EmployeeVehicle employeeVehicle);

	/**
	 * @param email
	 * @param pass
	 * @return list of the employee details fetched from database
	 */
	public List<String> getEmployeeDetails(String email, String pass);

	/**
	 * @param email
	 * @param pass
	 * @return true if user exist else return false
	 */
	public boolean checkLogin(String email, String pass);

	/**
	 * @param organization
	 * @param id
	 * @return the list of all the friends 
	 */
	public List<Friends> getAllFriends(String organization, int id);

	/**
	 * @param ead
	 * @param id
	 * @return updates the employee details
	 */
	public boolean updateEmployee(EmployeeAllDetails ead, int id);
}
