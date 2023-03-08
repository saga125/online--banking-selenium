package com.banking.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * This class contains reusable methods for handling property file
 * @author DELL
 */
public class PropertyUtility {

	private Properties prop;
	 
	/**
	 * This constructor will initialise the property file
	 * @param filepath
	 * @throws IOException
	 */
	public PropertyUtility(String filePath) throws IOException{
		FileInputStream fisProperty = new FileInputStream(filePath);
		prop= new Properties();
		prop.load(fisProperty);
		fisProperty.close();
	}
	
	/**
	 * This constructor is used to create object for class
	 */
	public PropertyUtility() {
	}
		
	/**
	 * This method is used to initialise Property File
	 * @deprecated new PropertyUtility(String filePath)
	 * @param filePath
	 * @throws Throwable
	 */
	@Deprecated
	public void initializePropertyFile(String filePath) throws Throwable{
		FileInputStream fisProperty = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fisProperty);
		fisProperty.close();
	}
	/**
	 * This method is used to fetch data from property file based on key
	 * @param key
	 * @return
	 */
	public String getPropertyData(PropertyKey key) {
		String keyString = key.name().toLowerCase();
		String value = prop.getProperty(keyString, "Please give proper key '"+keyString+"'").trim();
		return value;
	}
}
