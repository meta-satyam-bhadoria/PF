/*
 * test case file to test RemoveDuplicate class working
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test RemoveDuplicate class implementation
 * @author satyam bhadoria
 *
 */
public class RemoveDuplicateTest {
	protected RemoveDuplicate dupTest;		//creating object
	
	/*initializing object*/
	@Before
	public void init() {
		dupTest = new RemoveDuplicate();
	}

	/*positive test case*/
	@Test
	public void test1() throws Exception {
		int[] input = {1,1,2,2,3,4,5,7,3,6,9,5,1,4,7};
		int[] output = {1,2,3,4,5,7,6,9};
		assertArrayEquals (output, dupTest.removeDuplicate (input) );
	}
	
	/*positive test case*/
	@Test
	public void test2() throws Exception {
		int[] input = {1,2,-1,-1,0,0};
		int[] output = {1,2,-1,0};
		assertArrayEquals (output, dupTest.removeDuplicate (input) );
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test3() throws Exception {
		int[] input = {};
		int[] output = {};
		assertArrayEquals (output, dupTest.removeDuplicate (input) );
	}
}
