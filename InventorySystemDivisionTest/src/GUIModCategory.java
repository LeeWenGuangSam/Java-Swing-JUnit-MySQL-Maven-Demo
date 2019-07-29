import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;

public class GUIModCategory {
	//instance variables, more to come when needed
	private JFrame frmGuimodcategory;
	private JPanel frameTop, frameCenter, frameBottom;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton systemRadioBtn;
	private JRadioButton protocolRadioBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModCategory window = new GUIModCategory();
					window.frmGuimodcategory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//Constructor to be used instead of the main to be used in the main GUI
	public GUIModCategory() {
		//initialize();
		
		frmGuimodcategory = new JFrame();
		frmGuimodcategory.setTitle("GUIModCategory");
		frmGuimodcategory.setBounds(100, 100, 450, 300);
		frmGuimodcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//adds RadioButtons to buttonGroup, ensuring only one can be selected
		JRadioButton armorModBtn = new JRadioButton("Armor");
		buttonGroup.add(armorModBtn);
		JRadioButton skillModBtn = new JRadioButton("Skill");
		buttonGroup.add(skillModBtn);

		//sets the topFrame to be the FlowLayout 
		frameTop = new JPanel();
		frameTop.setLayout(new FlowLayout());

		frmGuimodcategory.getContentPane().add(frameTop, BorderLayout.NORTH);
		frameTop.add(armorModBtn);
		frameTop.add(skillModBtn);
		
		frameCenter = new JPanel();
		frmGuimodcategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
		GridBagLayout gbl_frameCenter = new GridBagLayout();
		gbl_frameCenter.columnWidths = new int[] {50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 50, 50};
		gbl_frameCenter.rowHeights = new int[] {23, 50, 50};
		gbl_frameCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_frameCenter.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frameCenter.setLayout(gbl_frameCenter);
		
		systemRadioBtn = new JRadioButton("System");
		GridBagConstraints gbc_systemRadioBtn = new GridBagConstraints();
		gbc_systemRadioBtn.insets = new Insets(0, 0, 0, 5);
		gbc_systemRadioBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_systemRadioBtn.gridx = 4;
		gbc_systemRadioBtn.gridy = 0;
		frameCenter.add(systemRadioBtn, gbc_systemRadioBtn);
		
		protocolRadioBtn = new JRadioButton("Protocol");
		GridBagConstraints gbc_protocolRadioBtn = new GridBagConstraints();
		gbc_protocolRadioBtn.insets = new Insets(0, 0, 0, 5);
		gbc_protocolRadioBtn.gridx = 5;
		gbc_protocolRadioBtn.gridy = 0;
		frameCenter.add(protocolRadioBtn, gbc_protocolRadioBtn);
		
		//sets the bottom Frame to be a FlowLayout
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());	
		
		frmGuimodcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton cancelButton = new JButton("Cancel");
		//sets the cancel button to exit when clicked
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frameBottom.add(confirmButton);
		frameBottom.add(cancelButton);
		
		//sets the JFrame to be visible
		frmGuimodcategory.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		frmGuimodcategory = new JFrame();
		frmGuimodcategory.setTitle("GUIModCategory");
		frmGuimodcategory.setBounds(100, 100, 450, 300);
		frmGuimodcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton armorModBtn = new JRadioButton("Armor");
		JRadioButton skillModBtn = new JRadioButton("Skill");

		frameTop = new JPanel();
		frameTop.setLayout(new FlowLayout());
		
		frmGuimodcategory.getContentPane().add(frameTop, BorderLayout.NORTH);
		frameTop.add(armorModBtn);
		frameTop.add(skillModBtn);
		
		frameBottom = new JPanel();
		frameBottom.setLayout(new FlowLayout());	
		
		frmGuimodcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);
		JButton confirmButton = new JButton("Confirm");
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frameBottom.add(confirmButton);
		frameBottom.add(cancelButton);
		*/
	}

}
