/*
 * This program implements the logic for
 * sorting the array
 */

/**
 * This class implements the quick sort algorithm
 * using recursion
 * @version 1.0
 * @author satyam bhadoria
 *
 */
public class QuickSort {
	
	/**
	 * This method implements quick sort algorithm
	 * @param inputArr - array of element
	 * @param low - low index of array
	 * @param high - high index of array
	 * @return inputArr - sorted array
	 */
	public int[] quickSort (int[] inputArr, int low, int high) {
		
		if (inputArr.length == 0) {
			throw new ArithmeticException ("List is empty");
		}
		return quickSortUtil (inputArr, low, high);
	}
	
	/**
	 * This method implements quick sort algorithm
	 * @param inputArr - array of element
	 * @param low - low index of array
	 * @param high - high index of array
	 * @return inputArr - sorted array
	 */
	private int[] quickSortUtil (int[] inputArr, int low, int high) {
		int tempLeft = low;						//temporary low index
		int tempRight = high;						//temporary high index
		int key = (tempLeft + tempRight) / 2;		//pivot element for array
		
		do{
			
			/*finds element left to pivot which is larger than pivot*/
			while (inputArr[ tempLeft ] < inputArr[ key ]) {
				tempLeft++;
			}
			
			/*finds element right to pivot which is smaller than pivot*/
			while (inputArr[ key ] < inputArr[ tempRight ]) {
				tempRight--;
			}
			
			/*swap above found two elements*/
			if (tempLeft <= tempRight) {
				int temp = inputArr[tempLeft];
				inputArr[tempLeft] = inputArr[tempRight];
				inputArr[tempRight] = temp;
				tempLeft++;
				tempRight--;
			}
		} while (tempLeft <= tempRight);
		
		/*sort left sub array*/
		if (low < tempRight) {
			quickSortUtil (inputArr, low, tempRight);
		}
		
		/*sort right sub array*/
		if (high > tempLeft){
			quickSortUtil (inputArr, tempLeft, high);
		}
		return inputArr;
	}
}
