/*
 * Weapon object to be invoked in the WeaponController
 */

public class Weapon {
	//instance variables
	String weaponType, weaponVariant, activeSkill, handlingSkill, holsteredSkill;
	
	//Constructor
	public Weapon(String weaponType, String weaponVariant, String activeSkill, String handlingSkill, String holsteredSkill )
	{
		this.weaponType = weaponType;
		this.weaponVariant = weaponVariant;
		this.activeSkill = activeSkill;
		this.handlingSkill = handlingSkill;
		this.holsteredSkill = holsteredSkill;
		
	}
	
	//getter and setter methods
	public String getWeaponCategory()
	{
		return weaponType;
	}
	
	public void setWeaponCategory(String weaponType)
	{
		this.weaponType = weaponType;
	}
		
	public String getWeaponVariant()
	{
		return weaponVariant;
	}
	
	public void setWeaponVariant(String weaponVariant)
	{
		this.weaponVariant = weaponVariant;
	}
	
	public String getActiveSkill()
	{
		return activeSkill;
	}
	
	public void setActiveSkill(String activeSkill)
	{
		this.activeSkill = activeSkill;
	}
	
	public String getHandlingSkill() {
		return handlingSkill;
	}

	public void setHandlingSkill(String handlingSkill) {
		this.handlingSkill = handlingSkill;
	}

	/*
	 * public String getHandlingSkill2() { return handlingSkill2; }
	 * 
	 * public void setHandlingSkill2(String handlingSkill2) { this.handlingSkill2 =
	 * handlingSkill2; }
	 */
	
	public String getHolsteredSkill()
	{
		return holsteredSkill;
	}
	
	public void setHolsteredSkill(String holsteredSkill)
	{
		this.holsteredSkill = holsteredSkill;
	}
	
	//end getter and setter methods
	
	//toString
	public String toString()
	{
		return weaponType + "," + weaponVariant + "," + activeSkill + "," + handlingSkill + "," + holsteredSkill;
	}
}
