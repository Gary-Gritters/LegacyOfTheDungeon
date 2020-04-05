package PlayerCharacter;

public class Fighter extends PlayerCharacter {

    private Fighter(String name, int str, int dex, int con, int mind,
                    int hp, int mp, int lv, int exp, int gold) {
        super(name, str, dex, con, mind, hp, mp, lv, exp, gold);

        name = "";
        str = 4;
        dex = 2;
        con = 3;
        mind = 1;
        hp = 10 + con;
        mp = 0;
        lv = 1;
        exp = 0;
        gold = 0;
    }

    private levelUp() {

        level++;
        strength += 3;
        dexterity += 2;
        constitution += 3;
        intelligence += 1;
        System.out.println("Please distribute remaining stat points");
    }

    public abilityType() {

        int requiredLevel = 3;
        String abilityName = "Focus";
        int damage = (strength + weaponDamage) * 0.5;
        //Also make fighter wait a turn before using attack
        //then set damage back to normal
    }


}
