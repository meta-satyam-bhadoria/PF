import static org.junit.Assert.*;

import org.junit.Test;

public class Pyramid1Test {
	Pyramid1 pyramid = new Pyramid1();
	
	@Test
	public void testPrint() {
		int n =- 1;
		String expected=null;
		String[] actual = null;
		try {
			actual = pyramid.print(n);
		} catch (PatternException e) {
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
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
	
	@Test
	public void testNumbers2() {
		int n = 5;
		String expected = "1234";
		String actual = null;
		try {
			actual = pyramid.numbers(2, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNumbers3() {
		int n=5;
		String expected="123";
		String actual = null;
		try {
			actual = pyramid.numbers(3, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNumbers4() {
		int n=5;
		String expected="12";
		String actual = null;
		try {
			actual = pyramid.numbers(4, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNumbers5() {
		int n=5;
		String expected="1";
		String actual = null;
		try {
			actual = pyramid.numbers(5, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSpace1() {
		int n=5;
		String expected="";
		String actual = null;
		try {
			actual = pyramid.spaces(1, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSpace2() {
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
	
	@Test
	public void testSpace3() {
		int n=5;
		String expected="  ";
		String actual = null;
		try {
			actual = pyramid.spaces(3, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSpace4() {
		int n=5;
		String expected="   ";
		String actual = null;
		try {
			actual = pyramid.spaces(4, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSpace5() {
		int n=5;
		String expected="    ";
		String actual = null;
		try {
			actual = pyramid.spaces(5, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPyramidint1() {
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

}