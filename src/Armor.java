/*****************************************
 * This class is the Armor Item type.
 *
 * @author RK
 * @version 2.0
 ******************************************/

public class Armor extends Item{

    /************************************
     * This constructor initializes the
     * itemType to Armor but leaves all
     * else at nothing.
     ************************************/

    public Armor(){
        itemName = "";
        itemType = "Armor";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /****************************************
     * This constructor initializes the
     * itemType to Armor and the itemName.
     *
     * @param name the name to initialize to.
     ****************************************/

    public Armor(String name){
        itemName = name;
        itemType = "Armor";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /******************************************
     * This constructor initialize the itemType
     * to armor as well as the itemName and
     * amount of armor it gives.
     *
     * @param name the name to initialize to.
     * @param AC the armor to initialize to.
     ******************************************/

    public Armor(String name, int AC){
        itemName = name;
        itemType = "Armor";
        attackDamage = 0;
        armorClass = AC;
        healthPoints = 0;
    }

    /********************************************
     * This method gives the armor class
     *
     * @return the armor.
     ********************************************/

    private int getArmorClass() {
        return armorClass;
    }

    /**************************************************
     * This method gives the armor class of a certain armor.
     *
     * @param a the armor.
     * @return the armor class.
     **************************************************/

    public int getArmorClass(Armor a){
        return a.getArmorClass();
    }

    /***************************************************
     * This method sets the armor class of the armor.
     *
     * @param armorClass armor class to set to.
     ***************************************************/

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}
