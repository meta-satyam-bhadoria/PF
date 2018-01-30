/*
 * This file contain RemoveDuplicate class for 
 * removing duplicates from various elements given 
 * in an array.
 */
import java.util.*;
/**
 * RemoveDuplicate class contain methods removeDuplicate,
 * merge, sort for removing duplicates.
 * @author satyam bhadoria
 *
 */
public class RemoveDuplicate {
	
	/**
	 * This function finds duplicates by using 
	 * concept of sorting and then remove them.
	 * @param input
	 * @return output
	 */
	protected int[] removeDuplicate (int[] input) throws Exception{
    	int[] indexArr;								//stores index of elements of input
    	int[] output;								//stores unique elements from input
    	int j = 1;									//index for output array
    	
    	if (input.length == 0) {
    		throw new ArithmeticException ("Empty input");
    	}
    	
    	indexArr = new int[input.length];
    	output = new int[input.length];
    	
    	/*initializes indexArr with index only*/
    	for(int i = 0; i < input.length; i++){
    		indexArr[i] = i;
    	}

    	/*calling sort method to sort input with indexArr*/
        sort (input, 0, input.length - 1, indexArr);
        
        /*making indexArr index equal where adjacent elements of input are equal*/
        for (int i =1 ; i < input.length; i++) {
        	if (input[i-1] == input[i]) {
        		indexArr[i] = indexArr[i - 1];		
        	}
        }
        
        /*calling sort method to sort indexArr with input*/
        sort (indexArr, 0, input.length - 1, input);
        output[0] = input[0];						//copying first element of input to output
        
        /*copying unique elements of input to output*/
        for (int i = 1; i < input.length; i++) {
        	
        	/*skipping if adjacent elements are equal*/
        	if (input[i-1] == input[i]) {
        		continue;
        	}
        	output[j] = input[i];					//copying element
        	j++;									
        }
        
        return Arrays.copyOfRange(output, 0, j );	//returns sub-array of output which are unique elements.
	}
    
	/**
	 * This function merges two sub-array array
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 * @param indexArr
	 */
    private void merge(int arr[], int left, int middle, int right,int[] indexArr){
    	
    	/*Find sizes n1 and n2 of two sub-arrays to be merged*/
    	int n1 = middle - left + 1;					
        int n2 = right - middle;
        
        /*create temporary arrays*/
        int leftArr[] = new int [n1];
        int indexLeftArr[] = new int [n1];
        int rightArr[] = new int [n2];
        int indexRightArr[] = new int [n2];
        
        /*copying  data to temporary left arrays*/
        for (int i=0; i<n1; ++i){
            leftArr[i] = arr[left + i];
            indexLeftArr[i] = indexArr[left + i];
        }
        
        /*copying data to temporary right arrays*/
        for (int j=0; j<n2; ++j){
            rightArr[j] = arr[middle + 1+ j];
            indexRightArr[j] = indexArr[middle + 1+ j];
        }
         
        int i = 0;							//Initial index of first sub-arrays
        int j = 0;							//Initial index of second sub-arrays
        int k = left;						//Initial index of merged sub-array array
        
        /*copying elements of sub-arrays to array till indexes are less than there corresponding sizes*/
        while (i < n1 && j < n2){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                indexArr[k] = indexLeftArr[i];
                i++;
            } else{
                arr[k] = rightArr[j];
                indexArr[k] = indexRightArr[j];
                j++;
            }
            k++;
        }
        
        /*copying remaining elements of left sub-arrays if any*/
        while (i < n1){
            arr[k] = leftArr[i];
            indexArr[k] = indexLeftArr[i];
            i++;
            k++;
        }
        
        /*copying remaining elements of right sub-arrays if any*/
        while (j < n2){
            arr[k] = rightArr[j];
            indexArr[k] = indexRightArr[j];
            j++;
            k++;
        }
    }
    
    /**
     * This function sort first array and change index of second array
     * according to sorted elements of first array
     * @param arr
     * @param left
     * @param right
     * @param indexArr
     */
    private void sort(int arr[], int left, int right, int[] indexArr){
        if (left < right) {
            int middle = (left + right) / 2;		//finds middle point
            
            /*sort first and second halves*/
            sort(arr, left, middle, indexArr);
            sort(arr , middle + 1, right, indexArr);
            
            /*merge these two halves*/
            merge(arr, left, middle, right, indexArr);
        }
    }
}
