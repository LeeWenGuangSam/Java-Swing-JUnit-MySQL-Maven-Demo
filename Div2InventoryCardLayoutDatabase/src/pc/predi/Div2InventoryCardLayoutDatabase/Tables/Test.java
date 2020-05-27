package pc.predi.Div2InventoryCardLayoutDatabase.Tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	static ArrayList<String> handlingSkills = new ArrayList<>();
	static ArrayList<String> weaponTypes = new ArrayList<>();
	static ArrayList<String> activeSkills = new ArrayList<>();
	static ArrayList<String> equippedSkills = new ArrayList<>();
	static ArrayList<String> holsteredSkills = new ArrayList<>();
	static File handSkillFile = new File("Weapons/HandlingSkills.txt");
	static File weaponTypeFile = new File("Weapons/weaponTypes.txt");
	static File actSkillFile = new File("Weapons/ActiveSkills.txt");
	static File equippedSkillFile = new File("Weapons/EquippedSkills.txt");
	static File holstSkillFile = new File("Weapons/HolsteredSkills.txt");
	public static void main(String[] args) {
	handlingSkills = readFile(handSkillFile);
	weaponTypes = readFile(weaponTypeFile);
	activeSkills = readFile(actSkillFile);
	equippedSkills = readFile(equippedSkillFile);
	holsteredSkills = readFile(holstSkillFile);
	//insertStatements("handlingskills", handlingSkills, weaponTypes);
	//insertStatements("activeSkills", activeSkills, weaponTypes);
	insertStatements("holsteredskills", equippedSkills, weaponTypes);
	insertStatements("holsteredSkills", holsteredSkills, weaponTypes);
	
	}
	static void insertStatements(String table, ArrayList<String> fields, ArrayList<String> weaponTypes) {		
		for(int indexField = 0; indexField < fields.size(); indexField++) {
			for(int indexType = 0; indexType < weaponTypes.size(); indexType++) {
				String statement = "insert into " + table + " VALUES " + "(NULL," + fields.get(indexField) + "," + weaponTypes.get(indexType) +");";
				System.out.println(statement);
			}
		}
	}
	
	static ArrayList<String> readFile(File file) {
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = "";
			while((currentLine = br.readLine()) != null) {
				temp.add("'" + currentLine + "'");
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
}
