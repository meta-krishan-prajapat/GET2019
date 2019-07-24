package assignment8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author krishan 
 * cage class have animals of same type,cage id and a fixed capacity of animals.
 */
public class Cage {
	private int animalCapacity;
	private int animalCapacityCount = 0;
	private String animalType;
	private int cageId;
	private int cageIdCount = 0;
	private List<Animal> animals;

	/**
	 * @param animalType
	 * @param animalCapacity function initialises the instance values
	 */
	public Cage(String animalType, int animalCapacity) {
		cageIdCount++;
		this.animalType = animalType;
		this.cageId = cageIdCount;
		this.animalCapacity = animalCapacity;
		this.animals = new ArrayList<Animal>();

	}

	/**
	 * @param animal
	 * @return function to add animal to the current cage
	 */
	public String addAnimalToCage(Animal animal) {
		if ((animal.getAnimalType() == this.animalType) && (this.animalCapacityCount < this.animalCapacity)) {
			this.animals.add(animal);
			return "Successfully added";

		} else {
			return "either the capacity is full or the Animal you want to add is not of the type of cage";
		}
	}

	/**
	 * @param animal function to remove element from cage
	 */
	public void removeAnimalFromCage(Animal animal) {
		try {
			if (animals.contains(animal)) {
				animals.remove(animal);
			} else {
				throw (new Exception("this animal doesnt exist in the current cage"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * display animals in cage
	 */
	public void displayAnimalsInCage() {
		Iterator<Animal> itr = animals.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}

	}

	/**
	 * @return animalCapacity
	 */
	public int getCageCapacity() {
		return animalCapacity;
	}

	/**
	 * @return animalType
	 */
	public String getAnimalType() {
		return animalType;
	}

	/**
	 * @return animals
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @return cageId
	 */
	public int getCageId() {
		return cageId;
	}

	/**
	 * @return true if cage is full
	 */
	public boolean isFull() {
		return animalCapacityCount >= animalCapacity;
	}

	/**
	 * @return animalCapacityCount
	 */
	public int getAnimalCapacityCount() {
		return animalCapacityCount;
	}
}
