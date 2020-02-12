package com.cloudfinder.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static int PAGE_LOAD_TIMEOUT= 30;
    public static int IMPLICIT_WAIT = 35;
    public static int EXPLICIT_WAIT = 20;
    
    // TestData excel path
    public static String TestData_SheetPath="E:\\EclipseWorkspace\\SeleniumProject\\src\\main\\java\\com\\cloudfinder\\qa\\testdata\\SeleniumTestData.xlsx";
    
    static Workbook book;
    static Sheet sheet;
    
    // Method to fetch
    public static Object[][] getTestData(String sheetName){
    	FileInputStream file = null;
    	try {
    		file= new FileInputStream(TestData_SheetPath);
    	} catch(FileNotFoundException e){
    		e.printStackTrace();
    		}
    	try {
    		book= WorkbookFactory.create(file);
    	} catch(InvalidFormatException e) {
    		e.printStackTrace();
    		} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	sheet= book.getSheet(sheetName);
    	Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	
    	for(int i=0; i<sheet.getLastRowNum(); i++) {
    		for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
    			data[i][j]= sheet.getRow(i+1).getCell(j).toString();
    		}
    	}
    	return data;
    	
    }
}
