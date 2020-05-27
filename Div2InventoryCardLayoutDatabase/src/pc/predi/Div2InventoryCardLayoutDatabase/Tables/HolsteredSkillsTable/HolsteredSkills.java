package pc.predi.Div2InventoryCardLayoutDatabase.Tables.HolsteredSkillsTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HolsteredSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "WeaponType")
	private String weaponType;
	
	@Column(name = "HolsteredSkill")
	private String holsteredSkill;
	
	public HolsteredSkills() {
		
	}
	
	public HolsteredSkills(String weaponType, String holsteredSkill) {
		super();
		this.weaponType = weaponType;
		this.holsteredSkill = holsteredSkill;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public String getHolsteredSkill() {
		return holsteredSkill;
	}

	public void setHolsteredSkill(String holsteredSkill) {
		this.holsteredSkill = holsteredSkill;
	}
	
	
}
