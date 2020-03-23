package dsa1;

import java.util.HashSet;

/**
 * @author krishan
 * LoopDetector class will first create a loop in the given linked list.
 * if there is a loop in the linked list it will detect. 
 *
 */
public class LoopDetector {
	/**
	 * @param list is the Linked List
	 * @param position is the position of loop node
	 * @return a looped linked list
	 */
	public static DsaLinkedList loopCreator(DsaLinkedList list, int position) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			DsaLinkedList.Node node = list.head;
			int counter = 0;
			while (node.next != null) {
				node = node.next;
			}
			DsaLinkedList.Node node2 = list.head;
			while (node2.next != null) {
				counter++;
				if (counter == position) {
					node.next = node2;
					break;
				}

				node2 = node2.next;
			}
			counter++;

			if (counter == position) {
				node.next = node2;

			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return list;
	}

	/**
	 * @param node is the head node of particular linked list.
	 * @return true if it detects a loop else return false
	 */
	public static boolean detectLoop(DsaLinkedList.Node node) {
		try {
			if (node == null) {
				throw (new Exception("list is empty can't perform operation"));
			}
			HashSet<DsaLinkedList.Node> set = new HashSet<DsaLinkedList.Node>();
			while (node != null) {

				if (set.contains(node))
					return true;

				// If we are seeing the node for
				// the first time, insert it in hash
				set.add(node);

				node = node.next;
			}
		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * @param list is the Linked list that is going to be detected for loop.
	 * @return true if it detects a loop else return false
	 */
	public boolean detectLoop2(DsaLinkedList list) {
		try {
			if (list == null) {
				throw (new Exception("list cant be empty"));
			}
			DsaLinkedList.Node fastPtr = list.head;
			DsaLinkedList.Node slowPtr = list.head;
			while (fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
				if (slowPtr == fastPtr)
					return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return false;
	}

	/*
	 * public static void main(String args[]) { try { LoopDetector ld = new
	 * LoopDetector();
	 * 
	 * DsaLinkedList list = new DsaLinkedList(); list.insert(list, 2);
	 * list.insert(list, 3); list.insert(list, 4); list.insert(list, 5);
	 * list.insert(list, 6); list.insert(list, 7); list.insert(list, 8); list =
	 * ld.loopCreator(list, 7); System.out.print(ld.detectLoop(list.head));
	 * System.out.print(ld.detectLoop2(list)); }
	 * 
	 * catch (Exception e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */

}
