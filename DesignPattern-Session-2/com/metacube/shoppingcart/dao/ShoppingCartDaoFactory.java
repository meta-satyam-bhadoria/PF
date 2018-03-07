package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class ShoppingCartDaoFactory {
	private static BaseDao<ShoppingCart> baseShoppingCartDao;
	private ShoppingCartDaoFactory() {}
	
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
