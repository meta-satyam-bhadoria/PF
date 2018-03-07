package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class ProductDaoFactory {
	
	private static BaseDao<Product> baseProductDao;
	private ProductDaoFactory() {}
	
	public static BaseDao<Product> getInstance(DatabaseEnum type) {
		switch(type){
		case in_memory:
			baseProductDao = InMemoryProductDao.getInstance();
			break;
		case sql:
			baseProductDao = null;
			break;
		}
		return baseProductDao;
	}
}
