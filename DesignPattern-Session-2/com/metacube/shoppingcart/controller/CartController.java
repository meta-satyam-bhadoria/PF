package com.metacube.shoppingcart.controller;

import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
import com.metacube.shoppingcart.facade.UserFacade;

/**
 * This class is used to control the data transfer between view and facade layer for shopping cart
 * This class is singleton class
 * @author Satyam Bhadoria
 *
 */
public class CartController {
	private static CartController cartSingletonObject;
	private ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
	private UserFacade userFacade = UserFacade.getInstance();
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private CartController() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return cartSingletonObject - object of this class
	 */
	public static CartController getInstance() {
		
		if(cartSingletonObject == null){
			cartSingletonObject = new CartController();
		}
		return cartSingletonObject;
	}
	
	/**
	 * Method to check for user is available or not
	 * @param userId - id of user
	 * @return true or false
	 */
	public boolean checkUser (String userId){
		return userFacade.checkUser(userId);
	}
	
	/**
	 * Method which send request to facade to add item to cart
	 * @param userId - id of user
	 * @param productId - id of product
	 * @param quantity - quantity of product to be added
	 */
	public void addToCart(String userId, String productId, int quantity ){
		shoppingCartFacade.addItem(userId, productId, quantity);
	}
	
	/**
	 * Method which send request to facade to remove item from cart
	 * @param productId - id of product
	 * @param userId - id of user
	 */
	public void remove(String productId, String userId) {
		shoppingCartFacade.removeItem(productId, userId);
	}
	
	/**
	 * Method which send request to facade to return the list of products in cart
	 * @param userId - id of user
	 * @return - object of shopping cart which contains list of products with details
	 */
	public ShoppingCart getCart(String userId){
		return shoppingCartFacade.getCart(userId);
	}
}
