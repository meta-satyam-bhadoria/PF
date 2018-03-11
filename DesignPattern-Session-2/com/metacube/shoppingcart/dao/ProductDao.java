package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;

/**
 * this interface contains methods for product
 * @author satyam bhadoria
 *
 */
public interface ProductDao extends BaseDao<Product> {
	
	/**
	 * Method which add product item
	 * @param item - product object
	 */
	public void addItem(Product item);
	
	/**
	 * Method which remove product item
	 * @param item - product item
	 */
	public void removeItem(Product item);
	
	/**
	 * Method which update the product item details
	 * @param item - product object
	 * @param name - name of product
	 * @param price - price of product
	 * @param stock - quantity of product available
	 */
	public void updateItem(Product item, String name, float price, int stock);
}
