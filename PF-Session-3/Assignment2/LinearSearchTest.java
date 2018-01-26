import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinearSearchTest {
	LinearSearch search;
	
	@Before
	public void testThis(){
		search = new LinearSearch();
	}

	@Test
	public void test() {
		int[] inputArr = new int[] {2,5,8,9,10,77,55};
		int element = 88;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, element, 0));
	}
	
	@Test
	public void test1() {
		int[] inputArr = new int[] {2,5,8,9,10, 77, 55};
		int element = 55;
		boolean output = true;
		assertEquals(output, search.linearSearch(inputArr, element, 0));
	}
	
	@Test
	public void test2() {
		int[] inputArr = new int[] {};
		int element = 77;
		boolean output = false;
		assertEquals(output, search.linearSearch(inputArr, element, inputArr.length));
	}

}
