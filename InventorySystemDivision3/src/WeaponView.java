
/*
 * Handles UI logic of the application
 */

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class WeaponView {

	// instance variables
	private JButton confirmBtn, cancelBtn;
	private JFrame frmGuiweaponcategory;
	private JPanel frameBottom, frameCenter;
	// private String weaponType, weaponVariant, activeSkill, handlingSkill,
	// holsteredSkill;

	/*
	 * Implementing change to include a comboBox that reads from a file Reimplement
	 * the code below to revert
	 * 
	 */
	private JComboBox boxWeaponVariant, boxWeaponType, boxActiveSkill, boxHandlingSkill, boxHolsteredSkill;
	// private JComboBox boxHandlingSkill2;
	// private JTextPane paneWeaponVariant;

	// private Weapon weapon;
	// private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private WeaponModel weaponModel;

	// Constructor
	public WeaponView(WeaponModel weaponModel) {
		this.weaponModel = weaponModel;
		// insert code for GUI here
		frmGuiweaponcategory = new JFrame();
		frmGuiweaponcategory.setTitle("GUIWeaponCategory");
		frmGuiweaponcategory.setBounds(100, 100, 450, 350);
		frmGuiweaponcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// new JPanel because JFrames can't be put in a JFrame
		// sets frame to be a FlowLayout as well
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());

		// comboBox for easy access to weapon category types
		boxWeaponType = new JComboBox();
		boxWeaponType.setModel(new DefaultComboBoxModel(weaponModel.getWeaponTypes()));
		frmGuiweaponcategory.getContentPane().add(boxWeaponType, BorderLayout.NORTH);

		// BorderLayout.SOUTH is now a FlowLayout
		frmGuiweaponcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);

		confirmBtn = new JButton("Confirm");
		// confirmBtn.addActionListener(this);
		frameBottom.add(confirmBtn);

		// adds cancelBtn and exits when buttonClicked
		cancelBtn = new JButton("Cancel");
		// cancelBtn.addActionListener(this);
		/*
		 * cancelBtn.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { frmGuiweaponcategory.dispose(); } });
		 */
		frameBottom.add(cancelBtn);

		frameCenter = new JPanel();
		frmGuiweaponcategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWidths = new int[] { 50, 50, 50 };
		gbl_frameCenter.rowHeights = new int[] { 50, 50, 50, 50, 50 };
		gbl_frameCenter.columnWeights = new double[] { 0.0, 1.0 };
		gbl_frameCenter.rowWeights = new double[] { 1.0, Double.MIN_VALUE, 0.0, 0.0 };
		frameCenter.setLayout(gbl_frameCenter);

		JLabel weaponVariant = new JLabel("Weapon Variant");
		GridBagConstraints gbc_weaponVariant = new GridBagConstraints();
		gbc_weaponVariant.insets = new Insets(0, 0, 5, 5);
		gbc_weaponVariant.gridx = 0;
		gbc_weaponVariant.gridy = 0;
		frameCenter.add(weaponVariant, gbc_weaponVariant);

		boxWeaponVariant = new JComboBox();
		boxWeaponVariant.setModel(new DefaultComboBoxModel(weaponModel.getWeaponVariants()));
		GridBagConstraints gbc_boxWeaponVariant = new GridBagConstraints();
		gbc_boxWeaponVariant.insets = new Insets(0, 0, 5, 5);
		gbc_boxWeaponVariant.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxWeaponVariant.gridx = 1;
		gbc_boxWeaponVariant.gridy = 0;
		frameCenter.add(boxWeaponVariant, gbc_boxWeaponVariant);

		/*
		 * paneWeaponVariant = new JTextPane(); GridBagConstraints gbc_paneWeaponVariant
		 * = new GridBagConstraints(); gbc_paneWeaponVariant.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_paneWeaponVariant.insets = new Insets(0,
		 * 0, 5, 5); gbc_paneWeaponVariant.gridx = 1; gbc_paneWeaponVariant.gridy = 0;
		 * frameCenter.add(paneWeaponVariant, gbc_paneWeaponVariant);
		 */

		// Add label to mark combo box
		JLabel activeLabel = new JLabel("Active Skill");
		GridBagConstraints gbc_activeLabel = new GridBagConstraints();
		gbc_activeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_activeLabel.gridx = 0;
		gbc_activeLabel.gridy = 1;
		frameCenter.add(activeLabel, gbc_activeLabel);

		boxActiveSkill = new JComboBox();
		boxActiveSkill.setModel(new DefaultComboBoxModel(weaponModel.getActiveSkills()));
		GridBagConstraints gbc_boxActiveSkill = new GridBagConstraints();
		gbc_boxActiveSkill.insets = new Insets(0, 0, 5, 5);
		gbc_boxActiveSkill.gridx = 1;
		gbc_boxActiveSkill.gridy = 1;
		frameCenter.add(boxActiveSkill, gbc_boxActiveSkill);

		JLabel lblHandlingSkill1 = new JLabel("Handling Skill");
		GridBagConstraints gbc_lblHandlingSkill = new GridBagConstraints();
		gbc_lblHandlingSkill.insets = new Insets(0, 0, 5, 5);
		gbc_lblHandlingSkill.gridx = 0;
		gbc_lblHandlingSkill.gridy = 2;
		frameCenter.add(lblHandlingSkill1, gbc_lblHandlingSkill);

		boxHandlingSkill = new JComboBox();
		boxHandlingSkill.setModel(new DefaultComboBoxModel(weaponModel.getHandlingSkills()));
		GridBagConstraints gbc_boxHandlingSkill = new GridBagConstraints();
		gbc_boxHandlingSkill.insets = new Insets(0, 0, 5, 5);
		gbc_boxHandlingSkill.gridx = 1;
		gbc_boxHandlingSkill.gridy = 2;
		frameCenter.add(boxHandlingSkill, gbc_boxHandlingSkill);

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

		JLabel lblHolsteredSkill = new JLabel("Equipped/Holstered Skill:");
		GridBagConstraints gbc_lblHolsteredSkill = new GridBagConstraints();
		gbc_lblHolsteredSkill.insets = new Insets(0, 0, 0, 5);
		gbc_lblHolsteredSkill.gridx = 0;
		gbc_lblHolsteredSkill.gridy = 3;
		frameCenter.add(lblHolsteredSkill, gbc_lblHolsteredSkill);

		boxHolsteredSkill = new JComboBox();
		boxHolsteredSkill.setModel(new DefaultComboBoxModel(weaponModel.getHandlingHolsteredSkills()));
		GridBagConstraints gbc_boxHolsteredSkill = new GridBagConstraints();
		gbc_boxHolsteredSkill.insets = new Insets(0, 0, 0, 5);
		gbc_boxHolsteredSkill.gridx = 1;
		gbc_boxHolsteredSkill.gridy = 3;
		frameCenter.add(boxHolsteredSkill, gbc_boxHolsteredSkill);

		// sets the JFrame to be visible
		// frmGuiweaponcategory.setVisible(true);
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

	public JComboBox getBoxWeaponVariant() {
		return boxWeaponVariant;
	}

	public void setBoxWeaponVariant(JComboBox boxWeaponVariant) {
		this.boxWeaponVariant = boxWeaponVariant;
	}

	public JComboBox getBoxWeaponType() {
		return boxWeaponType;
	}

	public void setBoxWeaponType(JComboBox boxWeaponType) {
		this.boxWeaponType = boxWeaponType;
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

	// end getter setter methods

	// Adds Actionlisteners to the buttons

	/*
	 * public void addConfirmBtnListener(ActionListener e) {
	 * confirmBtn.addActionListener(e); }
	 * 
	 * public void addCancelBtnListener(ActionListener e) {
	 * cancelBtn.addActionListener(e); }
	 */

	public void addButtonListener(JButton button, ActionListener actionListener) {
		button.addActionListener(actionListener);
	}

	public void addBoxListener(JComboBox box, ActionListener actionListener) {
		box.addActionListener(actionListener);
	}

	// Allows current JFrame to be disposed

	public void disposeView() {
		frmGuiweaponcategory.dispose();
	}

	// Allows current JFrame to be visible

	public void setVisible(boolean result) {
		frmGuiweaponcategory.setVisible(result);
	}
}
