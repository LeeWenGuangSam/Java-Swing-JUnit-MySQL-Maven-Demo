/*
 * GUIController coordinates interactions between View and Model
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class GUIController implements ActionListener, Runnable {
	
	//instance variables
	private GUIView view;
	private GUIModel model;
	
	//Constructor
	public GUIController(GUIView view, GUIModel model) {
		this.view = view;
		this.model = model;

		this.view.addConfirmBtnListener(this);
		this.view.addCancelBtnListener(this);
		this.view.addUploadBtnListener(this);
	}
	
	//Creating actionPerformed for the buttons in GUIView
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Invokes a specific GUI or MVC on button click
		 * Invoked GUI or MVC is dependent JComboBox equipList selectedItem
		 * Upload button is currently non functional and only for testing purposes only
		 */
		if (e.getSource() == view.getConfirmBtn()) {
			if (view.getEquipList().getSelectedItem().equals("Weapon")) {
				// weaponGUI = new GUIWeaponCategory();
				// SwingUtilities.invokeLater(weaponGUI);
				
				WeaponModel weaponModel = new WeaponModel();
				WeaponView weaponView = new WeaponView(weaponModel);
				WeaponController weaponController = new WeaponController(weaponView, weaponModel);
				weaponView.setVisible(true);
				SwingUtilities.invokeLater(weaponController);
			}
			
			else if(view.getEquipList().getSelectedItem().equals("Armor")) {
				ArmorModel armorModel = new ArmorModel();
				ArmorView armorView = new ArmorView(armorModel);
				ArmorController armorController = new ArmorController(armorView, armorModel);
				armorView.setVisible(true);
				SwingUtilities.invokeLater(armorController);
			}
		}

		else if (e.getSource() == view.getCancelBtn()) {
			view.disposeView();
		}

		if (e.getSource() == view.getUploadBtn()) {
			// uploads data to excel sheet
			/*
			 * if (weaponGUI != null) { weapons = weaponGUI.getWeapons();
			 * System.out.println(weaponGUI.toString());
			 */
			System.out.println("test");
		}
	}
	
	//SwingUtilities.invokeLater requires a Runnable object
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
