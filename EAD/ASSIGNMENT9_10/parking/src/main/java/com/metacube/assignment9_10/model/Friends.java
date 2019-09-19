package com.metacube.assignment9_10.model;

/**
 * @author krishan
 * Friends class keeps the details of all friends
 */
public class Friends
{
	public Employee e;
	public EmployeeVehicle v;

	/**
	 * constructor to initialise Employee and EmployeeVehicle classes
	 */
	public Friends()
	{
		e = new Employee();
		v = new EmployeeVehicle();
	}

	/**
	 * @return Employee reference
	 * method to get Employee
	 */
	public Employee getE()
	{
		return e;
	}

	/**
	 * @param e 
	 * method sets Employee
	 */
	public void setE(Employee e)
	{
		this.e = e;
	}

	/**
	 * @return EmployeeVehicle reference
	 * method to get EmployeeVehicle
	 */
	public EmployeeVehicle getV()
	{
		return v;
	}

	/**
	 * @param v
	 *method sets EmployeeVehicle
	 */
	public void setV(EmployeeVehicle v)
	{
		this.v = v;
	}

}
