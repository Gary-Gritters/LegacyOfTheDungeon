public class GamePiece implements IGamePiece{
    private String myName;
    private String myPicture;
    private int moveSpeed;
    private int health;
    private int range;
    //NOTE! If is ally is 0, they are nothing. 1 is friendly, -1 is enemy
    private int isAlly;
    public GamePiece(int newMoveSpeed, int newRange, String callMeThis, int amFriendly){
        myName = callMeThis;
        moveSpeed = newMoveSpeed;
        range = newRange;
        isAlly = amFriendly;
    }

    public GamePiece(){
        myName = "nullName";
        moveSpeed = 0;
        range = 0;
        isAlly = 0;
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
    public int getAlliance() {
        return isAlly;
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
