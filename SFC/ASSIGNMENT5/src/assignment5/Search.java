package assignment5;

/**
 * @author krishan class “Search” to search for an element in an array using
 *         following strategy 1.Linear Search 2.Binary Search Each of the above
 *         methods will receive an array and an element to be search in array as
 *         input. It will return the index where this element occurs in array.
 *         Assume array to be sorted for Binary search.
 */
public class Search {
	/**
	 * @param array
	 * @param ElementToSearch
	 * @param StartIndex
	 * @param EndIndex
	 * @return the index where the element to be searched occurs in array
	 */
	public int binarySearch(int array[], int ElementToSearch) {
		try {
			if (array.length > 0) {
				int mid = (array.length) / 2;

				if (array[mid] == ElementToSearch) {
					return mid + 1;
				} else if (ElementToSearch > array[mid]) {
					int tempArray[] = new int[array.length - (mid + 1)];
					int k = 0;
					for (int i = mid + 1; i < array.length; i++) {

						tempArray[k] = array[i];
						k++;
					}
					int result=0;
					if((result=binarySearch(tempArray, ElementToSearch))<0)
					{
						return -1;
					}
					else 
					{
						return result+mid+1;
					}
					
				} else {
					int tempArray[] = new int[mid];
					for (int i = 0; i < tempArray.length; i++) {
						tempArray[i] = array[i];

					}
					return binarySearch(tempArray, ElementToSearch);
				}
			}else {
				return -1;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	/**
	 * @param array
	 * @param ElementToSearch
	 * @param arrayIndex
	 * @return the index where the element to be searched occurs in array
	 */
	public int linearSearch(int array[], int ElementToSearch, int arrayIndex) {
		try {
			if (array.length != 0) {

				if (arrayIndex < array.length) {
					if (ElementToSearch == array[arrayIndex]) {
						return arrayIndex;
					} else {
						arrayIndex++;
						return linearSearch(array, ElementToSearch, arrayIndex);
					}
				} else {
					return -2;
				}
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

}
