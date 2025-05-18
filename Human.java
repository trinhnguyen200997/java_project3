// The Human class, a subclass of Hero_TN623245
public class Human extends Hero_TN623245 {
	
	/**
     * Constructor to initialize a Human hero
     * 
     * @param type          The type of the hero (e.g., Human)
     * @param name          The name of the Human hero
     * @param health        The health points of the hero
     * @param power         The base power level of the hero
     * @param description   A description of the hero
     * @param attackAbility The attack ability of the hero
     * @param speed         The speed of the hero
     */
	public Human(String type, String name,  int health,  double power, String description, AttackAbility attackAbility, double speed) {
		// Call the constructor of the superclass Hero_TN623245 to set up attributes
		super(type,name, health, power, description, attackAbility, speed);}
	
	/**
     * Override the getPower() method for Human heroes
     * 
     * @return The power level of the hero, calculated as a percentage of the base 
     *         power based on the hero's current health
     */
	@Override
	public double getPower() {
		return (health/100)*power;	// Calculate power as health percentage of base power
	}
	
	/**
     * Override the toString() method for Human heroes
     * 
     * @return The string representation of the hero, using the superclass's
     *         implementation
     */
	@Override
	public String toString() {
		return super.toString();	// Return the string representation from the superclass
	}
}
