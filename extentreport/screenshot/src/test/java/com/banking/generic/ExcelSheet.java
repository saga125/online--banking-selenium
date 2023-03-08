package com.banking.generic;

/**
 * This enum contains sheet name of excel
 * @author DELL
 *
 */

public enum ExcelSheet {

	User("User");
	
	String key;
	/**
	 *  
	 * @param key
	 */
	private ExcelSheet(String key) {
		this.key = key;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSheetName() {
		return key;
	}
}
