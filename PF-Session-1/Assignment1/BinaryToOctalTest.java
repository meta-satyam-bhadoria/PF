/*
 * This test case file is to test BinaryToOctal class working.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test BinaryToOctal class implementation
 * @author satyam bhadoria
 *
 */
public class BinaryToOctalTest {
	protected BinaryToOctal binToOct;   	//creating object of BinaryToOctal class

	/*initializing object*/
	@Before
	public void init(){
		binToOct = new BinaryToOctal();
	}
	
	/*positive test case 1*/
	@Test
	public void test() {
		assertEquals(64, binToOct.convertBinaryToOctal (110100) );
	}
	
	/*positive test case 2*/
	@Test
	public void test1() {
		assertEquals(0, binToOct.convertBinaryToOctal (000) );
	}
	
	/*positive test case 3*/
	@Test
	public void test2() {
		assertEquals(100, binToOct.convertBinaryToOctal (1000000) );
	}
	
	/*negative test case - not a binary number*/
	@Test(expected = ArithmeticException.class)
	public void test3() {
		assertEquals(76, binToOct.convertBinaryToOctal (112140) );
	}
	
	/*negative test case - negative binary number*/
	@Test(expected = ArithmeticException.class)
	public void test4() {
		assertEquals(76, binToOct.convertBinaryToOctal (-111110) );
	}

}
