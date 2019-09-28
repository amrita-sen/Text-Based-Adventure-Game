package valuables;

import consumables.Valuable;

/**
 * The Mobile class extends the abstract Valuable class and represents a Mobile phone that might be available in a room for the player to pickup
 * and admire.
 * It simply defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Mobile extends Valuable
{
	/*Super constructor that takes in, as parameters, a String value representing the Mobile description and an integer value 
	representing it's consumable value.*/
	public Mobile(String description, int integer) 
	{
		super(description, integer);
	}
}
