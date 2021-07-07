/*
 * This program implements the logic for
 * finding largest digit of a number
 * It contain class LargestDigit
 */

/**
 * This class implements above describe logic
 * This contain recursive method largestDigit
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class LargestDigit {
    
	/**
	 * This method finds the largest digit in the number
	 * itself and returns that digit using recursion
	 * @param number - number
	 * @return largestDigit - gives largest digit in the number
	 */
	public int largestDigit (int number) {
        int currentDigit;					//store last digit of a number
        int largestDigit;				//store largest digit of number
        number = Math.abs (number);			//making number positive if negative
        
        if (number < 10) {							//base condition for terminating recursion
            return number;
        }
        currentDigit = number % 10;					//copying last digit of a number
        largestDigit = largestDigit (number / 10);	//reducing number from last digit using recursion
            
        /*returns current digit as largest digit if greater than previous largest digit else returns largest digit only */
        if (largestDigit < currentDigit) {
        	return currentDigit;
        }
        return largestDigit;
    }
}