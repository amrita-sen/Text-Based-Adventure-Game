package pickups;

/**
 * The Opener class is an abstract class extends the abstract Pickup class and represents and opener object.
 * It simply defines the super constructor.
 * @author amrita sen 18048443
**/
public abstract class Opener extends Pickup
{
	// Super constructor that takes in the object description as a parameter and initialises it.
	public Opener(String description) 
	{
		super(description);
	}

}
