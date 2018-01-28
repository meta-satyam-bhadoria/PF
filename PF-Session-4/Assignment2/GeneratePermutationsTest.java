import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GeneratePermutationsTest {

	GeneratePermutations generate = new GeneratePermutations();
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
	
	@Test(expected = ArithmeticException.class)
	public void test1() {
		List<String> expected=Arrays.asList("");
		assertEquals(expected, generate.generatePermutations(""));
	}

}
