package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
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
	
	
	public void addToCart(String userId, Product product, int quantity ){
		shoppingCartFacade.addItem(userId, product, quantity);
	}
	
	public void remove(ShoppingCart item) {
		shoppingCartFacade.removeItem(item);
	}
	
	public List<ShoppingCart> getShoppingCartList() {
		return shoppingCartFacade.getList();
	}
}
