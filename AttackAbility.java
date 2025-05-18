
public class AttackAbility {
	private double maxPower;		// The maximum power of the attack ability
	private double minPower;		// The minimum power of the attack ability
	private AttackType attackType;	// The type of attack (e.g., Biological, Mechanical)
	private String description;		// A brief description of the attack ability
	
	/**
     * Constructor to initialize an AttackAbility object.
     *
     * @param maxPower    The maximum power of the attack ability.
     * @param minPower    The minimum power of the attack ability.
     * @param attackType  The type of the attack ability.
     * @param description A description of the attack ability.
     */
	public AttackAbility(double maxPower, double minPower, AttackType attackType, String description) {
		this.maxPower = maxPower;
		this.minPower = minPower;
		this.attackType = attackType;
		this.description = description;}
	//Getter methods
	public double getMaxPower() {
		return maxPower;}
	
	public double getMinPower() {
		return minPower;}
	
	public AttackType getAttackType() {
		return attackType;}	
	
	public String getDescription() {
        return description;
    }


	/**
     * Overrides the toString() method to return the attack type as a string.
     *
     * @return The attack type in string format.
     */
	@Override
	public String toString() {
	return "" + attackType ;
}
}
