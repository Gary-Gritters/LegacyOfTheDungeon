import java.util.Random;

/***************************************************
 * This class creates and manages the map within 
 * the non-GUI game.
 *
 * @author Jarett Allie
 ***************************************************/
public class Map {
	
    //The scanner which will hold the user's commands.
	private Random rand = new Random();
	
	//create a random number of rows from 5 to 11
	private int rows = rand.nextInt(5) + 5;
	//create a random number of columns from 5 to 11
	private int columns = rand.nextInt(5) + 5;
	
	//define the 2d array to hold the rows and 
	//columns
	private char twoD[][]=new char[rows][columns];
	
	//used to track player's position
	private int playerX;
	private int playerY;
	//temp variables to store old moves
	private int tempPlayerX;
	private int tempPlayerY;
	
	//boolean to check if the player has 
	//reached the exit
	private boolean exitCheck;
	
	/****************************************
     * This checks if the floor is completed.
     * 
     * @return exitCheck boolean.
     *********************************************/
	public boolean checkFloorComplete() 
	{
		return exitCheck;
	}
	

	/*********************************************
    * This fills the board to instantiate it.
    *********************************************/
	private void fillBoard() 
	{
		for(int i=0; i<rows;i++)
		{            
	        for(int j=0; j<columns;j++)
	        {
	        	twoD[i][j]='x';	
	        }
		}
	}
	
	/*********************************************
     * This returns the player's position as a
     * string in (x,y) order.
     * 
     * @return String with the position of player. 
     *********************************************/
	protected String getPlayerPos() 
	{
		int x = playerX;
		int y = playerY;
		//create a string of player's position
		String pos = String.valueOf(y + 1) + ", "
		+ String.valueOf(x + 1) ;
		return(pos);
	}
	
	/*********************************************
     * This is an array out of bounds check to make
     * sure the player doesn't move out of bounds.
     * 
     * @return if a move is valid, true.
     *********************************************/
	private boolean isMoveValid()
	{
		//check all four directions
		if((playerX > rows - 1 || playerX < 0 || 
				playerY > columns - 1 || playerY < 0 ))
			return false;
		else
			return true;
	}


	/*********************************************
     * This moves the player based on the command
     * passed from GameNoGUI.
     * 
     * @param choice the direction to move.
     *********************************************/
	protected void move(char choice) 
	{
		//temp variables to hold the original player 
		//position
		//this is for when an invalid move is made
		tempPlayerY = playerY;
		tempPlayerX = playerX;
		//switch statement activating a movement 
		//for all four directions
		switch(choice) {
		case 'n':
			playerX--;
			break;
		case 'e':
			playerY++;
			break;
		case 'w':
			playerY--;
			break;
		case 's':
			playerX++;
			break;	
		default:
			System.out.println("Sorry! Your "
					+ "movement was invalid");
		}
		
		//make sure move is valid
		if(isMoveValid())
			//if move is valid update board
			//and any actions that take 
			//place in next room
			updateCharPos();
		else {
			//if not valid move, restore position
			playerX = tempPlayerX;
			playerY = tempPlayerY;
		}
	}
	
	/*********************************************
     * This prints the game board and map key.
     *********************************************/
	protected void printBoard() 
	{
		System.out.println("\n	Map Key:");
		System.out.println("	P = Player");
		System.out.println("	T = Treasure");
		System.out.println("	X = Road block "
				+ "or Possible Enemy Encounter");
		System.out.println("	V = Visited\n");
		System.out.println("	E = Exit\n");
		//print the board.
		for(char[] x:twoD){
            for(char y:x){
            System.out.print(y+"  ");
            }
            System.out.println();
        }
	}
	
	/*********************************************
     * This sets where the exit will be on the map.
     * Reaching this room will "reset" the map to
     * be a new floor.
     *********************************************/
	private void setExit() 
	{
		int i = 0;
		//loops through the board to randomly place
		//the exit
		while(i ==0) {
			Random rand1 = new Random(); 
			int r = rand1.nextInt(rows);
			int c = rand1.nextInt(columns);
			//make sure it is an empty room
			if(twoD[r][c] == 'x') {
				twoD[r][c]='E';
				i++;
			}
		}		
	}
	
	/*********************************************
     * This sets the player's position.
     *********************************************/
	private void setPlayer() 
	{
		int i = 0;
		//while loop to randomly select where 
		//the player will start
		while(i == 0) {
			Random rand = new Random(); 
			int r = rand.nextInt(rows);
			int c = rand.nextInt(columns);
			//make sure the room is empty where
			//it will be placed
			if(twoD[r][c] == 'x') {
				twoD[r][c]='P';
				playerX = r;
				playerY = c;
				i++;
			}	
		}		
	}
	
	
	/*********************************************
     * This sets where treasure will be set on the
     * floor.
     *********************************************/
	private void setTreasure() 
	{
		int i = 0;
		Random rand1 = new Random(); 
		//currently it is set to 1-3 treasure rooms
		//per map
		int amt = rand1.nextInt(2) + 1;
		//while loop to randomly select where 
		//the player will start
		while(i < amt) {
			for(int n = 0; n < amt ;n++) {
				int r = rand1.nextInt(rows);
				int c = rand1.nextInt(columns);
				//make sure room is empty where
				//treasure will be put.
				if(twoD[r][c] == 'x') {
					twoD[r][c]='T';
					i++;
				}
			}
		}			
	}


	/*********************************************
     * This starts the game and instantiates the board.
     * This also sets treasure, the player, and the
     * exit.
     *********************************************/
	protected void startGame() 
	{
		exitCheck = false;
		this.fillBoard();
		this.setPlayer();
		this.setExit();
		this.setTreasure();
	}

	/*********************************************
     * This is ran when treasure is found.
     *********************************************/
	private void treasureRoom() 
	{
		System.out.println("\nCongrats! You found"
				+ " a treasure!\n");
		//call treasure class
		//add treasure to inventory
	}

	/*********************************************
     * This updates the characters position after
     * a move. This also will check if a player
     * reaches a treasure room, enemy room, or 
     * exit room.
     *********************************************/
	private void updateCharPos() 
	{
		//get room type that will be moved to
		char room = twoD[playerX][playerY];
		//set the old room moved from to v for 
		//it to be marked as visited
		twoD[tempPlayerX][tempPlayerY]='V';
		twoD[playerX][playerY]='P';
		//switch statement to check room type
		switch(room) {
		case 'E':
			System.out.println("\nCongrats! You "
					+ "made it to the next floor!\n");
			exitCheck = true;			
			break;
		case 'T':
			treasureRoom();
			break;
		default:
			break;
		}
	}
	
}
