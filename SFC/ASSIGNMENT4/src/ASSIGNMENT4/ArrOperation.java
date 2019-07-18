package ASSIGNMENT4;

/**
 * @author krishan ArrOperation class have different methods that will perform
 *         different array operations methods of ArrOperation class are:
 *         maxMirror(),countClumps(),fixXY(),splitArray(). 1.Return the size of
 *         the largest mirror section found in the input array.
 * 
 *         Mirror section in an array is a group of contiguous elements such
 *         that somewhere in the array, the same group appears in reverse order.
 *         For example
 * 
 *         maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3 maxMirror([7, 1, 4, 9, 7, 4,
 *         1]) → 2 maxMirror([1, 2, 1, 4]) → 3 maxMirror*([1, 4, 5, 3, 5, 4, 1])
 *         → 7
 * 
 *         Throw assertion error in case array is empty.
 * 
 *         2. Return the number of clumps in the input array.
 * 
 *         Clump in an array is a series of 2 or more adjacent elements of the
 *         same value. For example
 * 
 *         countClumps([1, 2, 2, 3, 4, 4]) → 2 countClumps([1, 1, 2, 1, 1]) → 2
 *         countClumps([1, 1, 1, 1, 1]) → 1
 * 
 *         Throw assertion error in case array is empty.
 * 
 *         3. Solve fixXY problem
 * 
 *         Return an array that contains exactly the same numbers as the input
 *         array, but rearranged so that every X is immediately followed by a Y.
 *         Do not move X within array, but every other number may move. For ex:
 * 
 *         Let’s say value of X is 4 and Y is 5. Then
 * 
 *         fixXY([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9] fixXY([1, 4, 1, 5]) →
 *         [1, 4, 5, 1] fixXY([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
 *         Assume we are receiving an array of integers along with value of X
 *         and Y as a method parameter.
 * 
 *         Throw assertion in following cases : If array is empty If there are
 *         unequal numbers of X and Y in input array. If two adjacents X values
 *         are there. If X occurs at the last index of array.
 * 
 *         4. splitArray
 * 
 *         Return the index if there is a place to split the input array so that
 *         the sum of the numbers on one side is equal to the sum of the numbers
 *         on the other side else return -1. For ex
 * 
 *         splitArray([1, 1, 1, 2, 1]) → 3 splitArray([2, 1, 1, 2, 1]) → -1
 *         splitArray([10, 10]) → 1
 * 
 *         Throw assertion error in case array is empty.
 * 
 */
public class ArrOperation {

	/**
	 * @param array
	 * @return maximum mirror length of array.
	 * @throws Exception maxMirror method accepts an array as argument and returns
	 *                   the maximum mirror length of array. Mirror section in an
	 *                   array is a group of contiguous elements such that somewhere
	 *                   in the array, the same group appears in reverse order
	 */
	public int maxMirror(int array[]) throws Exception {

		if (array.length == 0) {
			throw (new Exception("Empty Array"));
		}
		int length = array.length;
		int Temp_array[] = new int[length];
		int startPointer, endPointer, counter = 0, maximumCounter = 0;
		try {
			for (int k = 0; k < length; k++) {
				Temp_array[k] = array[k];
			}

			for (int i = 0; i < length; i++) {
				for (int j = length - 1; j >= 0; j--) {
					startPointer = i;
					endPointer = j;
					counter = 0;
					while ((startPointer < length && endPointer >= 0)
							&& (Temp_array[startPointer] == Temp_array[endPointer])) {
						counter++;
						startPointer++;
						endPointer--;
					}
					if (counter > maximumCounter) {
						maximumCounter = counter;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maximumCounter;
	}

	/**
	 * @param array
	 * @return total number of Clumps in the array
	 * @throws Exception Clump in an array is a series of 2 or more adjacent
	 *                   elements of the same value.
	 */
	public int countClumps(int array[]) throws Exception {

		if (array.length == 0) {
			throw (new Exception("Empty Array"));
		}
		boolean flag = false;
		int counter = 0;
		try {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == array[i + 1] && flag == false) {
					counter++;
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}

	/**
	 * @param array
	 * @param x
	 * @param y
	 * @return
	 * @throws Exception Return an array that contains exactly the same numbers as
	 *                   the input array, but rearranged so that every X is
	 *                   immediately followed by a Y. Do not move X within array,
	 *                   but every other number may move.
	 */
	public int[] fixXY(int array[], int x, int y) throws Exception {
		if (array.length == 0) {
			throw (new Exception("Empty Array"));
		}
		int xCounter = 0, yCounter = 0, k = 0, length = array.length;
		try {

			for (int i = 0; i < array.length; i++) {
				if (array[i] == x) {
					xCounter++;
					if (array[i] == array[i + 1] && (i + 1) < length) {
						throw (new Exception("two adjacents X values are there"));

					}

				} else if (array[i] == y) {
					yCounter++;
				}
			}
			if (xCounter == yCounter && array[length - 1] != x) {
				for (int j = 0; j < length; j++) {
					if (array[j] == y) {
						while (k < length - 1) {
							if (array[k] == x) {
								array[k + 1] = array[k + 1] ^ array[j];
								array[j] = array[k + 1] ^ array[j];
								array[k + 1] = array[k + 1] ^ array[j];
								k++;
								j = k;
								break;
							} else {
								k++;
							}

						}
					}
				}
			} else {
				if (xCounter != yCounter) {
					throw (new Exception("unequal numbers of X and Y in input array"));
				} else
					throw (new Exception("X occurs at the last index of array"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	/**
	 * @param array
	 * @return the index if there is a place to split the input array so that the
	 *         sum of the numbers on one side is equal to the sum of the numbers on
	 *         the other side else return -1.
	 * @throws Exception
	 */
	public int splitArray(int array[]) throws Exception {

		if (array.length == 0) {
			throw (new Exception("Empty Array"));
		}
		int length = array.length, sum1 = 0, sum2 = 0, split_position = -1, startpointer = -1, endpointer = length;
		try {
			while (startpointer != endpointer - 1) {
				if (sum1 == sum2) {

					startpointer++;
					endpointer--;
					sum1 += array[startpointer];
					sum2 += array[endpointer];

				} else if (sum1 < sum2) {
					startpointer++;
					sum1 += array[startpointer];
				} else {
					endpointer--;
					sum2 += array[endpointer];
				}
				if (startpointer + 1 == endpointer - 1 && sum1 == sum2) {
					break;
				}

			}
			if (sum1 == sum2 && startpointer == endpointer - 1) {
				split_position = endpointer;
			} else {
				split_position = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return split_position;
	}

	public static void main(String[] args) throws Exception {
		ArrOperation obj = new ArrOperation();
		int arr[] = { 1, 2, 2, 1 };
		int max = obj.maxMirror(arr);
		System.out.print(max);
	}

}
