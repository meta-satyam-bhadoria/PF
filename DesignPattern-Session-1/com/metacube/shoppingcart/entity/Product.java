package com.metacube.shoppingcart.entity;

/**
 * this class sets or gets the product entities like name, id, price etc
 * @author satyam bhadoria
 *
 */
public class Product {
	private static int countId = 0;
	private int id;
	private String name;
	private float price;
	
	/**
	 * constructor for iniating the entities
	 * @param name - name of product
	 * @param price - price of product
	 */
	public Product(String name, float price){
		this.name = name;
		this.price = price;
		this.id = countId++;
	}
	
	/**
	 * gets the product price
	 * @return - price of product
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * sets the price of product
	 * @param price - product price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * gets the product id
	 * @return - id of product
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * gets the product name
	 * @return - name of product
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of product
	 * @param name - product name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
