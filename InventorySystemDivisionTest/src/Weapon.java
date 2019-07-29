import java.awt.event.ActionEvent;

public class Weapon {
	String weaponType, weaponVariant, activeSkill, handlingSkill, holsteredSkill;
	
	public Weapon(String weaponType, String weaponVariant, String activeSkill, String handlingSkill, String holsteredSkill )
	{
		this.weaponType = weaponType;
		this.weaponVariant = weaponVariant;
		this.activeSkill = activeSkill;
		this.handlingSkill = handlingSkill;
		this.holsteredSkill = holsteredSkill;
		
	}
	
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
	
	public String getHandlingSkill()
	{
		return handlingSkill;
	}
	
	public void setHandlingSkill(String handlingSkill)
	{
		this.handlingSkill = handlingSkill;
	}
	
	public String getHolsteredSkill()
	{
		return holsteredSkill;
	}
	
	public void setHolsteredSkill(String holsteredSkill)
	{
		this.holsteredSkill = holsteredSkill;
	}
	
	public String toString()
	{
		return weaponType + " " + weaponVariant + " " + activeSkill + " " + handlingSkill + " " + holsteredSkill;
	}
}
