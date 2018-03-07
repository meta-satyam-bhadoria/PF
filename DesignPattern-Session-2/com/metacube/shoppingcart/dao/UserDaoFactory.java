package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class UserDaoFactory {
	private static BaseDao<User> baseUserDao;
	private UserDaoFactory() {}
	
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
