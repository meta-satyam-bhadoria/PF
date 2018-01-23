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
class IsSorted {
	
	/**
	 * This method return 0 for unsorted
	 * 1 for ascending sort
	 * 2 for descending sort
	 * @param input
	 */
	int isSorted (int[] input) {
        int ascCount = 1;					//holds count for ascending order
        int descCount = 1;					//holds count for descending order
        int inputLength = input.length;		//holds array length
        
        /*check whether array contain 0 or 1 element*/
        if (inputLength == 1 || inputLength == 0) {
            return 1;
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
            return 1;					//return 1 when ascending count is equal to length of array
        } else if (descCount == inputLength) {
            return 2;					//return 2 when descending count is equal to length of array
        }
        return 0;			//return 0 when count(ascending or descending) is not equal to length of array
    }
}
