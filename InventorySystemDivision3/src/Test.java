/*
 * Main class for instantiating and creating the objects for the program to run
 * 
 * Uses a MVC pattern
 * SwingUtilities.invokeLater(Runnable runnable) is a method to allow the Swing program to run on the Event Dispatch Thread.
 * The goal of this program is to ask for user input through a swing GUI and output the results to a .csv file (comma seperated value)
 * The .csv file is intended to be opened by Microsoft Office Excel.
 * 
 */

import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.SwingUtilities;

import java.io.File;
public class Test {
	public static void main(String[] args)
	{
		
		/*
		File file = new File("InsertWeaponSheetIntoExcel.txt");
		try
		{
			
			PrintWriter output = new PrintWriter(file);
			String text = "Test";
			output.println(text);
			System.out.println("File is created?");
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		
		
		GUIModel model = new GUIModel();
		
		GUIView view = new GUIView(model);
		
		GUIController controller = new GUIController(view, model);
		
		view.setVisible(true);
		
		SwingUtilities.invokeLater(controller);
	}
}
