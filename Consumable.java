package pickups;

/**
 * The Consumable class is an abstract class extends the abstract Pickup class and represents a Consumable object.
 * It defines the super constructor and maintains  a boolean instance variable to determine if an object has been consumed.
 * @author amrita sen 18048443
**/
public abstract class Consumable extends Pickup
{
	private boolean isConsumed; // A private boolean instance variable to determine if an object has been consumed.

	// Super constructor that takes in description of an object and sets isConsumed to false.
	public Consumable(String description) 
	{
		super(description);
		this.isConsumed = false;
	}

	/**
	 * A public get method to get isConsumed.  It does not take in any parameter.
	 * @return boolean isConsumed. 
	 * @author author amrita sen 18048443
	 * */
	public boolean getIsConsumed() 
	{
		return isConsumed;
	}
	
	/**
	 * This is a public void set method to set the isConsumed value.
	 * @param boolean isConsumed.
	 * @author amrita sen 18048443
	 * */
	public void setIsConsumed(boolean isConsumed) 
	{
		this.isConsumed = isConsumed;
	}
}
