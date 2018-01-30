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
	protected LinearSearch search;		//create object
	
	/*initialize object*/
	@Before
	public void testThis(){
		search = new LinearSearch();
	}
	
	/*positive test case*/
	@Test
	public void test() {
		int[] inputArr = new int[] {2,5,8,9,10,77,55};
		int elementToSearch = 88;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}
	
	/*positive test case*/
	@Test
	public void test1() {
		int[] inputArr = new int[] {2,5,8,9,10, 77, 55};
		int elementToSearch = 55;
		boolean output = true;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test2() {
		int[] inputArr = new int[] {};
		int elementToSearch = 77;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, elementToSearch));
	}

}
