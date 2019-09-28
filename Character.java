package characters;

import realworld.Entity;

/**
 * This class represents a Character in the game. It is an abstract sub class of the Entity class.
 * It maintains a private integer instance variable representing the character's health points.
 * It also defines the super constructor that initialises all instance variables and a default constructor.
 * In addition, the class maintains two abstract methods, protected and private, and concrete public get and set 
 * methods for the healthPoints variable.
 * Two subclasses, Player and Monster, extend the Character class.
 * @author amrita sen 18048443
**/
public abstract class Character extends Entity
{
	private int healthPoints; // Private instance variable to store a positive number representing the character's health points.
	
	public Character(String description) // Class constructor that takes in the description as a parameter and instantiates all instance variables.
	{
		super(description);
		this.healthPoints = 100;			
	}
	
	public Character(){}; // Default constructor that sets all instance variables to null values.
	
	/**
	 * This is a protected abstract method which will be overridden in the Player and Monster subclasses.
	 * It does not take in any parameters.
	 * @return Integer value representing damage dealt in an attack.
	 * @author amrita sen 18048443
	 * */
	protected abstract int dealAttackDamage();  
	
	/**
	 * This is a public abstract method which will be overridden in the Player and Monster subclasses.
	 * @param An object of type Character.
	 * @return Integer value representing damage dealt in an attack.
	 * @author amrita sen 18048443
	 * */
	public abstract int defendAttack(Character enemy); 

	/**
	 * This is a public get method to get character's the health points. It does not take in any parameters.
	 * @return Integer value representing character's health points.
	 * @author amrita sen 18048443
	 * */
	public int getHealthPoints()  
	{
		return healthPoints;
	}

	/**
	 * This is a public void set method to set character's health points.
	 * If the number is less than or equal to zero, character's health will be set to 0.
	 * This method does not return any value.
	 * @param Integer value representing character's health points.
	 * @author amrita sen 18048443
	 * */
	public void setHealthPoints(int healthPoints)  
	{
		if(healthPoints >= 0)
		{
			this.healthPoints = healthPoints;
		}
	}
}
