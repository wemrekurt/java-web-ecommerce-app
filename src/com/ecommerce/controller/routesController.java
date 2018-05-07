package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.ProductController;
import com.ecommerce.controller.AdminController;

public class routesController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        CustomerController customer = new CustomerController(request, response);
        ProductController product = new ProductController(request, response);
        AdminController admin = new AdminController(request, response);
        try {
            switch (action) {
            case "/show":
            	product.showProduct();
            	break;
        	// Admin
            case "/404":
            	showErrorPage(request, response);
            	break;
            case "/admin/":
            	admin.showAdmin();
            	break;
        	// Order Admin
            case "/admin/order/list":
            	admin.listOrder();
            	break;
        	// Product Admin
            case "/admin/product/show":
            	break;
            case "/admin/product/new":
                product.showNewForm();
                break;
            case "/admin/product/insert":
                product.insertProduct();
                break;
            case "/admin/product/delete":
                product.deleteProduct();
                break;
            case "/admin/product/edit":
                product.showEditForm();
                break;
            case "/admin/product/update":
                product.updateProduct();
                break;
            case "/admin/product/list":
            	admin.listProduct();
                break;
            // Customer Admin
            case "/admin/customer/show":
            	break;
            case "/admin/customer/new":
            	customer.showNewForm();
                break;
            case "/admin/customer/insert":
            	customer.insertCustomer();
                break;
            case "/admin/customer/delete":
            	customer.deleteCustomer();
                break;
            case "/admin/customer/edit":
            	customer.showEditForm();
                break;
            case "/admin/customer/update":
            	customer.updateCustomer();
                break;
            case "/admin/customer/list":
            	admin.listCustomer();
                break;  
            default:
            	String path = request.getContextPath();
            	response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", path + "/404");  
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	public void showErrorPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("NotFound.jsp");
        dispatcher.forward(request, response);
    }
	
	
}
