package question3;

/**
 * implementation of circular queue
 * @author krishan
 *
 * @param <T> queue store generic data type 
 */
public class Queue<T> implements QueueInterface<T> 
{
	private T[] circularQueue;
	private int head;
	private int tail;
	private int currentQueueSize;

	/**
	 * queue constructor create circular queue
	 * @param size
	 */
	Queue (int size) 
	{
		circularQueue = (T[]) new Object[size];
		head = -1;
		tail = -1;
		currentQueueSize = 0;
	}

	/**
	 * add element into queue
	 */
	@Override
	public void enqueue(T element) throws AssertionError 
	{
		if (isFull()) 
		{
			throw new AssertionError("Queue is full!!");
		}
		tail = (tail + 1) % circularQueue.length;
		circularQueue[tail] = element;
		currentQueueSize++;
		if (head == -1)
		{
			head++;
		}
	}
    
	/**
	 * remove element into queue
	 */
	@Override
	public T dequeue() throws AssertionError
	{
		if(isEmpty())
		{
			throw new AssertionError("Queue is empty!!");
		}
		T dequeueElement = circularQueue[head];
		circularQueue[head] = null;
		head = (head+1) % circularQueue.length;
		currentQueueSize--;
		return dequeueElement;
	}

	/**
	 * checks if queue is empty
	 */
	@Override
	public boolean isEmpty()
	{
		if (currentQueueSize == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * checks if queue is full
	 */
	@Override
	public boolean isFull() 
	{
         if(currentQueueSize == circularQueue.length)
         {
        	 return true;
         }
         return false;
	}
	
	/**
	 * return queue
	 * @return queue
	 */
	public T[] getCircularArray()
	{
		return circularQueue;
	}
}