package consumables;

import pickups.Consumable;

/**
 * The Food class is an abstract class that represents a Food object and extends the abstract Consumable class.
 * All food objects can be a part of the pickups available in a room and can be removed and added to the player's inventory.
 * All food objects increase the player's health, when consumed.
 * It maintains an instance variable of type integer to store the health points associated with a food object.
 * It also has a constructor that initialises the description and the health points, and get and set methods for the health
 * points. 
 * @author amrita sen 18048443
**/
public abstract class Food extends Consumable
{
	private int healthPoints; // Instance variable of type integer to store a value representing a food object's health points.
	
	// Class Constructor that takes in description and health points as parameters and initialises them.
	public Food(String description, int healthPoints) 
	{
		super(description);
		this.healthPoints = healthPoints;
	}

	/**
	 * A public get method to get food object's health points. It does not take in any parameters.
	 * @return healthPoints of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getHealthPoints() 
	{
		return healthPoints;
	}

	/**
	 * This is a public void set method to set food object's health points.
	 * This method does not return any value.
	 * @param Integer value representing food object's health points.
	 * @author amrita sen 18048443
	 * */
	public void setHealthPoints(int healthPoints) 
	{
		this.healthPoints = healthPoints;
	}
	
}
