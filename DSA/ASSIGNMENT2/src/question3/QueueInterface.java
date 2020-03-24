package question3;

/**
 * @author krishan
 *
 * @param <T> queue store generic data type 
 */
public interface QueueInterface <T>
{
    /**
     * @param element is the element to insert
     * method inserts element to the queue 
     */
    void enqueue(T element);
    /**
     * @return the removed element
     */
    T dequeue();
    /**
     * @return true if the queue is empty else return false
     */
    boolean isEmpty();
    /**
     * @return true if the queue is full else return false
     */
    boolean isFull();
}