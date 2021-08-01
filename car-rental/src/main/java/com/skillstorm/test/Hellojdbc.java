package com.skillstorm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Hellojdbc {
	
	static String url = "jdbc:mysql://localhost:3306/ss_p1";
	static String username = "ssp1";
	static String password = "password";
	
	static {
		// 1. load the driver
				try {Class.forName("com.mysql.cj.jdbc.Driver");
				}  catch (ClassNotFoundException e) {
					System.out.println("something bad happened while loading the driver.");
					}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		// 2. make a connection object  
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);
		
		// 3. statement object
		PreparedStatement stmt = conn.prepareStatement("insert into orders(customer_id, make, model, url, total_cost) values(?, ?, ?, ?, ?)");
		stmt.setInt(1, 12);
		stmt.setString(2, "Toyota");
		stmt.setString(3, "Crollor");
		stmt.setString(4, "");
		stmt.setFloat(5, 50.5f);
		
		// 4. execute the SQL commands
		stmt.executeUpdate();
		conn.commit();
	
		
		// 5. Close the connection
		conn.close();

	}

}
