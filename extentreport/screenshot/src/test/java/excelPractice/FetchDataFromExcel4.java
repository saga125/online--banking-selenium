package excelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel4 {

	public static void main(String[] args) throws IOException {
		String sheetName = "User";
		String expTestScriptName = "InternetBanking";
		String expKey = "PAN";
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excelpractice.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		List<String> dataList = new ArrayList<>();
		for (int i=1; i<=rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expKey)) {
						for (int k = i+1; ; k++) {
							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
							if (data.equals("")) {
								break;
							}
							else {
								dataList.add(data);
							}
						}
					}
			}
		}
	}

	}
}
