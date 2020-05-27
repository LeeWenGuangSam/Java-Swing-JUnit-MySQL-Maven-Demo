package pc.predi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;

public class SkillModModel {
	private JComboBox boxSkillNames, boxSkillSlots;
	private HashMap mapSkillNamesSlots, mapSkillNamesAttributes;
	private String[] skills, skillSlots, skillNamesAttributes;
	private String[][] test;
	public SkillModModel() {
//		skills = populateSkills(skills, new File("SkillMods/Skills.txt"));
//		skillSlots = populateSkills(skillSlots, new File("SkillMods/Skill Slots.txt"));
//		skillSlots = populateSkills(skillNamesSlots, new File("SkillMods/Skill Slots.txt"));
//		for(int i = 0; i < skillNamesSlots.length; i++) {
//			String[] tempArray = skillNamesSlots[i].split(",");
//			//populate comboBoxes using tempArray[0] and tempArray[0+1] .....
//		}
//		
		test = new String[skillSlots.length][];
		//insert number here
		test[0] = new String[5];
		mapSkillNamesAttributes = new HashMap<String,String>();
		//mapSkillNamesAttributes.put(key, value);
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
				//does not work for weaponTypes[], create specialised method
//				for(int i = 0; i < weaponTypes.length; i++) {
//					if(currentline.equals(weaponTypes[i])) {
//						continue;
//					}
//				}
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
}
