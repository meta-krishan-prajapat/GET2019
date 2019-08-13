package question2;

/**
 * @author krishan
 * Employee class keeps the Employee information
 *
 */
public class Employee
{
	private int empId;
	private String name;
	private int salary;
	private int age;

	/**
	 * @param empId
	 * @param name
	 * @param salary
	 * @param age
	 * Constructor initialises instances values 
	 */
	public Employee(int empId, String name, int salary, int age)
	{
		try
		{
			if (name == null)
			{
				throw new Exception("name can't be null");
			}
			this.empId = empId;
			this.name = name;
			this.salary = salary;
			this.age = age;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// get employeeId
	public int getEmpId()
	{
		return empId;
	}

	/**
	 * @param empId
	 * set employeeId
	 */
	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	/**
	 * @return name of the employee
	 */
	public String getName()
	{
		try
		{
			if (name == null)
			{
				throw new Exception("name cant be null");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return name;
	}

	/**
	 * @param name
	 * set employee name
	 */
	public void setName(String name)
	{
		try
		{
			if (name == null)
			{
				throw new Exception("data cant be null");
			}

			this.name = name;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return salary of the employee
	 */
	public int getSalary()
	{
		return salary;
	}

	/**
	 * @param salary
	 * set salary of the employee
	 */
	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	/**
	 * @return age of the employee
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age
	 * set age of the employee
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * display employee info
	 */
	public void displayEmployeeInfo()
	{
		System.out.println("Employee Id: " + empId);
		System.out.println("Employee Name: " + name);
		System.out.println("Employee Salary: " + salary);
		System.out.println("Employee Age: " + age);
	}

}