package excelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excelpractice.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("org");
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		String data = df.formatCellValue(cell);
		System.out.println(data);
		wb.close();
		fis.close();
	}

}
