package pc.predi.Div2InventoryCardLayoutDatabase.Tables.ActiveSkillsTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PopulateActiveSkills {
	public static void main(String[] args) {
		File file = new File("Weapons/ActiveSkills");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = "";
			br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
