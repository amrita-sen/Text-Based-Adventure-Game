package openers;

import pickups.Opener;

/**
 * The Key class extends the abstract Opener class and represents a Key object and defines the constructor of the super class.
 * A Key opens a War Chest.
 * @author amrita sen 18048443
**/
public class Key extends Opener
{
	// Super constructor that takes in the Key description as a parameter.
	public Key(String description)
	{
		super(description);
	}

}
