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
	 * @param left - low index of array
	 * @param right - high index of array
	 * @return inputArr - sorted array
	 */
	public int[] quickSort (int[] inputArr, int left, int right) {
		int tempLeft = left;						//temporary left index
		int tempRight = right;						//temporary right index
		int key = (tempLeft + tempRight) / 2;		//pivot element for array
		
		if (inputArr.length == 0) {
			throw new ArithmeticException ("List is empty");
		}
		
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
		if (left < tempRight) {
			quickSort(inputArr, left, tempRight);
		}
		
		/*sort right sub array*/
		if (right > tempLeft){
			quickSort(inputArr, tempLeft, right);
		}
		return inputArr;
	}
}
