package com.banking.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility_ {

	private Workbook wb;
	public void initializeExcelFile(String filepath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis);
	}
	
	
	public  Map<String, String> getExcelData(String sheetName, String exptestCaseName) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map = new HashedMap<>();
		for (int i=1; i<=rowCount; i++ ) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(exptestCaseName)) {
				for (int j=1; j<sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}

}
