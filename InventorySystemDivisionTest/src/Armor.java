import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Armor {

	private ArrayList<String> armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	private String armorVariant, armorValue, armorSlotType, armorBrandRoll, armorAttributeRoll1, armorAttributeValue1, armorAttributeRoll2,
			armorAttributeValue2, armorAttributeRoll3, armorAttributeValue3, armorAttributeRoll4, armorAttributeValue4,
			armorTalentRoll1, armorTalentRoll2;

	public Armor(String armorVariant, String armorValue, String armorSlotType, String armorBrandRoll, String armorAttributeRoll1, String armorAttributeValue1,
			String armorAttributeRoll2, String armorAttributeValue2, String armorAttributeRoll3,
			String armorAttributeValue3, String armorAttributeRoll4, String armorAttributeValue4,
			String armorTalentRoll1, String armorTalentRoll2) {
		this.armorVariant = armorVariant;
		this.armorValue = armorValue;
		this.armorSlotType = armorSlotType;
		this.armorBrandRoll = armorBrandRoll;
		this.armorAttributeRoll1 = armorAttributeRoll1;
		this.armorAttributeValue1 = armorAttributeValue1;
		this.armorAttributeRoll2 = armorAttributeRoll2;
		this.armorAttributeValue2 = armorAttributeValue2;
		this.armorAttributeRoll3 = armorAttributeRoll3;
		this.armorAttributeValue3 = armorAttributeValue3;
		this.armorAttributeRoll4 = armorAttributeRoll4;
		this.armorAttributeValue4 = armorAttributeValue4;
		this.armorTalentRoll1 = armorTalentRoll1;
		this.armorTalentRoll2 = armorTalentRoll2;
	}
	
	public String getArmorVariant() {
		return armorVariant;
	}

	public void setArmorVariant(String armorVariant) {
		this.armorVariant = armorVariant;
	}

	public String getArmorValue() {
		return armorValue;
	}

	public void setArmorValue(String armorValue) {
		this.armorValue = armorValue;
	}
	
	public String getArmorSlotType() {
		return armorSlotType;
	}

	public String getArmorAttributeValue1() {
		return armorAttributeValue1;
	}

	public void setArmorAttributeValue1(String armorAttributeValue1) {
		this.armorAttributeValue1 = armorAttributeValue1;
	}

	public String getArmorAttributeValue2() {
		return armorAttributeValue2;
	}

	public void setArmorAttributeValue2(String armorAttributeValue2) {
		this.armorAttributeValue2 = armorAttributeValue2;
	}

	public String getArmorAttributeValue3() {
		return armorAttributeValue3;
	}

	public void setArmorAttributeValue3(String armorAttributeValue3) {
		this.armorAttributeValue3 = armorAttributeValue3;
	}

	public String getArmorAttributeValue4() {
		return armorAttributeValue4;
	}

	public void setArmorAttributeValue4(String armorAttributeValue4) {
		this.armorAttributeValue4 = armorAttributeValue4;
	}

	public void setArmorSlotType(String armorSlotType) {
		this.armorSlotType = armorSlotType;
	}

	public String getArmorBrandRoll() {
		return armorBrandRoll;
	}

	public void setArmorBrandRoll(String armorBrandRoll) {
		this.armorBrandRoll = armorBrandRoll;
	}

	public String getArmorWeaponRoll1() {
		return armorAttributeRoll1;
	}

	public void setArmorWeaponRoll1(String armorWeaponRoll1) {
		this.armorAttributeRoll1 = armorWeaponRoll1;
	}

	public String getArmorWeaponRoll2() {
		return armorAttributeRoll2;
	}

	public void setArmorWeaponRoll2(String armorWeaponRoll2) {
		this.armorAttributeRoll2 = armorWeaponRoll2;
	}

	public String getArmorWeaponRoll3() {
		return armorAttributeRoll3;
	}

	public void setArmorWeaponRoll3(String armorWeaponRoll3) {
		this.armorAttributeRoll3 = armorWeaponRoll3;
	}

	public String getArmorWeaponRoll4() {
		return armorAttributeRoll4;
	}

	public void setArmorWeaponRoll4(String armorWeaponRoll4) {
		this.armorAttributeRoll4 = armorWeaponRoll4;
	}

	public String getArmorTalentRoll1() {
		return armorTalentRoll1;
	}

	public void setArmorTalentRoll1(String armorTalentRoll1) {
		this.armorTalentRoll1 = armorTalentRoll1;
	}

	public String getArmorTalentRoll2() {
		return armorTalentRoll2;
	}

	public void setArmorTalentRoll2(String armorTalentRoll2) {
		this.armorTalentRoll2 = armorTalentRoll2;
	}

	public ArrayList<String> populateArmorSlotTypes() {
		armorSlotTypes = new ArrayList<String>();
		armorSlotTypes.add("Backpack");
		armorSlotTypes.add("Chest");
		armorSlotTypes.add("Gloves");
		armorSlotTypes.add("Holster");
		armorSlotTypes.add("Kneepads");
		armorSlotTypes.add("Mask");
		Collections.sort(armorSlotTypes);
		return armorSlotTypes;
	}

	public ArrayList<String> getArmorSlotTypes() {
		armorSlotTypes = populateArmorSlotTypes();
		return armorSlotTypes;
	}

	public ArrayList<String> populateArmorBrandRolls() {
		armorBrandRolls = new ArrayList<String>();
		armorBrandRolls.add("5.11");
		armorBrandRolls.add("Aces and Eights");
		armorBrandRolls.add("Airaldi");
		armorBrandRolls.add("Alps");
		armorBrandRolls.add("Badger");
		armorBrandRolls.add("Gila");
		armorBrandRolls.add("Hard Wired");
		armorBrandRolls.add("Murakami");
		armorBrandRolls.add("Negotiator's Dilemma");
		armorBrandRolls.add("Ongoing Directive");
		armorBrandRolls.add("Petrov");
		armorBrandRolls.add("Providence");
		armorBrandRolls.add("Richter & Kaiser");
		armorBrandRolls.add("Tip of the Spear");
		armorBrandRolls.add("True Patriot");
		armorBrandRolls.add("Wyvern Wear");
		armorBrandRolls.add("Fenris");
		armorBrandRolls.add("Gila");
		armorBrandRolls.add("Murakami");
		armorBrandRolls.add("Overlord");
		armorBrandRolls.add("Sokolov");
		armorBrandRolls.add("Yaahl");
		armorBrandRolls.add("China Light");
		armorBrandRolls.add("Douglas & Harding");
		Collections.sort(armorBrandRolls);
		return armorBrandRolls;
	}

	public ArrayList<String> getArmorBrandRolls() {
		armorBrandRolls = populateArmorBrandRolls();
		return armorBrandRolls;
	}

	public ArrayList<String> populateArmorAttributeRolls() {
		armorAttributeRolls = new ArrayList<String>();
		armorAttributeRolls.add("Assault Rifle Damage");
		armorAttributeRolls.add("Critical Hit Chance");
		armorAttributeRolls.add("Critical Hit Damage");
		armorAttributeRolls.add("Damage to Elites");
		armorAttributeRolls.add("Headshot Damage");
		armorAttributeRolls.add("LMG Damage");
		armorAttributeRolls.add("Marksman Rifle Damage");
		armorAttributeRolls.add("Pistol Damage");
		armorAttributeRolls.add("Rifle Damage");
		armorAttributeRolls.add("Shotgun Damage");
		armorAttributeRolls.add("SMG Damage");
		armorAttributeRolls.add("Weapon Damage");
		armorAttributeRolls.add("Bonus Armor");
		armorAttributeRolls.add("Hazard Protection");
		armorAttributeRolls.add("Health");
		armorAttributeRolls.add("Health on Kill");
		armorAttributeRolls.add("Cooldown Reduction");
		armorAttributeRolls.add("Skill Power");
		Collections.sort(armorAttributeRolls);
		return armorAttributeRolls;
	}

	public ArrayList<String> getArmorAttributeRolls() {
		armorAttributeRolls = populateArmorAttributeRolls();
		return armorAttributeRolls;
	}

	public ArrayList<String> populateArmorTalentRolls() {
		armorTalentRolls = new ArrayList<String>();
		armorTalentRolls.add("Hardened");
		armorTalentRolls.add("Insulated");
		armorTalentRolls.add("Restorative");
		armorTalentRolls.add("Self Adjusting ");
		armorTalentRolls.add("Vital");
		armorTalentRolls.add("Capacitive ");
		armorTalentRolls.add("Destructive");
		armorTalentRolls.add("On the Ropes");
		armorTalentRolls.add("Efficient");
		armorTalentRolls.add("Safeguard");
		armorTalentRolls.add("Skilled ");
		armorTalentRolls.add("Tech Support");
		armorTalentRolls.add("Hard Hitting");
		armorTalentRolls.add("Vital ");
		armorTalentRolls.add("Destructive ");
		armorTalentRolls.add("Berserk ");
		armorTalentRolls.add("Unstoppable Force ");
		armorTalentRolls.add("Bloodsucker ");
		armorTalentRolls.add("Payload ");
		armorTalentRolls.add("Unbreakable ");
		armorTalentRolls.add("Mad Bomber ");
		armorTalentRolls.add("Critical");
		armorTalentRolls.add("Devastating");
		armorTalentRolls.add("Precise");
		armorTalentRolls.add("Surgical ");
		armorTalentRolls.add("Compensated");
		armorTalentRolls.add("Obiliterate");
		armorTalentRolls.add("Opportunistic");
		armorTalentRolls.add("Wicked");
		armorTalentRolls.add("Clutch");
		armorTalentRolls.add("Knee Cap");
		armorTalentRolls.add("Terminate");
		armorTalentRolls.add("To Order");
		armorTalentRolls.add("Bloodlust");
		armorTalentRolls.add("Gunslinger");
		armorTalentRolls.add("Reassigned");
		armorTalentRolls.add("Blacksmith");
		armorTalentRolls.add("Fill'er up");
		armorTalentRolls.add("Entrench");
		armorTalentRolls.add("Patience");
		armorTalentRolls.add("Braced");
		armorTalentRolls.add("Calculated");
		armorTalentRolls.add("Cloaked");
		armorTalentRolls.add("Spotter");
		armorTalentRolls.add("Centered");
		armorTalentRolls.add("Creeping Death");
		armorTalentRolls.add("Dialed In");
		armorTalentRolls.add("Trauma");
		Collections.sort(armorTalentRolls);
		return armorTalentRolls;
	}

	public ArrayList<String> getArmorTalentRolls() {
		armorTalentRolls = populateArmorTalentRolls();
		return armorTalentRolls;
	}

	@Override
	public String toString() {
		return "Armor [armorBrandRolls= " + armorBrandRolls + ", armorSlotType= " + armorSlotType + ", armorBrandRoll= "
				+ armorBrandRoll + ", armorAttributeRoll1= " + armorAttributeRoll1 + ", armorAttributeValue1= "
				+ armorAttributeValue1 + ", armorAttributeRoll2= " + armorAttributeRoll2 + ", armorAttributeValue2= "
				+ armorAttributeValue2 + ", armorAttributeRoll3= " + armorAttributeRoll3 + ", armorAttributeValue3= "
				+ armorAttributeValue3 + ", armorAttributeRoll4= " + armorAttributeRoll4 + ", armorAttributeValue4= "
				+ armorAttributeValue4 + ", armorTalentRoll1= " + armorTalentRoll1 + ", armorTalentRoll2= "
				+ armorTalentRoll2 + "]";
	}

}
