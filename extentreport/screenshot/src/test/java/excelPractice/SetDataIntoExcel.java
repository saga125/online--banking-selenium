package excelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/excelpractice.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Organization");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellValue("TC Pass");
	FileOutputStream fos = new FileOutputStream("./src/test/resources/excelpractice.xlsx");
	wb.write(fos);
	wb.close();
	fis.close();
	}

}
