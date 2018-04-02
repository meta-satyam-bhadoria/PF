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
		
		if(type == DatabaseEnum.IN_MEMORY) { 
			baseProductDao = InMemoryProductDao.getInstance();
			
		} else if(type == DatabaseEnum.SQL) {
			baseProductDao = null;
		}
				
		return baseProductDao;
	}
}
