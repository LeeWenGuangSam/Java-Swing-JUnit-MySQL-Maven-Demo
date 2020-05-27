package pc.predi;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CardView {
	private JButton weaponBtn, armorBtn, armorModBtn, skillModBtn;
	private JPanel configuredPanel;
	public CardView() {
		configuredPanel = new JPanel();
		configuredPanel.setLayout(new FlowLayout());

		weaponBtn = new JButton("Weapon");
		armorBtn = new JButton("Armor");
		armorModBtn = new JButton("Armor Mod");
		skillModBtn = new JButton("Skill Mod");
		

		configuredPanel.add(weaponBtn);
		configuredPanel.add(armorBtn);
		configuredPanel.add(armorModBtn);
		configuredPanel.add(skillModBtn);
	}

	public JButton getWeaponBtn() {
		return weaponBtn;
	}

	public JPanel getConfiguredPanel() {
		return configuredPanel;
	}

	public void setConfiguredPanel(JPanel configuredPanel) {
		this.configuredPanel = configuredPanel;
	}

	public void setWeaponBtn(JButton weaponBtn) {
		this.weaponBtn = weaponBtn;
	}

	public JButton getArmorBtn() {
		return armorBtn;
	}

	public void setArmorBtn(JButton armorBtn) {
		this.armorBtn = armorBtn;
	}
	
	public JButton getArmorModBtn() {
		return armorModBtn;
	}

	public void setArmorModBtn(JButton armorModBtn) {
		this.armorModBtn = armorModBtn;
	}

	public JButton getSkillModBtn() {
		return skillModBtn;
	}

	public void setSkillModBtn(JButton skillmodBtn) {
		this.skillModBtn = skillmodBtn;
	}
	
	
}
