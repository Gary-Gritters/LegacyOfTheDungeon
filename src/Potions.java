public class Potions extends Item{

    public Potions(){
        itemName = "";
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Potions(String name){
        itemName = name;
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = 0;
    }

    public Potions(String name, int HP){
        itemName = name;
        itemType = "Potion";
        attackDamage = 0;
        armorClass = 0;
        healthPoints = HP;
    }

    private int getHealthPoints() {
        return healthPoints;
    }

    public int getHealthPoints(Potions p) {
        return p.getHealthPoints();
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
