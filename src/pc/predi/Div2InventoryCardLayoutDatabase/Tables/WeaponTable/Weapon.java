package pc.predi.Div2InventoryCardLayoutDatabase.Tables.WeaponTable;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Weapon")
public class Weapon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "WeaponType")
	private String weaponType;
	@Column(name = "WeaponVariant")
	private String weaponVariant;
	@Column(name = "WeaponDamage")
	private String weaponDamage;
	@Column(name = "ActiveSkill")
	private String activeSkill;
	@Column(name = "HandlingSkill")
	private String handlingSkill;
	@Column(name = "HolsteredSkill")
	private String holsteredSkill;
	@Column(name = "DateCreated")
	private LocalDate dateCreated;
	@Column(name = "TimeCreated")
	private LocalTime timeCreated;
	
	//constructors
	public Weapon() {
		
	}
	
	public Weapon(String weaponType, String weaponVariant, String weaponDamage, String activeSkill,
			String handlingSkill, String holsteredSkill) {
		super();
		this.weaponType = weaponType;
		this.weaponVariant = weaponVariant;
		this.weaponDamage = weaponDamage;
		this.activeSkill = activeSkill;
		this.handlingSkill = handlingSkill;
		this.holsteredSkill = holsteredSkill;
		this.dateCreated = LocalDate.now();
		this.timeCreated = LocalTime.now();
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public String getWeaponVariant() {
		return weaponVariant;
	}

	public void setWeaponVariant(String weaponVariant) {
		this.weaponVariant = weaponVariant;
	}

	public String getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(String weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public String getActiveSkill() {
		return activeSkill;
	}

	public void setActiveSkill(String activeSkill) {
		this.activeSkill = activeSkill;
	}

	public String getHandlingSkill() {
		return handlingSkill;
	}

	public void setHandlingSkill(String handlingSkill) {
		this.handlingSkill = handlingSkill;
	}

	public String getHolsteredSkill() {
		return holsteredSkill;
	}

	public void setHolsteredSkill(String holsteredSkill) {
		this.holsteredSkill = holsteredSkill;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", weaponType=" + weaponType + ", weaponVariant=" + weaponVariant
				+ ", weaponDamage=" + weaponDamage + ", activeSkill=" + activeSkill + ", handlingSkill=" + handlingSkill
				+ ", holsteredSkill=" + holsteredSkill + ", dateCreated=" + dateCreated + ", timeCreated=" + timeCreated
				+ "]";
	}
	
	
}
