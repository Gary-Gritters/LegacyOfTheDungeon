public class Weapon extends Item{

    public Weapon(){
        itemName = "";
        itemType = "Weapon";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Weapon(String name){
        itemName = name;
        itemType = "Weapon";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Weapon(String name, int AD){
        itemName = name;
        itemType = "Weapon";
        attackDamage = AD;
        armorClass = 0;
        healthPoints = 0;
    }

    private int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackDamage(Weapon w){
        return w.getAttackDamage();
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
