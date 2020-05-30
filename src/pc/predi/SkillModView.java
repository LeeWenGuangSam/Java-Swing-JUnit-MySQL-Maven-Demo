package pc.predi;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SkillModView extends JPanel {
	private JLabel lblSkillName, lblSkillPower, lblSkillSlot, lblSkillPartName, lblSkillAttribute, lblSkillResult, lblSkillResultLogged;
	private JComboBox boxSkillName, boxSkillSlot, boxSkillPartName, boxSkillAttribute;
	private JTextField fieldSkillPower, fieldSkillAttributeValue;
	private HashMap mapSkillNamesSlots, mapSkillNamesAttributes;
	private String[] skillNames, skillSlots, skillPartNames, skillAttributes;
	private String[] skillNamesSlots, skillNamesAttributes;
	public SkillModView() {
		
		skillNames = populateSkills(skillNames, new File("SkillMods/Skill Names.txt"));
		skillSlots = populateSkills(skillSlots, new File("SkillMods/Skill Slots.txt"));
		skillPartNames = populateSkills(skillPartNames, new File("SkillMods/SkillPartNames.txt"));
		skillAttributes = populateSkills(skillAttributes, new File("SkillMods/SkillAttributes.txt"));
		
		GridBagLayout gbl_cardSkillMod = new GridBagLayout();
		gbl_cardSkillMod.columnWidths = new int[] {50,50,50};
		gbl_cardSkillMod.columnWeights = new double[] {1.0,1.0, 1.0};
		gbl_cardSkillMod.rowHeights = new int[] {50,50,50,50,50,50};
		gbl_cardSkillMod.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		
		lblSkillName = new JLabel("Skill Name:");
		GridBagConstraints gbc_lblSkillName = new GridBagConstraints();
		gbc_lblSkillName.insets = new Insets(0,0,5,5);
		gbc_lblSkillName.gridx = 0;
		gbc_lblSkillName.gridy = 0;
		
		boxSkillName = new JComboBox<>();
		boxSkillName.setModel(new DefaultComboBoxModel(skillNames));
		GridBagConstraints gbc_boxSkillName = new GridBagConstraints();
		gbc_boxSkillName.insets = new Insets(0, 0, 5, 5);
		gbc_boxSkillName.gridx = 1;
		gbc_boxSkillName.gridy = 0;
		
		lblSkillPower = new JLabel("Skill Power Requirement:");
		GridBagConstraints gbc_lblSkillPower = new GridBagConstraints();
		gbc_lblSkillPower.insets = new Insets(0,0,5,5);
		gbc_lblSkillPower.gridx = 0;
		gbc_lblSkillPower.gridy = 1;
		
		fieldSkillPower = new JTextField("");
		GridBagConstraints gbc_fieldSkillPower = new GridBagConstraints();
		gbc_fieldSkillPower.insets = new Insets(0, 0, 5, 0);
		gbc_fieldSkillPower.gridx = 1;
		gbc_fieldSkillPower.gridy = 1;
		fieldSkillPower.setColumns(10);
		
		
		lblSkillSlot = new JLabel("Skill Slot:");
		GridBagConstraints gbc_lblSkillSlot = new GridBagConstraints();
		gbc_lblSkillSlot.insets = new Insets(0, 0, 5, 5);
		gbc_lblSkillSlot.gridx = 0;
		gbc_lblSkillSlot.gridy = 2;
		
		boxSkillSlot = new JComboBox<>();
		boxSkillSlot.setModel(new DefaultComboBoxModel(skillSlots));
		GridBagConstraints gbc_boxSkillSlot = new GridBagConstraints();
		gbc_boxSkillSlot.insets = new Insets(0, 0, 5, 5);
		gbc_boxSkillSlot.gridx = 1;
		gbc_boxSkillSlot.gridy = 2;
		
		lblSkillPartName = new JLabel("Skill Part Name:");
		GridBagConstraints gbc_lblSkillPartName = new GridBagConstraints();
		gbc_lblSkillPartName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSkillPartName.gridx = 0;
		gbc_lblSkillPartName.gridy = 3;
		
		boxSkillPartName = new JComboBox<>();
		boxSkillPartName.setModel(new DefaultComboBoxModel(skillPartNames));
		GridBagConstraints gbc_boxSkillPartName = new GridBagConstraints();
		gbc_boxSkillPartName.insets = new Insets(0, 0, 5, 5);
		gbc_boxSkillPartName.gridx = 1;
		gbc_boxSkillPartName.gridy = 3;
		
		lblSkillAttribute = new JLabel("Attribute");
		GridBagConstraints gbc_lblSkillAttribute = new GridBagConstraints();
		gbc_lblSkillAttribute.insets = new Insets(0, 0, 5, 5);
		gbc_lblSkillAttribute.gridx = 0;
		gbc_lblSkillAttribute.gridy = 4;
		
		boxSkillAttribute = new JComboBox<>();
		boxSkillAttribute.setModel(new DefaultComboBoxModel(skillAttributes));
		GridBagConstraints gbc_boxSkillAttribute = new GridBagConstraints();
		gbc_boxSkillAttribute.insets = new Insets(0, 0, 5, 5);
		gbc_boxSkillAttribute.gridx = 1;
		gbc_boxSkillAttribute.gridy = 4;	
		
		fieldSkillAttributeValue = new JTextField("");
		GridBagConstraints gbc_fieldSkillAttributeValue = new GridBagConstraints();
		gbc_fieldSkillAttributeValue.insets = new Insets(0, 0, 5, 0);
		gbc_fieldSkillAttributeValue.gridx = 2;
		gbc_fieldSkillAttributeValue.gridy = 4;
		fieldSkillAttributeValue.setColumns(10);
		
		lblSkillResult = new JLabel("Previous Skill Mod:");
		GridBagConstraints gbc_lblSkillResult = new GridBagConstraints();
		gbc_lblSkillResult.insets = new Insets(0, 0, 5, 0);
		gbc_lblSkillResult.gridx = 0;
		gbc_lblSkillResult.gridy = 5;
		
		lblSkillResultLogged = new JLabel("No previous mod logged");
		GridBagConstraints gbc_lblSkillResultLogged = new GridBagConstraints();
		gbc_lblSkillResultLogged.insets = new Insets(0, 0, 5, 0);
		gbc_lblSkillResultLogged.gridx = 1;
		gbc_lblSkillResultLogged.gridy = 5;
		
		setName("cardSkillMod");
		setLayout(gbl_cardSkillMod);
		add(lblSkillName, gbc_lblSkillName);
		add(boxSkillName, gbc_boxSkillName);
		add(lblSkillPower, gbc_lblSkillPower);
		add(fieldSkillPower, gbc_fieldSkillPower);
		add(lblSkillSlot, gbc_lblSkillSlot);
		add(boxSkillSlot, gbc_boxSkillSlot);
		add(lblSkillPartName, gbc_lblSkillPartName);
		add(boxSkillPartName, gbc_boxSkillPartName);
		add(lblSkillAttribute, gbc_lblSkillAttribute);
		add(boxSkillAttribute, gbc_boxSkillAttribute);
		add(fieldSkillAttributeValue, gbc_fieldSkillAttributeValue);
		add(lblSkillResult, gbc_lblSkillResult);
		add(lblSkillResultLogged, gbc_lblSkillResultLogged);
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
				if (tempArrayList.contains(currentline) == false) {
					tempArrayList.add(currentline);
				}
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
