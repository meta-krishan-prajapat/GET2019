package question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author krishan
 *test class for compound class 
 */
public class CalculateMassTest {
	 Compounds com = new Compounds();
	@Test
	public void compoundtest1() {
		
	      assertEquals(32,com.calculateMass("CHHHOH"));
	}
	@Test
	public void compoundtest2() {
		
	      assertEquals(30,com.calculateMass("CHHHCHHH"));
	}
	@Test
	public void compoundtest3() {
		
	      assertEquals(18,com.calculateMass("HOH"));
	}
	@Test
	public void compoundtest4() {
		
	      assertEquals(46,com.calculateMass("CHHHCHHOH"));
	}
	@Test
	public void compoundtest5() {
		
	      assertEquals(60,com.calculateMass("CHHHCOOH"));
	}

}