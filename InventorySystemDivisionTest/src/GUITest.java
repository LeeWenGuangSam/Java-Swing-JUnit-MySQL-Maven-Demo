//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUITest implements ActionListener, Runnable {
	
	//instance variables
    private JFrame frmInventorysystem;
    private JPanel frameTop, frameBottom;
    private JComboBox equipList;
    private String category = "";
    private JButton confirmBtn, cancelBtn;
    private JButton uploadBtn;
    private Weapon weapon;
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private Armor armor;
    private ArrayList<Armor> armors = new ArrayList<Armor>();
    private GUIWeaponCategory weaponGUI = null;
    private GUIArmorCategory armorGUI = null;
    
    //Constructor
    public GUITest() {
        // formatting code here
        frmInventorysystem = new JFrame();
        frmInventorysystem.setTitle("InventorySystem");
        frmInventorysystem.setBounds(100, 100, 450, 300);
        frmInventorysystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInventorysystem.getContentPane().setLayout(new BorderLayout(0, 0));

        frameTop = new JPanel();
        frameTop.setLayout(new FlowLayout());

        /*
         * JFrame inside another JFrame is not possible. JPanels are used instead
         * Creating a flow layout for the bottom frame
         */
        frameBottom = new JPanel();
        frameBottom.setLayout(new FlowLayout());

        // creates comboBox to find out which of the three items player is looking to
        // insert
        // equipList.setModel(new DefaultComboBoxModel(new String[] {"Weapon", "Armor",
        // "Mod"}));
        String[] weaponCategories = { "Weapon", "Armor", "Mod" };
        equipList = new JComboBox(weaponCategories);
        frameTop.add(equipList);
        frmInventorysystem.getContentPane().add(frameTop, BorderLayout.NORTH);

        // Converting BorderLayout.south into a flow layout
        frmInventorysystem.getContentPane().add(frameBottom, BorderLayout.SOUTH);
        
        //adds confirmBtn to frame
        confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(this);

        frameBottom.add(confirmBtn);
        
        //add cancelBtn to frame
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);

        frameBottom.add(cancelBtn);

        uploadBtn = new JButton("Upload");

        uploadBtn.addActionListener(this);

        frameBottom.add(uploadBtn);
        
        //sets JFrame to be visible
        frmInventorysystem.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {

        // creates new JFrames to sort equipment when confirmBtn is clicked
    	//better methods to do this exist, like CardLayout
        if (e.getSource() == confirmBtn) {
            if (equipList.getSelectedItem().equals("Weapon")) {
                weaponGUI = new GUIWeaponCategory();
                SwingUtilities.invokeLater(weaponGUI);
            }
        }
        
        else if(e.getSource() == cancelBtn)
        {
        	frmInventorysystem.dispose();
        }
        
        //deprecated feature
        if (e.getSource() == uploadBtn) {
            if (weaponGUI != null) {
                weapons = weaponGUI.getWeapons();
                System.out.println(weaponGUI.toString());
            }
        }
    }
    
    //main
    public static void main(String[] args) {
        GUITest window = new GUITest();
        SwingUtilities.invokeLater(window);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}