package question2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author krishan
 * CountCharacter class count the unique character in a string
 */
public class CountCharacter {

	HashMap<String, Integer> cache = new HashMap<>();

	public long numberOfUniqueCharacter(String input) {
		int result = 0;
		try {
			if (input == null) {
				throw new Exception("String cant be null");
			}
			// for storing character one by one uniquely character is key and value is of
			// character in that string
			HashMap<Character, Integer> uniquecharacter = new HashMap<>();
			for (int i = 0; i < input.length(); i++) {
				char tempChar = input.charAt(i);
				// if character is already exist in map then update it's value
				if (uniquecharacter.containsKey(tempChar)) {
					int val = uniquecharacter.get(tempChar);
					uniquecharacter.put(tempChar, val + 1);
				}
				// if not exist then put in hashMap
				else
					uniquecharacter.put(tempChar, 1);

			}

			// creating a set of keySet of HashMap
			Set<Character> keyset = uniquecharacter.keySet();
			// creating a iterator for traversing set
			Iterator<Character> iterator = keyset.iterator();

			while (iterator.hasNext()) {
				// if character occurence (stored in map as value) is one then increment result
				// value
				if (uniquecharacter.get(iterator.next()) == 1)
					result++;
			}
			// put result in cash hashMap for future use
			cache.put(input, result);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

}
