package pc.predi.Div2InventoryCardLayoutDatabase.Tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateScripts {
	private ArrayList<String> script = new ArrayList<String>();
	public static void main(String[] args) {
		
		String weaponVariantField = "WeaponVariant', 'WeaponType";
		
		System.out.println(useSchema("division2_schema"));
		sqlInsertStatements(new File("Weapons/WeaponVariants.txt"), "weaponvariants",  "WeaponVariant', 'WeaponType", "Submachine Gun", "AUG A3 Para XS", "Vector SBR 9mm");

	}
	
	static String useSchema(String schema) {
		return "USE " + schema + ";";
		
	}
	
	//Goes through file, checks the startLine against the textfile, prints all lines as sql insert statements, stops at stopLine
	public static ArrayList<String> sqlInsertStatements(File file, String table, String fields, String values, String startLine, String stopLine) {
		String insertStatement;
		ArrayList<String> insertStatements = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			boolean startLineFound = false;
			String currentLine = "";
			String escapedLine = "";
			while(!currentLine.equals(startLine)) {
				currentLine = br.readLine();
				if(currentLine.equals(startLine)) {
					escapedLine = addEscapeCharacters(currentLine);
					escapedLine = "'" + escapedLine + "'";
					insertStatement = "INSERT INTO " + table + "('" + fields + "')" + "VALUES (" + escapedLine + ", '" + values + "' );";
					System.out.println(insertStatement);
					insertStatements.add(insertStatement);
					startLineFound = true;
				}
			}
			
			if(startLineFound == false) {
				br.close();
				System.out.println("Line not found!");
				return null;
			}
			
			while(!currentLine.equals(stopLine)) {
				currentLine = br.readLine();
				escapedLine = addEscapeCharacters(currentLine);
				escapedLine = "'" + escapedLine + "'";
				System.out.println("INSERT INTO " + table + "('" + fields + "')" + "VALUES (" + escapedLine + ", '" + values + "' );");
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return insertStatements;
	}
	
	/**
	 * Goes through file, checks the startLine against the textfile, goes through a
	 * loop to print sql insert statements that involves schema and table, ends at
	 * stopLine
	 */	
	static ArrayList<String> startStopLine(File file, String schema, String table, String fields, String equipmentType, String startLine, String stopLine) {
		try {
			//String file, String schema, String fields, String table, String startLine, String stopLine
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			boolean startLineFound = false;
			String currentLine = "";
			String escapedLine = "";
			ArrayList<String> script = new ArrayList<String>();
			while(!currentLine.equals(startLine)) {
				currentLine = br.readLine();
				if(currentLine.equals(startLine)) {
					startLineFound = true;
					escapedLine = addEscapeCharacters(currentLine);
					String output = "INSERT INTO `" + schema + "`. `" + table + "` (`"+ fields +"`) VALUES ('" + escapedLine +"', '"+ equipmentType +"');" ;
					System.out.println(output);
					script.add(output);
				}
			}
			if(startLineFound == false) {
				System.out.println("Line not found!");
				br.close();
				return null;
			}
			//when the startLine is found in the file
			while(!currentLine.equals(stopLine)) {
				currentLine = br.readLine();
				escapedLine = addEscapeCharacters(currentLine);
				String output = "INSERT INTO `" + schema + "`. `" + table + "` (`"+ fields +"`) VALUES ('" + escapedLine +"', '"+ equipmentType +"');" ;
				System.out.println(output);
				script.add(output);
			}
			br.close();
			return script;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	/*
	 * Goes through file, checks if startLine exists in text file, prints all
	 * lines as insert SQL statements until the stopLine
	 */	static void startStopLineConsole(File file, String schema, String table, String fields, String equipmentType, String startLine, String stopLine) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			boolean startLineFound = false;
			String currentLine = "";
			String escapedLine = "";
			//confirm startLine is in the file
			while(!currentLine.equals(startLine)) {
				currentLine = br.readLine();
				if(currentLine.equals(startLine)) {
					startLineFound = true;
					escapedLine = addEscapeCharacters(currentLine);
					String output = "INSERT INTO `" + schema + "`. `" + table + "` (`"+ fields +"`) VALUES ('" + escapedLine +"', '"+ equipmentType +"');" ;
					System.out.println(output);
				}
			}
			//exit when startLine is not found
			if(startLineFound == false) {
				System.out.println("Line not found!");
			}
			//when the startLine is found in the file
			while(!currentLine.equals(stopLine)) {
				currentLine = br.readLine();
				escapedLine = addEscapeCharacters(currentLine);
				String output = "INSERT INTO `" + schema + "`. `" + table + "` (`"+ fields +"`) VALUES ('" + escapedLine +"', '"+ equipmentType +"');" ;
				System.out.println(output);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//TODO: Creates a txtFile and populates it with sendTxt 
	static void createTxtFile(File txtFile, ArrayList<String> sendTxt) {
		
	}
	
	//checks for escape characters and adds to Strings that break SQL statements
	static String addEscapeCharacters(String outputString) {
		//TODO: nullpointer or outofbounds exception, please fix
		String output = "";
		for(int index = 0; index < outputString.length(); index++)
		{
			Character test = outputString.charAt(index);
			switch (test) {
			case 39:
				output += "\\";
				output += outputString.charAt(index);
				break;
			default : 
				output += outputString.charAt(index);
			}
		}
		return output;
	}
}
