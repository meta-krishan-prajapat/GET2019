package question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author krishan
 * TestEvaluateExpression tests the EvaluateExpression class
 *
 */
public class TestEvaluateExpression {
	@Test
	public void TestExpression()
	{ 
		String s=EvaluateExpression.EvaluateExpressionStack(" 2 * 6");
		assertEquals("12",s);
	}
	@Test
	public void TestExpression2()
	{ 
		String s=EvaluateExpression.EvaluateExpressionStack("( 7 * 8 ) - 7 * ( 10 / 2 )");
		assertEquals("21",s);
	}
	@Test
	public void TestExpression3()
	{ 
		String s=EvaluateExpression.EvaluateExpressionStack("100 * ( 2 + 12 )");
		assertEquals("1400",s);
	}
	@Test
	public void TestExpression4()
	{ 
		String s=EvaluateExpression.EvaluateExpressionStack(" 100 * ( 2 + 12 ) / 14");
		assertEquals("100",s);
	}

}
