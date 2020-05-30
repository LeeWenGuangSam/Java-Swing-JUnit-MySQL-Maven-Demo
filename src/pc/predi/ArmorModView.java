package pc.predi;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArmorModView extends JPanel{
	private JLabel lblArmorModType, lblArmorModName, lblArmorModRoll, lblArmorModAttribute1, lblArmorModAttribute2, lblArmorModAttribute3, lblResult, lblResultLogged;
	private JComboBox boxArmorModType, boxArmorModName, boxArmorModRoll;
	private JComboBox boxArmorModAttribute1, boxArmorModAttribute2, boxArmorModAttribute3;
	private JTextField fieldArmorModAttribute1, fieldArmorModAttribute2, fieldArmorModAttribute3;
	private String[] armorModTypes, armorModNames, armorModAttributes;
	public ArmorModView() {
		
		armorModTypes = populateSkills(armorModTypes, new File("ArmorMods/ArmorModTypes.txt"));
		armorModNames = populateSkills(armorModNames, new File("ArmorMods/ArmorModTypes/ArmorModNames.txt"));
		armorModAttributes = populateSkills(armorModAttributes, new File("ArmorMods/ArmorModTypes/ArmorModRolls/Offensive Protocol Critical.txt"));
		GridBagLayout gbl_cardArmorMod = new GridBagLayout();
		gbl_cardArmorMod.columnWeights = new double[] { 50, 50, 50 };
		gbl_cardArmorMod.rowHeights = new int[] { 30, 30, 50, 50, 50, 50 };
		gbl_cardArmorMod.columnWidths = new int[] { 50, 50, 50 };
		gbl_cardArmorMod.rowWeights = new double[] { 1.0, Double.MIN_VALUE, 1.0, 1.0 };
		
		
		lblArmorModType = new JLabel("Armor Mod Type:");
		GridBagConstraints gbc_lblArmorModType = new GridBagConstraints();
		gbc_lblArmorModType.insets = new Insets(0,0,0,5);
		gbc_lblArmorModType.gridx = 0;
		gbc_lblArmorModType.gridy = 0;
		
		boxArmorModType = new JComboBox();
		boxArmorModType.setModel(new DefaultComboBoxModel(armorModTypes));
		GridBagConstraints gbc_boxArmorModType = new GridBagConstraints();
		gbc_boxArmorModType.insets = new Insets(0,0,0,5);
		gbc_boxArmorModType.gridx = 1;
		gbc_boxArmorModType.gridy = 0;
		
		lblArmorModName = new JLabel("Armor Mod Name:");
		GridBagConstraints gbc_lblArmorModName = new GridBagConstraints();
		gbc_lblArmorModName.insets = new Insets(0,0,0,5);
		gbc_lblArmorModName.gridx = 0;
		gbc_lblArmorModName.gridy = 1;
		
		boxArmorModName = new JComboBox();
		boxArmorModName.setModel(new DefaultComboBoxModel(armorModNames));
		GridBagConstraints gbc_boxArmorModName = new GridBagConstraints();
		gbc_boxArmorModName.insets = new Insets(0,0,0,5);
		gbc_boxArmorModName.gridx = 1;
		gbc_boxArmorModName.gridy = 1;
		
		lblArmorModAttribute1 = new JLabel("Guaranteed Attribute:");
		GridBagConstraints gbc_lblArmorModAttribute1 = new GridBagConstraints();
		gbc_lblArmorModAttribute1.insets = new Insets(0,0,0,5);
		gbc_lblArmorModAttribute1.gridx = 0;
		gbc_lblArmorModAttribute1.gridy = 2;
		
		boxArmorModAttribute1 = new JComboBox();
		boxArmorModAttribute1.setModel(new DefaultComboBoxModel<>(armorModAttributes));
		GridBagConstraints gbc_boxArmorModAttribute1 = new GridBagConstraints();
		gbc_boxArmorModAttribute1.insets = new Insets(0,0,0,5);
		gbc_boxArmorModAttribute1.gridx = 1;
		gbc_boxArmorModAttribute1.gridy = 2;
		
		fieldArmorModAttribute1 = new JTextField();
		GridBagConstraints gbc_fieldArmorModAttribute1 = new GridBagConstraints();
		gbc_fieldArmorModAttribute1.insets = new Insets(0,0,0,5);
		gbc_fieldArmorModAttribute1.gridx = 2;
		gbc_fieldArmorModAttribute1.gridy = 2;
		fieldArmorModAttribute1.setColumns(10);
		
		lblArmorModAttribute2 = new JLabel("2nd Attribute:");
		GridBagConstraints gbc_lblArmorModAttribute2 = new GridBagConstraints();
		gbc_lblArmorModAttribute2.insets = new Insets(0,0,0,5);
		gbc_lblArmorModAttribute2.gridx = 0;
		gbc_lblArmorModAttribute2.gridy = 3;
		
		boxArmorModAttribute2 = new JComboBox();
		boxArmorModAttribute2.setModel(new DefaultComboBoxModel<>(armorModAttributes));
		GridBagConstraints gbc_boxArmorModAttribute2 = new GridBagConstraints();
		gbc_boxArmorModAttribute2.insets = new Insets(0,0,0,5);
		gbc_boxArmorModAttribute2.gridx = 1;
		gbc_boxArmorModAttribute2.gridy = 3;
		
		fieldArmorModAttribute2 = new JTextField();
		GridBagConstraints gbc_fieldArmorModAttribute2 = new GridBagConstraints();
		gbc_fieldArmorModAttribute2.insets = new Insets(0,0,0,5);
		gbc_fieldArmorModAttribute2.gridx = 2;
		gbc_fieldArmorModAttribute2.gridy = 3;
		fieldArmorModAttribute2.setColumns(10);
		
		lblArmorModAttribute3 = new JLabel("3rd Attribute");
		GridBagConstraints gbc_lblArmorModAttribute3 = new GridBagConstraints();
		gbc_lblArmorModAttribute3.insets = new Insets(0,0,0,5);
		gbc_lblArmorModAttribute3.gridx = 0;
		gbc_lblArmorModAttribute3.gridy = 4;
		
		boxArmorModAttribute3 = new JComboBox();
		boxArmorModAttribute3.setModel(new DefaultComboBoxModel<>(armorModAttributes));
		GridBagConstraints gbc_boxArmorModAttribute3 = new GridBagConstraints();
		gbc_boxArmorModAttribute3.insets = new Insets(0,0,0,5);
		gbc_boxArmorModAttribute3.gridx = 1;
		gbc_boxArmorModAttribute3.gridy = 4;
		
		fieldArmorModAttribute3 = new JTextField();
		GridBagConstraints gbc_fieldArmorModAttribute3 = new GridBagConstraints();
		gbc_fieldArmorModAttribute3.insets = new Insets(0,0,0,5);
		gbc_fieldArmorModAttribute3.gridx = 2;
		gbc_fieldArmorModAttribute3.gridy = 4;
		fieldArmorModAttribute3.setColumns(10);
		
		lblResult = new JLabel("Previous Mod Logged:");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.insets = new Insets(0,0,0,5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 5;
		
		lblResultLogged = new JLabel("No armor mod logged");
		GridBagConstraints gbc_lblResultLogged = new GridBagConstraints();
		gbc_lblResultLogged.insets = new Insets(0,0,0,5);
		gbc_lblResultLogged.gridx = 1;
		gbc_lblResultLogged.gridy = 5;
		
		setName("cardArmorMod");
		setLayout(gbl_cardArmorMod);
		add(lblArmorModType, gbc_lblArmorModType);
		add(boxArmorModType, gbc_boxArmorModType);
		add(lblArmorModName, gbc_lblArmorModName);
		add(boxArmorModName, gbc_boxArmorModName);
		add(lblArmorModAttribute1, gbc_lblArmorModAttribute1);
		add(boxArmorModAttribute1, gbc_boxArmorModAttribute1);
		add(fieldArmorModAttribute1, gbc_fieldArmorModAttribute1);
		add(lblArmorModAttribute2, gbc_lblArmorModAttribute2);
		add(boxArmorModAttribute2, gbc_boxArmorModAttribute2);
		add(fieldArmorModAttribute2, gbc_fieldArmorModAttribute2);
		add(lblArmorModAttribute3, gbc_lblArmorModAttribute3);
		add(boxArmorModAttribute3, gbc_boxArmorModAttribute3);
		add(fieldArmorModAttribute3, gbc_fieldArmorModAttribute3);
		add(lblResult, gbc_lblResult);
		add(lblResultLogged, gbc_lblResultLogged);
		
	}
	
	
	
	public JLabel getLblArmorModType() {
		return lblArmorModType;
	}



	public void setLblArmorModType(JLabel lblArmorModType) {
		this.lblArmorModType = lblArmorModType;
	}



	public JLabel getLblArmorModName() {
		return lblArmorModName;
	}



	public void setLblArmorModName(JLabel lblArmorModName) {
		this.lblArmorModName = lblArmorModName;
	}



	public JLabel getLblArmorModRoll() {
		return lblArmorModRoll;
	}



	public void setLblArmorModRoll(JLabel lblArmorModRoll) {
		this.lblArmorModRoll = lblArmorModRoll;
	}



	public JLabel getLblArmorModAttribute1() {
		return lblArmorModAttribute1;
	}



	public void setLblArmorModAttribute1(JLabel lblArmorModAttribute1) {
		this.lblArmorModAttribute1 = lblArmorModAttribute1;
	}



	public JLabel getLblArmorModAttribute2() {
		return lblArmorModAttribute2;
	}



	public void setLblArmorModAttribute2(JLabel lblArmorModAttribute2) {
		this.lblArmorModAttribute2 = lblArmorModAttribute2;
	}



	public JLabel getLblArmorModAttribute3() {
		return lblArmorModAttribute3;
	}



	public void setLblArmorModAttribute3(JLabel lblArmorModAttribute3) {
		this.lblArmorModAttribute3 = lblArmorModAttribute3;
	}



	public JLabel getLblResult() {
		return lblResult;
	}



	public void setLblResult(JLabel lblResult) {
		this.lblResult = lblResult;
	}



	public JLabel getLblResultLogged() {
		return lblResultLogged;
	}



	public void setLblResultLogged(JLabel lblResultLogged) {
		this.lblResultLogged = lblResultLogged;
	}



	public JComboBox getBoxArmorModType() {
		return boxArmorModType;
	}



	public void setBoxArmorModType(JComboBox boxArmorModType) {
		this.boxArmorModType = boxArmorModType;
	}



	public JComboBox getBoxArmorModName() {
		return boxArmorModName;
	}



	public void setBoxArmorModName(JComboBox boxArmorModName) {
		this.boxArmorModName = boxArmorModName;
	}



	public JComboBox getBoxArmorModRoll() {
		return boxArmorModRoll;
	}



	public void setBoxArmorModRoll(JComboBox boxArmorModRoll) {
		this.boxArmorModRoll = boxArmorModRoll;
	}



	public JComboBox getBoxArmorModAttribute1() {
		return boxArmorModAttribute1;
	}



	public void setBoxArmorModAttribute1(JComboBox boxArmorModAttribute1) {
		this.boxArmorModAttribute1 = boxArmorModAttribute1;
	}



	public JComboBox getBoxArmorModAttribute2() {
		return boxArmorModAttribute2;
	}



	public void setBoxArmorModAttribute2(JComboBox boxArmorModAttribute2) {
		this.boxArmorModAttribute2 = boxArmorModAttribute2;
	}



	public JComboBox getBoxArmorModAttribute3() {
		return boxArmorModAttribute3;
	}



	public void setBoxArmorModAttribute3(JComboBox boxArmorModAttribute3) {
		this.boxArmorModAttribute3 = boxArmorModAttribute3;
	}



	public JTextField getFieldArmorModAttribute1() {
		return fieldArmorModAttribute1;
	}



	public void setFieldArmorModAttribute1(JTextField fieldArmorModAttribute1) {
		this.fieldArmorModAttribute1 = fieldArmorModAttribute1;
	}



	public JTextField getFieldArmorModAttribute2() {
		return fieldArmorModAttribute2;
	}



	public void setFieldArmorModAttribute2(JTextField fieldArmorModAttribute2) {
		this.fieldArmorModAttribute2 = fieldArmorModAttribute2;
	}



	public JTextField getFieldArmorModAttribute3() {
		return fieldArmorModAttribute3;
	}



	public void setFieldArmorModAttribute3(JTextField fieldArmorModAttribute3) {
		this.fieldArmorModAttribute3 = fieldArmorModAttribute3;
	}



	public String[] getArmorModTypes() {
		return armorModTypes;
	}



	public void setArmorModTypes(String[] armorModTypes) {
		this.armorModTypes = armorModTypes;
	}



	public String[] getArmorModNames() {
		return armorModNames;
	}



	public void setArmorModNames(String[] armorModNames) {
		this.armorModNames = armorModNames;
	}



	public String[] getArmorModAttributes() {
		return armorModAttributes;
	}



	public void setArmorModAttributes(String[] armorModAttributes) {
		this.armorModAttributes = armorModAttributes;
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
		stringArray = stringArrayList.toArray(stringArray);
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
