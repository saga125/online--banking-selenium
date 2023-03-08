package com.banking.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection connection;
	Statement statement;
	
	/**
	 * This method is used to open the database connection and initialise the connection, statement
	 * @param dBUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public DatabaseUtility(String dBUrl, String dbUserName, String dbPassword) throws SQLException{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection(dBUrl, dbUserName, dbPassword);
		statement = connection.createStatement();
	}
	
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<String> getDataFromDataBase(String query, String columnName) throws SQLException{
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			list.add(result.getString(columnName));
		}
		return list;
	}
	
	/**
	 * This method is used to validate the data 
	 * it is present in database or not
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public boolean validateDataInDatabase(String query, String columnName, String expData) throws SQLException {
		ArrayList<String> list = getDataFromDataBase(query, columnName);
		boolean flag = false;
		for (String actData : list) {
			if (actData.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to store/modify/insert/delete the data in database/to do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException 
	 */
	public void setDataInDataBase(String query) throws SQLException {
		int result = statement.executeUpdate(query);
		if (result >=1) {
			System.out.println("Data entered/modified sucessfully");
		}	
	}
	
	/**
	 * This method is used to close the Database connection
	 */
	public void closeDBConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("While closing the database connectioon we got exception");
		}
	}
	
	
}
