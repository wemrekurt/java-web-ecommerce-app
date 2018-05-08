package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;


public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDao orderDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public OrderController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        orderDAO = new OrderDao(jdbcURL, jdbcUsername, jdbcPassword);
        
    }
    
    public void chOrderState() 
    		throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	int state = Integer.parseInt(request.getParameter("state"));
    	     
        Order order = orderDAO.find(id);
        order.setState(state);
        orderDAO.update(order);
        
        Cookie cookie = new Cookie("orderState", "update");
        cookie.setMaxAge(10*60);
        response.addCookie(cookie);         
        response.sendRedirect("show?id="+id);
      
    }

}
