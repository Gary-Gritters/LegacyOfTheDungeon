import java.util.Random;

public class Enemy {
	protected static final String[] NAMES = { "Zombie", "Human", "Vampire", "Goblin", "Skeleton Archer"};
   
	private Random rand = new Random();
	
	protected double health;
	protected double damage;
	protected double critMult;
	
	protected String name;
	
	protected Enemy() {
        name = NAMES[rand.nextInt(NAMES.length)];
        
        health = rand.nextInt(20) + 15;
        
	}
	
	protected double attack()
    {
		damage = rand.nextInt(10) + 5;
		return damage;
    } 

   
    protected void receiveDam(double d)
    {
        health -= d;
    } 
    
    protected String getName()
    {
        return name;
    }
   
    protected double health()
    {
        return health;
    }
	
}
