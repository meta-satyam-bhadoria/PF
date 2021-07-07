/*
 * test case file to test IsSorted class working
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test IsSorted class implementation
 * @author satyam bhadoria
 *
 */
public class IsSortedTest {
	
	protected IsSorted sorted;		//creating object

	/*initializing object*/
	@Before
	public void testThis(){
		sorted = new IsSorted();
	}
	
	/*positive test case 1*/
	@Test
	public void test() {
		int[] input = new int[] {1,2,3,4};
		int output = 1;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*positive test case 2*/
	@Test
	public void test1() {
		int[] input = new int[] {1,2,4,5,6,6,7,8,9};
		int output = 1;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*positive test case 3*/
	@Test
	public void test2() {
		int[] input = new int[] {9,5,4,4,3,1};
		int output = 2;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*positive test case 4*/
	@Test
	public void test3() {
		int[] input = new int[] {1,2,5,4};
		int output = 0;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*positive test case 5*/
	@Test
	public void test4() {
		int[] input = new int[] {-1,-2,-3,-4,-5,-6};
		int output = 2;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*positive test case 6*/
	@Test
	public void test5() {
		int[] input = new int[] {1,1,1,1,1,1,1,1,1};
		int output = 1;
		assertEquals (output, sorted.isSorted (input));
	}
	
	/*negative test case 7*/
	@Test(expected = ArithmeticException.class)
	public void test6() {
		int[] input = new int[] {};
		int output = 1;
		assertEquals (output, sorted.isSorted (input));
	}

}
