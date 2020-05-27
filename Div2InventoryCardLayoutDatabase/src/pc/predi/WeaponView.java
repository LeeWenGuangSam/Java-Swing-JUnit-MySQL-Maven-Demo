package pc.predi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.plaf.DimensionUIResource;

public class WeaponView extends JPanel{

	// instance variables
	private JComboBox boxWeaponTypes, boxWeaponVariant, boxWeaponType, boxActiveSkill, boxHandlingSkill, boxHolsteredSkill;
	private ArrayList<File> textFiles = new ArrayList<File>();
    private String[] weaponTypes, weaponVariants, activeSkills, handlingSkills, equippedHolsteredSkills;
	private String[] weaponVariantAssaultRifle, weaponVariantLightMachineGun, weaponVariantMarksmanRifle, weaponVariantPistol, weaponVariantRifle, weaponVariantShotgun, weaponVariantSubmachineGun;
    private JLabel lblWeaponTypes, lblweaponVariant, lblWeaponDamage, lblactiveLabel, lblHandlingSkill1, lblHolsteredSkill, lblResult, lblResultLogged;
    private JTextField fldWeaponDamage;
	// private String weaponType, weaponVariant, activeSkill, handlingSkill,
	// holsteredSkill;

	/*
	 * Implementing change to include a comboBox that reads from a file Reimplement
	 * the code below to revert
	 * 
	 */
	// private JComboBox boxHandlingSkill2;
	// private JTextPane paneWeaponVariant;

	// private Weapon weapon;
	// private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	

	// Constructor
	@SuppressWarnings("unchecked")
	public WeaponView() {
		//change this to put this all in 1 method later
    	textFiles.add(new File("Weapons/WeaponTypes.txt"));
    	textFiles.add(new File("Weapons/WeaponVariants.txt"));
    	textFiles.add(new File("Weapons/ActiveSkills.txt"));
    	textFiles.add(new File("Weapons/Exotic Active Skills.txt"));
    	textFiles.add(new File("Weapons/HandlingSkills.txt"));
    	textFiles.add(new File("Weapons/EquippedSkills.txt"));
    	textFiles.add(new File("Weapons/Exotic Handling Skills.txt"));
    	textFiles.add(new File("Weapons/HolsteredSkills.txt"));
    	textFiles.add(new File("Weapons/Exotic Holstered Skills.txt"));
    	
    	//weaponTypes = populateSkills(weaponTypes, textFiles.get(0));
    	weaponVariants = populateSkills(weaponVariants, textFiles.get(1));
    	activeSkills = populateSkills(activeSkills, textFiles.get(2));
    	activeSkills = populateSkills(activeSkills, textFiles.get(3));
    	handlingSkills = populateSkills(handlingSkills, textFiles.get(4));
    	handlingSkills = populateSkills(handlingSkills, textFiles.get(5));
    	handlingSkills = populateSkills(handlingSkills, textFiles.get(6));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, textFiles.get(4));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, textFiles.get(5));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, textFiles.get(7));
    	equippedHolsteredSkills = populateSkills(equippedHolsteredSkills, textFiles.get(8));
    	
    	//weaponTypes = populateSkills(weaponTypes, new File("Weapons/WeaponTypes.txt"));
    	weaponTypes = populateSkillsDatabase("weaponType", "WeaponVariants");
    	weaponVariants = populateSkillsDatabase("weaponVariant","WeaponVariants");
    	activeSkills = populateSkillsDatabase("activeSkill", "ActiveSkills");
    	handlingSkills = populateSkillsDatabase("handlingSkill","HandlingSkills");
    	equippedHolsteredSkills = populateSkillsDatabase("holsteredSkill", "HolsteredSkills");
    	//equippedHolsteredSkills = populateSkillsDatabase("","");
//    	weaponVariantAssaultRifle = populateSkills(weaponVariantAssaultRifle, new File("Weapons/WeaponVariants/Assault Rifle.txt"));
//    	weaponVariantLightMachineGun = populateSkills(weaponVariantLightMachineGun, new File("Weapons/WeaponVariants/Light Machine Gun.txt"));
//    	weaponVariantMarksmanRifle = populateSkills(weaponVariantMarksmanRifle, new File("Weapons/WeaponVariants/Marksman Rifle.txt"));
//    	weaponVariantPistol = populateSkills(weaponVariantPistol, new File("Weapons/WeaponVariants/Pistol.txt"));
//    	weaponVariantRifle = populateSkills(weaponVariantRifle, new File("Weapons/WeaponVariants/Rifle.txt"));
//    	weaponVariantShotgun = populateSkills(weaponVariantShotgun, new File("Weapons/WeaponVariants/Shotgun.txt"));
//    	weaponVariantSubmachineGun = populateSkills(weaponVariantSubmachineGun, new File("Weapons/WeaponVariants/Submachine Gun.txt"));
		// insert code for GUI here
