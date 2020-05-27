package pc.predi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	private JFrame frmEquipmentType;
	private CardView cardView;
	private JPanel panelTop;
	private JPanel panelCenter;
	private JPanel panelBottom;
	//private PanelTop panelTop;
	private JPanel cards;
	private JPanel cardWeapon, cardArmor, cardArmorMod, cardSkillMod;
	//private WeaponView cardWeapon;
	//private ArmorView cardArmor;
	//private ModView cardMod;
	private JButton weaponBtn, armorBtn, modBtn, confirmBtn, cancelBtn;
	private MainModel model;
	
	
	public MainView() {
		//this.model = model;
		frmEquipmentType = new JFrame();
		frmEquipmentType.setTitle("Inventory System");
		frmEquipmentType.setBounds(100, 100, 450, 400);
		//frmEquipmentType.setMinimumSize(new Dimension(800, 400));
		frmEquipmentType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEquipmentType.getContentPane().setLayout(new BorderLayout(0, 0));
		
		cardView = new CardView();
		panelTop = new JPanel();
		panelTop = cardView.getConfiguredPanel();
		//panelTop = changeView.getConfiguredPanel();
		//weaponBtn = changeView.getWeaponBtn();
		//armorBtn = changeView.getArmorBtn();
		//modBtn = changeView.getModBtn();
		frmEquipmentType.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		//cardWeapon = new WeaponView().getFrameCenter();
		cardWeapon = new WeaponView();
		//cardArmor = new ArmorView().getFrameCenter();
		cardArmor = new ArmorView();
		cardArmorMod = new ArmorModView();
		cardSkillMod = new SkillModView();
		panelCenter = configurePanelCenter();
		frmEquipmentType.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		confirmBtn = new JButton("Confirm");
		cancelBtn = new JButton("Cancel");
		panelBottom = configurePanelBottom();
		frmEquipmentType.getContentPane().add(panelBottom, BorderLayout.SOUTH);
		
		frmEquipmentType.pack();
	}
	
	//do I need configurePanelTop? or do I need the panel to be in a seperate class?
	/**
	 * 
	 * @return
	 */
	public JPanel configurePanelTop() {
		JPanel configuredPanel = new JPanel();
		panelTop = cardView.getConfiguredPanel();
		return configuredPanel;
	}
	/**
	 * CardLayout panel that holds the 3 different panels for each of the equipment types
	 * @return
	 */
	public JPanel configurePanelCenter() {
		JPanel configuredPanel = new JPanel();
		configuredPanel.setLayout(new CardLayout());
		//set default name for panel
		configuredPanel.setName("cardWeapon");
		//WeaponView weaponView = new WeaponView();
		//cardWeapon = new WeaponView().getFrameCenter();
		//cardArmor = new ArmorView().getFrameCenter();
		//cardMod = new ModView();
		//add additional views to the card down here
		//configuredPanel.add();
		//weaponBtn.getText() is null???
		configuredPanel.add(cardWeapon, cardWeapon.getName());
		configuredPanel.add(cardArmor, cardArmor.getName());
		configuredPanel.add(cardArmorMod, cardArmorMod.getName());
		configuredPanel.add(cardSkillMod, cardSkillMod.getName());
		
		//configuredPanel.add(cardWeapon.getFrameCenter(), cardWeapon.getName());
		//configuredPanel.add(cardArmor.getFrameCenter(), cardArmor.getName());
		
		return configuredPanel;
	}
	
	//do I get a Bottom Panel method? Or do I create the JPanel in the MainView above?
	/**
	 * Panel that holds the confirm and cancel button
	 * @return
	 */
	public JPanel configurePanelBottom() {
		JPanel configuredPanel = new JPanel();
		configuredPanel.setLayout(new FlowLayout());
		configuredPanel.add(confirmBtn);
		configuredPanel.add(cancelBtn);
		return configuredPanel;
	}
	
	public void addConfirmBtnListener(ActionListener listenerObject) {
		confirmBtn.addActionListener(listenerObject);
	}
	
	public void addCancelBtnListener(ActionListener listenerObject) {
		cancelBtn.addActionListener(listenerObject);
	}
	
//	public void disposeView() {
//		frmEquipmentType.dispose();
//	}
//	
//	public void setVisible(boolean result) {
//		frmEquipmentType.setVisible(result);
//	}

	public JButton getWeaponBtn() {
		return cardView.getWeaponBtn();
	}

	public void setWeaponBtn(JButton weaponBtn) {
		this.cardView.setWeaponBtn(weaponBtn);
	}

	public JButton getArmorBtn() {
		return cardView.getArmorBtn();
	}

	public void setArmorBtn(JButton armorBtn) {
		this.cardView.setArmorBtn(armorBtn);
	}
	
	public JButton getArmorModBtn() {
		return cardView.getArmorModBtn();
	}
	
	public void setArmorModBtn(JButton armorModBtn) {
		this.cardView.setArmorModBtn(armorModBtn);
	}

	public JButton getSkillModBtn() {
		return cardView.getSkillModBtn();
	}

	public void setSkillModBtn(JButton skillmodBtn) {
		this.cardView.setSkillModBtn(modBtn);
	}

	public CardView getChangeView() {
		return cardView;
	}

	public void setChangeView(CardView changeView) {
		this.cardView = changeView;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public JFrame getFrame() {
		return frmEquipmentType;
	}

	public void setFrame(JFrame frmEquipmentType) {
		this.frmEquipmentType = frmEquipmentType;
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

	public JPanel getPanelTop() {
		return panelTop;
	}

	public void setPanelTop(JPanel panelTop) {
		this.panelTop = panelTop;
	}

	public WeaponView getPanelCenterCardWeapon() {
		//System.out.println((JPanel)getPanelCenter().getComponent(0));
//		Component[] comp = ((JPanel) getPanelCenter().getComponent(0)).getComponents();
//		for(Component c : comp) {
//			System.out.println(c);
//		}
		
		//downcasting
		return (WeaponView) getPanelCenter().getComponent(0);
	}
//
//	public void setCardWeapon(JPanel cardWeapon) {
//		this.cardWeapon = cardWeapon;
//	}
//
	public ArmorView getPanelCenterCardArmor() {
//		ArmorView armorView = (ArmorView) getPanelCenter().getComponent(1);
//		return armorView;
		
		//downcasting
		return (ArmorView) getPanelCenter().getComponent(1);
	}
	
	public ArmorModView getPanelCenterCardArmorMod() {
		//downcasting
		return (ArmorModView) getPanelCenter().getComponent(2);
	}
	
	public SkillModView getPanelCenterCardSkillMod() {
		//downcasting
		return (SkillModView) getPanelCenter().getComponent(3);
	}
//
//	public void setCardArmor(JPanel cardArmor) {
//		this.cardArmor = cardArmor;
//	}
}
