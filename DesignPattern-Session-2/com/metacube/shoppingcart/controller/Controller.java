package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.facade.ProductFacade;

public class Controller {

	private static Controller data;
	
	public static Controller getInstance() {
		
		if(data == null){
			data = new Controller();
		}
		return data;
	}
	
	private Controller() {}
	
	ProductFacade productFacade = ProductFacade.getInstance();
	
	public void addItem(Product item){
		productFacade.addItem(item);
	}
	
	public List<Product> getList() {
		return productFacade.getList();
	}
}
