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
        nextLevel += 1000 * level;

        if (level == 3) {
            System.out.println("You learned Hide!");
        }

        if (level == 5) {
            System.out.println("You learned Mug!");
        }

        if (level == 7) {
            System.out.println("You learned Seller's Talk!");
            //Passively increase sale value on items the
            //rogue is carrying by 10%
        }

        if (level == 10) {
            System.out.println("You learned Treasure Hunter!");
            //Passively increase the chance of acquiring rare
            //treasure from dungeon runs
        }

        if (experience >= nextLevel) {
            levelUp();
        }
    }

    private void hide() {
        int backstab = (strength + weaponDamage) * 2;
        //Remove this character from battle for one turn
        boolean isHidden = true;
        if (isHidden == true) {
            damage = backstab;
            isHidden = false;
        }
    }

    private void mug() {
        int mugDamage = (strength + weaponDamage) / 2;
        //Attempt to steal an item off an enemy
    }
}
