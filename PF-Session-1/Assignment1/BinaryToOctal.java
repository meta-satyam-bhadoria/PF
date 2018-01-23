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
class BinaryToOctal {
	
	/**
	 * This method calculates and returns octal number
	 * corresponding to binary number.
	 * 
	 * @param binaryNum
	 * @return octalNum
	 */
	int convertBinaryToOctal(int binaryNum){
		
		/*store octal number temporarily for group of max 3 digits of binary number*/
		int tempOctal = 0;
		int octalNum = 0;			//store octal number
		int digit;					//store current working digit of binary number
		int countOctalLoop = 0;		//counter for calculating tempOctal value
		int loop = 0;				//counter for positioning tempOctal value to proper position in octalNum
		
		/* loop calculating octal number*/
		while (binaryNum != 0) {
			digit = binaryNum % 10;	//last digit of binary number
			
			/*check whether number is binary or not */
			if (digit > 1) {
				System.out.println("Not a binary number");
				System.exit(0);
			}
			
			/*perform operation only when digit is 1 and calculate tempOctal value*/
			if (digit == 1) {
				tempOctal += (int) Math.pow(2, countOctalLoop);
			}
			binaryNum /= 10;		//reduce binary number from last digit
			countOctalLoop++;
			
			/*Position tempOctal value in octalNum in proper position */
			if (countOctalLoop > 2) {
				octalNum = octalNum + tempOctal * (int) Math.pow(10, loop);
				countOctalLoop = 0;	//set to 0 again for calculating next tempOctal
				loop++;
				tempOctal = 0;		//set to 0 after get positioned in octalNum
			}
		}							//end of while loop
		
		/*Position tempOctal value in octalNum in proper position 
		 (if present) to very first left group of less than 3 digit in binary number
		 */
		if(countOctalLoop != 0){
			octalNum = octalNum + tempOctal * (int) Math.pow(10,loop);
		}
		return octalNum;			//returns octal number
	}
}