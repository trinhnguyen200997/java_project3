
public class Monster extends Hero_TN623245 {
    private double minPower; // Specific to Monster class (minPower)

     /**
     * Constructor for Monster
     * 
     * @param type          The type of the hero (e.g., Monster)
     * @param name          The name of the monster
     * @param health        The health points of the monster
     * @param power         The base power of the monster
     * @param description   A description of the monster
     * @param attackAbility The attack ability of the monster
     * @param speed         The speed of the monster
     * @param minPower      The minimum power the monster can have when health is very low
     */
   
        public Monster(String type, String name, int health, double power, String description, AttackAbility attackAbility, double speed, double minPower) {
        super(type, name, health, power, description, attackAbility, speed); // Calling the constructor of the superclass Hero
        this.minPower = minPower;	// Set the minimum power specific to the Monster
    }

   
        /**
         * Override the getPower() method for Monster
         * Determines the current power of the monster based on its health percentage.
         * 
         * @return The current power level based on health thresholds:
         *         - 75% or above health: Maximum base power
         *         - 50%-74% health: Half of the base power
         *         - 25%-49% health: Quarter of the base power
         *         - 0%-24% health: Minimum power
         *         - 0% health: Zero power
         */
    @Override
    public double getPower() {
    	int health =getHealth();	// Get the current health of the monster
    	
    	if(health >=75) {
    		return power;			// Maximum power if health is 75% or above
    	}else if (health >= 50) {
    		return power/2;			// Half the power if health is between 50% and 75%
    	} else if (health >= 25) {
            return power/4;			// Quarter of the power if health is between 25% and 50%
        } else if (health > 0) {
            return minPower;		// Minimum power if health is between 0% and 25%
        } else {
            return 0;				// Zero power if health is 0%
    	} 
    }

    /**
     * Override the toString() method for Monster
     * 
     * @return A string representation of the Monster, including its attributes
     *         and the minimum power.
     */
    @Override
    public String toString() {
    	return super.toString() + ", MinPower: " + minPower;
    }
}
