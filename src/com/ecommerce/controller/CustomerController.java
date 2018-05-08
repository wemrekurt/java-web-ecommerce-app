package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;

public class CustomerController {
	private static final long serialVersionUID = 1L;
    public CustomerDao customerDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public CustomerController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        customerDAO = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
        
    }
    
    public void showCustomer()
    		throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	System.out.println(id);    	
        Customer existingCustomer = customerDAO.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
        
    }
    
    public void listCustomer()
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDAO.listAllCustomers();
        
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showNewForm()
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showEditForm()
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerDAO.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
 
    }
 
    public void insertCustomer()
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        //FIXME: encrypt to md5
        // FIXME: create auth_key
        String auth_key = "";
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
 
        Customer newCustomer = new Customer(name, email, password, birthday, auth_key);
        customerDAO.insertCustomer(newCustomer);
        response.sendRedirect("list");
    }
 
    public void updateCustomer()
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String auth_key = request.getParameter("auth_key");
        
        Customer customer = new Customer(id, name, email, password, birthday, auth_key);
        customerDAO.updateCustomer(customer);
        response.sendRedirect("list");
    }
 
    public void deleteCustomer()
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Customer customer = new Customer(id);
        customerDAO.deleteCustomer(customer);
        response.sendRedirect("list");
 
    }
}
