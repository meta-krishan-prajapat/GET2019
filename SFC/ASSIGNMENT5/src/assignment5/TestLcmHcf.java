package assignment5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author krishan TestLcmHcf class tests the methods of class LcmHcf
 */
public class TestLcmHcf {
	LcmHcf lh = new LcmHcf();

	/**
	 * TestLcm Tests the LCM if both the arguments are 0
	 */
	@Test
	public void TestLcm() {
		assertEquals(-1, lh.LCM(0, 0));
	}

	/**
	 * TestHcf Tests the HCF if both the arguments are 0
	 */
	@Test
	public void TestHcf() {
		assertEquals(-1, lh.HCF(0, 0));
	}

	/**
	 * TestHcfNegative1 method tests the HCF method by passing first argument
	 * negative
	 */
	@Test
	public void TestHcfNegative1() {
		assertEquals(-1, lh.HCF(-2, 0));
	}

	/**
	 * TestHcfNegative2 method tests the HCF method by passing second argument
	 * negative
	 */
	@Test
	public void TestHcfNegative2() {
		assertEquals(-1, lh.HCF(0, -3));
	}

	/**
	 * TestLcmNegative1 method tests the LCM method by passing first argument
	 * negative
	 */
	public void TestLcmNegative1() {
		assertEquals(-1, lh.LCM(-2, 0));
	}

	/**
	 * TestLcmNegative2 method tests the LCM method by passing second argument
	 * negative
	 */
	@Test
	public void TestLcmNegative2() {
		assertEquals(-1, lh.LCM(0, -3));
	}

	/**
	 * TestHcfPositive1 method tests HCF method by passing positive arguments
	 */
	@Test
	public void TestHcfPositive1() {
		assertEquals(6, lh.HCF(30, 42));
	}

	/**
	 * TestLcmPositive1 method tests LCM method by passing positive arguments
	 */
	@Test
	public void TestLcmPositive1() {
		assertEquals(24, lh.LCM(24, 8));
	}

}
