import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BinarySearchTest {
	BinarySearch search;
	
	@Before
	public void testThis(){
		search = new BinarySearch();
	}

	@Test
	public void test() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77};
		int element = 88;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element, 0, inputArr.length));
	}
	
	@Test
	public void test1() {
		int[] inputArr = new int[] {2,5,8,9,10,55,77,88};
		int element = 77;
		boolean output = true;
		assertEquals(output, search.binarySearch(inputArr, element, 0, inputArr.length));
	}
	
	@Test
	public void test2() {
		int[] inputArr = new int[] {};
		int element = 77;
		boolean output = false;
		assertEquals(output, search.binarySearch(inputArr, element, 0, inputArr.length));
	}

}
