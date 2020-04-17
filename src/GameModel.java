public class GameModel {

    //This will be holding the logic for the game
    private GamePiece[][] myPieces;
    public GameModel(int row, int col){
        myPieces = new GamePiece[row][col];
        for(int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                myPieces[r][c] = new GamePiece();
            }
        }
    }
    public void createPiece(int rowSpot, int colSpot, int moveSpeed, int attackRange, String myName){
        myPieces[rowSpot][colSpot] = new GamePiece(moveSpeed, attackRange, myName);
    }

    public void removePiece(int rowSpot, int colSpot){
        myPieces[rowSpot][colSpot] = new GamePiece();
    }

    public boolean canMovePiece(int fromRow, int fromCol, int toRow, int toCol){
        boolean test = false;
        GamePiece check = myPieces[fromRow][fromCol];
        int distanceRow = Math.abs(fromRow - toRow);
        int distanceCol = Math.abs(fromCol - toCol);
        if(check.getName() == "nullName" || fromRow == toRow && fromCol == toCol){
            return false;
        }
        if(distanceRow <= check.getMoveSpeed() && distanceCol <= check.getMoveSpeed()){
            test = true;
            return true;
        }
        /*if((toRow - fromRow <= check.getMoveSpeed()) && (toCol - fromCol <= check.getMoveSpeed())){
            return true;
        }*/
        return false;
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol){
        if(canMovePiece(fromRow, fromCol, toRow, toCol)){
            myPieces[toRow][toCol] = myPieces[fromRow][fromCol];
            removePiece(fromRow, fromCol);
        }
    }
    public void attackPiece(){

    }
}
