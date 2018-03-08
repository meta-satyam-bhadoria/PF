package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.dao.ShoppingCartDao;
import com.metacube.shoppingcart.dao.ShoppingCartDaoFactory;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;
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
	
	public void addItem(String userId, Product item, int quantity ) {
		ShoppingCart cart = ((InMemoryShoppingCartDao) baseDao).returnCart(userId);
		if(ProductFacade.getInstance().searchProduct(item))
	}
	
	public void createCart(String userId, ShoppingCart cart) {
		((ShoppingCartDao) baseDao).createCart(userId, cart);
	}
	public void removeItem(String slNo) {
		if(searchShoppingCart(slNo)){
			baseDao.removeItem(slNo);
		}
	}
	
	private boolean searchInShoppingCart(String slNo){
		Product item = ProductFacade.getInstance().getProduct(slNo);
		if(item != null) {
				if(baseDao.returnCart(sl).getProductQuantity().containsKey(item));
		}
		return false;
	}
	
	public List<ShoppingCart> getList(){
		return new ArrayList<>(baseDao.getList().values());
	}

}
