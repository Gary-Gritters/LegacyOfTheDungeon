/*****************************************
 * This class is the Weapon Item type.
 *
 * @author RK
 * @version 2.0
 ******************************************/

public class Weapon extends Item{

    /************************************
     * This constructor initializes the
     * itemType to Weapon but leaves all
     * else at nothing.
     ************************************/

    public Weapon(){
        itemName = "";
        itemType = "Weapon";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /****************************************
     * This constructor initializes the
     * itemType to Weapon and the itemName.
     *
     * @param name the name to initialize to.
     ****************************************/

    public Weapon(String name){
        itemName = name;
        itemType = "Weapon";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /******************************************
     * This constructor initialize the itemType
     * to weapon as well as the itemName and
     * amount of damage it deals.
     *
     * @param name the name to initialize to.
     * @param AD the damage to initialize to.
     ******************************************/

    public Weapon(String name, int AD){
        itemName = name;
        itemType = "Weapon";
        attackDamage = AD;
        armorClass = 0;
        healthPoints = 0;
    }


    /********************************************
     * This method gives the damage a weapon does
     *
     * @return the damage.
     ********************************************/

    private int getAttackDamage() {
        return attackDamage;
    }

    /**************************************************
     * This method gives the damage of a certain weapon.
     *
     * @param w the weapon.
     * @return the damage.
     **************************************************/

    public int getAttackDamage(Weapon w){
        return w.getAttackDamage();
    }

    /***************************************************
     * This method sets the damage of the weapon.
     *
     * @param attackDamage damage to set to.
     ***************************************************/

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
