package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author krishan
 *
 */
public class TestLinkedListEmployee
{

	/**
	 * positive test case
	 */
	@Test
	public void test()
	{
		int[] expected = new int[] { 800, 600, 500 };
		int[] result = new int[3];

		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "krishan", 500, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "krishan2", 600, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "krishan3", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n = new Node(e);
		n = list.head;
		int i = 0;
		while (n.next != null)
		{
			result[i] = n.getData().getSalary();
			i++;
			n = n.next;

		}
		result[i] = n.getData().getSalary();
		assertArrayEquals(expected, result);
	}

	/**
	 * positive test case
	 */
	@Test
	public void test1()
	{
		int[] expected = new int[] { 800, 500, 500 };
		int[] result = new int[3];

		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "krishan", 500, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "krishan2", 500, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "krishan3", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n = new Node(e);
		n = list.head;
		int i = 0;
		while (n.next != null)
		{
			result[i] = n.getData().getSalary();
			i++;
			n = n.next;

		}
		result[i] = n.getData().getSalary();
		assertArrayEquals(expected, result);
	}

	/**
	 * positive test case
	 */
	@Test
	public void test3()
	{
		int[] expected = new int[] { 800, 800, 800 };
		int[] result = new int[3];

		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "krishan", 800, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "krishan2", 800, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "krishan3", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n = new Node(e);
		n = list.head;
		int i = 0;
		while (n.next != null)
		{
			result[i] = n.getData().getSalary();
			i++;
			n = n.next;

		}
		result[i] = n.getData().getSalary();
		assertArrayEquals(expected, result);
	}

}