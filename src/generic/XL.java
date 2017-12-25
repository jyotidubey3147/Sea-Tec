package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	
	//method to read the value from a cell
	public static String getcellValue(String path,String sheet,int r,int c) {
		String v="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			
		}
		return v;
	}
	
	//method to count the number of rows
	public static int rowCount(String path,String sheet) {
		int rc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		    rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e) {
			
		}
		return rc;
	}
	
	//method to write into new cell
	
	public static void setcellValue(String path,String sheet,String val,int r,int c) {
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).createRow(r).createCell(c).setCellValue(val);
			wb.write(new FileOutputStream(path));
		}
		catch(Exception e) {
			
		}
		
	}
	
	//method to count the number of cell in excel sheet
	
	public static int getcellCount(String path,String sheet,int r) {
		int cc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			cc=wb.getSheet(sheet).getRow(r).getLastCellNum();
		}
		catch(Exception e) {
		}
		return cc;
		
	}

}
