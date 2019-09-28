package gameplay;

import java.util.Scanner;
import characters.Monster;
import characters.Player;
import consumables.Food;
import consumables.Valuable;
import entities.Room;
import openables.TreasureChest;
import openables.WarChest;
import openers.Key;
import openers.LockPick;
import pickups.Pickup;

/**
 * This class represents a World object the game will be played in.  
 * It implements a single main method with core playable functionality code to create World and Player objects and invoke a play(Payer) method.
 * @author amrita sen 18048443
**/
public class World 
{	
	private boolean gameInProgress; // A private instance variable to store a boolean value determining if a game is in progress. 
	private Room currentRoom;       // A private instance variable of the Room object.  
	private PlayMode mode;          // A private instance variable of the PlayMode object.  
	private Player player;          // A private instance variable of the monster object.  

	public enum PlayMode {battle,explore;} // An enum containing the options of modes of play. 

	/* Class constructor that takes in a Room object representing the current room, a player will begin the game in and initialises
	the currentRoom and sets gameInProgress to true. */
	public World(Room currentRoom) 
	{
		 this.currentRoom = currentRoom;
		 this.gameInProgress = true;	
	}
	
	//--------------------------------------------------------
	/**
	 * This private method is essentially while loop to process input from the player depending on the current mode of play - battle or explore.
	 * The while loop continues until the game stops.
	 * @param Player object player.
	 * @author amrita sen 18048443
	 * */
	private void play(Player player)
	{
		this.player = player;
		
		//Displays text that provides some instructions about the game.
		System.out.println("Welcome player " + this.player.getName() + " to the Monster Maze!");
		System.out.println();
		System.out.println("The Gameplay: ");
		System.out.println("Traverse through this maze of five interconnected rooms in your quest to escape through the exit. As you explore each room,");
		System.out.println("pickup items and build your inventory. You might then be able to, admire a valuable, eat a food item, open a treasure or warchest,");
		System.out.println("or wield a weapon against a monster that may randomly appear!");
		System.out.println("But beware! If your health points deplete to zero in a battle with a monster, you will lose the game!");
		System.out.println("Good luck! Let the adventure begin!");
		System.out.println();
		System.out.println("Brave " + this.player.getName() + " enters the maze.");
		System.out.println();
		System.out.println(player);
		
		this.onEnterRoom();
		
		while(gameInProgress)
		{
			switch(this.mode)
			{
				case explore:
					processExploreUserInput();
					break;
				case battle:
					processBattleUserInput();             
					break;
				default:
					break;
			}
		}
	}
	
	//--------------------------------------------------------
	/**
	 * This private method simulates a scenario that will be created when a player enters a room.
	 * If a monster appears, the play mode is set to battle else it is set to explore.
	 * @author amrita sen 18048443
	 * */
	private void onEnterRoom()
	{
		System.out.println(currentRoom.getDescription());

    	this.currentRoom.createMonster();
		Monster monster = this.currentRoom.getMonster();
		
		if(monster != null)
		{ 
			boolean appears = monster.appears();
			
			if(appears)
			{
				System.out.println("A "+ monster.getClass().getSimpleName() +" draws hither!");
				this.player.createWeapon();
				System.out.println(player.getName() + " wields " + this.player.getWeapon() + " and is ready for battle!");
				readyBattleMode();
			}
			else
			{
				readyExploreMode();
			}
		}
	}
	
	//--------------------------------------------------------
	
	Scanner keyboard = new Scanner(System.in); // New instance of scanner object created to take in user input.
	
	/**
	 * This private method prompts the user for an input and processes it according  to the given commands available in the explore mode.
	 * @author amrita sen 18048443
	 * */
	private void processExploreUserInput()
	{		
		System.out.print("?> ");		
		String inputCmd = keyboard.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" ");
		String exploreCommand = tokens[0];

