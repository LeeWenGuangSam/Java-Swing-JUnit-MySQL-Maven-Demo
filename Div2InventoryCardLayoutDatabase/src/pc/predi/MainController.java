package pc.predi;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.View;

import pc.predi.Div2InventoryCardLayoutDatabase.Tables.Armor;
import pc.predi.Div2InventoryCardLayoutDatabase.Tables.WeaponTable.Weapon;

public class MainController implements ActionListener, ItemListener{
	private MainView view;
	private MainModel model;
	private CardLayout panelTop;
	private CardViewController cardViewController;
	private ArmorModController armorModController;
	private String currentCard;
	private File file;
	public MainController(MainView view, MainModel model) {
		this.view = view;
		this.model = model;
		
		panelTop = (CardLayout) (view.getPanelCenter().getLayout());
		cardViewController = new CardViewController(view, panelTop);
		armorModController = new ArmorModController(view);
		view.getWeaponBtn().addActionListener(cardViewController);
		view.getArmorBtn().addActionListener(cardViewController);		
		view.getArmorModBtn().addActionListener(cardViewController);
		view.getSkillModBtn().addActionListener(cardViewController);
		view.getConfirmBtn().addActionListener(this);
		view.getCancelBtn().addActionListener(this);
		
		//view.getPanelCenterCardWeapon().getBoxActiveSkill().addActionListener(this);
		//view.getPanelCenterCardWeapon().getBoxWeaponTypes();
		//view.getPanelCenterCardWeapon().getBoxWeaponTypes().addItemListener(this);
		//view.getPanelCenterCardArmor().getBoxArmorBrand();
		//view.getPanelCenterCardArmor().getBoxArmorBrand().addItemListener(this);
		//view.getPanelCenterCardWeapon().getBoxWeaponTypes().addActionListener(this);
		view.getPanelCenterCardWeapon().getBoxWeaponTypes().addItemListener(this);
		view.getPanelCenterCardArmor().getBoxArmorType().addItemListener(this);
		view.getPanelCenterCardArmor().getBoxArmorVariant().addItemListener(this);
		view.getPanelCenterCardArmorMod().getBoxArmorModType().addItemListener(armorModController);
		//view.getPanelCenterCardArmorMod().
		//view.getPanelCenterCardSkillMod();
		
		//Refer to the experimental code in ArmorView regarding nested JPanels to find out more
		//view.getPanelCenterCardArmor().getRadioOffenseSystemMod().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
//		CardLayout cl = (CardLayout) (view.getPanelCenter().getLayout());
//		
//		if(e.getSource() == view.getWeaponBtn()) {
//			view.getPanelCenter().setName("cardWeapon");
//			cl.show(view.getPanelCenter(), view.getPanelCenter().getName());
//		}
//		else if (e.getSource() == view.getArmorBtn()) {
//			view.getPanelCenter().setName("cardArmor");
//			cl.show(view.getPanelCenter(), view.getPanelCenter().getName());
//		}
//		else if (e.getSource() == view.getModBtn()) {
//			System.out.println("test");
//		}
//		else 
		if (actionEvent.getSource() == view.getConfirmBtn()) {
			currentCard = view.getPanelCenter().getName();
			Component component = null;
			Component[] components = getCurrentCard().getComponents();
			
			//Refer to the experimental code in ArmorView regarding nested JPanels to find out more
			/*
			 * //pull the nested JPanel component from ArmorView and grab the JPanel
			 * components //2. grab the JPanel components and put them together with the
			 * currentCard components (in order) //CONFTRMED TO BE WORKING, UPDATE FILE
			 * //please add the ONLY selected RadioButton to Component[] JPanel panel = new
			 * JPanel(); ArrayList<Component> combinedComponents = new
			 * ArrayList<Component>(); for(Component c : getCurrentCard().getComponents()) {
			 * combinedComponents.add(c); if(c instanceof JPanel) { panel = (JPanel) c;
			 * for(Component panelComponent : panel.getComponents()) {
			 * combinedComponents.add(panelComponent); } } } Component[] newComponents = new
			 * Component[combinedComponents.size()]; for(int i = 0; i <
			 * combinedComponents.size(); i++) { newComponents[i] =
			 * combinedComponents.get(i); System.out.println(newComponents[i]); } //
			 * //testing to get the components in jpanel in ArmorView out // JPanel jpanel =
			 * new JPanel(); // for(Component c : components) { // if(c instanceof JPanel) {
			 * // jpanel = (JPanel) c; // for(Component c1 : jpanel.getComponents()) { //
			 * System.out.println(c1); // } // } // else { // System.out.println(c); // } //
			 * // }
			 */			
			String passToFile = "";
			if(currentCard.equals(view.getPanelCenterCardWeapon().getName())) {
				//for(Component component : getCurrentCard().getComponents() )
				file = new File("WeaponSheet.csv");
				System.out.println(getStringComponents(components));
				insertWeapon(getStringComponents(components));
				passToFile = getStringComponents(components) + getLocalDateTime();
				System.out.println(passToFile);
				if (file.exists() && file.canRead() && file.canWrite()) {
					writeToFile(file, passToFile);
				}
				else {
					String firstDefaultLine = "Weapon Type,Weapon Variant,Weapon Damage,Active Skill,Handling Skill 1,Handling / Holstered Skill,Date created";
					createSheetFile(file, passToFile, firstDefaultLine);
				}
				//set the previous logged label/last label to show the String passToFile
				//for user confirmation and debugging
				if(components[components.length - 1] instanceof JLabel) {
					((JLabel) components[components.length - 1]).setText(passToFile);
				}
				view.getFrame().pack();
				//if(components)
//				try {
//					//use printwriter instead???
//					FileWriter output = new FileWriter(file, true);
//					output.write(passToFile + "\n");
//					output.close();
//				}
//				catch(Exception e1) {
//					e1.printStackTrace();
//				}
//				for(int i = 0; i < components.length; i++)
//				{
//					//System.out.println(component);
//					//test the class of the component, it does print out the class of the component
//					component = components[i];
//					//System.out.println(component.getClass());
//					if(component instanceof JComboBox) {
//						//JComboBox is a type, therefore it needs (JComboBox). 2. Downcasting component to JComboBox to use JComboBox.getSelectedItem(), 
//						//therefore needs ((JComboBox) component)
//						
//						try {
//							PrintWriter outputNew = new PrintWriter(file);
//							if(i != (components.length - 1)) {
//								outputNew.print(((JComboBox) component).getSelectedItem() + ", ");
//								System.out.print(((JComboBox) component).getSelectedItem() + ", ");
//							}
//							else {
//								outputNew.print(((JComboBox) component).getSelectedItem());
//								System.out.print(((JComboBox) component).getSelectedItem());
//							}
//							outputNew.close();
//						} catch (FileNotFoundException e1) {
//							
//							e1.printStackTrace();
//						}
//						
//						((JComboBox) component).getSelectedItem();
//						//test the if statement component instanceof JComboBox //it works and prints a toString method of JComboBox
//						//System.out.println(component);
//					}
//				}
//				for(Component component: view.getPanelCenter().getComponents())
//				{
//					
//				}
			}
			else if(currentCard.equals(view.getPanelCenterCardArmor().getName())) {
				file = new File("ArmorSheet.csv");
				insertArmor(getStringComponents(components));
				passToFile = getStringComponents(components) + getLocalDateTime();
				System.out.println(passToFile);
				//resetComboBoxes(components);
				if (file.exists() && file.canRead() && file.canWrite()) {
					writeToFile(file, passToFile);
				}
				else {
					//untested
					String firstDefaultLine = "Armor Type,Armor Variant,Armor Brand,Armor Attribute Roll 1,Armor Attribute Roll Value 1,Armor Attribute Roll 2,Armor Attribute Roll Value 2,Armor Attribute Roll 3,Armor Attribute Roll Value 3,Armor Attribute Roll 4,Armor Attribute Roll Value 4,Armor Talent Roll 1,Armor Talent Roll 2,System Mod 1, System Mod 2, Protocol Mod 1, Protocol Mod 2, Date Created";
					createSheetFile(file, passToFile, firstDefaultLine);
				}
				//set the previous logged label/last label to show the String passToFile
				//for user confirmation and debugging
				if(components[components.length - 1] instanceof JLabel) {
					((JLabel) components[components.length - 1]).setText(passToFile);
				}
				
				view.getFrame().pack();
			}
			else if(currentCard.equals(view.getPanelCenterCardSkillMod().getName())) {
				file = new File("SkillModSheet.csv");
				passToFile = getStringComponents(components) + getLocalDateTime();
				System.out.println(passToFile);
				if (file.exists() && file.canRead() && file.canWrite()) {
					writeToFile(file, passToFile);
				}
				else {
					String firstDefaultLine = "Skill Name,Skill Slot,Skill Part Name,Attribute,AttributeValue,Date Created";
					createSheetFile(file, passToFile, firstDefaultLine);
				}
				//set the previous logged label/last label to show the String passToFile
				//for user confirmation and debugging
				if(components[components.length - 1] instanceof JLabel) {
					((JLabel) components[components.length - 1]).setText(passToFile);
				}
				view.getFrame().pack();
			}
			else if(currentCard.equals(view.getPanelCenterCardArmorMod().getName())) {
				file = new File("ArmorModSheet.csv");
				passToFile = getStringComponents(components) + getLocalDateTime();
				System.out.println(passToFile);
				if (file.exists() && file.canRead() && file.canWrite()) {
					writeToFile(file, passToFile);
				}
				else {
					String firstDefaultLine = "Armor Mod Name,Armor Mod Name,Armor Attribute 1, Armor Attribute Value, Armor Attribute 2, Armor Attribute Value 2, Armor Attribute 3, Armor Attribute Value 3,Date Created";
					createSheetFile(file, passToFile, firstDefaultLine);
				}
				//set the previous logged label/last label to show the String passToFile
				//for user confirmation and debugging
				if(components[components.length - 1] instanceof JLabel) {
					((JLabel) components[components.length - 1]).setText(passToFile);
				}
				view.getFrame().pack();
			}
		}
		else if (actionEvent.getSource() == view.getCancelBtn()) {
			view.getFrame().dispose();
		}
		//Refer to the experimental code in ArmorView regarding nested JPanels to find out more
		/*
		 * else if (actionEvent.getSource() ==
		 * view.getPanelCenterCardArmor().getRadioOffenseSystemMod()) {
		 * System.out.println("test"); }
		 */
	}
	
	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		
//		String[] weaponVariantItems = {};
//		DefaultComboBoxModel comboBoxModel;
//		comboBoxModel = new DefaultComboBoxModel<>(weaponVariantItems);
//		if(itemEvent.getStateChange() == ItemEvent.SELECTED) {
//			System.out.println(itemEvent.getItem() + " " + itemEvent.getStateChange() );
//		}
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		if (itemEvent.getSource() == view.getPanelCenterCardWeapon().getBoxWeaponTypes()) {
//			switch (itemEvent.getItem().toString()) {
//
//			case "Assault Rifle":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantAssaultRifle()));
//				break;
//			case "Light Machine Gun":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantLightMachineGun()));
//				break;
//			case "Rifle":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantRifle()));
//				break;
//			case "Shotgun":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantShotgun()));
//				break;
//			case "Submachine Gun":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantSubmachineGun()));
//				break;
//			case "Pistol":
//				view.getPanelCenterCardWeapon().getBoxWeaponVariant()
//						.setModel(new DefaultComboBoxModel<>(model.getWeaponModel().getWeaponVariantPistol()));
//				break;
//			}

			Query variantQuery = em.createQuery("select distinct weaponVariant from WeaponVariants wv where wv.weaponType = :variant");
			variantQuery.setParameter("variant", itemEvent.getItem().toString());
			List<Object> listVariantObjects = variantQuery.getResultList();
			String[] weaponVariants = new String[listVariantObjects.size()];
			listVariantObjects.toArray(weaponVariants);
			
			Query activeQuery = em.createQuery("select distinct activeSkill from ActiveSkills actives where actives.weaponType = :activeSkill");
			activeQuery.setParameter("activeSkill", itemEvent.getItem().toString());
			List<Object> listActiveObjects = activeQuery.getResultList();
			String[] activeSkills = new String[listActiveObjects.size()];
			listActiveObjects.toArray(activeSkills);
			
			Query handlingQuery = em.createQuery("select distinct handlingSkill from HandlingSkills hands where hands.weaponType = :handlingSkill");
			handlingQuery.setParameter("handlingSkill", itemEvent.getItem().toString());
			List<Object> listHandlingObjects = handlingQuery.getResultList();
			String[] handlingSkills = new String[listHandlingObjects.size()];
			listHandlingObjects.toArray(handlingSkills);
			
			Query holsteredQuery = em.createQuery("select distinct holsteredSkill from HolsteredSkills holss where holss.weaponType = :holsteredSkill");
			holsteredQuery.setParameter("holsteredSkill", itemEvent.getItem().toString());
			List<Object> listHolsteredObjects = holsteredQuery.getResultList();
			String[] holsteredSkills = new String[listHolsteredObjects.size()];
			listHolsteredObjects.toArray(holsteredSkills);
			
			view.getPanelCenterCardWeapon().getBoxWeaponVariant().setModel(new DefaultComboBoxModel<>(weaponVariants));
			view.getPanelCenterCardWeapon().getBoxActiveSkill().setModel(new DefaultComboBoxModel<>(activeSkills));
			view.getPanelCenterCardWeapon().getBoxHandlingSkill().setModel(new DefaultComboBoxModel<>(handlingSkills));
			view.getPanelCenterCardWeapon().getBoxHolsteredSkill().setModel(new DefaultComboBoxModel<>(holsteredSkills));
			
			em.close();
		}
		else if(itemEvent.getSource() == view.getPanelCenterCardArmor().getBoxArmorType()) {
			switch (itemEvent.getItem().toString()) {
			
			case "Backpack":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantBackpacks()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsBackpack()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsBackpack()));
				break;
			case "Chest":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantChests()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsChest()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsChest()));
				break;
			case "Gloves":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantGloves()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsGloves()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsGloves()));
				break;
			case "Holster":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantHolsters()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsHolster()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsHolster()));
				break;
			case "Kneepads":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantKneepads()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsKneepads()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsKneepads()));
				break;
			case "Mask":
				view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantMasks()));
				view.getPanelCenterCardArmor().getBoxArmorTalent1().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsMask()));
				view.getPanelCenterCardArmor().getBoxArmorTalent2().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorTalentRollsMask()));
				break;
			}
		}
		else if (itemEvent.getSource() == view.getPanelCenterCardArmor().getBoxArmorVariant()) {
			switch (itemEvent.getItem().toString()) {
			case "Loadout Frame":
				for (JComboBox getAttributeBoxes : view.getPanelCenterCardArmor().getArmorAttributeBoxes()) {
					getAttributeBoxes.setModel(new DefaultComboBoxModel<>(model.getArmorModel().getArmorOngoingDirectiveAttributeRollsBackpack()));
				}

				break;
			case "Resource Harness":
				for (JComboBox getAttributeBoxes : view.getPanelCenterCardArmor().getArmorAttributeBoxes()) {
					getAttributeBoxes.setModel(new DefaultComboBoxModel<>(model.getArmorModel().getArmorOngoingDirectiveAttributeRollsChest()));
				}				
				break;
			}
		}
	}
	
	public JPanel getCurrentCard()
	{
	    JPanel card = null;

	    for (Component comp : view.getPanelCenter().getComponents() ) {
	        if (comp.isVisible() == true) {
	            card = (JPanel)comp;
	        }
	    }

	    return card;
	}
	
	public String getStringComponents(Component[] components) {
		String sendToFile = "";
		for(int i = 0; i < components.length; i++) {
			//component = components[i];
			//System.out.println(component);
			//test the class of the component, it does print out the class of the component
			if(components[i] instanceof JComboBox<?>) {
				//note components.length is 8
				if(i <= (components.length - 1)) {
					//JComboBox is a type, therefore it needs (JComboBox). 2. Downcasting component to JComboBox to use JComboBox.getSelectedItem(), 
					//therefore needs ((JComboBox) component)
					sendToFile = sendToFile + ((JComboBox<?>) components[i]).getSelectedItem().toString() + ",";
				}
			}
			//needs to set text to JTextFields for empty fields
			else if(components[i] instanceof JTextField) {
				if(i <= (components.length - 1)) {
					JTextField textField = ((JTextField) components[i]);
					if (textField.getText().equals("")) {
						sendToFile = sendToFile + "N.A." + ",";
					} else {
						sendToFile = sendToFile + textField.getText() + ",";
					}
				}
//				else {
//					sendToFile = sendToFile + ((JComboBox<?>) components[i]).getSelectedItem().toString();
//				}
				//System.out.println("insert JTextField here");
			}
		}
		return sendToFile;
	}
	
	//insertWeapon into MySql table
	public void insertWeapon(String componentsString) {
		String[] insertToWpnTable = componentsString.split(",");
		for(String s : insertToWpnTable) {
			System.out.println(s);
		}
		EntityManager em = Persistence.createEntityManagerFactory("InsertWeapon").createEntityManager();
		em.getTransaction().begin();
		Weapon weapon = new Weapon(insertToWpnTable[0], insertToWpnTable[1], insertToWpnTable[2], insertToWpnTable[3], insertToWpnTable[4], insertToWpnTable[5]);
		System.out.println(weapon.toString());
		System.out.println("Starting EntityTransaction");
		System.out.println("Inserting into Weapon Table");
		em.persist(weapon);
		em.getTransaction().commit();
		System.out.println("Closing entity transaction");
		em.close();
		
	}
	
	//TODO insertArmor into MySQL table
	public void insertArmor(String componentsString) {
		String[] insert = componentsString.split(",");
		for(String s : insert) {
			System.out.println(s);
		}
		System.out.println(componentsString);
		Armor armor = new Armor(insert[0], insert[1], insert[2], insert[3], insert[4], insert[5], insert[6], insert[7],
				insert[8], insert[9], insert[10], insert[11], insert[12], insert[13], insert[14], insert[15],
				insert[16], insert[17]);
		//TODO insert data into MySQL table
	}
	
	/**
	 * Writes a String firstDefaultLine and the next line writeToFile to a file File
	 * @param file
	 * @param writeToFile
	 * @param firstDefaultLine
	 */
	public void createSheetFile(File file, String writeToFile, String firstDefaultLine) {
		try {
			FileWriter output = new FileWriter(file);
			output.write(firstDefaultLine + "\n");
			output.write(writeToFile + "\n");
			output.close();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Writes a string passToFile to a .txt File file
	 * @param file
	 * @param passToFile
	 */
	public void writeToFile(File file, String passToFile) {
		try {
			//use printwriter instead???
			FileWriter output = new FileWriter(file, true);
			output.write(passToFile + "\n");
			output.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * Formats LocalDateTime to make it more readable
	 * Instead of the default LocalDateTime such as 2007-12-03T10:15:30
	 * LocalDateTime is formatted to dd/mm/yyyy hour:minute
	 * @return
	 */
	public String getLocalDateTime() {
		String localDateTime = "";
		LocalDateTime todayDateTime = LocalDateTime.now();
		//System.out.println(todayDateTime);
		String numberOfMinutes = Integer.toString(todayDateTime.getMinute());
		if(Integer.toString(todayDateTime.getMinute()).length() == 1) {
			numberOfMinutes = "0" + Integer.toString(todayDateTime.getMinute());
		}
		localDateTime = Integer.toString(todayDateTime.getDayOfMonth()) + "/" + Integer.toString(todayDateTime.getMonthValue()) + "/" + Integer.toString(todayDateTime.getYear())
		+ " " + Integer.toString(todayDateTime.getHour()) + ":" + numberOfMinutes;
		return localDateTime;
	}
	
	//for testing purposes only
	//returns all available components in panelCenter/CardLayout
	public Component getCurrentComponent() {
		Component component = null;
		for(Component comp: view.getPanelCenter().getComponents()) {
			if(comp.isVisible() == true) {
				component = comp;
			}
		}
		
		return component;
	}
	
	public void resetComboBoxes(Component[] components) {
		for(Component c : components) {
			if(c instanceof JComboBox) {
				((JComboBox<?>) c).setSelectedItem("None");
			}
		}
	}
	
	public void armorSettings() {
		//create a statement to manage armorTypes settings, eg. armorVariantBackpacks, armorTalentRollsBackpacks etc...
		String[] armorVariantType = model.getArmorModel().getArmorVariantBackpacks();
		view.getPanelCenterCardArmor().getBoxArmorVariant().setModel(new DefaultComboBoxModel(model.getArmorModel().getArmorVariantBackpacks()));

	}
}
