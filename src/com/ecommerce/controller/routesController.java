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
        try {
            switch (action) {
            case "/show":
            	product.showProduct();
            	break;
            case "/admin/":
            	product.showAdmin();
            	break;
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
            	product.adminListProduct();
                break;
            case "/admin/customer/show":
                customer.showCustomer();
                break;          
            default:
                System.out.println("default");
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
