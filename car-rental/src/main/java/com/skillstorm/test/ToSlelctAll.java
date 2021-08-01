package com.skillstorm.test;
import java.sql.SQLException;
import java.util.List;

import com.skillstorm.beans.Order;
import com.skillstorm.data.OrdersDAO;

public class ToSlelctAll {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		OrdersDAO od = new OrdersDAO();
		List<Order> oList = od.selectAll();
		
		for (Order o : oList) {
			System.out.println(o);
		}
	}
}
