/**
 * Enum AttackType
 * Represents different types of attack categories a hero can possess.
 */
public enum AttackType {
	Biological,Electromagnetic, Mechanical, NatureControl;
	
	
	/**
     * Overrides the toString() method to return the name of the enum constant.
     * 
     * @return The name of the attack type as a string.
     */
	@Override
	public String toString() {
		return this.name();
	}
}
