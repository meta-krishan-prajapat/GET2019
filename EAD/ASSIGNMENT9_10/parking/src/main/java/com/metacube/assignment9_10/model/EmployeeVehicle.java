package com.metacube.assignment9_10.model;

/**
 * @author krishan
 * EmployeeVehicle class keeps vehicle details of an Employee
 */
public class EmployeeVehicle
{
	String vehicleName, vehicleType, vehicleNumber, passPriceDetail;
	int empId;

	/**
	 * @return
	 */
	public int getEmpId()
	{
		return empId;
	}

	/**
	 * @param empId
	 *  method to set empId
	 */
	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	/**
	 * @return vehicleName
	 */
	public String getVehicleName()
	{
		return vehicleName;
	}

	/**
	 * @param vehicleName
	 *  method to set vehicleName
	 */
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
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
	 *  method to set vehicleType
	 */
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
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
	 *  method to set vehicleNumber
	 */
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber = vehicleNumber;
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
}
