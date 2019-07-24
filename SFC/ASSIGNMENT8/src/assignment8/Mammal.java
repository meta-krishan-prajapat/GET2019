package assignment8;

/**
 * @author krishan
 * Mammal class is the sub class of animal class
 */
public abstract class Mammal extends Animal {
	public final static String mammal = "Mammal";

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	Mammal(String name, int age, float weight) {
		super(name, age, weight);

	}

	/**
	 * @return the category of the animal
	 */
	public String getAnimalCategory() {
		return mammal;
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
