package assignment8;

/**
 * @author krishan
 * Sparrow is the sub class of Bird
 */
public class Sparrow extends Bird {

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	public Sparrow(String name, int age, float weight) {
		super(name, age, weight);

	}

	/**
	 * @return the sound of animal
	 */
	@Override
	public String getAnimalSound() {

		return "Sparrow sound";
	}

	/**
	 * @return the type of animal
	 */
	@Override
	public String getAnimalType() {

		return "Sparrow";
	}
}
