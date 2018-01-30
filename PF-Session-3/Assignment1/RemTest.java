/*
 * This test case file is to test Rem class working.
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * class to test Rem class implementation
 * @author satyam bhadoria
 *
 */
@RunWith(Parameterized.class)
public class RemTest {

	protected Rem rem = new Rem();
		 
	/*inputs and expected output as parameters*/
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, 100, 3 } , { 0, 3, 0 } , { 0, 0, 32 } , { 0, 3, 1} , {0,3,-2}, {0, -9, 2}
		});
	}
	
	/*variables for inputs and expected output*/
	private int fInput1;
	private int fInput2;
	private int fExpected;
	
	/**
	 * method for initializing variables declared above
	 */
	public RemTest(int expected, int number1, int number2) {
		fInput1= number1;
		fInput2 = number2;
		fExpected= expected;
	}
	
	/*test cases including negative(2,5 and 6 case) and positive(rest case)*/
	@Test
	public void test() {
		try {
			assertEquals(fExpected, rem.rem(fInput1, fInput2));
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
