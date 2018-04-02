package com.metacube.shoppingcart.dao;

import java.util.Map;

/**
 * main interface for dao layer
 * @author Satyam Bhadoria
 *
 * @param <T> generic parameter
 */
public interface BaseDao<T>{

	/**
	 * Method which return the list
	 * @return list of item like user list, product list etc.
	 */
	public Map<String, T> getList();
	
}
