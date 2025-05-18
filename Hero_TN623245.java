import java.util.Random;
/**
 * Abstract superclass representing a Hero in the game.
 * Each hero has attributes such as type, name, health, power, description, 
 * attack ability, and speed. This class also keeps track of the total number of heroes created.
 */
public abstract class Hero_TN623245 {
	
	//Static variable to hold the number of characters
	protected static int totalNumber = 0;
	
	// Attributes of heroes
	protected String type;							// The type or category of the hero
	protected String name;							//Name of the hero
	protected int health;							//The health point of the hero
	protected double power; 						//The power level of the hero
	protected String description;					// The description of the hero
	protected AttackAbility attackAbility;			//The attack ability of the hero
	protected double speed;							//The Speed of the hero
	
	
	/**
	 * Constructor to initialize a hero with its attributes.
	 *
	 * @param type           The type or category of the hero.
	 * @param name           The name of the hero.
	 * @param health         The health points of the hero.
	 * @param power          The power level of the hero.
	 * @param description    A brief description of the hero.
	 * @param attackAbility  The attack ability of the hero.
	 * @param speed          The speed attribute of the hero.
	 */
	public Hero_TN623245(String type, String name,  int health, double power, String descripton, AttackAbility attackAbility, double speed) {
		this.type = type;					//Set the type of hero
		this.name = name;					//Set the name of hero 
		this.health =health;				//Set the health score for hero 
		this.power = power;					//Set the power level for hero 
		this.description = description;		//Set the description for hero 
		this.attackAbility = attackAbility;	//Set the ability to attack of the hero 	
		this.speed = speed;					//Set the speed of hero 
		totalNumber++;						//Increment the total number of heroes
	}
	
	//Method to get the name of hero in the game
	public String getName() {
		return name;	//Return the hero's name
	}
	
	//Method to get the health of hero in the game
	public int getHealth() {
		return health;	//Return the hero's health
	}
	
	//Method to get the attack ability of hero in the game
	public AttackAbility getAttackAbility() {
        return attackAbility;}	//Return hero's attack ability
	
	//Method to get the speed of hero in the game
	public double getSpeed() {
        return speed;		//Return hero's speed
    }
   
	//Method to set the health of hero in the game
	public void setHealth(int h) {
		health = h;		//Update hero's health
	}
	
	/**
	 * Abstract method to calculate and return the hero's power.
	 * This method must be implemented in the subclasses.
	 *
	 * @return The power level of the hero.
	 */
	public abstract double getPower();
	
	
	/**
	 * Override the toString method to provide a string representation of the hero.
	 *
	 * @return A string containing the hero's attributes.
	 */
	@Override
	public String toString() {
	    return "Type: " + type +
	    		", Name: " + name +
	           ", Health: " + health +
	           ", Attack Ability: " + attackAbility +
	           ", Speed: " + speed +
	           ", Power: " + getPower();
	}
}