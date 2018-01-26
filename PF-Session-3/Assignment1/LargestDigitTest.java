import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class LargestDigitTest {

	LargestDigit largest = new LargestDigit();
		 
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 7, 1234567 } , { 4, 12341412 } , { 9, 54379542} , { 9, -54379542},{0,000}
		});
	}
	private int fInput;
	private int fExpected;
	
	public LargestDigitTest(int expected, int input) {
		fInput= input;
		fExpected= expected;
	}
	
	@Test
	public void test() {
		assertEquals(fExpected, largest.largestDigit(fInput));
	}
}
