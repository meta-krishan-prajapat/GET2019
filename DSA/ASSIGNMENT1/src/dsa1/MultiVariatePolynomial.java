package dsa1;

/**
 * @author krishan
 * MultiVariatePolynomail is a class which visualize the representation of a
 * multivariate polynomial using a nested list
 */
public class MultiVariatePolynomial {
	DsaLinkedList mainList = new DsaLinkedList();
	DsaLinkedList subList = new DsaLinkedList();

	/**
	 * @param equation represents polynomial in multiple variable
	 * @return returns maximum degree of polynomial
	 */
	public int maxDegree(String equation) {
		int degree = 0;
		try
		{
			if(equation== null)
			{
				throw (new Exception("equation cant be null"));
			}
		for (int i = 0; i < equation.length(); i++) {
			if (Character.isLetter(equation.charAt(i))) {
				subList = subList.insert(subList, 1);
			} else {
				if (Character.isDigit(equation.charAt(i))) {
					subList = subList.insert(subList, Character.digit(equation.charAt(i), 15) - 1);
				} else {
					mainList = mainList.insert(mainList, subList.head);
					if (equation.charAt(i) != '=') {
						subList = new DsaLinkedList();
					} else {
						break;
					}

				}
			}
		}
		DsaLinkedList.Node mainListHead = mainList.head;
		DsaLinkedList.Node subListHead = null;
		
		int count = 0;
		while (mainListHead.next != null) {
			count = 0;
			subListHead = (DsaLinkedList.Node) mainListHead.data2;
			while (subListHead.next != null) {
				count = count + (int) subListHead.data;
				subListHead = subListHead.next;
			}
			count = count + (int) subListHead.data;
			if (count > degree)
				degree = count;
			mainListHead = mainListHead.next;
		}
		count = 0;
		subListHead = (DsaLinkedList.Node) mainListHead.data2;
		while (subListHead.next != null) {
			count = count + (int) subListHead.data;
			subListHead = subListHead.next;
		}
		count = count + (int) subListHead.data;
		if (count > degree)
			degree = count;
		}catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		return degree;
	}

	/*
	 * public static void main(String[] args) { MultiVariatePolynomial obj = new
	 * MultiVariatePolynomial(); System.out.println(obj.maxDegree("xy+x4z+w3y4=0"));
	 * }
	 */
}
