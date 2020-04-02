public class Armor extends Item{

    public Armor(){
        itemName = "";
        itemType = "Armor";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Armor(String name){
        itemName = name;
        itemType = "Armor";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Armor(String name, int AC){
        itemName = name;
        itemType = "Armor";
        attackDamage = 0;
        armorClass = AC;
        healthPoints = 0;
    }

    private int getArmorClass() {
        return armorClass;
    }

    public int getArmorClass(Armor a){
        return a.getArmorClass();
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}
