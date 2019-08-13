package question2;

/**
 * @author krishan
 * class Node defines the node
 *
 */
public class Node
{
	public Employee data;
	public Node next;

	/**
	 * @param data
	 * constructor
	 */
	public Node(Employee data)
	{
		try
		{
			if (data == null)
			{
				throw new Exception("employee data can't be null");
			}
			this.data = data;
			this.next = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return data of employee
	 */
	public Employee getData()
	{
		try
		{
			if (data == null)
			{
				throw new Exception("data cant be null");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * @param data
	 * set employee data
	 */
	public void setData(Employee data)
	{
		try
		{
			if (data == null)
			{
				throw new Exception("data cant be null");
			}

			this.data = data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
