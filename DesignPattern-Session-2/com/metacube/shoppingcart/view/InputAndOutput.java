package com.metacube.shoppingcart.view;

import java.util.Map;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;

public class InputAndOutput {
	
	/* sonarLint 
	 * old code - Scanner input (It's confusing to have a class member with the same name (case differences aside) as its enclosing class)
	 * new code - Scanner inputScanner
	 * */
	Scanner inputScanner  = new Scanner(System.in);
	
	public boolean takeInput(int choice){
		Controller control = Controller.getInstance();
		
		switch (choice) {
			case 1:
				System.out.println("Enter name, price and stock of product");
				Product item = new Product(inputScanner.next(), inputScanner.nextFloat(), inputScanner.nextInt());
				control.add(item);
				break;
				
			case 2:
				System.out.println("Id\tName");
				for(Product p: control.getProductList()){
					System.out.println(p.getId()+"\t"+p.getName());
				}
				System.out.println("Enter Id of product to delete");
				control.removeProduct(inputScanner.next());
				break;
				
			case 3:
				System.out.println("Id\tName\t\tPrice\t\tStock");
				for(Product p: control.getProductList()){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				System.out.println("Enter Id, name, price and stock of product to update");
				control.update(inputScanner.next(), inputScanner.next(), inputScanner.nextFloat(), inputScanner.nextInt());
				break;
				
			case 4:
				System.out.println("Product List\n\nId\tName\t\tPrice\t\tStock");
				for(Product p: control.getProductList()){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				break;
				
			case 5:
				System.out.println("Enter email id, password and name of user");
				User user = new User(inputScanner.next(), inputScanner.next(), inputScanner.next());
				control.add(user);
				break;
				
			case 6:
				System.out.println("Id\t\tName");
				for(User p: control.getUserList()){
					System.out.println(p.getId()+"\t"+p.getName());
				}
				System.out.println("Enter Id of user to remove");
				control.removeUser(inputScanner.next());
				break;
				
			case 7:
				System.out.println("S.No.\tName");
				for(User p: control.getUserList()){
					System.out.println(p.getId()+"\t"+p.getName());
				}
				System.out.println("Enter Id, name email and password of user to update");
				control.update(inputScanner.next(), inputScanner.next(), inputScanner.next(), inputScanner.next());
				break;
				
			case 8:
				System.out.println("User List\nId\t\t\tName\t\tEmail\t\t\tPassword");
				for(User p: control.getUserList()){
					System.out.println(p.getId()+"\t\t\t"+p.getName()+"\t\t"+p.getEmail()+"\t\t\t"+p.getPassword());
				}
				break;
				
			case 9:
				System.out.println("Enter username and password");
				if(!cartShopping(inputScanner.next())){
					System.out.println("No username found. Try again!");
				}
				break;
				
			case 0:
				break;
				
			default:
				return false;
		}
		return true;
	}
	
	protected boolean cartShopping(String userName){
		
		CartController cartControl = CartController.getInstance();
		if( cartControl.checkUser(userName)){
			do{
				System.out.println("1. Add product");
				System.out.println("2. Remove product");
				System.out.println("3. Show cart");
				System.out.println("4. Exit from shopping");
			}while(shoppingCart(cartControl, userName));
			return true;
		}
		return false;
	}
	
	protected boolean shoppingCart(CartController cartController, String userName){
		switch(inputScanner.nextInt()){
			case 1:
				System.out.println("Product List\nId\tName\t\tPrice\t\tStock");
				Controller control = Controller.getInstance();
				for(Product p: control.getProductList()){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				System.out.println("Enter S.No. of product and quantity to add to cart");
				cartController.addToCart(userName, Integer.toString(inputScanner.nextInt()), inputScanner.nextInt());
				break;
			case 2:
				System.out.println("Enter Id of product to remove");
				cartController.remove(inputScanner.next(), userName);
				break;
			case 3:
				System.out.println("Your cart contains");
				ShoppingCart cart = cartController.getCart(userName);
				System.out.println("Id\tName\t\tQuantity\t\tPrice\t\tTotal");
				for(Map.Entry<Product, Float> p : cart.getProductSubTotal().entrySet()) {
					System.out.println(p.getKey().getId()+"\t"+p.getKey().getName()+"\t\t"+cart.getQuantity(p.getKey())+"\t\t"+p.getKey().getPrice()+"\t\t"+p.getValue());
				}
				System.out.println("\t\t\t\t\t\tTotal Price= \t"+cart.getTotal());
				break;
			default:
				return false;
		}
		return true;
	}
}
