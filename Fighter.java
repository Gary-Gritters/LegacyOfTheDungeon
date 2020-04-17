package PlayerCharacter;

/***************************************************
 * This guy hits things really hard.  He also protects others
 * from harm.
 *
 * @author Matt Hendrick
 ***************************************************/
public class Fighter extends PlayerCharacter {

    /************************************************
     * Initial stat chart for a level 1 fighter.
     *
     * @param name
     * @param str
     * @param dex
     * @param con
     * @param mind
     * @param hp
     * @param mp
     * @param lv
     * @param exp
     * @param next
     * @param gold
     */
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

    /*********************************************
     * This is the growth chart for the fighter
     *********************************************/
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

    /*********************************************
     * This ability is meant to hit a target hard, but leave
     * the fighter unable to act for a turn.  Strategically,
     * it is meant to hit a threatening monster hard to get it
     * out of battle ASAP.
     ********************************************/
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

    /********************************************
     * Raises defense at the cost of the opportunity to attack
     * the next turn
     ********************************************/
    public void shield() {
        int defense;
        int armorValue;
        String abilityName = "Shield";
        defense = (constitution + armorValue) * 2;
    }

    /********************************************
     * Draw the enemies to the fighter.  This should have the
     * effect of removing the priority from other characters, which
     * would require an AI change if this is active.
     ********************************************/
    public void taunt() {
        //Enemies that target a character with a melee attack attack this
        //character instead for one round
    }

    /**********************************************
     * Hits surrounding enemies for normal melee damage.
     **********************************************/
    public void whirlwind() {
        //Target all surrounding enemies
    }

}
