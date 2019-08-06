package question3;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketTest {

	/**
	 * @throws Exception
	 * return the expected result
	 */
	@Test
	public void testfindOrderOfBowlres() throws Exception {
		
		int result[]=new int[]{0,3,3,2};
		
		int expected[]=new int[4];
		PriorityBowler pb=new PriorityBowler(3, 10);
		pb.enQueue("a", 6);
		pb.enQueue("b", 4);
		pb.enQueue("c", 8);
		pb.deQueue();
	
		for(int i=1;i<pb.queue.length;i++)
		{
			expected[i]=pb.queue[i].getPriority();
		}
		assertArrayEquals(result,expected);

	}



	/**
	 * @throws Exception
	 * return the expected result
	 */
	@Test
	public void testfindOrderOfBolresNegative() throws Exception {
		
		int result[]=new int[]{0,3,2,2};
		
		int expected[]=new int[4];
		PriorityBowler pb=new PriorityBowler(3, 5);
		pb.enQueue("a", 5);
		pb.enQueue("b", 4);
		pb.enQueue("c", 3);
		pb.deQueue();
		for(int i=1;i<pb.queue.length;i++)
		{
			expected[i]=pb.queue[i].getPriority();
		}
		assertArrayEquals(result,expected);

	}
}
