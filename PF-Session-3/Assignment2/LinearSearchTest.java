/*
 * This test case file is to test LinearSearch class working.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test LinearSearch class implementation
 * @author satyam bhadoria
 *
 */
public class LinearSearchTest {
	public LinearSearch search;		//create object
	
	/**
	 * initialize object
	 * */
	@Before
	public void testThis(){
		search = new LinearSearch();
	}
	
	/**
	 * successful test case for linear search returning false
	 * */
	@Test
	public void testLinearSearch() {
		int[] inputArr = new int[] {2,5,8,9,10,77,55};
		int elementToSearch = 88;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}
	
	/**
	 * successful test case for linear search returning true
	 * */
	@Test
	public void testLinearSearch1() {
		int[] inputArr = new int[] {2,5,8,-9,10,-77, 55};
		int elementToSearch = 55;
		boolean output = true;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}
	
	/**
	 * failure test case for checking Arithmetic Exception when empty list provided
	 * */
	@Test(expected = ArithmeticException.class)
	public void testLinearSearch2() {
		int[] inputArr = new int[] {};
		int elementToSearch = 77;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}

}
