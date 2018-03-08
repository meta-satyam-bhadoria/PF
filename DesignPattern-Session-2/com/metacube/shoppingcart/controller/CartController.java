package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class CartController {
	private static CartController data;
	
	public static CartController getInstance() {
		
		if(data == null){
			data = new CartController();
		}
		return data;
	}
	
	private CartController() {}
	
	
	ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
	UserFacade userFacade = UserFacade.getInstance();
	
	public boolean checkUser (String userName){
		return userFacade.checkUser(userName);
	}
	
	
	public void addToCart(String userId, String productId, int quantity ){
		shoppingCartFacade.addItem(userId, productId, quantity);
		System.out.println("cart controler "+userId+"  "+productId+"   "+ quantity);
	}
	
	public void remove(String productId, String userId) {
		shoppingCartFacade.removeItem(productId, userId);
	}
	
	public List<ShoppingCart> getShoppingCartList() {
		return shoppingCartFacade.getList();
	}
	
	public ShoppingCart getCart(String userId){
		return shoppingCartFacade.getCart(userId);
	}
}