		switch(exploreCommand)
		{
			case "door":
				openDoor(tokens[1]);
				break;		
			case "pickup":  
				pickup(tokens[1]);				
				break;
			case "exit":
				findExit();
				break;
			case "describe":
				describe();
				break;
			case "admire":
				admire(tokens[1]);
				break;
			case "eat":
				eat(tokens[1]);
				break;
			case "stats":
				stats();
				break;
			case "wield":
				wield(tokens[1]);
				break;
			case "open":
				open(tokens[1]);
				break;
			case "help":
				help();
				break;
			case "quit":
				quit();
				break;
			default:
				System.out.println("Your command is invalid! Please choose one from the given options.");
				help();
				break;
		}
	}		
	
	/**
	 * This private method prompts the user for an input and processes it according  to the given commands available in the battle mode.
	 * @author amrita sen 18048443
	 * */
	private void processBattleUserInput()
	{
		System.out.print("!> ");		
		String inputCmd = keyboard.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" ");
		
		String battleCommand = tokens[0];
		
		switch(battleCommand)
		{
			case "attack":
				attack();
				break;
			case "wield":
				wield(tokens[1]);
				break;
			case "help":
				help();
				break;
			case "quit":
				quit();
				break;
			default:
				System.out.println("Your command is invalid! Please choose one from the given options.");
				help();
				break;
		}		
	}
	
	//--------------------------------------------------------
	/**
	 * This private method processes the explore command door based on user input, and simulates the opening of the chosen door number.
	 * It also alerts the user if an invalid input has been entered.
	 * @param String value representing door number.
	 * @author amrita sen 18048443
	 * */
    private void openDoor(String door)
	{ 		
	  try 
      { 
          // checking valid integer using parseInt() method 
		  Integer.parseInt(door); 
		  
		  int doorNumber = Integer.parseInt(door) - 1;
		  
		  if (doorNumber < this.currentRoom.getConnectingRooms().length && doorNumber >= 0)
		  {
				this.currentRoom = this.currentRoom.getConnectingRooms()[doorNumber];
				System.out.println(this.player.getName() + " bravely opens door " + door);
				this.currentRoom.getDescription();
				onEnterRoom();
		  }
		  else
		  {
			System.out.println("Oops! There is no door number " + door + " in this room. Enter a number not less than 1"
							   + "and not greater than the number of doors in the room.");
			System.out.println("Check the number of doors in the room  using the \"describe\" command and try again!");
		  }		
      }  
      catch (NumberFormatException e)  
      { 
          System.out.println("Oops! Looks like you haven't entered a number. " + door + " must be a number not greater than the number of doors "
          					+ "in the room. Check the number of doors in the room  using the \"describe\" command and try again!"); 
      }
	}
	
    /**
	 * This private method processes the explore command pickup based on user input, and simulates the picking up of the chosen item.
	 * The method determines if the item is available in the room for pickup and then, removes it from the room inventory
	 * and adds it to the player's inventory.
	 * @param String value representing an item the user wishes to pickup.
	 * @author amrita sen 18048443
	 * */
	private void pickup(String id)
	{
		// If the current room has pickups, execute the code that follows, else display the else statement.		
		if(this.currentRoom.getPickupsInRoom() != null) 
		{
			if(this.currentRoom.getPickupsInRoom().select(id) != null)
			{
				Pickup pickup = this.currentRoom.getPickupsInRoom().select(id); 
				{					
					System.out.println(this.player.getName() + " picks up the "  +  pickup.getClass().getSimpleName() + "." );
					this.player.getInventory().add(pickup);	
					this.currentRoom.getPickupsInRoom().remove(id);
				}		
			}
			else  
			{
				System.out.println("Oh no! This room does not have any " + id + "." );
			}
		}
		else
		{
			System.out.println("There are no items in this room to pickup!" );
		}
	}
	
   /**
	 * This private method processes the explore command exit and simulates the searching of the current room for an exit.
	 * If the current room is a final room, the player will find the exit else the player is prompted to search again.
	 * The game ends if the player manages to find the exit.
	 * @author amrita sen 18048443
	 * */
	private void findExit()
	{
		// If the current room is the final room, execute the code that follows, else display the else statement.		
		if(this.currentRoom.getIsFinalRoom())
		{
			System.out.println(player.getName() + " searched everywhere for the exit....\r\n" + 
				"     ...and behold, found it.");
			System.out.println("Well done brave " + player.getName() +". Your quest has now ended.");
			gameInProgress = false;
		}
		else
		{
			System.out.println("Exit not found! Try again.");
		}
	}
	
   /**
	 * This private method processes the explore command describe and displays the description of the current room followed by a list of 
	 * pickups available in the room when invoked.
	 * @author amrita sen 18048443
	 * */
	private void describe()
	{
		System.out.println(this.currentRoom.getDescription());
		
		// for statement to display pickups in the current room.
		for(Pickup pickup: this.currentRoom.getPickupsInRoom().getItems()) 
		{
			System.out.println("There is a " + pickup.getClass().getSimpleName() + " on the floor.");
		}
				
		int numberOfDoors = this.currentRoom.getConnectingRooms().length;		// Integer variable to store value representing number of rooms.
		System.out.println("There are " + numberOfDoors + " doors.");
	}
	
   /**
	 * This private method processes the explore command admire based on user input, and simulates the admiring of a valuable if it is
	 * available in the player's inventory.This method invokes the admire method from the Player class that increase player's confidence 
	 * value by the consumable value associated with the valuable. 
	 * The valuable may be admired only once to increase confidence, but it is not removed from the player's inventory.
	 * @param  String value representing an item the user wishes to admire.
	 * @author amrita sen 18048443
	 * */
	private void admire(String id)
	{
		// If the chosen item is in the player's inventory, execute the code that follows, else display the else statement.		
		if(this.player.getInventory().select(id) != null)
		{
			Pickup pickup = player.getInventory().select(id);		
			Valuable valuable = (Valuable) pickup;		
			
			if(valuable.getIsConsumed() == false)
			{
				this.player.admire(valuable);				
				System.out.println(this.player.getName() + " admires " + pickup.getDescription()); 
				System.out.println(this.player.getName() + "'s confidence increases by " + valuable.getConsumableValue() + " points!");
				valuable.setIsConsumed(true);
			}
			else
			{
				System.out.println("Oops! Looks like " + this.player.getName() + " has already admired this valuable! "
						            + "It cannot be admired again.");
			}
		}	
		else
		{
			System.out.println(this.player.getName() + " does not have this valuable in his inventory to admire!"); 
		}
		
	}
	
   /**
	 * This private method processes the explore command admire based on user input, and simulates the eating of a food object if it is
	 * available in the player's inventory.This method invokes the eat method from the Player class that increase player's health 
	 * value by the health value associated with the food object. 
	 * The food object may be consumed only once to increase health points and then is removed from the player's inventory.
	 * @param  String value representing an item the user wishes to eat.
	 * @author amrita sen 18048443
	 * */
	private void eat(String id)
	{
		// If the chosen item is in the player's inventory, execute the code that follows, else display the else statement.
		if(this.player.getInventory().select(id) != null)
		{
			Pickup pickup = player.getInventory().select(id);		
			Food food = (Food) pickup;	
			
			if(food.getIsConsumed() == false)
			{
				this.player.eat(food);		
				this.player.getInventory().remove(food);
				System.out.println("Brave " + this.player.getName() + " ate the " + pickup.getClass().getSimpleName() + 
									" increasing his health by " + food.getHealthPoints() + " points!");				
				food.setIsConsumed(true);
			}
		}
		else
		{
			System.out.println("Brave " + this.player.getName() + " could not find a " + id + " in his inventory");					
		}
	}
	
   /**
	 * This private method processes the explore command stats and displays the player's health, confidence points and inventory.
	 * @author amrita sen 18048443
	 * */
	private void stats()	
	{
		System.out.println(this.player);
		System.out.println("Brave " + this.player.getName() + " is carrying the following items: " + this.player.getInventory());
	}
		
   /**
	 * This private method processes the command wield based on user input, and simulates the wielding of a weapon.
	 * A weapon must be in the player's inventory for the player to be able to wield it. Otherwise, by default the player is able to 
	 * wield his fists of fury.
	 * @param String value representing the weapon the user wishes to wield.
	 * @author amrita sen 18048443
	 * */
	private void wield(String id)
	{
		// If the chosen item is in the player's inventory, execute the code that follows, else display the else statement.
		if(player.getInventory().select(id) != null)
		{
			Pickup pickup = player.getInventory().select(id);					
			System.out.println("Brave " + this.player.getName() + " wields the " + pickup.getClass().getSimpleName());
		}
		else
		{
			System.out.println("Oh no! " + this.player.getName() + " does not have the chosen weapon in his inventory to wield."); 
			System.out.println("Brave " + this.player.getName() + " wields his powerful " + this.player.getWeapon() + " instead and is ready for battle!");		
		}		
	}
		
   /**
	 * This private method processes the explore open command based on user input, and simulates the opening of a treasure chest or a 
	 * war chest. A Key object is required to open the treasure chest and a LockPick object is required to open a war chest.
	 * Once the chest is opened, the contents (treasure or a weapon) are added to the player's inventory and both the key and chest are 
	 * removed from inventory.
	 * @param String value representing a treasure of a war chest.
	 * @author amrita sen 18048443
	 * */
	private void open(String id)
	{
		// If there are pickups available in the room, execute the code that follows, else display the else statement.
		if(this.currentRoom.getPickupsInRoom() != null) 
		{
			if(this.player.getInventory() != null)
			{
				if(id == "treasure chest")
				{
					if(player.getInventory().select("Key") == null)
					{
						System.out.println("Oh no! You do not have a key to open the " + id + ".");
					}
					else
					{	
						Pickup pickup = player.getInventory().select("Key");
						Key treasureChestKey = (Key) pickup;
						
						if(this.currentRoom.getPickupsInRoom().select("TreasureChest") == null)
						{
							System.out.println("Oops. The room does not have a " + id + "  to open.");
						}
						else
						{
							Pickup treasureChest = this.currentRoom.getPickupsInRoom().select("TreasureChest");
							TreasureChest newTreasureChest = (TreasureChest) treasureChest;	
							newTreasureChest.unlockWith(treasureChestKey);	
							Pickup treasure = treasureChest.getContent();	
							this.player.getInventory().remove(treasureChestKey);
							this.currentRoom.getPickupsInRoom().remove(newTreasureChest);;
							this.player.getInventory().add(treasure);
						}
					}
				}		
				else if (id == "war chest")
				{
					if(player.getInventory().select("LockPick") == null)
					{
						System.out.println("Oh no! You do not have a key to open the war chest.");
					}
					else
					{	
						Pickup anotherPickup = player.getInventory().select("LockPick");
						LockPick warChestKey = (LockPick) anotherPickup;
						
						if(this.currentRoom.getPickupsInRoom().select("WarChest") == null)
						{
							System.out.println("Oops. The room does not have a WarChest to open.");
						}
						else
						{
							Pickup warChest = this.currentRoom.getPickupsInRoom().select("WarChest");
							WarChest newWarChest = (WarChest) warChest;					
							newWarChest.unlockWith(warChestKey);					
							Pickup weapon = warChest.getContent();	
							this.player.getInventory().remove(warChestKey);
							this.currentRoom.getPickupsInRoom().remove(warChest);;
							this.player.getInventory().add(weapon);
					    }
				    }
			    }
				else
				{
					System.out.println("Oh no! " + this.player.getName() + " does not have the appropriate key in his inventory or there is no chest in this room!");
				}
			}
		}
	}
	
 /**
	 * This private method processes the battle command attack and simulates the action of attacking a monster.
	 * This method invokes the defendAttack method from the player and monster class which decrease the players health and confidence
	 * when attacked by the monster and decreases the monster's health when attacked by the player.
	 * If the player's health decrease to 0 before the monster's, player loses the game, else continues to explore the room.
	 * @author amrita sen 18048443
	 * */
	private void attack()
	{
		Monster monster = this.currentRoom.getMonster();
		
		System.out.println(player.getName() +  " attacks " + monster.getDescription() + " " +  this.currentRoom.getMonster().getClass().getSimpleName());
						  
		this.player.getWeapon().hit();
		
		int monsterDamage = this.player.defendAttack(monster); // Integer variable to store damage dealt by a monster in an attack.
		int playerDamage = monster.defendAttack(player);       // Integer variable to store damage dealt by a player in an attack.
		
		System.out.println("The " + monster.getDescription() + " " + monster.getClass().getSimpleName() + " sustains " + playerDamage + " damage");  	
		System.out.println("The " + monster.getClass().getSimpleName() + " attacks!");

		//Game ends if player health points decrease to 0. Else, player can continue to explore the maze.
		if (this.player.getHealthPoints() <= 0)
		{
			this.player.setHealthPoints(0);
			System.out.println(this.player.getName() + " has sustained " + monsterDamage + " damage!");	
			System.out.println(this.player);			
			System.out.println("Alas! " + this.player.getName() + " has been defeated!");
			System.out.println("You have failed your quest.");
			gameInProgress = false;
		}
		else if(monster.getHealthPoints() <= 0)
		{
			System.out.println("Brave " + this.player.getName() + " has defeated the " + monster.getClass().getSimpleName() + "!");
			System.out.println("You can continue to explore the maze...");
			
			readyExploreMode();
		}
		else
		{
			System.out.println(this.player.getName() + " has sustained " + monsterDamage + " damage!");	
		}
	} 
 	
   /**
	 * This private method processes the help command, and displays the list of commands available depending on the mode the game is
	 * currently in.
	 * @author amrita sen 18048443
	 * */
	private void help() 
	{
		switch(this.mode)
		{
			case explore:
				System.out.println("Explore commands (choose one): admire (valuable item of choice), describe (current room), door (opens door of chosen number), eat (food item of choice),");
				System.out.println("                               exit (search room for exit), help (displays explorer commands), open (treasure chest or war chest),");
				System.out.println("                               pickup (item of choice), quit (end game), stats (displays player stats), wield (weapon of choice)");				
				break;
			case battle:
				System.out.println("Battle command (choose one): attack, wield (weapon of choice), help (displays battle commands), quit (end game)");             
				break;
			default:
				break;
		}
	}
	
   /**
	 * This private method processes the quit command, and simply ends the game by setting the game InProgress value to false when invoked.
	 * @author amrita sen 18048443
	 * */
	private void quit()
	{
		gameInProgress = false;		
		System.out.println("Oh no! You have ended the game. Goodye... chicken!");
	}
	
	//--------------------------------------------------------
	/**
	 * This private method sets the current play mode to battle and displays the commands available in that mode.
	 * @author amrita sen 18048443
	 * */
	private void readyBattleMode()
	{
		this.mode = PlayMode.battle;
		help(); // Displays commands available in battle mode.
	}
	
	/**
	 * This private method sets the current play mode to explore and displays the commands available in that mode.
	 * @author amrita sen 18048443
	 * */
	private void readyExploreMode()
	{
		this.mode = PlayMode.explore;
		help();  // Displays commands available in explore mode.
	}
		
	//--------------------------------------------------------
	/**
	 * This method invokes and implements the play method.
	 * @author amrita sen 18048443
	 * */
	public static void main(String[] args) 
	{
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("Sir Kendric","Shiny Armour",100,50);
		world.play(playerOne);		
	}
}
