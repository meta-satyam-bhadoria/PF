package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
import com.metacube.shoppingcart.facade.UserFacade;

/**
 * This class is used to control the data transfer between view and facade layer for user and products
 * This class is singleton class
 * @author Satyam Bhadoria
 *
 */
public class Controller {
	private static Controller controllerSingletonObject;
	private ProductFacade productFacade = ProductFacade.getInstance();
	private UserFacade userFacade = UserFacade.getInstance();
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private Controller() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return controllerSingletonObject - object of this class
	 */
	public static Controller getInstance() {
		
		if(controllerSingletonObject == null){
			controllerSingletonObject = new Controller();
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
	
	/**
	 * Method which send request to facade to add user and also create cart for that user
	 * @param user - user object
	 */
	public void add(User user){
		userFacade.addItem(user);
		ShoppingCart cart = userFacade.createUserCart(user);
		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		shoppingCartFacade.createCart(user.getEmail(), cart);
	}
	
	/**
	 * Method which send request to facade to remove user
	 * @param userId - id of user
	 */
	public void removeUser(String userId) {
		userFacade.removeItem(userId);
	}
	
	/**
	 * Method which send request to facade to update details of user
	 * @param userId - id of user
	 * @param name - name of user
	 * @param email - email of user
	 * @param password - password of user
	 */
	public void update(String userId, String name, String email, String password){
		userFacade.updateItem(userId, name, email, password);
	}
	
	/**
	 * Method which send request to facade to return the list of user
	 * @return- list of user
	 */
	public List<User> getUserList() {
		return userFacade.getList();
	}
}
