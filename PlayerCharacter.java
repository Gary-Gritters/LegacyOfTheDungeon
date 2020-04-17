package PlayerCharacter;
import java.util.Random;
/**********************************************************
 * This class will detail the basic framework of a character.
 * These attributes are common to all classes (though in the case
 * of the fighter and rogue, magic will always be at 0), but will have
 * different growth rates and abilities depending upon the class.
 *
 * @author Matt Hendrick
 ***********************************************************/
abstract public class PlayerCharacter {

    protected String charName;
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int health;
    protected int magic;
    protected int level;
    protected int experience;
    protected int nextLevel;
    protected int currency;

    /***********************************************
     * Acts as the basic constructor for a character and will
     * give the character's stats.
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
    public PlayerCharacter(String name, int str, int dex, int con, int mind,
                     int hp, int mp, int lv, int exp, int next, int gold) {

        charName = "" + name;
        strength = str;
        dexterity = dex;
        constitution = con;
        intelligence = mind;
        health = hp;
        magic = mp;
        level = lv;
        experience = exp;
        nextLevel = next;
        currency = gold;
    }

    /**********************************************
     * This is how the character will grow upon reaching a certain
     * experience point threshold.  There is code that will level the
     * character multiple times in the very rare event a character
     * gains more than one level in a single battle.
     ************************************************/
    public void levelUp() {

        level++;
        strength += 0;
        dexterity += 0;
        constitution += 0;
        intelligence += 0;
        nextLevel += level * 1000;
        System.out.println("Please distribute remaining stat points");
        if (experience >= nextLevel) {
            levelUp();
        }
    }

    /*************************************************
     * This is the general skeleton of what an ability would look
     * like.  Since most of the abilities manipulate damage and
     * defense in some way, those two parameters are included in
     * the general method.  All abilities have a required level and
     * a name.
     ***************************************************/
    public void abilityType() {

        int requiredLevel;
        String abilityName;
        int damage;
        int defense;
    }

    /*************************************************
     *
     * @param name Sets the character's name after creation
     **************************************************/
    public void setCharName(String name) {
        charName = name;
    }

    /************************************************
     *
     * @return This will call the character's name when needed
     *************************************************/
    public String getCharName() {
        return charName;
    }

    /************************************************
     *
     * @param str Sets the character's strength to the current
     *            value.  May be manipulated by abilities also.
     ************************************************/
    public void setCharStr(int str) {
        strength = str;
    }

    /*************************************************
     *
     * @return Will call the strength value when needed, often
     *         during battles.
     **************************************************/
    public int getCharStr() {
        return strength;
    }

    /*************************************************
     *
     * @param dex Sets the character's dexterity to the current
     *            value.  May be manipulated by abilities as well.
     *************************************************/

    public void setCharDex(int dex) {
        dexterity = dex;
    }

    /*************************************************
     *
     * @return Will call the dexterity value when needed, often
     *         during battles.
     **************************************************/
    public int getCharDex() {
        return dexterity;
    }

    /**************************************************
     *
     * @param con Sets the character's constitution to the current
     *            value.  May be manipulated by abilities as well.
     **************************************************/
    public void setCharCon(int con) {
        constitution = con;
    }

    /*************************************************
     *
     * @return Will call the constitution value when needed, often
     *         during battles and when calculating HP.
     **************************************************/
    public int getCharCon() {
        return constitution;
    }

    /*****************************************************
     *
     * @param mind Sets the character's intelligence to the current
     *             value.
     *****************************************************/
    public void setCharMind(int mind) {
        intelligence = mind;
    }

    /*************************************************
     *
     * @return Will call the intelligence value when needed, often
     *         during battles when casting magic.
     **************************************************/
    public int getCharMind() {
        return intelligence;
    }

    /*************************************************
     *
     * @param hp Sets the character's health to the current value,
     *           though never in the negatives.
     *************************************************/
    public void setCharHealth(int hp) {
        health = hp;
    }

    /*************************************************
     *
     * @return Will call the HP value when needed, often
     *         during battles or when taking curative items.
     **************************************************/
    public int getCharHealth() {
        return health;
    }

    /**************************************************
     *
     * @param mp Sets the character's magic to the current value
     *           though never in the negatives.
     */
    public void setCharMagic(int mp) {
        magic = mp;
    }

    /*************************************************
     *
     * @return Will call the MP value when needed, often
     *         during battles or when taking items to recover it.
     **************************************************/
    public int getCharMagic() {
        return magic;
    }

    /*************************************************
     *
     * @param exp Adds the enemy's experience value to the player's
     *            total
     *************************************************/
    public void setExperience(int exp) {
        experience = exp;
    }

    /*************************************************
     *
     * @return Will call the experience value when needed, often
     *         after battles.
     **************************************************/
    public int getExperience() {
        return experience;
    }

    /***************************************************
     *
     * @param gold Adds and subtracts money when needed
     **************************************************/
    public void setCurrency(int gold) {
        currency = gold;
    }

    /*************************************************
     *
     * @return Will call the currency value when needed,
     *         typically after a battle or when shopping
     **************************************************/
    public int getCurrency() {
        return currency;
    }




}
