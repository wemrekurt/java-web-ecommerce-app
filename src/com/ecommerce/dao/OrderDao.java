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
import com.ecommerce.model.Order;
import com.ecommerce.dao.CustomerDao;

public class OrderDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public OrderDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public int create(Order order) throws SQLException {
        String sql = "INSERT INTO orders (num, date, total, address_id, customer_id, status) VALUES (?, NULL, ?, ?, ?, ?)";
        connect();        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, order.getNum());
        statement.setFloat(3, order.getTotal());
        statement.setInt(4, order.getAddress_id());
        statement.setInt(5, order.getCustomer_id());
        statement.setInt(6, order.getState());
        
        int rowInserted =  statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            int id = rs.getInt(1);
            statement.close();
            disconnect();
            return id;
        }
        
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public int create_order_prods(int order_id, int product_id, float unit_price, int size) throws SQLException {
    	String sql = "INSERT INTO order_products (size, unit_price, product_id, order_id) VALUES (?, ?, ?, ?)";
    	connect();        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, size);
        statement.setFloat(2, unit_price);
        statement.setInt(3, product_id);
        statement.setInt(4, order_id);
        
        int rowInserted =  statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            int id = rs.getInt(1);
            statement.close();
            disconnect();
            return id;
        }
        
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public int count() throws SQLException {
    	String sql = "SELECT COUNT(*) AS toplam FROM orders";
    	 connect();
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);                  
         ResultSet resultSet = statement.executeQuery();
         if(resultSet.next())
        	 return resultSet.getInt("toplam"); 
    	 return 0;
    }
     
    public List<Order> all() throws SQLException {
        List<Order> listOrder = new ArrayList<>();
         
        String sql = "SELECT * FROM orders";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String num = resultSet.getString("num");            
            String date = resultSet.getString("date");
            Float total = resultSet.getFloat("total");            
            int address_id = resultSet.getInt("address_id");
            int customer_id = resultSet.getInt("customer_id");
            int state = resultSet.getInt("status");
            
            CustomerDao cdao = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
            Customer customer = cdao.getCustomer(customer_id);
             
            Order order = new Order(id, num, date, total, address_id, customer_id, state, customer);
            listOrder.add(order);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listOrder;
    }
     
    public boolean delete(Order order) throws SQLException {
        String sql = "DELETE FROM orders where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean update(Order order) throws SQLException {
    	//FIXME: check password empty
        String sql = "UPDATE orders SET num = ?, date = ?, total = ?, address_id = ?, customer_id = ?, status = ?";
        sql += " WHERE id = ?";
        connect();
       
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getNum());
        statement.setString(2, order.getDate());
        statement.setFloat(3, order.getTotal());
        statement.setInt(4, order.getAddress_id());
        statement.setInt(5, order.getCustomer_id());
        statement.setInt(6, order.getState());
        statement.setInt(7, order.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }    
    
     
    public Order find(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String num = resultSet.getString("num");            
            String date = resultSet.getString("date");
            Float total = resultSet.getFloat("total");            
            int address_id = resultSet.getInt("address_id");
            int customer_id = resultSet.getInt("customer_id");
            int state = resultSet.getInt("status");
            CustomerDao cdao = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
            Customer customer = cdao.getCustomer(customer_id);
            
            order = new Order(id, num, date, total, address_id, customer_id, state, customer);
        }
         
        resultSet.close();
        statement.close();
         
        return order;
    }
	
}
