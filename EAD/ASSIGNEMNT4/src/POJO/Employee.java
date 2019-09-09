package POJO;

/**
 * @author krishan
 * Employee POJO class for employee details.
 */
public class Employee
{
	protected String  empName, empEmail, empContact, empGender, empPassword, empOrganization;
	private int empId;

	/**
	 * @return the id of employee
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
	 * @return the Name of employee
	 */
	public String getEmpName()
	{
		return empName;
	}

	/**
	 * @param empName
	 * method sets the Name of employee.
	 */
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	/**
	 * @return the Email of employee
	 */
	public String getEmpEmail()
	{
		return empEmail;
	}

	/**
	 * @param empEmail
	 * method  sets the Email of employee.
	 */
	public void setEmpEmail(String empEmail)
	{
		this.empEmail = empEmail;
	}

	/**
	 * @return the Password of employee
	 */
	public String getEmpPassword()
	{
		return empPassword;
	}

	/**
	 * @param empPassword
	 * method sets the Password of employee.
	 */
	public void setEmpPassword(String empPassword)
	{
		this.empPassword = empPassword;
	}

	/**
	 * @return the Contact of employee
	 */
	public String getEmpContact()
	{
		return empContact;
	}

	/**
	 * @param empContact
	 * method  sets the Contact of employee.
	 */
	public void setEmpContact(String empContact)
	{
		this.empContact = empContact;
	}

	/**
	 * @return the Gender of employee
	 */
	public String getEmpGender()
	{
		return empGender;
	}

	/**
	 * @param empGender
	 * method  sets the Gender of employee.
	 */
	public void setEmpGender(String empGender)
	{
		this.empGender = empGender;
	}

	/**
	 * @return the Organization of employee
	 */
	public String getEmpOrganization()
	{
		return empOrganization;
	}

	/**
	 * @param empOrganization
	 * method  sets the Organization of employee.
	 */
	public void setEmpOrganization(String empOrganization)
	{
		this.empOrganization = empOrganization;
	}

}
