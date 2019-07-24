package assignment8;

/**
 * @author krishan 
 * Peacock is the sub class of Bird
 */
public class Peacock extends Bird {

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	public Peacock(String name, int age, float weight) {
		super(name, age, weight);

	}

	/**
	 * @return the sound of animal
	 */
	@Override
	public String getAnimalSound() {

		return "peacock sound";
	}

	/**
	 * @return the type of animal
	 */
	@Override
	public String getAnimalType() {

		return "Peacock";
	}
}
