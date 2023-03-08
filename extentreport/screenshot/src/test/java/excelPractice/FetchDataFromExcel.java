package excelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df = new DataFormatter();
		//convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/excelpractice.xlsx");
		//open excel
		Workbook wb = WorkbookFactory.create(fis);
		//get control on sheet
		Sheet sheet = wb.getSheet("User");
		//get control on row
		int rowCount = sheet.getLastRowNum(); //index
		//get control on cell
		short cellCount = sheet.getRow(1).getLastCellNum(); //count
		for (int i=1; i<=rowCount; i++) {
			for (int j=0; j<cellCount; j++) {
				//fetch data
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
		}
		System.out.println(rowCount);
		//close stream, workbook
		wb.close();
		
	}

}
