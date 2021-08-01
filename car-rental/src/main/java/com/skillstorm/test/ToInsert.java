package com.skillstorm.test;

import java.sql.SQLException;
import com.skillstorm.beans.Order;
import com.skillstorm.data.OrdersDAO;

public class ToInsert {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		OrdersDAO od = new OrdersDAO();
		boolean one = od.insert(new Order(15, "Audi", "A5", 80.5F));
		System.out.println(one);
	}
}
