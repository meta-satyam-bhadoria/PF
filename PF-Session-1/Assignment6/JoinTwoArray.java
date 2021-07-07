/*
 *This file contain JoinTwoArray class which 
 *joins two sorted array into third array. 
 */

/**
 * JoinTwoArray class includes method join
 * which returns joined sorted array
 * @author satyam bhadoria
 *
 */
public class JoinTwoArray {
	
	/**
	 * This method join two array in sorted order
	 * without using external sort.
	 * @param a
	 * @param aSize
	 * @param b
	 * @param bSize
	 * @param c
	 * @return c
	 */
	protected int[] join(int[] a, int aSize, int[] b, int bSize, int[] c){
        int aStartIndex = 0;		//initial index for array a
        int bStartIndex = 0;		//initial index for array b
        int cIndex = 0;				//initial index for array c
        
        if (a.length == 0 || b.length == 0) {
    		throw new ArithmeticException ("Empty input");
    	}
        
        /*copying elements of two arrays(a and b) to array c till indexes are less than there corresponding sizes*/
        while(aStartIndex < aSize && bStartIndex < bSize){
            if(a[aStartIndex] <= b[bStartIndex]){
                c[cIndex] = a[aStartIndex++];
            } else{
                c[cIndex] = b[bStartIndex++];
            }
            cIndex++;
        }
        
        /*copying remaining elements of array 'a' if any*/
        while(aStartIndex < aSize){
            c[cIndex] = a[aStartIndex++];
            cIndex++;
        }
        
        /*copying remaining elements of array 'b' if any*/
        while(bStartIndex < bSize){
            c[cIndex] = b[bStartIndex++];
            cIndex++;
        }
        return c;		//returns joined sorted array
    }
}

