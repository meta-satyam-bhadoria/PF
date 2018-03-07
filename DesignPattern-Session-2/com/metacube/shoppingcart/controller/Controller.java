package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;

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
	UserFacade userFacade = UserFacade.getInstance();
	
	
	
	
	public void add(Product item){
		productFacade.addItem(item);
	}
	
	public void remove(Product item) {
		productFacade.removeItem(item);
	}
	
	public void update(Product item, String name, float price, int stock){
		productFacade.updateItem(item, name, price, stock);
	}
	
	public List<Product> getProductList() {
		return productFacade.getList();
	}
	
	
	
	
	
	public void add(User item){
		userFacade.addItem(item);
	}
	
	public void remove(User item) {
		userFacade.removeItem(item);
	}
	
	public void update(User item, String name, String email, String password){
		userFacade.updateItem(item, name, email, password);
	}
	
	public List<User> getUserList() {
		return userFacade.getList();
	}
}
