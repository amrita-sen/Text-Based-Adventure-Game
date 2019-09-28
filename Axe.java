package wieldables;

import pickups.Wieldable;

/**
 * The Axe class extends the abstract Wieldable class and represents an Axe that player can pickup and wield.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Axe extends Wieldable
{
	/*Super constructor that takes in a String value representing the Axe description and two integer values representing the high
	and low strength as parameters.*/
	public Axe(String description, int high, int low) 
	{
		super(description, high, low);
	}
}
