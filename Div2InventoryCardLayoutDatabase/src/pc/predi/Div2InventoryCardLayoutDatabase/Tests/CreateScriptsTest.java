package pc.predi.Div2InventoryCardLayoutDatabase.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pc.predi.Div2InventoryCardLayoutDatabase.Tables.CreateScripts;

class CreateScriptsTest {
	
	//regex demo
	@Test
	void testSqlInsertStatements() {
		ArrayList<String> statements = CreateScripts.sqlInsertStatements(new File("Weapons/WeaponVariants.txt"), "weaponvariants",  "WeaponVariant', 'WeaponType", "Submachine Gun", "AUG A3 Para XS", "Vector SBR 9mm");
		ArrayList<Boolean> resultsList = new ArrayList<Boolean>();
		ArrayList<Boolean> expectedResultsList = new ArrayList<Boolean>();
		Boolean result;
		for(String s : statements) {
			result = s.matches("INSERT[\\s]*INTO[\\s]*[\\w]*[(]'[\\w]*',[\\s]*'[\\w]*'[)]VALUES[\\s]*[(]'.*',[\\s]*'.*'[\\s][)];");
			resultsList.add(result);
			expectedResultsList.add(true);
		}
		Boolean[] results = new Boolean[resultsList.size()];
		results = resultsList.toArray(results);
		Boolean[] expectedResults = new Boolean[resultsList.size()];
		expectedResults = expectedResultsList.toArray(expectedResults);
		assertArrayEquals(expectedResults, results);
	}

}
