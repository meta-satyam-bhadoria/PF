package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;

public interface ProductDao extends BaseDao<Product> {
	public void updateItem(Product item, String name, float price, int stock);
}
