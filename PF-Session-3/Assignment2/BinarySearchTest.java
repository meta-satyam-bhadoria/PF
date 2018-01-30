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
	protected BinarySearch search;		//create object
	
	/*initialize object*/
	@Before
	public void testThis(){
		search = new BinarySearch();
	}

	/*positive test case*/
	@Test
	public void test() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77};
		int element = 88;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element));
	}
	
	/*positive test case*/
	@Test
	public void test1() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77,88};
		int element = 77;
		boolean output = true;
		assertEquals(output, search.binarySearch(inputArr, element));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test2() {
		int[] inputArr = new int[] {};
		int element = 77;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element));
	}

}
