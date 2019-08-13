package question1;

/**
 * @author krishan
 * Node class for node property 
 * String key, value 
 *
 */
public class Node
{

	private String key;
	private String value;
	Node left, right, parent;

	/**
	 * @param key
	 * @param value
	 * constructor
	 */
	public Node(String key, String value)
	{
		try
		{
			if (key == null || value == null)
			{
				throw new Exception("null input data");
			}
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 * getter method for key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 * setter method for key
	 */
	public void setKey(String key)
	{
		try
		{
			if (key == null)
			{
				throw new Exception("null input data");
			}
			this.key = key;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * getter method for value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 * setter method for value
	 */
	public void setValue(String value)
	{
		try
		{
			if (value == null)
			{
				throw new Exception("null input data");
			}

			this.value = value;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 * getter method for left child
	 */
	public Node getLeft()
	{
		return left;
	}

	/**
	 * @param left
	 * setter method for left child
	 */
	public void setLeft(Node left)
	{
		try
		{
			if (left == null)
			{
				throw new Exception("null input data");
			}

			this.left = left;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 * getter method right child
	 */
	public Node getRight()
	{
		return right;
	}

	/**
	 * @param right
	 * setter method for right
	 */
	public void setRight(Node right)
	{
		try
		{
			if (right == null)
			{
				throw new Exception("null input data");
			}

			this.right = right;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 * getter method for parent
	 */
	public Node getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 * setter method for parent
	 */
	public void setParent(Node parent)
	{
		try
		{
			if (parent == null)
			{
				throw new Exception("null input data");
			}

			this.parent = parent;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}