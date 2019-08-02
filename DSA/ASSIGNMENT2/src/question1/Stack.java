package question1;


/**
 * @author krishan
 * stack interface defines the methods of stack
 *
 */
public interface Stack {
	/**
	 * @return the popped element from stack
	 * pop will remove element from the top of the stack
	 */
	public String pop();
	/**
	 * @param c is the element to be pushed into the stack
	 * @return true if successfully inserted
	 */
	public boolean push(String c);
	/**
	 * @param c1 is the operator 
	 * @return return the precedence of @param c1
	 */
	public  int Prec(String c1);
	/**
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();
	/**
	 * @return the top most element of the stack
	 */
	public String peek(); 

}
