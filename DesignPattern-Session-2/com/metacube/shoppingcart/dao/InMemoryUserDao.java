package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.User;

/**
 * this class performs operation like add, remove, update, search etc without 
 * check of logic is correct or not
 * @author satyam bhadoria
 *
 */
public class InMemoryUserDao implements UserDao{
	private Map<String, User> userMap = new HashMap<>();
	private static InMemoryUserDao data;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private InMemoryUserDao() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return InMemoryUserDao - object of this class
	 */
	public static InMemoryUserDao getInstance() {
		
		if(data == null){
			data = new InMemoryUserDao();
		}
		return data;
	}
	
	/**
	 * Method which return the map of user
	 * @return map of user
	 */
	public Map<String, User> getList() {
		return userMap;
	}
	
	/**
	 * Method which add user into the map
	 * @param user - user object
	 */
	public void addItem(User user){
		userMap.put(user.getId(), user);
	}
	
	/**
	 * Method which removes user from the map
	 * @param user - user object
	 */
	public void removeItem(User user) {
		userMap.remove(user.getId());
	}
	
	/**
	 * Method which upadte the user details
	 * @param item - user object
	 * @param name - name of user
	 * @param email - email id of user
	 * @param password - password of user
	 */
	public void updateItem(User item, String name, String email, String password) {
		item.setEmail(email);
		item.setName(name);
		item.setPassword(password);
	}
	
	/**
	 * Method which return the user object using user id
	 * @param userId - id of user
	 * @return user object
	 */
	public User getUser(String userId) {
		return userMap.get(userId);
	}
}
