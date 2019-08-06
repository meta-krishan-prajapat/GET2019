package question2;

import java.util.Scanner;

public class PriorityQueueTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Queue Size");
		int size = input.nextInt();
		PriorityQueue object = new PriorityQueue(size);

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Display the Queue elements.\n4\tTo Exit the Program.\nEnter your option:- ");
			select = input.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				int ele = input.nextInt();
				System.out.print("Enter their priority");
				int priority = input.nextInt();
				object.enQueue(ele, priority);
				break;
			}
			case 2: {
				try {
					object.deQueue();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				object.display();
				break;
			}
			case 4: {
				term = 1;
				break;
			}
			default:
				System.out.println("Enter a valid options");
			}
		}
	}

}
