/*
 * This file implements the logic for
 * searching a number from the list given
 */

/**
 * This class will search a number in the array
 * using recursion
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class BinarySearch {
	
	/**
	 * This method true if element found else false
	 * @param inputList - array of elements
	 * @param numToSearch - element to search for
	 */
	protected boolean binarySearch (int[] inputList, int numToSearch) {

		if (inputList.length == 0) {
			throw new ArithmeticException ("List is empty");
		}
		return binarySearchFourParam (inputList, numToSearch, 0, inputList.length);
	}
	
	/**
	 * This method uses recursion to search
	 * element binary search strategy
	 * @param inputList - array of elements
	 * @param numToSearch - element to search for
	 * @param left - low index of array
	 * @param right - high index of array 
	 */
	private boolean binarySearchFourParam (int[] inputList, int numToSearch, int left, int right) {
		int middle = (left + right) / 2;	//middle elements in the array
		
		/*return false if element not found till left index equals right index*/
		if(left == right){
			return false;
		} else if (numToSearch == inputList[middle]) {		//return true if element found
			return true;
		}
		
		/*call itself if number is left side of middle element*/
		if (numToSearch < inputList[middle]) {
			return binarySearchFourParam(inputList, numToSearch, left, middle - 1);
		}
		
		/*call itself if number is right side of middle element*/
		return binarySearchFourParam(inputList, numToSearch, middle + 1, right);
	} 
}
