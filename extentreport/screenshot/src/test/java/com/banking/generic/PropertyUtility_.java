package com.banking.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility_ {
	
	private Properties prop;
	public void initializePropertyFile(String filepath) throws IOException {
		FileInputStream fisProperty = new FileInputStream(filepath);
		prop = new Properties();
		prop.load(fisProperty);
}
	
	public String getPropertyData(String key) {
		String value = prop.getProperty(key,"").trim();
		return value;
	}


}
