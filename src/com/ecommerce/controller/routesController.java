package com.ecommerce.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
import com.ecommerce.controller.OrderController;
import com.ecommerce.controller.MainController;

public class routesController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        CustomerController customer = new CustomerController(request, response);
        ProductController product = new ProductController(request, response);
        AdminController admin = new AdminController(request, response);
        OrderController order = new OrderController(request, response);
        MainController main = new MainController(request, response);
		
        try {
            switch (action) {
            case "/siparis-olustur":
            	main.makeOrder();
            	break;
            case "/sepete-ekle":
            	main.addToBasket();
            	break;
            case "/giris":
            	try {
					main.doLogin();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
            	break;
        	case "/create-account":
            	try {
					main.createCustomer();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
            	break;
            case "/admin/order/chstate":
            	order.chOrderState();
            	break;
            case "/admin/product/insert":
                product.insertProduct();
                break;            
            case "/admin/product/upload":
            	product.uploadImage();
            	break;
            case "/admin/product/update":
				product.updateProduct();
				break;            
            // Customer Admin
            case "/admin/customer/insert":
            	customer.insertCustomer();
                break;
            case "/admin/customer/update":
            	customer.updateCustomer();
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        CustomerController customer = new CustomerController(request, response);
        ProductController product = new ProductController(request, response);
        AdminController admin = new AdminController(request, response);
        OrderController order = new OrderController(request, response);
        MainController main = new MainController(request, response);
        
        try {
            switch (action) {
            case "/":
            	main.index();
            	break;
            case "/tum-urunler":
            	main.allProducts();
            	break;
            case "/hesabim/siparis":
            	main.showOrder();
            	break;
            case "/sepet":
            	main.showBasket();
            	break;
            case "/urun":
            	product.showProduct();
            	break;
            case "/hesap-olustur":
            	main.showCreateAccount();
            	break;
            case "/giris-yap":
            	main.showLogin();
            	break;
        	case "/hesap":
        		main.showAccount();
        		break;
    		case "/hesabim/siparisler":
    			main.showOrders();
    			break;
        	case "/cikis":
        		main.logOut();
        		break;
            case "/404":
            	showErrorPage(request, response);
            	break;
	    	// Admin
            case "/admin/":
            	admin.showAdmin();
            	break;
        	// Order Admin
            case "/admin/order/list":
            	admin.listOrder();
            	break;
            case "/admin/order/show":
            	admin.showOrder();
            	break;
            
        	// Product Admin
            case "/admin/product/show":
            	admin.productShow();
            	break;
            case "/admin/product/new":
                product.showNewForm();
                break;
            
            case "/admin/product/delete":
                product.deleteProduct();
                break;
            case "/admin/product/edit":
                product.showEditForm();
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
            case "/admin/customer/delete":
            	customer.deleteCustomer();
                break;
            case "/admin/customer/edit":
            	customer.showEditForm();
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
