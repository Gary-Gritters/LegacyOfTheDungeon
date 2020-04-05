package PlayerCharacter;

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


    }
}
