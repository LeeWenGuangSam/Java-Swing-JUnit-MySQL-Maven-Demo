package pc.predi.InventorySystemDivsionCardLayout.WeaponVariantsTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * @author predi
 * Deprecated.
 * Refer to pc.predi.Div2InventoryCardLayoutDatabase.Tables.CreateScripts for a more elegant and less hardcoded design 
 */
public class PopulateWeaponVariants {
	public static void main(String[] args) {
		String insertStatement = "";
		ArrayList<String> tempArrayList = new ArrayList<String>();
		
		try {
			File typesFile = new File("Weapons/WeaponTypes.txt");
			File variantsFile = new File("Weapons/WeaponVariants.txt");
			FileReader fr = new FileReader(variantsFile);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = "";
			while(!currentLine.equals("The Railsplitter - CTAR-21")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Assault Rifle');");
				//System.out.println();
			}
			while(!currentLine.equals("Military RPK-74 M")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Light Machine Gun');");
			}
			while(!currentLine.equals("Surplus SVD")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Marksman Rifle');");
			}
			while(!currentLine.equals("X-45 Tactical Replica")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Pistol');");
			}
			while(!currentLine.equals("USC 45 ACP Replica")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Rifle');");
			}
			while(!currentLine.equals("Tactical Super 90 SBS Replica")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Shotgun');");
			}
			while(!currentLine.equals("Vector SBR 9mm")) {
				currentLine = br.readLine();
				System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Submachine Gun');");
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void stopAtThisLine(String stopLine) {
//		while(!currentLine.equals("Vector SBR 9mm")) {
//			currentLine = br.readLine();
//			System.out.println("INSERT INTO `division2_inventory`.`weaponvariants` (`WeaponVariant`, `WeaponType`) VALUES ('"+ currentLine +"', 'Submachine Gun');");
//		}
//		br.close();
//	}
}
