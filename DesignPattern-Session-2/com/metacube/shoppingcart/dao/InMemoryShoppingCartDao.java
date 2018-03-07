package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public List<ShoppingCart> getList() {
		return new ArrayList<>(shoppingCartMap.values());
	}
	
	public void addItem(ShoppingCart item){
		shoppingCartMap.put(item.getName(), item);
	}
	
	public void removeItem(ShoppingCart item) {
		shoppingCartMap.remove(item.getId());
	}
	
	public void updateItem(ShoppingCart item) {
		
	}
}
