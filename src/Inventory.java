/******************************************
* This class is the main Inventory.
 *
 * @author RK
 * @version 2.0
*******************************************/

public class Inventory {

    // the inventory is an array of Items
    private Item[] myInventory = new Item[8];

    /****************************************
     * This constructor initializes all spots
     * as empty weapons to show that the
     * inventory slot is empty when checked.
     ****************************************/

    public Inventory() {
        for(int i = 0; i < 8; i++) {
            myInventory[i] = new Weapon();
        }
    }

    /******************************************
     * This method returns the inventory.
     *
     * @return the inventory array.
     ******************************************/

    public Item[] getMyInventory() {
        return myInventory;
    }

    /******************************************
     * This method returns a specific item.
     *
     * @param place the spot in the item array.
     * @param i the inventory you are looking in.
     * @return the item.
     */

    public Item getItem(int place, Inventory i) {
        if(place > -1 && place < 8){
            return i.getMyInventory()[place];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /*******************************************
     * This method adds an item to an inventory.
     *
     * @param i the inventory to add to.
     * @param thisOne the item to add.
     *******************************************/

    public void addItem(Inventory i, Item thisOne){
        if(isFull(i)){
            System.out.println("Sorry your inventory is already full");
        } else {
            for(int j = 0; j < 8; j++){
                if(i.getMyInventory()[j].getItemName() == ""){
                    i.getMyInventory()[j] = thisOne;
                    break;
                }
            }
        }
    }

    /************************************************
     * This method removes an item from an inventory.
     *
     * @param i the inventory to remove from.
     * @param thisOne the item to remove.
     ************************************************/

    public void dropItem(Inventory i, Item thisOne){
        for(int j = 0; j < 8; j++){
            if(i.getMyInventory()[j].getItemName() == thisOne.getItemName()){
                i.getMyInventory()[j] = new Weapon();
            }
        }
    }

    /*****************************************************
     * This method checks if all inventory slots are full.
     *
     * @param i the inventory to check
     * @return boolean for if it is full or not.
     *****************************************************/

    public Boolean isFull(Inventory i){
        for(int j = 0; j < 8; j++){
            if(i.getItem(j, this).getItemName() == ""){
                return false;
            }
        }
        return true;
    }
}