import static org.junit.Assert.*;

import org.junit.Test;

public class PyramidTest {
	Pyramid pyramid = new Pyramid();
	
	@Test
	public void testPrint() {
		int n =- 1;
		String expected = null;
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
		int n = 9;
		String expected="1";
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
		int n = 9;
		String expected = "121";
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
	
	@Test
	public void testNumbers4() {
		int n=9;
		String expected="1234321";
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
		int n=9;
		String expected="123454321";
		String actual = null;
		try {
			actual = pyramid.numbers(5, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers6() {
		int n=9;
		String expected="12345654321";
		String actual = null;
		try {
			actual = pyramid.numbers(6, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers7() {
		int n=9;
		String expected="1234567654321";
		String actual = null;
		try {
			actual = pyramid.numbers(7, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers8() {
		int n=9;
		String expected="123456787654321";
		String actual = null;
		try {
			actual = pyramid.numbers(8, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers9() {
		int n=9;
		String expected="12345678987654321";
		String actual = null;
		try {
			actual = pyramid.numbers(9, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNumbers10() {
		int n=9;
		String expected="123456787654321";
		String actual = null;
		try {
			actual = pyramid.numbers(10, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers11() {
		int n=9;
		String expected="1234567654321";
		String actual = null;
		try {
			actual = pyramid.numbers(11, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers12() {
		int n=9;
		String expected="12345654321";
		String actual = null;
		try {
			actual = pyramid.numbers(12, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers13() {
		int n=9;
		String expected="123454321";
		String actual = null;
		try {
			actual = pyramid.numbers(13, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers14() {
		int n=9;
		String expected="1234321";
		String actual = null;
		try {
			actual = pyramid.numbers(14, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers15() {
		int n=9;
		String expected="12321";
		String actual = null;
		try {
			actual = pyramid.numbers(15, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers16() {
		int n=9;
		String expected="121";
		String actual = null;
		try {
			actual = pyramid.numbers(16, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testNumbers17() {
		int n=9;
		String expected="1";
		String actual = null;
		try {
			actual = pyramid.numbers(17, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSpace1() {
		int n=9;
		String expected="        ";
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
		int n=9;
		String expected="       ";
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
	
	@Test
	public void testSpace4() {
		int n=9;
		String expected="     ";
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
		int n=9;
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
	public void testSpace6() {
		int n=9;
		String expected="   ";
		String actual = null;
		try {
			actual = pyramid.spaces(6, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testSpace7() {
		int n=9;
		String expected="  ";
		String actual = null;
		try {
			actual = pyramid.spaces(7, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testSpace8() {
		int n=9;
		String expected=" ";
		String actual = null;
		try {
			actual = pyramid.spaces(8, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}

	@Test
	public void testSpace9() {
		int n=9;
		String expected="";
		String actual = null;
		try {
			actual = pyramid.spaces(9, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace10() {
		int n=9;
		String expected=" ";
		String actual = null;
		try {
			actual = pyramid.spaces(10, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace11() {
		int n=9;
		String expected="  ";
		String actual = null;
		try {
			actual = pyramid.spaces(11, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace12() {
		int n=9;
		String expected="   ";
		String actual = null;
		try {
			actual = pyramid.spaces(12, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace13() {
		int n=9;
		String expected="    ";
		String actual = null;
		try {
			actual = pyramid.spaces(13, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace14() {
		int n=9;
		String expected="     ";
		String actual = null;
		try {
			actual = pyramid.spaces(14, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace15() {
		int n=9;
		String expected="      ";
		String actual = null;
		try {
			actual = pyramid.spaces(15, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace16() {
		int n=9;
		String expected="       ";
		String actual = null;
		try {
			actual = pyramid.spaces(16, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected,actual);
	}


	@Test
	public void testSpace17() {
		int n=9;
		String expected="        ";
		String actual = null;
		try {
			actual = pyramid.spaces(17, n);
		} catch (PatternException e) {
			 
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPyramidint1() {
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

}