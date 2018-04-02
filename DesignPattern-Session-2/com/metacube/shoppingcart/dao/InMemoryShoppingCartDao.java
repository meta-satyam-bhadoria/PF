package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

/**
 * this class performs operation like add, remove, update, search etc without 
 * check of logic is correct or not
 * @author satyam bhadoria
 *
 */
public class InMemoryShoppingCartDao implements ShoppingCartDao{
	private Map<String, ShoppingCart> shoppingCartMap = new HashMap<>();
	private static InMemoryShoppingCartDao data;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private InMemoryShoppingCartDao() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return InMemoryShoppingCartDao - object of this class
	 */
	public static InMemoryShoppingCartDao getInstance() {
		
		if(data == null){
			data = new InMemoryShoppingCartDao();
		}
		return data;
	}
	
	/**
	 * Method which return map of shopping cart
	 * @return shopping cart map
	 */
	public Map<String, ShoppingCart> getList() {
		return shoppingCartMap;
	}
	
	/**
	 * 
	 */
	public void createCart(String userId, ShoppingCart cart){
		shoppingCartMap.put(userId, cart);
	}
	
	/**
	 * Method which add product item in shopping cart
	 * @param userId - id of user
	 * @param item - product object
	 * @param quantity - quantity of product
	 * @param totalOfProduct - amount of particular product
	 */
	public void addItem(String userId, Product item, int quantity, float totalOfProduct){
		shoppingCartMap.get(userId).setQuantity(item, quantity);
		shoppingCartMap.get(userId).setSubTotal(item, totalOfProduct);
	}
	
	/**
	 * Method which remove product item from shopping cart
	 * @param productId - id of product
	 * @param usesrId - id of user
	 */
	public void removeItem(Product productId, String userId) {
		shoppingCartMap.get(userId).removeProduct(productId);
	}
	
	/**
	 * Method which return cart object of particular user
	 * @param userId - id of user
	 * @return shopping cart object
	 */
	public ShoppingCart returnCart(String userId) {
		return shoppingCartMap.get(userId);
	}
	
	/**
	 * Method which update total amount of all products in cart
	 * @param totalAmount - total amount of products
	 * @param userId - id of user
	 */
	public void updateTotal(float totalAmount, String userId){
		shoppingCartMap.get(userId).setTotal(totalAmount);
	}
}