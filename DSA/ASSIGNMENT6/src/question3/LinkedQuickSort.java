package question3;

/**
 * @author krishan
 * LinkedQuickSort class sort a LinkedList of Employee using salary
 *
 */
public class LinkedQuickSort
{
	/**
	 * @param list
	 * @param low
	 * @param high
	 * @return a partitioned list according to the pivot element
	 */
	public DsaLinkedList.Node partition(DsaLinkedList list, DsaLinkedList.Node low, DsaLinkedList.Node high)
	{
		DsaLinkedList.Node i = null;
		try
		{
			int pivot = high.emp.salary;
			i = low;
			DsaLinkedList.Node j = low;

			while (j != high)
			{
				if (j.emp.salary <= pivot)
				{
					// swap i and j
					int temp = j.emp.salary;
					j.emp.salary = i.emp.salary;
					i.emp.salary = temp;
					i = i.next;

				}
				j = j.next;
			}
			// swap j and i
			int temp = j.emp.salary;
			j.emp.salary = i.emp.salary;
			i.emp.salary = temp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * @param list
	 * @param low
	 * @param high
	 * sort is a recursive method for using divide and conquer algorithm
	 */
	public void sort(DsaLinkedList list, DsaLinkedList.Node low, DsaLinkedList.Node high)
	{
		try
		{
			if (list == null)
			{
				throw new NullPointerException("list can't be null");
			}
			if (low != high.next)
			{

				DsaLinkedList.Node pi = partition(list, low, high);
				if (pi.next != high)
				{
					sort(list, pi.next, high);
				}

				DsaLinkedList.Node n = low;

				while (n.next != pi && n.next != null)
				{

					n = n.next;
				}

				if (n.next != null)
				{
					sort(list, low, n);
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
