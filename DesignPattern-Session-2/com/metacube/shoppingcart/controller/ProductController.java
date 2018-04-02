package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.facade.ProductFacade;

/**
 * This class is used to control the data transfer between view and facade layer for user and products
 * This class is singleton class
 * @author Satyam Bhadoria
 *
 */
public class ProductController {
	private static ProductController controllerSingletonObject;
	private ProductFacade productFacade = ProductFacade.getInstance();
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private ProductController() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return controllerSingletonObject - object of this class
	 */
	public static ProductController getInstance() {
		
		if(controllerSingletonObject == null){
			controllerSingletonObject = new ProductController();
		}
		return controllerSingletonObject;
	}
	
	/**
	 * Method which send request to facade to add product in memory
	 * @param item - product object
	 */
	public void add(Product item){
		productFacade.addItem(item);
	}
	
	/**
	 * Method which send request to facade to remove product from memory
	 * @param productId - id product
	 */
	public void removeProduct(String productId) {
		productFacade.removeItem(productId);
	}
	
	/**
	 * Method which send request to facade to update details of product in memory
	 * @param productId - id of product
	 * @param name - name of product
	 * @param price - price of product
	 * @param stock - total quantity of that product available
	 */
	public void update(String productId, String name, float price, int stock){
		productFacade.updateItem(productId, name, price, stock);
	}
	
	/**
	 * Method which send request to facade to return the list of products
	 * @return - list of products
	 */
	public List<Product> getProductList() {
		return productFacade.getList();
	}
}
