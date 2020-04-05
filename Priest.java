package PlayerCharacter;

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
    }
}
