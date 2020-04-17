import java.util.Scanner;

public class GameNoGUI {
	//DEFINE vars
	private Scanner scan = new Scanner(System.in);
	private Map m;
	
	
	public static void main(String[] args) {
		//start new game instance
		GameNoGUI game = new GameNoGUI();
		game.startGame();
		game.choice();
	}

	//displayed once
	private static void startMessage() {
		System.out.println("Welcome to Legacy Of the Dungeon\n");
		System.out.println("Your journey will start soon after you create your character!");
		//insert creation
		System.out.println("\nFeel free to type \"h\" for help at any time.\n");
		//enter description of commands
		//command "help" will display above
		//create method calls for each command
		System.out.println("This is the map where you will be starting your journey!");
		
		
	}
	
	//this method responds to what the player wants to do
	private void choice() {
		//check game is still valid/active
		System.out.println("\nWhat would you like to do?");
		System.out.println("\nOptions in this release include \"h\" for help, \"i\" for inventory, and \"q\" for quit.");
		System.out.println("\nTo move your character, type one of the following:");
		System.out.println("N,S,E, or W");
		char input = scan.next().charAt(0);
		//when the player moves call move function
		commandCheck(input);
		
	}
	
	private void commandCheck(char c) {
		switch(c) {
		case 'h':
			helpMessage();
			break;
		case 'i':
			openInventory();
			break;
		case 'q':
			System.out.println("Game closed successfully.");
			System.out.println("Thank you for playing!");
			System.exit(0);
			break;
		default:
			if(c == 'n' || c == 'w' || c == 'e' || c == 's')
				move(c);
			break;
		}
	}
	
	

	private void openInventory() {
		
	}

	private void helpMessage() {
		
	}

	//calls the move function in the map class
	private void move(char c) {
		//moves from the map class
		m.move(c);
		
		if(m.checkFloorComplete()) {
			m = new Map();
			//GameMain game = new GameMain();
			m.startGame();
			//game.choice();
		}
		
		System.out.println("Your new position is: " + m.getPlayerPos());
		//print board after moving
		m.printBoard();
		//go back to choice
		choice();
	}
	
	//starts the game
	private void startGame() {
		m = new Map();
		//display first message
		startMessage();
		//start new instance of the map
		m.startGame();
		m.printBoard();

	}
	
}
