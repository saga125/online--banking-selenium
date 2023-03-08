package practice;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDatafromDataBase {

	public static void main(String[] args) throws SQLException {
		//step1:- create instance for Driver --> register driver to jdbc
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection = null;
		try {
			//step2:-get connection --> dburl, un, pwdjdbc:mysql://localhost:3306mydb
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
			//Step-3 --> create statement 
			Statement statement = connection.createStatement();
			//Step4 --> execute query
			ResultSet result = statement.executeQuery("Select * from student");
			//Step5 --> iterate data and verify or fetch
			while (result.next()) {
				String empName = result.getString("emp_name");
				int empId = result.getInt(2);
				System.out.println(empName+" "+empId);
			}
		}
		finally {
			//Step 6 --> close connection
			connection.close();
			System.out.println("connection closed");
		}
	}

}
