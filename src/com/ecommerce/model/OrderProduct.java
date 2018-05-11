package com.ecommerce.model;

public class OrderProduct {
	protected int id;
	protected int product_id;
	protected int order_id;
	protected Product product;
	protected Order order;
	protected int size;
	protected float unit_price;
	
	public OrderProduct() {
    }
 
    public OrderProduct(int id) {
        this.id = id;
    }
    public OrderProduct(int id, int size, float unit_price, int product_id, int order_id) {
        this.id = id;
        this.size = size;
        this.unit_price = unit_price;
        this.product_id = product_id;
        this.order_id = order_id;
    }
    
    public OrderProduct(int id, int size, float unit_price, Product product, Order order) {
    	this.id = id;
    	this.size = size;
    	this.unit_price = unit_price;
    	this.product = product;
    	this.product_id = product.getId();
    	this.order_id = order.getId();
    	this.order = order;
    }

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
   
     
}
