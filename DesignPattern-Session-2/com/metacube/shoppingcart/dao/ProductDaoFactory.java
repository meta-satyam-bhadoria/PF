package com.metacube.shoppingcart.dao;

public class ProductDaoFactory {
	
	private static BaseDao baseDao;
	private ProductDaoFactory() {}
	
	public static BaseDao getInstance(DatabaseEnum type) {
		switch(type){
		case in_memory:
			baseDao = InMemoryProductDao.getInstance();
			break;
		case sql:
			baseDao = null;
			break;
		}
		return baseDao;
	}
}
