package com.ecommerce.model;

public class Customer {
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected String birthday;
	protected String auth_key;
	
	public Customer() {
    }
 
    public Customer(int id) {
        this.id = id;
    }

	public Customer(String name, String email, String password, String birthday, String auth_key) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.auth_key = auth_key;
    }

	public Customer(int id, String name, String email, String password, String birthday, String auth_key) {
        this(name, email, password, birthday, auth_key);
        this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
    public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}


	
}
