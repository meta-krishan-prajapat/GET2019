
package dao;

/**
 * @author krishan
 * Query class to return different types of queries
 *
 */
public class Query
{

	/**
	 *
	 * @return query
	 *  Inserts book in table
	 */
	public static String insert()
	{
		String query = "insert into book(title,writer,publisher,published_year) values(?,?,?,?)";
		return query;
	}

	/**
	 * 
	 * @return query
	 * Gets All books from table
	 */
	public static String getAll()
	{
		String query = "select * from book ";
		return query;
	}

	/**
	 *
	 * @return query
	 *  Gets All books from table by title
	 */
	public static String getByTitle(String title)
	{
		String query = "select * from book where title = '" + title + "'";
		return query;
	}

	/**
	 * 
	 * @return query
	 * Updates Book
	 */
	public static String update()
	{
		String query = "update book set title =? , published_year=? where id=?";
		return query;
	}

	/**
	 * 
	 * @return query
	 * Deletes book from table by id
	 */
	public static String deleteById(int id)
	{
		String query = "delete from book where id =" + id;
		return query;
	}

	/**
	 * 
	 * @return query
	 * Deletes All books from table
	 */
	public static String deleteAll()
	{
		String query = "delete from book";
		return query;
	}
}