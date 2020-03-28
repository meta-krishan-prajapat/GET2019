package question1;

/**
 * @author krishan
 * value class for containing key and value in pair
 * String key,value
 */
public class Value
{

	private String key;
	private String value;

	/**
	 * @param key
	 * @param value
	 * constructor
	 */
	public Value(String key, String value)
	{
		try
		{
			if (key == null || value == null)
			{
				throw new Exception("null input data");
			}
			this.key = key;
			this.value = value;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * getKey
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 * setKey
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
	 * getValue
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 * setValue
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

}