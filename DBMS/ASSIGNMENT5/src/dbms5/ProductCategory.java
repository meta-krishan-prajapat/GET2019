package dbms5;

/**
 * @author krishan
 * Represents a product category by its id.
 * It also saves its name, number of children it has
 * and the parent category of this category(NULL if top category).
 * POJO class for product category
 */
public class ProductCategory
{
	private Integer parentId;
	private String name;
	private int childCount;

	/**
	 * Initialises the category with following properties
	 * @param name Name of category.
	 * @param childCount Number of sub categories under this category.
	 * @param parentId Parent category of this category.
	 */
	public ProductCategory(Integer parentId, String name, int childCount)
	{
		try
		{
			if (name == null)
			{
				throw new NullPointerException("name cant be null");
			}
			this.name = name;
			this.childCount = childCount;
			this.parentId = parentId;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the number of categories under a sub category
	 * @param categoryId     Id under which categories are to be found
	 * @return               number of categories under a sub category
	 * @throws SQLException  If connection to database fails
	 */

	// GETTERS AND SETTERS

	/** 
	 * @return the name 
	 * 
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *  @param name the name to set 
	 *  
	 */
	public void setName(String name)
	{
		try
		{
			if (name == null)
			{
				throw new NullPointerException("name cant be null");
			}
			this.name = name;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** @return the childCount */
	public int getChildCount()
	{
		return childCount;
	}

	/** @param childCount the childCount to set */
	public void setChildCount(int childCount)
	{
		this.childCount = childCount;
	}

	/** @return the parentId */
	public Integer getParentId()
	{
		return parentId;
	}

	/** @param parentId the parentId to set */
	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
}
