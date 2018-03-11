package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

/**
 * this class is used to return the object of InMemoryProductDao object
 * @author satyam bhadoria
 *
 */
public class ProductDaoFactory {
	
	private static BaseDao<Product> baseProductDao;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private ProductDaoFactory() {}
	
	/**
	 * Method which returns the object of InMemoryProductDao
	 * @param type - database type
	 * @return baseProductDao object
	 */
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
