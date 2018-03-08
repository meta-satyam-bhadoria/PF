package com.metacube.shoppingcart.view;

import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;

public class Input {
	
	/* sonarLint 
	 * old code - Scanner input (It's confusing to have a class member with the same name (case differences aside) as its enclosing class)
	 * new code - Scanner inputScanner
	 * */
	Scanner inputScanner  = new Scanner(System.in);
	
	public boolean takeInput(int choice){
		Controller control = Controller.getInstance();
		
		switch (choice) {
			case 1:
				System.out.println("Product List\nId\tName\t\tPrice\t\tStock");
				for(Product p: control.getProductList()){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				break;
				
			case 2:
				System.out.println("Enter name, price and stock of product");
				Product item = new Product(inputScanner.next(), inputScanner.nextFloat(), inputScanner.nextInt());
				control.add(item);
				break;
				
			case 3:
				System.out.println("S.No.\tName");
				List<Product> productList = control.getProductList();
				for(Product p: productList){
					System.out.println(p.getId()+"\t"+p.getName());
				}
				System.out.println("Enter S.No. of product to delete");
				int selected = inputScanner.nextInt();
				control.remove(productList.get(selected - 1));
				break;
				
			case 4:
				System.out.println("S.No.\tName");
				productList = control.getProductList();
				for(Product p: productList){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				System.out.println("Enter S.No. of product to update");
				selected = inputScanner.nextInt();
				System.out.println("Enter name, price and stock to update");
				control.update(productList.get(selected - 1), inputScanner.next(), inputScanner.nextFloat(), inputScanner.nextInt());
				break;
				
			case 5:
				System.out.println("Enter email id, password and name of user");
				User user = new User(inputScanner.next(), inputScanner.next(), inputScanner.next());
				control.add(user);
				break;
				
			case 6:
				System.out.println("S.No.\tName");
				List<User> userList = control.getUserList();
				for(User p: userList){
					System.out.println(p.getId()+"\t"+p.getName());
				}
				System.out.println("Enter S.No. of user to update");
				selected = inputScanner.nextInt();
				System.out.println("Enter name email and password to update");
				control.update(userList.get(selected - 1), inputScanner.next(), inputScanner.next(), inputScanner.next());
				break;
				
			case 7:
				System.out.println("User List\nId\t\tName\t\tEmail\t\tPassword");
				userList = control.getUserList();
				for(User p: userList){
					System.out.println(p.getId()+"\t\t"+p.getName()+"\t\t"+p.getEmail()+"\t\t"+p.getPassword());
				}
				break;
				
			case 8:
				System.out.println("Enter username and password");
				if(!cartShopping(inputScanner.next())){
					System.out.println("No username found. Try again!");
				}
				break;
				
			default:
				return false;
		}
		return true;
	}
	
	private boolean cartShopping(String userName){
		
		CartController cartControl = CartController.getInstance();
		if( cartControl.checkUser(userName)){
			do{
				System.out.println("1. Add product");
				System.out.println("2. Remove product");
				System.out.println("3. checkout");
			}while(shoppingCart(cartControl, userName));
			return true;
		}
		return false;
	}
	
	private boolean shoppingCart(CartController cartController, String userName){
		switch(inputScanner.nextInt()){
			case 1:
				System.out.println("Product List\nId\tName\t\tPrice\t\tStock");
				Controller control = Controller.getInstance();
				List<Product> list = control.getProductList();
				for(Product p: list){
					System.out.println(p.getId()+"\t"+p.getName()+"\t\t"+p.getPrice()+"\t\t"+p.getStock());
				}
				System.out.println("Enter S.No. of product and quantity to add to cart");
				cartController.addToCart(userName, list.get(inputScanner.nextInt()), inputScanner.nextInt());
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				return false;
		}
		return true;
	}
}
