package com.metacube.shoppingcart.view;

import java.util.Map;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.ProductController;
import com.metacube.shoppingcart.controller.UserController;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;

/**
 * This class is used to take input and give output
 * @author Satyam Bhadoria
 *
 */
public class InputAndOutput {
	
	Scanner input  = new Scanner(System.in);
	
	/**
	 * Method which perform operation on the basis of selected choice
	 * @param choice - choice selected
	 * @return true or false
	 */
	public boolean takeInput(int choice) {
		ProductController productController = ProductController.getInstance();
		UserController userController = UserController.getInstance();
		
		switch(choice) {
			case 1:
				System.out.println("Enter name, price and stock of product");
				Product item = new Product( input.next(), input.nextFloat(), input.nextInt() );
				productController.add(item);
				break;
				
			case 2:
				System.out.println("Id\tName");
				
				for( Product p: productController.getProductList() ) {
					System.out.println( p.getId() + "\t" + p.getName() );
				}
				System.out.println("Enter Id of product to delete");
				productController.removeProduct( input.next() );
				break;
				
			case 3:
				System.out.println("Id\tName\t\tPrice\t\tStock");
				
				for( Product p: productController.getProductList() ) {
					System.out.println( p.getId() + "\t" + p.getName() + "\t\t" + p.getPrice() + "\t\t" + p.getStock());
				}
				System.out.println("Enter Id, name, price and stock of product to update");
				productController.update( input.next(), input.next(), input.nextFloat(), input.nextInt());
				break;
				
			case 4:
				System.out.println("Product List\n\nId\tName\t\tPrice\t\tStock");
				for( Product p: productController.getProductList() ) {
					System.out.println( p.getId() + "\t" + p.getName() + "\t\t" + p.getPrice() + "\t\t" + p.getStock());
				}
				break;
				
			case 5:
				System.out.println("Enter email id, password and name of user");
				User user = new User( input.next(), input.next(), input.next());
				userController.add(user);
				break;
				
			case 6:
				System.out.println("Id\t\tName");
				
				for( User p: userController.getUserList() ) {
					System.out.println( p.getId() + "\t" + p.getName() );
				}
				System.out.println("Enter Id of user to remove");
				userController.removeUser( input.next() );
				break;
				
			case 7:
				System.out.println("S.No.\tName");
				
				for( User p: userController.getUserList() ) {
					System.out.println( p.getId() + "\t" + p.getName() );
				}
				System.out.println("Enter Id, name email and password of user to update");
				userController.update(input.next(), input.next(), input.next(), input.next());
				break;
				
			case 8:
				System.out.println("User List\nId\t\t\tName\t\tEmail\t\t\tPassword");
				
				for( User p: userController.getUserList() ) {
					System.out.println( p.getId() + "\t\t\t" + p.getName() + "\t\t" + p.getEmail() + "\t\t\t" + p.getPassword() );
				}
				break;
				
			case 9:
				System.out.println("Enter username and password");
				if( !cartShopping( input.next() )) {
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
	
	/**
	 * Method which shows the option for shopping cart
	 * @param userId - user id 
	 * @return true or false
	 */
	public boolean cartShopping(String userId) {
		
		CartController cartControl = CartController.getInstance();
		
		if( cartControl.checkUser(userId) ) {
			
			do {
				System.out.println("1. Add product");
				System.out.println("2. Remove product");
				System.out.println("3. Show cart");
				System.out.println("4. Exit from shopping");
			} while( shoppingCart(cartControl, userId) );
			return true;
		}
		return false;
	}
	
	/**
	 * Method which perform operation on the basis of selected choice
	 * @param cartController - controller for shopping cart
	 * @param userId - id of user
	 * @return true or false
	 */
	public boolean shoppingCart(CartController cartController, String userId) {
		switch( input.nextInt() ) {
			case 1:
				System.out.println("Product List\nId\tName\t\tPrice\t\tStock");
				ProductController control = ProductController.getInstance();
				
				for( Product p: control.getProductList() ) {
					System.out.println( p.getId() + "\t" + p.getName() + "\t\t" + p.getPrice() + "\t\t" + p.getStock() );
				}
				System.out.println("Enter S.No. of product and quantity to add to cart");
				cartController.addToCart( userId, Integer.toString(input.nextInt()), input.nextInt());
				break;
				
			case 2:
				System.out.println("Enter Id of product to remove");
				cartController.remove( input.next(), userId );
				break;
				
			case 3:
				System.out.println("Your cart contains");
				ShoppingCart cart = cartController.getCart(userId);
				System.out.println("Id\tName\t\tQuantity\t\tPrice\t\tTotal");
				
				for( Map.Entry<Product, Float> p : cart.getProductSubTotal().entrySet()) {
					System.out.println( p.getKey().getId() + "\t" + p.getKey().getName() + "\t\t" + cart.getQuantity( p.getKey() ) 
										+ "\t\t" + p.getKey().getPrice() + "\t\t" + p.getValue() );
				}
				System.out.println("\t\t\t\t\t\tTotal Price= \t" + cart.getTotal() );
				break;
				
			default:
				return false;
		}
		return true;
	}
}
