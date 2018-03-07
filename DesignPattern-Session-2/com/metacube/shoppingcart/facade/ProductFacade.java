package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.dao.ProductDaoFactory;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class ProductFacade {
	private static ProductFacade data;
	
	public static ProductFacade getInstance() {
		
		if(data == null){
			data = new ProductFacade();
		}
		return data;
	}
	
	private ProductFacade() {}
	
	BaseDao<Product> baseDao = (InMemoryProductDao) ProductDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	public void addItem(Product item) {
		if(!searchProduct(item)){
			baseDao.addItem(item);
		}
	}
	
	public void removeItem(Product item) {
		if (searchProduct(item)) {
			baseDao.removeItem(item);
		}
	}
	
	private boolean searchProduct(Product item){
		List<Product> list = baseDao.getList();
		return list.contains(item);
	}
	
	public List<Product> getList(){
		return baseDao.getList();
	}
	
	public void updateItem(Product item, String name, float price, int stock){
		if (searchProduct(item)) {
			((ProductDao) baseDao).updateItem(item, name, price, stock);
		}
	}
}
