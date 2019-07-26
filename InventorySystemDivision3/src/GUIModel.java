/*
 * GUIModel handles all the calculations needed.
 * However, since this is just a program that prints String values into a .csv file, this class will mostly be empty.
 */
public class GUIModel {
	//instance variables
	private String[] weaponCategories = { "Weapon", "Armor", "Mod" };
	//private Weapon weapon;
	
	//Constructor
	public GUIModel() {

	}
	
	//Getter setter methods

	public String[] getWeaponCategories() {
		return weaponCategories;
	}

	public void setWeaponCategories(String[] weaponCategories) {
		this.weaponCategories = weaponCategories;
	}
	
	//end getter setter methods
}
