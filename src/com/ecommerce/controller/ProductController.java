package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";
    private ProductDao productDAO;
    private CustomerDao customerDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public ProductController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        productDAO = new ProductDao(jdbcURL, jdbcUsername, jdbcPassword);
        customerDAO = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword); 
    }
 
    
    public void showProduct()
    		throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductShow.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }
    public void listProduct()
            throws SQLException, IOException, ServletException {
    	if(this.is_admin()) {    		
    		List<Product> listProduct = productDAO.listAllProducts();
    		request.setAttribute("listProduct", listProduct);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
    		dispatcher.forward(request, response);
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}
    }
 
    public void showNewForm()
            throws ServletException, IOException, SQLException {
    	if(this.is_admin()) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
	        dispatcher.forward(request, response);
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}
    }
 
    public void showEditForm()
            throws SQLException, ServletException, IOException {
    	if(this.is_admin()) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Product existingProduct = productDAO.getProduct(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
	        request.setAttribute("product", existingProduct);
	        dispatcher.forward(request, response);
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}  
 
    }
    
    public void uploadImage() throws IllegalStateException, IOException, ServletException, SQLException {
    	String strid = request.getParameter("id");
    	int id = Integer.parseInt(strid);
		Product product = productDAO.getProduct(id);
		
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        // System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        String fileName = null;
        

        Part part = request.getPart("image");
        
        fileName = getFileName(part);
        String rename = uploadFilePath + File.separator + strid + ".png";
        part.write(rename);
        String[] extension = fileName.split(".");
        
        //Files.copy(Paths.get(rename), Paths.get("/home/emrek/eclipse-workspace/E-Commerce/WebContent/images/"+strid+".png"), StandardCopyOption.REPLACE_EXISTING);
        response.sendRedirect("./show?id="+strid);
    }
    
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
    
    public void insertProduct()
            throws SQLException, IOException, NumberFormatException, ServletException {
    	if(this.is_admin()) {
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        float price = Float.parseFloat(request.getParameter("price"));	 
	        Product newProduct = new Product(name, description, "", price);
	        productDAO.insertProduct(newProduct);
	        response.sendRedirect("list");
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}  
    }
 
    public void updateProduct()
            throws SQLException, IOException, NumberFormatException, ServletException {
    	if(this.is_admin()) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        float price = Float.parseFloat(request.getParameter("price"));
	        String image = "";  
	
	        Product product = new Product(id, name, description, image, price);
	        productDAO.updateProduct(product);
	        response.sendRedirect("list");
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}  
    }
 
    public void deleteProduct()
            throws SQLException, IOException, NumberFormatException, ServletException {
    	if(this.is_admin()) {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Product product = new Product(id);
	        productDAO.deleteProduct(product);
	        response.sendRedirect("list");
    	}else {
    		response.sendRedirect("/E-Commerce");
    	}  
    }
    
    public boolean is_admin() throws SQLException, IOException, ServletException {
    	if(request.getSession().getAttribute("user_id") == null) {
    		return false;
    	}else {
    		int user_id = (Integer) request.getSession().getAttribute("user_id");
    		Customer user = customerDAO.getCustomer(user_id);
    		if(user.getId() > 0 && user.getRole() > 1) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    }
}
