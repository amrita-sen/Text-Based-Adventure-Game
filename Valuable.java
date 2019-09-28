package consumables;

import pickups.Consumable;

/**
 * The Valuable class is an abstract class that represents a valuable object and extends the abstract Consumable class.
 * All valuable objects can be a part of the pickups available in a room and can be removed and added to the player's inventory.
 * All valuable objects increase the player's confidence, when admired.
 * It maintains an instance variable of type integer to store the consumable value associated with a valuable object.
 * It also has a constructor that initialises the description and the consumable value, and get and set methods for the consumable value. 
 * @author amrita sen 18048443
**/
public abstract class Valuable extends Consumable
{
	private int consumableValue; // Instance variable of type integer to store a value representing a valuable object's consumable value.

	// Class Constructor that takes in description and consumable value as parameters and initialises them.
	public Valuable(String description, int consumableValue) 
	{
		super(description);
		this.consumableValue = consumableValue;
	}

	/**
	 * A public get method to get valuable object's consumable value. It does not take in any parameters.
	 * @return consumable value of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getConsumableValue() 
	{
		return consumableValue;
	}

	/**
	 * This is a public void set method to set valuable object's consumable value.
	 * This method does not return any value.
	 * @param Integer value representing valuable object's consumable value
	 * @author amrita sen 18048443
	 * */
	public void setConsumableValue(int consumableValue) 
	{
		this.consumableValue = consumableValue;
	}
}