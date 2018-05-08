package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Order;
import com.ecommerce.helper.OrderHelper;
import com.ecommerce.helper.Biscuit;

public class AdminController {
	private static final long serialVersionUID = 1L;
    private ProductDao productDAO;
    private CustomerDao customerDAO;
    private OrderDao orderDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public AdminController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        productDAO = new ProductDao(jdbcURL, jdbcUsername, jdbcPassword);
        customerDAO = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword); 
        orderDAO = new OrderDao(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public void showAdmin()
            throws SQLException, IOException, ServletException {
    	request.setAttribute("productSize", productDAO.countProduct());
    	request.setAttribute("customerSize", customerDAO.countCustomer());
    	request.setAttribute("orderSize", orderDAO.count());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
    public void listProduct()
            throws SQLException, IOException, ServletException {
        List<Product> listProduct = productDAO.listAllProducts();
        
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void listCustomer()
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDAO.listAllCustomers();
        
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void listOrder()
            throws SQLException, IOException, ServletException {
        List<Order> listOrder = orderDAO.all();
        
        request.setAttribute("orders", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void showOrder()
            throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.find(id);
        OrderHelper ordhelp = new OrderHelper();
        RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
        Biscuit cookie = new Biscuit(request.getCookies());        
        request.setAttribute("updateCookie", cookie.getCookie("orderState"));
        cookie.removeCookie("orderState", response);
        request.setAttribute("states", ordhelp.states());
        request.setAttribute("order", order);
        dispatcher.forward(request, response);
    }
    
    
}
