package wieldables;

import pickups.Wieldable;

/**
 * The Sword class extends the abstract Wieldable class and represents a Sword that player can wield.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Sword extends Wieldable
{
	/*Super constructor that takes in a String value representing the Axe description and two integer values representing the high
	and low strength as parameters*/
	public Sword(String description, int high, int low) 
	{
		super(description, high, low);
	}
}
