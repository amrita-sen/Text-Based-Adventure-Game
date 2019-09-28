package openers;

import pickups.Opener;

/**
 * The LockPick class extends the abstract Opener class and represents a LockPick object and defines the constructor of the super class.
 * A LockPick opens a War Chest.
 * @author amrita sen 18048443
**/
public class LockPick extends Opener
{
	// Super constructor that takes in the Key description as a parameter.
	public LockPick(String description) 
	{
		super(description);
	}

}
