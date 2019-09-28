package pickups;

/**
 * The Openable class is an abstract class extends the abstract Pickup class and represents an Openable object.
 * It defines two super constructors and maintains a boolean instance variable isLocked and a Pickup variable content.
 * In addition, it has an abstract method unlockWith(opener) and get and set methods for the instance variables.
 * @author amrita sen 18048443
**/
public abstract class Openable extends Pickup
{
	private boolean isLocked; // Private instance variable of type boolean to store the value representing if the object is locked.
	private Pickup content;  // Private Pickup object variable.
	

	public Openable(String description, Pickup content) 
	{
		super(description);
		this.content = content;
		this.isLocked = true;
	}
	
	public Openable(Pickup content) 
	{
		super(content);
		this.isLocked = true;
	}

	public abstract void unlockWith(Opener opener);

	public boolean getIsLocked() 
	{
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) 
	{
		this.isLocked = isLocked;
	}

	public Pickup getContent() 
	{
		return content;
	}

	public void setContent(Pickup content) 
	{
		this.content = content;
	}
}
