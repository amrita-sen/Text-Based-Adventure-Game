package pickups;

/**
 * This abstract class represents a Wieldable object and is a sub class of the abstract Pickup class.
 * Wieldable objects can be a part of the Player's inventory as well as the Room's inventory.
 * A player can use a Wieldable object to hit if it is a part of his or her inventory.
 * This class has has three subclasses - Axe, Sword and FistsOfFury.
 * @author amrita sen 18048443
**/
public abstract class Wieldable extends Pickup  
{
	private int high;  // Private instance variable to store an integer high value.
	private int low;   // Private instance variable to store an integer low value.

	// Super Constructor that takes in description, and the high and low integer values and initialises the instance variables and description.
	public Wieldable(String description, int high, int low) 
	{
		super(description);
		this.high = high;
		this.low = low;
	}
	
	/**
	 * A public method to get the high value of a weapon. It does not take in any parameter.
	 * @return high of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getHigh() 
	{
		return high;
	}

	/**
	 * A public void method that takes in an integer value representing the high value and sets in the high variable.
	 * It does not return any value.
	 * @param high of type integer.
	 * @author amrita sen 18048443
	 * */
	public void setHigh(int high) 
	{
		this.high = high;
	}

	/**
	 * A public method to get the low value of a weapon. It does not take in any parameter.
	 * @return low of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getLow() 
	{
		return low;
	}

	/**
	 * A public void method that takes in an integer value representing the low value and sets in the low variable.
	 * It does not return any value.
	 * @param low of type integer.
	 * @author amrita sen 18048443
	 * */
	public void setLow(int low) 
	{
		this.low = low;
	}

	/**
	 * A public method determines the strength of a weapon when used to hit, based on the high and low value of a weapon. 
	 * @return randome number x such that x is greater than or equal to the low value and less than the high value.
	 * @author amrita sen 18048443
	 * */
	public int hit()
	{
		int x = generateRandomNumber(this.low, (this.high - 1));
		
		return x;
	}

}
