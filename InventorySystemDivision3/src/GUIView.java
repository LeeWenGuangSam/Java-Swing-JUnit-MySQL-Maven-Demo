import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Only handles UI logic of application. 
 * 
 * The customer will include all the UI components
 * interacts with.
 */

public class GUIView {
	//instance variables
	private JFrame frmInventorysystem;
	private JPanel frameTop, frameBottom;
	private JComboBox equipList;
	//private String category = "";
	private JButton confirmBtn, cancelBtn;
	private JButton uploadBtn;
	private GUIModel model;
	// private Weapon weapon;
	// private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	// private Armor armor;
	// private ArrayList<Armor> armors = new ArrayList<Armor>();
	// private GUIWeaponCategory weaponGUI = null;
	// private GUIArmorCategory armorGUI = null;

	//Constructor
	public GUIView(GUIModel model) {
		this.model = model;
		// insert formatting code here
		frmInventorysystem = new JFrame();
		frmInventorysystem.setTitle("InventorySystem");
		frmInventorysystem.setBounds(100, 100, 450, 300);
		frmInventorysystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventorysystem.getContentPane().setLayout(new BorderLayout(0, 0));

		frameTop = new JPanel();
		frameTop.setLayout(new FlowLayout());

		/*
		 * JFrame inside another JFrame is not possible. JPanels are used instead
		 * Creating a flow layout for the bottom frame
		 */
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());

		// creates comboBox to find out which of the three items player is looking to
		// insert
		// equipList.setModel(new DefaultComboBoxModel(new String[] {"Weapon", "Armor",
		// "Mod"}));
		// String[] weaponCategories = { "Weapon", "Armor", "Mod" };
		equipList = new JComboBox(model.getWeaponCategories());
		frameTop.add(equipList);
		frmInventorysystem.getContentPane().add(frameTop, BorderLayout.NORTH);

		// Converting BorderLayout.south into a flow layout
		frmInventorysystem.getContentPane().add(frameBottom, BorderLayout.SOUTH);

		confirmBtn = new JButton("Confirm");
		// confirmBtn.addActionListener(this);

		// creates new windows to sort equipment when confirmBtn is clicked
		frameBottom.add(confirmBtn);

		cancelBtn = new JButton("Cancel");
		// cancelBtn.addActionListener(this);

		frameBottom.add(cancelBtn);

		uploadBtn = new JButton("Upload");

		// uploadBtn.addActionListener(this);

		frameBottom.add(uploadBtn);

		// frmInventorysystem.setVisible(true);
	}
	
	//Getter setter methods

	public JComboBox getEquipList() {
		return equipList;
	}

	public JButton getConfirmBtn() {
		return confirmBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public JButton getUploadBtn() {
		return uploadBtn;
	}
	
	//end getter setter methods
	
	//Adds Actionlisteners to all the buttons

	public void addConfirmBtnListener(ActionListener listenerObject) {
		confirmBtn.addActionListener(listenerObject);
	}

	public void addCancelBtnListener(ActionListener listenerObject) {
		cancelBtn.addActionListener(listenerObject);
	}

	public void addUploadBtnListener(ActionListener listenerObject) {
		uploadBtn.addActionListener(listenerObject);
	}

	//Allows for current JFrame to be disposed
	public void disposeView() {
		frmInventorysystem.dispose();
	}
	
	//Allows current JFrame to be visible
	public void setVisible(boolean result) {
		frmInventorysystem.setVisible(result);
	}
}
