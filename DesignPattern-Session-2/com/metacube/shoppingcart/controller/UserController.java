package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
import com.metacube.shoppingcart.facade.UserFacade;

/**
 * This class is used to control the data transfer between view and facade layer for user
 * This class is singleton class
 * @author Satyam Bhadoria
 *
 */
public class UserController {
	private static UserController userControllerObject;
	private UserFacade userFacade = UserFacade.getInstance();
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private UserController() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return userControllerObject - object of this class
	 */
	public static UserController getInstance() {
		
		if(userControllerObject == null){
			userControllerObject = new UserController();
		}
		return userControllerObject;
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
