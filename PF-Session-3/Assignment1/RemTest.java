/*
 * This test case file is to test Rem class working.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * class to test Rem class implementation
 * @author satyam bhadoria
 *
 */
public class RemTest {
	public Rem rem;			//creating object
	
	/**
	 * initialize object
	 * */
	@Before
	public void init () {
		rem = new Rem();
	}
	
	/**
	 * successful test case for finding remainder
	 * */
	@Test
	public void testRem() {
		int expected = 15;
		int actual = rem.rem(15, 20);
		assertEquals(expected, actual);
	}
	
	/**
	 * failure test case for 
 when first number is negaitve
	 * */
	@Test(expected = ArithmeticException.class)
	public void testRem1() {
		int expected = 0;
		int actual = rem.rem(-3, 5);
		assertEquals(expected, actual);
	}
	
	/**
	 * failure test case for for checking Arithmetic Exception when second number is 0
	 * */
	@Test(expected = ArithmeticException.class)
	public void testRem2() {
		int expected = 0;
		int actual = rem.rem(3, 0);
		assertEquals(expected, actual);
	}

	/**
	 * failure test case for for checking Arithmetic Exception when second number is negative
	 * */
	@Test(expected = ArithmeticException.class)
	public void testRem3() {
		int expected = 0;
		int actual = rem.rem(3, -5);
		assertEquals(expected, actual);
	}
}