package com.metacube.shoppingcart.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart extends BaseEntity {
	private static int countId = 1;
	private float total;
	private Map<Product, Float> subTotal = new HashMap<>();
	private Map<Product, Integer> list= new HashMap<>();

	public ShoppingCart(String name, Product item, int quantity) {
		super(Integer.toString(countId++), name);
		this.total = 0;
		this.list.put(item, quantity);
		this.list.put(item, 0);
	}
	
	public Map<Product,Integer> getProductQuantity() {
		return list;
	}
	
	public Map<Product, Float> getProductSubTotal(){
		return subTotal;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getQuantity(Product item) {
		return list.get(item);
	}

	public void setQuantity(Product item, int quantity) {
		this.list.replace(item, quantity);
	}
}
