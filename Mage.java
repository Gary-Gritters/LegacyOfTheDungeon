package PlayerCharacter;

import java.util.Random;

public class Mage extends PlayerCharacter {

    private Mage(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, gold);

        name = "";
        str = 1;
        dex = 2;
        con = 1;
        mind = 6;
        hp = 6 + con;
        mp = 6 + mind;
        lv = 1;
        exp = 0;
        gold = 0;

    }

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

    private void paralyze() {
        //This will set the target enemy to have their turn skipped
        //until condition is cured
    }

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
