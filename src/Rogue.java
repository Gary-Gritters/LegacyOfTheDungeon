package PlayerCharacter;

/***********************************************
 * This is the Rogue class, which specializes in stealing
 * and will eventually become the ranged attack specialist if
 * the player chooses to equip the rogue accordingly
 *
 * @author Matt Hendrick
 ***********************************************/

public class Rogue extends PlayerCharacter{

    /*************************************************
     * This is the initial stat chart for a new Rogue.
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
     *************************************************/
    private Rogue(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int next, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, next, gold);

        name = "";
        str = 2;
        dex = 4;
        con = 2;
        mind = 2;
        hp = 8 + con;
        mp = 0;
        lv = 1;
        exp = 0;
        next = 1000;
        gold = 0;

    }

    /**************************************************
     * This is the level up chart for the Rogue.  Unlike the other
     * classes, the Rogue grants passive party bonuses at higher levels,
     * making it a good idea to keep one in your party.
     **************************************************/
    private levelUp() {

        level++;
        strength += 2;
        dexterity += 3;
        constitution += 2;
        intelligence += 2;
        System.out.println("Please distribute remaining stat points");
        nextLevel += 1000 * level;

        if (level == 3) {
            System.out.println("You learned Hide!");
        }

        if (level == 5) {
            System.out.println("You learned Mug!");
        }

        if (level == 7) {
            System.out.println("You learned Seller's Talk!");
            //Passively increase sale value on items the
            //rogue is carrying by 10%
        }

        if (level == 10) {
            System.out.println("You learned Treasure Hunter!");
            //Passively increase the chance of acquiring rare
            //treasure from dungeon runs
        }

        if (experience >= nextLevel) {
            levelUp();
        }
    }

    /************************************************
     * Designed to pretty much be the opposite of the Fighter's
     * Focus Strike, the delay is before the backstab, though the
     * Rogue is also free from targeted effects during the hiding phase.
     ************************************************/
    private void hide() {
        int backstab = (strength + weaponDamage) * 2;
        //Remove this character from battle for one turn
        boolean isHidden = true;
        if (isHidden == true) {
            damage = backstab;
            isHidden = false;
        }
    }

    /***********************************************
     * Combines the effects of stealing an item with a normal
     * attack, though there are attack penalties.  Future builds
     * may allow upgrades at higher levels to remove this penalty,
     * or lessen it considerably.
     *************************************************/
    private void mug() {
        int mugDamage = (strength + weaponDamage) / 2;
        //Attempt to steal an item off an enemy
    }
}
