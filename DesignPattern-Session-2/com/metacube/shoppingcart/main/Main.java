package com.metacube.shoppingcart.main;

import java.util.Scanner;
import com.metacube.shoppingcart.view.Input;

public class Main {
	public static void main(String[] args){
		Scanner inputScanner  = new Scanner(System.in);
		Input shop = new Input();
		do{
			System.out.println("1. Show All Products");
			System.out.println("2. Add Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Update Product");
			System.out.println("5. Show Cart Products");
			System.out.println("Enter ur choice");
			int choice = inputScanner.nextInt();
			if(choice <= 0 && choice < 5){
				break;
			}
			shop.takeInput(choice);
		}while(true);
		inputScanner.close();
	}
}
