package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

/**
 * this class is used to return the object of InMemoryUserDao object
 * @author satyam bhadoria
 *
 */
public class UserDaoFactory {
	private static BaseDao<User> baseUserDao;
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private UserDaoFactory() {}
	
	/**
	 * Method which returns the object of InMemoryUserDao
	 * @param type - database type
	 * @return - baseUserDao object
	 */
	public static BaseDao<User> getInstance(DatabaseEnum type) {

		if(type == DatabaseEnum.IN_MEMORY) { 
			baseUserDao = InMemoryUserDao.getInstance();
			
		} else if(type == DatabaseEnum.SQL) {
			baseUserDao = null;
		}
		return baseUserDao;
	}
}
