package com.evs.vtiger.exceldata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {
	public static void main(String[] args) {
	}
	

	
	public static String getTestData(List<String> dataList, String dataName) {
		
		int dataCount=dataList.size();
		int dataValueNumber=-1;
		for(int i=0;i<=dataCount-1; i++) {
			
			String listDataValue=dataList.get(i);
			if(listDataValue.equalsIgnoreCase(dataName)) {
				dataValueNumber=i+1;
				break;
			}
			
		}
		
		String dataValue=dataList.get(dataValueNumber);
		return dataValue;
	}
	
	
	public static List<String> getTestCaseData(String path,String testCaseId) throws IOException {
		int rowNumber =getRowNumber(testCaseId);
		List<String> listData=new ArrayList<>();
		InputStream  files=	new FileInputStream(path);
		Workbook wBook=    new XSSFWorkbook(files);
		
		Sheet sheetObj= wBook.getSheet("TestData");
		
	    Row  rowObj= sheetObj.getRow(rowNumber);
		int dataColumnNumber=getColumnNumber(sheetObj, "DataName1");
		int cellCount= rowObj.getLastCellNum();
		for (int i = dataColumnNumber; i <= cellCount-1; i++) {
			Cell  cellObj= rowObj.getCell(i);
			String cellValue =cellObj.getStringCellValue();
			listData.add(cellValue);
		}
		return listData;
	}
	
public static int getRowNumber(String testcaseId) throws IOException {
		
		InputStream  files=	new FileInputStream("testdata\\TestCase.xlsx");
		Workbook wBook= new XSSFWorkbook(files);
		Sheet sheetObj= wBook.getSheet("TestData");
		int colmNum=getColumnNumber(sheetObj, "TcId");
		int rowCount=sheetObj.getLastRowNum();
		int rowNumber=0;
		for(int i=0;i<=rowCount;i++) {
			Row rowObj=sheetObj.getRow(i);
			Cell cellData=rowObj.getCell(colmNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if(cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumber=i;
				break;
			}
		}
		return rowNumber;
		
		
	}

public static int getColumnNumber(Sheet sheetObj, String colomnName) throws IOException  {
	
        int columnNUmber=0;
		Row rowObj =sheetObj.getRow(0);
		int  columnCount= rowObj.getLastCellNum();
		for (int j = 0; j <=columnCount-1; j++) {
			Cell cellObj =rowObj.getCell(j);
			String columnData=cellObj.getStringCellValue();
			
			if (columnData.equalsIgnoreCase(colomnName)) {

				columnNUmber=j;
				break;
			}
		}

	return columnNUmber;
}




	
	
	
}
