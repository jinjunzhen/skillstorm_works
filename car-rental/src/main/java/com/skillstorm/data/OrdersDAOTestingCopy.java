package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.*;

public class OrdersDAOTestingCopy {
	// CRUD: Create, Retrieve, Update, Delete
	
	private static String url = "jdbc:mysql://localhost:3306/p_sample";
	private static String username = "ssp1";
	private static String password = "password";
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Something bad happened while loading the driver.");
			e.printStackTrace();
		}
	}
	
	
	public List<Order> selectAll() throws SQLException{
		List<Order> oList = new LinkedList();
		
		Connection conn = DriverManager.getConnection(url, username, password);
		try {
			PreparedStatement stmt = conn.prepareStatement("select reference_id, customer_id, make, model, url, total_cost from orders;");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int reference_id = rs.getInt("reference_id");
				int customer_id = rs.getInt("customer_id");
				String make = rs.getString("make");
				String model = rs.getString("model");
				String url = rs.getString("url");
				float total_cost = rs.getFloat("total_cost");
				Order oneOrder = new Order(reference_id, customer_id, make, model, url, total_cost);
				oList.add(oneOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oList;
	}
	
	
	public boolean insert(Order order) throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into orders(customer_id, make, model, url, total_cost) values(?, ?, ?, ?, ?)");
			stmt.setInt(1, order.getCustomer_id());
			stmt.setString(2, order.getMake());
			stmt.setString(3, order.getModel());
			stmt.setString(4, order.getUrl());
			stmt.setFloat(5, order.getTotal_cost());
			return stmt.executeUpdate()==1;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		return false;
	}
	
	public boolean update(Order order) throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		try {
			PreparedStatement stmt = conn.prepareStatement("update orders set customer_id=?, make=?, model=?, url=?, total_cost=? where reference_id=?");
			stmt.setInt(1, order.getCustomer_id());
			stmt.setString(2, order.getMake());
			stmt.setString(3, order.getModel());
			stmt.setString(4, order.getUrl());
			stmt.setFloat(5, order.getTotal_cost());
			stmt.setInt(6, order.getReference_id());
			return stmt.executeUpdate()==1;	
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		return false;
	}
	
	public boolean delete(int reference_id) throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from orders where reference_id = ?;");
			stmt.setInt(1, reference_id);
			return stmt.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		return false;
	}
	
	public Order findByID(int reference_id) throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		try {
			PreparedStatement stmt = conn.prepareStatement("select reference_id, customer_id, make, model, url, total_cost from orders where reference_id = ?;");
			stmt.setInt(1, reference_id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return new Order(rs.getInt("reference_id"), rs.getInt("customer_id"),
					rs.getString("make"), rs.getString("model"), rs.getString("url"), rs.getFloat("total_cost"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		
		return null;
	}
	
	
	
}
