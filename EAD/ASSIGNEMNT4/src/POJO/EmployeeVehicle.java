package POJO;

/**
 * @author krishan
 * EmployeeVehicle class is a POJO class for vehicle details
 *
 */
public class EmployeeVehicle
{
	String vehicleName,vehicleType,vehicleNumber,passPriceDetail;
	int empId;

	/**
	 * @return gets id of employee
	 */
	public int getEmpId()
	{
		return empId;
	}

	/**
	 * @param empId
	 * method sets the id of employee.
	 */
	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	/**
	 * @return gets vehicleName of employee
	 */
	public String getVehicleName()
	{
		return vehicleName;
	}

	/**
	 * @param vehicleName
	 * method sets the vehicleName of employee.
	 */
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}

	/**
	 * @return gets vehicleType of employee
	 */
	public String getVehicleType()
	{
		return vehicleType;
	}

	/**
	 * @param vehicleType
	 * method sets the vehicleType of employee.
	 */
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}

	/**
	 * @return gets vehicleNumber of employee
	 */
	public String getVehicleNumber()
	{
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber
	 * method sets the vehicleNumber of employee.
	 */
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return gets passPriceDetail of employee
	 */
	public String getPassPriceDetail()
	{
		return passPriceDetail;
	}

	/**
	 * @param passPriceDetail
	 * method sets the PriceDetail of employee.
	 * 
	 */
	public void setPassPriceDetail(String passPriceDetail)
	{
		this.passPriceDetail = passPriceDetail;
	}
}
