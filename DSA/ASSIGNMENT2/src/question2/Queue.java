package question2;


	/**
	 * @author krishan 
	 * interface Queue defines the methods of Queue that are to be implemented.
	 * @param <T> queue store generic data type 
	 */
	public interface Queue<T> {

	    /**
	     * @param object is the object to be inserted
	     * @return true if successfully inserted the element
	     */
	    public boolean insert(T object);

	    /**
	     * @return the removed element
	     */
	    public T remove();

	    /**
	     * @return true if the queue is empty else return false
	     * @throws Exception
	     */
	    public boolean isEmpty() throws Exception;

	    /**
	     * @return true if the queue is full else return false
	     */
	    public boolean isFull();

	    /**
	     * @return the top most element of the queue
	     */
	    public T top();
	}


