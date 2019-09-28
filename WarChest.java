package openables;

import pickups.Openable;
import pickups.Opener;
import pickups.Pickup;

/**
 * The WarChest class represents a War Chest object that could be available in the room for the player to unlock.
 * It extends the abstract Openable class. 
 * It defines the two constructors of the super class and implements the unlockWith(Opener opener) method.
 * @author amrita sen 18048443
**/
public class WarChest extends Openable
{	
	public WarChest(String description, Pickup content)   // Super constructor that takes in a description and a Pickup object as parameters.
	{
		super(description, content);
		super.setIsLocked(getIsLocked());
	}

	public WarChest(Pickup content)                   // Super constructor that takes in only a Pickup object as a parameter.
	{
		super(content);
		super.setIsLocked(getIsLocked());
	}

	/**
	 * This public method invokes the getIsLocked() from the super class and, if true, sets it to false.
	 * It takes in an Opener object but does not return any value.
	 * @param Opener object
	 * @author amrita sen 18048443
	 * */
	@Override
	public void unlockWith(Opener opener) 
	{
		if(super.getIsLocked() == true)
		{
			super.setIsLocked(false);		
		}
	}

}
