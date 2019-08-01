package dsa1;

import java.util.Scanner;

/**
 * @author krishan
 * DsaLinkedList class will create Linked List with data as object type and integer type separately.
 * DsaLinkedList has methods to rotate LinkedList clockwise as well as method to display and insert data to linked list.
 */
public class DsaLinkedList {
	 Node head;

	/**
	 * @author krishan
	 * Node class is a nested class that will create a node for a linked list.
	 * Node class has constructors to add data as well as another node to a Node.  
	 *
	 */
	static class Node {
		Node next;
		int data;
		Object data2;

		/**
		 * @param data is an integer that is to be added to the linked list
		 */
		Node(int data) {
			this.data = data;
			this.next = null;
		}

		/**
		 * @param data2 data is an object that is to be added to the linked list
		 */
		public Node(Object data2) {
			this.data2 = data2;
			this.next = null;
		}
	}

	/**
	 * @param list is the Linked List 
	 * @param data is data to insert in the linked list
	 * @return a linked list with inserted data
	 * method insert will insert the data to the linked list 
	 */
	public DsaLinkedList insert(DsaLinkedList list, int data) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			Node newNode = new Node(data);
			if (list.head == null) {
				list.head = newNode;
			} else {
				Node last = head;
				while (last.next != null) {
					last = last.next;
				}
				last.next = newNode;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}
	/**
	 * @param list is the Linked List 
	 * @param data is data to insert in the linked list
	 * @return a linked list with inserted data
	 * method insert will insert the data as object to the linked list 
	 */
	public DsaLinkedList insert(DsaLinkedList list, Object data) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			Node newNode = new Node(data);
			if (list.head == null) {
				list.head = newNode;
			} else {
				Node last = head;
				while (last.next != null) {
					last = last.next;
				}
				last.next = newNode;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}


	/**
	 * @param list
	 * @param L is the starting point of a subList
	 * @param R end point of a subList
	 * @param N is the no of rotation are to e performed in a sublist. 
	 * @return a rotated List 
	 */
	public DsaLinkedList rotateList(DsaLinkedList list, int L, int R, int N) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			DsaLinkedList subList = new DsaLinkedList();
			Node node, node2 = null, node3 = null;
			node = list.head;
			int counter = 0, currentData = 0, nextData = 0;
			while (node.next != null) {
				counter++;
				if (counter == L - 1)
					node2 = node;
				else if (counter >= L && counter <= R) {

					subList = subList.insert(subList, node.data);
					if (counter == R) {
						node3 = node.next;
						node.next = null;
						break;
					}

				}

				else {

				}
				node = node.next;
			}

			counter = 1;
			while (counter <= N) {
				node = subList.head;

				int headData = node.data;
				nextData = headData;

				while (node.next != null) {
					currentData = node.data;
					node.data = nextData;
					nextData = currentData;
					node = node.next;

				}
				currentData = node.data;
				node.data = nextData;
				nextData = currentData;
				subList.head.data = nextData;
				counter++;

			}
			node2.next = subList.head;
			node.next = node3;
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	/**
	 * @param list is the Linked list to be displayed on screen
	 * display method will display the Linked list
	 */
	public void display(DsaLinkedList list) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			Node node;
			node = list.head;
			while (node.next != null) {
				System.out.print(" " + node.data + " ");
				node = node.next;
			}
			System.out.print(" " + node.data + " ");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/*
	 * public static void main(String[] args) throws Exception { DsaLinkedList
	 * dsaLinkedList = new DsaLinkedList();
	 * 
	 * System.out.println("enter no. of elements in the list"); Scanner scanner =
	 * new Scanner(System.in); int totalElements = scanner.nextInt();
	 * System.out.println("enter " + totalElements +
	 * " elements to add in the LinkList"); int data = 0; for (int i = 0; i <
	 * totalElements; i++) { data = scanner.nextInt(); dsaLinkedList =
	 * dsaLinkedList.insert(dsaLinkedList, data); }
	 * System.out.println("enter value of N:"); int N = scanner.nextInt();
	 * System.out.println("enter value of L:"); int L = scanner.nextInt();
	 * System.out.println("enter value of R:"); int R = scanner.nextInt();
	 * dsaLinkedList.display(dsaLinkedList); System.out.println("rotated List:");
	 * 
	 * dsaLinkedList.display(dsaLinkedList.rotateList(dsaLinkedList, L, R, N));
	 * 
	 * scanner.close();
	 * 
	 * }
	 */

}
