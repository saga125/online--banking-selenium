package tyPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreDataintoPropertyFile {

	public static void main(String[] args) throws IOException {
		        //Step1 -->convert the physical file into java readable object
				FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData/login.propeties",true);
				//Step2:- create object for properties class
				Properties prop = new Properties();
				//Step3:- store data
				prop.setProperty("url", "http://localhost:8888");
				//Step4:- save data
				prop.store(fos, "");
				//Step5:- close stream
				fos.close();
			    prop.clear();
	}

}
