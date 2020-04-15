package PlayerCharacter;

import java.util.Random;

/******************************************************
 * This is the Mage class, which is used for casting offensive
 * magic spells, and also contains a growth guide for leveling up
 *
 * @author Matt Hendrick
 ******************************************************/
public class Mage extends PlayerCharacter {

    /*************************************************
     * This is the initial statistics chart for the Mage
     * upon character creation.
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
     **************************************************/
    private Mage(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int next, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, next, gold);

        name = "";
        str = 1;
        dex = 2;
        con = 1;
        mind = 6;
        hp = 6 + con;
        mp = 6 + mind;
        lv = 1;
        exp = 0;
        next = 1000;
        gold = 0;

    }

    /****************************************************
     * This is the level up chart that details how the mage grows
     * every level.
     ****************************************************/
    private levelUp() {

        level++;
        strength += 1;
        dexterity += 1;
        constitution += 1;
        intelligence += 6;
        System.out.println("Please distribute remaining stat points");
        nextLevel += 1000 * level;

        if (level == 3) {
            System.out.println("You learned Bolt!");
        }

        if (level == 5) {
            System.out.println("You learned Fireball!");
        }

        if (level == 7) {
            System.out.println("You learned Paralyze!");
        }

        if (level == 10) {
            System.out.println("You learned Finger of Doom!");
        }

        if (experience >= nextLevel) {
            levelUp();
        }

    }

    /***********************************************
     * Initial spell of the Mage so the character isn't completely
     * useless at first level.  Will still have to be babysat by
     * melee classes for the early levels.
     ***********************************************/
    private void spark() {
        int damage;
        Random random = new Random();
        damage = random.nextInt(6) + 1;
        if (magic >= 2) {
            magic -= 2;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

    /**********************************************
     * Essentially a more advanced version of Spark
     **********************************************/
    private void bolt() {
        int damage;
        Random random = new Random();
        damage = random.nextInt(6) + 7;
        if (magic >= 4) {
            magic -= 4;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

    /***********************************************
     * As the monsters have more HP, we need more powerful spells
     * to keep the monsters in check.  This will target multiple
     * monsters at once
     *
     *************************************************/
    private void fireball() {
        int damage;
        Random random = new Random();
        damage = random.nextInt(6) + 7;
        if (magic >= 8) {
            magic -= 8;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
        //This targets multiple enemies
    }

    /***********************************************
     * The first status ailment spell we can cast on the monsters.
     * This does have a chance to work on bosses, though they
     * will have an additional chance to resist it.
     ***********************************************/
    private void paralyze() {
        //This will set the target enemy to have their turn skipped
        //until condition is cured
    }

    /**********************************************
     * This will inflict a high amount of single target damage,
     * but is also expensive to cast.
     ***********************************************/
    private void doom() {
        int damage;
        Random random = new Random();
        damage = random.nextInt(20) + 20;
        if (magic >= 13) {
            magic -= 13;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

}
