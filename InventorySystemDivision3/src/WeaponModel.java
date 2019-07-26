/*
 * WeaponModel handles all the calculations needed.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponModel {
	//instance variables
    private String[] weaponTypes, weaponVariants, activeSkills, handlingSkills, equippedHolsteredSkills;
    private ArrayList<File> textFiles = new ArrayList<File>();
    private ArrayList<Path> weaponVariantPaths;
    //Constructor
    //sorts entire array on instantiation
    public WeaponModel()
    {
        /*weaponTypes = new String[] { "Assault Rifle", "Light Machine Gun", "Marksman Rifle", "Pistol", "Rifle",
                "Shotgun", "Submachine Gun" };
                */
    	
    	//weaponTypes = populateWeaponTypes();
        
        //weaponVariants = populateWeaponVariants();
    	
        
		/*
		 * activeSkills = new String[] { "Boomerang", "BreadBasket", "Close & Personal",
		 * "Eyeless", "Fast Hands", "Finisher", "First Blood", "Frenzy", "Ignited",
		 * "Killer", "Lucky Shot", "Measured", "Naked", "Near Sighted", "On Empty",
		 * "Optimist", "Outsider", "Perpetuation", "Premeditated", "Preservation",
		 * "Pummel", "Ranger", "Reformation", "Rifleman", "Sadist", "Salvage", "Spike",
		 * "Steady Handed", "Strained", "Unhinged", "Unwavering", "Vindictive" };
		 */
        
        //activeSkills = populateActiveSkills();
        
		/*
		 * handlingSkills = new String[] { "Cannon", "In Rhythm", "Protected Deploy",
		 * "Protected Reload", "Recharged", "Rooted", "Stop, Drop, and Roll", "Zen",
		 * "Accurate", "Allegro", "Distance", "Extra", "Jazz Hands", "Optimized",
		 * "Stable" };
		 */
        
        //handlingSkills = populateHandlingSkills();
        
		/*
		 * holsteredSkills = new String[] { "Double Duty", "Everlasting", "Greased",
		 * "Overlap", "Transmission", "Wascally" };
		 */
        
        //holsteredSkills = populateHolsteredSkills();
    	
    	textFiles.add(new File("WeaponTypes.txt"));
    	textFiles.add(new File("WeaponVariants.txt"));
    	textFiles.add(new File("ActiveSkills.txt"));
    	textFiles.add(new File("HandlingSkills.txt"));
    	textFiles.add(new File("EquippedSkills.txt"));
    	textFiles.add(new File("HolsteredSkills.txt"));
    	
    	weaponTypes = populateModelsAndSkills(weaponTypes, textFiles.get(0));
    	weaponVariants = populateModelsAndSkills(weaponVariants, textFiles.get(1));
    	activeSkills = populateModelsAndSkills(activeSkills, textFiles.get(2));
    	handlingSkills = populateModelsAndSkills(handlingSkills, textFiles.get(3));
    	equippedHolsteredSkills = populateModelsAndSkills(equippedHolsteredSkills, textFiles.get(4));
    	equippedHolsteredSkills = populateModelsAndSkills(equippedHolsteredSkills, textFiles.get(5));
    	
    	Arrays.sort(weaponTypes);
    	Arrays.sort(activeSkills);
    	Arrays.sort(handlingSkills);
    	Arrays.sort(equippedHolsteredSkills);
    	
    	//create directory using Files.createDirectories(Path dir, FileAttribute<?> attrs)
    	//create file in directory
    	//read file using Files.readAllLines public static List<String>(Path path, Charset cs)
    	//use List<String> to populate variables
    	
		/*
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Assault Rifle.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Light Machine Gun.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Marksman Rifle.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Pistol.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Rifle.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Shotgun.txt"));
		 * weaponVariantPaths.add(Paths.get("WeaponVariants/Submachine Gun.txt"));
		 * 
		 * 
		 * //relative path Path path = Paths.get("WeaponTypes/"); List<String>
		 * arrayToPopulate = new ArrayList<String>(); if
		 * (Files.exists(Paths.get(path.toString()))) { try { arrayToPopulate =
		 * Files.readAllLines(path); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 * 
		 * try { //relative path Files.createDirectories(Paths.get(path.toString()));
		 * Files.createFile(Paths.get("WeaponTypes/WeaponTypes.txt")); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
    	
    	//populateModelsAndSkills();
    }
    
    //Getter setter methods
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
	
	public String[] getHandlingHolsteredSkills() {
		return equippedHolsteredSkills;
	}

	public void setHandlingHolsteredSkills(String[] handlingHolsteredSkills) {
		this.equippedHolsteredSkills = handlingHolsteredSkills;
	}
	
	//end getter setter methods
	
	//Populates by reading from a file called WeaponTypes.txt
	public String[] populateWeaponTypes()
	{
		File file = new File("WeaponTypes.txt");
		ArrayList<String> weaponTypesTemp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				//line = br.readLine();
				weaponTypesTemp.add(line);
			}
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String[] weaponTypes = new String[weaponTypesTemp.size()];
		for(int i = 0; i < weaponTypesTemp.size(); i++) {
			weaponTypes[i] = weaponTypesTemp.get(i);
		}
		return weaponTypes;
	}
	
	
	//Populates by reading from a file called WeaponVariant.txt
	public String[] populateWeaponVariants()
	{
        //Reading from a file to populate comboBox
        File file = new File("WeaponVariants.txt");
        ArrayList<String> weaponVariantsTemp = new ArrayList<String>();
        try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				//String line = "";
				//line = br.readLine();
				weaponVariantsTemp.add(line);
			}
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] weaponVariants = new String[weaponVariantsTemp.size()];
        //loop through arraylist and move all arraylist items into array, return array as result and input as parameter into DefaultComboBoxModel
        for(int i = 0; i < weaponVariantsTemp.size(); i++)
        {
        	weaponVariants[i] = weaponVariantsTemp.get(i);
        }
		return weaponVariants;
	}
	
	public String[] populateActiveSkills()
	{
		File file = new File("ActiveSkills.txt");
		ArrayList<String> activeSkillsTemp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				activeSkillsTemp.add(line);
			}
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String[] activeSkills = new String[activeSkillsTemp.size()];
		for(int i = 0; i < activeSkillsTemp.size(); i++) {
			activeSkills[i] = activeSkillsTemp.get(i);
		}
		return activeSkills;
	}
	
	public String[] populateHandlingSkills()
	{
		File file = new File("HandlingSkills.txt");
		ArrayList<String> handlingSkillsTemp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				handlingSkillsTemp.add(line);
			}
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String[] handlingSkills = new String[handlingSkillsTemp.size()];
		for(int i = 0; i < handlingSkillsTemp.size(); i++) {
			handlingSkills[i] = handlingSkillsTemp.get(i);
		}
		return handlingSkills;
	}
	
	public String[] populateHolsteredSkills()
	{
		File file = new File("HolsteredSkills.txt");
		ArrayList<String> holsteredSkillsTemp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				holsteredSkillsTemp.add(line);
			}
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String[] holsteredSkills = new String[holsteredSkillsTemp.size()];
		for(int i = 0; i < holsteredSkillsTemp.size(); i++) {
			holsteredSkills[i] = holsteredSkillsTemp.get(i);
		}
		return holsteredSkills;
	}
	
	//old code, does not account for adding to arrays
	/*
	public String[] populateModelsAndSkills(String[] arrayToPopulate, File file)
	{
		//adds to arraylist from file
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null)
			{
				temp.add(line);
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//DefaultComboBox only takes E[] only, a String[] array is created
		arrayToPopulate = new String[temp.size()];
		for(int i = 0; i < temp.size(); i++)
		{
			arrayToPopulate[i] = temp.get(i);
		}
		return arrayToPopulate;
	}
	*/
	
	//creates array if array is null or not instantiated
	//creates and adds to array if array is not empty
	public String[] populateModelsAndSkills(String[] arrayToPopulateOrAdd, File file)
	{
		//adds to a temp arraylist from file
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null)
			{
				temp.add(line);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		int length = 0;
		if(arrayToPopulateOrAdd == null) 
		{
			String[] arrayToPopulate = new String[temp.size()];
			for(int i = 0; i < temp.size() + length; i++)
			{
				arrayToPopulate[i] = temp.get(i);
			}
			return arrayToPopulate;
		}
		//if arrayToPopulate is not empty
		else
		{
			length = arrayToPopulateOrAdd.length;
			String arrayToAdd[] = new String[temp.size() + arrayToPopulateOrAdd.length];
			for(int i = 0; i < temp.size(); i++)
			{
				arrayToAdd[i] = temp.get(i);
			}
			for(int i = temp.size(); i < arrayToAdd.length; i++)
			{
				arrayToAdd[i] = arrayToPopulateOrAdd[i-temp.size()];
			}
			return arrayToAdd;
		}
	}
	
	//potential new implementation for populating array
	//Using Files class
	public String[] populateModelsAndSkills(String[] arrayToPopulate, Path path) {
		if(Files.exists(path))
		{
			List<String> temp = new ArrayList<String>();
			try {
				temp = Files.readAllLines(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrayToPopulate = new String[temp.size()];
			for(int i = 0; i < temp.size(); i++)
			{
				arrayToPopulate[i] = temp.get(i);
			}
		}
		return arrayToPopulate;
	}
	
	/*
	 * public void populateModelsAndSkills() { //instantiate arraylist of files to
	 * loop through ArrayList<File> weaponFiles = new ArrayList<File>();
	 * 
	 * weaponFiles.add(new File("WeaponTypes.txt")); weaponFiles.add(new
	 * File("WeaponVariants.txt")); weaponFiles.add(new File("ActiveSkills.txt"));
	 * weaponFiles.add(new File("HandlingSkills.txt")); weaponFiles.add(new
	 * File("HolsteredSkills.txt"));
	 * 
	 * //instantiate an Arraylist of arraylist Strings to be used temporarily
	 * ArrayList<ArrayList<String>> typesModelsSkillsOuterTemp = new
	 * ArrayList<ArrayList<String>>();
	 * 
	 * ArrayList<String> weaponTypesTemp = new ArrayList<String>();
	 * ArrayList<String> weaponVariantsTemp = new ArrayList<String>();
	 * ArrayList<String> activeSkillsTemp = new ArrayList<String>();
	 * ArrayList<String> handlingSkillsTemp = new ArrayList<String>();
	 * ArrayList<String> holsteredSkillsTemp = new ArrayList<String>();
	 * typesModelsSkillsOuterTemp.add(weaponTypesTemp);
	 * typesModelsSkillsOuterTemp.add(weaponVariantsTemp);
	 * typesModelsSkillsOuterTemp.add(activeSkillsTemp);
	 * typesModelsSkillsOuterTemp.add(handlingSkillsTemp);
	 * typesModelsSkillsOuterTemp.add(holsteredSkillsTemp);
	 * 
	 * //instantiate an ArrayList of arrays to for values to be put into and to be
	 * moved into the DefaultComboBoxModel ArrayList<String[]> typesModelsSkills =
	 * new ArrayList<String[]>(); String[] weaponTypes; String[] weaponVariants;
	 * String[] activeSkills; String[] handlingSkills; String[] holsteredSkills;
	 * typesModelsSkills.add(weaponTypes); typesModelsSkills.add(weaponVariants);
	 * typesModelsSkills.add(activeSkills); typesModelsSkills.add(handlingSkills);
	 * typesModelsSkills.add(holsteredSkills);
	 * 
	 * 
	 * for (int outer = 0; outer < weaponFiles.size(); outer++) { try { FileReader
	 * fr = new FileReader(weaponFiles.get(outer)); BufferedReader br = new
	 * BufferedReader(fr); String line = ""; while ((line = br.readLine()) != null)
	 * { typesModelsSkillsOuterTemp.get(outer).add(line); } fr.close(); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * //instantiates array to be put into DefaultComboBox String[]
	 * typesModelsSkillsInnerTemp = typesModelsSkills.get(outer);
	 * typesModelsSkills.get(outer) = new String[typesModelsSkillsOuterTemp.size()];
	 * //typesModelsSkillsInnerTemp = new String[typesModelsSkillsOuterTemp.size()];
	 * //String[] t = typesModelsSkills.get(outer); for(int n = 0; n <
	 * typesModelsSkillsOuterTemp.size(); n++) { //typesModelsSkillsInnerTemp[outer]
	 * = typesModelsSkillsOuterTemp.get(outer).get(n);
	 * typesModelsSkills.get(outer)[n] =
	 * typesModelsSkillsOuterTemp.get(outer).get(n); } } }
	 */
}
