package com.skillstorm.test;
import java.sql.SQLException;

import com.skillstorm.data.OrdersDAO;

public class ToDelete {

	public static void main(String[] args) throws SQLException {
		
		int todelete = 17;
		
		OrdersDAO od = new OrdersDAO();
		boolean one = od.delete(todelete);
		System.out.println(one);

	}

}
