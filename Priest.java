package PlayerCharacter;

import java.util.Random;

public class Priest extends PlayerCharacter {

    private Priest(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, gold);

        name = "";
        str = 2;
        dex = 1;
        con = 2;
        mind = 5;
        hp = 6 + con;
        mp = 6 + mind;
        lv = 1;
        exp = 0;
        gold = 0;


    }

    private levelUp() {

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

    private void firstAid() {
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

    private void cureLight() {
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

    private void cureModerate() {
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

    private void cureAllModerate() {
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
