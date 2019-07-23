package assignment2;

/**
 * @author krishan 
 * class HexCalc supports hexadecimal numbers operational methods.
 */
public class HexCalc {
	char positions[];

	public HexCalc() {
		positions = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	}

	/**
	 * @param number is a number with base @param base
	 * @param base   is the base from which the @number will be converted to decimal
	 *               number
	 * @return returns the converted decimal number as integer
	 */
	public int convertToDecimal(String number, int base) {
		int decimal = 0;
		boolean flag = false;
		try {
			number = number.toUpperCase();
			char num[] = number.toCharArray();
			for (int i = num.length - 1, k = 0; i >= 0; i--) {
				flag = false;
				for (int j = 0; j < base; j++) {
					if (num[i] == positions[j]) {
						flag = true;
						decimal += (Math.pow(base, k)) * j;
						k++;
					}
				}

				if (flag == false) {
					throw (new Exception("cant convert this number to decimal"));
				}

			}
			return decimal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return -1;
	}

	/**
	 * @param number is a decimal number
	 * @param base   is the base in which decimal number @param number is converted
	 * @return the number in the converted base as string
	 */
	public String convertFromDecimal(int number, int base) {
		String convertedReversedNum = "", reverse = "";
		int remainder = 0, num = number;
		try {

			while (num != 0) {
				remainder = num % base;
				convertedReversedNum += positions[remainder];
				num = num / base;
			}

			for (int i = convertedReversedNum.length() - 1; i >= 0; i--) {
				reverse = reverse + convertedReversedNum.charAt(i);
			}
		} catch (Exception e) {
			System.out.println("can't convert this number from decimal");
		}
		return reverse;
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns addition of aString and bString in hexadecimal as a string
	 */
	public String add(String aString, String bString) {

		int decimal1 = 0, decimal2;
		try {
			decimal1 = convertToDecimal(aString, 16);
			decimal2 = convertToDecimal(bString, 16);
			decimal1 += decimal2;
		} catch (Exception e) {
			System.out.println("addition can't be performed");
		}
		return convertFromDecimal(decimal1, 16);
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns subtraction of aString and bString in hexadecimal as a string
	 */
	public String subtract(String aString, String bString) {

		int decimal1 = 0, decimal2;
		try {
			decimal1 = convertToDecimal(aString, 16);
			decimal2 = convertToDecimal(bString, 16);
			decimal1 -= decimal2;
			if (decimal1 < 0)
				decimal1 *= -1;
		} catch (Exception e) {
			System.out.println("substraction cant be performed");
		}
		return convertFromDecimal(decimal1, 16);
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns multiplication of aString and bString in hexadecimal as a
	 *         string
	 */
	public String multiply(String aString, String bString) {

		int decimal1 = 0, decimal2;
		try {
			decimal1 = convertToDecimal(aString, 16);
			decimal2 = convertToDecimal(bString, 16);
			decimal1 *= decimal2;
		} catch (Exception e) {
			System.out.println("multiplication cant be performed");
		}
		return convertFromDecimal(decimal1, 16);
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns division of aString and bString in hexadecimal as a string
	 */
	public String divide(String aString, String bString) {

		int decimal1, decimal2, decimal3 = 0;
		try {
			decimal1 = convertToDecimal(aString, 16);
			decimal2 = convertToDecimal(bString, 16);
			if (decimal1 > decimal2) {
				decimal3 = (int) (decimal1 / decimal2);
			} else {
				decimal3 = 0;
			}
		} catch (ArithmeticException e) {
			System.out.print("please enter valid numbers you entered zero in denominator ");
		}
		return convertFromDecimal(decimal3, 16);
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns true if aString is less than bString
	 * @throws Exception handles Exception if occurs
	 */
	public boolean equalTo(String aString, String bString) throws Exception {

		if (aString.equalsIgnoreCase(bString))
			return true;
		else
			return false;
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns true if aString is greater than bString
	 * @throws Exception handles Exception if occurs
	 */
	public boolean greaterThan(String aString, String bString) throws Exception {

		if (aString.compareTo(bString) > 0)
			return true;
		return false;
	}

	/**
	 * @param aString and @param bString are hexadecimal numbers
	 * @return returns true if aString is less than bString
	 * @throws Exception handles Exception if occurs
	 */
	public boolean LessThan(String aString, String bString) throws Exception {

		if (aString.compareTo(bString) < 0)
			return true;
		return false;
	}

	public static void main(String args[]) {
		try {
			HexCalc ob = new HexCalc();
			System.out.println(ob.convertToDecimal("74h", 16));
			System.out.println(ob.convertToDecimal("74", 16));
			System.out.println(ob.convertFromDecimal(116, 16));
			// 1E is 30 and 35 is 53
			String aString = "1E", bString = "35";
			;
			System.out.println("addition:" + ob.add(aString, bString));
			System.out.println("substraction:" + ob.subtract(aString, bString));
			System.out.println("multiplication:" + ob.multiply(aString, bString));

			System.out.println("division:" + ob.divide(bString, aString));
			System.out.println("equal" + ob.equalTo(aString, bString));
			System.out.println("greater:" + ob.greaterThan(aString, bString));
			System.out.println("less:" + ob.LessThan(aString, bString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
