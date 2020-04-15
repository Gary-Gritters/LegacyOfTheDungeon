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

    public void abilityType() {

        int requiredLevel;
        String abilityName;
        int damage;
        int defense;
    }
    
    public void setCharName(String name) {
        charName = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharStr(int str) {
        strength = str;
    }

    public int getCharStr() {
        return strength;
    }

    public void setCharDex(int dex) {
        dexterity = dex;
    }

    public int getCharDex() {
        return dexterity;
    }

    public void setCharCon(int con) {
        constitution = con;
    }

    public int getCharCon() {
        return constitution;
    }

    public void setCharMind(int mind) {
        intelligence = mind;
    }

    public int getCharMind() {
        return intelligence;
    }

    public void setCharHealth(int hp) {
        health = hp;
    }

    public int getCharHealth() {
        return health;
    }

    public void setCharMagic(int mp) {
        magic = mp;
    }

    public int getCharMagic() {
        return magic;
    }

    public void setExperience(int exp) {
        experience = exp;
    }

    public int getExperience() {
        return experience;
    }

    public void setCurrency(int gold) {
        currency = gold;
    }

    public int getCurrency() {
        return currency;
    }




}
