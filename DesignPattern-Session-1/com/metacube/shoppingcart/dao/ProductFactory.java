package com.metacube.shoppingcart.dao;

/**
 * This class is used to return storage instance type 
 * like inmemory or database type
 * @author satyam bhadoria
 *
 */
public class ProductFactory{
	private static BaseDao baseDao;
	
	/**
	 * This method returns instance of storage type
	 * @param dbName - storage type
	 * @return - instance of storage type
	 */
	public static BaseDao getInstance(DatabaseEnum dbName) {
		
		switch(dbName){
			case IN_MEMORY : baseDao = new InMemoryProductDao();
							return baseDao;
			case SQL : return null;
		}
	return null;	
	}
	
	/**
	 * private constructor to restrict creating object from using new keyword
	 */
	private ProductFactory() {}
}
