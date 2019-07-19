package assignment5;

/**
 * @author krishan Design a class to implement following mathematical problems.
 *         L.C.M. of two numbers x and y. Receive x and y as method parameters
 *         and return computed value. H.C.F of two numbers x and y using
 *         Euclid’s algorithm. Receive x and y as method parameters and return
 *         computed value.
 *
 * 
 */
public class LcmHcf {
	/**
	 * @param num1
	 * @param num2
	 * @return the LCM of two numbers num1 and num2
	 */
	public int LCM(int num1, int num2) {
		int hcf = 0;
		try {

			hcf = HCF(num1, num2);
			if (hcf < 0) {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (num1 * num2) / hcf;
	}

	// as we know gcd is hcf
	/**
	 * @param num1
	 * @param num2
	 * @return the HCF of two numbers num1 and num2
	 */
	public int HCF(int num1, int num2) {
		try {
			if (num1 < 0 || num2 < 0) {
				return -1;
			} else {
				// Everything divides 0
				if (num1 == 0 && num2 != 0)
					return num2;
				else if (num2 == 0 && num1 != 0)
					return num1;

				// base case
				else if (num1 == num2) {
					if (num1 == 0 && num2 == 0) {
						return -1;
					}
					return num1;
				}

				// n1 is greater
				else if (num1 > num2) {
					return HCF(num1 - num2, num2);
				}
			}
		} catch (Exception e) {

		}
		return HCF(num1, num2 - num1);
	}

	public static void main(String[] args) {

	}

}
