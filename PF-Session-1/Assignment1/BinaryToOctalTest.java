import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryToOctalTest {

	@Test
	public void test() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(64, binToOct.convertBinaryToOctal(110100));
	}
	
	@Test
	public void test1() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(0, binToOct.convertBinaryToOctal(000));
	}
	
	@Test
	public void test2() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(14, binToOct.convertBinaryToOctal(1100));
	}
	
	@Test
	public void test3() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(100, binToOct.convertBinaryToOctal(1000000));
	}
	
	@Test
	public void test4() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(54, binToOct.convertBinaryToOctal(101100));
	}
	
	@Test
	public void test5() {
		BinaryToOctal binToOct = new BinaryToOctal();
		assertEquals(76, binToOct.convertBinaryToOctal(111110));
	}

}
