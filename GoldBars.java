package valuables;

import consumables.Valuable;

/**
 * The GoldBars class extends the abstract Valuable class and represents a GoldBar object that might be available in a room for the player to pickup
 * and admire.
 * It simply defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class GoldBars extends Valuable
{
	/*Super constructor that takes in, as parameters, a String value representing the GoldBars description and an integer value 
	representing it's consumable value.*/
	public GoldBars(String description, int integer) 
	{
		super(description, integer);
	}
}
