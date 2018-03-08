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
	
	public void addItem(String userId, String productId, int quantity ) {
		if (ProductFacade.getInstance().searchProduct(productId)){
			System.out.println("product found "+userId+"  "+productId+"   "+ quantity);
			
			if (ProductFacade.getInstance().getProduct(productId).getStock() >= quantity){
				System.out.println("quantity suffi"+userId+"  "+productId+"   "+ quantity);
				
				ShoppingCart cart = ((InMemoryShoppingCartDao) baseDao).returnCart(userId);
				ProductFacade.getInstance().getProduct(productId).setStock(quantity);
				
				if(searchInShoppingCart(productId, userId)){
					quantity = cart.getQuantity(ProductFacade.getInstance().getProduct(productId)) + quantity;
				}
				float subTotal = ProductFacade.getInstance().getProduct(productId).getPrice() * quantity;
				((InMemoryShoppingCartDao) baseDao).addItem(userId, ProductFacade.getInstance().getProduct(productId), quantity, subTotal);
				
				float total = 0;
				for(Map.Entry<Product, Float> p: cart.getProductSubTotal().entrySet()){
					total += p.getValue();
				}
				((InMemoryShoppingCartDao) baseDao).updateTotal(total, userId);
			}
			else{
				System.out.println("not suffi quant");
			}
		}
		else{
			System.out.println("product not found in shop facade");
		}
	}
	
	public void createCart(String userId, ShoppingCart cart) {
		((ShoppingCartDao) baseDao).createCart(userId, cart);
	}
	
	public void removeItem(String productId, String userId) {
		if(searchInShoppingCart(productId, userId)){
			((ShoppingCartDao) baseDao).removeItem(ProductFacade.getInstance().getProduct(productId), userId);
			
			float total = 0;
			for(Map.Entry<Product, Float> p: ((InMemoryShoppingCartDao) baseDao).returnCart(userId).getProductSubTotal().entrySet()){
				total += p.getValue();
			}
			((InMemoryShoppingCartDao) baseDao).updateTotal(total, userId);
		}
	}
	
	private boolean searchInShoppingCart(String slNo, String userId){
		Product item = ProductFacade.getInstance().getProduct(slNo);
		if(item != null) {
				return ((InMemoryShoppingCartDao) baseDao).returnCart(userId).getProductQuantity().containsKey(item);
		}
		return false;
	}
	
	public List<ShoppingCart> getList(){
		return new ArrayList<>(baseDao.getList().values());
	}
	
	public ShoppingCart getCart(String userId){
		return ((InMemoryShoppingCartDao) baseDao).returnCart(userId);
	}

}
