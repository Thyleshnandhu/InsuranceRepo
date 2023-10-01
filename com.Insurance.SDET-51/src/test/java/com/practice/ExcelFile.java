package com.practice;

import java.io.FileInputStream;//reading multiple data in excel


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s= wb.getSheet("insurance");
		
		int count=s.getLastRowNum();
		
		
		for(int i=1;i<=count;i++) {
			int lastCell=s.getRow(1).getLastCellNum();
			int lastCell1=s.getRow(i).getLastCellNum();
			for(int j=0;j<lastCell1;j++) {
				String value=s.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value+" ");
			}
			System.out.println();
		}
	}}


