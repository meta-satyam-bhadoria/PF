/*
 * This test case file is to test LargestDigit class working.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * class to test LargestDigit class implementation
 * @author satyam bhadoria
 *
 */
public class LargestDigitTest {
	public LargestDigit largestDigit;			//creating object
	
	/**
	 * initialize object
	 * */
	@Before
	public void init () {
		largestDigit = new LargestDigit();
	}
	
	/**
	 * successful test case for finding largest digit for positive number
	 * */
	@Test
	public void testLargestDigit() {
		int expected = 2;
		int actual = largestDigit.largestDigit(20);
		assertEquals(expected, actual);
	}

	/**
	 * successful test case for finding largest digit for negative number
	 * */
	@Test
	public void testLargestDigit1() {
		int expected = 9;
		int actual = largestDigit.largestDigit(-5594385);
		assertEquals(expected, actual);
	}
}