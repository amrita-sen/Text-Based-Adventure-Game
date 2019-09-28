package food;

import consumables.Food;

/**
 * The RoastBoar class extends the abstract Food class and represents a RoastBoar that might be available in a room for the player to consume.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class RoastBoar extends Food
{
	/*Super constructor that takes in, as parameters, a String value representing the roastboar description and an integer value 
	representing it's health points.*/
	public RoastBoar(String description, int healthPoints) 
	{
		super(description, healthPoints);
	}

}
