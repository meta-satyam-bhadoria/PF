package com.metacube.shoppingcart.view;

import java.util.Scanner;

import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.entity.Product;

public class Input {
	static Scanner input  = new Scanner(System.in);
	public void takeInput(){
		int choice;
		do{
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. Show Products");
			System.out.println("Enter ur choice");
			choice = input.nextInt();
			switch(choice) {
				case 1: 
					String name = input.next();
					float price = input.nextFloat();
					Controller control = new Controller();
					control.addProduct(name, price);
					break;
				case 2: 
					// delete product
				case 3:
					// update product
				case 4: 
					Controller control1 = new Controller();
					for(Product s: control1.getAll()){
						System.out.println(s.getName()+"  "+s.getPrice());
					}
					break;
				default:
					System.exit(0);
			}
		}while(true);
	}
}
