package pc.predi;

/* Only handles the UI logic of the application.
 * 
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ArmorView extends JPanel{
	
	//instance variables
	private JLabel lblArmorType, lblArmorBrand, lblArmorValue, lblArmorVariant, lblResult, lblResultLogged, lblTalent, lblTalent_1, lblSystemMod1, lblSystemMod2, lblProtocolMod1, lblProtocolMod2;
	private ArrayList<JLabel> attributeLabels = new ArrayList<JLabel>();
	private JComboBox boxArmorVariant, boxArmorType, boxArmorBrand, boxArmorTalent1, boxArmorTalent2, boxSystemMod1, boxSystemMod2, boxProtocolMod1 , boxProtocolMod2;
	private ArrayList<JComboBox> armorAttributeBoxes = new ArrayList<JComboBox>();
	//private String[] armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	private ArrayList<JTextField> armorAttributeFields = new ArrayList<JTextField>();
	//private Armor armor;
	private ArrayList<File> textFiles = new ArrayList<File>();
	private String[] armorTypes, armorVariants, armorBrandRolls, armorAttributeRolls, armorTalentRolls, systemModRolls, protocolModRolls;
	private String[] armorVariantBackpacks, armorVariantChests, armorVariantGloves, armorVariantHolsters, armorVariantKneepads, armorVariantMasks;
	private String[] armorTalentRollsBackpack, armorTalentRollsChest, armorTalentRollsGloves, armorTalentRollsHolster, armorTalentRollsKneepads, armorTalentRollsMask;
	//private HashSet<String> armorTalentRollsSet;
	private Set armorTalentRollsSet;
	/**
	 * Create the application.
	 */

	// Constructor
	public ArmorView() {
		
		textFiles.add(new File("Armors/ArmorTypes.txt"));
		textFiles.add(new File("Armors/ArmorVariants.txt"));
		textFiles.add(new File("Armors/ArmorBrandRolls.txt"));
		textFiles.add(new File("Armors/ArmorAttributeRolls.txt"));
		textFiles.add(new File("Armors/ArmorTalentRolls.txt"));
		textFiles.add(new File("Armors/ArmorExoticRolls.txt"));
		
		armorTypes = populateSkills(armorTypes, textFiles.get(0));
		armorVariants = populateSkills(armorVariants,textFiles.get(1));
		armorBrandRolls = populateSkills(armorBrandRolls, textFiles.get(2));
		armorAttributeRolls = populateSkills(armorAttributeRolls, textFiles.get(3));
		armorTalentRolls = populateSkills(armorTalentRolls, textFiles.get(4));
		armorTalentRolls = populateSkills(armorTalentRolls, textFiles.get(5));
				
		//armorTalentRollsSet = new HashSet<String>(Arrays.asList(armorTalentRolls));
		armorTalentRollsSet = new HashSet<>(Arrays.asList(armorTalentRolls));
		
		systemModRolls = new String[] {"None","Offensive", "Defensive", "Utility"};
		protocolModRolls = new String[] {"None","Offensive", "Defensive", "Utility"};
		
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

		
		// create JPanel, sets panel to GridBagLayout
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_frameCenter.rowHeights = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 50, 50, 50, 50, 50, 50};
		gbl_frameCenter.columnWidths = new int[] { 75, 50, 50 };
		gbl_frameCenter.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		
		lblArmorType = new JLabel("Armor Type:");
		GridBagConstraints gbc_lblArmorType = new GridBagConstraints();
		gbc_lblArmorType.anchor = GridBagConstraints.EAST;
		gbc_lblArmorType.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmorType.gridx = 0;
		gbc_lblArmorType.gridy = 0;
		
		boxArmorType = new JComboBox();
		boxArmorType.setModel(new DefaultComboBoxModel<>(armorTypes));
		GridBagConstraints gbc_boxArmorType = new GridBagConstraints();
		gbc_boxArmorType.insets = new Insets(0, 0, 5, 5);
		gbc_boxArmorType.gridx = 1;
		gbc_boxArmorType.gridy = 0;
		
		lblArmorVariant = new JLabel("Armor Variant:");
		GridBagConstraints gbc_lblArmorVariant = new GridBagConstraints();
		gbc_lblArmorVariant.anchor = GridBagConstraints.EAST;
		gbc_lblArmorVariant.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmorVariant.gridx = 0;
		gbc_lblArmorVariant.gridy = 1;
		
		boxArmorVariant = new JComboBox();
		boxArmorVariant.setModel(new DefaultComboBoxModel<>(armorVariants));
		GridBagConstraints gbc_boxArmorVariant = new GridBagConstraints();
		gbc_boxArmorVariant.insets = new Insets(0, 0, 5, 5);
		gbc_boxArmorVariant.gridx = 1;
		gbc_boxArmorVariant.gridy = 1;

		lblArmorBrand = new JLabel("Brand:");
		GridBagConstraints gbc_lblBrand = new GridBagConstraints();
		gbc_lblBrand.anchor = GridBagConstraints.EAST;
		gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrand.gridx = 0;
		gbc_lblBrand.gridy = 2;

		// create JComboBox for armor brands
		boxArmorBrand = new JComboBox();
		boxArmorBrand.setModel(new DefaultComboBoxModel(armorBrandRolls));
		GridBagConstraints gbc_boxArmorBrand = new GridBagConstraints();
		gbc_boxArmorBrand.insets = new Insets(0, 0, 5, 5);
		gbc_boxArmorBrand.gridx = 1;
		gbc_boxArmorBrand.gridy = 2;

		attributeLabels.add(new JLabel("Attribute 1:"));
		GridBagConstraints gbc_attributeLabels0 = new GridBagConstraints();
		gbc_attributeLabels0.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels0.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels0.gridx = 0;
		gbc_attributeLabels0.gridy = 3;

		// create JComboBox for armor attributes
		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(0).setModel(new DefaultComboBoxModel(armorAttributeRolls));
		armorAttributeBoxes.get(0).setSelectedItem("None");
		GridBagConstraints gbc_armorAttributeBox1 = new GridBagConstraints();
		gbc_armorAttributeBox1.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox1.gridx = 1;
		gbc_armorAttributeBox1.gridy = 3;

		// create JTextField for armor attributes
		armorAttributeFields.add(new JTextField(""));
		GridBagConstraints gbc_armorAttributeValue1 = new GridBagConstraints();
		gbc_armorAttributeValue1.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue1.gridx = 2;
		gbc_armorAttributeValue1.gridy = 3;
		armorAttributeFields.get(0).setColumns(10);

		attributeLabels.add(new JLabel("Attribute 2:"));
		GridBagConstraints gbc_attributeLabels1 = new GridBagConstraints();
		gbc_attributeLabels1.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels1.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels1.gridx = 0;
		gbc_attributeLabels1.gridy = 4;

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(1).setModel(new DefaultComboBoxModel(armorAttributeRolls));
		armorAttributeBoxes.get(1).setSelectedItem("None");
		GridBagConstraints gbc_armorAttributeBox2 = new GridBagConstraints();
		gbc_armorAttributeBox2.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox2.gridx = 1;
		gbc_armorAttributeBox2.gridy = 4;

		armorAttributeFields.add(new JTextField(""));
		armorAttributeFields.get(1).setColumns(10);
		GridBagConstraints gbc_armorAttributeValue2 = new GridBagConstraints();
		gbc_armorAttributeValue2.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue2.gridx = 2;
		gbc_armorAttributeValue2.gridy = 4;

		attributeLabels.add(new JLabel("Attribute 3:"));
		GridBagConstraints gbc_attributeLabels2 = new GridBagConstraints();
		gbc_attributeLabels2.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels2.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels2.gridx = 0;
		gbc_attributeLabels2.gridy = 5;

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(2).setModel(new DefaultComboBoxModel(armorAttributeRolls));
		armorAttributeBoxes.get(2).setSelectedItem("None");
		GridBagConstraints gbc_armorAttributeBox3 = new GridBagConstraints();
		gbc_armorAttributeBox3.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox3.gridx = 1;
		gbc_armorAttributeBox3.gridy = 5;

		armorAttributeFields.add(new JTextField(""));
		armorAttributeFields.get(2).setColumns(10);
		GridBagConstraints gbc_armorAttributeField3 = new GridBagConstraints();
		gbc_armorAttributeField3.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeField3.gridx = 2;
		gbc_armorAttributeField3.gridy = 5;

		attributeLabels.add(new JLabel("Attribute 4:"));
		GridBagConstraints gbc_attributeLabels3 = new GridBagConstraints();
		gbc_attributeLabels3.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels3.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels3.gridx = 0;
		gbc_attributeLabels3.gridy = 6;

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(3).setModel(new DefaultComboBoxModel(armorAttributeRolls));
		armorAttributeBoxes.get(3).setSelectedItem("None");
		GridBagConstraints gbc_armorAttributeBox4 = new GridBagConstraints();
		gbc_armorAttributeBox4.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox4.gridx = 1;
		gbc_armorAttributeBox4.gridy = 6;

		armorAttributeFields.add(new JTextField(""));
		armorAttributeFields.get(3).setColumns(10);
		GridBagConstraints gbc_armorAttributeValue3 = new GridBagConstraints();
		gbc_armorAttributeValue3.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue3.gridx = 2;
		gbc_armorAttributeValue3.gridy = 6;

		lblTalent = new JLabel("Talent 1:");
		GridBagConstraints gbc_lblTalent = new GridBagConstraints();
		gbc_lblTalent.anchor = GridBagConstraints.EAST;
		gbc_lblTalent.insets = new Insets(0, 0, 5, 5);
		gbc_lblTalent.gridx = 0;
		gbc_lblTalent.gridy = 7;

		// create JComboBox for armor talents
		boxArmorTalent1 = new JComboBox();
		boxArmorTalent1.setModel(new DefaultComboBoxModel(armorTalentRolls));
		boxArmorTalent1.setSelectedItem("None");
		GridBagConstraints gbc_boxArmorTalent1 = new GridBagConstraints();
		gbc_boxArmorTalent1.insets = new Insets(0, 0, 5, 5);
		gbc_boxArmorTalent1.gridx = 1;
		gbc_boxArmorTalent1.gridy = 7;

		lblTalent_1 = new JLabel("Talent 2:");
		GridBagConstraints gbc_lblTalent_1 = new GridBagConstraints();
		gbc_lblTalent_1.anchor = GridBagConstraints.EAST;
		gbc_lblTalent_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblTalent_1.gridx = 0;
		gbc_lblTalent_1.gridy = 8;

		boxArmorTalent2 = new JComboBox();
		boxArmorTalent2.setModel(new DefaultComboBoxModel(armorTalentRolls));
		boxArmorTalent2.setSelectedItem("None");
		GridBagConstraints gbc_boxArmorTalent2 = new GridBagConstraints();
		gbc_boxArmorTalent2.insets = new Insets(0, 0, 0, 5);
		gbc_boxArmorTalent2.gridx = 1;
		gbc_boxArmorTalent2.gridy = 8;
		
		lblSystemMod1 = new JLabel("System Mod 1:");
		GridBagConstraints gbc_lblSystemMod1 = new GridBagConstraints();
		gbc_lblSystemMod1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSystemMod1.gridx = 0;
		gbc_lblSystemMod1.gridy = 9;
		
		boxSystemMod1 = new JComboBox();
		boxSystemMod1.setModel(new DefaultComboBoxModel(systemModRolls));
		GridBagConstraints gbc_boxSystemMod1 = new GridBagConstraints(); 
		gbc_boxSystemMod1.insets = new Insets(0, 0, 0, 5);
		gbc_boxSystemMod1.gridx = 1;
		gbc_boxSystemMod1.gridy = 9;
		
		lblSystemMod2 = new JLabel("System Mod 2:");
		GridBagConstraints gbc_lblSystemMod2 = new GridBagConstraints();
		gbc_lblSystemMod2.insets = new Insets(0, 0, 0, 5);
		gbc_lblSystemMod2.gridx = 0;
		gbc_lblSystemMod2.gridy = 10;
		
		boxSystemMod2 = new JComboBox();
		boxSystemMod2.setModel(new DefaultComboBoxModel(systemModRolls));
		GridBagConstraints gbc_boxSystemMod2 = new GridBagConstraints(); 
		gbc_boxSystemMod2.insets = new Insets(0, 0, 0, 5);
		gbc_boxSystemMod2.gridx = 1;
		gbc_boxSystemMod2.gridy = 10;
		
		lblProtocolMod1 = new JLabel("Protocol Mod 1:");
		GridBagConstraints gbc_lblProtocolMod1 = new GridBagConstraints();
		gbc_lblProtocolMod1.insets = new Insets(0, 0, 0, 5);
		gbc_lblProtocolMod1.gridx = 0;
		gbc_lblProtocolMod1.gridy = 11;
		
		boxProtocolMod1 = new JComboBox();
		boxProtocolMod1.setModel(new DefaultComboBoxModel(protocolModRolls));
		GridBagConstraints gbc_boxProtocolMod1 = new GridBagConstraints(); 
		gbc_boxProtocolMod1.insets = new Insets(0, 0, 0, 5);
		gbc_boxProtocolMod1.gridx = 1;
		gbc_boxProtocolMod1.gridy = 11;
		
		lblProtocolMod2 = new JLabel("Protocol Mod 2:");
		GridBagConstraints gbc_lblProtocolMod2 = new GridBagConstraints();
		gbc_lblProtocolMod2.insets = new Insets(0, 0, 0, 5);
		gbc_lblProtocolMod2.gridx = 0;
		gbc_lblProtocolMod2.gridy = 12;
		
		boxProtocolMod2 = new JComboBox();
		boxProtocolMod2.setModel(new DefaultComboBoxModel(protocolModRolls));
		GridBagConstraints gbc_boxProtocolMod2 = new GridBagConstraints(); 
		gbc_boxProtocolMod2.insets = new Insets(0, 0, 0, 5);
		gbc_boxProtocolMod2.gridx = 1;
		gbc_boxProtocolMod2.gridy = 12;
		
		lblResult = new JLabel("Previous armor logged:");
		GridBagConstraints gbc_Result = new GridBagConstraints();
		gbc_Result.insets = new Insets(0, 0, 0, 5);
		gbc_Result.gridx = 0;
		gbc_Result.gridy = 13;
		
		lblResultLogged = new JLabel("No armor logged");
		GridBagConstraints gbc_ResultLogged = new GridBagConstraints();
		gbc_ResultLogged.insets = new Insets(0, 0, 0, 5);
		gbc_ResultLogged.gridx = 1;
		gbc_ResultLogged.gridy = 13;
		
		
		
		
		//Experiment to test radioButtons
		//Result: they work, but the actionlistener for it needs to access it directly for the programmer to extract the text/information out of the
		//radio buttons
		/*
		 * private JPanel radioButtonPanel;
		 * private JRadioButton radioOffenseSystemMod, radioDefenseSystemMod, 
		 * radioUtilitySystemMod, radioOffenseProtocolMod, radioDefenseProtocolMod,  radioUtilityProtocolMod;
		 * private JRadioButton radioNoneSystemMod, radioNoneProtocolMod;
		 * private ArrayList<JRadioButton> listSystemMods, listProtocolMods;
		 * private ButtonGroup btnGroupSystemMods, btnGroupProtocolMods;
		 * lblSystemMod = new JLabel("System Mod:"); radioOffenseSystemMod = new
		 * JRadioButton("Offensive"); radioDefenseSystemMod = new
		 * JRadioButton("Defensive"); radioUtilitySystemMod = new
		 * JRadioButton("Utility"); radioNoneSystemMod = new JRadioButton("None");
		 * btnGroupSystemMods = new ButtonGroup();
		 * btnGroupSystemMods.add(radioOffenseSystemMod);
		 * btnGroupSystemMods.add(radioDefenseSystemMod);
		 * btnGroupSystemMods.add(radioUtilitySystemMod);
		 * 
		 * GridBagConstraints gbc_lblSystemMod = new GridBagConstraints();
		 * gbc_lblSystemMod.insets = new Insets(0, 0, 0, 5); gbc_lblSystemMod.gridx = 0;
		 * gbc_lblSystemMod.gridy = 10;
		 * 
		 * GridBagConstraints gbc_btnGroupSystemMods = new GridBagConstraints();
		 * gbc_btnGroupSystemMods.insets = new Insets(0, 0, 0, 5);
		 * gbc_btnGroupSystemMods.gridx = 1; gbc_btnGroupSystemMods.gridy = 10;
		 * 
		 * lblProtocolMod = new JLabel("Protocol Mod:"); radioOffenseProtocolMod = new
		 * JRadioButton("Offensive"); radioDefenseProtocolMod = new
		 * JRadioButton("Defensive"); radioUtilityProtocolMod = new
		 * JRadioButton("Utility"); radioNoneProtocolMod = new JRadioButton("None");
		 * btnGroupProtocolMods = new ButtonGroup();
		 * btnGroupProtocolMods.add(radioOffenseProtocolMod);
		 * btnGroupProtocolMods.add(radioDefenseProtocolMod);
		 * btnGroupProtocolMods.add(radioUtilityProtocolMod);
		 * 
		 * //add it to the list of instance variables later radioButtonPanel = new
		 * JPanel(new FlowLayout()); radioButtonPanel.add(radioOffenseSystemMod);
		 * radioButtonPanel.add(radioDefenseSystemMod);
		 * radioButtonPanel.add(radioUtilitySystemMod);
		 * add(lblSystemMod,gbc_lblSystemMod);
		 * //add(radioOffenseSystemMod, gbc_btnGroupSystemMods);
		 * add(radioButtonPanel,gbc_btnGroupSystemMods);
		 * 
		 */
		
		//Code for accessing the radiobuttons in a nested JPanel
		//Note: requires programmer to access the JPanel first then access the components second, 
		//then finally downcasting it to its proper object/class for it work
		/*
		 * public JPanel getRadioButtonPanel() { return radioButtonPanel; }
		 * 
		 * public void setRadioButtonPanel(JPanel radioButtonPanel) {
		 * this.radioButtonPanel = radioButtonPanel; }
		 * 
		 * public JRadioButton getRadioOffenseSystemMod() { JRadioButton
		 * radioOffenseSystemMod = null; for(Component c :
		 * radioButtonPanel.getComponents()) { if(c instanceof JRadioButton) {
		 * JRadioButton radioButton = (JRadioButton) c;
		 * if(radioButton.getText().equals("Offensive")) { radioOffenseSystemMod =
		 * radioButton; break; } } } return radioOffenseSystemMod; }
		 */


		setName("cardArmor");
		setLayout(gbl_frameCenter);
		add(lblArmorType, gbc_lblArmorType);
		add(boxArmorType, gbc_boxArmorType);
		add(lblArmorVariant, gbc_lblArmorVariant);
		add(boxArmorVariant, gbc_boxArmorVariant);
		add(lblArmorBrand, gbc_lblBrand);
		add(boxArmorBrand, gbc_boxArmorBrand);
		add(attributeLabels.get(0), gbc_attributeLabels0);
		add(armorAttributeBoxes.get(0), gbc_armorAttributeBox1);
		add(armorAttributeFields.get(0), gbc_armorAttributeValue1);
		add(attributeLabels.get(1), gbc_attributeLabels1);
		add(armorAttributeBoxes.get(1), gbc_armorAttributeBox2);
		add(armorAttributeFields.get(1), gbc_armorAttributeValue2);
		add(attributeLabels.get(2), gbc_attributeLabels2);
		add(armorAttributeBoxes.get(2), gbc_armorAttributeBox3);
		add(armorAttributeFields.get(2), gbc_armorAttributeField3);
		add(attributeLabels.get(3), gbc_attributeLabels3);
		add(armorAttributeBoxes.get(3), gbc_armorAttributeBox4);
		add(armorAttributeFields.get(3), gbc_armorAttributeValue3);
		add(lblTalent, gbc_lblTalent);
		add(boxArmorTalent1, gbc_boxArmorTalent1);
		add(lblTalent_1, gbc_lblTalent_1);
		add(boxArmorTalent2, gbc_boxArmorTalent2);
		
		add(lblSystemMod1, gbc_lblSystemMod1);
		add(boxSystemMod1, gbc_boxSystemMod1);
		add(lblSystemMod2, gbc_lblSystemMod2);
		add(boxSystemMod2, gbc_boxSystemMod2);
		add(lblProtocolMod1, gbc_lblProtocolMod1);
		add(boxProtocolMod1, gbc_boxProtocolMod1);
		add(lblProtocolMod2, gbc_lblProtocolMod2);
		add(boxProtocolMod2, gbc_boxProtocolMod2);
		add(lblResult, gbc_Result);
		add(lblResultLogged, gbc_ResultLogged);
		
	}

	//start Getter Setter methods}

	public JLabel getLblArmorTypes() {
		return lblArmorType;
	}

	public void setLblArmorTypes(JLabel lblArmorTypes) {
		this.lblArmorType = lblArmorTypes;
	}

	public JLabel getLblArmorBrand() {
		return lblArmorBrand;
	}

	public void setLblArmorBrand(JLabel lblArmorBrand) {
		this.lblArmorBrand = lblArmorBrand;
	}

	public JLabel getLblArmorValue() {
		return lblArmorValue;
	}

	public void setLblArmorValue(JLabel lblArmorValue) {
		this.lblArmorValue = lblArmorValue;
	}

	public JLabel getLblArmorVariant() {
		return lblArmorVariant;
	}

	public void setLblArmorVariant(JLabel lblArmorVariant) {
		this.lblArmorVariant = lblArmorVariant;
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

	public JLabel getLblTalent() {
		return lblTalent;
	}

	public void setLblTalent(JLabel lblTalent) {
		this.lblTalent = lblTalent;
	}

	public JLabel getLblTalent_1() {
		return lblTalent_1;
	}

	public void setLblTalent_1(JLabel lblTalent_1) {
		this.lblTalent_1 = lblTalent_1;
	}

	public ArrayList<JLabel> getAttributeLabels() {
		return attributeLabels;
	}

	public void setAttributeLabels(ArrayList<JLabel> attributeLabels) {
		this.attributeLabels = attributeLabels;
	}

	public JComboBox getBoxArmorVariant() {
		return boxArmorVariant;
	}

	public void setBoxArmorVariant(JComboBox boxArmorVariant) {
		this.boxArmorVariant = boxArmorVariant;
	}

	public JComboBox getBoxArmorType() {
		return boxArmorType;
	}

	public void setBoxArmorType(JComboBox boxArmorType) {
		this.boxArmorType = boxArmorType;
	}

	public JComboBox getBoxArmorBrand() {
		return boxArmorBrand;
	}

	public void setBoxArmorBrand(JComboBox boxArmorBrand) {
		this.boxArmorBrand = boxArmorBrand;
	}

	public JComboBox getBoxArmorTalent1() {
		return boxArmorTalent1;
	}

	public void setBoxArmorTalent1(JComboBox boxArmorTalent1) {
		this.boxArmorTalent1 = boxArmorTalent1;
	}

	public JComboBox getBoxArmorTalent2() {
		return boxArmorTalent2;
	}

	public void setBoxArmorTalent2(JComboBox boxArmorTalent2) {
		this.boxArmorTalent2 = boxArmorTalent2;
	}

	public ArrayList<JComboBox> getArmorAttributeBoxes() {
		return armorAttributeBoxes;
	}

	public void setArmorAttributeBoxes(ArrayList<JComboBox> armorAttributeBoxes) {
		this.armorAttributeBoxes = armorAttributeBoxes;
	}

	public ArrayList<JTextField> getArmorAttributeFields() {
		return armorAttributeFields;
	}

	public void setArmorAttributeFields(ArrayList<JTextField> armorAttributeFields) {
		this.armorAttributeFields = armorAttributeFields;
	}
	
	public ArrayList<File> getTextFiles() {
		return textFiles;
	}

	public void setTextFiles(ArrayList<File> textFiles) {
		this.textFiles = textFiles;
	}

	public String[] getArmorTypes() {
		return armorTypes;
	}

	public void setArmorTypes(String[] armorTypes) {
		this.armorTypes = armorTypes;
	}

	public String[] getArmorVariants() {
		return armorVariants;
	}

	public void setArmorVariants(String[] armorVariants) {
		this.armorVariants = armorVariants;
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
	
	//end Getter Setter methods

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
}
