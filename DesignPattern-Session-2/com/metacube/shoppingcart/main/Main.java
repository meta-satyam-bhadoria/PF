package com.metacube.shoppingcart.main;

import java.util.Scanner;
import com.metacube.shoppingcart.view.Input;

public class Main {
	public static void main(String[] args){
		Scanner inputScanner  = new Scanner(System.in);
		Input shop = new Input();
		int choice;
		do{
			System.out.println("1. Show all products");
			System.out.println("2. Add product");
			System.out.println("3. Delete product");
			System.out.println("4. Update product");
			
			System.out.println("5. Add user");
			System.out.println("6. Update user");
			System.out.println("7. Show all user");
			
			System.out.println("8. Shop");
			System.out.println("Enter ur choice");
			choice = inputScanner.nextInt();
		}while(shop.takeInput(choice));
		inputScanner.close();
	}
}
