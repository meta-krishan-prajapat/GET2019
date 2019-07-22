package assignment6;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author krishan 
 * TestIntset class is created to test the methods of Intset
 *
 */
public class TestIntset {

	// test of set values out of range
	@Test
	public void testSet_Out_Range() {

		new IntSet(new int[] { -1, 1002 });

	}

	// positive test case for determining size of set
	@Test
	public void testLength() {

		IntSet setarray = new IntSet(new int[] { 6, 7, 8, 10 });
		int returnedValue = setarray.size();
		int expectedValue = 4;
		Assert.assertEquals(expectedValue, returnedValue);
	}

	// positive test case to check if the number is member of set
	@Test
	public void testFind_Value_Positive() {
		IntSet setarray = new IntSet(new int[] { 1, 2, 3, 4, 5 });
		assertTrue(setarray.isMember(4));
	}

	// negative test case to check if the number is member of set
	@Test
	public void testFind_Value_Negative() {
		IntSet setarray = new IntSet(new int[] { 1, 2, 3, 4, 5 });
		assertFalse(setarray.isMember(8));
	}

	// positive test to check if given array is a subset
	@Test
	public void test_Is_Subset_Positive() {
		IntSet setarray = new IntSet(new int[] { 1, 2, 3, 4, 5 });
		IntSet subsetarray = new IntSet(new int[] { 1, 2, 3 });
		assertTrue(setarray.isSubSet(subsetarray));
	}

	// negative test to check if given array is a subset
	@Test
	public void test_Is_Subset_Negative() {
		IntSet setarray = new IntSet(new int[] { 1, 2, 3, 4, 5 });
		IntSet subsetarray = new IntSet(new int[] { 7, 8 });
		assertFalse(setarray.isSubSet(subsetarray));
	}

	// test to check if null set is a subset
	@Test
	public void test_Is_Subset_Null() {
		IntSet setarray = new IntSet(new int[] { 1, 2, 3, 4, 5 });
		IntSet subsetarray = new IntSet(new int[] {});
		assertTrue(setarray.isSubSet(subsetarray));
	}

	// positive test for union operation of sets
	@Test
	public void test_Union_Set_Same() {
		IntSet setarray1 = new IntSet(new int[] { 1, 2, 3 });
		IntSet setarray2 = new IntSet(new int[] { 1, 2, 3 });
		int returnedArrOperation[] = setarray1.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_Union_Set_Diff() {
		IntSet setarray1 = new IntSet(new int[] { 1, 2, 3 });
		IntSet setarray2 = new IntSet(new int[] { 4, 5, 6 });
		int returnedArrOperation[] = setarray1.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_Union_Set_Mix() {
		IntSet setarray1 = new IntSet(new int[] { 1, 2, 3 });
		IntSet setarray2 = new IntSet(new int[] { 2, 3, 5, 6 });
		int returnedArrOperation[] = setarray1.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3, 5, 6 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_Union_Set_Null() {
		IntSet setarray1 = new IntSet(new int[] { 1, 2, 3 });
		IntSet setarray2 = new IntSet(new int[] {});
		int returnedArrOperation[] = setarray1.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

}
