package com.skillstorm.test;

import java.sql.SQLException;

import com.skillstorm.beans.Order;
import com.skillstorm.data.OrdersDAO;

public class toFindByID {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		int toFindByID = 16;
		
		OrdersDAO od = new OrdersDAO();
		Order one = od.findByID(toFindByID);
		System.out.println(one);

	}

}
