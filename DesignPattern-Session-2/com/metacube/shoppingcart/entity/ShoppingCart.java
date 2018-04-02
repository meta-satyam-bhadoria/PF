package com.metacube.shoppingcart.entity;

import java.util.HashMap;
import java.util.Map;
/**
 * this class contains the detail about shopping cart
 * @author Satyam Bhadoria
 *
 */
public class ShoppingCart extends BaseEntity {
	private static int countId = 1;
	private float total;
	private Map<Product, Float> subTotal = new HashMap<>();
	private Map<Product, Integer> list= new HashMap<>();

	/**
	 * constructor
	 * @param email - email id of user
	 */
	public ShoppingCart(String email) {
		super(Integer.toString(countId++), email);
	}

	/**
	 * setter for setting the amount of product purchased
	 * @param productItem - product object
	 * @param subTotal - amount of product purchased
	 */
	public void setSubTotal(Product productItem, float subTotal) {
		this.subTotal.put(productItem, subTotal);
	}

	/**
	 * getter for getting the quantity of product purchased 
	 * @return quantity of product
	 */
	public Map<Product,Integer> getProductQuantity() {
		return list;
	}
	
	/**
	 * getter for getting the amount of product purchased
	 * @return amount
	 */
	public Map<Product, Float> getProductSubTotal(){
		return subTotal;
	}
	
	/**
	 * getter for getting the total amount of product in the cart
	 * @return total amount
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * setter for setting the total amount of product in the cart
	 * @param totalAmount - total amount of product
	 */
	public void setTotal(float totalAmount) {
		this.total = totalAmount;
	}

	/**
	 * getter for returning the quantity of product
	 * @param productItem - product object
	 * @return quantity of product
	 */
	public int getQuantity(Product productItem) {
		return list.get(productItem);
	}

	/**
	 * setter for setting the quantity of product which is been purchased by user
	 * @param productItem - product object which gets purchased
	 * @param quantity - quantity of product which gets purchased
	 */
	public void setQuantity(Product productItem, int quantity) {
		this.list.put(productItem, quantity);
	}
	/**
	 * Method which remove product from cart
	 * @param productItem - product object
	 */
	public void removeProduct(Product productItem){
		this.list.remove(productItem);
		this.subTotal.remove(productItem);
	}
}
