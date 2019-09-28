package monsters;

import characters.Monster;

/**
 * The Zombie class extends the abstract Monster class and represents an Zombie that might appear in a room when a player enters.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Zombie extends Monster
{	
	//Super constructor that takes in, as a parameter, an integer value representing appearance probability of an Ogre and sets it's description to "mad".
	public Zombie(int probability) 
	{
		super(probability);
		super.setDescription("slow moving");
	}
}
