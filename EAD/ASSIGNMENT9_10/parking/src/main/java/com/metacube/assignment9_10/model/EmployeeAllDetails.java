package com.metacube.assignment9_10.model;

/**
 * @author krishan
 * EmployeeAllDetails class keeps All the details related to particular employee 
 */
public class EmployeeAllDetails
{
	protected String vehicleName, vehicleNumber, vehicleType, passPriceDetail;
	int empId;
	protected String empName, empContact, empGender, empOrganization, empEmail;

	/**
	 * @return vehicleName
	 */
	public String getVehicleName()
	{
		return vehicleName;
	}

	/**
	 * @param vehicleName
	 * method to set vehicleName
	 */
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}

	/**
	 * @return vehicleNumber
	 */
	public String getVehicleNumber()
	{
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber
	 * method to set vehicleNumber
	 */
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return empId
	 */
	public int getEmpId()
	{
		return empId;
	}

	/**
	 * @return vehicleType
	 */
	public String getVehicleType()
	{
		return vehicleType;
	}

	/**
	 * @param vehicleType
	 * method to set vehicleType
	 */
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}

	/**
	 * @return passPriceDetail
	 */
	public String getPassPriceDetail()
	{
		return passPriceDetail;
	}

	/**
	 * @param passPriceDetail
	 * method to set passPriceDetail
	 */
	public void setPassPriceDetail(String passPriceDetail)
	{
		this.passPriceDetail = passPriceDetail;
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