package assignment8;

/**
 * @author krishan
 * Lion is the sub class of Mammal
 */
public class Lion extends Mammal {

	/**
	 * @param name
	 * @param age
	 * @param weight
	 * function initialises the instance variables 
	 */
	Lion(String name, int age, float weight) {
		super(name, age, weight);
	}
	/**
	 *@return the sound of animal
	 */
	@Override
	public String getAnimalSound() {
		
		return "Roar";
	}
	/**
	 *@return the type of animal
	 */
	@Override
	public String getAnimalType() {
		
		return "Lion";
	}
	

}
