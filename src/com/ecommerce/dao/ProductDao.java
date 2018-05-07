package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.model.Product;

 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table product
 * in the database.
 * @author www.codejava.net
 *
 */
public class ProductDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ProductDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
    	
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {                
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, description, price, image) VALUES (?, ?, ?, ?)";
        connect();        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setFloat(3, product.getPrice());
        statement.setString(4, product.getImage());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public int countProduct() throws SQLException {
    	String sql = "SELECT COUNT(*) AS toplam FROM products";
    	 connect();
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);                  
         ResultSet resultSet = statement.executeQuery();
         if(resultSet.next())
        	 return resultSet.getInt("toplam"); 
    	 return 0;
    }
     
    public List<Product> listAllProducts() throws SQLException {
        List<Product> listProduct = new ArrayList<>();
         
        String sql = "SELECT * FROM products";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");            
            String description = resultSet.getString("description");
            float price = resultSet.getFloat("price");
            String image = resultSet.getString("image");
             
            Product product = new Product(id, name, description, image, price);
            listProduct.add(product);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listProduct;
    }
     
    public boolean deleteProduct(Product product) throws SQLException {
        String sql = "DELETE FROM products where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, product.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, image = ?";
        sql += " WHERE id = ?";
        connect();
         
       
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setFloat(3, product.getPrice());
        statement.setString(4, product.getImage());
        statement.setInt(5, product.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    
     
    public Product getProduct(int id) throws SQLException {
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            float price = resultSet.getFloat("price");
            String image = resultSet.getString("image");
             
            product = new Product(id, name, description, image, price);
        }
         
        resultSet.close();
        statement.close();
         
        return product;
    }
}