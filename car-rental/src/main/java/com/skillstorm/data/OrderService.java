package com.skillstorm.data;

import java.sql.SQLException;
import java.util.List;

import com.skillstorm.beans.Order;

public class OrderService {
	OrdersDAO dao = new OrdersDAO();
	
	public List<Order> findAll() throws SQLException {
		return dao.selectAll();
	}

	public Order find(int id) throws SQLException {
		return dao.findByID(id);
	}
	
	public boolean add(Order order) throws SQLException {
		return dao.insert(order);
	}
	

	public boolean update(Order order) throws SQLException {
		return dao.update(order);
	}
	
	public boolean remove(int id) throws SQLException {
		return dao.delete(id);
	}
}