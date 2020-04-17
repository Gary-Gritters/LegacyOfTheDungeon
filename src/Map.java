import java.util.Random;

public class Map {
	
	private Random rand = new Random();
	
	//board variables
	private int rows = rand.nextInt(5 + 1) + 5;
	private int columns = rand.nextInt(5 + 1) + 5;
	private char twoD[][]=new char[rows][columns];
	
	//used to track player position
	private int playerX;
	private int playerY;
	private int tempPlayerX;
	private int tempPlayerY;
	private boolean exitCheck;
	
	
	public boolean checkFloorComplete() {
		return exitCheck;
	}
	
	
	//return current room type
	public char checkRoom() {
		//finish...
		return 'y';
	}

	private void exitRoom() {
		System.out.println("\nCongrats! You made it to the next floor!\n");
		exitCheck = true;
//		resetBoard();
		
	}

	//fill and initialize the board at the start
	private void fillBoard() {
		
		for(int i=0; i<rows;i++)
		{            
	        for(int j=0; j<columns;j++)
	        {
	        	twoD[i][j]='x';	
	        }
		}
	}
	
	//used to get the position of player (x,y)
	protected String getPlayerPos() {
		int x = playerX;
		int y = playerY;
		String pos = String.valueOf(y + 1) + ", " + String.valueOf(x + 1) ;
		
		return(pos);
	}
	
	
	//array check to make sure player does not move out of bounds
	//faster than a try-catch
	private boolean isMoveValid(){
		if((playerX > rows - 1 || playerX < 0 || playerY > columns - 1 || playerY < 0 ))
			return false;
		else
			return true;
	}


	//this function moves the player
	protected void move(char choice) {
		//temp variables to hold the original player position
		//this is for when an invalid move is made
		tempPlayerY = playerY;
		tempPlayerX = playerX;

		//switch statement activating a movement for all four directions
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
			System.out.println("Sorry! Your movement was invalid");
		}
		
		//make sure move is valid
		if(isMoveValid())
			//if move is valid update board and any actions that take place in next room
			updateCharPos();
		else {
			//if not valid move, restore position
			playerX = tempPlayerX;
			playerY = tempPlayerY;
		}
	}
	
	//print the board and map key
	protected void printBoard() {
		System.out.println("\n	Map Key:");
		System.out.println("	P = Player");
		System.out.println("	T = Treasure");
		System.out.println("	X = Road block or Possible Enemy Encounter");
		System.out.println("	V = Visited\n");
		System.out.println("	E = Exit\n");

		
		for(char[] x:twoD){
            for(char y:x){
            System.out.print(y+"  ");
            }
            System.out.println();
        }
	}
	
	//set exit on board to next map
	//reaching this room will "reset" the map to be a new world/floor
	private void setExit() {
		int i = 0;
		while(i ==0) {
			Random rand1 = new Random(); 
			int r = rand1.nextInt(rows);
			int c = rand1.nextInt(columns);
			if(twoD[r][c] == 'x') {
				twoD[r][c]='E';
				i++;
			}
		}		
	}
	
	//set initial player position
	private void setPlayer() {
		int i = 0;
		
		//randomly select where the player will start
		while(i == 0) {
			Random rand = new Random(); 
			
			int r = rand.nextInt(rows);
			int c = rand.nextInt(columns);
				
			if(twoD[r][c] == 'x') {
				twoD[r][c]='P';
				playerX = r;
				playerY = c;
				i++;
			}	
			
		}		
	}
	
	
	//set a spot for treasure to spawn
	private void setTreasure() {
		int i = 0;
		Random rand1 = new Random(); 
		//currently it is set to 1-3 treasure rooms per map
		int amt = rand1.nextInt(2) + 1;
		while(i < amt) {
			
			for(int n = 0; n < amt ;n++) {
				
				int r = rand1.nextInt(rows);
				int c = rand1.nextInt(columns);
				
				if(twoD[r][c] == 'x') {
					twoD[r][c]='T';
					i++;
				}
			}
		}			
	}


	//starts a new game 
	public void startGame() {
		exitCheck = false;
		this.fillBoard();
		this.setPlayer();
		this.setExit();
		this.setTreasure();
		//this.printBoard();
		//System.out.println("\n" + (this.getPlayerPos()));
	
	}


	private void treasureRoom() {
		System.out.println("\nCongrats! You found a treasure!\n");
		//name treasure
		//add treasure to inventory
	}


	//updates the players position after a move
	//also will check if player reaches a treasure room,enemy room, exit, etc.
	private void updateCharPos() {
		//get room type that will be moved to
		char room = twoD[playerX][playerY];
		//set the old room moved from to v for visited
		twoD[tempPlayerX][tempPlayerY]='V';
		twoD[playerX][playerY]='P';
		//ADD in actions for each type of room encounter
		switch(room) {
		case 'E':
			exitRoom();
			break;
		case 'T':
			treasureRoom();
			break;
		default:
			break;
		}
		
	}


	
}
