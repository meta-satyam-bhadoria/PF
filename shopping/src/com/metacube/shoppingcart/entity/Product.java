package com.metacube.shoppingcart.entity;

public class Product {
	private static int id = 0;
	private String name;
	private float price;
	
	public Product(String name, float price){
		this.name = name;
		this.price = price;
		this.id++;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static int getId() {
		return id;
	}
	public static void setId() {
		Product.id++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
