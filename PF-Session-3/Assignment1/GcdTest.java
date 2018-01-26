import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class GcdTest {

	Gcd gcd = new Gcd();
		 
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, 100, 3 } , { 1, 3, -100 } , { 5, 50, 45 } , { 3, 3, 0} , { 1, -5, -9}, {0, 0, 0}
		});
	}
	private int fInput1;
	private int fInput2;
	private int fExpected;
	
	public GcdTest(int expected, int number1, int number2) {
		fInput1= number1;
		fInput2 = number2;
		fExpected= expected;
	}
	
	@Test
	public void test() {
		assertEquals(fExpected, gcd.gcd(fInput1, fInput2));
	}
}
