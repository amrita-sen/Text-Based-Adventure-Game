package characters;

/**
  * This class represents a Monster in the game. It is an abstract sub class of the Character and defines the super constructor.
  * It maintains three private instance variables of type integer representing the monster's appearance probability, the amount of 
  * damage the Monster can deal in an attack and it's health points.
  * It implements the protected dealAttackDamage method and the public defendAttack method and defines the get and set method for 
  * the instance variables.
  * In addition, it also has an appear method that determines if a monster should appear in a room.
  * @author amrita sen 18048443
 **/
public abstract class Monster extends Character
{
	private int probability;   // Private instance variable to store an integer value representing the monster's appearance probability.
	private int damage;        // Private instance variable to store an integer value representing the damage amount, Monster can deal.
	private int healthPoints;  // Private instance variable to store an integer value representing the monster's health points
	
	public Monster(int probability) // Class Constructor that takes in probability and initialises the instance variables and the description.
	{
		super.setDescription(super.getDescription());
		this.healthPoints = 100;	
		this.probability = probability;			
		this.damage = 75;
	}
	
	/**
	 * A public get method to get the damage dealt by the monster in an attack. It does not take in any parameter.
	 * @return Integer value representing damage.
	 * @author author amrita sen 18048443
	 * */
	public int getDamage()  
	{
		return damage;
	}

	/**
	 * This is a public void set method to set monster's damage value.
	 * This method does not return any value.
	 * @param Integer value representing monster's damage value.
	 * @author amrita sen 18048443
	 * */
	public void setDamage(int damage) 
	{		
		this.damage = damage;
	}

	/**
	 * A public get method to get monster's health points. It does not take in any parameters.
	 * @return healthPoints of type integer.
	 * @author amrita sen 18048443
	 * */
	public int getHealthPoints() 
	{
		return healthPoints;
	}

	/**
	 * This is a public void set method to set monster's health points.
	 * If the number is less than or equal to zero, monster's health will be set to 0.
	 * This method does not return any value.
	 * @param Integer value representing monster's health points.
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
	 * A public get method to get the probability value of a monster appearing in a room. It does not take in any parameters.
	 * @return probability value of type type integer.
	 * @author amrita sen 18048443
	 * */
	public int getProbability() 
	{
		return probability;
	}

	/**
	 * This is a public void set method to set the probability value of a monster appearing in a room..
	 * This method does not return any value.
	 * @param Integer value representing monster's probability.
	 * @author amrita sen 18048443
	 * */
	public void setProbability(int probability) 
	{
		this.probability = probability;
	}
	
	/**
	 * This protected method overrides the dealAttackDamage method in the Character class. It does not take in any parameters.
	 * @return Integer value damage + r, where r is a randomly selected value between 1 and 10.
	 * @author amrita sen 18048443
	 * */
	@Override
	protected int dealAttackDamage() 
	{
		int value = this.damage + generateRandomNumber(1, 10);
		return value;
	}
	
	/**
	 * This public method overrides the defendAttackDamage method in the Character class.
	 * It simulates an incoming attack from an enemy character.
	 * It invokes d = enemy.dealAttackDamage() and reduces monster's health by d.
	 * @param An object of type Character representing monster's enemy (player).
	 * @return Value d of type integer representing how much damage was dealt to the monster.
	 * @author amrita sen 18048443
	 * */
	@Override
	public int defendAttack(Character enemy) 
	{
		int d = enemy.dealAttackDamage();		
		this.healthPoints -= d;		
		
		return d;
	}	
	
	/**
	 * This public method determines whether or not the monster appears in a room. It does not take in any parameters.
	 * @return boolean value. If the monster's health is 0, false is returned. Else, it true if x is less than or equal to it's
	 * probability value, where x is a random number between 0 and 101 exclusive.
	 * @author amrita sen 18048443
	 * */
	public boolean appears()
	{	
		if(this.healthPoints <= 0)
		{
			return false;
		}
		int x = generateRandomNumber(1, 100);
		
		return (x <= probability);
	}
}
