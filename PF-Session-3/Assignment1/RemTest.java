import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class RemTest {

	Rem rem = new Rem();
		 
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, 100, 3 } , { 0, 3, 0 } , { 0, 0, 32 } , { 0, 3, 1} , { 1, 45, 4}, {4, 49, 9}
		});
	}
	private int fInput1;
	private int fInput2;
	private int fExpected;
	
	public RemTest(int expected, int number1, int number2) {
		fInput1= number1;
		fInput2 = number2;
		fExpected= expected;
	}
	
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
