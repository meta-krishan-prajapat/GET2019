package question2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author krishan
 * test class for priority queue
 *
 */
public class TestPriorityQueue {
	PriorityQueue priorityQueue;


	/**
	 * test enQueue Should Return True When Queue Not Full
	 */
	@Test
	public void testenQueueShouldReturnTrueWhenQueueNotFull() {
		priorityQueue = new PriorityQueue(10);
		priorityQueue.enQueue("node1", 2);
		boolean isenQueue = priorityQueue.enQueue("node2", 4);
		assertEquals(true, isenQueue);
	}

	/**
	 * test cases for enQueue()
	 */
	@Test
	public void testIsEmptyShouldReturnTrueWhenQueueEmpty() {
		priorityQueue = new PriorityQueue(10);
		boolean isEmpty = priorityQueue.isEmpty();
		assertEquals(true, isEmpty);
	}

	/**
	 * Test Is Empty Should Return False When Queue Not Empty
	 */
	@Test
	public void testIsEmptyShouldReturnFalseWhenQueueNotEmpty() {
		priorityQueue = new PriorityQueue(10);
		priorityQueue.enQueue("node1", 2);
		boolean isEmpty = priorityQueue.isEmpty();
		assertEquals(false, isEmpty);
	}

	
	/**
	 * test Is Full Should Return True When Queue Full
	 */
	@Test
	public void testIsFullShouldReturnTrueWhenQueueFull() {
		priorityQueue = new PriorityQueue(2);
		priorityQueue.enQueue("node1", 2);
		priorityQueue.enQueue("node2", 1);
		boolean isFull = priorityQueue.isFull();
		assertEquals(false, isFull);
	}

	/**
	 * test Is Full Should Return False When Queue Not Full
	 */
	@Test
	public void testIsFullShouldReturnFalseWhenQueueNotFull() {
		priorityQueue = new PriorityQueue(10);
		priorityQueue.enQueue("node1", 2);
		boolean isFull = priorityQueue.isFull();
		assertEquals(false, isFull);
	}

}