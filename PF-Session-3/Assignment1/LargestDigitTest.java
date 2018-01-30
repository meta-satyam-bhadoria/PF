/*
 * This test case file is to test LargestDigit class working.
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * class to test LargestDigit class implementation
 * @author satyam bhadoria
 *
 */
@RunWith(Parameterized.class)
public class LargestDigitTest {
	protected LargestDigit largest = new LargestDigit();
	
	/*inputs and expected output as parameters*/
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 7, 1234567 } , { 4, 12341412 } , { 9, 54379542} , { 9, -54379542},{0,000}
		});
	}
	
	/*variables for inputs and expected output*/
	private int fInput;
	private int fExpected;
	
	/**
	 * method for initializing variables declared above
	 */
	public LargestDigitTest(int expected, int input) {
		fInput= input;
		fExpected= expected;
	}
	
	/*test cases*/
	@Test
	public void test() {
		try{
			assertEquals(fExpected, largest.largestDigit(fInput));
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
