package POJO;

/**
 * @author krishan
 *  Friends POJO class to keep the object of both vehicle and
 *         employee
 *
 */
public class Friends
{
	public Employee e;
	public EmployeeVehicle v;

	/**
	 * 
	 */
	public Friends()
	{
		e = new Employee();
		v = new EmployeeVehicle();
	}

	/**
	 * @return employee object
	 */
	public Employee getE()
	{
		return e;
	}

	/**
	 * @param e method to set the employee object
	 */
	public void setE(Employee e)
	{
		this.e = e;
	}

	/**
	 * @return EmployeeVehicle object
	 */
	public EmployeeVehicle getV()
	{
		return v;
	}

	/**
	 * @param v method to set the vehicle object
	 */
	public void setV(EmployeeVehicle v)
	{
		this.v = v;
	}

}
