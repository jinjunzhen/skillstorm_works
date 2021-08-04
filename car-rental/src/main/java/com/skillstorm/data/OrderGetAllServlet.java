package com.skillstorm.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Order;


@WebServlet(urlPatterns = "/api/getAll")
public class OrderGetAllServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	OrderService orderService = new OrderService();
	
	public OrderGetAllServlet() {}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		requestURI = requestURI.replace(this.getServletContext().getContextPath(), "");
		// req.getParameter("a"); // get the query parameter
		System.out.println(requestURI);
		
		//response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("GET method");
		try {
			List<Order> aList = orderService.findAll();
			String json = new ObjectMapper().writeValueAsString(aList);
			resp.getWriter().print(json);		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
