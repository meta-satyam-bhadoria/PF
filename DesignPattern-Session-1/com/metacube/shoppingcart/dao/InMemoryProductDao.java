package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;


import com.metacube.shoppingcart.entity.Product;

/**
 * This class performs basic function for inmemory storage
 * @author satyam bhadoria
 *
 */
public class InMemoryProductDao implements BaseDao {
	
	Map<Integer , Product> allProducts = new HashMap<>();

	/**
	 * this method returns list of products
	 * @return - list of products
	 */
	public Map<Integer, Product> getAll() {
		return this.allProducts;
	}

	/**
	 * This method add the product in the list
	 * @param product - product object
	 */
	public StatusEnum addProduct(Product product) {
		this.allProducts.put(product.getId(), product);
		return StatusEnum.PRODUCT_ADDED;
	}
	
	/**
	 * This method removes the product using product id
	 * @param productId - id of product
	 */
	public void removeProduct(int productId) {
		allProducts.remove(productId);
	}

	/**
	 * this method updates the product
	 * @param productId - id of product
	 * @param productName - name of product
	 * @param price - price of product
	 */
	public void updateProduct(int productId, String productName, float price) {
		Product product = allProducts.get(productId);
		product.setName(productName);
		product.setPrice(price);
	}
	
}
