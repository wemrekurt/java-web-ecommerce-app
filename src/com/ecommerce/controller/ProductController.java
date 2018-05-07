package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDAO;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public ProductController(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;
    	this.response = response;
        String jdbcURL = "jdbc:mysql://localhost/java_ecommerce?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
 
        productDAO = new ProductDao(jdbcURL, jdbcUsername, jdbcPassword);
        
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
        List<Product> listProduct = productDAO.listAllProducts();
        
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showNewForm()
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showEditForm()
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
 
    }
 
    public void insertProduct()
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        //String image = request.getParameter("image");
        // Image
 
        Product newProduct = new Product(name, description, "", price);
        productDAO.insertProduct(newProduct);
        response.sendRedirect("list");
    }
 
    public void updateProduct()
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("image");
 
        Product product = new Product(id, name, description, image, price);
        productDAO.updateProduct(product);
        response.sendRedirect("list");
    }
 
    public void deleteProduct()
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Product product = new Product(id);
        productDAO.deleteProduct(product);
        response.sendRedirect("list");
 
    }
}
