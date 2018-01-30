/*
 * This test case file is to test Pyramid class working.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test Pyramid class implementation
 * @author satyam bhadoria
 *
 */
public class PyramidTest {
	protected Pyramid pyramid;			//creating object
	
	/*initialize object*/
	@Before
	public void init () {
		pyramid = new Pyramid();
	}
	
	/*positive test case*/
	@Test
	public void testNumbers1() {
		int n=9;
		String expected="12321";
		String actual = null;
		try {
			actual = pyramid.numbers(3, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	/*negative test case*/
	@Test(expected = PatternException.class)
	public void testNumbers2() throws PatternException {
		int n=9;
		String expected="12321";
		String actual = pyramid.numbers(20, n);
		assertEquals(expected,actual);
	}
	
	/*positive test case*/
	@Test
	public void testSpace1() {
		int n=9;
		String expected="      ";
		String actual = null;
		try {
			actual = pyramid.spaces(3, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	/*negative test case*/
	@Test(expected = PatternException.class)
	public void testSpace2() throws PatternException {
		int n=9;
		String expected="      ";
		String actual = pyramid.spaces(20, n);
		assertEquals(expected,actual);
	}
	
	/*positive test case*/
	@Test
	public void testPrint() {
		int n = 9;
		String expected[]={ "        1",
							"       121",
							"      12321",
							"     1234321",
							"    123454321",
							"   12345654321",
							"  1234567654321",
							" 123456787654321",
							"12345678987654321",
							" 123456787654321",
							"  1234567654321",
							"   12345654321",
							"    123454321",
							"     1234321",
							"      12321",
							"       121",
							"        1"};
		String actual[] = null;
		try {
			actual = pyramid.print(n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertArrayEquals(expected, actual);
	}
	
	/*negative test case*/
	@Test(expected = PatternException.class)
	public void testPrint1() throws PatternException {
		int n =- 1;
		String expected = null;
		String[] actual = pyramid.print(n);
		assertEquals(expected,actual);
	}

}
