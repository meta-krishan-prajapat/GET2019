package com.metacube.assignment9_10.model;

/**
 * @author krishan
 * Employee class keeps the details of employee
 */
public class Employee
{
	protected String empName, empEmail, empContact, empGender, empPassword, empOrganization;
	private int empId;

	/**
	 * @return empId
	 */
	public int getEmpId()
	{
		return empId;
	}

	/**
	 * @param empId
	 * method to set empId
	 */
	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	/**
	 * @return empName
	 */
	public String getEmpName()
	{
		return empName;
	}

	/**
	 * @param empName
	 * method to set empName
	 */
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	/**
	 * @return empEmail
	 */
	public String getEmpEmail()
	{
		return empEmail;
	}

	/**
	 * @param empEmail
	 * method to set empEmail
	 */
	public void setEmpEmail(String empEmail)
	{
		this.empEmail = empEmail;
	}

	/**
	 * @return empPassword
	 */
	public String getEmpPassword()
	{
		return empPassword;
	}

	/**
	 * @param empPassword
	 * method to set empPassword
	 */
	public void setEmpPassword(String empPassword)
	{
		this.empPassword = empPassword;
	}

	/**
	 * @return empContact
	 */
	public String getEmpContact()
	{
		return empContact;
	}

	/**
	 * @param empContact
	 * method to set empContact
	 */
	public void setEmpContact(String empContact)
	{
		this.empContact = empContact;
	}

	/**
	 * @return empGender
	 */
	public String getEmpGender()
	{
		return empGender;
	}

	/**
	 * @param empGender
	 * method to set empGender
	 */
	public void setEmpGender(String empGender)
	{
		this.empGender = empGender;
	}

	/**
	 * @return empOrganization
	 */
	public String getEmpOrganization()
	{
		return empOrganization;
	}

	/**
	 * @param empOrganization
	 * method to set empOrganization
	 */
	public void setEmpOrganization(String empOrganization)
	{
		this.empOrganization = empOrganization;
	}

}
