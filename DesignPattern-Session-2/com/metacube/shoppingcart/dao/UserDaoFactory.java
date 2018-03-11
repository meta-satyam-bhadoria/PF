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
		switch(type){
			case in_memory:
				baseUserDao = InMemoryUserDao.getInstance();
				break;
			case sql:
				baseUserDao = null;
				break;
			}
		return baseUserDao;
	}
}
