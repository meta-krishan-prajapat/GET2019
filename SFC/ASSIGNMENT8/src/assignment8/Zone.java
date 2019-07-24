package assignment8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krishan
 * zone class will create cages and their operational functions
 * zone class have its own functionality like zone id ,has park,has forest etc.
 * there can be multiple zones in a zoo.
 *
 */
public class Zone {
	protected final int maxCages;
	protected int cageCount=0;
	protected int zoneId=0;
	protected String animalCategory;
	protected String zoneName;
	protected boolean hasPark=false;
	protected boolean hasForest=false;
	protected List<Cage> cages;
	public Zone(String animalCategory,int maxCages,boolean hasPark,boolean hasForest,String name)
	{
		this.zoneName=name;
		this.zoneId++;
		this.maxCages=maxCages;
		this.animalCategory=animalCategory;
		this.hasForest=hasForest;
		this.hasPark=hasPark;
		this.cages=new ArrayList<Cage>();
	}

	/**
	 * @param animalType
	 * @param capacity
	 * @return true if cage can be added
	 */
	public Boolean addCage(String animalType,int capacity)
	{
		try
		{
		if(this.cageCount<this.maxCages)
		{
			cageCount++;
			Cage cage=new Cage(animalType,capacity);
			this.getCages().add(cage);
			return true;
		}
		
		}catch(Exception e)
        {
        	e.printStackTrace();
        }
		
			return false;
		
	}
	/**
	 * @param animalToBeAdded
	 * @return true if respective type of cage found
	 */
	public boolean addAnimalToCage(Animal animalToBeAdded){
        boolean cagefound = false;
        try
        {
            for(Cage x:getCages()) {
                if(x.getAnimalType() == animalToBeAdded.getAnimalType() && (! x.isFull()))  {
                    x.addAnimalToCage(animalToBeAdded);
                     cagefound = true;
                     return true;
                }
            }
            if(! cagefound) {
                System.out.println("Cage not Found :");
                if(addCage(animalToBeAdded.getAnimalType(), 3))
                    if(addAnimalToCage(animalToBeAdded))
                        return true;
                else
                    return false;
            }
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        return false;
    }
	/**
	 * displays data of each created zone
	 */
	public void display(){
		try {
        System.out.println("details Of Zone :" +zoneId +"  "+zoneName);
        System.out.println("Cage id  cage Animal Type  Cage Capacity  No of Animal In Cage" );
        for(Cage c: cages)
            System.out.println(c.getCageId() +" "+ c.getAnimalType() +" "+ c.getCageCapacity() +" " +c.getAnimalCapacityCount());
		}catch(Exception e)
        {
        	e.printStackTrace();
        }
		}
	/**
	 * @return cageCount
	 */
	public int getCageCount() {
		return cageCount;
	}
	
	/**
	 * @return animalCategory
	 */
	public String getAnimalCategory() {
		return animalCategory;
	}
	
	/**
	 * @return hasPark
	 */
	public boolean hasPark() {
		return hasPark;
	}
	
	/**
	 * @return hasForest
	 */
	public boolean hasForest() {
		return hasForest;
	}
	
	/**
	 * @return cages
	 */
	public List<Cage> getCages() {
		return cages;
	}
	
	/**
	 * @return maxCages
	 */
	public int getMaxCages() {
		return maxCages;
	}
	
	
}
