/*
 * This test case file is to test GeneratePermutations class working.
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * class to test GeneratePermutations class implementation
 * @author satyam bhadoria
 *
 */
public class GeneratePermutationsTest {

	protected GeneratePermutations generate = new GeneratePermutations();		//creating object
	
	/*positive test case*/
	@Test
	public void test() {
		List<String> expected=Arrays.asList("ABC",
											"ACB",
											"BAC",
											"BCA",
											"CAB",
											"CBA");
		assertEquals(expected, generate.generatePermutations("ABC"));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test1() {
		List<String> expected=Arrays.asList("");
		assertEquals(expected, generate.generatePermutations(""));
	}

}
