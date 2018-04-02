package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.User;

/**
 * this interface contains method which will get implemented in another class which inherits this
 * @author satyam bhadoria
 *
 */
public interface UserDao extends BaseDao<User>{
	
	/**
	 * Method which add user
	 * @param user - user object
	 */
	public void addItem(User user);
	
	/**
	 * Method which remove user
	 * @param user - user object
	 */
	public void removeItem(User user);
	
	/**
	 * Method which update user details
	 * @param user - user object
	 * @param name - name of user
	 * @param email - email of user
	 * @param password - password of user
	 */
	public void updateItem(User user, String name, String email, String password);
}
