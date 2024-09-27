package assignment8;

/**
 * @author krishan
 * Crocodile is the sub class of reptile
 */
public class Crocodile extends Reptile {

	/**
	 * @param name
	 * @param age
	 * @param weight
	 * function initialises the instance variables 
	 */
	public Crocodile(String name, int age, float weight) {
		super(name, age, weight);
	}
	/**
	 *@return the sound of the animal
	 */
	@Override
	public String getAnimalSound() {
		
		return "sound of crocodile";
	}
	/**
	 *@return the type of animal
	 */
	@Override
	public String getAnimalType() {
	
		return "Crocodile";
	}

}
