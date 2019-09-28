package characters;

import consumables.Food;
import consumables.Valuable;
import gameplay.Inventory;
import pickups.Wieldable;
import wieldables.Axe;
import wieldables.FistsOfFury;
import wieldables.Sword;

/**
 * This class represents a Player in the game and is a subclass of the abstract Character class.
 * It maintains six private instance variables representing the player's name, confidence value, healthPoints, damage, 
 * the player's weapon, and the player's inventory and  defines the super constructor. 
 * It implements the protected dealAttackDamage method and the public defendAttack method and defines the get and set method for 
 * the instance variables.
 * @author amrita sen 18048443
**/
public class Player extends Character
{
	private String name;          // Private instance variable to store a String representing the player's name.
	private int confidenceValue;  // Private instance variable to store an integer representing the player's confidence value.
	private int healthPoints;    // Private instance variable to store an integer representing the player's health points.
	private int damage;	         // Private instance variable to store an integer representing the damage dealt in an attack.
	private Wieldable weapon;    // Private instance of the Wieldable class representing player's weapon.
	private Inventory inventory; // Private instance of the Inventory class representing player's inventory, which is an array.
	
	// Class Constructor that takes in the player's name, description, healthpoints and confidence values and intialises them.
	public Player(String name, String description,  int healthPoints , int confidenceValue) 
	{
		super(description);
		this.name =  name;
		this.healthPoints = healthPoints;
		this.confidenceValue = confidenceValue;
		this.weapon = new FistsOfFury("FistsOfFury", 45, 10);
		this.inventory = new Inventory();
	}
	
	/**
	 * A public get method to get the damage dealt by the player in an attack.  It does not take in any parameter.
	 * @return Integer value representing damage.
	 * @author author amrita sen 18048443
	 * */
	public int getDamage() 
	{
		return damage;
	}

	/**
	 * This is a public void set method to set player's damage value.
	 * This method does not return any value.
	 * @param Integer value representing player's damage value.
	 * @author amrita sen 18048443
	 * */
	public void setDamage(int damage) 
	{
		this.damage = damage;
	}

	/**
	 * A public get method to get the player's name.  It does not take in any parameter.
	 * @return Player's name of type String.
	 * @author author amrita sen 18048443
	 * */
	public String getName() 
	{
		return name;
	}

	/**
	 * This is a public void set method to set player's name.
	 * This method does not return any value.
	 * @param String representing a name.
	 * @author amrita sen 18048443
	 * */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * A public get method to get the player's inventory.  It does not take in any parameter.
	 * @return Player's inventory of type Inventory.
	 * @author author amrita sen 18048443
	 * */
	public Inventory getInventory() 
	{
		return inventory;
	}

	/**
	 * This is a public void set method to set player's inventory.
	 * This method does not return any value.
	 * @param inventory of type Inventory.
	 * @author amrita sen 18048443
	 * */
	public void setInventory(Inventory inventory) 
	{
		this.inventory = inventory;
	}

	/**
	 * A public get method to get player's health points. It does not take in any parameters.
	 * @return healthPoints of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getHealthPoints() 
	{
		return healthPoints;
	}

	/**
	 * This is a public void set method to set player's health points.
	 * If the number is less than or equal to zero, player's health will be set to 0.
	 * This method does not return any value.
	 * @param Integer value representing player's health points.
	 * @author amrita sen 18048443
	 * */
	public void setHealthPoints(int healthPoints) 
	{
		if (healthPoints <= 0)
		{
			this.healthPoints = 0;
		}
		this.healthPoints = healthPoints;
	}
	
	/**
	 * A public get method to get player's Confidence Value. It does not take in any parameters.
	 * @return confidence value of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getConfidenceValue() 
	{
		return confidenceValue;
	}

	/**
	 * This is a public void set method to set player's confidence value.
	 * If the number is less than or equal to zero, player's confidence value will be set to 0.
	 * This method does not return any value.
	 * @param Integer value representing player's confidence value.
	 * @author amrita sen 18048443
	 * */
	public void setConfidenceValue(int confidenceValue) 
	{
		if (confidenceValue <= 0)
		{
			this.confidenceValue = 0;
		}
		this.confidenceValue = confidenceValue;
	}

	/**
	 * This protected method overrides the dealAttackDamage method in the Character class. It does not take in any parameters.
	 * It calculates the amount of damage dealt by the player's attack based on the formula damage = h + h * c / 100, where h 
	 * is the strength of the user's weapon (value returned by hit()) and c is the player confidence.
	 * @return Calculated integer value representing damage.
	 * @author amrita sen 18048443
	 * */
	@Override
	protected int dealAttackDamage() 
	{
		int h = this.weapon.hit();
		int c = this.confidenceValue;
		
		damage = h + h * c / 100;
		 
		return damage;
	}

	/**
	 * This public method overrides the defendAttackDamage method in the Character class.
	 * It simulates an incoming attack from an enemy character.
	 * It invokes d = enemy.dealAttackDamage() and reduces player's health by d.
	 * In addition, the player's confidence is decreased by (d/2).
	 * @param An object of type Character representing player's enemy (monster).
	 * @return Value d of type integer representing how much damage was dealt to the player.
	 * @author amrita sen 18048443
	 * */
	@Override
	public int defendAttack(Character enemy) 
	{	
		int d = enemy.dealAttackDamage();
		this.healthPoints -= d;
		this.confidenceValue -= (d / 2);		
		
		return d;
	}
	
	/**
	 * This public method increases the player's confidence with a valuable's value if a player admire's the valuable.
	 * It does not return any value.
	 * @param valuable object of type Valuable.
	 * @author amrita sen 18048443
	 * */
	public void admire(Valuable valuable) 
	{
		if(valuable.getConsumableValue() != 0)
		{
			this.confidenceValue += valuable.getConsumableValue();
		}
	}

	/**
	 * This public method increases the player's health points with a food item's value if a player eats it.
	 * It does not return any value.
	 * @param food object of type Food.
	 * @author amrita sen 18048443
	 * */
	public void eat(Food food) 
	{
		this.healthPoints += food.getHealthPoints();
	}
	
	/**
	 * This public method creates a weapon object for the player when called.
	 * It does not return any value and does not take in any parameter.
	 * @author amrita sen 18048443
	 * */
	public void createWeapon() 
	{
		if(this.weapon.getClass().getSimpleName() == "sword")
		{
			this.weapon = new Sword("Sword", 30, 39);	
		}
		else if(this.weapon.getClass().getSimpleName() == "axe")
		{
			this.weapon = new Axe("Heavy axe", 15, 30);	
		}
	}
	
	/**
	 * A public get method to get player's Wieldable weapon. It does not take in any parameters.
	 * @return weapon object.
	 * @author amrita sen 18048443
	 * */
	public Wieldable getWeapon() 
	{
		return weapon;	
	}

	/**
	 * This is a public void set method to set player's wieldable weapon.
	 * If the number is less than or equal to zero, player's confidence value will be set to 0.
	 * This method does not return any value.
	 * @param Wieldable object.
	 * @author amrita sen 18048443
	 * */
	public void setWeapon(Wieldable weapon)
	{
		this.weapon = weapon;
	}
	
	/**
	 * A public to String method that does not take in any parameter.
	 * @return a String representation of the values for Player class.
	 * @author amrita sen 18048443
	 * */
	@Override
	public String toString()
	{
		return name + " is wearing " + super.getDescription() + System.lineSeparator() + "Health: " +
				healthPoints + " Confidence: " + this.confidenceValue + " Wielding: " + this.weapon.getClass().getSimpleName();		
	}
}
