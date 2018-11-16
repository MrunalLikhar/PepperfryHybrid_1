package Generic;


import java.io.FileInputStream;

import java.io.FileOutputStream;





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	
	
	
	public static String getExcelData(String filepath, String sheet, int row, int cell) {
		String s ="";
		
		try {
			FileInputStream f = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(f);
			s = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		} 
		catch (Exception e) {
			
		}
		
		return s ;
		
		
	}
	
	
		
		
	
	
	public static void putDataInExcel(String filepath, String sheetname, int row, int cell, String value) {
		
		 Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(filepath));
		} 
		catch (Exception e) {
		
		}
		 
		 Sheet s = wb.getSheet(sheetname);
		 Row r = s.getRow(row);
		 Cell c = r.getCell(cell);
		  if (c ==null)
			  c =r.createCell(cell);
		  c.setCellType(CellType.STRING);
		  c.setCellValue(value);
		  
		  FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("PepperfryData.xlsx");
		} 
		catch (Exception e) {
			
		}
		  try {
			wb.write(fo);
		} 
		  catch (Exception e) {
			
		}
		  try {
			fo.close();
		} 
		  catch (Exception e) {
			
		}
		  try {
			wb.close();
		} 
		  catch (Exception e) {
			
		}
		  
	}
		
		
		
		
		
		
}

