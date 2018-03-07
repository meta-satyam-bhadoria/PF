package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.dao.ShoppingCartDaoFactory;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class ShoppingCartFacade {
private static ShoppingCartFacade data;
	
	public static ShoppingCartFacade getInstance() {
		
		if(data == null){
			data = new ShoppingCartFacade();
		}
		return data;
	}
	
	private ShoppingCartFacade() {}
	
	BaseDao<ShoppingCart> baseDao = (InMemoryShoppingCartDao) ShoppingCartDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	public void addItem(ShoppingCart item) {
		if(!searchShoppingCart(item)){
			baseDao.addItem(item);
		}
	}
	
	public void removeItem(ShoppingCart item) {
		if(searchShoppingCart(item)){
			baseDao.removeItem(item);
		}
	}
	
	private boolean searchShoppingCart(ShoppingCart item){
		List<ShoppingCart> list = baseDao.getList();
		return list.contains(item);
	}
	
	public List<ShoppingCart> getList(){
		return baseDao.getList();
	}

}
