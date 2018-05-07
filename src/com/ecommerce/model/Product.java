package com.ecommerce.model;

public class Product {
	protected int id;
	protected String name;
	protected float price;
	protected String description;
	protected String image;
	
	public Product() {
    }
 
    public Product(int id) {
        this.id = id;
    }
 
    public Product(int id, String name, String description, String image, float price) {
        this(name, description, image, price);
        this.id = id;
    }
     
    public Product(String name, String description, String image, float price) {
        this.name= name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
