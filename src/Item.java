public abstract class Item {

    String itemName;
    String itemType;
    int attackDamage;
    int armorClass;
    int healthPoints;

    public Item() {
        itemName = "";
        itemType = "";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() { return itemType; }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
