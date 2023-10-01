package com.insu.Genericutils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility{
	/**
	 * This method will fetch the data from the excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNo);
		Cell cell=row.getCell(cellNo);
		String data=cell.toString();
		return data;
		
		
	}
	/**
	 * This method will write the data in the excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
   public void writeDataIntoExcelSheet(String sheetName,int rowNo,int cellNo,String value) throws Throwable {
	   FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.createRow(rowNo);
		Cell cell=row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IpathConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
   /**
    * This method fetch count row created in excel sheet
    * @param sheetName
    * @return
    * @throws Throwable
    */
   public int getRowCount(String sheetName) throws Throwable {
	   FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis); 
		Sheet sheet=wb.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
   }
   public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn, WebDriver driver) throws Throwable{
	   //FETCHING DATA FROM EXCEL
	   FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
	   Workbook wb=WorkbookFactory.create(fis);
	   Sheet sh=wb.getSheet(sheetName);
	   int count= sh.getLastRowNum();
	   
	   HashMap<String , String> map=new HashMap<String, String>();//empty map
	   
	   for(int i=1;i<=count;i++) {
		   String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
		   String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
		   map.put(key, value);
	   }
	   
	   return map;
	     }
   public Object[][] getMultipleSetOfDataFromExcel(String sheetName) throws Throwable {
	   FileInputStream fi=new FileInputStream(IpathConstants.excelPath);
	   Workbook wb=WorkbookFactory.create(fi);
	   Sheet sh=wb.getSheet(sheetName);
	   int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow+1][lastCell];
		
		for(int i=0;i<=lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj[i][j] =sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
   }
	 
   }

