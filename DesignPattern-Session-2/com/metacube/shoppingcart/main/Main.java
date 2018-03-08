package com.metacube.shoppingcart.main;

import java.util.Scanner;
import com.metacube.shoppingcart.view.InputAndOutput;

public class Main {
	public static void main(String[] args){
		Scanner inputScanner  = new Scanner(System.in);
		InputAndOutput shop = new InputAndOutput();
		String inputChoice;
		int choice;
		do{
			System.out.println("1. Add product");
			System.out.println("2. Delete product");
			System.out.println("3. Update product");
			System.out.println("4. Show all products");
			
			System.out.println("5. Add user");
			System.out.println("6. Remove user");
			System.out.println("7. Update user");
			System.out.println("8. Show all user");
			
			System.out.println("9. Shop");
			System.out.println("Enter ur choice");
			inputChoice = inputScanner.next();
			try{
				choice = Integer.parseInt(inputChoice);
			} catch(NumberFormatException e){
				System.out.println("Enter correct input");
				choice = 0;
			}
		} while(shop.takeInput(choice));
		inputScanner.close();
	}
}
