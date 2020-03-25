package question2;

/**
 * @author krishan
 * class priorityQueue will set the priority of element using heap,enqueue an dequeue elements 
 */
public class PriorityQueue implements Queue {
	public Element[] queue;
	private int noOfElements = 0;
	private int Size;

	/**
	 * @param size
	 * Constructor will initialise priority queue
	 */
	public PriorityQueue(int size) {
		this.Size = size + 1;
		this.queue = new Element[Size];
	}

	/**
	 * enQueue method will enqueue element using heap
	 */
	public boolean enQueue(Object element, int priority) {
		try
		{
		if (!isFull()) {
			Element object = new Element(element, priority);
			queue[++noOfElements] = object;
			int position = noOfElements;
			while ((position != 1) && object.priority > queue[position / 2].priority) {
				queue[position] = queue[position / 2];
				position = position / 2;
			}
			queue[position] = object;
		} else {
			throw new Exception("Queue Array is full");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * deQueue method will dequeue element using heap
	 */
	public Object deQueue() throws Exception {
		
		Element store=null;
		try
		{
		if (isEmpty()) {
			throw (new Exception("queue is empty"));
		}
		store = queue[1];
		queue[1] = queue[noOfElements];
		int count = noOfElements - 1;

		while (count != 0) {
			int pos = count;
			while ((pos != 1) && queue[pos].priority > queue[pos / 2].priority) {
				Element temp = queue[pos];
				queue[pos] = queue[pos / 2];
				queue[pos / 2] = temp;
				pos = pos / 2;

			}

			count--;
		}
		noOfElements--;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return store.getElement();
	}

	/**
	 *
	 */
	@Override
	public boolean isEmpty() {
		if (noOfElements == 0)
			return true;
		return false;
	}

	/**
	 *
	 */
	@Override
	public boolean isFull() {
		if (noOfElements == Size)
			return true;
		return false;
	}

	/**
	 *
	 */
	@Override
	public int getSize() {
		return noOfElements;
	}

	/**
	 *
	 */
	@Override
	public void display() {
		for (int i = 1; i <= noOfElements; i++) {
			System.out.println("Element is :" + queue[i].getElement());

		}

	}

}
