package question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author krishan 
 * TestCircularQueue is a test class for circular queue
 */
public class TestCircularQueue {

	CircularQueue<Integer> queue = new CircularQueue<Integer>(5);

	/**
	 * testInsertPositive method tests the positive test cases of insertion
	 */
	@Test
	public void testInsertPositive() {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		int result = (int) queue.top();
		assertEquals(result, 4);
	}

	/**
	 * testRemovePositive method tests the positive test cases of removal after
	 * insertion
	 */
	@Test
	public void testRemovePositive() {
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		int result = (int) queue.remove();
		assertEquals(result, 9);
	}

	/**
	 * testIsEmptyNegative method tests the isEmpty method with negative test case
	 */
	@Test
	public void testIsEmptyNegative() throws Exception {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		boolean result = queue.isEmpty();
		assertEquals(result, false);
	}

	/**
	 * testIsEmptyPositive method tests the isEmpty method with positive test case
	 */
	@Test
	public void testIsEmptyPositive() throws Exception {
		boolean result = queue.isEmpty();
		assertEquals(result, true);
	}

	/**
	 * testIsFullPositive method tests the isFull method with positive test case
	 */
	@Test
	public void testIsFullPositive() {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(1);
		boolean result = queue.isFull();
		assertEquals(result, true);
	}

	/**
	 * testIsFullNegative method tests the isFull method with negative test case
	 */
	@Test
	public void testIsFullNegative() {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		boolean result = queue.isFull();
		assertEquals(result, false);
	}

	/**
	 * testCircularQueue method tests the queue on insert,remove and top method
	 */
	@Test
	public void testCircularQueue() {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(2);
		int frontVal = (int) queue.remove();
		queue.insert(5);
		int result = (int) queue.top();
		assertEquals(result, 9);
	}

	/**
	 * testCircularQueueFull checks the isFull method after insertion and removal
	 */
	@Test
	public void testCircularQueueFull() {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(2);
		queue.insert(2);
		int frontVal = (int) queue.remove();
		queue.insert(5);
		boolean result = queue.isFull();
		assertEquals(result, true);
	}

}
