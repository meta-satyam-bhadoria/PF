/*
* This file contain BinaryToOctal class
* which convert binary number to octal number.
*/

/**
 * BinaryToOctal class includes a function
 * which convert binary number to octal number.
 * 
 * @author Satyam Bhadoria
 */
public class BinaryToOctal {
	
	/**
	 * This method calculates and returns octal number
	 * corresponding to binary number.
	 * 
	 * @param binaryNum
	 * @return octalNum
	 */
	protected int convertBinaryToOctal(int binaryNumber){
		
		if (binaryNumber < 0) {
			throw new ArithmeticException ("Binary number cannot be negative");
		}
		
		return convertDecimalToOctal ( convertBinaryToDecimal (binaryNumber) );		//return octal number
	}
	
	/**
	 * method to convert binary number to decimal number
	 * @param binaryNumber
	 * @return decimalNumber
	 */
	private int convertBinaryToDecimal (int binaryNumber) {
		int digit;
		int decimalNumber = 0;
		int count = 0;
		
		/*finds decimal number for given binary number*/
		while (binaryNumber != 0) {
			digit = binaryNumber % 10;

			if (digit > 1) {
				throw new ArithmeticException ("Not a binary number");
			}
			decimalNumber += digit * Math.pow(2, count++);
			binaryNumber /= 10;
		}
		return decimalNumber;
	}
	
	/**
	 * method to convert decimal number to octal number
	 * @param decimalNumber
	 * @return octalNumber
	 */
	private int convertDecimalToOctal (int decimalNumber) {
		int digit;
		int octalNumber = 0;
		int count = 0;
		
		/*finds octal number for given decimal number*/
		while (decimalNumber != 0) {
			digit = decimalNumber % 8;
			octalNumber += digit * Math.pow(10, count++);
			decimalNumber /= 8;
		}
		return octalNumber;
	}
}
