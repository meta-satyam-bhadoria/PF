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

	public GeneratePermutations generate = new GeneratePermutations();		//creating object
	
	/**
	 * successful test case for generating permutations
	 */
	@Test
	public void testGeneratePermutations() {
		List<String> expected=Arrays.asList("ABC",
											"ACB",
											"BAC",
											"BCA",
											"CAB",
											"CBA");
		assertEquals(expected, generate.generatePermutations("ABC"));
	}
	
	/**
	 * failure test case for checking arithmetic exception when list is empty
	 */
	@Test(expected = ArithmeticException.class)
	public void testGeneratePermutations1() {
		List<String> expected=Arrays.asList("");
		assertEquals(expected, generate.generatePermutations(""));
	}

}
