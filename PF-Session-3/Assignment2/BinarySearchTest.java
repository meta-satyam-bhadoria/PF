/*
 * This test case file is to test BinarySearch class working.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test BinarySearch class implementation
 * @author satyam bhadoria
 *
 */
public class BinarySearchTest {
	public BinarySearch search;		//create object
	
	/*initialize object*/
	@Before
	public void testThis(){
		search = new BinarySearch();
	}

	/*successful test case for binary search*/
	@Test
	public void testBinarySearch() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77};
		int element = 88;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element));
	}
	
	/*successful test case for binary search*/
	@Test
	public void testBinarySearch1() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77,88};
		int element = 88;
		boolean output = true;
		assertEquals(output, search.binarySearch(inputArr, element));
	}
	
	/*failure test case for binary search when empty list provided*/
	@Test(expected = ArithmeticException.class)
	public void testBinarySearch2() {
		int[] inputArr = new int[] {};
		int element = 77;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element));
	}

}
