/*
 * This program implements the logic for
 * finding greatest common divisor of two
 * number.
 */

/**
 * This class implements above describe logic.
 * This contain recursive method gcd and findGcd.
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class Gcd {
    
	/**
	 * This method actually implements
	 * the logic for finding gcd of two numbers using recursion
	 * @param num1 - first number
	 * @param num2 - second number
	 */
	public int gcd (int num1, int num2) {
		
		if (num1 < 0 || num2 < 0) {
			throw new ArithmeticException ("Numbers should be positive");
		}
        
        return gcdUtil (num1, num2 );		//call itself with argument = second and 
        										//remainder(comes by dividing first by second) 
    }
	
	/**
	 * This method actually implements
	 * the logic for finding gcd of two numbers using recursion
	 * @param num1 - first number
	 * @param num2 - second number
	 */
	private int gcdUtil (int num1, int num2) {
        
        /*swap arguments if first argument is smaller*/
        if (num1 < num2) {
        	int temp = num1;
        	num1 = num2;
        	num2 = temp;
        }
        
        /*return first argument as gcd if second argument is 0*/
        if (num2 == 0) {
        	return num1;
        }
        
        return gcdUtil (num2, (num1 % num2) );		//call itself with argument = second and 
        										//remainder(comes by dividing first by second) 
    }

}

