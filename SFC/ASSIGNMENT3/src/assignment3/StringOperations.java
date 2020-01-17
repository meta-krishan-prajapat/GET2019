package assignment3;

/**
 * @author krishan 
 * StringOperartions class compares string1 and string2, reverse the string, finds the largest word and converts lowercase to uppercase and vice versa.
 */
public class StringOperations {
	/**
	 * Compares two strings for equality
	 * @param string1
	 * @param string2
	 * @return 1 if equal, 0 otherwise
	 */
	public int compareString(String string1, String string2) {
		int equal = 0;
		try {

			if (string1.length() == string2.length()) {
				equal = 1;
				for (int i = 0; i < string1.length(); i++) {
					if (string1.charAt(i) != string2.charAt(i)) {
						equal = 0;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equal;
	}

	/**
	 * Generates the reverse of a string 
	 * @param originalString
	 * @return reverse of the originalString
	 */
	public String reverseString(String originalString) {
		String reverseString = "";
		try {

			for (int i = originalString.length() - 1; i >= 0; i--) {
				reverseString += originalString.charAt(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reverseString;
	}

	/**
	 * Converts lowercase characters in a string to uppercase characters and viceversa
	 * @param originalString
	 * @return convertedString
	 */
	public String convertString(String originalString) {
		String convertedString = "";
		try {

			for (int i = 0; i < originalString.length(); i++) {
				if (originalString.charAt(i) >= 'a' && originalString.charAt(i) <= 'z')
					convertedString += (char) (originalString.charAt(i) - 32);
				else if (originalString.charAt(i) >= 'A' && originalString.charAt(i) <= 'Z')
					convertedString += (char) (originalString.charAt(i) + 32);
				else
					convertedString += originalString.charAt(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedString;
	}

	/**
	 * Finds the largest word in a string
	 * @param string
	 * @return largest word in the string
	 */
	public String largestWord(String string) {
		String largestWord = "";
		try {
			for (String word : string.split(" ")) {
				if (word.length() >= largestWord.length())
					largestWord = word;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return largestWord;
	}

	public static void main(String[] args) {
		StringOperations stringOp = new StringOperations();
		System.out.println("result:" + stringOp.compareString("hello", "world"));
		System.out.println(stringOp.convertString("hello"));
		System.out.println(stringOp.largestWord("metacube is a good company"));
		System.out.println(stringOp.reverseString("cool"));

	}
}
