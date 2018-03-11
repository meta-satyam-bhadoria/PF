package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

/**
 * this class is used to return the object of InMemoryShoppingCartDao object
 * @author satyam bhadoria
 *
 */
public class ShoppingCartDaoFactory {
	private static BaseDao<ShoppingCart> baseShoppingCartDao;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private ShoppingCartDaoFactory() {}
	
	/**
	 * Method which returns the object of InMemoryShoppingCartDao
	 * @param type - database type
	 * @return baseShoppingCartDao object
	 */
	public static BaseDao<ShoppingCart> getInstance(DatabaseEnum type) {
		switch(type){
			case in_memory:
				baseShoppingCartDao = InMemoryShoppingCartDao.getInstance();
				break;
			case sql:
				baseShoppingCartDao = null;
				break;
			}
		return baseShoppingCartDao;
	}
}
