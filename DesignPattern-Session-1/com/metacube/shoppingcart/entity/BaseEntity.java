package com.metacube.shoppingcart.entity;

/**
 * this class contains the common data member and method which will inherited by another class
 * @author Satyam Bhadoria
 *
 */
public class BaseEntity {
	private String id ;
	private String name;
	
	/**
	 * constructor
	 * @param id - id of item
	 * @param name - name of item
	 */
	public BaseEntity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * getter for returning name of item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for set the name of item
	 * @param name - name of item
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for returning the id of item
	 * @return id of item
	 */
	public String getId() {
		return id;
	}	
}