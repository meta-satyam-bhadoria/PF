/*
 * This test case file is to test Gcd class working.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * class to test Gcd class implementation
 * @author satyam bhadoria
 *
 */
public class GcdTest {
	public Gcd gcd;			//creating object
	
	/**
	 * initialize object
	 * */
	@Before
	public void init () {
		gcd = new Gcd();
	}
	
	/**
	 * successful test case for finding gcd
	 * */
	@Test
	public void testGcd() {
		int expected = 5;
		int actual = gcd.gcd(15, 20);
		assertEquals(expected, actual);
	}
	
	/**
	 * failure test case for for checking Arithmetic Exception when first number is neagtive
	 * */
	@Test(expected = ArithmeticException.class)
	public void testGcd1() {
		int expected = 0;
		int actual = gcd.gcd(-3, 5);
		assertEquals(expected, actual);
	}

	/**
	 * failure test case for for checking Arithmetic Exception when second number is neagtive
	 * */
	@Test(expected = ArithmeticException.class)
	public void testGcd2() {
		int expected = 0;
		int actual = gcd.gcd(3, -5);
		assertEquals(expected, actual);
	}
}