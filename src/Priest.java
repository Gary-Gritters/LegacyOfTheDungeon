import java.util.Random;

/***********************************************************
 * This is the Priest character class that contains a couple of
 * basic heal spells and a general growth rate each time the character
 * levels up.
 *
 * @author Matt Hendrick
 ***********************************************************/

public class Priest extends PlayerCharacter {

    /********************************************************
     * This is the initial stats chart for the Priest as well as
     * the other fields for the character.
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
     *********************************************************/
    public Priest(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int next, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, next, gold);

        name = "";
        str = 2;
        dex = 1;
        con = 2;
        mind = 5;
        hp = 6 + con;
        mp = 6 + mind;
        lv = 1;
        exp = 0;
        next = 1000;
        gold = 0;


    }

    /************************************************
     * This is how the character will grow once they reach the
     * proper amount of experience points.
     ***************************************************/
    public void levelUp() {

        level++;
        strength += 1;
        dexterity += 2;
        constitution += 2;
        intelligence += 4;
        System.out.println("Please distribute remaining stat points");
        nextLevel += 1000 * level;

        if (level == 3) {
            System.out.println("You learned Cure Light Wounds!");
        }

        if (level == 5) {
            System.out.println("You learned Cure Moderate Wounds!");
        }

        if (level == 7) {
            System.out.println("You learned Remove Paralysis!");
            //Flag a paralyzed character to be able to take turns again
        }

        if (level == 10) {
            System.out.println("You learned Mass Cure Moderate Wounds!");
            //Go through each friendly character and calculate recovery
        }

        if (experience >= nextLevel) {
            levelUp();
        }
    }

    /*******************************************
     * Basic starter spell that the priest can use at level 1
     ********************************************/
    public void firstAid() {
        int recover;
        Random random = new Random();
        recover = random.nextInt(6) + 1;
        if (magic >= 2) {
            magic -= 2;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

    /**************************************************
     * The first spell the priest learns after the initial spell.
     * It is designed to cost more, but will cure the character of
     * more damage than the first level spell.
     **************************************************/
    public void cureLight() {
        int recover;
        Random random = new Random();
        recover = random.nextInt(6) + 6;
        if (magic >= 4) {
            magic -= 4;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

    /***************************************************
     * As enemy damage starts to ramp up in later parts of the game,
     * the priest will need their spells to cure similar amounts of
     * damage.
     ****************************************************/
    public void cureModerate() {
        int recover;
        Random random = new Random();
        recover = random.nextInt(12) + 12;
        if (magic >= 8) {
            magic -= 8;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }

    /*******************************************************
     * Some enemies will be able to paralyze the characters.
     * This will help free characters afflicted by such conditions.
     *
     ********************************************************/
    public void cureParalysis() {
        //Not yet implemented
    }

    /*****************************************************
     * As enemies start to learn magic that can hit more than one player,
     * the priest will need spells that can assist multiple allies.
     ******************************************************/
    public void cureAllModerate() {
        //Make this cycle through all active characters on the field
        int recover;
        Random random = new Random();
        recover = random.nextInt(12) + 12;
        if (magic >= 2) {
            magic -= 2;
        }
        else {
            System.out.println("You don't have enough MP!");
        }
    }
}
