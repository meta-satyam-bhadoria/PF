/*
 * This test case file is to test Gcd class working.
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * class to test Gcd class implementation
 * @author satyam bhadoria
 *
 */
@RunWith(Parameterized.class)
public class GcdTest {
	protected Gcd gcd = new Gcd();				//creating object
		 
	/*inputs and expected output as parameters*/
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, 100, 3 } , { 1, 3, -100 } , { 5, 50, 45 } , { 3, 3, 0} , { 1, -5, -9}, {0, 0, 0}
		});
	}
	
	/*variables for inputs and expected output*/
	private int fInput1;
	private int fInput2;
	private int fExpected;
	
	/**
	 * method for initializing variables declared above
	 */
	public GcdTest(int expected, int number1, int number2) {
		fInput1= number1;
		fInput2 = number2;
		fExpected= expected;
	}
	
	/*test cases including negative(2 and 5 case) and positive(rest case)*/
	@Test
	public void test() {
		try{
			assertEquals(fExpected, gcd.gcd(fInput1, fInput2));
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
