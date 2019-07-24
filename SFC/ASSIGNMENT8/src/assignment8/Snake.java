package assignment8;

/**
 * @author krishan
 * Snake is the sub class of reptile
 */
public class Snake extends Reptile {

	/**
	 * @param name
	 * @param age
	 * @param weight
	 * function initialises the instance variables 
	 */
	public Snake(String name, int age, float weight) {
		super(name, age, weight);
	}
	/**
	 *@return the sound of animal
	 */
	@Override
	public String getAnimalSound() {
		
		return "hissssss";
	}
	/**
	 *@return the type of animal
	 */
	@Override
	public String getAnimalType() {
	
		return "Snake";
	}

}
