public class GamePiece implements IGamePiece{
    private String myName;
    private String myPicture;
    private int moveSpeed;
    private int health;
    private int range;
    //NOTE! If is ally is 0, they are nothing. 1 is friendly, -1 is enemy
    private int isAlly;


    /**
     * This is the constructor for a game piece.
     *
     * @param newMoveSpeed movespeed of the unit
     * @param newRange range of unit
     * @param callMeThis name of the unit
     * @param amFriendly alliegance of the unit. 1 is an ally, 0 is nothing, -1 is an enemy
     *
     */
    public GamePiece(int newMoveSpeed, int newRange, String callMeThis, int amFriendly){
        myName = callMeThis;
        moveSpeed = newMoveSpeed;
        range = newRange;
        isAlly = amFriendly;
    }

    /**
     * This is the basic constructor of a gamepiece. Basically a null spot on the board
     *
     */

    public GamePiece(){
        myName = "nullName";
        moveSpeed = 0;
        range = 0;
        isAlly = 0;
    }

    /**
     * This is the constructor for a game piece.
     *
     * @param setMoveSpeed movespeed of the unit
     */

    public void setMoveSpeed(int setMoveSpeed){
        moveSpeed = setMoveSpeed;
    }

    /**
     * Returns name of the unit
     * @return  name of the unit
     */
    public String getName(){
        return myName;
    }

    /**
     * Method returns the speed of a unit
     * @return speed of the unit
     */
    public int getMoveSpeed(){
        return moveSpeed;
    }

    /**
     * Method returns the range of a unit
     * @return range of the unit
     */
    public int getRange(){
        return range;
    }

    /**
     * Method returns allegiance of a unit. 1 is an ally, 0 is nothing, -1 is an enemy
     * @return allegiance of the unit.
     */
    public int getAlliance() {
        return isAlly;
    }

    /**
     * Method decreases the health of a unit by an amount damage
     * @param damage is the amount of damage a unit takes
     */

    public void takeDamage(int damage){
        health -= damage;
    }

    /**
     * Method heals health of a unit from damage.
     * @param heal is the amount a unit is healed
     */
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
