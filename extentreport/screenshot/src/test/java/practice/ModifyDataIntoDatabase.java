package practice;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		//Step1 -->create instance for Driver -->register driver to jdbc
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		//Step2 -->get connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
			//step3 --> create statement
			Statement statement = connection.createStatement();
			//step4 -->execute statement/query
			int result = statement.executeUpdate("insert into student values('Veera', '1003');");
			
			if (result==1) {
				System.out.println("User is created");
			}
			else {
				System.out.println("user is not created");
			}
		}
			finally {
				//Step5 --> close connection
				connection.close();
				System.out.println("connection closed");
			}
	}
}
