/*****************************************
 * This class is the Potion Item type.
 *
 * @author RK
 * @version 2.0
 ******************************************/

public class Potions extends Item{

    /************************************
     * This constructor initializes the
     * itemType to Potion but leaves all
     * else at nothing.
     ************************************/

    public Potions(){
        itemName = "";
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /****************************************
     * This constructor initializes the
     * itemType to Potion and the itemName.
     *
     * @param name the name to initialize to.
     ****************************************/

    public Potions(String name){
        itemName = name;
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /******************************************
     * This constructor initialize the itemType
     * to potion as well as the itemName and
     * amount of hp it gives.
     *
     * @param name the name to initialize to.
     * @param HP the hp to initialize to.
     ******************************************/

    public Potions(String name, int HP){
        itemName = name;
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = HP;
    }

    /********************************************
     * This method gives the hp a potion gives
     *
     * @return the hp.
     ********************************************/

    private int getHealthPoints() {
        return healthPoints;
    }

    /**************************************************
     * This method gives the hp of a certain potion.
     *
     * @param p the potion.
     * @return the hp.
     **************************************************/

    public int getHealthPoints(Potions p) {
        return p.getHealthPoints();
    }

    /***************************************************
     * This method sets the hp of the potion.
     *
     * @param healthPoints hp to set to.
     ***************************************************/

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
