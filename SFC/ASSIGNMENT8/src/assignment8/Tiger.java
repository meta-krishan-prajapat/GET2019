package assignment8;

/**
 * @author krishan
 * Tiger is the sub class of Mammal
 */
public class Tiger extends Mammal {

	/**
	 * @param name
	 * @param age
	 * @param weight
	 * function initialises the instance variables 
	 */
	Tiger(String name, int age, float weight) {
		super(name, age, weight);
	}
	/**
	 *@return the sound of animal
	 */
	@Override
	public String getAnimalSound() {
		
		return "Tiger-Roar";
	}
	/**
	 *@return the type of animal
	 */
	@Override
	public String getAnimalType() {
		
		return "Tiger";
	}
	

}
