package PlayerCharacter;

public class Fighter extends PlayerCharacter {

    private Fighter(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int next, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, next, gold);

        name = "";
        str = 4;
        dex = 2;
        con = 3;
        mind = 1;
        hp = 10 + con;
        mp = 0;
        lv = 1;
        exp = 0;
        next = 1000;
        gold = 0;
    }

    public void levelUp() {

        level++;
        strength += 3;
        dexterity += 2;
        constitution += 3;
        intelligence += 1;
        nextLevel += 1000 * level;

        if (level == 3) {
            System.out.println("You learned Focus Strike!");
        }

        if (level == 5) {
            System.out.println("You learned Shield!");
        }

        if (level == 7) {
            System.out.println("You learned Taunt!");
        }

        if (level == 10) {
            System.out.println("You learned Whirlwind!");
        }

        if (experience >= nextLevel) {
            levelUp();
        }

    }

    public void abilityType() {

        int weaponDamage = 0;
        int armorValue = 0;
        int damage;
        int defense;
        int numTurns;
        boolean isAvailable = true;
    }

    public void focusStrike() {
        boolean isActive = true;
        int damage;
        int weaponDamage; //Tie this to weapon
        String abilityName = "Focus Strike";
        if (isActive == true) {
            damage = (strength + weaponDamage) * 2;
            isActive = false;
        }
        else {
            System.out.println("Focus Strike cannot be used " +
                    "until next turn");
        }

    }

    public void shield() {
        int defense;
        int armorValue;
        String abilityName = "Shield";
        defense = (constitution + armorValue) * 2;
    }

    public void taunt() {
        //Enemies that target a character with a melee attack attack this
        //character instead for one round
    }

    public void whirlwind() {
        //Target all surrounding enemies
    }







}
