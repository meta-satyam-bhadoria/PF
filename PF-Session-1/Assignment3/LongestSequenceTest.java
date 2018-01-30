/*
 * test case file to test LongestSequence class working
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test LongestSequence class implementation
 * @author satyam bhadoria
 *
 */
public class LongestSequenceTest {
	
	protected LongestSequence longSequence;		//creating object
	
	/*initializing object*/
	@Before
	public void testThis(){
		longSequence = new LongestSequence();
	}

	/*positive test case 1*/
	@Test
	public void test() {
		int[] input = new int[] {1,2,3,4,1,2};
		int[] output = new int[] {1,2,3,4};
		assertArrayEquals (output, longSequence.longestSequence (input) );
	}
	
	/*positive test case 2*/
	@Test
	public void test1() {
		int[] input = new int[] {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] output = new int[] {1,2,4,5,6,7,8,9};
		assertArrayEquals (output, longSequence.longestSequence (input) );
	}
	
	/*positive test case 3*/
	@Test
	public void test3() {
		int[] input = new int[] {-1,-9,-11,-10,-5,-4,-1,0,1,5,7,6,1,4,5,6,7};
		int[] output = new int[] {-11,-10,-5,-4,-1,0,1,5,7};
		assertArrayEquals(output, longSequence.longestSequence(input));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test4() {
		int[] input = new int[] {};
		int[] output = new int[] {};
		assertArrayEquals(output, longSequence.longestSequence(input));
	}

}
