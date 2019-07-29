import java.util.ArrayList;

public class EquipmentData {
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private ArrayList<Armor> armors = new ArrayList<Armor>();
	
	public EquipmentData(ArrayList<Weapon >weapons, ArrayList<Armor> armors)
	{
		this.weapons = weapons;
		this.armors = armors;
	}
	
	public void addWeapon(String weaponType, String weaponVariant, String activeSkill, String handlingSkill, String holsteredSkill)
	{
		weapons.add(new Weapon(weaponType, weaponVariant, activeSkill, handlingSkill, holsteredSkill));
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}

	public ArrayList<Armor> getArmors() {
		return armors;
	}

	public void setArmors(ArrayList<Armor> armors) {
		this.armors = armors;
	}

	@Override
	public String toString() {
		return "EquipmentData [weapons=" + weapons + ", armors=" + armors + "]";
	}
	
	
}
