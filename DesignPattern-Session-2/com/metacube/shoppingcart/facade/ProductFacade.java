package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
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
		if(!searchProduct(item.getId())){
			baseDao.addItem(item);
		}
	}
	
	public void removeItem(String productId) {
		if (searchProduct(productId)) {
			baseDao.removeItem(getProduct(productId));
		}
	}
	
	public boolean searchProduct(String slNo){
		return baseDao.getList().containsKey(slNo);
	}
	
	public List<Product> getList(){
		return new ArrayList<>(baseDao.getList().values());
	}
	
	public void updateItem(String productId, String name, float price, int stock){
		if (searchProduct(productId)) {
			((ProductDao) baseDao).updateItem(getProduct(productId), name, price, stock);
		}
	}
	
	public Product getProduct(String slNo) {
		return ((InMemoryProductDao) baseDao).getProduct(slNo);
	}
}
