package valuables;

import consumables.Valuable;

/**
 * The Coin class extends the abstract Valuable class and represents a Coin object that might be available in a room for the player to pickup
 * and admire.
 * It simply defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Coin extends Valuable
{
	/*Super constructor that takes in, as parameters, a String value representing the Coin description and an integer value 
	representing it's consumable value.*/
	public Coin(String description, int integer)
	{
		super(description, integer);		 
	}
}
