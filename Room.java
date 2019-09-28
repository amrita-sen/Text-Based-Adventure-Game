package entities;

import characters.Monster;
import gameplay.Inventory;
import monsters.Dragon;
import monsters.Ogre;
import monsters.Zombie;
import realworld.Entity;

/**
 * This class represents a Room object in this game and is a sub class of the World class.
 * The player will have to traverse through a maze of five interconnected rooms in order to escape. 
 * Room objects are created by the static readFile method in the ReadWorldDataFile class.
 * @author amrita sen 18048443
**/
public class Room extends Entity
{	
	private Monster monster;         // A private instance variable of the monster object.  
	private Inventory pickupsInRoom; // A private instance variable of the inventory object representing a list of pickups available.
	private Room[] connectingRooms;  // A private instance variable to store an array of connecting rooms.
	private boolean finalRoom;       // A private instance variable to store a boolean value for final room.
	
	public Room() { }  // Default constructor that sets all instance variables to null values.
	
	// Super constructor that takes in the description, pickups in room and an array of connecting rooms and initialises all instance variables.
	public Room(String description, Inventory pickupsInRoom, Room[] connectingRooms) 
	{
		super(description);		
		this.pickupsInRoom = pickupsInRoom;
		this.monster = new Zombie(33);
		this.finalRoom = false;
	}
	
	/**
	 * A public method to get the true or false value if the current room is a final room. It does not take in any parameter.
	 * @return True if room is final room.
	 * @author amrita sen 18048443
	 * */
	public boolean getIsFinalRoom() 
	{
		return finalRoom;
	}
	
	/**
	 * A public void method to set the boolean value of finalRoom to true or false. It does not return any value.
	 * @param boolean isFinalRoom
	 * @author amrita sen 18048443
	 * */
	public void setFinalRoom(boolean isFinalRoom) 
	{
		this.finalRoom = isFinalRoom;
	}
	
	/**
	 * A public method to get the array of connecting rooms. It does not take in any parameter.
	 * @return connectingRooms which is an Array of room objects.
	 * @author amrita sen 18048443
	 * */
	public Room[] getConnectingRooms() 
	{
		return connectingRooms;
	}
	
	/**
	 * A public void method that takes in an array of room objects and sets in the connectingRooms variable. It does not return any value.
	 * @param Array of room objects.
	 * @author amrita sen 18048443
	 * */
	public void setConnectingRooms(Room[] connectingRooms) 
	{
		this.connectingRooms = connectingRooms;
	}

	/**
	 * A public method that will create a monster object in a room when called and saves it in the Room instance variable of Monster object.
	 * It does not take in any parameter and does not return any value.
	 * @author amrita sen 18048443
	 * */
	public void createMonster() 
	{	
		this.monster = new Ogre(33);
		this.monster = new Zombie(40);
		this.monster = new Dragon(33);
	}
	
	/**
	 * A public method to get a Monster object. It does not take in any parameter.
	 * @return Monster object.
	 * @author amrita sen 18048443
	 * */
	public Monster getMonster() 
	{			
		return monster;
	}
	
	/**
	 * A public void method that takes in a Monster object and saves it in the Room instance of the Monster object. 
	 * It does not return any value.
	 * @param Monster object.
	 * @author amrita sen 18048443
	 * */
	public void setMonster(Monster monster) 
	{
		this.monster = monster;
	}

	/**
	 * A public method to get the pickups in a room. It does not take in any parameter.
	 * @return pickupsInRoom of type Inventory.
	 * @author amrita sen 18048443
	 * */
	public Inventory getPickupsInRoom() 
	{
		return pickupsInRoom;
	}
	
	/**
	 * A public void method that takes in an Inventory object and sets in the pickups variable. It does not return any value.
	 * @param Inventory object instance pickups.
	 * @author amrita sen 18048443
	 * */
	public void setPickupsInRoom(Inventory pickups) 
	{
		this.pickupsInRoom = pickups;
	}	
}
