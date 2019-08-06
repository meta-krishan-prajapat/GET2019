package question2;

/**
 * @author krishan
 * class to define Element that is going to be added or removed from the priority queue
 */
public class Element {
	Object element=null;
	int priority;

	/**
	 * @param ele
	 * @param prior
	 * constructor to set instance values
	 */
	public Element(Object ele, int prior) {
		this.element = ele;
		this.priority = prior;
	}

	/**
	 * @return the element
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * @return the priority of particular element
	 */
	public int getPriority() {
		return priority;
	}

}
