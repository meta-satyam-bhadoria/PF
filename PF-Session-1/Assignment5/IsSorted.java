/*
 * This file contain IsSorted class which
 * checks for sorted elements in an array 
 * whether ascending or descending
 */

/**
 * IsSorted class checks for sort or unsort elements.
 * @author satyam bhadoria
 *
 */
public class IsSorted {
	
	/**
	 * This method return 0 for unsorted
	 * return 1 for ascending sort
	 * return 2 for descending sort
	 * @param input
	 */
	protected int isSorted (int[] input) {
        int ascCount = 1;					//count for ascending order
        int descCount = 1;					//count for descending order
        int inputLength = input.length;		//array length
        
        if (input.length == 0) {
    		throw new ArithmeticException ("Empty input");
    	}
        
        /*increment ascending and descending count when elements are greater or lesser than previous elements*/
        for (int i = 1; i < inputLength; i++) {
            if(input[i - 1] < input[i]){
                ascCount++;
            } else if(input[i - 1] > input[i]){
                descCount++;
            } else{
                ascCount++;
                descCount++;
            }
        }
        
        if (ascCount == inputLength) {
            return 1;			
        } else if (descCount == inputLength) {
            return 2;		
        }
        return 0;	
    }
}
