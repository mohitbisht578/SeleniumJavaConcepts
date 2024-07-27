package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfilefromExcel {
	
	public static void main(String[] args) throws IOException {
		
		///Users/mohit/eclipse-workspace/SeleniumWebDriver/test data/data.xlsx
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+
				"/test data/data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("no of rows : " + totalRows); //5 //rows will start from 0
		System.out.println("no of cells : " + totalCells); //4 //cells will start from 1
		
		for(int row=0; row<=totalRows; row++) {
			
			XSSFRow currentRow = sheet.getRow(row);
			
			for(int cell=0; cell<totalCells; cell++) {
				
				XSSFCell currentCell = currentRow.getCell(cell);
				
				System.out.print(currentCell.toString()+"\t");
			}
			
			System.out.println();
		}
		
		workbook.close();
		file.close();
 
	}

}
