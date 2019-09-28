package monsters;

import characters.Monster;

/**
 * The Dragon class extends the abstract Monster class and represents a Dragon that might appear in a room when a player enters.
 * It defines the constructor of the super class.
 * @author amrita sen 18048443
**/
public class Dragon extends Monster
{
	/* Super constructor that takes in, as a parameter, an integer value representing appearance probability of a dragon and sets 
	 it's description to "green"*/
	public Dragon(int probability) 
	{
		super(probability);
		super.setDescription("green");
	}
}
