package Staff;

import java.text.ParseException;
import java.util.Date;

import com.banking.generic.JavaUtility;

public class Practice1 {

	public static void main(String[] args) throws ParseException {
		JavaUtility ju = new JavaUtility();
	/*	String dateTime = ju.addOrSubstractDate("16_10_2022", 20);
		System.out.println(dateTime);*/
		
		String date = ju.getDateinPattern("20/02/2023");
		System.out.println(date);
	}

}
