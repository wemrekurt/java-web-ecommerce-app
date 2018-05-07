package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Customer;

 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table customer
 * in the database.
 * @author www.codejava.net
 *
 */
public class CustomerDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CustomerDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (name, email, password, birthday) VALUES (?, ?, ?, ?)";
        connect();        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getEmail());
        statement.setString(3, customer.getPassword());
        statement.setString(4, customer.getBirthday());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public int countCustomer() throws SQLException {
    	String sql = "SELECT COUNT(*) AS toplam FROM customers";
    	 connect();
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);                  
         ResultSet resultSet = statement.executeQuery();
         if(resultSet.next())
        	 return resultSet.getInt("toplam"); 
    	 return 0;
    }
     
    public List<Customer> listAllCustomers() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();
         
        String sql = "SELECT * FROM customers";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");            
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");            
            String birthday = resultSet.getString("birthday");
             
            Customer customer = new Customer(id, name, email, password, birthday);
            listCustomer.add(customer);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCustomer;
    }
     
    public boolean deleteCustomer(Customer customer) throws SQLException {
        String sql = "DELETE FROM customers where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, customer.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCustomer(Customer customer) throws SQLException {
    	//FIXME: check password empty
        String sql = "UPDATE customers SET name = ?, email = ?, password = ?, birthday = ?";
        sql += " WHERE id = ?";
        connect();
         
       
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getEmail());
        statement.setString(3, customer.getPassword());
        statement.setString(4, customer.getBirthday());
        statement.setInt(5, customer.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    
     
    public Customer getCustomer(int id) throws SQLException {
        Customer customer = null;
        String sql = "SELECT * FROM customers WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");            
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");            
            String birthday = resultSet.getString("birthday");
             
            customer = new Customer(id, name, email, password, birthday);
        }
         
        resultSet.close();
        statement.close();
         
        return customer;
    }
}