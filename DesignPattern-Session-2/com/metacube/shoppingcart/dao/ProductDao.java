package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;

public interface ProductDao<T extends BaseDao<? super T>> {
	public void updateItem(T item);
}
