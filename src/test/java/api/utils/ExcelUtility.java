package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		System.out.println("rowcount::"+rowcount);
		workbook.close();
		fis.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellcount = row.getLastCellNum();
		System.out.println("cellcount::"+cellcount);
		workbook.close();
		fis.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		DataFormatter format = new DataFormatter();
		String celldata;
		try {
			celldata = format.formatCellValue(cell);
		} catch (Exception e) {
			celldata = "";
		}
		System.out.println("celldata::"+celldata);
		workbook.close();
		fis.close();

		return celldata;
	}

	public void setCellData(String sheetName, int rowNum, int colNum, String celldata) throws IOException {
		File excelfile = new File(path);
		if (!excelfile.exists()) {
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);

		if (workbook.getSheetIndex(sheetName) == -1)
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rowNum) == null)
			sheet.createRow(rowNum);
		row = sheet.getRow(rowNum);

		cell = row.createCell(colNum);
		cell.setCellValue(celldata);
		fos = new FileOutputStream(path);
		System.out.println("cell::"+cell);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
}