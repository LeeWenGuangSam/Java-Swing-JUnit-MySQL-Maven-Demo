/*
 * Handles the interactions between the ArmorView and the ArmorController
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArmorController implements Runnable, ActionListener {
	
	//instance variables
	private ArmorView armorView;
	private ArmorModel armorModel;
	
	private File file = new File("InsertIntoExcelArmorSheet.csv");
	
	//Constructor
	public ArmorController(ArmorView armorView, ArmorModel armorModel)
	{
		this.armorView = armorView;
		this.armorModel = armorModel;
		
		this.armorView.addConfirmBtnListener(this);
		this.armorView.addCancelBtnListener(this);
	}
	
	
	//Creating actionPerformed logic for the buttons in ArmorView
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Invokes armor.toString() on click and writes output to .csv file.
		 * Creates a new file with proper fields if does not exist.
		 * Closes and disposes View/Window on confirmBtn click
		 */
		// TODO Auto-generated method stub
		if(e.getSource() == armorView.getConfirmBtn())
		{
			Armor armor = new Armor(armorView.getArmorVariantField().getText(),
					armorView.getArmorValueField().getText(), armorView.getArmorSlotBox().getSelectedItem().toString(),
					armorView.getArmorBrandBox().getSelectedItem().toString(),
					armorView.getArmorAttributeBoxes(0).getSelectedItem().toString(),
					armorView.getArmorAttributeFields(0).getText(),
					armorView.getArmorAttributeBoxes(1).getSelectedItem().toString(),
					armorView.getArmorAttributeFields(1).getSelectedText(),
					armorView.getArmorAttributeBoxes(2).getSelectedItem().toString(),
					armorView.getArmorAttributeFields(2).getText(),
					armorView.getArmorAttributeBoxes(3).getSelectedItem().toString(),
					armorView.getArmorAttributeFields(3).getText(),
					armorView.getArmorTalentBox1().getSelectedItem().toString(),
					armorView.getArmorTalentBox2().getSelectedItem().toString());
			
			FileWriter output;
			if(file.exists() && file.canRead() && file.canWrite()) {
				try {
					output = new FileWriter(file, true);
					output.write(armor.toString() + "\n");
					output.close();
					System.out.println("File updated");
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			else {
				try {
					PrintWriter outputNew = new PrintWriter(file);
					outputNew.println("Armor Variant,Armor Value,Armor Slot Type,Armor Brand,Armor Attribute Roll 1,Armor Attribute Roll Value 1,Armor Attribute Roll 2,Armor Attribute Roll Value 2,Armor Attribute Roll 3,Armor Attribute Roll Value 3,Armor Attribute Roll 4,Armor Attribute Roll Value 4,Armor Talent Roll 1,Armor Talent Roll 2");
					outputNew.println(armor.toString());
					outputNew.close();
					System.out.println("File created");
				}
				catch(Exception e1){
					e1.printStackTrace();					
				}
			}
			//For testing purposes only.
			System.out.println("Armor printed to file\n" + armor.toString());
			//disposes view
			armorView.disposeView();
		}
		else if(e.getSource() == armorView.getCancelBtn())
		{
			armorView.disposeView();
		}
	}
	
	//SwingUtilities.invokeLater(Runnable runnable) requires a runnable object.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
