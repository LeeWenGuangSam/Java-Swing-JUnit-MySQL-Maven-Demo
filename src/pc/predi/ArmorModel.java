package pc.predi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ArmorModel {
	private String[] armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	private String[] armorVariantBackpacks, armorVariantChests, armorVariantGloves, armorVariantHolsters, armorVariantKneepads, armorVariantMasks;
	private String[] armorTalentRollsBackpack, armorTalentRollsChest, armorTalentRollsGloves, armorTalentRollsHolster, armorTalentRollsKneepads, armorTalentRollsMask;
	private String[] armorOngoingDirectiveAttributeRollsBackpack, armorOngoingDirectiveAttributeRollsChest;
	private ArrayList<File> textFiles = new ArrayList<File>();
	private ArrayList<File> textFilesAttributesOngoingDirective = new ArrayList<File>();
	public ArmorModel() {
		textFiles.add(new File("Armors/ArmorTypes.txt"));
		textFiles.add(new File("Armors/ArmorBrandRolls.txt"));
		textFiles.add(new File("Armors/ArmorAttributeRolls.txt"));
		textFiles.add(new File("Armors/ArmorTalentRolls.txt"));
		textFiles.add(new File("Armors/ArmorExoticRolls.txt"));
		textFilesAttributesOngoingDirective.add(new File("Armors/ArmorOngoingDirectiveAttributeRollsBackpack.txt"));
		textFilesAttributesOngoingDirective.add(new File("Armors/ArmorOngoingDirectiveAttributeRollsChest.txt"));
		
		armorSlotTypes = populateSkills(armorSlotTypes, textFiles.get(0));
		armorBrandRolls = populateSkills(armorBrandRolls, textFiles.get(1));
		armorAttributeRolls = populateSkills(armorAttributeRolls, textFiles.get(2));
		armorTalentRolls = populateSkills(armorTalentRolls, textFiles.get(3));
		
		armorVariantBackpacks = populateSkills(armorVariantBackpacks, new File("Armors/ArmorVariants/Backpack.txt"));
		armorVariantChests = populateSkills(armorVariantChests, new File("Armors/ArmorVariants/Chest.txt"));
		armorVariantGloves = populateSkills(armorVariantGloves, new File("Armors/ArmorVariants/Glove.txt"));
		armorVariantHolsters = populateSkills(armorVariantHolsters, new File("Armors/ArmorVariants/Holster.txt"));
		armorVariantKneepads = populateSkills(armorVariantKneepads, new File("Armors/ArmorVariants/Kneepad.txt"));
		armorVariantMasks = populateSkills(armorVariantMasks, new File("Armors/ArmorVariants/Mask.txt"));
		
		armorTalentRollsBackpack = populateSkills(armorTalentRollsBackpack, new File("Armors/ArmorVariants/ArmorTalentRolls/Backpack Talents.txt"));
		armorTalentRollsChest = populateSkills(armorTalentRollsChest, new File("Armors/ArmorVariants/ArmorTalentRolls/Chest Talents.txt"));
		armorTalentRollsGloves = populateSkills(armorTalentRollsChest, new File("Armors/ArmorVariants/ArmorTalentRolls/Glove Talents.txt"));
		armorTalentRollsHolster = populateSkills(armorTalentRollsChest, new File("Armors/ArmorVariants/ArmorTalentRolls/Holster Talents.txt"));
		armorTalentRollsKneepads = populateSkills(armorTalentRollsChest, new File("Armors/ArmorVariants/ArmorTalentRolls/Kneepad Talents.txt"));
		armorTalentRollsMask = populateSkills(armorTalentRollsChest, new File("Armors/ArmorVariants/ArmorTalentRolls/Mask Talents.txt"));
		
		armorOngoingDirectiveAttributeRollsBackpack = populateSkills(armorOngoingDirectiveAttributeRollsBackpack, textFilesAttributesOngoingDirective.get(0));
		armorOngoingDirectiveAttributeRollsChest = populateSkills(armorOngoingDirectiveAttributeRollsChest, textFilesAttributesOngoingDirective.get(1));
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
	
		public String[] getArmorOngoingDirectiveAttributeRollsBackpack() {
		return armorOngoingDirectiveAttributeRollsBackpack;
	}

	public void setArmorOngoingDirectiveAttributeRollsBackpack(String[] armorOngoingDirectiveAttributeRollsBackpack) {
		this.armorOngoingDirectiveAttributeRollsBackpack = armorOngoingDirectiveAttributeRollsBackpack;
	}

	public String[] getArmorOngoingDirectiveAttributeRollsChest() {
		return armorOngoingDirectiveAttributeRollsChest;
	}

	public void setArmorOngoingDirectiveAttributeRollsChest(String[] armorOngoingDirectiveAttributeRollsChest) {
		this.armorOngoingDirectiveAttributeRollsChest = armorOngoingDirectiveAttributeRollsChest;
	}

	public ArrayList<File> getTextFilesAttributesOngoingDirective() {
		return textFilesAttributesOngoingDirective;
	}

	public void setTextFilesAttributesOngoingDirective(ArrayList<File> textFilesAttributesOngoingDirective) {
		this.textFilesAttributesOngoingDirective = textFilesAttributesOngoingDirective;
	}

	public String[] getArmorVariantBackpacks() {
		return armorVariantBackpacks;
	}

	public void setArmorVariantBackpacks(String[] armorVariantBackpacks) {
		this.armorVariantBackpacks = armorVariantBackpacks;
	}

	public String[] getArmorVariantChests() {
		return armorVariantChests;
	}

	public void setArmorVariantChests(String[] armorVariantChests) {
		this.armorVariantChests = armorVariantChests;
	}

	public String[] getArmorVariantGloves() {
		return armorVariantGloves;
	}

	public void setArmorVariantGloves(String[] armorVariantGloves) {
		this.armorVariantGloves = armorVariantGloves;
	}

	public String[] getArmorVariantHolsters() {
		return armorVariantHolsters;
	}

	public void setArmorVariantHolsters(String[] armorVariantHolsters) {
		this.armorVariantHolsters = armorVariantHolsters;
	}

	public String[] getArmorVariantKneepads() {
		return armorVariantKneepads;
	}

	public void setArmorVariantKneepads(String[] armorVariantKneepads) {
		this.armorVariantKneepads = armorVariantKneepads;
	}

	public String[] getArmorVariantMasks() {
		return armorVariantMasks;
	}

	public void setArmorVariantMasks(String[] armorVariantMasks) {
		this.armorVariantMasks = armorVariantMasks;
	}

	public String[] getArmorTalentRollsBackpack() {
		return armorTalentRollsBackpack;
	}

	public void setArmorTalentRollsBackpack(String[] armorTalentRollsBackpack) {
		this.armorTalentRollsBackpack = armorTalentRollsBackpack;
	}

	public String[] getArmorTalentRollsChest() {
		return armorTalentRollsChest;
	}

	public void setArmorTalentRollsChest(String[] armorTalentRollsChest) {
		this.armorTalentRollsChest = armorTalentRollsChest;
	}

	public String[] getArmorTalentRollsGloves() {
		return armorTalentRollsGloves;
	}

	public void setArmorTalentRollsGloves(String[] armorTalentRollsGloves) {
		this.armorTalentRollsGloves = armorTalentRollsGloves;
	}

	public String[] getArmorTalentRollsHolster() {
		return armorTalentRollsHolster;
	}

	public void setArmorTalentRollsHolster(String[] armorTalentRollsHolster) {
		this.armorTalentRollsHolster = armorTalentRollsHolster;
	}

	public String[] getArmorTalentRollsKneepads() {
		return armorTalentRollsKneepads;
	}

	public void setArmorTalentRollsKneepads(String[] armorTalentRollsKneepads) {
		this.armorTalentRollsKneepads = armorTalentRollsKneepads;
	}

	public String[] getArmorTalentRollsMask() {
		return armorTalentRollsMask;
	}

	public void setArmorTalentRollsMask(String[] armorTalentRollsMask) {
		this.armorTalentRollsMask = armorTalentRollsMask;
	}

	public ArrayList<File> getTextFiles() {
		return textFiles;
	}

	public void setTextFiles(ArrayList<File> textFiles) {
		this.textFiles = textFiles;
	}
	
	
}
