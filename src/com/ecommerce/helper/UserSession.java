package com.ecommerce.helper;

import javax.servlet.http.HttpSession;

public class UserSession {
	private HttpSession session;
	
	public UserSession(HttpSession session) {  			
		this.session = session;
		session.setMaxInactiveInterval(30*60*60);
	}
	
	public UserSession(HttpSession session, String auth_key, String name, int user_id) {
		this.session = session;
		session.setAttribute("user_auth", auth_key);
		session.setAttribute("user_name", name);
		session.setAttribute("user_id", user_id);
		session.setMaxInactiveInterval(30*60*60);
	}
	
	
	public boolean logged_in() {
		if(this.session.getAttribute("user_auth") == null)
			return false;
		else
			return true;
	}
	
	public void log_out() {
		session.invalidate();
	}

	
	
}
