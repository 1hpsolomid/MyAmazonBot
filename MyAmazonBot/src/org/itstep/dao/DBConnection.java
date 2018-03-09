package org.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private final static String DB_URL = "jdbc:postgresql://localhost:5432/amazonbot";
	private final static String DB_USERNAME = "postgres";
	private final static String DB_USERPASSWORD = "bogdan0077asus";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_USERPASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return con;
	}
}
