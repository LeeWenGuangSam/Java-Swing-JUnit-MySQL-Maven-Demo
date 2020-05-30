package pc.predi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;

public class WeaponModel {
	private String[] weaponTypes, weaponVariants, activeSkills, handlingSkills, equippedHolsteredSkills;
	private String[] weaponVariantAssaultRifle, weaponVariantLightMachineGun, weaponVariantMarksmanRifle, weaponVariantPistol, weaponVariantRifle, weaponVariantShotgun, weaponVariantSubmachineGun;
	private ArrayList<File> weaponSkillFiles = new ArrayList<File>();
	//private ArrayList<Path> weaponVariantPaths;
	public WeaponModel() {
		weaponSkillFiles.add(new File("Weapons/WeaponTypes.txt"));
		weaponSkillFiles.add(new File("Weapons/WeaponVariants.txt"));
		weaponSkillFiles.add(new File("Weapons/ActiveSkills.txt"));
		weaponSkillFiles.add(new File("Weapons/Exotic Active Skills.txt"));
		weaponSkillFiles.add(new File("Weapons/HandlingSkills.txt"));
		weaponSkillFiles.add(new File("Weapons/EquippedSkills.txt"));
    	weaponSkillFiles.add(new File("Weapons/Exotic Handling Skills.txt"));
    	weaponSkillFiles.add(new File("Weapons/HolsteredSkills.txt"));
    	weaponSkillFiles.add(new File("Weapons/Exotic Holstered Skills.txt"));
    	
    	weaponVariants = populateSkills(weaponVariants, weaponSkillFiles.get(1));
    	activeSkills = populateSkills(activeSkills, weaponSkillFiles.get(2));
    	activeSkills = populateSkills(activeSkills, weaponSkillFiles.get(3));
    	handlingSkills = populateSkills(handlingSkills, weaponSkillFiles.get(4));
    	handlingSkills = populateSkills(handlingSkills, weaponSkillFiles.get(5));
    	handlingSkills = populateSkills(handlingSkills, weaponSkillFiles.get(6));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, weaponSkillFiles.get(4));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, weaponSkillFiles.get(5));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, weaponSkillFiles.get(7));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, weaponSkillFiles.get(8));
    	
    	weaponTypes = populateSkills(weaponTypes, new File("Weapons/WeaponTypes.txt"));
    	weaponVariantAssaultRifle = populateSkills(weaponVariantAssaultRifle, new File("Weapons/WeaponVariants/Assault Rifle.txt"));
    	weaponVariantLightMachineGun = populateSkills(weaponVariantLightMachineGun, new File("Weapons/WeaponVariants/Light Machine Gun.txt"));
    	weaponVariantMarksmanRifle = populateSkills(weaponVariantMarksmanRifle, new File("Weapons/WeaponVariants/Marksman Rifle.txt"));
    	weaponVariantPistol = populateSkills(weaponVariantPistol, new File("Weapons/WeaponVariants/Pistol.txt"));
    	weaponVariantRifle = populateSkills(weaponVariantRifle, new File("Weapons/WeaponVariants/Rifle.txt"));
    	weaponVariantShotgun = populateSkills(weaponVariantShotgun, new File("Weapons/WeaponVariants/Shotgun.txt"));
    	weaponVariantSubmachineGun = populateSkills(weaponVariantSubmachineGun, new File("Weapons/WeaponVariants/Submachine Gun.txt"));
	}
	
	//creates array if array is null or not instantiated
	//creates and adds to array if array is not empty
	public String[] populateSkills(String[] arrayToPopulate, File file)
	{
		String[] stringArrayToSend = null;
		//adds to a temp arraylist from file
		ArrayList<String> tempArrayList = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String currentline = "";
			
			while((currentline = br.readLine()) != null)
			{
				tempArrayList.add(currentline);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(arrayToPopulate == null) 
		{			
			stringArrayToSend = convertStringArrayListToStringArray(tempArrayList);
			return stringArrayToSend;
		}
		//if arrayToPopulate is not empty
		else
		{			
			stringArrayToSend = combineArray(tempArrayList, arrayToPopulate);
			return stringArrayToSend;
		}
	}
	
	public String[] convertStringArrayListToStringArray(ArrayList<String> stringArrayList) {
		
		String[] stringArray = new String[stringArrayList.size()];
		for(int i = 0; i < stringArrayList.size(); i++) {
			stringArray[i] = stringArrayList.get(i);
		}
		return stringArray;
	}
	
	public String[] combineArray(ArrayList<String> stringArrayList, String[] populatedArray) {
		int combinedArraySize = stringArrayList.size() + populatedArray.length;
		String[] combinedArray = new String[combinedArraySize];
		for(int i = 0; i < populatedArray.length ; i++) {
			combinedArray[i] = populatedArray[i];
		}
		
		for(int i = populatedArray.length; i < combinedArraySize ; i++) {
			combinedArray[i] = stringArrayList.get(i - populatedArray.length);
		}
		return combinedArray;
	}
	
	public String[] listWeaponVariants(String weaponFirstVariant) {
		String[] weaponVariants = null;
		return weaponVariants;
	}

	public String[] getWeaponTypes() {
		return weaponTypes;
	}

	public void setWeaponTypes(String[] weaponTypes) {
		this.weaponTypes = weaponTypes;
	}

	public String[] getWeaponVariants() {
		return weaponVariants;
	}

	public void setWeaponVariants(String[] weaponVariants) {
		this.weaponVariants = weaponVariants;
	}

	public String[] getActiveSkills() {
		return activeSkills;
	}

	public void setActiveSkills(String[] activeSkills) {
		this.activeSkills = activeSkills;
	}

	public String[] getHandlingSkills() {
		return handlingSkills;
	}

	public void setHandlingSkills(String[] handlingSkills) {
		this.handlingSkills = handlingSkills;
	}

	public String[] getEquippedHolsteredSkills() {
		return equippedHolsteredSkills;
	}

	public void setEquippedHolsteredSkills(String[] equippedHolsteredSkills) {
		this.equippedHolsteredSkills = equippedHolsteredSkills;
	}
	
		public String[] getWeaponVariantAssaultRifle() {
		return weaponVariantAssaultRifle;
	}

	public void setWeaponVariantAssaultRifle(String[] weaponVariantAssaultRifle) {
		this.weaponVariantAssaultRifle = weaponVariantAssaultRifle;
	}

	public String[] getWeaponVariantLightMachineGun() {
		return weaponVariantLightMachineGun;
	}

	public void setWeaponVariantLightMachineGun(String[] weaponVariantLightMachineGun) {
		this.weaponVariantLightMachineGun = weaponVariantLightMachineGun;
	}

	public String[] getWeaponVariantMarksmanRifle() {
		return weaponVariantMarksmanRifle;
	}

	public void setWeaponVariantMarksmanRifle(String[] weaponVariantMarksmanRifle) {
		this.weaponVariantMarksmanRifle = weaponVariantMarksmanRifle;
	}

	public String[] getWeaponVariantPistol() {
		return weaponVariantPistol;
	}

	public void setWeaponVariantPistol(String[] weaponVariantPistol) {
		this.weaponVariantPistol = weaponVariantPistol;
	}

	public String[] getWeaponVariantRifle() {
		return weaponVariantRifle;
	}

	public void setWeaponVariantRifle(String[] weaponVariantRifle) {
		this.weaponVariantRifle = weaponVariantRifle;
	}

	public String[] getWeaponVariantShotgun() {
		return weaponVariantShotgun;
	}

	public void setWeaponVariantShotgun(String[] weaponVariantShotgun) {
		this.weaponVariantShotgun = weaponVariantShotgun;
	}

	public String[] getWeaponVariantSubmachineGun() {
		return weaponVariantSubmachineGun;
	}

	public void setWeaponVariantSubmachineGun(String[] weaponVariantSubmachineGun) {
		this.weaponVariantSubmachineGun = weaponVariantSubmachineGun;
	}

	public ArrayList<File> getWeaponSkillFiles() {
		return weaponSkillFiles;
	}

	public void setWeaponSkillFiles(ArrayList<File> weaponSkillFiles) {
		this.weaponSkillFiles = weaponSkillFiles;
	}	
}
