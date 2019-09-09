
package model;

/**
 * @author krishan
 * Book class is a POJO class
 */
public class Book {
	private int id;
	private String title;
	private String writer; 
	private String publisher;
	private int published_year;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * method sets the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 * method sets the title
	 */
	public void setTitle(String title) {
		try
		{
			if(title!=null)
			{
				this.title = title;
			}
			else 
			{
				throw new NullPointerException("null pointer exception");
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @return writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @param writer
	 * method sets the writer
	 */
	public void setWriter(String writer) {
		try
		{
			if(title!=null)
			{
				this.writer = writer;
			}
			else 
			{
				throw new NullPointerException("null pointer exception");
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 * method sets the publisher
	 */
	public void setPublisher(String publisher) {
		try
		{
			if(title!=null)
			{
				this.publisher = publisher;			
				}
			else 
			{
				throw new NullPointerException("null pointer exception");
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @return published_year
	 */
	public int getPublished_year() {
		return published_year;
	}

	/**
	 * @param published_year
	 * method sets the published_year
	 */
	public void setPublished_year(int published_year) {
		try
		{
			if(title!=null)
			{this.published_year = published_year;	
				}
			else 
			{
				throw new NullPointerException("null pointer exception");
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @param id
	 * @param title
	 * @param writer
	 * @param publisher
	 * @param published_year
	 * Constructor of the class
	 */
	public Book(int id, String title, String writer, String publisher,
			int published_year) {
	
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.published_year = published_year;
	}
	
	
	
	/**
	 * @param id
	 * @param title
	 * @param published_year
	 * Constructor of the class
	 */
	public Book(int id, String title, int published_year) {
	
		this.id = id;
		this.title = title;
		this.published_year = published_year;
	}

	/**
	 * @param title
	 * @param writer
	 * @param publisher
	 * @param published_year
	 * Constructor of the class
	 */
	public Book(String title, String writer, String publisher,
			int published_year) {
		
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.published_year = published_year;
	}
}