package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;

public interface BaseDao<T>{

	public void addItem(T item);

	public List<T> getList();
	
}
