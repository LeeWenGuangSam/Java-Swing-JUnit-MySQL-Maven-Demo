import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateDivision2Excel {

    public static void main(String[] args) {

    	XSSFWorkbook workbook = new XSSFWorkbook();
        try {
        	FileOutputStream output = new FileOutputStream("Test1.xlsx");
            XSSFSheet sheet = workbook.createSheet("sheet1");
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue("test");
            workbook.write(output);
            workbook.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	/**
    	
        File file = new File("Test1.xlsx");
        FileInputStream fIP = null;
		try {
			fIP = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Get the workbook instance for XLSX file 
        try {
			XSSFWorkbook workbook = new XSSFWorkbook(fIP);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(file.isFile() && file.exists()) {
           System.out.println("openworkbook.xlsx file open successfully.");
        } else {
           System.out.println("Error to open openworkbook.xlsx file.");
        }
        */
    }
}