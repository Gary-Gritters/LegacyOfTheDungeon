import java.util.Scanner;

/***************************************************
 * This class runs an instance of the game with no
 * GUI. Everything is text based as an output from 
 * the console.
 *
 * @author Jarett Allie
 ***************************************************/
public class GameNoGUI {
	
    //The scanner which will hold the user's commands.
	private Scanner scan = new Scanner(System.in);
	
    //Initial definition of the map class.
	private Map m;
	
	/*********************************************
     * This starts a new game and then calls the 
     * choice() class which manages the game.
     *********************************************/
	public static void main(String[] args) 
	{
		//create new game instance
		GameNoGUI game = new GameNoGUI();
		//setup a new game
		game.startGame();
		//call choice() which is used to play the
		//game
		game.choice();
	}

	 /*********************************************
     * This prints a message at the start of the
     * game.
     *********************************************/
	private static void startMessage() 
	{
		System.out.println("Welcome to Legacy Of "
				+ "the Dungeon\n");
		System.out.println("Your journey will start"
				+ " soon after you create your "
				+ "character!");
		System.out.println("\nFeel free to type \"h\""
				+ " for help at any time.\n");
		System.out.println("This is the map where"
				+ " you will be starting your "
				+ "journey!");
	}
	
	/*********************************************
     * This methods gets the users input for what 
     * they want to do and then checks what
     * command it is.
     *********************************************/
	private void choice() 
	{
		System.out.println("_______________________"
				+ "_______________________________"
				+ "______________________");
		System.out.println("\nWhat would you like"
				+ " to do?");
		System.out.println("\nOptions in this "
				+ "release include \"h\" for help, "
				+ "\"i\" for inventory, and \"q\" "
				+ "for quit.");
		System.out.println("\nTo move your character, "
				+ "type one of the following:");
		System.out.println("N, S, E, or W");
		
		char input = scan.next().charAt(0);
		//when the player inputs a command, call 
		//commandCheck to check it
		commandCheck(input);
		
	}
	
	/*********************************************
     * This checks what command was input by the
     * user.
     * 
     * @param The command's character.
     *********************************************/
	private void commandCheck(char c) 
	{
		//use a switch case to check what command
		//will be called
		char c2 = Character.toLowerCase(c);
		switch(c2) {
		case 'h':
			helpMessage();
			break;
		case 'i':
			openInventory();
			break;
		case 'q':
			System.out.println("Game closed "
					+ "successfully.");
			System.out.println("Thank you for"
					+ " playing!");
			System.exit(0);
			break;
		default:
			//check to see if there was a movement
			//the player wanted to do
			if(c2 == 'n' || c2 == 'w' || c2 == 'e' 
			|| c2 == 's')
				move(c2);
			else
				//if no commands are valid keep
				//scanning until one is
				commandCheck(scan.next().charAt(0));
			break;
		}
	}
	
	
	/*********************************************
     * This opens the inventory for the player.
     *********************************************/
	private void openInventory() 
	{
		System.out.println("This feature "
				+ "is currently being implemented.");
		System.out.println("\n\nYour new position is: "
				+ m.getPlayerPos());
		m.printBoard();
		choice();

	}
	
	/*********************************************
     * This displays a help message.
     *********************************************/
	private void helpMessage() 
	{
		System.out.println("This feature is "
				+ "currently being implsemented.");
		System.out.println("\n\nYour new position is: "
				+ m.getPlayerPos());
		m.printBoard();
		choice();
	}

	/*********************************************
     * This moves the character's position in
     * Map.java. Then it checks if a new map has
     * to be created when the character reaches
     * the exit.
     * 
     * @param The command's character.
     *********************************************/
	private void move(char c) 
	{
		//move character on the map
		m.move(c);
		//check if the character has reached the exit
		if(m.checkFloorComplete()) {
			//if character reached exit, create new
			//map
			m = new Map();
			//restarts map
			m.startGame();
		}
		
		System.out.println("\n\nYour new position is: "
		+ m.getPlayerPos());
		//print board after moving
		m.printBoard();
		//go back to choice
		choice();
	}
	
	/*********************************************
     * This generates everything needed when
     * starting a new game.
     *********************************************/
	private void startGame() 
	{
		//create new instance of map
		m = new Map();
		//display first message
		startMessage();
		//start new instance of the map
		m.startGame();
		//print map
		m.printBoard();

	}
	
}
