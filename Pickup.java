package pickups;

import realworld.Entity;

/**
 * The Pickup class is an abstract class extends the Entity class and represents a pickup object that might be in a room available for
 * player to pickup.
 * It defines the super constructor.
 * It has a second constructor that takes in a Pickup object and initialises content.
 * In addition, this class has get and set methods for the Pickup object variable.
 * @author amrita sen 18048443
**/
public abstract class Pickup extends Entity
{	
	private Pickup content; // Instance variable to store a Pickup object.

	//Super constructor that takes in a description as a parameter and initialises it.
	public Pickup(String description) 
	{
		super(description);
	}

	// Class constructor that takes in a Pickup object as a parameter and initialises it.
	public Pickup(Pickup content) 
	{
		 this.content = content;
	}

	/**
	 * A public get method to get Pickup content.  It does not take in any parameter.
	 * @return Pickup object content.
	 * @author author amrita sen 18048443
	 * */
	public Pickup getContent() 
	{
		return content;
	}

	/**
	 * This is a public void set method to set the Pickup object content.
	 * @param Pickup object content.
	 * @author amrita sen 18048443
	 * */
	public void setContent(Pickup content) 
	{
		this.content = content;
	}

}
	
	