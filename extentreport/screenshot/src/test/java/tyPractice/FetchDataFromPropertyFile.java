package tyPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//Step1 :-convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData/login.properties");
		//Step2 :- create object for properties class
		Properties prop = new Properties();
		//Step3 :- load all keys
		prop.load(fis);
		//Step4 :- fetch data
		String pw = prop.getProperty("password");
		System.out.println(pw);
		//Step5 :- close input stream
		fis.close();
	}

}



//you can use trim() method to remove end and start spaces in property file key values