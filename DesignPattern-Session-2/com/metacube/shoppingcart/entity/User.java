package com.metacube.shoppingcart.entity;

public class User extends BaseEntity{
	private String password;
	private String email;
	
	public User(String email, String password, String name){
		super(email, name);
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
