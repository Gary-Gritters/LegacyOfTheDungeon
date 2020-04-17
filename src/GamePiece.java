public class GamePiece implements IGamePiece{
    private String myName;
    private String myPicture;
    private int moveSpeed;
    private int health;
    private int range;
    private boolean isAlly;
    public GamePiece(int newMoveSpeed, int newRange, String callMeThis){
        myName = callMeThis;
        moveSpeed = newMoveSpeed;
        range = newRange;
    }

    public GamePiece(){
        myName = "nullName";
        moveSpeed = 0;
        range = 0;
    }

    public void setMoveSpeed(int setMoveSpeed){
        moveSpeed = setMoveSpeed;
    }

    public String getName(){
        return myName;
    }
    public int getMoveSpeed(){
        return moveSpeed;
    }
    public int getRange(){
        return range;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public void healDamage(int heal){
        health += heal;
    }
    /*
    public void movePiece(){

    }
    public void attackPiece(){

    }
     */
}
