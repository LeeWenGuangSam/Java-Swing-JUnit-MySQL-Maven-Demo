package pc.predi;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardViewController implements ActionListener {
	private MainView view;
	private CardLayout panelTop;
	public CardViewController(MainView view, CardLayout panelTop) {
		this.view = view;
		this.panelTop = panelTop;
		System.out.println("Running ChangeViewController");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.getWeaponBtn()) {
			view.getPanelCenter().setName("cardWeapon");
			//view.getFrame().setSize(500, 400);
			view.getFrame().pack();
			panelTop.show(view.getPanelCenter(), view.getPanelCenter().getName());
		}
		else if (e.getSource() == view.getArmorBtn()) {
			view.getPanelCenter().setName("cardArmor");
			view.getFrame().pack();
			panelTop.show(view.getPanelCenter(), view.getPanelCenter().getName());
		}
		else if(e.getSource() == view.getArmorModBtn()) {
			view.getPanelCenter().setName("cardArmorMod");
			view.getFrame().pack();
			panelTop.show(view.getPanelCenter(), view.getPanelCenter().getName());
		}
		else if (e.getSource() == view.getSkillModBtn()) {
			view.getPanelCenter().setName("cardSkillMod");
			//view.getFrame().setSize(550,450);
			view.getFrame().pack();
			panelTop.show(view.getPanelCenter(), view.getPanelCenter().getName());
		}
	}
}