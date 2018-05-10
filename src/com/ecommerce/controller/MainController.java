package com.ecommerce.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.google.gson.Gson;
import com.ecommerce.helper.UserSession;
import com.ecommerce.helper.Hash;
import com.ecommerce.helper.Pair;
import com.ecommerce.helper.Basket;
import com.ecommerce.helper.Biscuit;
import com.ecommerce.helper.Element;

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
    	
    	int product_id = Integer.parseInt(request.getParameter("product_id"));
    	int qty = Integer.parseInt(request.getParameter("qty"));
    	
    	List<Element> list = new ArrayList<Element>();
    	list.add(new Element(product_id, qty));
    	String json = new Gson().toJson(list);
    	
    	Biscuit cookie = new Biscuit(request.getCookies());   
    	Basket basket = new Basket(cookie);
    	basket.add(product_id, qty);
    	
    	Cookie cook = new Cookie("basket", basket.save());
    	cook.setMaxAge(10*60);
        response.addCookie(cook);    	
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    public void showCreateAccount()
    		throws SQLException, IOException, ServletException {
    	UserSession chkuser = new UserSession(request.getSession());
    	if(chkuser.logged_in()) {
    		response.sendRedirect("./hesap");
    	}else {    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("show_create_account.jsp");
    		dispatcher.forward(request, response);        
    	}
    }
    
    
    public void showLogin() 
    		throws SQLException, IOException, ServletException {
    	UserSession chkuser = new UserSession(request.getSession());
    	if(chkuser.logged_in()) {
    		response.sendRedirect("./hesap");
    	}else {    		
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("show_login.jsp");
	        dispatcher.forward(request, response);
    	}
    }
    
    public void showAccount() throws SQLException ,ServletException, IOException {
    	UserSession chkuser = new UserSession(request.getSession());
    	if(chkuser.logged_in()) {
    		// int user_id = Integer.parseInt();
    		// Customer user = customerDAO.getCustomer(user_id);
    		int user_id = (Integer) request.getSession().getAttribute("user_id");
    		Customer user = customerDAO.getCustomer(user_id);
    		request.setAttribute("user", user);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("hesap.jsp");
    		dispatcher.forward(request, response);
    	}else {    		
    		response.sendRedirect("./giris-yap");
    	}
    }
    
    public void logOut() throws SQLException ,ServletException, IOException {
    	UserSession user = new UserSession(request.getSession());
    	user.log_out();
    	response.sendRedirect("./giris-yap");
    }
    
    public void doLogin() throws SQLException, IOException, ServletException, NoSuchAlgorithmException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.length() > 0 && password.length() > 0) {
        	Customer user = customerDAO.find_by_email(email);
        	if(user.getId() > 0) {       		
        		
        		Hash hashed_password = new Hash(password);
        		password = hashed_password.getHash();
        		
        		if(password.equals(user.getPassword())) {
        			Hash randomHash = new Hash();
            		String auth_key = randomHash.getHash();
            		
            		UserSession session = new UserSession(request.getSession(), auth_key, user.getName(), user.getId());
            		user.setAuth_key(auth_key);
            		customerDAO.updateCustomer(user);
                	response.sendRedirect("./");
        		}else {
        			request.setAttribute("show_error", true);
                	request.setAttribute("error", "Hatalı parola!");
                	RequestDispatcher dispatcher = request.getRequestDispatcher("/show_login.jsp");
                    dispatcher.forward(request, response);   
        		}
        	}else {
        		request.setAttribute("show_error", true);
            	request.setAttribute("error", "Sistemde böyle bir kullanıcı kaydı bulamadık");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/show_login.jsp");
                dispatcher.forward(request, response);   
        	}
        }else {
        	request.setAttribute("show_error", true);
        	request.setAttribute("error", "Lütfen tüm alanları doldurun");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/show_login.jsp");
            dispatcher.forward(request, response);   
        }
    }
    
    public void createCustomer()
    		throws SQLException, IOException, ServletException, NoSuchAlgorithmException {
    	String birthday = "";
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        //FIXME: encrypt to md5
        String password = request.getParameter("password");
        String password_confirmation = request.getParameter("password_confirmation");
        if(request.getParameterMap().containsKey("birthday") && (request.getParameter("birthday").length() > 0) ) {        	
        	birthday = request.getParameter("birthday");
        }       
        System.out.println(birthday);
        
        request.setAttribute("name", name);
    	request.setAttribute("email", email);
    	
        if(password.equals(password_confirmation)) {
        	if(name.length() > 0 && email.length() > 0) {
            	
        		Customer chkuser = customerDAO.find_by_email(email);
            	if(chkuser.getId() > 0) {
            		request.setAttribute("show_error", true);
            		request.setAttribute("error", "Bu e-posta adresi ile sistemimizde kayıtlı bir kullanıcı bulunmakta.");
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/show_create_account.jsp");
                    dispatcher.forward(request, response);    
            	}else {
            		Hash randomHash = new Hash();
            		String auth_key = randomHash.getHash();
            		
            		Hash hashed_password = new Hash(password);
            		password = hashed_password.getHash();
            		
            		Customer newCustomer = new Customer(name, email, password, birthday, auth_key);
                    int insertCustomer = customerDAO.insertCustomer(newCustomer);
                    
                    if(insertCustomer > 0) {
                    	UserSession session = new UserSession(request.getSession(), auth_key, name, insertCustomer);                	
                    	response.sendRedirect("./");
                    }else {
                    	request.setAttribute("show_error", true);
                		request.setAttribute("error", "Sistem hatası! Hesap oluşturulamadı");
                		RequestDispatcher dispatcher = request.getRequestDispatcher("/show_create_account.jsp");
                        dispatcher.forward(request, response);    
                    }	
            	}
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
