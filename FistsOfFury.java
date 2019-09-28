package wieldables;

import pickups.Wieldable;

/**
 * The FistsOfFury class extends the abstract Wieldable class and represents a FistsOfFury object that player can wield.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class FistsOfFury extends Wieldable
{
	/*Super constructor that takes in a String value representing the Axe description and two integer values representing the high
	and low strength as parameters.*/
	public FistsOfFury(String description, int high, int low) 
	{
		super(description, high, low);
	}
}
