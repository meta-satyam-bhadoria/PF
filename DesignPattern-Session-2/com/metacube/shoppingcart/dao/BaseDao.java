package com.metacube.shoppingcart.dao;

import java.util.Map;

/**
 * main interface for dao layer
 * @author Satyam Bhadoria
 *
 * @param <T>
 */
public interface BaseDao<T>{

	public void addItem(T item);
	
	public void removeItem(T item);

	public Map<String, T> getList();
	
}
