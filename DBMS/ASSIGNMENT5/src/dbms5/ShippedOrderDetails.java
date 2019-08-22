package dbms5;

import java.sql.Date;

/**
 * @author krishan
 * POJO class for shipped order details
 */
public class ShippedOrderDetails
{
	private int orderId;
	private Date orderDate;
	private Float orderTotal;

	public ShippedOrderDetails(int orderId, Date orderDate, Float orderTotal)
	{
		try
		{
			if (orderDate == null)
			{
				throw new NullPointerException("date can't be null");
			}
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.orderTotal = orderTotal;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	protected Date getOrderDate()
	{
		return orderDate;
	}

	protected int getOrderId()
	{
		return orderId;
	}

	protected Float getOrderTotal()
	{
		return orderTotal;
	}

}
