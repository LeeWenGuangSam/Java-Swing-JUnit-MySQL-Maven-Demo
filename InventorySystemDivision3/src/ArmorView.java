/* Only handles the UI logic of the application.
 * 
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArmorView {
	
	//instance variables
	private JFrame frmGuiArmorCategory;
	private JPanel frameCenter, frameBottom;
	private JLabel lblBrand, lblArmorValue, lblArmorVariant;
	private JComboBox armorSlotBox, armorBrandBox, armorTalentBox1, armorTalentBox2;
	private ArrayList<JComboBox> armorAttributeBoxes = new ArrayList<JComboBox>();
	private JLabel lblTalent, lblTalent_1;
	private ArrayList<JLabel> attributeLabels = new ArrayList<JLabel>();
	//private String[] armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	private JButton confirmBtn, cancelBtn;
	private ArrayList<JTextField> armorAttributeFields = new ArrayList<JTextField>();
	//private Armor armor;
	private JTextField armorVariantField, armorValueField;
	
	private ArmorModel armorModel;

	/**
	 * Create the application.
	 */

	// Constructor
	public ArmorView(ArmorModel armorModel) {

		// create String arrays for weapon types
		/*armorSlotTypes = new String[] { "Backpack", "Chest", "Gloves", "Holster", "Kneepads", "Mask" };
		Arrays.sort(armorSlotTypes);
		armorBrandRolls = new String[] { "5.11", "Aces and Eights", "Airaldi", "Alps", "Badger", "Gila", "Hard Wired",
				"Murakami", "Negotiator's Dilemma", "Ongoing Directive", "Petrov", "Providence", "Richter & Kaiser",
				"Tip of the Spear", "True Patriot", "Wyvern Wear", "Fenris", "Gila", "Murakami", "Overlord", "Sokolov",
				"Yaahl", "China Light", "Douglas & Harding" };
		Arrays.sort(armorBrandRolls);
		armorAttributeRolls = new String[] { "Assault Rifle Damage", "Critical Hit Chance", "Critical Hit Damage",
				"Damage to Elites", "Headshot Damage", "LMG Damage", "Marksman Rifle Damage", "Pistol Damage",
				"Rifle Damage", "Shotgun Damage", "SMG Damage", "Weapon Damage", "Bonus Armor", "Hazard Protection",
				"Health", "Health on Kill", "Cooldown Reduction", "Skill Power", "(None)" };
		Arrays.sort(armorAttributeRolls);
		armorTalentRolls = new String[] { "Hardened ", "Insulated ", "Restorative ", "Self Adjusting ", "Vital",
				"Capacitive ", "Destructive ", "On the Ropes", "Efficient ", "Safeguard ", "Skilled ", "Tech Support ",
				"Hard Hitting", "Vital ", "Destructive ", "Berserk ", "Unstoppable Force ", "Bloodsucker ", "Payload ",
				"Unbreakable ", "Mad Bomber ", "Critical ", "Devastating ", "Precise ", "Surgical ", "Compensated",
				"Obiliterate", "Opportunistic", "Wicked", "Clutch", "Knee Cap", "Terminate", "To Order", "Bloodlust",
				"Gunslinger", "Reassigned", "Blacksmith", "Fill'er up", "Entrench", "Patience", "Braced", "Calculated",
				"Cloaked", "Spotter", "Centered", "Creeping Death", "Dialed In", "Trauma", "(None)" };
		Arrays.sort(armorTalentRolls);
		*/

		// create JFrame
		frmGuiArmorCategory = new JFrame();
		frmGuiArmorCategory.setTitle("GUIArmorCategory");
		frmGuiArmorCategory.setBounds(100, 100, 550, 400);
		frmGuiArmorCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create JComboBox for armor slots
		armorSlotBox = new JComboBox();
		armorSlotBox.setModel(new DefaultComboBoxModel(armorModel.getArmorSlotTypes()));
		frmGuiArmorCategory.getContentPane().add(armorSlotBox, BorderLayout.NORTH);

		// create JPanel, sets panel to GridBagLayout
		frameCenter = new JPanel();
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_frameCenter.rowHeights = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 50};
		gbl_frameCenter.columnWidths = new int[] { 75, 50, 50 };
		frameCenter.setLayout(gbl_frameCenter);

		frmGuiArmorCategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
		
		lblArmorVariant = new JLabel("Armor Variant:");
		GridBagConstraints gbc_lblArmorVariant = new GridBagConstraints();
		gbc_lblArmorVariant.anchor = GridBagConstraints.EAST;
		gbc_lblArmorVariant.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmorVariant.gridx = 0;
		gbc_lblArmorVariant.gridy = 0;
		frameCenter.add(lblArmorVariant, gbc_lblArmorVariant);
		
		armorVariantField = new JTextField();
		GridBagConstraints gbc_armorVariantField = new GridBagConstraints();
		gbc_armorVariantField.insets = new Insets(0, 0, 5, 5);
		gbc_armorVariantField.gridx = 1;
		gbc_armorVariantField.gridy = 0;
		frameCenter.add(armorVariantField, gbc_armorVariantField);
		armorVariantField.setColumns(10);
		
		lblArmorValue = new JLabel("Armor Value:");
		GridBagConstraints gbc_lblArmorValue = new GridBagConstraints();
		gbc_lblArmorValue.anchor = GridBagConstraints.EAST;
		gbc_lblArmorValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmorValue.gridx = 0;
		gbc_lblArmorValue.gridy = 1;
		frameCenter.add(lblArmorValue, gbc_lblArmorValue);
		
		armorValueField = new JTextField();
		GridBagConstraints gbc_armorValueField = new GridBagConstraints();
		gbc_armorValueField.fill = GridBagConstraints.VERTICAL;
		gbc_armorValueField.insets = new Insets(0, 0, 5, 5);
		gbc_armorValueField.gridx = 1;
		gbc_armorValueField.gridy = 1;
		frameCenter.add(armorValueField, gbc_armorValueField);
		armorValueField.setColumns(5);

		lblBrand = new JLabel("Brand:");
		GridBagConstraints gbc_lblBrand = new GridBagConstraints();
		gbc_lblBrand.anchor = GridBagConstraints.EAST;
		gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrand.gridx = 0;
		gbc_lblBrand.gridy = 2;
		frameCenter.add(lblBrand, gbc_lblBrand);

		// create JComboBox for armor brands
		armorBrandBox = new JComboBox();
		armorBrandBox.setModel(new DefaultComboBoxModel(armorModel.getArmorBrandRolls()));
		GridBagConstraints gbc_armorBrandBox = new GridBagConstraints();
		gbc_armorBrandBox.insets = new Insets(0, 0, 5, 5);
		gbc_armorBrandBox.gridx = 1;
		gbc_armorBrandBox.gridy = 2;
		frameCenter.add(armorBrandBox, gbc_armorBrandBox);

		attributeLabels.add(new JLabel("Attribute 1:"));
		GridBagConstraints gbc_attributeLabels0 = new GridBagConstraints();
		gbc_attributeLabels0.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels0.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels0.gridx = 0;
		gbc_attributeLabels0.gridy = 3;
		frameCenter.add(attributeLabels.get(0), gbc_attributeLabels0);

		// create JComboBox for armor attributes
		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(0).setModel(new DefaultComboBoxModel(armorModel.getArmorAttributeRolls()));
		GridBagConstraints gbc_armorAttributeBox1 = new GridBagConstraints();
		gbc_armorAttributeBox1.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox1.gridx = 1;
		gbc_armorAttributeBox1.gridy = 3;
		frameCenter.add(armorAttributeBoxes.get(0), gbc_armorAttributeBox1);

		// create JTextField for armor attributes
		armorAttributeFields.add(new JTextField());
		GridBagConstraints gbc_armorAttributeValue1 = new GridBagConstraints();
		gbc_armorAttributeValue1.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue1.gridx = 2;
		gbc_armorAttributeValue1.gridy = 3;
		frameCenter.add(armorAttributeFields.get(0), gbc_armorAttributeValue1);
		armorAttributeFields.get(0).setColumns(10);

		attributeLabels.add(new JLabel("Attribute 2:"));
		GridBagConstraints gbc_attributeLabels1 = new GridBagConstraints();
		gbc_attributeLabels1.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels1.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels1.gridx = 0;
		gbc_attributeLabels1.gridy = 4;
		frameCenter.add(attributeLabels.get(1), gbc_attributeLabels1);

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(1).setModel(new DefaultComboBoxModel(armorModel.getArmorAttributeRolls()));
		GridBagConstraints gbc_armorAttributeBox2 = new GridBagConstraints();
		gbc_armorAttributeBox2.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox2.gridx = 1;
		gbc_armorAttributeBox2.gridy = 4;
		frameCenter.add(armorAttributeBoxes.get(1), gbc_armorAttributeBox2);

		armorAttributeFields.add(new JTextField());
		armorAttributeFields.get(1).setColumns(10);
		GridBagConstraints gbc_armorAttributeValue2 = new GridBagConstraints();
		gbc_armorAttributeValue2.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue2.gridx = 2;
		gbc_armorAttributeValue2.gridy = 4;
		frameCenter.add(armorAttributeFields.get(1), gbc_armorAttributeValue2);

		attributeLabels.add(new JLabel("Attribute 3:"));
		GridBagConstraints gbc_attributeLabels2 = new GridBagConstraints();
		gbc_attributeLabels2.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels2.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels2.gridx = 0;
		gbc_attributeLabels2.gridy = 5;
		frameCenter.add(attributeLabels.get(2), gbc_attributeLabels2);

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(2).setModel(new DefaultComboBoxModel(armorModel.getArmorAttributeRolls()));
		GridBagConstraints gbc_armorAttributeBox3 = new GridBagConstraints();
		gbc_armorAttributeBox3.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox3.gridx = 1;
		gbc_armorAttributeBox3.gridy = 5;
		frameCenter.add(armorAttributeBoxes.get(2), gbc_armorAttributeBox3);

		armorAttributeFields.add(new JTextField());
		armorAttributeFields.get(2).setColumns(10);
		GridBagConstraints gbc_armorAttributeField3 = new GridBagConstraints();
		gbc_armorAttributeField3.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeField3.gridx = 2;
		gbc_armorAttributeField3.gridy = 5;
		frameCenter.add(armorAttributeFields.get(2), gbc_armorAttributeField3);

		attributeLabels.add(new JLabel("Attribute 4:"));
		GridBagConstraints gbc_attributeLabels3 = new GridBagConstraints();
		gbc_attributeLabels3.anchor = GridBagConstraints.EAST;
		gbc_attributeLabels3.insets = new Insets(0, 0, 5, 5);
		gbc_attributeLabels3.gridx = 0;
		gbc_attributeLabels3.gridy = 6;
		frameCenter.add(attributeLabels.get(3), gbc_attributeLabels3);

		armorAttributeBoxes.add(new JComboBox());
		armorAttributeBoxes.get(3).setModel(new DefaultComboBoxModel(armorModel.getArmorAttributeRolls()));
		GridBagConstraints gbc_armorAttributeBox4 = new GridBagConstraints();
		gbc_armorAttributeBox4.insets = new Insets(0, 0, 5, 5);
		gbc_armorAttributeBox4.gridx = 1;
		gbc_armorAttributeBox4.gridy = 6;
		frameCenter.add(armorAttributeBoxes.get(3), gbc_armorAttributeBox4);

		armorAttributeFields.add(new JTextField());
		armorAttributeFields.get(3).setColumns(10);
		GridBagConstraints gbc_armorAttributeValue3 = new GridBagConstraints();
		gbc_armorAttributeValue3.insets = new Insets(0, 0, 5, 0);
		gbc_armorAttributeValue3.gridx = 2;
		gbc_armorAttributeValue3.gridy = 6;
		frameCenter.add(armorAttributeFields.get(3), gbc_armorAttributeValue3);

		lblTalent = new JLabel("Talent 1:");
		GridBagConstraints gbc_lblTalent = new GridBagConstraints();
		gbc_lblTalent.anchor = GridBagConstraints.EAST;
		gbc_lblTalent.insets = new Insets(0, 0, 5, 5);
		gbc_lblTalent.gridx = 0;
		gbc_lblTalent.gridy = 7;
		frameCenter.add(lblTalent, gbc_lblTalent);

		// create JComboBox for armor talents
		armorTalentBox1 = new JComboBox();
		armorTalentBox1.setModel(new DefaultComboBoxModel(armorModel.getArmorTalentRolls()));
		GridBagConstraints gbc_armorTalentBox1 = new GridBagConstraints();
		gbc_armorTalentBox1.insets = new Insets(0, 0, 5, 5);
		gbc_armorTalentBox1.gridx = 1;
		gbc_armorTalentBox1.gridy = 7;
		frameCenter.add(armorTalentBox1, gbc_armorTalentBox1);

		lblTalent_1 = new JLabel("Talent 2:");
		GridBagConstraints gbc_lblTalent_1 = new GridBagConstraints();
		gbc_lblTalent_1.anchor = GridBagConstraints.EAST;
		gbc_lblTalent_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblTalent_1.gridx = 0;
		gbc_lblTalent_1.gridy = 8;
		frameCenter.add(lblTalent_1, gbc_lblTalent_1);

		armorTalentBox2 = new JComboBox();
		armorTalentBox2.setModel(new DefaultComboBoxModel(armorModel.getArmorTalentRolls()));
		GridBagConstraints gbc_armorTalentBox2 = new GridBagConstraints();
		gbc_armorTalentBox2.insets = new Insets(0, 0, 0, 5);
		gbc_armorTalentBox2.gridx = 1;
		gbc_armorTalentBox2.gridy = 8;
		frameCenter.add(armorTalentBox2, gbc_armorTalentBox2);

		// sets bottom frame to be FlowLayout
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());

		confirmBtn = new JButton("Confirm");
		//confirmBtn.addActionListener(this);
		frameBottom.add(confirmBtn);

		// sets the cancelBtn to exit when clicked
		cancelBtn = new JButton("Cancel");
		/*cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuiarmorcategory.dispose();
			}
		});*/
		frameBottom.add(cancelBtn);

		frmGuiArmorCategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);

		// sets the GUI or JFrame to be visible
		//frmGuiarmorcategory.setVisible(true);
	}

	//start Getter Setter methods
	public JComboBox getArmorSlotBox() {
		return armorSlotBox;
	}
	public void setArmorSlotBox(JComboBox armorSlotBox) {
		this.armorSlotBox = armorSlotBox;
	}
	public JComboBox getArmorBrandBox() {
		return armorBrandBox;
	}
	public void setArmorBrandBox(JComboBox armorBrandBox) {
		this.armorBrandBox = armorBrandBox;
	}
	public JComboBox getArmorTalentBox1() {
		return armorTalentBox1;
	}
	public void setArmorTalentBox1(JComboBox armorTalentBox1) {
		this.armorTalentBox1 = armorTalentBox1;
	}
	public JComboBox getArmorTalentBox2() {
		return armorTalentBox2;
	}
	public void setArmorTalentBox2(JComboBox armorTalentBox2) {
		this.armorTalentBox2 = armorTalentBox2;
	}
	public JComboBox getArmorAttributeBoxes(int i) {
		return armorAttributeBoxes.get(i);
	}
	public void setArmorAttributeBoxes(ArrayList<JComboBox> armorAttributeBoxes) {
		this.armorAttributeBoxes = armorAttributeBoxes;
	}
	public JTextField getArmorAttributeFields(int i) {
		return armorAttributeFields.get(i);
	}
	public void setArmorAttributeFields(ArrayList<JTextField> armorAttributeFields) {
		this.armorAttributeFields = armorAttributeFields;
	}
	public JTextField getArmorVariantField() {
		return armorVariantField;
	}
	public void setArmorVariantField(JTextField armorVariantField) {
		this.armorVariantField = armorVariantField;
	}
	public JTextField getArmorValueField() {
		return armorValueField;
	}
	public void setArmorValueField(JTextField armorValueField) {
		this.armorValueField = armorValueField;
	}
	
	public JButton getConfirmBtn() {
		return confirmBtn;
	}

	public void setConfirmBtn(JButton confirmBtn) {
		this.confirmBtn = confirmBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
	
	//end Getter Setter methods
	
	//Add ActionListeners to all the buttons
	public void addConfirmBtnListener(ActionListener e) {
		confirmBtn.addActionListener(e);
	}
	
	public void addCancelBtnListener(ActionListener e) {
		cancelBtn.addActionListener(e);
	}
	
	//Allows for current JFrame to be disposed
	public void disposeView() {
		frmGuiArmorCategory.dispose();
	}
	
	//Allows current JFrame to be visible
	public void setVisible(boolean result)
	{
		frmGuiArmorCategory.setVisible(result);
	}

	
}
