package assignment8;

/**
 * @author krishan
 * Animal class is the base class of the zoo
 */
public abstract class Animal {
	private int age;
	private float weight;
	private final String name;
	private static int id = 0;

	/**
	 * @param name
	 * @param age
	 * @param weight function initialises the instance variables
	 */
	public Animal(String name, int age, float weight) {
		id++;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * @return the name of the animal
	 */
	public String getAnimalName() {
		return this.name;
	}

	/**
	 * @return age of the animal
	 */
	public int getAnimalAge() {
		return this.age;
	}

	/**
	 * @return weight of the animal
	 */
	public float getAnimalWeight() {
		return this.weight;
	}

	/**
	 * @return the Animal id
	 */
	public int getAnimalId() {
		return Animal.id;
	}

	/**
	 * @return the sound of particular type of animal
	 */
	public abstract String getAnimalSound();

	/**
	 * @return the type of animal
	 */
	public abstract String getAnimalType();

	/**
	 * @return the category of animal
	 */
	public abstract String getAnimalCategory();

}
