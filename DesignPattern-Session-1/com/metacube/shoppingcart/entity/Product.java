package com.metacube.shoppingcart.entity;

/**
 * This class contains the details about the product
 * @author Satyam Bhadoria
 *
 */
public class Product extends BaseEntity{
	private static int countId = 1;
	private float priceOfProduct;
	private int stockAvailable;
	
	/**
	 * constructor
	 * @param name - name of product
	 * @param price - price of product
	 * @param stock - stock of product
	 */
	public Product(String name, float price, int stock) {
		super(Integer.toString(countId++), name);
		this.priceOfProduct = price;
		this.stockAvailable = stock;
	}

	/**
	 * getter for returning the product price
	 * @return price of product
	 */
	public float getPrice() {
		return priceOfProduct;
	}

	/**
	 * setter for setting the price of product
	 * @param price - price of product
	 */
	public void setPrice(float price) {
		this.priceOfProduct = price;
	}

	/**
	 * getter for returning stock of product
	 * @return stock of product
	 */
	public int getStock() {
		return stockAvailable;
	}

	/**
	 * setter for stock to update when some product id purchased
	 * @param stock - quantity which have been reduced from product's stock
	 */
	public void setStock(int stock) {
		this.stockAvailable -= stock;
	}
	
	/**
	 * setter to update the stock of product
	 * @param quantity - quantity of product which is available
	 */
	public void setUpdatedStock(int quantity){
		this.stockAvailable = quantity;
	}
}
