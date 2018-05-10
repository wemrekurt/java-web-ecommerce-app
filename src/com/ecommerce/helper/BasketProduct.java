package com.ecommerce.helper;

import com.ecommerce.model.Product;

public class BasketProduct {
	int id;
	Product product;
	int qty;
	
	public BasketProduct (int pr_id, Product pr, int pr_qty) {
		this.id = pr_id;
		this.product = pr;
		this.qty = pr_qty;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
