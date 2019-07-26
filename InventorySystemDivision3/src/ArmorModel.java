/* Handles all the calculations needed.
 * 
 */

import java.util.Arrays;

public class ArmorModel {
	//instance variables
	private String[] armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	
	//Constructor
	public ArmorModel()
	{
		armorSlotTypes = new String[] { "Backpack", "Chest", "Gloves", "Holster", "Kneepads", "Mask" };
		
		armorBrandRolls = new String[] { "5.11", "Aces and Eights", "Airaldi", "Alps", "Badger", "Gila", "Hard Wired",
				"Murakami", "Negotiator's Dilemma", "Ongoing Directive", "Petrov", "Providence", "Richter & Kaiser",
				"Tip of the Spear", "True Patriot", "Wyvern Wear", "Fenris", "Gila", "Murakami", "Overlord", "Sokolov",
				"Yaahl", "China Light", "Douglas & Harding" };
		
		armorAttributeRolls = new String[] { "Assault Rifle Damage", "Critical Hit Chance", "Critical Hit Damage",
				"Damage to Elites", "Headshot Damage", "LMG Damage", "Marksman Rifle Damage", "Pistol Damage",
				"Rifle Damage", "Shotgun Damage", "SMG Damage", "Weapon Damage", "Bonus Armor", "Hazard Protection",
				"Health", "Health on Kill", "Cooldown Reduction", "Skill Power", "(None)" };
		
		armorTalentRolls = new String[] { "Hardened ", "Insulated ", "Restorative ", "Self Adjusting ", "Vital",
				"Capacitive ", "Destructive ", "On the Ropes", "Efficient ", "Safeguard ", "Skilled ", "Tech Support ",
				"Hard Hitting", "Vital ", "Destructive ", "Berserk ", "Unstoppable Force ", "Bloodsucker ", "Payload ",
				"Unbreakable ", "Mad Bomber ", "Critical ", "Devastating ", "Precise ", "Surgical ", "Compensated",
				"Obiliterate", "Opportunistic", "Wicked", "Clutch", "Knee Cap", "Terminate", "To Order", "Bloodlust",
				"Gunslinger", "Reassigned", "Blacksmith", "Fill'er up", "Entrench", "Patience", "Braced", "Calculated",
				"Cloaked", "Spotter", "Centered", "Creeping Death", "Dialed In", "Trauma", "(None)" };
		
		
		//sorts the arrays alphabetically
		Arrays.sort(armorSlotTypes);
		Arrays.sort(armorBrandRolls);
		Arrays.sort(armorAttributeRolls);
		Arrays.sort(armorTalentRolls);
	}
	
	//Getter setter methods
	public String[] getArmorSlotTypes() {
		return armorSlotTypes;
	}

	public void setArmorSlotTypes(String[] armorSlotTypes) {
		this.armorSlotTypes = armorSlotTypes;
	}

	public String[] getArmorBrandRolls() {
		return armorBrandRolls;
	}

	public void setArmorBrandRolls(String[] armorBrandRolls) {
		this.armorBrandRolls = armorBrandRolls;
	}

	public String[] getArmorAttributeRolls() {
		return armorAttributeRolls;
	}

	public void setArmorAttributeRolls(String[] armorAttributeRolls) {
		this.armorAttributeRolls = armorAttributeRolls;
	}

	public String[] getArmorTalentRolls() {
		return armorTalentRolls;
	}

	public void setArmorTalentRolls(String[] armorTalentRolls) {
		this.armorTalentRolls = armorTalentRolls;
	}
	
	//end getter setter methods
}
