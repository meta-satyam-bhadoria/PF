/*
 * This program implements the logic for
 * finding remainder when first number is get
 * divided by second number
 */

/**
 * This class implements above describe logic.
 * This contain recursive method rem.
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class Rem {
    
	/**
	 * This method returns remainder
	 * @param num1 - first number 
	 * @param num2 - second number
	 */
	public int rem (int num1, int num2) throws ArithmeticException {
		
        if (num2 == 0) {
            throw new ArithmeticException ("Cannot divide by zero");
        }
        
        if (num2 < 0 || num1 < 0) {
            throw new ArithmeticException ("Number should be greater than zero");
        }
        
        return remUtil ( num1, num2 );		//call itself by reducing first argument by second
    }
	
	private int remUtil (int num1, int num2) {
        
        /*return number 1 as remainder if smaller than number 2*/
        if (num1 < num2) {
            return num1;
        }
        return remUtil ( (num1 - num2), num2 );		//call itself by reducing first argument by second
    }
}