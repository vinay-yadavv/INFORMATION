package com.evs.vtiger.exceldata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.evs.vtiger.utility.WebUtil;

public class ExcelUtil {
	

	public static Map<String, String> getTestCaseData(String xlPath, String testCaseId) throws IOException {

		///// workbook handling
		InputStream fis = new FileInputStream(xlPath);
		String[] arrPath = xlPath.split("\\.");
		String fileExtension = arrPath[1];
		Workbook wbook = null;
		if (fileExtension.equalsIgnoreCase("xlsx")) {
			wbook = new XSSFWorkbook(fis);

		} else if (fileExtension.equalsIgnoreCase("xls")) {
			wbook = new HSSFWorkbook(fis);
		} else {
			System.out.println("file extension is wrong, Please check it");
		}

		//// Sheet Handling

		Sheet sheetObj = wbook.getSheet("TestData");

//// Search Test Data Row Number

		///// search in which column number testcase id exist

		int tcIdColumnNo = getColumnNumber(sheetObj, "TcID");

		////// search rowNumber and now you know that from which column Number
		/////// you have to match the testcase id

		int rowCount = sheetObj.getLastRowNum();
		int rowNumber = -1;
		for (int i = 0; i <= rowCount; i++) {
			Row rowObj = sheetObj.getRow(i);
			Cell cellObj = rowObj.getCell(tcIdColumnNo);
			String cellDataTcId = cellObj.getStringCellValue();
			if (cellDataTcId.equalsIgnoreCase(testCaseId)) {
				rowNumber = i;
			}
		}
//		  System.out.println(rowNumber);
		///////

		Row dataRowObj = sheetObj.getRow(rowNumber);

		int dataCellCount = dataRowObj.getLastCellNum();

		///// get Column Number of Column From where data is being started
		int dataStartingColumnNumber = getColumnNumber(sheetObj, "DataName1");
		int z = 100;

		///// printing total testData
		Map<String, String> mapData = new HashMap<String, String>();

		for (int i = dataStartingColumnNumber; i <= dataCellCount - 1; i = i + 2) {
			Cell cellDataNameObj = dataRowObj.getCell(i);
			String cellDataName = cellDataNameObj.getStringCellValue();

			Cell cellDataValueObj = dataRowObj.getCell(i + 1);
			String cellDataValue = cellDataValueObj.getStringCellValue();
			mapData.put(cellDataName, cellDataValue);
		}

		return mapData;

	}

	public static int getColumnNumber(Sheet sheetObj, String testId) {

		Row fstRowObj = sheetObj.getRow(0);
		int cellCount = fstRowObj.getLastCellNum();
		int tcIdColumnNumber = -1;
		for (int i = 0; i <= cellCount - 1; i++) {
			Cell cellObj = fstRowObj.getCell(i);
			String columnName = cellObj.getStringCellValue();
			if (columnName.equalsIgnoreCase(testId)) {
				tcIdColumnNumber = i;
				break;
			}

		}
		return tcIdColumnNumber;
	}
public static void main(String[] args) throws IOException {
//	getRowNumber("VT004");
}
	public static int getRowNumber(String testcaseId) throws IOException {

		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		int colmNum = getColumnNumber("TcId");
		int rowCount = sheetObj.getLastRowNum();
		int rowNumber = 0;
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow rowObj = sheetObj.getRow(i);
			XSSFCell cellData = rowObj.getCell(colmNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumber = i;
				WebUtil.getRandomNumber(colmNum, rowCount);
				break;
			}
		}
		return rowNumber;

	}

	public static void getRowNumberData(int RowNumber) throws IOException {
		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		XSSFRow rowObj = sheetObj.getRow(RowNumber);
		int dataColumnNumber = getColumnNumber("DataName1");
		for (int i = dataColumnNumber; i < rowObj.getLastCellNum(); i++) {
			XSSFCell cellObj = rowObj.getCell(i);
			String cellValue = cellObj.getStringCellValue();
			System.out.print(cellValue + ",");
		}
		System.out.println();
	}

	public static int getColumnNumber(String colomnName) throws IOException {
		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		int columnNUmber = 0;
		XSSFRow rowObj = sheetObj.getRow(0);
		int columnCount = rowObj.getLastCellNum();
		for (int j = 0; j <= columnCount - 1; j++) {
			XSSFCell cellObj = rowObj.getCell(j);
			String columnData = cellObj.getStringCellValue();

			if (columnData.equalsIgnoreCase(colomnName)) {

				columnNUmber = j;
				break;
			}
		}

		return columnNUmber;
	}

	public void getAllExcelData() throws IOException {

		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		int countRow = sheetObj.getLastRowNum();
		for (int i = 0; i <= countRow; i++) {
			XSSFRow rowObj = sheetObj.getRow(i);
			int currentCellNumber = rowObj.getLastCellNum();
			for (int j = 0; j <= currentCellNumber - 1; j++) {
				XSSFCell cellObj = rowObj.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String cellValue = cellObj.getStringCellValue();
				System.out.print(cellValue + ",");
			}
			System.out.println("");
		}
	}

	public static void getColumnNumber(int columnNumber) throws IOException {
		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		for (int i = 0; i < sheetObj.getLastRowNum(); i++) {
			XSSFRow rowObj = sheetObj.getRow(i);
			XSSFCell cellObj = rowObj.getCell(columnNumber);
			String cellValue = cellObj.getStringCellValue();
			System.out.print(cellValue + ",");
		}
		System.out.println();
	}
	

	public static void simpleCode(int RowNumber, int cellNumber) throws IOException {
		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		XSSFRow rowObj = sheetObj.getRow(RowNumber);
		XSSFCell cellObj = rowObj.getCell(cellNumber);
		System.out.println(cellObj);
	}

	public void defineAbtCode() throws IOException {
		// For reading excel file purpase we will use Fileinputstream
		// when we want to write any data in excel then we will FileoutPutsream ..
		// InputStream is a parent of FileInputsream .....
		InputStream files = new FileInputStream("testdata\\TestCase.xlsx");
		// For using fileinputsream valiable we will use XSSFWorkbook ........
		XSSFWorkbook wBook = new XSSFWorkbook(files);
		// For taking excel sheet we will use of getSheet in which we will have to pass
		// sheet name
		// For taking excel sheet we will use of getSheetAt in which we will have to
		// pass number of sheet
		// it both return object of XSSFSheet
		XSSFSheet sheetObj = wBook.getSheet("TestData");
		// For Taking row number we will have to use getRow method
		// it take always one argument of int then we pass number of
		// row for taking data
		XSSFRow rowObj = sheetObj.getRow(1);
		// For taking Cell number we will have to use getCell method it also taken
		// cell number in which we will pass number of cell
		XSSFCell cellObj = rowObj.getCell(3);
		System.out.println(cellObj);
	}

}
