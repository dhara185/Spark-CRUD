package restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMS {
	Connection c = null;
	Statement stmt = null;

	private void getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:port/databaseName", "username", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean executeUpdate(String query) {
		Boolean result = false;
		try {
			getConnection();
			stmt = c.createStatement();
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	public ResultSet executeQuery(String query) {
		ResultSet result = null;
		try {
			getConnection();
			stmt = c.createStatement();
			result = stmt.executeQuery(query);
//			if (result.next()) {
//				System.out.println(result.getString(1));
//				return result;
//			} else {
//				System.out.println("hahaha");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}