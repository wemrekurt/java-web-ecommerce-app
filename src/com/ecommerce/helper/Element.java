package com.ecommerce.helper;

public class Element {
	int product_id;
	int qty;
	
	public Element(int id, int quantity) {
		this.product_id = id;
		this.qty = quantity;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}



}
