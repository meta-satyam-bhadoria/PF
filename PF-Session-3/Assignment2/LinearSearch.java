/*
 * This file implements the logic for
 * searching a number from the list given
 * using sequential approach
 */

/**
 * This class will search a number in the array
 * linearly using recursion
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class LinearSearch {
	
	/**
	 * This method uses recursion to search
	 * element linearly
	 * @param inputList - array of elements
	 * @param numToSearch - element to search for
	 * @param position - position from where to search
	 * @return either true or false
	 */
	boolean linearSearch (int[] inputList, int numToSearch, int position) {
		
		/*returns false if element not found till end of the list*/
		if (position == inputList.length) {
			return false;
		}
		
		/*return true if element found*/
		if (numToSearch == inputList[position]){
			return true;
		}
		
		return linearSearch(inputList, numToSearch, position + 1);	//call itself again with increase in position by 1
	}
}
