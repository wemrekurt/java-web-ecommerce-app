package com.ecommerce.helper;

import javax.servlet.http.HttpSession;

public class UserSession {
	private HttpSession session;
	
	public UserSession(HttpSession session) {  			
		session.setMaxInactiveInterval(30*60*60);
	}
	
	public UserSession(HttpSession session, String auth_key, String name) {
		this.session = session;
		session.setAttribute("user_auth", auth_key);
		session.setAttribute("username", name);    			
		session.setMaxInactiveInterval(30*60*60);
	}
	
	
	public void checkUser() {
		
	}
	
	
}
