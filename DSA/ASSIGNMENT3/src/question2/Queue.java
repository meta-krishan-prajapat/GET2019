package question2;

public interface Queue {
	boolean enQueue(Object element, int priority);

	Object deQueue() throws Exception;

	boolean isEmpty();

	boolean isFull();

	int getSize();

	void display();

}
