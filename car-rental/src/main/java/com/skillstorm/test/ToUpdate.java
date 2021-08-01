package com.skillstorm.test;

import java.sql.SQLException;

import com.skillstorm.beans.Order;
import com.skillstorm.data.OrdersDAO;

public class ToUpdate {

	public static void main(String[] args) throws SQLException {
		OrdersDAO od = new OrdersDAO();
		boolean one = od.update(new Order( 1 ,15, "Audi", "A5", "url", 80.5F));
		System.out.println(one);
	}

}
