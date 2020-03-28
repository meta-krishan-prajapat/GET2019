package question2;

/**
 * @author krishan
 * class LinkedListEmployee implements insertion sort on linked list of employee 
 */
public class LinkedListEmployee
{
	public Node head;
	Node sorted;
	int data;

	public LinkedListEmployee()
	{
		head = null;

	}

	/**
	 * @param list is the Linked List 
	 * @param data is data to insert in the linked list
	 * @return a linked list with inserted data
	 * method insert will insert the data as object to the linked list 
	 */
	public LinkedListEmployee insert(LinkedListEmployee list, Employee data)
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
	 * @param list
	 * @return sorted list of employee sorted by insertion sort 
	 */
	public LinkedListEmployee insertionSort(LinkedListEmployee list)
	{
		try
		{
			if (list == null)
			{
				throw new Exception("list cant be null");
			}

			// Initialise sorted linked list
			sorted = null;
			Node current = list.head;
			// Traverse the given linked list and insert every
			// node to sorted
			while (current != null)
			{
				// Store next for next iteration
				Node next = current.next;
				// insert current in sorted linked list
				sortedInsert(current);
				// Update current
				current = next;
			}
			// Update head_ref to point to sorted linked list
			head = sorted;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param newNode
	 * method to insert a new node in a list.
	 */
	public void sortedInsert(Node newNode)
	{
		try
		{
			if (newNode == null)
			{
				throw new Exception("newNode can't be null");
			}
			Node current = sorted;
			if (sorted == null || sorted.getData().getSalary() < newNode.getData().getSalary())
			{
				newNode.next = sorted;
				sorted = newNode;
			}
			else if (current.getData().getSalary() == newNode.getData().getSalary())
			{
				if (current.getData().getAge() < newNode.getData().getAge())
				{

					newNode.next = current.next;
					current.next = newNode;
				}
				else
				{
					newNode.next = sorted;
					sorted = newNode;
				}

			}
			else
			{
				// Node current = sorted;
				/* Locate the node before the point of insertion */

				while (current.next != null && current.getData().getSalary() > newNode.getData().getSalary())
				{

					current = current.next;
				}

				newNode.next = current.next;
				current.next = newNode;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param list
	 * method to display the @param list
	 */
	public void display(LinkedListEmployee list)
	{
		try
		{
			if (list == null)
			{
				throw new Exception("can't display a null list");
			}
			// Node current will point to head
			Node current = list.head;

			if (list.head == null)
			{
				System.out.println("List is empty");
				return;
			}
			System.out.println("Nodes of singly linked list: ");
			while (current.next != null)
			{
				// Prints each node by incrementing pointer
				current.getData().displayEmployeeInfo();
				current = current.next;
			}
			current.getData().displayEmployeeInfo();
			System.out.println();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}