package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.DatabaseEnum;
import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductDaoFactory;
import com.metacube.shoppingcart.entity.Product;

public class ProductFacade {
	private static ProductFacade data;
	
	public static ProductFacade getInstance() {
		
		if(data == null){
			data = new ProductFacade();
		}
		return data;
	}
	
	private ProductFacade() {}
	
	BaseDao baseDao = (InMemoryProductDao) ProductDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	public void addItem(Product item) {
		if(!searchProduct(item)){
			baseDao.addItem(item);
		}
	}
	
	private boolean searchProduct(Product item){
		List<Product> list = baseDao.getList();
		return list.contains(item);
	}
	
	public List<Product> getList(){
		return baseDao.getList();
	}
}
