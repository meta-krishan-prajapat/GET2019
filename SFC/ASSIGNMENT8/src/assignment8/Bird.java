package assignment8;

/**
 * @author krishan
 * Bird class is the sub class of animal class
 *
 */
public abstract class Bird extends Animal {
	public final static String bird = "Bird";

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	public Bird(String name, int age, float weight) {
		super(name, age, weight);
	}

	/**
	 * @return the category of animal
	 */
	public String getAnimalCategory() {
		return bird;
	}

	/**
	 * @return the sound of particular type of animal
	 */
	@Override
	public abstract String getAnimalSound();

	/**
	 * @return the type of animal
	 */
	@Override
	public abstract String getAnimalType();

}
