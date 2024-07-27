package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String excelFile, String excelSheet) throws IOException {
	
			fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(excelSheet);
			int rowCount = sheet.getLastRowNum();
			workbook.close();
			fis.close();
			return rowCount;
	
	}
	
	public static int getCellCount(String excelFile, String excelSheet, int rowNum) throws IOException {
		
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(excelSheet);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;

}
	
	public static String getCellData(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		String data;
		try {
			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		return data;

}
	
	public static void setCellData(String excelFile, String excelSheet, int rowNum, int cellNum, String data) throws IOException {
		
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
	
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();

}
	
	public static void fillGreenColor(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = workbook.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
	}
	
public static void fillRedColor(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = workbook.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
	}
	
	


}
