package dbms5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;

/**
 * @author krishan
 * QueryExecuter class executes all the queries
 *
 */
public class QueryExecuter
{
	Connection con = null;
	List<ShippedOrderDetails> list = null;

	/**
	 * constructor to get the connection from DBConnection class
	 */
	public QueryExecuter()
	{
		try
		{
			con = DBConnection.getDBConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * method to get the result of order details
	 */
	public void OrderDetailsResult()
	{
		try
		{
			list = new ArrayList<ShippedOrderDetails>();
			String sqlQuery = "select o.orderId,o.order_placing_date, p.price*op.order_quantity total_order from orders o join order_product op on o.orderId=op.orderId join product p on op.productId=p.id where op.orderStatus='shipped' order by o.order_placing_date;";

			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new ShippedOrderDetails(rs.getInt("orderId"), rs.getDate("order_placing_date"), rs.getFloat("total_order")));

			}
			for (ShippedOrderDetails sod : list)
			{
				System.out.println(sod.getOrderId() + "  " + sod.getOrderDate() + " " + sod.getOrderTotal());
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param ids
	 * @param names
	 * @param prices
	 * @param quantities
	 * @param urls
	 * @param dates
	 * method to insert images to product table using batch
	 */
	public void insertImages(int[] ids, String[] names, float[] prices, int[] quantities, String[] urls, Date[] dates)
	{
		PreparedStatement ps = null;
		try
		{
			if (ids == null || names == null || prices == null || quantities == null || urls == null || dates == null)
			{
				throw new NullPointerException("Inputs can't be null");
			}
			con.setAutoCommit(false);
			String sqlQuery = "INSERT INTO product(id,name,price,quantity,product_image,added_on_date) VALUES(?,?,?,?,?,?)";
			int count = 0;

			ps = con.prepareStatement(sqlQuery);
			while (count < urls.length)
			{

				ps.setInt(1, ids[count]);
				ps.setString(2, names[count]);
				ps.setFloat(3, prices[count]);
				ps.setInt(4, quantities[count]);
				ps.setString(5, urls[count]);
				ps.setDate(6, dates[count]);
				ps.addBatch();
				count++;
			}
			ps.executeBatch();
			con.commit();
			ps.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return the no. of deleted rows
	 * method to delete particular products which are not ordered from last one year
	 */
	public int deleteProducts()
	{
		try
		{
			String sqlQuery = "update product \r\n" + "set product.is_active=false\r\n"
					+ "where product.id NOT IN (select distinct order_product.productId from order_product join orders on orders.orderId = order_product.orderId where TIMESTAMPDIFF(YEAR, orders.order_placing_date, CURDATE())<1); ";
			PreparedStatement ps = null;

			ps = con.prepareStatement(sqlQuery);
			int rows = ps.executeUpdate();

			return rows;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * @param categoryId is the parent id
	 * @return the no. of child of a particular parent
	 * @throws SQLException
	 * method to get the no. of children of parent using parent id
	 */
	public int getChildCount(int categoryId)
	{

		try
		{

			String sqlQuery = "select count(category.name) as total from category where category.root=?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			System.out.println("nnnnnnnnnnnn");
			int childs = 0;
			while (rs.next())
			{
				childs = rs.getInt("total");
			}

			return childs;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	/**
	
	 * @return List of top product categories.
	 * @throws SQLException  If connection to data fails
	* Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.
	 */
	public List<ProductCategory> getChildCount()
	{
		List<ProductCategory> productCategoryList = new LinkedList<>();
		try
		{
			PreparedStatement preparedStmt = con
					.prepareStatement("select c.id,c.name from category c where c.root is null order by c.name");
			ResultSet parentIdSet = preparedStmt.executeQuery();

			// Calculating child count and adding all top categories to list
			while (parentIdSet.next())
			{
				productCategoryList.add(new ProductCategory(parentIdSet.getInt("id"), parentIdSet.getString("name"),
						getChildCount(parentIdSet.getInt("id"))));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return productCategoryList;
	}

}
