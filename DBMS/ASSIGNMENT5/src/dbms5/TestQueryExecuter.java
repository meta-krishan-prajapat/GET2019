package dbms5;

import static org.junit.Assert.*;
import java.sql.Date;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author krishan
 * Test unit of QueryExecuter
 */
public class TestQueryExecuter
{

	private static QueryExecuter queryExecuter;

	@BeforeClass
	public static void setup() throws SQLException
	{
		queryExecuter = new QueryExecuter();
	}

	/**
	 * method to test shipped Orders
	 */
	@Test
	public void shippedOrderTest()
	{
		try
		{
			queryExecuter.OrderDetailsResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * method to test image Batch method
	 */
	@Test
	public void imageBatchTest()
	{
		try
		{
			Date dates[] =
			{ new Date(2018, 01, 01), new Date(2018, 01, 02), new Date(2018, 01, 01) };
			queryExecuter.insertImages(new int[]
			{ 80, 90, 92 }, new String[]
			{ "a", "b", "c" }, new float[]
			{ 5000, 6000, 7000 }, new int[]
			{ 4, 6, 7 }, new String[]
			{ "aa", "bb", "cc" }, dates);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * test the parent category
	 */
	@Test
	public void topCategoryTest()
	{
		try
		{
			int x = queryExecuter.getChildCount(1);
			assertEquals(2, x);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * test the parent category
	 */
	@Test
	public void topCategoryTest2()
	{
		try
		{
			int x = queryExecuter.getChildCount(2);
			assertEquals(0, x);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * test the parent category
	 */
	@Test
	public void topCategoryTest3()
	{
		try
		{
			int x = queryExecuter.getChildCount(3);
			assertEquals(0, x);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}

}