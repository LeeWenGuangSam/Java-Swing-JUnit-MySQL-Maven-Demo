package pc.predi.Div2InventoryCardLayoutDatabase.Tables.ActiveSkillsTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "ActiveSkills")
@Table(name = "ActiveSkills")
public class ActiveSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ActiveSkill")
	private String activeSkill;
	
	@Column(name = "WeaponType")
	private String weaponType;
	
	public ActiveSkills() {
		
	}
	
	public ActiveSkills(String activeSkill, String weaponType) {
		this.activeSkill = activeSkill;
		this.weaponType = weaponType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActiveSkill() {
		return activeSkill;
	}

	public void setActiveSkill(String activeSkill) {
		this.activeSkill = activeSkill;
	}
	
	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
}
