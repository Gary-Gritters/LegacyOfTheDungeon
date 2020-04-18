public class GameModel {

    //This will be holding the logic for the game
    private GamePiece[][] myPieces;

    /***********************************************
     * Acts as the basic constructor for a character and will
     * give the character's stats.
     *
     * @param row
     * @param col
     *
     * Constructor to create a clear game of size row by col
     */

    public GameModel(int row, int col){
        myPieces = new GamePiece[row][col];
        for(int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                myPieces[r][c] = new GamePiece();
            }
        }
    }

    /******************************************
     * This method creates a unit in the game model
     *
     * @param rowSpot the spot in the item array.
     * @param colSpot the inventory you are looking in.
     * @param moveSpeed how many squares a unit can move
     * @param attackRange how far a unit can reach with their attack
     * @param myName the name of the unit
     * @param isAlly define if allied, enemy, or nothing. 1 is ally, 0 is nothing, -1 is enemy.
     *
     */

    public void createPiece(int rowSpot, int colSpot, int moveSpeed, int attackRange, String myName, int isAlly){
        myPieces[rowSpot][colSpot] = new GamePiece(moveSpeed, attackRange, myName, isAlly);
    }

    /******************************************
     * This method removes a unit off of the model
     *
     * @param rowSpot row of unit to remove
     * @param colSpot column of unit to remove
     */

    public void removePiece(int rowSpot, int colSpot){
        myPieces[rowSpot][colSpot] = new GamePiece();
    }

    /******************************************
     * This method check if the the piece on a spot (from) can move to a spot (to)
     * Uses (row, col)
     *
     * @param fromRow the row of the unit trying to move
     * @param fromCol the column of the unit trying to move
     * @param toRow the row the unit is trying to move to
     * @param toCol the column the unit is trying to move to
     * @return true if its a viable move, false if it isn't
     */

    public boolean canMovePiece(int fromRow, int fromCol, int toRow, int toCol){
        GamePiece check = myPieces[fromRow][fromCol];
        int distanceRow = Math.abs(fromRow - toRow);
        int distanceCol = Math.abs(fromCol - toCol);
        if(check.getName() == "nullName" || fromRow == toRow && fromCol == toCol){
            return false;
        }
        if(!myPieces[toRow][toCol].getName().equals("nullName")){
            return false;
        }
        if(distanceRow <= check.getMoveSpeed() && distanceCol <= check.getMoveSpeed()){
            return true;
        }
        return false;
    }

    /******************************************
     * This method check the alliegance of a unit
     *
     * @param rowSpot the row of the unit
     * @param colSpot the col of the unit
     * @return returns the alliegance of the spot. If 1, ally. If 0, nothing. If -1, enemy.
     */

    public int isAlly(int rowSpot, int colSpot){
        return myPieces[rowSpot][colSpot].getAlliance();
    }

    /******************************************
     * This method moves a unit from a spot to another spot.
     *
     * @param fromRow the row of the unit moving
     * @param fromCol the column of the unit moving
     * @param toRow the row the unit is moving to
     * @param toCol the column the unit is moving to
     */

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol){
        if(canMovePiece(fromRow, fromCol, toRow, toCol)){
            myPieces[toRow][toCol] = myPieces[fromRow][fromCol];
            removePiece(fromRow, fromCol);
        }
    }
}
