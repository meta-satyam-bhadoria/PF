package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.dao.ProductDaoFactory;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

/**
 * This class gets the data from controller and perform some operation and pass to the dao layer.
 * @author Satyam Bhadoria
 *
 */
public class ProductFacade {
	private static ProductFacade productFacade;
	private BaseDao<Product> productDao = ProductDaoFactory.getInstance(DatabaseEnum.IN_MEMORY);
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private ProductFacade() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return - object of this class
	 */
	public static ProductFacade getInstance() {
		
		if(productFacade == null){
			productFacade = new ProductFacade();
		}
		return productFacade;
	}
	
	/**
	 * Method which send command to dao to add product after performing some operation
	 * @param product - product object
	 */
	public void addItem(Product product) {
		
		if(!searchProduct(product.getId())){
			((InMemoryProductDao) productDao).addItem(product);
		}
	}
	
	/**
	 * Method which send command to dao to remove product after performing some operation
	 * @param productId - id of product
	 */
	public void removeItem(String productId) {
		
		if (searchProduct(productId)) {
			((InMemoryProductDao) productDao).removeItem(getProduct(productId));
		}
	}
	
	/**
	 * Method which search for product that it is available or not
	 * @param productId - id of product
	 * @return - true or false
	 */
	public boolean searchProduct(String productId){
		return productDao.getList().containsKey(productId);
	}
	
	/**
	 * Method which send command to dao layer to return list of products
	 * @return - list of product came from dao layer
	 */
	public List<Product> getList(){
		return new ArrayList<>(productDao.getList().values());
	}
	
	/**
	 * Method which update details of product with the help of dao
	 * @param productId - id of product
	 * @param name - name of product
	 * @param price - price of product
	 * @param stock - total quantity of that product
	 */
	public void updateItem(String productId, String name, float price, int stock){
		
		if (searchProduct(productId)) {
			((ProductDao) productDao).updateItem(getProduct(productId), name, price, stock);
		}
	}
	
	/**
	 * Method which return product object came from dao
	 * @param productId - id of product
	 * @return - product object
	 */
	public Product getProduct(String productId) {
		return ((InMemoryProductDao) productDao).getProduct(productId);
	}
}