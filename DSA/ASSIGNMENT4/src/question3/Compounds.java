package question3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author krishan
 * class Compound keeps the mass of C,O,H and calculates the mass of give compound
 */
public class Compounds {
	public static Map<Character,Integer> mass = new HashMap<Character,Integer>();
	/**
	 * add the element with the mass
	 */
	public void addValue( ) {
		mass.put('C',12);
		mass.put('H', 1);
		mass.put('O',16);
	}
	/**
	 * calculate the mass of the compounds
	 * @param compound
	 * @return
	 */
	public int calculateMass(String compound) {
		int result=0;
		try
		{
			if (compound == null) {
				throw new Exception("compound name cant be null");
			}
		addValue();
		Map<Character,Integer> count=characterCount(compound);
		for(char s : count.keySet()) {
			result=result+(count.get(s)*mass.get(s));
		}     
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * calculate the count of each character
	 * @param inputString
	 * @return map
	 */
	public HashMap<Character, Integer> characterCount(String inputString) {
		HashMap<Character, Integer> charCountMap=null;
		try
		{
		charCountMap = new HashMap<Character, Integer>(); 
		char[] strArray = inputString.toCharArray(); 


		for (char c : strArray) { 
			if (charCountMap.containsKey(c)) { 
				charCountMap.put(c, charCountMap.get(c) + 1); 
			} 
			else { 
				charCountMap.put(c, 1); 
			} 
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return charCountMap;
	} 
}