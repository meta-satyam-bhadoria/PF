/*
 * test case file to test JoinTwoArray class working
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test JoinTwoArray class implementation
 * @author satyam bhadoria
 *
 */
public class JoinTwoArrayTest {
	protected JoinTwoArray merge;		//create object
	
	/*initialize object*/
	@Before
	public void testThis(){
		merge = new JoinTwoArray();
	}

	/*positive test case*/
	@Test
	public void test() {
		int[] a = new int[] {1,2,3,4,5,7,8,9};		//first array
		int aLength = a.length;
		int[] b = new int[] {-2,-1,2,4,5,6};		//second array
		int bLength = b.length;
		int[] c = new int[aLength + bLength];		
		int[] output = new int[] {-2,-1,1,2,2,3,4,4,5,5,6,7,8,9};
		assertArrayEquals (output, merge.join(a, aLength, b, bLength, c));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test1() {
		int[] a = new int[] {};		//first array
		int aLength = a.length;
		int[] b = new int[] {};		//second array
		int bLength = b.length;
		int[] c = new int[aLength + bLength];		
		int[] output = new int[] {};
		assertArrayEquals (output, merge.join(a, aLength, b, bLength, c));
	}

}
