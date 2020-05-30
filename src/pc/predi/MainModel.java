package pc.predi;

public class MainModel {
	private WeaponModel weaponModel;
	private ArmorModel armorModel;
	public MainModel() {
		weaponModel = new WeaponModel();
		armorModel = new ArmorModel();
	}
	public WeaponModel getWeaponModel() {
		return weaponModel;
	}
	public void setWeapon(WeaponModel weapon) {
		this.weaponModel = weapon;
	}
	public ArmorModel getArmorModel() {
		return armorModel;
	}
	public void setArmor(ArmorModel armor) {
		this.armorModel = armor;
	}
	
	
}