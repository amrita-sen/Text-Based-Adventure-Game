package food;

import consumables.Food;

/**
 * The Bread class extends the abstract Food class and represents a Bread object that might be available in a room for the player to pickup and consume.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Bread extends Food
{
	/*Super constructor that takes in, as parameters, a String value representing the bread description and an integer value 
	representing it's health points.*/
	public Bread(String description, int healthPoints) 
	{
		super(description, healthPoints);
	} 
}
