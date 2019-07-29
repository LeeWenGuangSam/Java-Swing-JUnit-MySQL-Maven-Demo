//import for the GUI
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.*;
import java.awt.event.*;
//for container
import java.awt.*;
//Main GUI for the system
public class GUIMain implements ActionListener {
	//instance variables
	private JFrame GuiMain;
	private JLabel equipCat;
	String[] equipCats = {"Weapon", "Armor", "Mod"};
	JComboBox equipCatList = new JComboBox(equipCats);
	
	private JButton confirmBtn, cancelBtn;
	
	public GUIMain()
	{
		GuiMain = new JFrame();
		//close program
		GuiMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create objects for use in GUI
		confirmBtn = new JButton("Confirm");
		cancelBtn = new JButton("Cancel");
		Container cc = GuiMain.getContentPane();
		Container cl = GuiMain.getContentPane();
		
		//set container Layout
		cc.setLayout(new FlowLayout());
		//add created objects to container
		cc.add(equipCatList);
		cc.add(confirmBtn);
		cc.add(cancelBtn);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	
	public static void main(String[] args) {
		GUIMain demo = new GUIMain();
		
		demo.GuiMain.setTitle("GUIMain");
		demo.GuiMain.setSize(300,300);
		demo.GuiMain.setVisible(true);
	}
	
}
