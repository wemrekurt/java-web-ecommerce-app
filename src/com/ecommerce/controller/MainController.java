package com.ecommerce.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.helper.UserSession;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDAO;
    private CustomerDao customerDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public MainController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
    	
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        productDAO = new ProductDao(jdbcURL, jdbcUsername, jdbcPassword);
        customerDAO = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public void index() 
    		throws SQLException, IOException, ServletException {
    	
		List<Product> listProduct = productDAO.listAllProducts();        
        request.setAttribute("products", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);        
	}
    
    public void addToBasket()
    		throws SQLException, IOException, ServletException {
    	   System.out.println();
    }
    
    public void showCreateAccount()
    		throws SQLException, IOException, ServletException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("show_create_account.jsp");
        dispatcher.forward(request, response);        
    }
    
    public void doLogin() {
    	
    }
    
    public void showLogin() 
    		throws SQLException, IOException, ServletException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("show_login.jsp");
        dispatcher.forward(request, response);
    }
    
    public void createCustomer()
    		throws SQLException, IOException, ServletException, NoSuchAlgorithmException {
    	String birthday = "";
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        //FIXME: encrypt to md5
        String password = request.getParameter("password");
        String password_confirmation = request.getParameter("password_confirmation");
        if(request.getParameterMap().containsKey("birthday")) {        	
        	birthday = request.getParameter("birthday");
        }
        
        
        request.setAttribute("name", name);
    	request.setAttribute("email", email);
    	
        if(password.equals(password_confirmation)) {
        	if(name.length() > 0 && email.length() > 0) {
            	
        		Random rand = new Random();
        		int  n = rand.nextInt(99999) + 999;
        		String x = Integer.toString(n);
        		byte[] bytesOfMessage = x.getBytes("UTF-8");
        		
        		MessageDigest md = MessageDigest.getInstance("MD5");
        		byte[] digest = md.digest(bytesOfMessage);
        		String auth_key = new String(digest, StandardCharsets.UTF_8);

        		Customer newCustomer = new Customer(name, email, password, birthday, auth_key);
                customerDAO.insertCustomer(newCustomer);
                
    			UserSession session = new UserSession(request.getSession(), auth_key, name);
    			
                response.sendRedirect("./");
                
        	}else {
        		request.setAttribute("show_error", true);
        		request.setAttribute("error", "İsim ve E-posta zorunludur");
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/show_create_account.jsp");
                dispatcher.forward(request, response);    
        	}
        }else {        	
        	request.setAttribute("show_error", true);
        	request.setAttribute("error", "Parolalar Eşleşmiyor");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/show_create_account.jsp");
            dispatcher.forward(request, response);     
        }
        
    }
    
}
