
/*
 * WeaponController coordinates interactions between the WeaponView and WeaponModel
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class WeaponController implements ActionListener, Runnable {

	// instance variables
	private WeaponView weaponView;

	private WeaponModel weaponModel;

	private Weapon weapon;

	private File file = new File("InsertIntoExcelWeaponSheet.csv");

	// Constructor
	public WeaponController(WeaponView weaponView, WeaponModel weaponModel) {
		this.weaponView = weaponView;

		this.weaponModel = weaponModel;
		
		//this.weaponView.addConfirmBtnListener(this);
		//this.weaponView.addCancelBtnListener(this);
		
		this.weaponView.addButtonListener(weaponView.getConfirmBtn(), this);
		this.weaponView.addButtonListener(weaponView.getCancelBtn(), this);
		
		this.weaponView.addBoxListener(weaponView.getBoxWeaponType(), this);
	}

	// Creating actionPerformed for the buttons in WeaponView

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * Invokes weapon.toString() on click and writes output to a .csv file Creates a
		 * new file with proper fields if file does not exist Closes or disposes
		 * View/Window on confirmBtn click
		 */
		if (e.getSource() == weaponView.getConfirmBtn()) { // start if
			weapon = new Weapon(weaponView.getBoxWeaponType().getSelectedItem().toString(),
					weaponView.getBoxWeaponVariant().getSelectedItem().toString(),
					weaponView.getBoxActiveSkill().getSelectedItem().toString(),
					weaponView.getBoxHandlingSkill().getSelectedItem().toString(),
					weaponView.getBoxHolsteredSkill().getSelectedItem().toString());

			FileWriter output;
			if (file.exists() && file.canRead() && file.canWrite()) { // nested if
				try { // try block
					output = new FileWriter(file, true);
					output.write(weapon.toString() + "\n");
					output.close();
					// output.write();
				} // end try
				catch (Exception e1) { // catch block
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // end catch
			} // end nested if
			else { // else block
				createFile();
			} // end else
				// For testing purposes only
			System.out.println("Weapon printed to file\n" + weapon.toString());
			weaponView.disposeView();
		} // end if
			// closes View/Window on cancelBtn click
		else if (e.getSource() == weaponView.getCancelBtn()) {
			weaponView.disposeView();
		}
		
		if(weaponView.getBoxWeaponType().getSelectedItem().toString().equals("Assault Rifle")) {
			
			weaponView.getBoxWeaponVariant().setModel(new DefaultComboBoxModel(new String[] {"test"}));
		}
	}
	
	public void createFolder()
	{
		
	}
	
	public void createFile()
	{
		try { // try block
			PrintWriter outputNew = new PrintWriter(file);
			outputNew.println("WeaponType,WeaponVariant,ActiveSkill,HandlingSkill1,HandlingSkill2,HolsteredSkill");
			outputNew.println(weapon.toString());
			outputNew.close();
			System.out.println("File created");
		} // end try block
		catch (FileNotFoundException e1) { // catch block
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
	}

	// SwingUtilities.invokeLater(Runnable runnable) requires a runnable object
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
