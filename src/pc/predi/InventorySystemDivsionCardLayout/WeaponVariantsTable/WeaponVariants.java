package pc.predi.InventorySystemDivsionCardLayout.WeaponVariantsTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "WeaponVariants")
@Table(name = "WeaponVariants")
public class WeaponVariants {
	
	@Id
	@Column(name = "WeaponVariant")
	private String weaponVariant;
	@Column(name = "WeaponType")
	private String weaponType;
	public WeaponVariants(){
		
	}
	public WeaponVariants(String weaponVariant, String weaponType) {
		super();
		this.weaponVariant = weaponVariant;
		this.weaponType = weaponType;
	}
	public String getWeaponVariant() {
		return weaponVariant;
	}
	public void setWeaponVariant(String weaponVariant) {
		weaponVariant = weaponVariant;
	}
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	
	
}