//		frmGuiweaponcategory = new JFrame();
//		frmGuiweaponcategory.setTitle("GUIWeaponCategory");
//		frmGuiweaponcategory.setBounds(100, 100, 450, 350);
//		frmGuiweaponcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frmGuiweaponcategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWidths = new int[] { 50, 50, 50, 50 };
		gbl_frameCenter.rowHeights = new int[] { 0, 0, 20, 20, 20, 20 };
		gbl_frameCenter.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gbl_frameCenter.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		
		lblWeaponTypes = new JLabel("Weapon Type");
		GridBagConstraints gbc_weaponTypes = new GridBagConstraints();
		gbc_weaponTypes.insets = new Insets(0, 0, 5, 5);
		gbc_weaponTypes.gridx = 0;
		gbc_weaponTypes.gridy = 0;
		
		boxWeaponTypes = new JComboBox();
		boxWeaponTypes.setModel(new DefaultComboBoxModel(weaponTypes));
		GridBagConstraints gbc_boxWeaponTypes = new GridBagConstraints();
		gbc_boxWeaponTypes.insets = new Insets(0, 0, 5, 5);
		//gbc_boxWeaponTypes.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxWeaponTypes.gridx = 1;
		gbc_boxWeaponTypes.gridy = 0;

		lblweaponVariant = new JLabel("Weapon Variant");
		GridBagConstraints gbc_lblweaponVariant = new GridBagConstraints();
		gbc_lblweaponVariant.insets = new Insets(0, 0, 5, 5);
		gbc_lblweaponVariant.gridx = 0;
		gbc_lblweaponVariant.gridy = 1;

		boxWeaponVariant = new JComboBox();
		boxWeaponVariant.setModel(new DefaultComboBoxModel(weaponVariants));
		//boxWeaponVariant.setEditable(true);
		GridBagConstraints gbc_boxWeaponVariant = new GridBagConstraints();
		gbc_boxWeaponVariant.insets = new Insets(0, 0, 5, 5);
		//gbc_boxWeaponVariant.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxWeaponVariant.gridx = 1;
		gbc_boxWeaponVariant.gridy = 1;

		/*
		 * paneWeaponVariant = new JTextPane(); GridBagConstraints gbc_paneWeaponVariant
		 * = new GridBagConstraints(); gbc_paneWeaponVariant.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_paneWeaponVariant.insets = new Insets(0,
		 * 0, 5, 5); gbc_paneWeaponVariant.gridx = 1; gbc_paneWeaponVariant.gridy = 0;
		 * frameCenter.add(paneWeaponVariant, gbc_paneWeaponVariant);
		 */
		
		lblWeaponDamage = new JLabel("Weapon Damage");
		GridBagConstraints gbc_lblWeaponDamage = new GridBagConstraints();
		gbc_lblWeaponDamage.insets = new Insets(0,0,5,5);
		gbc_lblWeaponDamage.gridx = 0;
		gbc_lblWeaponDamage.gridy = 2;
		
		fldWeaponDamage = new JTextField("");
		GridBagConstraints gbc_fldWeaponDamage = new GridBagConstraints();
		gbc_fldWeaponDamage.insets = new Insets(0,0,5,5);
		gbc_fldWeaponDamage.gridx = 1;
		gbc_fldWeaponDamage.gridy = 2;
		fldWeaponDamage.setColumns(10);

		// Add label to mark combo box
		lblactiveLabel = new JLabel("Active Skill");
		GridBagConstraints gbc_lblactiveLabel = new GridBagConstraints();
		gbc_lblactiveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblactiveLabel.gridx = 0;
		gbc_lblactiveLabel.gridy = 3;

		boxActiveSkill = new JComboBox();
		boxActiveSkill.setModel(new DefaultComboBoxModel(activeSkills));
		GridBagConstraints gbc_boxActiveSkill = new GridBagConstraints();
		gbc_boxActiveSkill.insets = new Insets(0, 0, 5, 5);
		gbc_boxActiveSkill.gridx = 1;
		gbc_boxActiveSkill.gridy = 3;

		lblHandlingSkill1 = new JLabel("Handling/Equipped Skill");
		GridBagConstraints gbc_lblHandlingSkill = new GridBagConstraints();
		gbc_lblHandlingSkill.insets = new Insets(0, 0, 5, 5);
		gbc_lblHandlingSkill.gridx = 0;
		gbc_lblHandlingSkill.gridy = 4;

		boxHandlingSkill = new JComboBox();
		boxHandlingSkill.setModel(new DefaultComboBoxModel(handlingSkills));
		GridBagConstraints gbc_boxHandlingSkill = new GridBagConstraints();
		gbc_boxHandlingSkill.insets = new Insets(0, 0, 5, 5);
		gbc_boxHandlingSkill.gridx = 1;
		gbc_boxHandlingSkill.gridy = 4;

		/*
		 * JLabel lblHandlingequippedSkill2 = new JLabel("Handling/Equipped Skill 2:");
		 * GridBagConstraints gbc_lblHandlingequippedSkill2 = new GridBagConstraints();
		 * gbc_lblHandlingequippedSkill2.anchor = GridBagConstraints.EAST;
		 * gbc_lblHandlingequippedSkill2.insets = new Insets(0, 0, 5, 5);
		 * gbc_lblHandlingequippedSkill2.gridx = 0; gbc_lblHandlingequippedSkill2.gridy
		 * = 3; frameCenter.add(lblHandlingequippedSkill2,
		 * gbc_lblHandlingequippedSkill2);
		 * 
		 * boxHandlingSkill2 = new JComboBox(); boxHandlingSkill2.setModel(new
		 * DefaultComboBoxModel(weaponModel.getHandlingSkills())); GridBagConstraints
		 * gbc_boxHandlingSkill2 = new GridBagConstraints();
		 * gbc_boxHandlingSkill2.insets = new Insets(0, 0, 5, 5);
		 * gbc_boxHandlingSkill2.gridx = 1; gbc_boxHandlingSkill2.gridy = 3;
		 * frameCenter.add(boxHandlingSkill2, gbc_boxHandlingSkill2);
		 */

		lblHolsteredSkill = new JLabel("Handling/Equipped/Holstered Skill:");
		GridBagConstraints gbc_lblHolsteredSkill = new GridBagConstraints();
		gbc_lblHolsteredSkill.insets = new Insets(0, 0, 0, 5);
		gbc_lblHolsteredSkill.gridx = 0;
		gbc_lblHolsteredSkill.gridy = 5;

		boxHolsteredSkill = new JComboBox();
		boxHolsteredSkill.setModel(new DefaultComboBoxModel(equippedHolsteredSkills));
		GridBagConstraints gbc_boxHolsteredSkill = new GridBagConstraints();
		gbc_boxHolsteredSkill.insets = new Insets(0, 0, 0, 5);
		gbc_boxHolsteredSkill.gridx = 1;
		gbc_boxHolsteredSkill.gridy = 5;
		
		lblResult = new JLabel("Previous weapon logged:");
		GridBagConstraints gbc_Result = new GridBagConstraints();
		gbc_Result.insets = new Insets(0, 0, 0, 5);
		gbc_Result.gridx = 0;
		gbc_Result.gridy = 6;
		
		lblResultLogged = new JLabel("No weapon logged");
		GridBagConstraints gbc_ResultLogged = new GridBagConstraints();
		gbc_ResultLogged.insets = new Insets(0, 0, 0, 5);
		gbc_ResultLogged.gridx = 1;
		gbc_ResultLogged.gridy = 6;

		// sets the JFrame to be visible
		// frmGuiweaponcategory.setVisible(true);
		
    	setName("cardWeapon");
		setLayout(gbl_frameCenter);
		add(lblWeaponTypes, gbc_weaponTypes);
		add(boxWeaponTypes, gbc_boxWeaponTypes);
		add(lblweaponVariant, gbc_lblweaponVariant);
		add(boxWeaponVariant, gbc_boxWeaponVariant);
		add(lblWeaponDamage, gbc_lblWeaponDamage);
		add(fldWeaponDamage, gbc_fldWeaponDamage);
		add(lblactiveLabel, gbc_lblactiveLabel);
		add(boxActiveSkill, gbc_boxActiveSkill);
		add(lblHandlingSkill1, gbc_lblHandlingSkill);
		add(boxHandlingSkill, gbc_boxHandlingSkill);
		add(lblHolsteredSkill, gbc_lblHolsteredSkill);
		add(boxHolsteredSkill, gbc_boxHolsteredSkill);
		add(lblResult, gbc_Result);
		add(lblResultLogged, gbc_ResultLogged);

		
	}

	// Getter setter methods
	/*
	 * public JTextPane getPaneWeaponVariant() {
	 * 
	 * return paneWeaponVariant; }
	 * 
	 * public void setPaneWeaponVariant(JTextPane paneWeaponVariant) {
	 * this.paneWeaponVariant = paneWeaponVariant; }
	 */

	public JComboBox getBoxWeaponTypes() {
		return boxWeaponTypes;
	}

	public void setBoxWeaponTypes(JComboBox boxWeaponTypes) {
		this.boxWeaponTypes = boxWeaponTypes;
	}

	public JComboBox getBoxWeaponVariant() {
		return boxWeaponVariant;
	}

	public void setBoxWeaponVariant(JComboBox boxWeaponVariant) {
		this.boxWeaponVariant = boxWeaponVariant;
	}
	
	public JLabel getLblWeaponDamage() {
		return lblWeaponDamage;
	}
	
	public JTextField getFldWeaponDamage() {
		return fldWeaponDamage;
	}

