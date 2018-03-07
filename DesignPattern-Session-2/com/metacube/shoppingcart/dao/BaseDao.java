package com.metacube.shoppingcart.dao;

import java.util.List;

public interface BaseDao<T>{

	public void addItem(T item);
	
	public void removeItem(T item);

	public List<T> getList();
	
}
