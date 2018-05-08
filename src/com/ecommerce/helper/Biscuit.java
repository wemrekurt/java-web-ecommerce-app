package com.ecommerce.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Biscuit {
	public Cookie[] cookies;

	public Biscuit(Cookie[] cookies) {
		this.cookies = cookies;  
	}
	
	public String getCookie(String key) {
		if (cookies != null)
       	 for (Cookie cookie : cookies)
       	   if (cookie.getName().equals(key))
       		   return cookie.getValue();
		return "";
	}
	
	public void removeCookie(String key, HttpServletResponse response) {
		if (cookies != null) {			
			for (Cookie cookie : cookies) {	       		 
				if (cookie.getName().equals(key)) {	       		   
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	
}
