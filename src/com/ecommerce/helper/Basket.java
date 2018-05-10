package com.ecommerce.helper;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Element> list = new ArrayList<Element>();
	private Biscuit biscuit;
	private String cookie_item;
	
	public Basket(Biscuit cookie) {
		this.biscuit = cookie;
		this.cookie_item = cookie.getCookie("basket");
		
		this.resolve();
	}
	
	private void resolve() {
		if(cookie_item.length() > 0) {
			int id, size;			
			for (String item: cookie_item.split("\\|")) {				
				if(item.length() > 0) {
					String[] prod = item.split(",");
					id = Integer.parseInt(prod[0]);
					size = Integer.parseInt(prod[1]);
					list.add(new Element(id, size));	
				}
			}
		}
	}
	
	public String save() {
		String cook = "";
		for(Element elem: list) 
			cook = cook + Integer.toString(elem.getProduct_id()) + "," + Integer.toString(elem.getQty()) + "|";
		return cook;
	}
	
	public boolean remove(int id) {
		boolean x = false;
		for(Element elem: list) {
			if(elem.getProduct_id() == id) {
				if(list.remove(elem))
					x = true;
				break;
			}
		}
		return x;
	}
	
	public boolean update(int id, int qty) {
		boolean x = false;
		for(Element elem: list) {
			if(elem.getProduct_id() == id) {
				elem.setQty(qty);
				x = true;
				break;
			}
		}
		return x;
	}
	
	public void add(int id, int qty) {
		boolean found = false;
		for(Element elem: list) {
			if(elem.getProduct_id() == id) {
				elem.setQty(elem.getQty() + qty);
				found = true;
				break;
			}
		}
		if(found == false) {			
			list.add(new Element(id, qty));
		}
	}
	
	public List<Element> getItems(){
		return list;
	}
	
}
