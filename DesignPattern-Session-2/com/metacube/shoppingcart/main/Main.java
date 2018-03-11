package com.metacube.shoppingcart.main;

import java.util.Scanner;
import com.metacube.shoppingcart.view.InputAndOutput;

/**
 * This class is main class which contains main method to test the working of project.
 * @author Satyam Bhadoria
 *
 */
public class Main {
	
	/**
	 * Driver method to test the run
	 * @param args - for command line arguments
	 */
	public static void main(String[] args) {
		Scanner inputScanner  = new Scanner(System.in);
		InputAndOutput shop = new InputAndOutput();
		int choice;
		
		do {
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
			try{
				choice = Integer.parseInt( inputScanner.next() );
			} catch(NumberFormatException e){
				System.out.println("Enter correct input");
				choice = 0;
			}
		} while( shop.takeInput(choice) );
		inputScanner.close();
	}
}
