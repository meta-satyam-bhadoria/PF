package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;

public class InMemoryProductDao implements ProductDao{
	Map<String, Product> productMap = new HashMap<>();
	
	
	private static InMemoryProductDao data;
	private InMemoryProductDao() {}
	public static InMemoryProductDao getInstance() {
		
		if(data == null){
			data = new InMemoryProductDao();
		}
		return data;
	}
	
	
	public List<Product> getList() {
		return new ArrayList<>(productMap.values());
	}
	
	public void addItem(Product item){
		productMap.put(item.getId(), item);
	}
	
	public void removeItem(Product item) {
		productMap.remove(item.getId());
	}
	
	public void updateItem(Product item, String name, float price, int stock) {
		item.setName(name);
		item.setPrice(price);
		item.setStock(stock);
	}
}
