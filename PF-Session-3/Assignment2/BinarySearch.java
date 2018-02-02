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
	 * @return true(if found) or false( not found)
	 */
	public boolean binarySearch (int[] inputList, int numToSearch) {

		if (inputList.length == 0) {
			throw new ArithmeticException ("List is empty");
		}
		return binarySearchUtil (inputList, numToSearch, 0, inputList.length);
	}
	
	/**
	 * This method uses recursion to search
	 * element binary search strategy
	 * @param inputList - array of elements
	 * @param numToSearch - element to search for
	 * @param low - low index of array
	 * @param high - high index of array 
	 * @return true(if found) or false( not found)
	 */
	private boolean binarySearchUtil (int[] inputList, int numToSearch, int low, int high) {
		int middle = (low + high) / 2;	//middle elements in the array
		
		/*return false if element not found till left index equals right index*/
		if(low == high){
			return false;
		} else if (numToSearch == inputList[middle]) {		//return true if element found
			return true;
		}
		
		/*call itself if number is left side of middle element*/
		if (numToSearch < inputList[middle]) {
			return binarySearchUtil(inputList, numToSearch, low, middle - 1);
		}
		
		/*call itself if number is right side of middle element*/
		return binarySearchUtil(inputList, numToSearch, middle + 1, high);
	} 
}
