package com.ecommerce.model;

import com.ecommerce.model.Customer;

public class Order {
	protected int id;
	protected String num;
	protected String date;
	protected float total;
	protected int address_id;
	protected int customer_id;
	protected Customer customer;
	protected int state;
	
	public Order() {
    }
 
    public Order(int id) {
        this.id = id;
    }
    
    public Order(int id, String num, String date, float total, int address_id, int customer_id, int state, Customer customer) {
        this(id, num, date, total, address_id, customer_id, state);
        this.customer = customer;
    }
    
    public Order(int id, String num, String date, float total, int address_id, int customer_id, int state) {
        this(num, date, total, address_id, customer_id, state);
        this.id = id;
    }
     
    public Order(String num, String date, float total, int address_id, int customer_id, int state) {
        this.num = num;
        this.date = date;
        this.total = total;
        this.address_id = address_id;
        this.customer_id = customer_id;
        this.state = state;
    }
    
    public String showState() {
    	if(state == 1)
    		return "Onay Bekliyor";
    	else if(state == 2)
    		return "Onaylandı";
    	else if(state == 3)
    		return "Paketleniyor";
    	else if(state == 4)
    		return "Kargoya Verildi";
    	else if(state == 5)
    		return "Teslim Edildi";
    	else
    		return "Onay Bekliyor";
    }

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
