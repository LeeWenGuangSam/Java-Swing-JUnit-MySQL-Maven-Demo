import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class GUIArmorCategory implements ActionListener, Runnable {
	// instance variables, more to come when needed
	private JFrame frmGuiarmorcategory;
	private JPanel frameCenter, frameBottom;
	private JLabel lblBrand, lblArmorValue, lblArmorVariant;
	private JComboBox armorSlotBox, armorBrandBox, armorTalentBox1, armorTalentBox2;
	private ArrayList<JComboBox> armorAttributeBoxes = new ArrayList<JComboBox>();
	private JLabel lblTalent, lblTalent_1;
	private ArrayList<JLabel> attributeLabels = new ArrayList<JLabel>();
	private String[] armorSlotTypes, armorBrandRolls, armorAttributeRolls, armorTalentRolls;
	private JButton confirmBtn, cancelBtn;
	private ArrayList<JTextField> armorAttributeFields = new ArrayList<JTextField>();
	private Armor armor;
	private JTextField armorVariantField, armorValueField;

	/**
	 * Create the application.
	 */

	// Constructor to be used instead of a main to be used in main GUI
	public GUIArmorCategory() {

		// create String arrays for weapon types
		armorSlotTypes = new String[] { "Backpack", "Chest", "Gloves", "Holster", "Kneepads", "Mask" };
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

		// create JFrame
		frmGuiarmorcategory = new JFrame();
		frmGuiarmorcategory.setTitle("GUIArmorCategory");
		frmGuiarmorcategory.setBounds(100, 100, 550, 400);
		frmGuiarmorcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create JComboBox for armor slots
		armorSlotBox = new JComboBox();
		armorSlotBox.setModel(new DefaultComboBoxModel(armorSlotTypes));
		frmGuiarmorcategory.getContentPane().add(armorSlotBox, BorderLayout.NORTH);

		// create JPanel, sets panel to GridBagLayout
		frameCenter = new JPanel();
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_frameCenter.rowHeights = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 50};
		gbl_frameCenter.columnWidths = new int[] { 75, 50, 50 };
		frameCenter.setLayout(gbl_frameCenter);

		frmGuiarmorcategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
		
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
		armorBrandBox.setModel(new DefaultComboBoxModel(armorBrandRolls));
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
		armorAttributeBoxes.get(0).setModel(new DefaultComboBoxModel(armorAttributeRolls));
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
		armorAttributeBoxes.get(1).setModel(new DefaultComboBoxModel(armorAttributeRolls));
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
		armorAttributeBoxes.get(2).setModel(new DefaultComboBoxModel(armorAttributeRolls));
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
		armorAttributeBoxes.get(3).setModel(new DefaultComboBoxModel(armorAttributeRolls));
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
		armorTalentBox1.setModel(new DefaultComboBoxModel(armorTalentRolls));
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
		armorTalentBox2.setModel(new DefaultComboBoxModel(armorTalentRolls));
		GridBagConstraints gbc_armorTalentBox2 = new GridBagConstraints();
		gbc_armorTalentBox2.insets = new Insets(0, 0, 0, 5);
		gbc_armorTalentBox2.gridx = 1;
		gbc_armorTalentBox2.gridy = 8;
		frameCenter.add(armorTalentBox2, gbc_armorTalentBox2);

		// sets bottom frame to be FlowLayout
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());

		confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(this);
		frameBottom.add(confirmBtn);

		// sets the cancelBtn to exit when clicked
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuiarmorcategory.dispose();
			}
		});
		frameBottom.add(cancelBtn);

		frmGuiarmorcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);

		// sets the GUI or JFrame to be visible
		frmGuiarmorcategory.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * frmGuiarmorcategory = new JFrame();
		 * frmGuiarmorcategory.setTitle("GUIArmorCategory");
		 * frmGuiarmorcategory.setBounds(100, 100, 450, 300);
		 * frmGuiarmorcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * JComboBox comboBox = new JComboBox(); comboBox.setModel(new
		 * DefaultComboBoxModel(new String[] {"Backpack", "Chest", "Gloves", "Holster",
		 * "Kneepads", "Mask"})); frmGuiarmorcategory.getContentPane().add(comboBox,
		 * BorderLayout.NORTH);
		 * 
		 * frameBottom = new JPanel(); frameBottom.setLayout(new FlowLayout());
		 * 
		 * JButton confirmBtn = new JButton("Confirm"); frameBottom.add(confirmBtn);
		 * 
		 * JButton cancelBtn = new JButton("Cancel"); frameBottom.add(cancelBtn);
		 * 
		 * frmGuiarmorcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);
		 */
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == confirmBtn) {
			armor = createArmor();
			frmGuiarmorcategory.dispose();
		} else if (e.getSource() == cancelBtn) {
			frmGuiarmorcategory.dispose();
		}
	}

	public Armor createArmor() {
		String armorVariant = armorVariantField.getText();
		String armorValue = armorValueField.getText();
		String armorSlot = armorSlotBox.getSelectedItem().toString();
		String armorBrand = armorBrandBox.getSelectedItem().toString();
		String armorAttributesBoxStrings[] = new String[armorAttributeBoxes.size()];
		String armorAttributeFieldStrings[] = new String[armorAttributeFields.size()];
		for (int i = 0; i < armorAttributesBoxStrings.length; i++) {
			armorAttributesBoxStrings[i] = armorAttributeBoxes.get(i).getSelectedItem().toString();
		}
		for (int i = 0; i < armorAttributeFields.size(); i++) {
			armorAttributeFieldStrings[i] = armorAttributeFields.get(i).getText();
		}
		String armorTalent1 = armorTalentBox1.getSelectedItem().toString();
		String armorTalent2 = armorTalentBox2.getSelectedItem().toString();
		return new Armor(armorVariant, armorValue, armorSlot, armorBrand, armorAttributesBoxStrings[0], armorAttributeFieldStrings[0],
				armorAttributesBoxStrings[1], armorAttributeFieldStrings[1], armorAttributesBoxStrings[2],
				armorAttributeFieldStrings[2], armorAttributesBoxStrings[3], armorAttributeFieldStrings[3],
				armorTalent1, armorTalent2);
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public String toString() {
		return armor.toString();
	}

}
