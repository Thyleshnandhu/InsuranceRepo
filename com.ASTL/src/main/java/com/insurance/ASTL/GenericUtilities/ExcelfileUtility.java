package com.insurance.ASTL.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelfileUtility 
{
	/**
	 * This method is used to read data from excel
	 * @param sheetname
	 * @param rownumber
	 * @param cellnumber
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelSheet(String sheetname,int rownumber,int cellnumber) throws Throwable
	{
		FileInputStream fin=new FileInputStream(PathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rownumber);
		Cell cell=row.getCell(cellnumber);
		String data=cell.getStringCellValue();
		return data;
	}
	/**
	 * This method is used to write data into excel
	 * @param sheetname
	 * @param rownumber
	 * @param cellnumber
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	public void writeDataintoExcelSheet(String sheetname,int rownumber,int cellnumber,String value) throws Throwable
	{
		FileInputStream fin=new FileInputStream(PathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rownumber);
		Cell cell=row.getCell(cellnumber);
		cell.setCellValue(value);
		
		FileOutputStream fout=new FileOutputStream(PathConstant.excelfilepath);
		wb.write(fout);
		wb.close();
	}
	
	public int getRowCount(String sheetname) throws Throwable
	{
		FileInputStream fin=new FileInputStream(PathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh=wb.getSheet(sheetname);
		int row=sh.getLastRowNum();
		return row;
	}
	
	public HashMap<String,String> getMultipleDataFromExcel(String sheetname,int keycol,int valcol) throws Throwable, IOException
	{
		//fetch data from excel
		FileInputStream fin=new FileInputStream(PathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh=wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		HashMap<String,String> map=new HashMap<String, String>();
		for(int i=1;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(keycol).getStringCellValue();
			String value=sh.getRow(i).getCell(valcol).getStringCellValue();
			map.put(key, value);
		}
		
		
		return map;
	}
	
	public Object[][] getMultipleDataFromExcel(String sheet) throws Throwable, Throwable
	{
		FileInputStream fin=new FileInputStream(PathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh=wb.getSheet(sheet);
		int lastrow=sh.getLastRowNum();
		int lastcol=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow+1][lastcol];
		
		for(int i=0;i<=lastrow;i++)
		{
			for(int j=0;j<lastcol;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();			}
		}
		return obj;
	}
	
	
}
