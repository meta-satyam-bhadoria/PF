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
class LargestDigit {
    
	/**
	 * This method finds the largest digit in the number
	 * itself and returns that digit using recursion
	 * @param num - number
	 * @return largestDigit - gives largest digit in the number
	 */
	int largestDigit (int num) {
        int curDigit;					//store last digit of a number
        int largestDigit;				//store largest digit of number
        num = Math.abs (num);			//making number positive if negative
        
        /*finds largest digit of a number*/
        if (num < 10) {							//base condition for terminating recursion
            return num;
        }
        curDigit = num % 10;					//copying last digit of a number
        largestDigit = largestDigit (num / 10);	//reducing number from last digit using recursion
            
        /*returns current digit as largest digit if greater than previous largest digit
           else returns largest digit only
         */
        if (largestDigit < curDigit) {
        	return curDigit;
        }
        return largestDigit;
    }
}