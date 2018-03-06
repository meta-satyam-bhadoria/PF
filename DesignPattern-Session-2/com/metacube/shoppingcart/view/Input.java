package com.metacube.shoppingcart.view;

import java.util.Scanner;

import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.entity.Product;

public class Input {
	
	/* sonarLint 
	 * old code - Scanner input (It's confusing to have a class member with the same name (case differences aside) as its enclosing class)
	 * new code - Scanner inputScanner
	 * */
	Scanner inputScanner  = new Scanner(System.in);
	
	public void takeInput(int choice){
		Controller control = Controller.getInstance();
		
		switch (choice) {
		case 1:
			System.out.println(control.getList());
			break;
		case 2:
			Product item = new Product(inputScanner.next(), inputScanner.nextFloat(), inputScanner.nextInt());
			control.addItem(item);
			break;
		default:
			break;
		}
	}
}
