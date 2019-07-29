import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GUIWeaponCategory implements ActionListener, Runnable {
	//instance variables
    private JButton confirmBtn, cancelBtn;
    private JFrame frmGuiweaponcategory;
    private JPanel frameBottom, frameCenter;
    private String weaponType, weaponVariant, activeSkill, handlingSkill, holsteredSkill;
    private String[] weaponTypes, weaponVariants, activeSkills, handlingSkills, holsteredSkills;
    private JComboBox boxWeaponType, boxActiveSkill, boxHandlingSkill1, boxHolsteredSkill;
    private JTextPane paneWeaponVariant;
    // creates weapon object
    // thoughts on creating a Weapon data structure?
    private Weapon weapon;
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private JLabel lblHandlingequippedSkill2;
    private JComboBox boxHandlingSkill2;

    //Constructor
    public GUIWeaponCategory() {
        // insert code for GUI here
        frmGuiweaponcategory = new JFrame();
        frmGuiweaponcategory.setTitle("GUIWeaponCategory");
        frmGuiweaponcategory.setBounds(100, 100, 450, 300);
        frmGuiweaponcategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // new JPanel because JFrames can't be put in a JFrame
        // creates and adds frameBottom to BorderLayout.SOUTH
        frameBottom = new JPanel();
        frameBottom.setLayout(new FlowLayout());

        // comboBox for easy access to weapon category types
        boxWeaponType = new JComboBox();
        weaponTypes = new String[] { "Assault Rifle", "Light Machine Gun", "Marksman Rifle", "Pistol", "Rifle",
                "Shotgun", "Submachine Gun" };
        Arrays.sort(weaponTypes);
        boxWeaponType.setModel(new DefaultComboBoxModel(weaponTypes));
        frmGuiweaponcategory.getContentPane().add(boxWeaponType, BorderLayout.NORTH);

        frmGuiweaponcategory.getContentPane().add(frameBottom, BorderLayout.SOUTH);

        //adds confirmBtn to frameBottom
        confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(this);
        frameBottom.add(confirmBtn);

        // add cancelBtn to frameBottom
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);
        //inner class handler
		/*
		 * cancelBtn.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { frmGuiweaponcategory.dispose(); } });
		 */
        frameBottom.add(cancelBtn);
        
        
        frameCenter = new JPanel();
        frmGuiweaponcategory.getContentPane().add(frameCenter, BorderLayout.CENTER);
        GridBagLayout gbl_frameCenter = new GridBagLayout();
        gbl_frameCenter.columnWidths = new int[] { 50, 50, 50 };
        gbl_frameCenter.rowHeights = new int[] {50, 50, 50, 50, 50};
        gbl_frameCenter.columnWeights = new double[] { 0.0, 1.0 };
        gbl_frameCenter.rowWeights = new double[] { 1.0, Double.MIN_VALUE, 0.0, 0.0 };
        frameCenter.setLayout(gbl_frameCenter);

        JLabel weaponVariant = new JLabel("Weapon Variant");
        GridBagConstraints gbc_weaponVariant = new GridBagConstraints();
        gbc_weaponVariant.insets = new Insets(0, 0, 5, 5);
        gbc_weaponVariant.gridx = 0;
        gbc_weaponVariant.gridy = 0;
        frameCenter.add(weaponVariant, gbc_weaponVariant);

        paneWeaponVariant = new JTextPane();
        GridBagConstraints gbc_paneWeaponVariant = new GridBagConstraints();
        gbc_paneWeaponVariant.fill = GridBagConstraints.HORIZONTAL;
        gbc_paneWeaponVariant.insets = new Insets(0, 0, 5, 5);
        gbc_paneWeaponVariant.gridx = 1;
        gbc_paneWeaponVariant.gridy = 0;
        frameCenter.add(paneWeaponVariant, gbc_paneWeaponVariant);

        // Add label to mark combo box
        JLabel activeLabel = new JLabel("Active Skill");
        GridBagConstraints gbc_activeLabel = new GridBagConstraints();
        gbc_activeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_activeLabel.gridx = 0;
        gbc_activeLabel.gridy = 1;
        frameCenter.add(activeLabel, gbc_activeLabel);

        boxActiveSkill = new JComboBox();
        activeSkills = new String[] { "Boomerang", "BreadBasket", "Close & Personal", "Eyeless", "Fast Hands",
                "Finisher", "First Blood", "Frenzy", "Ignited", "Killer", "Lucky Shot", "Measured", "Naked",
                "Near Sighted", "On Empty", "Optimist", "Outsider", "Perpetuation", "Premeditated", "Preservation",
                "Pummel", "Ranger", "Reformation", "Rifleman", "Sadist", "Salvage", "Spike", "Steady Handed",
                "Strained", "Unhinged", "Unwavering", "Vindictive" };
        Arrays.sort(activeSkills);
        boxActiveSkill.setModel(new DefaultComboBoxModel(activeSkills));
        GridBagConstraints gbc_boxActiveSkill = new GridBagConstraints();
        gbc_boxActiveSkill.insets = new Insets(0, 0, 5, 5);
        gbc_boxActiveSkill.gridx = 1;
        gbc_boxActiveSkill.gridy = 1;
        frameCenter.add(boxActiveSkill, gbc_boxActiveSkill);

        JLabel lblHandlingSkill1 = new JLabel("Handling/Equipped Skill");
        GridBagConstraints gbc_lblHandlingSkill1 = new GridBagConstraints();
        gbc_lblHandlingSkill1.insets = new Insets(0, 0, 5, 5);
        gbc_lblHandlingSkill1.gridx = 0;
        gbc_lblHandlingSkill1.gridy = 2;
        frameCenter.add(lblHandlingSkill1, gbc_lblHandlingSkill1);

        boxHandlingSkill1 = new JComboBox();
        handlingSkills = new String[] { "Cannon", "In Rhythm", "Protected Deploy", "Protected Reload", "Recharged",
                "Rooted", "Stop, Drop, and Roll", "Zen", "Accurate", "Allegro", "Distance", "Extra", "Jazz Hands",
                "Optimized", "Stable" };
        Arrays.sort(handlingSkills);
        boxHandlingSkill1.setModel(new DefaultComboBoxModel(handlingSkills));
        GridBagConstraints gbc_boxHandlingSkill1 = new GridBagConstraints();
        gbc_boxHandlingSkill1.insets = new Insets(0, 0, 5, 5);
        gbc_boxHandlingSkill1.gridx = 1;
        gbc_boxHandlingSkill1.gridy = 2;
        frameCenter.add(boxHandlingSkill1, gbc_boxHandlingSkill1);
        
        lblHandlingequippedSkill2 = new JLabel("Handling/Equipped Skill 2:");
        GridBagConstraints gbc_lblHandlingequippedSkill2 = new GridBagConstraints();
        gbc_lblHandlingequippedSkill2.anchor = GridBagConstraints.EAST;
        gbc_lblHandlingequippedSkill2.insets = new Insets(0, 0, 5, 5);
        gbc_lblHandlingequippedSkill2.gridx = 0;
        gbc_lblHandlingequippedSkill2.gridy = 3;
        frameCenter.add(lblHandlingequippedSkill2, gbc_lblHandlingequippedSkill2);
        
        boxHandlingSkill2 = new JComboBox();
        boxHandlingSkill2.setModel(new DefaultComboBoxModel(new String[] {"test"}));
        GridBagConstraints gbc_boxHandlingSkill2 = new GridBagConstraints();
        gbc_boxHandlingSkill2.insets = new Insets(0, 0, 5, 5);
        gbc_boxHandlingSkill2.gridx = 1;
        gbc_boxHandlingSkill2.gridy = 3;
        frameCenter.add(boxHandlingSkill2, gbc_boxHandlingSkill2);

        JLabel lblHolsteredSkill = new JLabel("Holstered Skill:");
        GridBagConstraints gbc_lblHolsteredSkill = new GridBagConstraints();
        gbc_lblHolsteredSkill.insets = new Insets(0, 0, 0, 5);
        gbc_lblHolsteredSkill.gridx = 0;
        gbc_lblHolsteredSkill.gridy = 4;
        frameCenter.add(lblHolsteredSkill, gbc_lblHolsteredSkill);

        boxHolsteredSkill = new JComboBox();
        holsteredSkills = new String[] { "Double Duty", "Everlasting", "Greased", "Overlap", "Transmission",
                "Wascally" };
        Arrays.sort(holsteredSkills);
        boxHolsteredSkill.setModel(new DefaultComboBoxModel(holsteredSkills));
        GridBagConstraints gbc_boxHolsteredSkill = new GridBagConstraints();
        gbc_boxHolsteredSkill.insets = new Insets(0, 0, 0, 5);
        gbc_boxHolsteredSkill.gridx = 1;
        gbc_boxHolsteredSkill.gridy = 4;
        frameCenter.add(boxHolsteredSkill, gbc_boxHolsteredSkill);

        // sets the JFrame to be visible
        frmGuiweaponcategory.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmBtn) {
            // puts selected items into String variables
            // replace with a method to create a weapon later
            // consider the possibility for adding to a data structure
            createWeapon();
            frmGuiweaponcategory.dispose();
        }
        else if (e.getSource() == cancelBtn) {
            frmGuiweaponcategory.dispose();
        }
    }

    public ArrayList<Weapon> createWeapon() {
        weaponType = boxWeaponType.getSelectedItem().toString();
        weaponVariant = paneWeaponVariant.getText();
        activeSkill = boxWeaponType.getSelectedItem().toString();
        handlingSkill = boxHandlingSkill1.getSelectedItem().toString();
        holsteredSkill = boxHolsteredSkill.getSelectedItem().toString();
        weapons.add(new Weapon(weaponType, weaponVariant, activeSkill, handlingSkill, holsteredSkill));
        return weapons;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    public String toString()
    {
    	for(int i = 0; i < weapons.size(); i++)
    	{
    		System.out.println(weapons.get(i).toString());
    	}
    	return "";
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}