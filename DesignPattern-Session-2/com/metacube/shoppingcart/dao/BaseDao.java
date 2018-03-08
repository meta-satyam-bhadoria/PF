package com.metacube.shoppingcart.dao;

import java.util.Map;

public interface BaseDao<T>{

	public void addItem(T item);
	
	public void removeItem(String slNo);

	public Map<String, T> getList();
	
}
