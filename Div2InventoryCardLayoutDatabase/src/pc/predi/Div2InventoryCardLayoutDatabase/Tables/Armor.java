package pc.predi.Div2InventoryCardLayoutDatabase.Tables;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Armor {
	//instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String armorType;
	private String armorVariant;
	private String armorBrand;
	private String attributeRoll_1;
	private String attributeValue_1;
	private String attributeRoll_2;
	private String attributeValue_2;
	private String attributeRoll_3;
	private String attributeValue_3;
	private String attributeRoll_4;
	private String attributeValue_4;
	private String talentRoll_1;
	private String talentValue_1;
	private String talentRoll_2;
	private String talentValue_2;
	private String modRoll_1;
	private String modRoll_2;
	private String modRoll_3;
	private LocalDate dateCreated;
	private LocalTime timeCreated;
	
	
	//constructors	
	public Armor() {
		
	}

	public Armor(String armorType, String armorVariant, String armorBrand, String attributeRoll_1,
			String attributeValue_1, String attributeRoll_2, String attributeValue_2, String attributeRoll_3,
			String attributeValue_3, String attributeRoll_4, String attributeValue_4, String talentRoll_1,
			String talentValue_1, String talentRoll_2, String talentValue_2, String modRoll_1, String modRoll_2,
			String modRoll_3) {
		super();
		this.armorType = armorType;
		this.armorVariant = armorVariant;
		this.armorBrand = armorBrand;
		this.attributeRoll_1 = attributeRoll_1;
		this.attributeValue_1 = attributeValue_1;
		this.attributeRoll_2 = attributeRoll_2;
		this.attributeValue_2 = attributeValue_2;
		this.attributeRoll_3 = attributeRoll_3;
		this.attributeValue_3 = attributeValue_3;
		this.attributeRoll_4 = attributeRoll_4;
		this.attributeValue_4 = attributeValue_4;
		this.talentRoll_1 = talentRoll_1;
		this.talentValue_1 = talentValue_1;
		this.talentRoll_2 = talentRoll_2;
		this.talentValue_2 = talentValue_2;
		this.modRoll_1 = modRoll_1;
		this.modRoll_2 = modRoll_2;
		this.modRoll_3 = modRoll_3;
		this.dateCreated = LocalDate.now();
		this.timeCreated = LocalTime.now();
	}
	//getter and setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getArmorType() {
		return armorType;
	}


	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}


	public String getArmorVariant() {
		return armorVariant;
	}


	public void setArmorVariant(String armorVariant) {
		this.armorVariant = armorVariant;
	}


	public String getArmorBrand() {
		return armorBrand;
	}


	public void setArmorBrand(String armorBrand) {
		this.armorBrand = armorBrand;
	}


	public String getAttributeRoll_1() {
		return attributeRoll_1;
	}


	public void setAttributeRoll_1(String attributeRoll_1) {
		this.attributeRoll_1 = attributeRoll_1;
	}


	public String getAttributeValue_1() {
		return attributeValue_1;
	}


	public void setAttributeValue_1(String attributeValue_1) {
		this.attributeValue_1 = attributeValue_1;
	}


	public String getAttributeRoll_2() {
		return attributeRoll_2;
	}


	public void setAttributeRoll_2(String attributeRoll_2) {
		this.attributeRoll_2 = attributeRoll_2;
	}


	public String getAttributeValue_2() {
		return attributeValue_2;
	}


	public void setAttributeValue_2(String attributeValue_2) {
		this.attributeValue_2 = attributeValue_2;
	}


	public String getAttributeRoll_3() {
		return attributeRoll_3;
	}


	public void setAttributeRoll_3(String attributeRoll_3) {
		this.attributeRoll_3 = attributeRoll_3;
	}


	public String getAttributeValue_3() {
		return attributeValue_3;
	}


	public void setAttributeValue_3(String attributeValue_3) {
		this.attributeValue_3 = attributeValue_3;
	}


	public String getAttributeRoll_4() {
		return attributeRoll_4;
	}


	public void setAttributeRoll_4(String attributeRoll_4) {
		this.attributeRoll_4 = attributeRoll_4;
	}


	public String getAttributeValue_4() {
		return attributeValue_4;
	}


	public void setAttributeValue_4(String attributeValue_4) {
		this.attributeValue_4 = attributeValue_4;
	}


	public String getTalentRoll_1() {
		return talentRoll_1;
	}


	public void setTalentRoll_1(String talentRoll_1) {
		this.talentRoll_1 = talentRoll_1;
	}


	public String getTalentValue_1() {
		return talentValue_1;
	}


	public void setTalentValue_1(String talentValue_1) {
		this.talentValue_1 = talentValue_1;
	}


	public String getTalentRoll_2() {
		return talentRoll_2;
	}


	public void setTalentRoll_2(String talentRoll_2) {
		this.talentRoll_2 = talentRoll_2;
	}


	public String getTalentValue_2() {
		return talentValue_2;
	}


	public void setTalentValue_2(String talentValue_2) {
		this.talentValue_2 = talentValue_2;
	}


	public String getModRoll_1() {
		return modRoll_1;
	}


	public void setModRoll_1(String modRoll_1) {
		this.modRoll_1 = modRoll_1;
	}


	public String getModRoll_2() {
		return modRoll_2;
	}


	public void setModRoll_2(String modRoll_2) {
		this.modRoll_2 = modRoll_2;
	}


	public String getModRoll_3() {
		return modRoll_3;
	}


	public void setModRoll_3(String modRoll_3) {
		this.modRoll_3 = modRoll_3;
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
		return "Armor [id=" + id + ", armorType=" + armorType + ", armorVariant=" + armorVariant + ", armorBrand="
				+ armorBrand + ", attributeRoll_1=" + attributeRoll_1 + ", attributeValue_1=" + attributeValue_1
				+ ", attributeRoll_2=" + attributeRoll_2 + ", attributeValue_2=" + attributeValue_2
				+ ", attributeRoll_3=" + attributeRoll_3 + ", attributeValue_3=" + attributeValue_3
				+ ", attributeRoll_4=" + attributeRoll_4 + ", attributeValue_4=" + attributeValue_4 + ", talentRoll_1="
				+ talentRoll_1 + ", talentValue_1=" + talentValue_1 + ", talentRoll_2=" + talentRoll_2
				+ ", talentValue_2=" + talentValue_2 + ", modRoll_1=" + modRoll_1 + ", modRoll_2=" + modRoll_2
				+ ", modRoll_3=" + modRoll_3 + ", dateCreated=" + dateCreated + ", timeCreated=" + timeCreated + "]";
	}

}

