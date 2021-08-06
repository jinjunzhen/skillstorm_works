package com.skillstorm.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.skillstorm.beans.Order;
import com.skillstorm.data.OrdersDAOTestingCopy;

public class DAOTESTING {
	
	Order order;
	OrdersDAOTestingCopy orderDAO = new OrdersDAOTestingCopy();
	
	
	@BeforeClass
	public static void setupBeforeClass() {
		System.out.println("before each test, insert 3 entries");
		System.out.println("after each test, delete 3 entries");
	}
	
	
	@Before
	public void beforeEachTest() throws SQLException {
		orderDAO.insert(new Order(1001, "string11", "string12", "string13", 1001.001F)); //1
		orderDAO.insert(new Order(2002, "string21", "string22", "string23", 2002.002F)); //2
		orderDAO.insert(new Order(3003, "string31", "string32", "string33", 3003.003F)); //3
	}
	
	@Test
	public void countEntries() throws SQLException {
		List<Order> orders = orderDAO.selectAll();
		int expected = 3;
		assertEquals(orders.size(), expected);
	}
	
	
	@Test
	public void insertEntry() throws SQLException {
		orderDAO.insert(new Order(1, "string", "string", "string", 1.01F));
		List<Order> orders = orderDAO.selectAll();
		int expected = 4;
		assertEquals(orders.size(), expected);
		int lastIindex = orders.size();
		orderDAO.delete(lastIindex);
	}
	
	@After
	public void afterEachTest() throws SQLException {
		List<Order> orders = orderDAO.selectAll();
		for (Order o : orders) {
			orderDAO.delete(o.getReference_id());
		}
	}
	
	@Test
	public void insertEntryThenFetch() throws SQLException {
		String expected = "customer_id=1111, make=I, model=am, url=here, total_cost=1.0]";
		orderDAO.insert(new Order(1111, "I", "am", "here", 1F));
		List<Order> orders = orderDAO.selectAll();
		int lastIindex = orders.size()-1;  // lastIindex = 3 from ( before test insert 3 + insert 1) - 1 
		Order actualObj = orders.get(lastIindex);
		String actualString = actualObj.toString(); // full string 
		StringBuffer sb = new StringBuffer(actualString);
		sb.replace(0,25,"");
		String actual = sb.toString();	
		assertEquals(expected, actual);
		
		orderDAO.delete(lastIindex); // 0, 1, 2, 3
	}
}
