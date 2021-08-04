package com.skillstorm.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/rental")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	OrdersDAO dao = new OrdersDAO();

	public OrderServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("id") == null || req.getParameter("id").equals("0")) {
			List<Order> orders = null;
			try {
				orders = dao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String json = new ObjectMapper().writeValueAsString(orders);
			resp.getWriter().print(json);
		} else {
			String param = req.getParameter("id");
			int id = Integer.parseInt(param);
			Order order = null;
			try {
				order = dao.findByID(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // JDBC
			String json = new ObjectMapper().writeValueAsString(order); // converting Java obj -> JSON
			System.out.println(json);
			resp.getWriter().print(json);// write the data to the response
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp); // default is to throw 405
		InputStream requestBody = req.getInputStream();
		// convert the request body into a Trainee.class object
		Order order = new ObjectMapper().readValue(requestBody, Order.class);
		System.out.println(order);
		try {
			boolean updated = dao.insert(order);
			// return back the updated trainee
			resp.getWriter().print(updated);
			resp.setStatus(201); // "return"
			resp.setContentType("application/json"); // Content-Type : application/json (header)
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print("cant insert"); // OR empty object
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody = req.getInputStream();
		// convert the request body into a Trainee.class object
		Order order = new ObjectMapper().readValue(requestBody, Order.class);
		System.out.println(order);
		try {
			boolean success = dao.update(order);
			// return back the updated trainee
			resp.getWriter().print(success + " plz do error check yourself, i am lazy");
			resp.setStatus(200); // "ok"
			resp.setContentType("application/json"); // Content-Type : application/json (header)
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print("cant update"); // OR empty object
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean success = false;
		if (req.getParameter("id") == null || req.getParameter("id").equals("0")) {
			resp.getWriter().print("you need to enter an ID");
		} else {
			String param = req.getParameter("id");
			int id = Integer.parseInt(param);
			try {
				success = dao.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // JDBC
			resp.getWriter().print("deletable?: " + success);// write the data to the response
		}
	}

}
