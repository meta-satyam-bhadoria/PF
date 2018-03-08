package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	public void updateItem(ShoppingCart item);
	public void createCart(String userId, ShoppingCart cart);
	public void removeItem(Product item, String userId);
}
