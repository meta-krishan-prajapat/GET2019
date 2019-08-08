package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author krishan
 * UniqueCharacterCountTest class is for testing UniqueCharacterCount
 */
public class UniqueCharacterCountTest {
	CountCharacter cc = new CountCharacter();

	/**
	 * positive test cases for method numberOfUniqueCharacter of UniqueCharacterCount class
	 */
	@Test
	public void testUniqueCharacter() {
		assertEquals(1, cc.numberOfUniqueCharacter("mmmmmmmmmn"));
		assertEquals(3, cc.numberOfUniqueCharacter("hello"));
		assertEquals(1, cc.numberOfUniqueCharacter("malyalam"));
		assertEquals(8, cc.numberOfUniqueCharacter("asdfgghjkl"));
	}

}