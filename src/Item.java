/**********************************************
 * This class is the building block for the
 * Item Type classes.
 *
 * @author RK
 * @version 2.0
 **********************************************/

public abstract class Item {

    // instance variables for:
    // itemName
    String itemName;

    // itemType
    String itemType;

    // damage amount
    int attackDamage;

    // armor amount
    int armorClass;

    // hp amount
    int healthPoints;

    /*****************************************************
     * This constructor initializes everything to nothing.
     *****************************************************/

    public Item() {
        itemName = "";
        itemType = "";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    /*******************************************
     * This method gives the item name.
     *
     * @return the name of the item.
     ******************************************/

    public String getItemName() {
        return itemName;
    }

    /*****************************************
     * This method give the item type.
     *
     * @return the type of the item.
     *****************************************/

    public String getItemType() { return itemType; }

    /****************************************
     * Set the item type to a type of item.
     *
     * @param itemType the type to set to.
     ****************************************/

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /****************************************
     * Set the item name.
     *
     * @param itemName the name to set to.
     ****************************************/

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
