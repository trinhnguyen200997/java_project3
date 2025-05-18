// The NonLiving class, a subclass of Hero_TN623245,
public class NonLiving extends Hero_TN623245 {
	
	//hold the number of non-living characters
	private static int nonLivingNumber = 0; 	
	
	/**
     * Constructor to initialize a NonLiving hero
     * 
     * @param type          The type of the hero (e.g., NonLiving)
     * @param name          The name of the NonLiving hero
     * @param health        The health points of the hero
     * @param power         The base power level of the hero
     * @param description   A description of the hero
     * @param attackAbility The attack ability of the hero
     * @param speed         The speed of the hero
     */
	public NonLiving(String type, String name, int health,  double power,String description, AttackAbility attackAbility, double speed) {
		// Call the constructor of the superclass Hero_TN623245 to set up attributes
		super(type, name, health, power, description, attackAbility, speed);
		nonLivingNumber++;
	}
	
	
	//Getter methods 
	public static int getNonLivingNumber() {
		return nonLivingNumber;}	// Return the total number of NonLiving heroes created
		
		
	/**
     * Override the getPower() method for NonLiving heroes
     * 
     * @return The power level of the hero:
     *         - If health is greater than 0%, the power is equal to its initial value.
     *         - If health is 0%, the power is 0.
     */
	@Override
	public double getPower() {
		// If health is greater than 0, the power is equal to its value set initially
        // Otherwise, the power is 0
		if(getHealth()> 0) {	
			return power;}			// Return the maximum power if health is above 0%	
		return 0;
		}
	
	
	/**
    * Override the toString() method for NonLiving heroes
    * 
    * @return The string representation of the hero, using the superclass's
    *         implementation
    */
	@Override
	public String toString() {
		return super.toString();	// Return the string representation from the superclass
	}
	
}

