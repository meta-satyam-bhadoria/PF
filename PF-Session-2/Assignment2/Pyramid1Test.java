/*
 * This test case file is to test Pyramid1 class working.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test Pyramid1 class implementation
 * @author satyam bhadoria
 *
 */
public class Pyramid1Test {
	protected Pyramid1 pyramid;			//creating object
	
	/*initialize object*/
	@Before
	public void init () {
		pyramid = new Pyramid1();
	}
	
	/*positive test case*/
	@Test
	public void testNumbers1(){
		int n = 5;
		String expected="12345";
		String actual = null;
		try {
			actual = pyramid.numbers(1, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	/*negative test case*/
	@Test(expected = PatternException.class)
	public void testNumbers2() throws PatternException{
		int n = 5;
		String expected="12345";
		String actual = pyramid.numbers(9, n);
		assertEquals(expected,actual);
	}
	
	/*positive test case*/
	@Test
	public void testSpace1() {
		int n=5;
		String expected=" ";
		String actual = null;
		try {
			actual = pyramid.spaces(2, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	/*negative test case*/
	@Test(expected = PatternException.class)
	public void testSpace2() throws PatternException {
		int n=5;
		String expected=" ";
		String actual = pyramid.spaces(8, n);
		assertEquals(expected,actual);
	}
	
	/*positive test case*/
	@Test
	public void testPrint() {
		int n = 5;
		String expected[]={ "12345",
							" 1234",
							"  123",
							"   12",
							"    1",};
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
		int n = -1;
		String expected=null;
		String[] actual = pyramid.print(n);
		assertEquals(expected,actual);
	}

}
