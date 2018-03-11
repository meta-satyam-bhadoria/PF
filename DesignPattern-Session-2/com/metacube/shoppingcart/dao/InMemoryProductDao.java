package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;

/**
 * this class performs operation like add, remove, update, search etc without 
 * check of logic is correct or not
 * @author satyam bhadoria
 *
 */
public class InMemoryProductDao implements ProductDao{
	private Map<String, Product> productMap = new HashMap<>();
	private static InMemoryProductDao data;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private InMemoryProductDao() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return InMemoryProductDao - object of this class
	 */
	public static InMemoryProductDao getInstance() {
		
		if(data == null){
			data = new InMemoryProductDao();
		}
		return data;
	}
	
	/**
	 * Method which return map of products
	 * @return product map
	 */
	public Map<String, Product> getList() {
		return productMap;
	}
	
	/**
	 * Method which add the product item in the map list
	 * @param item - product object
	 */
	public void addItem(Product item){
		productMap.put(item.getId(), item);
	}
	
	/**
	 * Method which removes product from the map
	 * @param item - product object
	 */
	public void removeItem(Product item) {
		productMap.remove(item.getId());
	}
	
	/**
	 * Method which updates product 
	 * @param item - product object
	 * @param name - name of product
	 * @param price - price of product
	 * @param stock - quantity of product
	 */
	public void updateItem(Product item, String name, float price, int stock) {
		item.setName(name);
		item.setPrice(price);
		item.setUpdatedStock(stock);
	}
	
	/**
	 * Method which get the product object using product id
	 * @param productId - id of product
	 * @return product object
	 */
	public Product getProduct(String productId) {
		return productMap.get(productId);
	}
}