package question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author krishan 
 * TestLinkedQuickSort class is for testing LinkedQuickSort class
 *
 */
public class TestLinkedQuickSort
{
	/**
	 * positive test case 
	 */
	@Test
	public void positiveTestOfClass()
	{
		DsaLinkedList list = new DsaLinkedList();
		Employee e1 = new Employee("krishan1", 20010, 23);
		Employee e2 = new Employee("krishan2", 20009, 23);
		Employee e3 = new Employee("krishan3", 20008, 23);
		Employee e4 = new Employee("krishan4", 20007, 23);
		Employee e5 = new Employee("krishan5", 20006, 23);
		Employee e6 = new Employee("krishan6", 20005, 23);

		list.insert(list, e1);
		list.insert(list, e2);
		list.insert(list, e3);
		list.insert(list, e4);
		list.insert(list, e5);
		list.insert(list, e6);

		DsaLinkedList ExpectedList = new DsaLinkedList();
		Employee e7 = new Employee("krishan5", 20005, 23);
		Employee e8 = new Employee("krishan6", 20006, 24);
		Employee e9 = new Employee("krishan7", 20007, 25);
		Employee e10 = new Employee("krishan8", 20008, 26);
		Employee e11 = new Employee("krishan9", 20009, 27);
		Employee e12 = new Employee("krishan10", 20010, 28);
		ExpectedList.insert(ExpectedList, e7);
		ExpectedList.insert(ExpectedList, e8);
		ExpectedList.insert(ExpectedList, e9);
		ExpectedList.insert(ExpectedList, e10);
		ExpectedList.insert(ExpectedList, e11);
		ExpectedList.insert(ExpectedList, e12);
		ExpectedList.display(ExpectedList);

		LinkedQuickSort ob = new LinkedQuickSort();
		DsaLinkedList.Node n = list.head;
		while (n.next != null)
		{
			n = n.next;
		}

		ob.sort(list, list.head, n);
		assertEquals(ExpectedList.head.emp.salary, list.head.emp.salary);

	}

	/**
	 * positive test case 
	 */
	@Test
	public void positive2TestOfClass()
	{
		DsaLinkedList list = new DsaLinkedList();
		Employee e1 = new Employee("krishan1", 20009, 23);
		Employee e2 = new Employee("krishan2", 20006, 24);
		Employee e3 = new Employee("krishan3", 20008, 25);
		Employee e4 = new Employee("krishan4", 20007, 26);
		Employee e5 = new Employee("krishan5", 20010, 27);
		Employee e6 = new Employee("krishan6", 20005, 28);

		list.insert(list, e1);
		list.insert(list, e2);
		list.insert(list, e3);
		list.insert(list, e4);
		list.insert(list, e5);
		list.insert(list, e6);

		DsaLinkedList ExpectedList = new DsaLinkedList();
		Employee e7 = new Employee("krishan5", 20005, 23);
		Employee e8 = new Employee("krishan6", 20006, 24);
		Employee e9 = new Employee("krishan7", 20007, 25);
		Employee e10 = new Employee("krishan8", 20008, 26);
		Employee e11 = new Employee("krishan9", 20009, 27);
		Employee e12 = new Employee("krishan10", 20010, 28);
		ExpectedList.insert(ExpectedList, e7);
		ExpectedList.insert(ExpectedList, e8);
		ExpectedList.insert(ExpectedList, e9);
		ExpectedList.insert(ExpectedList, e10);
		ExpectedList.insert(ExpectedList, e11);
		ExpectedList.insert(ExpectedList, e12);
		ExpectedList.display(ExpectedList);

		LinkedQuickSort ob = new LinkedQuickSort();
		DsaLinkedList.Node n = list.head;
		while (n.next != null)
		{
			n = n.next;
		}

		ob.sort(list, list.head, n);
		assertEquals(ExpectedList.head.emp.salary, list.head.emp.salary);

	}

	/**
	 * negative test case 
	 */
	@Test
	public void negativeTestOfClass()
	{
		try
		{
			DsaLinkedList list = null;

			DsaLinkedList.Node n = list.head;
			while (n.next != null)
			{
				n = n.next;
			}
			LinkedQuickSort ob = new LinkedQuickSort();
			ob.sort(list, list.head, n);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), null);
		}

	}

	/**
	 * negative test case 
	 */
	@Test
	public void negative2TestOfClass()
	{
		try
		{
			DsaLinkedList list = null;
			Employee e = new Employee("krishan", 20005, 23);

			list.insert(list, e);
		}
		catch (Exception e)
		{
			assertEquals(null, e.getMessage());
		}

	}
}
