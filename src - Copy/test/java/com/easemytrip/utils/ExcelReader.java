package com.easemytrip.utils;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private Workbook wb;
	public ExcelReader(String fileNameWithLocation) {
		try {
			if(fileNameWithLocation.endsWith("xls")) {
				wb=new HSSFWorkbook(new FileInputStream(fileNameWithLocation));
				
			}
			else if(fileNameWithLocation.endsWith("xlsx")) {
				wb=new XSSFWorkbook(new FileInputStream(fileNameWithLocation));
			}
			else {
				System.out.println("Invalid input");
			}
		}catch (Exception E) {
			System.out.println("Error with file handling "+E.getMessage());
		}
		
	}
	public int rowNumbers(String sheet) {
		return wb.getSheet(sheet).getLastRowNum()+1;
	}
	public int colNumbers(String sheet) {
		return wb.getSheet(sheet).getRow(0).getLastCellNum();
	}
	public int getCellDataInt(String sheetName, int row, int col) {
		Cell data = wb.getSheet(sheetName).getRow(row).getCell(col);
		int data1 = (int) data.getNumericCellValue();
		return data1;
	}
	
	public String readCellData(String sheet,int row,int col) {
		String data=wb.getSheet(sheet).getRow(row).getCell(col).toString();
		return data;
		
	}
	
}
