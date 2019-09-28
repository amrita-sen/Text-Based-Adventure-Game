package monsters;

import characters.Monster;

/**
 * The Ogre class extends the abstract Monster class and represents an Ogre that might appear in a room when a player enters.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Ogre extends Monster
{
	//Super constructor that takes in, as a parameter, an integer value representing appearance probability of an Ogre and sets it's description to "mad".
	public Ogre(int probability) 
	{
		super(probability);
		super.setDescription("mad");
	}
}
