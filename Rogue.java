package PlayerCharacter;

public class Rogue extends PlayerCharacter{

    private Rogue(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, gold);

        name = "";
        str = 2;
        dex = 4;
        con = 2;
        mind = 2;
        hp = 8 + con;
        mp = 0;
        lv = 1;
        exp = 0;
        gold = 0;

    }

    private levelUp() {

        level++;
        strength += 2;
        dexterity += 3;
        constitution += 2;
        intelligence += 2;
        System.out.println("Please distribute remaining stat points");


    }
}
