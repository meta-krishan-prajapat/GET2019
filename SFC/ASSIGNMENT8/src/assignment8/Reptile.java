package assignment8;

/**
 * @author krishan 
 * Reptile class is the sub class of animal class
 */
public abstract class Reptile extends Animal {
	public final static String reptile = "Re0ptile";

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	public Reptile(String name, int age, float weight) {
		super(name, age, weight);

	}

	/**
	 * @return the category of the animal
	 */
	public String getAnimalCategory() {
		return reptile;
	}

	/**
	 * @return the sound of animal
	 */
	@Override
	public abstract String getAnimalSound();

	/**
	 * @return the type of animal
	 */
	@Override
	public abstract String getAnimalType();

}
