package assignment5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author krishan TestSearch class tests the methods of Search class
 *
 */
public class TestSearch {
	Search search = new Search();

	/**
	 * TestBinaryEmpty method tests the binarySearch method by passing empty array
	 */
	@Test
	public void TestBinaryEmpty() {
		assertEquals(-1, search.binarySearch(new int[] {}, 5));
	}

	/**
	 * TestLinearEmpty method tests the linearSearch method by passing empty array
	 */
	@Test
	public void TestLinearEmpty() {
		assertEquals(-1, search.linearSearch(new int[] {}, 5, 0));
	}

	/**
	 * TestBinaryNotFound method tests binarySearch method by passing an element
	 * which is not present in array which is passed in arguments
	 */
	@Test
	public void TestBinaryNotFound() {
		assertEquals(-1, search.binarySearch(new int[] { 1, 2, 3, 4 }, 5));
	}

	/**
	 * TestlinearNotFound method tests linearSearch method by passing an element
	 * which is not present in array which is passed in arguments
	 */
	@Test
	public void TestlinearNotFound() {
		assertEquals(-2, search.linearSearch(new int[] { 6, 2, 8, 5 }, 3, 0));
	}

	/**
	 * TestBinaryTrue method tests the binarySearch method by passing true values
	 */
	@Test
	public void TestBinaryTrue() {
		int array[] = { 2, 4, 6, 8, 10 };
		assertEquals(5, search.binarySearch(array, 10));
	}

	/**
	 * TestlinearTrue method tests the linearSearch method by passing true values
	 */
	@Test
	public void TestlinearTrue() {
		int array[] = { 2, 4, 1, 3, 6 };
		assertEquals(3, search.linearSearch(array, 3, 0));
	}

}
