package question1;

/**
 * @author krishan
 * EvaluateExpression will evaluate the expression which is in infix
 */
public class EvaluateExpression {
	/**
	 * @param expression
	 * @return 
	 */
	public static String EvaluateExpressionStack(String expression) {
		char[] tokens = expression.toCharArray();
		int result = 0;
		StackOperation operator = new StackOperation();
		StackOperation stack = new StackOperation();
		int flag = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ') {
				continue;
			}
			
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0'
						&& tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				stack.push((sbuf.toString()));
			} else if (tokens[i] == '(') {
				operator.push((Character.toString(tokens[i])));
			} else if (tokens[i] == ')') {
				while (operator.peek() != "(") {
					result = evaluate(stack.pop(), operator.pop(),
							stack.pop());
					if(operator.peek().equals("(")){
						flag =1;
						break;
					}
					stack.push(result + "");
				}
				if(flag == 1){
					operator.pop();
					stack.push(result + "");
				}
				//operator.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'
					|| tokens[i] == '/') {
				while (!operator.isEmpty()
						&& operator.Prec(Character.toString(tokens[i])) <= operator
								.Prec(operator.peek())) {
					result = evaluate(stack.pop(), operator.pop(),
							stack.pop());
					stack.push(result + "");
				}
				operator.push((Character.toString(tokens[i])));
			}

		}
		while (!operator.isEmpty()) {
			result = evaluate(stack.pop(), operator.pop(), stack.pop());
			stack.push(result + "");
		}
		return stack.pop();
	}

	/**
	 * @param operand1
	 * @param operator
	 * @param operand2
	 * @return the evaluated result of the @param operand1 ,@param operand1 and @param operand2
	 */
	public static int evaluate(String operand1, String operator, String operand2) {
		int result = 0;
		try
		{
			if(operand1==null||operand2==null||operator==null)
			{
				throw new Exception("inputs can't be null");
			}
			else
			{
		int op1 = Integer.parseInt(operand2);
		int op2 = Integer.parseInt(operand1);
		
		System.out.println(operator);
		if (operator.equals("*")) {
			result = op1 * op2;
		} else if (operator.equals("/")) {
			result = op1 / op2;
		} else if (operator.equals("+")) {
			result = op1 + op2;
		} else if (operator.equals("-")) {
			result = op1 - op2;
		}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		// System.out.println(EvaluateExpressionStack(" 2 * 6"));
		System.out.println(EvaluateExpressionStack("( 7 * 8 ) - 7 * ( 10 / 2 )"));
		// System.out.println(EvaluateExpressionStack("100 * ( 2 + 12 )"));
		// System.out.println(EvaluateExpressionStack("100 * ( 2 + 12 ) / 14"));
	}

}
