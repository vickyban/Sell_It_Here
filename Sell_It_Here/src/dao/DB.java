package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static String user = "root";
	private static String password= "1234";
	private static String url = "jdbc:mysql://localhost:3307/sellithere";
	
	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password); 
			
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}catch(Exception e) {
			e.getMessage();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
