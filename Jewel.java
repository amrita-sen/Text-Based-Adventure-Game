package valuables;

import consumables.Valuable;

/**
 * The Jewel class extends the abstract Valuable class and represents a Jewel that might be available in a room for the player to pickup
 * and admire.
 * It simply defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Jewel extends Valuable
{
	/*Super constructor that takes in, as parameters, a String value representing the Jewel description and an integer value 
	representing it's consumable value.*/
	public Jewel(String description, int consumableValue) 
	{
		super(description, consumableValue);
	}
	
	
}