//	public JComboBox getBoxWeaponType() {
//		return boxWeaponType;
//	}
//
//	public void setBoxWeaponType(JComboBox boxWeaponType) {
//		this.boxWeaponType = boxWeaponType;
//	}

	public void setFldWeaponDamage(JTextField fldWeaponDamage) {
		this.fldWeaponDamage = fldWeaponDamage;
	}

	public void setLblWeaponDamage(JLabel lblWeaponDamage) {
		this.lblWeaponDamage = lblWeaponDamage;
	}

	public JComboBox getBoxActiveSkill() {
		return boxActiveSkill;
	}

	public void setBoxActiveSkill(JComboBox boxActiveSkill) {
		this.boxActiveSkill = boxActiveSkill;
	}

	public JComboBox getBoxHandlingSkill() {
		return boxHandlingSkill;
	}

	public void setBoxHandlingSkill(JComboBox boxHandlingSkill1) {
		this.boxHandlingSkill = boxHandlingSkill1;
	}

	/*
	 * public JComboBox getBoxHandlingSkill2() { return boxHandlingSkill2; }
	 * 
	 * public void setBoxHandlingSkill2(JComboBox boxHandlingSkill2) {
	 * this.boxHandlingSkill2 = boxHandlingSkill2; }
	 */

	public JComboBox getBoxHolsteredSkill() {
		return boxHolsteredSkill;
	}

	public void setBoxHolsteredSkill(JComboBox boxHolsteredSkill) {
		this.boxHolsteredSkill = boxHolsteredSkill;
	}
	
	public JLabel getLblResultLogged() {
		return lblResultLogged;
	}

	public void setLblResultLogged(JLabel lblResultLogged) {
		this.lblResultLogged = lblResultLogged;
	}

	// end getter setter methods

	// Adds Actionlisteners to the buttons

	/*
	 * public void addConfirmBtnListener(ActionListener e) {
	 * confirmBtn.addActionListener(e); }
	 * 
	 * public void addCancelBtnListener(ActionListener e) {
	 * cancelBtn.addActionListener(e); }
	 */
	
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
	
	public String[] populateSkillsDatabase(String fields, String table) {
		String[] exitArray;
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select distinct " + fields + " from " + table);
		List<Object> listObjects = query.getResultList();
		exitArray = new String[listObjects.size()];
		listObjects.toArray(exitArray);
		Arrays.sort(exitArray);
		em.close();
		return exitArray;
	}
	
	public String[] convertStringArrayListToStringArray(ArrayList<String> stringArrayList) {
		
		String[] stringArray = new String[stringArrayList.size()];
//		for(int i = 0; i < stringArrayList.size(); i++) {
//			stringArray[i] = stringArrayList.get(i);
//		}
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
	
	public void selectStatement(String field, String table) {
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		List<Object> result = em.createQuery(" SELECT " + field + " FROM " + table ).getResultList();
		
		em.close();
	}
}

