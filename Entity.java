package realworld;

import java.util.Random;

/**
 * The Entity class is an abstract class that represents an Entity object of this game. All objects in this game are direct or indirect
 * subclasses of the Entity class. t maintains a String variable representing the description of an entity of the game and another String 
 * variable representing it's id (unique identifier). It has default constructor and another constructor that takes a description and sets 
 * the id with a special code.
 * The class also has get and set methods for the description and a get method for the id .
 * This class also has protected method that generates a random number representing the randomized behaviour of the entities.
 * In addition, the class has a compareID(String) method and a toString method.
 * @author amrita sen 18048443
**/
public abstract class Entity 
{
	private String description;   // Private String instance variable to store the entity's description.
	private String id;            // Private String instance variable to store the entity's id.
	
	public Entity(){}               // Default class constructor that initialises all instance values to null.
	
	// Class constructor that take in the description and sets the id with the code and initialises the description.	
	public Entity(String description) 									
	{
		this.id = this.getClass().getSimpleName();
		this.description = description;
	}
	
	/**
	 * A public get method to get the entity description. It does not take in any parameter.
	 * @return description of type String.
	 * @author author amrita sen 18048443
	 * */
	public String getDescription()
	{
		return description;
	}

	/**
	 * This is a public void set method to set entity's description.
	 * This method does not return any value.
	 * @param String desciption.
	 * @author amrita sen 18048443
	 * */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * A public get method to get the entity's id. It does not take in any parameter.
	 * @return id of type integer.
	 * @author author amrita sen 18048443
	 * */
	public String getId()
	{
		return id;
	}
	
	/**
	 * This is a protected method takes in two integer values as parameters, and generates and returns a random integer value between
	 * the two integers.
	 * @param integer x representing lower of the two numbers.
	 * @param integer y representing higher of the two numbers.
	 * @return randomly generated integer number between integer x and y.
	 * @author amrita sen 18048443
	 * */
	protected int generateRandomNumber(int x, int y) // Protected method that returns a random integer between x and y.
	{
		return new Random().nextInt(y - x) + x;
	}
	
	/**
	 * This is public method determines if the argument is a String object represents the same sequence of characters as this object, 
	 * ignoring differences in case. It determines entity's id equality to given string
	 * @return randomly generated integer number between integer x and y.
	 * @author amrita sen 18048443
	 * */
	public boolean compareID(String anotherId)
	{
		return anotherId.equalsIgnoreCase(id);		
	}	
	
	/**
	 * This is public toString method that returns a String representation of the unique identifier, entity's id.
	 * @return Entiy's unique identifier, String id.
	 * @author amrita sen 18048443
	 * */
	public String toString()
	{
		return id;
	}
}
