package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
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
	
	private ProductFacade productFacade = ProductFacade.getInstance();
	private UserFacade userFacade = UserFacade.getInstance();
	
	
	
	
	public void add(Product item){
		productFacade.addItem(item);
	}
	
	public void removeProduct(String productId) {
		productFacade.removeItem(productId);
	}
	
	public void update(String productId, String name, float price, int stock){
		productFacade.updateItem(productId, name, price, stock);
	}
	
	public List<Product> getProductList() {
		return productFacade.getList();
	}
	
	
	
	
	
	public void add(User item){
		userFacade.addItem(item);
		ShoppingCart cart = userFacade.createUserCart(item);
		System.out.println("new cart created for user" + cart);
		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		shoppingCartFacade.createCart(item.getEmail(), cart);
		
	}
	
	public void removeUser(String userId) {
		userFacade.removeItem(userId);
	}
	
	public void update(String userId, String name, String email, String password){
		userFacade.updateItem(userId, name, email, password);
	}
	
	public List<User> getUserList() {
		return userFacade.getList();
	}
}
