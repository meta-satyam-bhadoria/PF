package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

public class InMemoryShoppingCartDao implements ShoppingCartDao{
	Map<String, ShoppingCart> shoppingCartMap = new HashMap<>();
	
	
	private static InMemoryShoppingCartDao data;
	private InMemoryShoppingCartDao() {}
	public static InMemoryShoppingCartDao getInstance() {
		
		if(data == null){
			data = new InMemoryShoppingCartDao();
		}
		return data;
	}
	
	
	public Map<String, ShoppingCart> getList() {
		return shoppingCartMap;
	}
	
	public void createCart(String userId, ShoppingCart cart){
		shoppingCartMap.put(userId, cart);
	}
	
	public void addItem(String userId, Product item, int quantity, float subTotal, float total){
		shoppingCartMap.get(userId).setQuantity(item, quantity);
		shoppingCartMap.get(userId).setSubTotal(item, subTotal);
		shoppingCartMap.get(userId).setTotal(total);
	}
	
	public void removeItem(String slNo) {
		shoppingCartMap.remove(slNo);
	}
	
	public void updateItem(ShoppingCart item) {
		
	}
	
	public ShoppingCart returnCart(String userId) {
		return shoppingCartMap.get(userId);
	}
	
	public void addItem(ShoppingCart cart) {
		
	}
}
