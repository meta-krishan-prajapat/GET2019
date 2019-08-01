package dsa1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
/**
 * @author krishan
 * TestLinkedList class will tests the Linked list class methods of rotation loop detection and multivariate polynomial.
 */
public class TestLinkedList {
	
	/**
	 * TestRotateDsaLinkedList method will test the clockwise rotation of the linked list.
	 */
	@Test
	public void TestRotateDsaLinkedList() {
		
		DsaLinkedList list = new DsaLinkedList();
		list = list.insert(list , 2);
		list = list.insert(list , 3);
		list = list.insert(list , 4);
		list = list.insert(list , 5);
		list = list.insert(list , 6);
		list = list.insert(list , 7);
		
		list = list.rotateList(list,2,5,2);
		
		list.display(list);
		System.out.println();
		DsaLinkedList expectedresult = new DsaLinkedList();
		expectedresult = expectedresult.insert(expectedresult , 2);
		expectedresult = expectedresult.insert(expectedresult , 5);
		expectedresult = expectedresult.insert(expectedresult , 6);
		expectedresult = expectedresult.insert(expectedresult , 3);
		expectedresult = expectedresult.insert(expectedresult , 4);
		expectedresult = expectedresult.insert(expectedresult , 7);
		System.out.println();
		list.display(expectedresult);
		Assert.assertEquals(expectedresult,list);
	}
	
	
	/**
	 * TestDetectLoop method detects the loop in the Linked List if exists.
	 */
	@Test
	public void TestDetectLoop() {
		
		DsaLinkedList list = new DsaLinkedList();
		list = list.insert(list , 2);
		list = list.insert(list , 3);
		list = list.insert(list , 4);
		list = list.insert(list , 5);
		list = list.insert(list , 6);
		list = list.insert(list , 7);
		
		list = LoopDetector.loopCreator(list,3);
		boolean expectedresult = true;
		assertEquals(expectedresult,LoopDetector.detectLoop(list.head));				
	}
	/**
	 * TestDetectLoop2 method detects the loop in the Linked List if exists.
	 */
	@Test
	public void TestDetectLoop2() {
		
		DsaLinkedList list = new DsaLinkedList();
		list = list.insert(list , 2);
		list = list.insert(list , 3);
		list = list.insert(list , 4);
		list = list.insert(list , 5);
		list = list.insert(list , 6);
		list = list.insert(list , 7);
		boolean expectedresult = false;
		assertEquals(expectedresult,LoopDetector.detectLoop(list.head));				
	}
	
	/**
	 * TestMultiVariatePolynomial method tests the maximum degree of a multivariate polynomial.
	 */
	@Test
	public void TestMultiVariatePolynomial(){
		MultiVariatePolynomial poly = new MultiVariatePolynomial();
		int degree = poly.maxDegree("xy+x4z+w3y4=0");
		int expectedresult = 7;
		assertEquals(expectedresult,degree);
	}
	/**
	 * TestMultiVariatePolynomial2 method tests the maximum degree of a multivariate polynomial.
	 */
	@Test
	public void TestMultiVariatePolynomial2(){
		MultiVariatePolynomial poly = new MultiVariatePolynomial();
		int degree = poly.maxDegree("xy2+x6z+w4y4=0");
		int expectedresult = 8;
		assertEquals(expectedresult,degree);
	}

}
