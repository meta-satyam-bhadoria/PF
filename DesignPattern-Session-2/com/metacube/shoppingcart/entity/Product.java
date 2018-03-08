package com.metacube.shoppingcart.entity;

public class Product extends BaseEntity{
	private static int countId = 1;
	private float price;
	private int stock;
	
	public Product(String name, float price, int stock) {
		super(Integer.toString(countId++), name);
		this.price = price;
		this.stock = stock;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock -= stock;
	}
	
	public void setUpdatedStock(int quantity){
		this.stock = quantity;
	}
}
