package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.ShoppingCart;

public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	public void updateItem(ShoppingCart item);
}
