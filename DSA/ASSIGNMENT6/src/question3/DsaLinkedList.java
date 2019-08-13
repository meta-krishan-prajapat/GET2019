package question3;

/**
 * @author krishan
 * DsaLinkedList class will create Linked List with data as object of Employee type.
 * DsaLinkedList has methods to rotate LinkedList clockwise as well as method to display and insert data to linked list.
 */
public class DsaLinkedList
{
	Node head;

	/**
	 * @author krishan
	 * Node class is a nested class that will create a node for a linked list.
	 * Node class has constructors to add data as well as another node to a Node.  
	 *
	 */
	static class Node
	{
		Node next;
		Employee emp;

		/**
		 * @param data2 data is an object that is to be added to the linked list
		 */
		public Node(Employee emp)
		{
			if (emp == null)
			{
				throw new NullPointerException("list can't be null");
			}
			this.emp = emp;
			this.next = null;
		}
	}

	/**
	 * @param list is the Linked List 
	 * @param data is data to insert in the linked list
	 * @return a linked list with inserted data
	 * method insert will insert the data as object to the linked list 
	 */
	public DsaLinkedList insert(DsaLinkedList list, Employee data)
	{
		try
		{
			if (list == null)
			{
				throw (new Exception("list cant be null"));
			}
			if (data == null)
			{
				throw (new Exception("employee cant be null"));
			}
			Node newNode = new Node(data);
			if (list.head == null)
			{
				list.head = newNode;
			}
			else
			{
				Node last = head;
				while (last.next != null)
				{
					last = last.next;
				}
				last.next = newNode;
			}
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		return list;
	}

	/**
	 * @param list is the Linked list to be displayed on screen
	 * display method will display the Linked list
	 */
	public void display(DsaLinkedList list)
	{
		try
		{
			if (list == null)
			{
				throw (new Exception("list cant be empty"));
			}
			Node node;
			node = list.head;
			while (node.next != null)
			{
				System.out.print(" " + node.emp.salary + " ");
				node = node.next;
			}
			System.out.print(" " + node.emp.salary + " ");
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}

}
