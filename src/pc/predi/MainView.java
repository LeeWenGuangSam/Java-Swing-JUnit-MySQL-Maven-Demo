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
	private JPanel cards;
	private JPanel cardWeapon, cardArmor, cardArmorMod, cardSkillMod;
	private JButton weaponBtn, armorBtn, modBtn, confirmBtn, cancelBtn;
	private MainModel model;
	
	
	public MainView() {
		frmEquipmentType = new JFrame();
		frmEquipmentType.setTitle("Inventory System");
		frmEquipmentType.setBounds(100, 100, 450, 400);
		frmEquipmentType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEquipmentType.getContentPane().setLayout(new BorderLayout(0, 0));
		
		cardView = new CardView();
		panelTop = new JPanel();
		panelTop = cardView.getConfiguredPanel();
		frmEquipmentType.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		cardWeapon = new WeaponView();
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
		configuredPanel.setName("cardWeapon");
		configuredPanel.add(cardWeapon, cardWeapon.getName());
		configuredPanel.add(cardArmor, cardArmor.getName());
		configuredPanel.add(cardArmorMod, cardArmorMod.getName());
		configuredPanel.add(cardSkillMod, cardSkillMod.getName());		
		return configuredPanel;
	}
	
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
		//downcasting
		return (WeaponView) getPanelCenter().getComponent(0);
	}
	
	public ArmorView getPanelCenterCardArmor() {		
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
}
