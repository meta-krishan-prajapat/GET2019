package assignment6;

/**
 * @author krishan 
 * IntSet is an immutable class which is using an array to represent a set of integers in the range 1-1000 The purpose of IntSet is for the operation with set of array.
 */
public final class IntSet {
	private final int[] set;

	/**
	 * @param array is an Array of integers between 1 to 1000.
	 */
	public IntSet(int array[]) {
		this.set = new int[array.length];
		for (int i = 0; i < set.length; i++) {
			if (array[i] > 0 && array[i] <= 1000) {
				set[i] = array[i];
			}
			else
			{
				System.out.println("values out of bound");
				break;
			}
			
		}

	}

	/**
	 * @param x is an integer
	 * @return returns true if x is the member of set[] else returns false.
	 */
	public boolean isMember(int x) {
		try {
			for (int i = 0; i < set.length; i++) {
				if (set[i] == x) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * @return returns the length of the set
	 */
	public int size() {
		return set.length;
	}

	/**
	 * @param s is an object of IntSet class which will have a set array of its own
	 * @return returns true if s.set is the subset of set else return false
	 */
	public boolean isSubSet(IntSet s) {
		boolean flag;
		try {
			for (int i = 0; i < s.set.length; i++) {
				flag = false;
				for (int j = 0; j < set.length; j++) {
					if (set[j] == s.set[i]) {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					return false;
				}
			}
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * @return returns the compliment array of set
	 */
	public int[] getComplement() {
		boolean flag;

		int complimentSet[] = new int[1000 - set.length], k = 0;
		try {
			flag = false;
			for (int i = 1; i <= 1000; i++) {
				for (int j = 0; j < set.length; j++) {
					if (set[j] == i) {
						flag = false;
						break;
					} else {
						flag = true;
					}

				}
				if (flag == true) {
					complimentSet[k] = i;
					k++;
				}
			}
		} catch (Exception e) {
		}
		return complimentSet;
	}

	/**
	 * @param s1 is an object of class IntSet having a set
	 * @param s2 is an object of class IntSet having a set
	 * @return returns the union of s1.set and s2.set
	 */
	public int[] union(IntSet s1, IntSet s2) {
		int union[] = null, common = 0, k;
		boolean flag = false;
		try {
			for (int i = 0; i < s1.set.length; i++) {
				for (int j = 0; j < s2.set.length; j++) {
					if (s1.set[i] == s2.set[j]) {
						common++;
					}
				}
			}
			union = new int[s1.set.length + s2.set.length - common];
			for (k = 0; k < s1.set.length; k++) {
				union[k] = s1.set[k];
			}
			for (int j = 0; j < s2.set.length; j++) {
				for (int i = 0; i < union.length; i++) {
					if (s2.set[j] == union[i]) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if (flag == true) {
					union[k] = s2.set[j];
					k++;
				}
			}
		} catch (Exception e) {
		}
		return union;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 3, 4, 5 };

		IntSet ins1 = new IntSet(arr);
		IntSet ins2 = new IntSet(arr2);
		IntSet ob = new IntSet(arr);

		arr = ob.getComplement();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
