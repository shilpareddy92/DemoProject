package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataClass {
	
	public static String TESTDATA_SHEET_PATH  = "C:\\Users\\SDagadapally\\Desktop\\testdata.xlsx";
	static Workbook book ;
	static Sheet sheet;
	static FileInputStream inputstream = null;

	public static void main(String[] args)  {
		
		ReadExcel("data");
		
		

		Properties prop = new Properties();
		
		try {
			inputstream = new FileInputStream(
					"C:\\Users\\SDagadapally\\eclipse-workspace\\DemoProject\\src\\com\\demo\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(inputstream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("address"));
		

	}
	
	public static Object[][] ReadExcel(String SheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}

		}
		return data;
	}
	
	
	public static String GetData(String SheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		String data= null;
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data = sheet.getRow(i + 1).getCell(k).toString();

			}

		}
		return data;
	}

}
