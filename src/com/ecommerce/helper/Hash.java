package com.ecommerce.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;

public class Hash {
	
	String hash;

	public Hash(String password)
			throws SQLException, IOException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        this.hash = sb.toString();
	}
	
	public Hash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Random rand = new Random();
		int  n = rand.nextInt(99999) + 999;
		String x = Integer.toString(n);
		byte[] bytesOfMessage = x.getBytes("UTF-8");
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(bytesOfMessage);
		
		byte byteData[] = md.digest();
		
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		this.hash = sb.toString();
	}
	
	public String getHash() {
		return hash;
	}	
	
}
