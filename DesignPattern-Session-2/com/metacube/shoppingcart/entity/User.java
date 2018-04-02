package com.metacube.shoppingcart.entity;

/**
 * This class contains the details about the user
 * @author Satyam Bhadoria
 *
 */
public class User extends BaseEntity{
	private String password;
	private String email;
	
	/**
	 * constructor
	 * @param email - email id of user
	 * @param password - password of user
	 * @param name - name of user
	 */
	public User(String email, String password, String name){
		super(email, name);
		this.email = email;
		this.password = password;
	}

	/**
	 * getter for returning password of user
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * setter for setting password of user
	 * @param password - password of user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * getter for returning the email of user
	 * @return email of user
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setter for setting the email id of user
	 * @param email - email id of user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
