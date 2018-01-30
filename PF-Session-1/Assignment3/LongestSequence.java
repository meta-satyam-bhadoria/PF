import java.util.Arrays;

/*
 * This file contains LongestSequence class
 * which finds longest increasing sequence
 */

/**
 * LongestSequence class finds the longest increasing
 * sequence from the given sequence
 * @author satyam bhadoria
 *
 */
public class LongestSequence {
	
	/**
	 * This method finds and returns the first occurring longest increasing sequence
	 * @param input
	 */
	protected int[] longestSequence (int[] input) {
        int startPosition = 0;				//start position of longest increasing sequence
        int sequenceLength = 1;				//length of longest sequence. Minimum length 1
        int currStartPosition = 0;			//start position of current sequence
        int currSequenceLength = 1;			//length of current sequence. Minimum length 1
        
        if (input.length == 0) {
    		throw new ArithmeticException ("Empty input");
    	}
        
        /*finds longest increasing sequence*/
        for (int i = 1; i < input.length; i++) {
        	
        	/*if element is greater than previous element than check for longest length and start position*/
            if (input[i - 1] >= input[i]) {
                
            	/*check whether existing longest sequence length is less than current sequence length*/
            	if (currSequenceLength > sequenceLength) {
                    sequenceLength = currSequenceLength;	//copying current length
                    startPosition = currStartPosition;		//copying current position
                }
                currStartPosition = i;
                currSequenceLength = 1;
            } else{
                currSequenceLength++;		//increment current sequence length
            }
        }
        
        /*check whether existing longest sequence length is less than current sequence length*/
        if (sequenceLength < currSequenceLength) {
            sequenceLength = currSequenceLength;	//copying current length
            startPosition = currStartPosition;		//copying current position
        }
        
        return Arrays.copyOfRange (input, startPosition, startPosition + sequenceLength);
    }
}
