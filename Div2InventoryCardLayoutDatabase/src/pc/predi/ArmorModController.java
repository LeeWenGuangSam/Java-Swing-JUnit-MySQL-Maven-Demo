package pc.predi;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ArmorModController implements ItemListener {
	private MainView view;
	private JComboBox armorModType;
	private ArmorModModel armorModModel;
	public ArmorModController(MainView view) {
		this.view = view;
		armorModType = view.getPanelCenterCardArmorMod().getBoxArmorModType();
		armorModModel = new ArmorModModel();
	}

	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		if(itemEvent.getStateChange() == ItemEvent.SELECTED) {
			System.out.println(itemEvent.getItem());
		}
		switch(itemEvent.getItem().toString()) {
		case "Offensive": 
			//view.getPanelCenterCardArmorMod().getBoxArmorModName().setModel(armorModModel.populateSkills(arrayToPopulate, file));
			view.getPanelCenterCardArmorMod().getBoxArmorModName().setModel(new DefaultComboBoxModel(armorModModel
					.populateArrayFromFile(new File("ArmorMods/ArmorModTypes/ArmorModNamesOffensive.txt"))));
			break;
		
		case "Defensive":
			view.getPanelCenterCardArmorMod().getBoxArmorModName().setModel(new DefaultComboBoxModel(armorModModel
					.populateArrayFromFile(new File("ArmorMods/ArmorModTypes/ArmorModNamesDefensive.txt"))));
			break;
		
		case "Utility":
			view.getPanelCenterCardArmorMod().getBoxArmorModName().setModel(new DefaultComboBoxModel(armorModModel
					.populateArrayFromFile(new File("ArmorMods/ArmorModTypes/ArmorModNamesUtility.txt"))));
			break;
			
		
		}
	}

}
