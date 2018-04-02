package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

/**
 * this interface contains method which will get implemented in another class which inherits this
 * @author satyam bhadoria
 *
 */
public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	
	/**
	 * method which create cart for user
	 * @param userId - user id 
	 * @param cart - cart object
	 */
	public void createCart(String userId, ShoppingCart cart);
	
	/**
	 * Method which remove product from cart
	 * @param product - product object
	 * @param userId - id of user
	 */
	public void removeItem(Product product, String userId);
}
