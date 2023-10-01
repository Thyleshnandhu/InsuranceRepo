package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleInExcel {
	public static void main(String[] args) throws Throwable {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int row=sc.nextInt();
		System.out.println("Enter the number of columns");
		int col=sc.nextInt();
		String path = "./src\\test\\resources\\TestData.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("insurance");
		for(int i=0;i<row;i++) {
			sh.createRow(i);
			for(int j=0;j<col;j++) {
				System.out.println("Enter the data for "+i+"row and"+j+"cell");
				String c=sc.next();
				sh.getRow(i).createCell(j).setCellValue(c);
			}
		}
		FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
