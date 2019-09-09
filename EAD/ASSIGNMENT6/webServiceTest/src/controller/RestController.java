
package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utility.Helper;
import model.Book;

/**
 * @author krishan RestController class works as a controller for rest API
 *
 */
@Path("/books")
public class RestController
{

	/**
	 * 
	 * @param book to be added
	 * @return message
	 *  Adds Book
	 */
	@POST
	@Path("/addBooks")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addBook(Book book)
	{
		if (Helper.addBook(book) != 0)
		{
			return "Sucessfully Added!";
		} else
		{
			return "Book Cannot be added!";
		}
	}

	/**
	 * 
	 * @return list of books as json
	 *  Gets All Books
	 */
	@GET
	@Path("/getBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks()
	{
		List<Book> books = Helper.getAllBook();
		return books;
	}

	/**
	 * 
	 * @param title of book
	 * @return list of books
	 *  Gets Book by title
	 */
	@GET
	@Path("/getBooks/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooksByTitle(@PathParam("title") String title)
	{
		List<Book> books = Helper.getBookByTitle(title);
		return books;
	}

	/**
	 * 
	 * @param book to be updated
	 * @return message
	 *  Updates Book
	 */
	@PUT
	@Path("/updateBook")
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBook(Book book)
	{
		if (Helper.updateBook(book) != 0)
		{
			return "Sucessfully Updated!";
		} else
		{
			return "Book Cannot be updated!";
		}
	}

	/**
	 *
	 * @return message 
	 * Deletes All Books
	 */
	@DELETE
	@Path("/deleteBooks")
	@Produces("text/plain")
	public String deleteBooks()
	{
		if (Helper.deleteAllBook() != 0)
		{
			return "Sucessfully Deleted!";
		} else
		{
			return "Books Cannot be Deleted!";
		}
	}

	/**
	 *
	 * @param id of book
	 * @return message
	 *  Deletes Book by Id
	 */
	@DELETE
	@Path("/deleteBooks/{id}")
	@Produces("text/plain")
	public String deleteBookById(@PathParam("id") int id)
	{
		if (Helper.deleteBookById(id) != 0)
		{
			return "Sucessfully Deleted!";
		} else
		{
			return "Book Cannot be Deleted!";
		}
	}
}