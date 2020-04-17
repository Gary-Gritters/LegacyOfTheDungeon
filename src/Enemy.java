import java.util.Random;

/***************************************************
 * This class manages each enemy which will be 
 * encountered by the player.
 *
 * @author Jarett Allie
 ***************************************************/
public class Enemy {
	//hold final string array with available names
	//for each enemy
	protected static final String[] NAMES = { "Zombie",
			"Human", "Vampire", "Goblin", 
			"Skeleton Archer"};
    //create new instance of random variable
	private Random rand = new Random();
	
	//holds the enemies health
	protected double health;
	//holds the enemies damage
	protected double damage;
	//holds the enemies crit multiplier
	protected double critMult;
	//holds the enemies name
	protected String name;
	
	/*********************************************
     * This generates the name for the enemy and
     * sets the health.
     *********************************************/
	protected Enemy() 
	{
        //assign a random name to the enemy
		name = NAMES[rand.nextInt(NAMES.length)];
		//generate random health to add to enemy
		double randHealth = Math.pow(2,rand.nextInt(3));
		//switch case for health of each enemy
        switch(name) {
        case "Zombie":
        	health = 7.5+ randHealth;
        	break;
        case "Vampire":
        	health = 15 + randHealth;
        	break;
        case "Goblin":
        	health = 5.0 + randHealth;
        	break;
        case "Human":
        	health = 12.5+ randHealth;
        	break;
        case "Zombie Archer":
        	health = 10.0 + randHealth;
        	break;
        default:
        	break;
        }
	}
	
	/*********************************************
     * This generates the attack value for the
     * enemy.
     *********************************************/
	protected void attack() 
	{
		//create random crit chance for the enemy
		double critChance = rand.nextInt(10);
		
		//generate crit multiplier for enemy if
		//crit chance is greater than 4
		if(critChance <= 4)
			critMult = 1;
		else
			critMult = critChance * 0.3;
		
		//switch case for damage of each enemy
        switch(name) {
        case "Zombie":
        	damage = rand.nextInt(4) * critMult;
        	break;
        case "Vampire":
        	damage = rand.nextInt(6) * critMult;
        	break;
        case "Goblin":
        	damage = rand.nextInt(2) * critMult;
        	break;
        case "Human":
        	damage = rand.nextInt(8) * critMult;
        	break;
        case "Zombie Archer":
        	health = 10.0;
        	damage = rand.nextInt(5) * critMult;
        	break;
        default:
        	break;
        }
	}

	/*********************************************
     * This depletes the enemy class health when
     * attacked by the player.
     * 
     * @param d the damage received
     *********************************************/
    protected void receiveDam(double d)
    {
    	//remove health
        health -= d;
        checkDeath();
    } 
    
    /*********************************************
     * This returns the name of the enemy.
     *********************************************/
    protected String getName()
    {
        return name;
    }
   
    /*********************************************
     * This returns the health of the enemy.
     *********************************************/
    protected double health()
    {
        return health;
    }
    
    /*********************************************
     * This checks if the enemy has died when its
     * health reaches 0.
     * 
     * @return true if health is 0
     *********************************************/
    protected boolean checkDeath() 
    {
    	if(health == 0) {
    		System.out.println(name + " is defeated!");
    		return true;
    	}
    	return false;
    }
	
}
