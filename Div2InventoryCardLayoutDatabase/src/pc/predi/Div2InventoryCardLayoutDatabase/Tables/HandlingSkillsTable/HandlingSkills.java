package pc.predi.Div2InventoryCardLayoutDatabase.Tables.HandlingSkillsTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HandlingSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "WeaponType")
	private String weaponType;
	
	@Column(name = "HandlingSkill")
	private String handlingSkill;
	
	public HandlingSkills() {
		
	}
	
	public HandlingSkills(String weaponType, String handlingSkill) {
		super();
		this.weaponType = weaponType;
		this.handlingSkill = handlingSkill;
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

	public String getHandlingSkill() {
		return handlingSkill;
	}

	public void setHandlingSkill(String handlingSkill) {
		this.handlingSkill = handlingSkill;
	}
	
	
}
