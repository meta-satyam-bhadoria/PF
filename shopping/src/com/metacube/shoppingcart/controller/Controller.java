package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.facade.ProductFacade;

public class Controller {
	ProductFacade productFacade = ProductFacade.getInstance();
	
	
	public void addProduct(String name , float price){
		productFacade.addProduct(name,price);
	}
	
	public List<Product> getAll(){
		return productFacade.getAll();
	}
}
