package excelPractice;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelDataForBankingSystem {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excelpractice.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("User");
		int rowCount = sheet.getLastRowNum(); 
		System.out.println(rowCount);
		for (int i=1; i<=rowCount; i++) {
			short cellCount = sheet.getRow(i).getLastCellNum(); //count
			System.out.println(cellCount);
			for (int j=0; j<cellCount; j++) {
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
	}

}
	}
}
